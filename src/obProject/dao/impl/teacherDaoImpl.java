package obProject.dao.impl;

import  java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import obProject.util.JdbcConnection;
import java.sql.Connection;

import obProject.entity.*;
import obProject.dao.teacherDao;
public class teacherDaoImpl implements teacherDao {

    @Override
    public int insert_course(course c, course_time ct,lecture l) {
        String sql="insert into course value(?,?,?,?,?,?,?)";
        Object[] obj={c.getCid(),c.getDepartment_id(),c.getCredit(),c.getName(),c.getType(),c.getTarget_department_id(),l.getRid()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);


        String sql2="insert into course_time value(?,?,?)";
        Object[] obj2={ct.getCid(),ct.getWeekday(),ct.getSession()};
        int update2 =JdbcConnection.ExecuteUpdate(sql2,obj2);

        String sql3="insert into lecture value(?,?,?)";
        Object[] obj3={l.getTid(),l.getCid(),l.getApproval()};
        int update3 =JdbcConnection.ExecuteUpdate(sql3,obj3);

        return update & update2 & update3;
    }

    @Override
    public List<lecture> select_course(String tid) {
        Connection connect=JdbcConnection.getConnection();
        List<lecture> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where tid=?");
            pstm.setString(1,tid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String rid=rs.getString(1);
                String cid=rs.getString(2);
                String did=rs.getString(3);
                String tname=rs.getString(6);
                String approval=rs.getString(9);
                int credit=rs.getInt(10);
                String cname=rs.getString(11);
                String type=rs.getString(12);
                String target_department_id=rs.getString(13);
                int weekday=rs.getInt(14);
                int session=rs.getInt(15);
                String campus=rs.getString(16);
                String building=rs.getString(17);

                department d=select_a_department(did);
                department t_d=select_a_department(target_department_id);
                //step2 保存到对象
                lecture tc;
                if(t_d==null)
                    tc = new lecture  (tid,cid,d.getDepartment_name(),credit,cname,type,null,tname,approval,weekday,session,rid,campus,building);
                else
                    tc = new lecture  (tid,cid,d.getDepartment_name(),credit,cname,type,t_d.getDepartment_name(),tname,approval,weekday,session,rid,campus,building);

                //step3 将结果导入集合
                list.add(tc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<course_score> select_by_cid(String cid) {
        Connection connect=JdbcConnection.getConnection();
        List<course_score> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from select_course natural join course where cid=?");
            pstm.setString(1,cid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                int score=rs.getInt(3);
                String sid=rs.getString(4);
                String cname=rs.getString(6);
                int credit=rs.getInt(5);
                String type=rs.getString(7);
                //step2 保存到对象
                course_score tc = new course_score (cid,sid,cname,score,type,credit);

                //step3 将结果导入集合
                list.add(tc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public int update_grade(String cid, String sid, int grade) {
        String sql="update select_course set score=? where sid=? and cid=?";
        Object[] obj={grade,sid,cid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public List<remake_student> select_student_remake(String tid) {
        Connection connect=JdbcConnection.getConnection();
        List<remake_student> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from course natural join re_exam natural join lecture where tid=?");
            pstm.setString(1,tid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String cid=rs.getString(1);
                String cname=rs.getString(4);
                String sid=rs.getString(8);
                String isPass=rs.getString(9);

                //step2 保存到对象
                remake_student rst=new remake_student(sid,cid,cname,isPass);

                //step3 将结果导入集合
                list.add(rst);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public int update_remake(String cid, String sid, String if_pass) {
        String sql="update re_exam set if_pass=? where sid=? and cid=?";
        Object[] obj={if_pass,sid,cid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }
    public department select_a_department(String did) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        department dep=null;
        try
        {
            pstm= connect.prepareStatement("select * from department where department_id=? ");
            pstm.setString(1,did);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String department_id=rs.getString(1);
                String department=rs.getString(2);
                //step2 保存到对象
                dep = new department (department_id,department);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return dep;
    }


    @Override
    public int remake_pass(String sid,String cid) {
        String sql="update re_exam set is_pass='通过' where sid=? and cid=?";
        Object[] obj={sid,cid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }

    @Override
    public int remake_not_pass(String sid,String cid) {
        String sql="update re_exam set is_pass='不通过' where sid=? and cid=?";
        Object[] obj={sid,cid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }

    @Override
    public String select_password(String tid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        String pass=null;
        try
        {
            pstm= connect.prepareStatement("select password from teacher where tid=? ");
            pstm.setString(1,tid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                pass=rs.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return pass;
    }

    @Override
    public int revise_password(String tid,String password) {
        String sql="update teacher set password=? where tid=?";
        Object[] obj={password,tid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }
}

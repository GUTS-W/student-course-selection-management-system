package obProject.dao.impl;

import  java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import obProject.util.JdbcConnection;
import java.sql.Connection;

import obProject.entity.*;
import obProject.dao.studentDao;
public class studentDaoImpl implements studentDao {
    @Override
    public List<lecture> select_course(String sid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        int tag[]=new int [36];
        try
        {
            pstm= connect.prepareStatement("select * from student natural join course natural join select_course natural join course_time where sid=?");
            pstm.setString(1,sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                int weekday=Integer.parseInt(rs.getString(15));
                int session=Integer.parseInt(rs.getString(16));
                tag[weekday*5+session-5]=1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
             JdbcConnection.closeAll(connect,rs,pstm);
        }
        List<lecture> list=new ArrayList<>();
        connect=JdbcConnection.getConnection();
        rs=null;
        pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where approval=1 and target_department_id=?");
            pstm.setString(1,find_did(sid));
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String rid=rs.getString(1);
                String cid=rs.getString(2);
                String tid=rs.getString(4);
                String tname=rs.getString(6);
                String approval=rs.getString(9);
                int credit=rs.getInt(10);
                String cname=rs.getString(11);
                String type=rs.getString(12);
                String target_department_id=rs.getString(13);
                int weekday=Integer.parseInt(rs.getString(14));
                int session=Integer.parseInt(rs.getString(15));
                String campus=rs.getString(16);
                String building=rs.getString(17);

                department d=select_a_department(find_did(sid));
                department t_d=select_a_department(target_department_id);

                //step2 保存到对象
                if(tag[weekday*5+session-5]==1)
                {
                    lecture tc = new lecture(tid,cid,d.getDepartment_name(),credit,cname,type,t_d.getDepartment_name(),tname,approval,weekday,session,rid,campus,building);
                    //step3 将结果导入集合
                    list.add(tc);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<remake_student> select_course_remake(String sid) {
        List<remake_student> list=new ArrayList<>();
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from course natural join re_exam where sid=?");
            pstm.setString(1,sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String cid=rs.getString(1);
                String cname=rs.getString(4);
                String is_pass=rs.getString(9);

                //step2 保存到对象
                remake_student rs1 = new remake_student(sid,cid,cname,is_pass);
                    //step3 将结果导入集合
                    list.add(rs1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<lecture> select_ALL_course(String sid) {
        Connection connect=JdbcConnection.getConnection();
        List<lecture> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where approval='通过' and (target_department_id=? or target_department_id is null or target_department_id='')");
            pstm.setString(1,find_did(sid));
            //logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            //logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String rid=rs.getString(1);
                String cid=rs.getString(2);
                String did=rs.getString(3);
                String tid=rs.getString(4);
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
    public lecture select_a_course(String cname,String did) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        int tag[]=new int [36];
        try
        {
            pstm= connect.prepareStatement("select * from student natural join course natural join select_course natural join course_time");
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                int weekday=Integer.parseInt(rs.getString(15));
                int session=Integer.parseInt(rs.getString(16));
                tag[weekday*5+session-5]=1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        connect=JdbcConnection.getConnection();
        rs=null;
        pstm=null;
        lecture tc=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where approval=1 and c_name=? and target_department_id=?");
            pstm.setString(1,cname);
            pstm.setString(2,did);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String rid=rs.getString(1);
                String cid=rs.getString(2);
                String tid=rs.getString(4);
                String tname=rs.getString(6);
                String approval=rs.getString(9);
                int credit=rs.getInt(10);
                String type=rs.getString(12);
                String target_department_id=rs.getString(13);
                int weekday=Integer.parseInt(rs.getString(14));
                int session=Integer.parseInt(rs.getString(15));
                String campus=rs.getString(16);
                String building=rs.getString(17);

                department d=select_a_department(did);
                department t_d=select_a_department(target_department_id);
                if(tag[weekday*5+session-5]==1)
                {
                    tc = new lecture(tid,cid,d.getDepartment_name(),credit,cname,type,t_d.getDepartment_name(),tname,approval,weekday,session,rid,campus,building);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return tc;
    }

    @Override
    public List<lecture> select_courses_by_type(String type) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        int tag[]=new int [36];
        try
        {
            pstm= connect.prepareStatement("select * from student natural join course natural join select_course natural join course_time");
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                int weekday=Integer.parseInt(rs.getString(15));
                int session=Integer.parseInt(rs.getString(16));
                tag[weekday*5+session-5]=1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        List<lecture> list=new ArrayList<>();
        connect=JdbcConnection.getConnection();
        rs=null;
        pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where approval=1 and type=?");
            pstm.setString(1,type);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String rid=rs.getString(1);
                String cid=rs.getString(2);
                String did=rs.getString(3);
                String tid=rs.getString(4);
                String tname=rs.getString(6);
                String approval=rs.getString(9);
                int credit=rs.getInt(10);
                String cname=rs.getString(11);
                String target_department_id=rs.getString(13);
                int weekday=Integer.parseInt(rs.getString(14));
                int session=Integer.parseInt(rs.getString(15));
                String campus=rs.getString(16);
                String building=rs.getString(17);

                department d=select_a_department(did);
                department t_d=select_a_department(target_department_id);
                if(tag[weekday*5+session-5]==1)
                {
                    lecture tc = new lecture(tid,cid,d.getDepartment_name(),credit,cname,type,t_d.getDepartment_name(),tname,approval,weekday,session,rid,campus,building);
                    //step3 将结果导入集合
                    list.add(tc);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<lecture> select_courses_chose(String sid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        List<lecture> list=new ArrayList<>();
        try
        {
            //pstm= connect.prepareStatement("select * from course natural join select_course natural join course_time natural join classroom where sid=?");
            pstm= connect.prepareStatement("select * from course natural join select_course natural join course_time natural join classroom natural join lecture natural join teacher where sid=?");
            pstm.setString(1,sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String rid=rs.getString(4);
                String cid=rs.getString(3);
                String did=rs.getString(1);
                int credit=rs.getInt(5);
                String cname=rs.getString(6);
                String type=rs.getString(7);
                String target_department_id=rs.getString(8);
                int weekday=rs.getInt(11);
                int session=rs.getInt(12);
                String campus=rs.getString(13);
                String building=rs.getString(14);
                String tname=rs.getString(17);

                department d=select_a_department(did);
                department t_d=select_a_department(target_department_id);
                lecture tc;
                if(t_d!=null)
                    tc = new lecture(null,cid,d.getDepartment_name(),credit,cname,type,t_d.getDepartment_name(),tname,null,weekday,session,rid,campus,building);
                else
                    tc = new lecture(null,cid,d.getDepartment_name(),credit,cname,type,null,tname,null,weekday,session,rid,campus,building);

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
    public int delete_course_chosen(String sid, String cid) {
        String sql="delete from select_course where cid=? and sid=?";
        Object[] obj={cid,sid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int insert_course(String sid,String cid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        int k=0;
        int tag[]=new int [36];
        try
        {
            pstm= connect.prepareStatement("select * from student natural join course natural join select_course natural join course_time where sid=?");
            pstm.setString(1,sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                int weekday=Integer.parseInt(rs.getString(15));
                int session=Integer.parseInt(rs.getString(16));
                tag[weekday*5+session-5]=1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        int update=0;
        if(tag[select_course_by_cid(cid)]!=1) {
            String sql="insert into select_course value(?,?,?)";
            Object[] obj = {sid, cid, null};
            update = JdbcConnection.ExecuteUpdate(sql, obj);
        }
        return update;
    }

    @Override
    public List<reward_punishshment> select_all_rp(String sid) {
        Connection connect=JdbcConnection.getConnection();
        List<reward_punishshment> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from reward_punishment where sid=?");
            pstm.setString(1,sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String level=rs.getString(2);
                String type=rs.getString(3);
                String name=rs.getString(4);
                String is_pass=rs.getString(5);
                //step2 保存到对象
                reward_punishshment tc = new reward_punishshment (sid,level,type,name,is_pass);

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
    public int insert_reward(reward_punishshment r) {
        String sql="insert into reward_punishment value(?,?,?,?,?)";
        Object[] obj={r.getSid(),r.getLevel(),r.getType(),r.getName(),r.getIs_pass()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public List<course_score> select_score(String sid) {
        Connection connect=JdbcConnection.getConnection();
        List<course_score> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from select_course natural join course where sid=?");
            pstm.setString(1,sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                String cid=rs.getString(1);
                int score=rs.getInt(3);
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
    public gpa alu_gpa(List<course_score> c_g) {
        float credit=0;
        float gpa=0;

        for(int i=0;i<c_g.size();i++)
        {
            if(c_g.get(i).getScore()!=0 && c_g.get(i).getType().equals("必修"))
            //此处使用中文会出问题故先删除对于课程类型的判断
            {
                gpa = (gpa * credit + c_g.get(i).getScore() * c_g.get(i).getCredit()) / (credit + c_g.get(i).getCredit());
                credit = credit + c_g.get(i).getCredit();
            }
        }
        return new gpa(gpa,credit);
    }

    @Override
    public int insert_remake(String sid, String cid) {
        //验证成绩是否不合格
        if(select_a_score(sid,cid)>=60)
            return 0;

        String sql="insert into re_exam value(?,?,?)";
        Object[] obj={sid,cid,"提交申请"};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int select_a_score(String sid, String cid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        int score=0;
        try
        {
            pstm= connect.prepareStatement("select * from select_course natural join course where sid=? and cid=?");
            pstm.setString(1,sid);
            pstm.setString(2,cid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                score=rs.getInt(3);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return score;
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
    public int select_course_by_cid(String cid) {
        Connection connect=JdbcConnection.getConnection();
        List<lecture> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        int t=0;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time where cid=?");
            pstm.setString(1,cid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int weekday=rs.getInt(14);
                int session=rs.getInt(15);
                t=weekday*5+session-5;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return t;
    }

    @Override
    public String find_did(String sid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        String did=null;
        try
        {
            pstm= connect.prepareStatement("select * from student natural join institution where sid=? ");
            pstm.setString(1,sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //step1 取数据
                did=rs.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return did;
    }

    @Override
    public lecture select_a_course_by_cid(String cid)
    {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        lecture tc=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where cid=?");
            pstm.setString(1,cid);
 //           logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
 //           logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String rid=rs.getString(1);
                String did=rs.getString(3);
                String tid=rs.getString(4);
                String tname=rs.getString(6);
                String approval=rs.getString(9);
                int credit=rs.getInt(10);
                String cname=rs.getString(11);
                String type=rs.getString(12);
                String target_department_id=rs.getString(13);
                int weekday=Integer.parseInt(rs.getString(14));
                int session=Integer.parseInt(rs.getString(15));
                String campus=rs.getString(16);
                String building=rs.getString(17);

                department d=select_a_department(did);
                department t_d=select_a_department(target_department_id);
                //step2 保存到对象
                if(t_d==null)
                    tc = new lecture  (tid,cid,d.getDepartment_name(),credit,cname,type,null,tname,approval,weekday,session,rid,campus,building);
                else
                    tc = new lecture  (tid,cid,d.getDepartment_name(),credit,cname,type,t_d.getDepartment_name(),tname,approval,weekday,session,rid,campus,building);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return tc;
    }

    @Override
    public String select_password(String sid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        String pass=null;
        try
        {
            pstm= connect.prepareStatement("select password from student where sid=? ");
            pstm.setString(1,sid);
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
    public int revise_password(String sid,String password) {
        String sql="update student set password=? where sid=?";
        Object[] obj={password,sid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }
}
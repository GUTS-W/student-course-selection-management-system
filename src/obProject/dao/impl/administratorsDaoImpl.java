package obProject.dao.impl;

import  java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import obProject.entity.student;
import obProject.util.JdbcConnection;
import java.sql.Connection;

import obProject.entity.*;
import obProject.dao.administratorDao;
import obProject.util.Log;
import org.apache.log4j.Logger;

public class administratorsDaoImpl implements administratorDao {
    Logger logger=Log.getLogger();

    @Override
    public List<department> select_ALL_department() {
        Connection connect=JdbcConnection.getConnection();
        List<department> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from department ");
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String department_id=rs.getString(1);
                String department=rs.getString(2);


                //step2 保存到对象
                department dep = new department (department_id,department);

                //step3 将结果导入集合
                list.add(dep);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public department select_a_department(String did) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        department dep=null;
        try
        {
            pstm= connect.prepareStatement("select * from department where department_id=? ");
            pstm.setString(1,did);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
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
    public department select_a_department_by_name(String dname) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        department dep=null;
        try
        {
            pstm= connect.prepareStatement("select * from department where department=? ");
            pstm.setString(1,dname);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
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
    public int insert_department(department d) {
        String sql="insert into department values(?,?)";
        Object[] obj={d.getDepartment_id(),d.getDepartment_name()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int update_department(String department_before,String department_after) {
        String sql="update department set department=? where department=?";
        Object[] obj={department_after,department_before};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int delete_department(String department_name) {
        String sql="delete from department where department=?";
        Object[] obj={department_name};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public String get_major_id(String department_name,String major_name) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        String major_id=null;
        try
        {
            pstm= connect.prepareStatement("select mid from department natural join department_major where department=? and major=? ");
            pstm.setString(1,department_name);
            pstm.setString(2,major_name);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            if (rs.next()) {
                major_id=rs.getString(1);
                logger.debug("major_id is "+major_id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return major_id;
    }


    @Override
    public List<information_of_department_and_major> select_information_department_and_mojor(String department_name) {
        Connection connect=JdbcConnection.getConnection();
        List<information_of_department_and_major> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from department join department_major on department.department_id=department_major.department_id where department=?");
            pstm.setString(1,department_name);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String department=rs.getString(2);
                String major=rs.getString(5);

                //step2 保存到对象
                information_of_department_and_major iform = new information_of_department_and_major (department,major);

                //step3 将结果导入集合
                list.add(iform);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public int insert_major(department_major m) {
        String sql="insert into department_major values(?,?,?)";
        Object[] obj={m.getMid(),m.getDepartment_id(),m.getMajor()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }

    @Override
    public int update_major(String mid,String oldName, String newName) {
        String sql="update department_major set major=? where major=? and department_id=?";
        Object[] obj={newName,oldName,mid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int delete_major(String mname,String did) {
        String sql="delete from department_major where major=? and department_id=?";
        Object[] obj={mname,did};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public List<student_information> select_ALL_student() {
        Connection connect=JdbcConnection.getConnection();
        List<student_information> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from student natural join institution natural join department_major natural join department");
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String sid=rs.getString(3);
                String id=rs.getString(4);
                Date birthday=rs.getDate(5);
                String name=rs.getString(6);
                String sex=rs.getString(7);
                String campus=rs.getString(9);
                String grade=rs.getString(10);
                String class_1=rs.getString(11);
                String major=rs.getString(12);
                String department=rs.getString(13);

                //step2 保存到对象
                student_information stu = new student_information (sid,id,birthday,name,sex,department,major,campus,grade,class_1);

                //step3 将结果导入集合
                list.add(stu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<student_information> select_byname_student(String sname) {
        Connection connect=JdbcConnection.getConnection();
        List<student_information> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        student_information s=null;
        try
        {
            pstm= connect.prepareStatement("select * from student natural join institution natural join department_major natural join department where name=?");
            pstm.setString(1,sname);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String sid=rs.getString(3);
                String id=rs.getString(4);
                Date birthday=rs.getDate(5);
                String name=rs.getString(6);
                String sex=rs.getString(7);
                String campus=rs.getString(9);
                String grade=rs.getString(10);
                String class_1=rs.getString(11);
                String major=rs.getString(12);
                String department=rs.getString(13);

                //step2 保存到对象
                student_information stu = new student_information (sid,id,birthday,name,sex,department,major,campus,grade,class_1);

                //step3 将结果导入集合
                list.add(stu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<student_information> select_bydept_student(String deptm) {
        Connection connect=JdbcConnection.getConnection();
        List<student_information> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        student_information s=null;
        try
        {
            pstm= connect.prepareStatement("select * from student natural join institution natural join department_major natural join department where department=?");
            pstm.setString(1,deptm);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String sid=rs.getString(3);
                String id=rs.getString(4);
                Date birthday=rs.getDate(5);
                String name=rs.getString(6);
                String sex=rs.getString(7);
                String campus=rs.getString(9);
                String grade=rs.getString(10);
                String class_1=rs.getString(11);
                String major=rs.getString(12);
                String department=rs.getString(13);

                //step2 保存到对象
                student_information stu = new student_information (sid,id,birthday,name,sex,department,major,campus,grade,class_1);

                //step3 将结果导入集合
                list.add(stu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<student_information> select_bymajor_student(String mjr) {
        Connection connect=JdbcConnection.getConnection();
        List<student_information> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        student_information s=null;
        try
        {
            pstm= connect.prepareStatement("select * from student natural join institution natural join department_major natural join department where major=?");
            pstm.setString(1,mjr);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String sid=rs.getString(3);
                String id=rs.getString(4);
                Date birthday=rs.getDate(5);
                String name=rs.getString(6);
                String sex=rs.getString(7);
                String campus=rs.getString(9);
                String grade=rs.getString(10);
                String class_1=rs.getString(11);
                String major=rs.getString(12);
                String department=rs.getString(13);

                //step2 保存到对象
                student_information stu = new student_information (sid,id,birthday,name,sex,department,major,campus,grade,class_1);

                //step3 将结果导入集合
                list.add(stu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public student_information select_a_studnet(String sid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        student_information stu=null;
        try
        {
            pstm= connect.prepareStatement("select * from student natural join institution natural join department_major natural join department where sid=?");
            pstm.setString(1,sid);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String id=rs.getString(4);
                Date birthday=rs.getDate(5);
                String name=rs.getString(6);
                String sex=rs.getString(7);
                String campus=rs.getString(9);
                String grade=rs.getString(10);
                String class_1=rs.getString(11);
                String major=rs.getString(12);
                String department=rs.getString(13);

                //step2 保存到对象
                stu = new student_information (sid,id,birthday,name,sex,department,major,campus,grade,class_1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return stu;
    }

    @Override
    public teacher select_a_teacher(String tid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        teacher tea=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join department where tid=?");
            pstm.setString(1,tid);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                int age=rs.getInt(3);
                String name=rs.getString(4);
                String sex=rs.getString(6);
                String department=rs.getString(7);
                String department_id=rs.getString(1);
                String password=rs.getString(5);

                //step2 保存到对象
                tea = new teacher (tid,department_id,age,name,password,sex,department);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return tea;
    }

    @Override
    public List<teacher> select_byname_teacher(String name) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        List<teacher> list=new ArrayList<>();
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join department where t_name=?");
            pstm.setString(1,name);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                int age=rs.getInt(3);
                String tid=rs.getString(2);
                String sex=rs.getString(6);
                String department=rs.getString(7);
                String department_id=rs.getString(1);
                String password=rs.getString(5);

                //step2 保存到对象
                teacher tea = new teacher (tid,department_id,age,name,password,sex,department);
                list.add(tea);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public List<teacher> select_bydepartment_teacher(String department) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        List<teacher> list=new ArrayList<>();
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join department where department=?");
            pstm.setString(1,department);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                int age=rs.getInt(3);
                String tid=rs.getString(2);
                String sex=rs.getString(6);
                String name=rs.getString(4);
                String department_id=rs.getString(1);
                String password=rs.getString(5);

                //step2 保存到对象
                teacher tea = new teacher (tid,department_id,age,name,password,sex,department);
                list.add(tea);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return list;
    }

    @Override
    public int delete_institution(String sid) {
        String sql="delete from institution where sid=?";
        Object[] obj={sid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int insert_student(student s,institution s_i) {
        String sql="insert into student values(?,?,?,?,?,?)";
        Object[] obj={s.getSid(),s.getId(),s.getBirthday(),s.getName(),s.getSex(),s.getPassword()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        String sql1="insert into institution values(?,?,?,?,?) ";
        Object[] obj1={s_i.getCampus(),s_i.getMID(),s_i.getGrade(),s_i.getClass_1(),s_i.getSid()};
        int update2 =JdbcConnection.ExecuteUpdate(sql1,obj1);
        return update & update2;
    }

    @Override
    public int update_student_basic(student s) {
        String sql="update student set id=?,birthday=?,name=?,sex=? where sid=?";
        Object[] obj={s.getId(),s.getBirthday(),s.getName(),s.getSex(),s.getSid()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int update_student_insititution(institution s_i) {
        String sql="update institution set campus=?,mid=?,grade=?,class=? where sid=?";
        Object[] obj={s_i.getCampus(),s_i.getMID(),s_i.getGrade(),s_i.getClass_1(),s_i.getSid()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int delete_student(String sid) {
        String sql="delete from student where sid=?";
        Object[] obj={sid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        String sql2="delete from institution where sid=?";
        Object[] obj2={sid};
        int update2 =JdbcConnection.ExecuteUpdate(sql2,obj2);

        return update ;//& update2;
    }

    @Override
    public int course_pass(String cid) {
        String sql="update lecture set approval='通过' where cid=?";
        Object[] obj={cid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }

    @Override
    public int course_not_pass(String cid) {
        String sql="update lecture set approval='不通过' where cid=?";
        Object[] obj={cid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }

    @Override
    public List<lecture> select_ALL_course() {
        Connection connect=JdbcConnection.getConnection();
        List<lecture> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom");
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
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
    public List<lecture> select_wait_course(String d_id) {
        Connection connect=JdbcConnection.getConnection();
        List<lecture> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where approval='待审核' and department_id=?");
            pstm.setString(1,d_id);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
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
    public lecture select_a_course(String cname)
    {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        lecture tc=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where c_name=?");
            pstm.setString(1,cname);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String rid=rs.getString(1);
                String cid=rs.getString(2);
                String did=rs.getString(3);
                String tid=rs.getString(4);
                String tname=rs.getString(6);
                String approval=rs.getString(9);
                int credit=rs.getInt(10);
                String type=rs.getString(12);
                String target_department_id=rs.getString(13);
                int weekday=rs.getInt(14);
                int session=rs.getInt(15);
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
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
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
                int weekday=rs.getInt(14);
                int session=rs.getInt(15);
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
    public List<lecture> select_courses_by_type(String type) {
        Connection connect=JdbcConnection.getConnection();
        List<lecture> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join lecture natural join course natural join course_time natural join classroom where type=?");
            pstm.setString(1,type);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
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
    public int insert_course(course c,course_time ct,lecture l) {
        String sql="insert into course value(?,?,?,?,?,?,?)";
        Object[] obj={c.getCid(),c.getDepartment_id(),c.getCredit(),c.getName(),c.getType(),c.getTarget_department_id(),l.getRid()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);


        String sql2="insert into course_time value(?,?,?)";
        Object[] obj2={ct.getCid(),ct.getWeekday(),ct.getSession()};
        int update2 =JdbcConnection.ExecuteUpdate(sql2,obj2);

        String sql3="insert into lecture value(?,?,?)";
        Object[] obj3={l.getTid(),l.getCid(),l.getApproval()};
        int update3 =JdbcConnection.ExecuteUpdate(sql3,obj3);

        return update & update2;
    }

    @Override
    public int update_course(course c,course_time ct,lecture l) {
        String sql="update course set department_id=?,credit=?,c_name=?,type=?,target_department_id=?,rid=? where cid=?";
        Object[] obj={c.getDepartment_id(),c.getCredit(),c.getName(),c.getType(),c.getTarget_department_id(),l.getRid(),c.getCid()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        String sql2="update course_time set weekday=?,section=? where cid=?";
        Object[] obj2={ct.getWeekday(),ct.getSession(),ct.getCid()};
        int update2 =JdbcConnection.ExecuteUpdate(sql2,obj2);

        return update & update2;
    }



    @Override
    public int delete_course(String cid) {
        String sql="delete from course where cid=?";
        Object[] obj={cid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        String sql1="delete from lecture where cid=?";
        Object[] obj1={cid};
        int update1 =JdbcConnection.ExecuteUpdate(sql1,obj1);

        String sql2="delete from course_time where cid=?";
        Object[] obj2={cid};
        int update2 =JdbcConnection.ExecuteUpdate(sql2,obj2);

        if(update==1 && update1==1 && update2==1)
            return 1;
        else
            return 0;
    }

    @Override
    public List<teacher> select_ALL_teacher() {
        Connection connect=JdbcConnection.getConnection();
        List<teacher> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from teacher natural join department");
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String tid=rs.getString(2);
                String department_id=rs.getString(1);
                int age=rs.getInt(3);
                String name=rs.getString(4);
                String password=rs.getString(5);
                String sex=rs.getString(6);
                String department=rs.getString(7);

                //step2 保存到对象
                teacher tc = new teacher (tid,department_id,age,name,password,sex,department);

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
    public int insert_teacher(teacher t) {
        String sql="insert into teacher value(?,?,?,?,?,?)";
        Object[] obj={t.getTid(),t.getDepartment_id(),t.getAge(),t.getName(),t.getPassword(),t.getSex()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int update_teacher(obProject.entity.teacher t) {
        String sql="update teacher set department_id=?,age=?,t_name=?,password=?,sex=? where tid=?";
        Object[] obj={t.getDepartment_id(),t.getAge(),t.getName(),t.getPassword(),t.getSex(),t.getTid()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int delete_teacher(String tid) {
        String sql="delete from teacher where tid=?";
        Object[] obj={tid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        String sql2="delete from lecture where tid=?";
        Object[] obj2={tid};
        int update2 =JdbcConnection.ExecuteUpdate(sql2,obj2);

        return update;
    }

    @Override
    public List<reward_punishshment> select_all_rp() {
        Connection connect=JdbcConnection.getConnection();
        List<reward_punishshment> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from reward_punishment");
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String sid=rs.getString(1);
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
    public List<reward_punishshment> select_wait_rp() {
        Connection connect=JdbcConnection.getConnection();
        List<reward_punishshment> list=new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try
        {
            pstm= connect.prepareStatement("select * from reward_punishment where is_pass='待审核'");
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                String sid=rs.getString(1);
                String level=rs.getString(2);
                String type=rs.getString(3);
                String name=rs.getString(4);
                //step2 保存到对象
                reward_punishshment tc = new reward_punishshment (sid,level,type,name,"待审批");

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
    public int rp_pass(String sid,String level,String name,String type) {
        String sql="update reward_punishment set is_pass='通过' where sid=? and level=? and name=? and type=?";
        Object[] obj={sid,level,name,type};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }

    @Override
    public int rp_not_pass(String sid,String level,String name,String type) {
        String sql="update reward_punishment set is_pass='不通过' where sid=? and level=? and name=? and type=?";
        Object[] obj={sid,level,name,type};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }

    @Override
    public int insert_rp(reward_punishshment rp) {
        String sql="insert into reward_punishment value(?,?,?,?,?)";
        Object[] obj={rp.getSid(),rp.getLevel(),rp.getType(),rp.getName(),rp.getIs_pass()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public int delete_rp(reward_punishshment rp) {
        String sql="delete from reward_punishshment where sid=? and level=? and name=? and type=?";
        Object[] obj={rp.getSid(),rp.getLevel(),rp.getName(),rp.getType()};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);
        return update;
    }

    @Override
    public String select_rid(String c, String b) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        String rid=null;
        try
        {
            pstm= connect.prepareStatement("select * from classroom where campus=? and building=?");
            pstm.setString(1,c);
            pstm.setString(2,b);
            logger.debug("stmt创建成功"+pstm);
            rs = pstm.executeQuery();
            logger.debug("sql执行成功");
            while (rs.next()) {
                //step1 取数据
                rid=rs.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcConnection.closeAll(connect,rs,pstm);
        }
        return rid;
    }

    @Override
    public String select_password(String aid) {
        Connection connect=JdbcConnection.getConnection();
        ResultSet rs=null;
        PreparedStatement pstm=null;
        String pass=null;
        try
        {
            pstm= connect.prepareStatement("select password from administrators where aid=? ");
            pstm.setString(1,aid);
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
    public int revise_password(String aid,String password) {
        String sql="update administrators set password=? where aid=?";
        Object[] obj={password,aid};
        int update =JdbcConnection.ExecuteUpdate(sql,obj);

        return update;
    }


}
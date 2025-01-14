package obProject.dao;

import obProject.entity.*;

import java.util.List;

public interface teacherDao {
    //插入课程信息     insert into course value(?,?,?,?,?,?)    insert into course_time value(?,?,?)
    int insert_course(course c,course_time ct,lecture l);
    //查询所有教授课程
    List<lecture> select_course(String tid);
    List<course_score> select_by_cid(String cid);
    //录入成绩
    int update_grade(String cid,String sid,int grade);
    //补考的学生查询
    List<remake_student> select_student_remake(String tid);
    //补考的成绩录入
    int update_remake(String cid,String sid,String if_pass);
    public department select_a_department(String did);
    int remake_pass(String sid,String cid);
    int remake_not_pass(String sid,String cid);

    String select_password(String tid);
    int revise_password(String tid,String password);
}

package obProject.dao;

import java.util.List;

import obProject.entity.*;
public interface studentDao {
    //查询所有可选的课程
    List<lecture> select_course(String did);
    List<remake_student> select_course_remake(String sid);

    List<lecture> select_ALL_course(String sid);

    //根据课名查找课程
    lecture select_a_course(String cname,String did);
    //查询类型的课程
    List<lecture> select_courses_by_type(String type);
    //查询已选择课程
    List<lecture> select_courses_chose(String sid);

    public lecture select_a_course_by_cid(String cid);
    //删除已选课程  delete from select_course where sid=? and cid=?
    int delete_course_chosen(String sid,String cid);

    //选择课程    视为添加课程   insert into select_course value(?,?,?)
    int insert_course(String sid,String cid);

    //查询奖惩情况
    List<reward_punishshment> select_all_rp(String sid);
    //申请奖励视为insert    insert into reward_punishment value(?,?,?,?,?)
    int insert_reward(reward_punishshment r);
    //查询课程分数
    List<course_score> select_score(String sid);
    //学分与绩点计算
    gpa alu_gpa(List<course_score> c_g);

    //学生补考申请
    int insert_remake(String sid,String cid);

    int select_a_score(String sid,String cid);

    public department select_a_department(String did);

    int select_course_by_cid(String cid);

    String find_did(String sid);

    String select_password(String sid);

    int revise_password(String sid,String password);

}

package obProject.dao;

import java.util.List;

import obProject.entity.*;


//在test文件中直接使用多态从而使用子类即可
public interface administratorDao {
    //1.查询的返回值不是对象就是集合 2.增删查改的返回值都是int

    //查询所有学院   select * from department
    List<department> select_ALL_department();
    //查询单个学院  select * from department where department_id=?   返回值是对象
    department select_a_department(String did);
    department select_a_department_by_name(String dname);
    //增加学院数量   insert into department values(?,?)

    int insert_department(department d);
    //修改学院的操作   update department set department=? where department_id=?
    int update_department(String department_before,String department_after);
    //删除学院的操作    delete from department where department_name=?
    int delete_department(String department_name);


    //查询某学院专业信息     select * from department join major on department.department_id=major.department_id
    List<information_of_department_and_major> select_information_department_and_mojor(String department_name);

    //增加专业数量     insert into department_major values(?,?,?)
    int insert_major(department_major m);
    //修改专业数据     update department set major=? where mid=? and department_id=?
    int update_major(String mid,String oldName, String newName);
    //删除专业操作
    int delete_major(String mname,String dname);
    String get_major_id(String department_name,String major_name);

    //查询所有学生信息   select * from student natural join institution natural join department_major natural join department
    List<student_information> select_ALL_student();

    //根据名字查询学生
    List<student_information> select_byname_student(String sname);
    //根据学院查询
    List<student_information> select_bydept_student(String deptm);
    //根据专业查询
    List<student_information> select_bymajor_student(String mjr);
    //查询一个学生信息  select * from student natural join institution natural join department_major natural join department where sid=?
    student_information select_a_studnet(String sid);
    //增加学生信息   insert into student values(?,?,?,?,?,?)   insert into institution values(?,?,?,?,?,?)
    teacher select_a_teacher(String tid);
    int delete_institution(String sid);
    int insert_student(student s,institution s_i);
    //修改学生基本信息   update department set id=?,birthday=?,name=?,password=?,sex=? where sid=?
    int update_student_basic(student s);
    //修改学生单位信息   update department set campus=?,mid=?,grade=?,class_1=? where sid=?
    int update_student_insititution(institution s_i);
    //删除学生信息   delete from student where sid=?  delete from institution where sid=?
    int delete_student(String sid);

    //查询所有课程信息并审批  select * from (teacher join lecture on TID) join course on CID
    //查询所有课程信息
    List<lecture> select_ALL_course();

    int course_pass(String cid);

    int course_not_pass(String cid);

    //查找未审批的课程
    List<lecture> select_wait_course(String d_id);
    //查询单个课程的信息
    lecture select_a_course(String cname);

    public lecture select_a_course_by_cid(String cid);
    //查询类型的课程
    List<lecture> select_courses_by_type(String type);
    //插入课程信息     insert into course value(?,?,?,?,?,?)    insert into course_time value(?,?,?)
    int insert_course(course c,course_time ct,lecture l);
    //修改课程信息     update course set department_id=?,credit=?,name=?,type=?,target_department_id=? where cid=?
    //update course_time set weekday=?,session=? where cid=?
    int update_course(course c,course_time ct,lecture l);
    //删除课程信息
    int delete_course(String cname);

    //查询老师的所有信息 select * from teacher
    List<teacher> select_ALL_teacher();
    List<teacher> select_byname_teacher(String name);
    List<teacher> select_bydepartment_teacher(String department);
    //添加教师信息 insert into teacher value(?,?,?,?,?,?)   返回值：int
    int insert_teacher(teacher t);
    //修改教师信息 update teacher set department_id=?,age=?,name=?,password=?,sex=? where tid=?
    int update_teacher(teacher t);
    //删除教师信息  delete from teacher where tid=?    delete from lecture where tid=?
    int delete_teacher(String tid);
    //查询奖惩情况
    List<reward_punishshment> select_all_rp();

    List<reward_punishshment> select_wait_rp();
    int rp_pass(String sid,String level,String name,String type);
    int rp_not_pass(String sid,String level,String name,String type);
    //增加奖惩情况
    int insert_rp(reward_punishshment rp);
    //删除奖惩情况
    int delete_rp(reward_punishshment rp);
    String select_rid(String c, String b);
    String select_password(String aid);
    int revise_password(String aid,String password);
}
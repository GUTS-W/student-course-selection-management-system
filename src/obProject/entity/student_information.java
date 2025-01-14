package obProject.entity;
//这是一个应用类
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Date;

public class student_information {
    private String sid;
    private String id;
    private Date birthday;
    private String name;
    private String sex;
    private String department;
    private String major;
    private String campus;
    private String grade;
    private String class_1;

    public student_information(String sid, String id, Date birthday, String name, String sex, String department, String major, String campus, String grade, String class_1) {
        this.sid = sid;
        this.id = id;
        this.birthday = birthday;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.major = major;
        this.campus = campus;
        this.grade = grade;
        this.class_1 = class_1;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClass_1() {
        return class_1;
    }

    public void setClass_1(String class_1) {
        this.class_1 = class_1;
    }
    public void WriteARow(Sheet sheet, int theRow){
        Row row=sheet.createRow(theRow);
        row.createCell(0).setCellValue(this.sid);
        row.createCell(1).setCellValue(this.name);
        row.createCell(2).setCellValue(this.campus);
        row.createCell(3).setCellValue(this.department);
        row.createCell(4).setCellValue(this.major);
        row.createCell(5).setCellValue(this.birthday);
        row.createCell(6).setCellValue(this.sex);
        row.createCell(7).setCellValue(this.grade);
        row.createCell(8).setCellValue(this.class_1);
        row.createCell(9).setCellValue(this.id);
    }

    static public void WriteTitle(Sheet sheet){
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("学号");
        headerRow.createCell(1).setCellValue("姓名");
        headerRow.createCell(2).setCellValue("校区");
        headerRow.createCell(3).setCellValue("学院");
        headerRow.createCell(4).setCellValue("专业");
        headerRow.createCell(5).setCellValue("生日");
        headerRow.createCell(6).setCellValue("性别");
        headerRow.createCell(7).setCellValue("年级");
        headerRow.createCell(8).setCellValue("班级");
        headerRow.createCell(9).setCellValue("身份证号");
    }
}

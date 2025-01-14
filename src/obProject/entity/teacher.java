package obProject.entity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class teacher {
    private String tid;
    private String department_id;
    private int age;
    private String name;
    private String password;
    private String sex;
    private String department;

    public teacher(String tid, String department_id, int age, String name, String password, String sex, String department) {
        this.tid = tid;
        this.department_id = department_id;
        this.age = age;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.department=department;
    }
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void WriteARow(Sheet sheet, int theRow){
        Row row=sheet.createRow(theRow);
        row.createCell(0).setCellValue(this.tid);
        row.createCell(1).setCellValue(this.name);
        row.createCell(2).setCellValue(this.age);
        row.createCell(3).setCellValue(this.department);
        row.createCell(4).setCellValue(this.sex);
    }

    static public void WriteTitle(Sheet sheet){
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("姓名");
        headerRow.createCell(2).setCellValue("年龄");
        headerRow.createCell(3).setCellValue("学院");
        headerRow.createCell(4).setCellValue("性别");
    }
}

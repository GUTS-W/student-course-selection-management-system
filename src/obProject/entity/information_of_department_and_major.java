package obProject.entity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.Field;

//这是一张应用表
public class information_of_department_and_major {
    private String department;
    private String major;

    public information_of_department_and_major(String department, String major) {
        this.department = department;
        this.major = major;
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

    public void WriteARow(Sheet sheet, int theRow){
        Row row=sheet.createRow(theRow);
        row.createCell(0).setCellValue(this.department);
        row.createCell(1).setCellValue(this.major);
    }

    static public void WriteTitle(Sheet sheet){
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("学院名称");
        headerRow.createCell(1).setCellValue("专业名称");
    }
}

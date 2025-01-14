package obProject.util;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
/*
Admin_teacher_Panel保留了使用方法
 */

public class ExcelWriter {
    static public Workbook openWorkBook(){
        Workbook workbook=new XSSFWorkbook();
        return workbook;
    }
    static public Sheet openSheet(Workbook workbook){
        Sheet sheet=workbook.createSheet("sheet1");
        return sheet;
    }
    static public void fileOut(Workbook workbook,String path){
        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

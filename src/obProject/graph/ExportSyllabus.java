package obProject.graph;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import obProject.dao.impl.studentDaoImpl;
import obProject.entity.lecture;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExportSyllabus extends JFrame{
    private JTable table;
    studentDaoImpl stu=new studentDaoImpl();
    public ExportSyllabus(String sid) {
        super("课表查看及导出");
        List<lecture> l=stu.select_courses_chose(sid);

        // Sample data
        Object[][] data = {
                {"1 08:00-09:50", "", "", "", "", "", "", ""},
                {"2 10:10-12:00", "", "", "", "", "", "", ""},
                {"3 14:00-15:50", "", "", "", "", "", "", ""},
                {"4 16:10-18:00", "", "", "", "", "", "", ""},
                {"5 19:00-20:50", "", "", "", "", "", "", ""}
        };

        for(int i=0; i< l.size(); i++)
        {
            data[l.get(i).getSession()-1][l.get(i).getWeekday()]=l.get(i).getCname();
        }

        // Column names
        String[] columnNames = {"", "周一", "周二", "周三", "周四", "周五", "周六", "周日"};

        // Create a default table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create a table with the default model
        table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create an "Export" button
        JButton exportButton = new JButton("导出为Excel");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToExcel();
            }
        });

        // Add the "Export" button to the frame
        getContentPane().add(exportButton, BorderLayout.SOUTH);

        // Display the frame
        setSize(900, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void exportToExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                // Create a new workbook
                Workbook workbook = new XSSFWorkbook();

                // Create a sheet
                Sheet sheet = workbook.createSheet("Table Data");

                // Create a header row
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(table.getColumnName(col));
                }

                // Create data rows
                for (int row = 0; row < table.getRowCount(); row++) {
                    Row dataRow = sheet.createRow(row + 1);
                    for (int col = 0; col < table.getColumnCount(); col++) {
                        Cell cell = dataRow.createCell(col);
                        cell.setCellValue(table.getValueAt(row, col).toString());
                    }
                }

                try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    // Write the workbook content to a file
                    workbook.write(fileOut);
                    JOptionPane.showMessageDialog(this, "课表导出成功!");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "课表导出失败! Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        // Close the workbook
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error choosing file or exporting: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

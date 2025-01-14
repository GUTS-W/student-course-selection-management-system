package obProject.graph;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class showCheckboxTable {
    public showCheckboxTable(CardLayout cardLayout, JPanel root, String path, String name){
        JFrame frame = new JFrame("所查找课程情况");
        frame.setSize(600, 400);

        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(){
            //@Override
           /* public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 1) {
                    return Boolean.class; // 设置第n+1列为布尔类型，以便显示复选框
                }
                return super.getColumnClass(columnIndex);
            }*/
        };

        JTable table = new JTable(model);
        // 将表格的第二列设置为复选框列
       /* table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                return checkBox;
            }
        });*/

        // 创建滚动窗格以容纳表格
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // 从 CSV 文件中读取数据
        String csvFile = System.getProperty("user.dir")+"\\src\\obProject\\img\\c.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"\\src\\obProject\\img\\c.csv"), "GB2312"))) {
            // 读取文件头部，设置表格列名
            if ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);
                model.setColumnIdentifiers(columns);
            }

            // 读取数据行并添加到表格模型中
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
       // cardLayout.show(root,name);



    }
}

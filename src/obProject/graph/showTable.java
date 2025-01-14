package obProject.graph;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class showTable {


    public  showTable(CardLayout cardLayout, JPanel root, String path,String name){
        JFrame frame = new JFrame(name);
        frame.setSize(600, 400);

        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel();

        JTable table = new JTable(model);

        // 创建滚动窗格以容纳表格
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // 从 CSV 文件中读取数据
        String csvFile = path;
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "GB2312"))) {
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
    }
}

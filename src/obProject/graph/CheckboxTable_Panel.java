package obProject.graph;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CheckboxTable_Panel extends JPanel{
    private int xLength;
    private int yLength;
    private int valid;
    private DefaultTableModel model = new DefaultTableModel();

    public CheckboxTable_Panel(){
        //需要接收一些数组
        // 创建表格模型


        getModel().addColumn("课程号");
        getModel().addColumn("课程姓名");
        getModel().addColumn("课程学分");
        getModel().addColumn("课程类型");
        getModel().addColumn("所属学院");
        getModel().addColumn("是否通过"); // 用于放置复选框

        // 添加数据到表格模型
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});
        getModel().addRow(new Object[]{"0001", "原神元素学习", "5","必修","计算机科学与技术学院"});

        // 创建表格

        JTable table = new JTable(getModel());
        // 在表格中的每一行增加复选框
        TableColumn checkboxColumn = table.getColumnModel().getColumn(5);//这个数字需要修改
        checkboxColumn.setCellRenderer(new Admin_course_Panel.CheckboxRenderer());
        checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        // 添加表格到滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setVisible(true);

    }


    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }


    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}

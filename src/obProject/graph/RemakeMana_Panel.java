package obProject.graph;
import obProject.dao.impl.teacherDaoImpl;
import obProject.entity.remake_student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RemakeMana_Panel extends JPanel{

    //private CheckboxTable_Panel tablePanel =new CheckboxTable_Panel();//这个位置需要接下来set
    //JPanel panel=new JPanel();
    JPanel panel=new JPanel();
    JPanel tablePanel=new JPanel();
    private JButton indentityButton =new JButton("确定");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    String welcomeStatement="Hello 教师"+ getAccount();
    JLabel welcomeLabel=new JLabel(welcomeStatement);
    private DefaultTableModel model = new DefaultTableModel();
    // 创建表格
    JTable table = new JTable(getModel());
    // 添加表格到滚动窗格
    JScrollPane scrollPane = new JScrollPane(table);
    void setWelcome(){
        welcomeStatement="Hello 教师"+ getAccount();
        welcomeLabel.setText("");
        welcomeLabel.setText(welcomeStatement);
    }
    teacherDaoImpl tea=new teacherDaoImpl();
    private JLabel operation=new JLabel("此时您进行的操作是 补考管理");
    public RemakeMana_Panel(){
        setLayout(null);

        panel.setLayout(null);
        panel.setBounds(0,0,1000,200);
        welcomeLabel.setBounds(350,10,1000,35);
        Font font=new Font("楷体", Font.BOLD, 25);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(Color.BLACK);

        tablePanel.setLayout(null);
        scrollPane.setBounds(0,0,1000,500);
        tablePanel.add(scrollPane);
        tablePanel.setBounds(0,200,1000,500);




        getIndentityButton().setBounds(100,50,200,50);


        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIndentityButton().setFont(font_button);
        //退出按钮
        getBackButton().setBounds(850,10,120,30);
        //当前进行的操作提醒
        Font font1=new Font("楷体", Font.BOLD, 25);
        operation.setFont(font1);
        operation.setForeground(Color.BLACK);
        operation.setBounds(360,65,500,40);

        panel.add(operation);
        panel.add(welcomeLabel);
        panel.add(getIndentityButton());
        panel.add(getBackButton());
        add(panel);
        add(tablePanel);

    }

    void updateTabel(){
        // 移除所有行
        model.setRowCount(0);

        // 移除所有列名
        model.setColumnCount(0);
        List<remake_student> list= new ArrayList<>();
        list=tea.select_student_remake(getAccount());
        getModel().addColumn("学生学号");
        getModel().addColumn("课程编号");
        getModel().addColumn("课程名称");
        getModel().addColumn("补考状态");
        getModel().addColumn("是否通过");
        for(int i=0;i<list.size();i++){
            getModel().addRow(new Object[]{list.get(i).getSid(),list.get(i).getCid(),
                    list.get(i).getCname(),list.get(i).getIf_pass()});
        }


        // 在表格中的每一行增加复选框
        TableColumn checkboxColumn = table.getColumnModel().getColumn(4);
        checkboxColumn.setCellRenderer(new Admin_course_Panel.CheckboxRenderer());
        checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
    }


    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }


    static class CheckboxRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                return checkBox;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("操作成功!");
        JLabel defuseLabel=new JLabel("操作失败!");
        Font font=new Font("微软雅黑", Font.BOLD, 25);
        label.setFont(font);
        if(update!=0)
            dialog.add(label);
        else
            dialog.add(defuseLabel);
        // 显示对话框
        dialog.setVisible(true);
    }
    public JButton getIndentityButton() {
        return indentityButton;
    }

    public void setIndentityButton(JButton indentityButton) {
        this.indentityButton = indentityButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

//    public CheckboxTable_Panel getTablePanel() {
//        return tablePanel;
//    }
//
//    public void setTablePanel(CheckboxTable_Panel tablePanel) {
//        this.tablePanel = tablePanel;
//    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /*public CheckboxTable_Panel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(CheckboxTable_Panel tablePanel) {
        this.tablePanel = tablePanel;
    }*/
}

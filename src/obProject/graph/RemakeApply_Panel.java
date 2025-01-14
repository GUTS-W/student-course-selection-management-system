package obProject.graph;

import obProject.dao.impl.studentDaoImpl;
import obProject.entity.remake_student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RemakeApply_Panel extends JPanel{
   private JPanel tablePanel=new JPanel();
    private JPanel panel=new JPanel();
    private JButton addButton=new JButton("申请");
    private JButton backButton=new JButton("退出");
    private String account;
    String welcomeStatement="Hello 学生"+ getAccount();
    JLabel welcomeLabel=new JLabel(welcomeStatement);
    DefaultTableModel model = new DefaultTableModel();
    // 创建表格
    JTable table = new JTable(model);
    // 添加表格到滚动窗格
    JScrollPane scrollPane = new JScrollPane(table);
    private JLabel operation=new JLabel("此时您进行的操作是 申请补考");
    studentDaoImpl stu=new studentDaoImpl();
    void setWelcome(){
        String str="Hello 学生"+getAccount();
        welcomeStatement=str;
        welcomeLabel.setText("");
        welcomeLabel.setText(welcomeStatement);
    }
    public RemakeApply_Panel(){
    }
    void init(){
        setLayout(null);


        tablePanel.setLayout(null);
        scrollPane.setBounds(0,0,1000,500);
        getTablePanel().add(scrollPane);
        getTablePanel().setBounds(0,200,1000,500);

        getPanel().setLayout(null);
        getPanel().setBounds(0,0,1000,200);

        getAddButton().setBounds(100,60,200,50);


        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getAddButton().setFont(font_button);
        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        getPanel().add(getAddButton());
        getPanel().add(getBackButton());

        welcomeLabel.setText(welcomeStatement);
        welcomeLabel.setBounds(350,10,1000,35);
        Font font=new Font("楷体", Font.BOLD, 25);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(Color.BLACK);

        Font font1=new Font("楷体", Font.BOLD, 25);
        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.BLACK);
        operation.setBounds(360,65,500,40);

        add(operation);
        add(welcomeLabel);
        add(getPanel());
        add(tablePanel);
    }

    void showTable(){
        // 移除所有行
        model.setRowCount(0);

        // 移除所有列名
        model.setColumnCount(0);

        List<remake_student> list= stu.select_course_remake(account);

        //logger.debug("id为"+getAccount());
        //list=tea.select_course(getAccount());
        model.addColumn("课程编号");
        model.addColumn("课程名称");
        model.addColumn("学生id");
        model.addColumn("是否通过");

        for(int i=0;i<list.size();i++){
            model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getSid(),list.get(i).getIf_pass()});
        }
        //JFrame frame = new JFrame("学生补考信息");


    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public JPanel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JPanel tablePanel) {
        this.tablePanel = tablePanel;
    }
}

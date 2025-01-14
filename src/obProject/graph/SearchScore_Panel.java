package obProject.graph;
import obProject.entity.lecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import obProject.entity.*;
import obProject.dao.impl.administratorsDaoImpl;
import obProject.dao.impl.studentDaoImpl;
public class SearchScore_Panel extends JPanel{
    private String textName="";//查询到的name
    administratorsDaoImpl adm=new administratorsDaoImpl();
    studentDaoImpl stu=new studentDaoImpl();
    private JTextField searchNameText =new JTextField(10);//总绩点
    private JTextField searchIDText =new JTextField(10);//总学分
    private JButton identityButton=new JButton("查询详细绩点");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    JLabel operation=new JLabel("此时您的学分绩点如下:");
    void init(){
        setLayout(null);
        String welcomeStatement="Hello 学生"+ getAccount();
        JLabel welcomeLabel=new JLabel(welcomeStatement);
        welcomeLabel.setBounds(350,10,1000,35);
        Font font=new Font("楷体", Font.BOLD, 25);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(Color.WHITE);
        int borderRed = 129;
        int borderGreen = 138;
        int borderBlue = 138;
        Color borderColor = new Color(borderRed, borderGreen, borderBlue);
        Font font1=new Font("楷体", Font.BOLD, 25);




        getSearchIDText().setBounds(520,180,190,38);

        getSearchNameText().setBounds(520,280,190,38);


        JLabel addIDLabel=new JLabel("所修总学分");
        JLabel addNameLabel=new JLabel("总绩点");
        String sid=account;
        List<course_score> l=stu.select_score(sid);
        gpa g1=stu.alu_gpa(l);
        searchIDText.setText(String.valueOf(g1.getCredit()));
        searchNameText.setText(String.valueOf(g1.getGpa()));
        addIDLabel.setBounds(260,180,230,40);
        addIDLabel.setForeground(Color.WHITE);
        addIDLabel.setFont(font1);
        addIDLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));
        addNameLabel.setBounds(260,280,230,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,400,200,50);
        getIdentityButton().setFont(font_button);

        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getBackButton());
        add(getIdentityButton());
        add(operation);
        add(getSearchIDText());
        add(getSearchNameText());
        add(addIDLabel);
        add(addNameLabel);
        add(welcomeLabel);
    }
    public void excute(){
        //接口
        String sid=account;

        List<course_score> list=new ArrayList<>();
        list=stu.select_score(sid);
        showSearchCourseTable(list);
    }
    void showSearchCourseTable(List<course_score> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("全部的课程信息");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("课程号");
            model.addColumn("课程名");
            model.addColumn("学号");
            model.addColumn("成绩");
            model.addColumn("学分");
            model.addColumn("课程类型");

            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                if(list.get(i).getScore()==0)
                {
                    model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getSid(),
                            "null",list.get(i).getCredit(),list.get(i).getType()});
                    continue;
                }
                model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getSid(),
                        list.get(i).getScore(),list.get(i).getCredit(),list.get(i).getType()});
            }
            // 创建表格
            JTable table = new JTable(model);


            // 添加表格到滚动窗格
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);

        });
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public JButton getIdentityButton() {
        return identityButton;
    }

    public void setIdentityButton(JButton identityButton) {
        this.identityButton = identityButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }



    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public JTextField getSearchNameText() {
        return searchNameText;
    }

    public void setSearchNameText(JTextField searchNameText) {
        this.searchNameText = searchNameText;
    }

    public JTextField getSearchIDText() {
        return searchIDText;
    }

    public void setSearchIDText(JTextField searchIDText) {
        this.searchIDText = searchIDText;
    }
}

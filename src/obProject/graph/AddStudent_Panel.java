package obProject.graph;

import javax.swing.*;
import java.awt.*;
public class AddStudent_Panel extends JPanel{
    private JTextField addIDText=new JTextField(10);//待加入的id区域
    private JTextField addNameText=new JTextField(10);//待加入的姓名区域
    private JTextField addSidText=new JTextField(10);//学号输入框
    private JTextField addBirthdayText=new JTextField(10);
    private JTextField addDepartmentText=new JTextField(10);
    private JTextField addMajorText=new JTextField(10);
    private JTextField addSexText=new JTextField(10);
    private JTextField addCampusText=new JTextField(10);
    private JTextField addClassText=new JTextField(10);
    private JTextField addGradeText=new JTextField(10);
    private JButton identityButton=new JButton("确认");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    JLabel operation=new JLabel("此时您进行的操作是 增加学生信息");
    public void init(){
        setLayout(null);
        String welcomeStatement="Hello 管理员"+ getAccount();
        JLabel welcomeLabel=new JLabel(welcomeStatement);
        welcomeLabel.setBounds(350,10,1000,35);
        Font font=new Font("楷体", Font.BOLD, 25);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(Color.WHITE);
//设置边框颜色
        int borderRed = 129;
        int borderGreen = 138;
        int borderBlue = 138;
        Color borderColor = new Color(borderRed, borderGreen, borderBlue);
        Font font1=new Font("楷体", Font.BOLD, 25);

        //输入框的位置
        getAddSidText().setBounds(280,150,190,40);
        getAddNameText().setBounds(280,210,190,38);
        getAddIDText().setBounds(280,270,190,38);
        getAddBirthdayText().setBounds(280,330,190,38);
        getAddSexText().setBounds(280,390,190,38);
        getAddDepartmentText().setBounds(780,150,190,38);
        getAddMajorText().setBounds(780,210,190,38);
        getAddCampusText().setBounds(780,270,190,38);
        getAddGradeText().setBounds(780,330,190,38);
        getAddClassText().setBounds(780,390,190,38);

        //标签及其摆放的位置
        JLabel addSidLabel=new JLabel("待增加学生学号");
        JLabel addNameLabel=new JLabel("待增加学生姓名");
        JLabel addIDLabel=new JLabel("待增加学生身份证号");
        JLabel addBirthdayLabel=new JLabel("待增加学生生日");
        JLabel addSexLabel=new JLabel("待增加学生性别");
        JLabel addDepartLabel=new JLabel("待增加学生学院");
        JLabel addMajorLabel=new JLabel("待增加学生专业");
        JLabel addCampusLabel=new JLabel("待增加学生校区");
        JLabel addGradeLabel=new JLabel("待增加学生年级");
        JLabel addClassLabel=new JLabel("待增加学生班级");

        addSidLabel.setBounds(10,150,250,40);
        addSidLabel.setForeground(Color.WHITE);
        addSidLabel.setFont(font1);
        addSidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addNameLabel.setBounds(10,210,250,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addIDLabel.setBounds(10,270,250,40);
        addIDLabel.setForeground(Color.WHITE);
        addIDLabel.setFont(font1);
        addIDLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addBirthdayLabel.setBounds(10,330,250,40);
        addBirthdayLabel.setForeground(Color.WHITE);
        addBirthdayLabel.setFont(font1);
        addBirthdayLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addSexLabel.setBounds(10,390,250,40);
        addSexLabel.setForeground(Color.WHITE);
        addSexLabel.setFont(font1);
        addSexLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addDepartLabel.setBounds(510,150,250,40);
        addDepartLabel.setForeground(Color.WHITE);
        addDepartLabel.setFont(font1);
        addDepartLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addMajorLabel.setBounds(510,210,250,40);
        addMajorLabel.setForeground(Color.WHITE);
        addMajorLabel.setFont(font1);
        addMajorLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addCampusLabel.setBounds(510,270,250,40);
        addCampusLabel.setForeground(Color.WHITE);
        addCampusLabel.setFont(font1);
        addCampusLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addGradeLabel.setBounds(510,330,250,40);
        addGradeLabel.setForeground(Color.WHITE);
        addGradeLabel.setFont(font1);
        addGradeLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addClassLabel.setBounds(510,390,250,40);
        addClassLabel.setForeground(Color.WHITE);
        addClassLabel.setFont(font1);
        addClassLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,580,200,50);
        getIdentityButton().setFont(font_button);


        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        //向panel中添加
        add(operation);
        add(identityButton);
        add(backButton);
        add(getAddSidText());
        add(addNameText);
        add(addIDText);
        add(getAddBirthdayText());
        add(getAddSexText());
        add(getAddDepartmentText());
        add(getAddMajorText());
        add(welcomeLabel);
        add(addSidLabel);
        add(addSexLabel);
        add(addBirthdayLabel);
        add(addNameLabel);
        add(addIDLabel);
        add(addDepartLabel);
        add(addMajorLabel);
        add(getAddCampusText());
        add(getAddGradeText());
        add(getAddClassText());
        add(addCampusLabel);
        add(addGradeLabel);
        add(addClassLabel);
    }



    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("添加成功!");
        JLabel defuseLabel=new JLabel("添加失败!");
        Font font=new Font("微软雅黑", Font.BOLD, 25);
        label.setFont(font);
        if(update!=0)
            dialog.add(label);
        else
            dialog.add(defuseLabel);
        // 显示对话框
        dialog.setVisible(true);
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

    public JTextField getAddIDText() {
        return addIDText;
    }

    public void setAddIDText(JTextField addIDText) {
        this.addIDText = addIDText;
    }

    public JTextField getAddNameText() {
        return addNameText;
    }

    public void setAddNameText(JTextField addNameText) {
        this.addNameText = addNameText;
    }

    public JTextField getAddSidText() {
        return addSidText;
    }

    public void setAddSidText(JTextField addSidText) {
        this.addSidText = addSidText;
    }

    public JTextField getAddBirthdayText() {
        return addBirthdayText;
    }

    public void setAddBirthdayText(JTextField addBirthdayText) {
        this.addBirthdayText = addBirthdayText;
    }

    public JTextField getAddDepartmentText() {
        return addDepartmentText;
    }

    public void setAddDepartmentText(JTextField addDepartmentText) {
        this.addDepartmentText = addDepartmentText;
    }

    public JTextField getAddMajorText() {
        return addMajorText;
    }

    public void setAddMajorText(JTextField addMajorText) {
        this.addMajorText = addMajorText;
    }

    public JTextField getAddSexText() {
        return addSexText;
    }

    public void setAddSexText(JTextField addSexText) {
        this.addSexText = addSexText;
    }

    public JTextField getAddCampusText() {
        return addCampusText;
    }

    public void setAddCampusText(JTextField addCampusText) {
        this.addCampusText = addCampusText;
    }

    public JTextField getAddGradeText() {
        return addGradeText;
    }

    public void setAddGradeText(JTextField addGradeText) {
        this.addGradeText = addGradeText;
    }

    public JTextField getAddClassText() {
        return addClassText;
    }

    public void setAddClassText(JTextField addClassText) {
        this.addClassText = addClassText;
    }
}

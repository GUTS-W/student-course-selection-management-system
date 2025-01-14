package obProject.graph;
import javax.swing.*;
import java.awt.*;
public class StudentInfo_Panel extends JPanel{
    private JTextField IDText=new JTextField(10);//待加入的id区域
    private JTextField NameText=new JTextField(10);//待加入的姓名区域
    private JTextField SidText=new JTextField(10);//学号输入框
    private JTextField BirthdayText=new JTextField(10);
    private JTextField DepartmentText=new JTextField(10);
    private JTextField MajorText=new JTextField(10);
    private JTextField SexText=new JTextField(10);
    private JTextField CampusText=new JTextField(10);
    private JTextField ClassText=new JTextField(10);
    private JTextField GradeText=new JTextField(10);
    private JButton identityButton=new JButton("编辑");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    private JLabel operation=new JLabel("此时您进行的操作是 查看个人信息");
    public void init(){
        setLayout(null);
        String welcomeStatement="Hello 学生"+ getAccount();
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
        getSidText().setBounds(280,150,190,40);
        getNameText().setBounds(280,210,190,38);
        getIDText().setBounds(280,270,190,38);
        getBirthdayText().setBounds(280,330,190,38);
        getSexText().setBounds(280,390,190,38);
        getDepartmentText().setBounds(780,150,190,38);
        getMajorText().setBounds(780,210,190,38);
        getCampusText().setBounds(780,270,190,38);
        getGradeText().setBounds(780,330,190,38);
        getClassText().setBounds(780,390,190,38);

        //标签及其摆放的位置
        JLabel SidLabel=new JLabel("学生学号");
        JLabel NameLabel=new JLabel("学生姓名");
        JLabel IDLabel=new JLabel("学生身份证号");
        JLabel BirthdayLabel=new JLabel("学生生日");
        JLabel SexLabel=new JLabel("学生性别");
        JLabel DepartLabel=new JLabel("学生学院");
        JLabel MajorLabel=new JLabel("学生专业");
        JLabel CampusLabel=new JLabel("学生校区");
        JLabel GradeLabel=new JLabel("学生年级");
        JLabel ClassLabel=new JLabel("学生班级");

        SidLabel.setBounds(10,150,250,40);
        SidLabel.setForeground(Color.WHITE);
        SidLabel.setFont(font1);
        SidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        NameLabel.setBounds(10,210,250,40);
        NameLabel.setForeground(Color.WHITE);
        NameLabel.setFont(font1);
        NameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        IDLabel.setBounds(10,270,250,40);
        IDLabel.setForeground(Color.WHITE);
        IDLabel.setFont(font1);
        IDLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        BirthdayLabel.setBounds(10,330,250,40);
        BirthdayLabel.setForeground(Color.WHITE);
        BirthdayLabel.setFont(font1);
        BirthdayLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        SexLabel.setBounds(10,390,250,40);
        SexLabel.setForeground(Color.WHITE);
        SexLabel.setFont(font1);
        SexLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        DepartLabel.setBounds(510,150,250,40);
        DepartLabel.setForeground(Color.WHITE);
        DepartLabel.setFont(font1);
        DepartLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        MajorLabel.setBounds(510,210,250,40);
        MajorLabel.setForeground(Color.WHITE);
        MajorLabel.setFont(font1);
        MajorLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        CampusLabel.setBounds(510,270,250,40);
        CampusLabel.setForeground(Color.WHITE);
        CampusLabel.setFont(font1);
        CampusLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        GradeLabel.setBounds(510,330,250,40);
        GradeLabel.setForeground(Color.WHITE);
        GradeLabel.setFont(font1);
        GradeLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        ClassLabel.setBounds(510,390,250,40);
        ClassLabel.setForeground(Color.WHITE);
        ClassLabel.setFont(font1);
        ClassLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

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
        //add(identityButton);
        add(backButton);
        add(getSidText());
        add(NameText);
        add(IDText);
        add(getBirthdayText());
        add(getSexText());
        add(getDepartmentText());
        add(getMajorText());
        add(welcomeLabel);
        add(SidLabel);
        add(SexLabel);
        add(BirthdayLabel);
        add(NameLabel);
        add(IDLabel);
        add(DepartLabel);
        add(MajorLabel);
        add(getCampusText());
        add(getGradeText());
        add(getClassText());
        add(CampusLabel);
        add(GradeLabel);
        add(ClassLabel);
    }

    public JTextField getIDText() {
        return IDText;
    }

    public void setIDText(JTextField IDText) {
        this.IDText = IDText;
    }

    public JTextField getNameText() {
        return NameText;
    }

    public void setNameText(JTextField nameText) {
        NameText = nameText;
    }

    public JTextField getSidText() {
        return SidText;
    }

    public void setSidText(JTextField sidText) {
        SidText = sidText;
    }

    public JTextField getBirthdayText() {
        return BirthdayText;
    }



    public JTextField getDepartmentText() {
        return DepartmentText;
    }

    public void setDepartmentText(JTextField departmentText) {
        DepartmentText = departmentText;
    }

    public JTextField getMajorText() {
        return MajorText;
    }

    public void setMajorText(JTextField majorText) {
        MajorText = majorText;
    }

    public JTextField getSexText() {
        return SexText;
    }

    public void setSexText(JTextField sexText) {
        SexText = sexText;
    }

    public JTextField getCampusText() {
        return CampusText;
    }

    public void setCampusText(JTextField campusText) {
        CampusText = campusText;
    }

    public JTextField getClassText() {
        return ClassText;
    }

    public void setClassText(JTextField classText) {
        ClassText = classText;
    }

    public JTextField getGradeText() {
        return GradeText;
    }

    public void setGradeText(JTextField gradeText) {
        GradeText = gradeText;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public JLabel getOperation() {
        return operation;
    }

    public void setOperation(JLabel operation) {
        this.operation = operation;
    }
}

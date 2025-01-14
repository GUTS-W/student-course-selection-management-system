package obProject.graph;

import javax.swing.*;
import java.awt.*;
public class Teacher_Menu_Panel extends JPanel{
    private JButton backButton=new JButton("退出");
    private String account;
    private String welcomeStatement;
    private JLabel welcomeLabel=new JLabel(getWelcomeStatement());
    private JButton courseApply_button=new JButton("开课申请");
    private JButton scoreInput_button =new JButton("成绩录入");
    private JButton remake_button=new JButton("补考管理");
    public Teacher_Menu_Panel(){}
    void init(){
        setLayout(null);
        setWelcomeStatement("Hello 教师"+ getAccount());
        getWelcomeLabel().setText(getWelcomeStatement());
        getWelcomeLabel().setBounds(350,0,1000,30);
        Font font=new Font("楷体", Font.BOLD, 25);
        getWelcomeLabel().setFont(font);

        getCourseApply_button().setBounds(110,45,180,30);
        getScoreInput_button().setBounds(310,45,180,30);
        getRemake_button().setBounds(510,45,180,30);

        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getBackButton());
        add(getWelcomeLabel());
        add(getCourseApply_button());
        add(getScoreInput_button());
        add(getRemake_button());

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

    public String getWelcomeStatement() {
        return welcomeStatement;
    }

    public void setWelcomeStatement(String welcomeStatement) {
        this.welcomeStatement = welcomeStatement;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    public void setWelcomeLabel(JLabel welcomeLabel) {
        this.welcomeLabel = welcomeLabel;
    }

    public JButton getCourseApply_button() {
        return courseApply_button;
    }

    public void setCourseApply_button(JButton courseApply_button) {
        this.courseApply_button = courseApply_button;
    }

    public JButton getScoreInput_button() {
        return scoreInput_button;
    }

    public void setScoreInput_button(JButton scoreInput_button) {
        this.scoreInput_button = scoreInput_button;
    }

    public JButton getRemake_button() {
        return remake_button;
    }

    public void setRemake_button(JButton remake_button) {
        this.remake_button = remake_button;
    }
}

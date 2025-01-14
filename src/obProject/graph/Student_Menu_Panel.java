package obProject.graph;

import javax.swing.*;
import java.awt.*;
public class Student_Menu_Panel extends JPanel{
    private JButton info_button=new JButton("学生信息查看");
    private JButton select_button=new JButton("学生选课管理");
    private JButton edit_button=new JButton("学生补考申请");
    private JButton grades_button=new JButton("学分绩点查询");
    private JButton syllabus_button=new JButton("学生课表查询");
    private JButton awardPublish_button=new JButton("学生奖惩模块");
    private JButton backButton=new JButton("退出");
    private String account;
    private String welcomeStatement;
    private JLabel welcomeLabel=new JLabel(getWelcomeStatement());
    public Student_Menu_Panel(){

    }
    public void init(){
        setLayout(null);
        setWelcomeStatement("Hello 学生"+ getAccount());
        getWelcomeLabel().setText(getWelcomeStatement());
        getWelcomeLabel().setBounds(350,0,1000,30);
        Font font=new Font("楷体", Font.BOLD, 25);
        getWelcomeLabel().setFont(font);

        /*JPanel  studentInformationPanel = new JPanel();
        JPanel selectPanel = new JPanel();
        JPanel editPanel = new JPanel();
        JPanel gradesPanel = new JPanel();
        JPanel syllabusPanel = new JPanel();//课表
        JPanel awardPublishPanel=new JPanel();//奖惩模块*/

        getInfo_button().setBounds(110,45,180,30);
        getSelect_button().setBounds(310,45,180,30);
        getEdit_button().setBounds(510,45,180,30);
        getGrades_button().setBounds(710,45,180,30);
        getSyllabus_button().setBounds(110,90,180,30);
        getAwardPublish_button().setBounds(310,90,180,30);


        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        /*studentInformationPanel.add(info_button);
        selectPanel.add(select_button);
        editPanel.add(edit_button);
        gradesPanel.add(grades_button);
        syllabusPanel.add(syllabus_button);
        awardPublishPanel.add(awardPublish_button);
*/

        add(getBackButton());
        add(getWelcomeLabel());
        add(getInfo_button());
        add(getSelect_button());
        add(getEdit_button());
        add(getGrades_button());
        add(getSyllabus_button());
        add(getAwardPublish_button());
    }

    public JButton getInfo_button() {
        return info_button;
    }

    public void setInfo_button(JButton info_button) {
        this.info_button = info_button;
    }

    public JButton getSelect_button() {
        return select_button;
    }

    public void setSelect_button(JButton select_button) {
        this.select_button = select_button;
    }

    public JButton getEdit_button() {
        return edit_button;
    }

    public void setEdit_button(JButton edit_button) {
        this.edit_button = edit_button;
    }

    public JButton getGrades_button() {
        return grades_button;
    }

    public void setGrades_button(JButton grades_button) {
        this.grades_button = grades_button;
    }

    public JButton getSyllabus_button() {
        return syllabus_button;
    }

    public void setSyllabus_button(JButton syllabus_button) {
        this.syllabus_button = syllabus_button;
    }

    public JButton getAwardPublish_button() {
        return awardPublish_button;
    }

    public void setAwardPublish_button(JButton awardPublish_button) {
        this.awardPublish_button = awardPublish_button;
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
}
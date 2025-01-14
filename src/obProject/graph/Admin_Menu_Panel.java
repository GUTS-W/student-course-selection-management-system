package obProject.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Menu_Panel extends JPanel{
    private JButton backButton=new JButton("退出");
    private String account;
    String welcomeStatement;
    JLabel welcomeLabel=new JLabel(welcomeStatement);
    private JButton studentMana_button=new JButton("学生信息管理");
    private JButton teacherMana_button=new JButton("教师信息管理");
    private JButton instituteMana_button=new JButton("院系管理");
    private JButton courseMana_button=new JButton("课程管理");
    private JButton majorMana_button=new JButton("专业管理");
    private JButton rpMana_button=new JButton("奖惩管理");
    public Admin_Menu_Panel() {}

    void init(){
        setLayout(null);

        welcomeStatement="Hello 管理员"+account;
        welcomeLabel.setText(welcomeStatement);
        welcomeLabel.setBounds(350,0,1000,30);
        Font font=new Font("楷体", Font.BOLD, 25);
        welcomeLabel.setFont(font);


        getStudentMana_button().setBounds(110,45,180,30);
        getTeacherMana_button().setBounds(310,45,180,30);
        getInstituteMana_button().setBounds(510,45,180,30);
        getCourseMana_button().setBounds(710,45,180,30);
        getMajorMana_button().setBounds(110,90,180,30);
        getRPMana_button().setBounds(310,90,180,30);
        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getBackButton());
        add(welcomeLabel);
        add(getStudentMana_button());
        add(getTeacherMana_button());
        add(getInstituteMana_button());
        add(getCourseMana_button());
        add(getMajorMana_button());
        add(getRPMana_button());
    }



    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public JButton getStudentMana_button() {
        return studentMana_button;
    }

    public void setStudentMana_button(JButton studentMana_button) {
        this.studentMana_button = studentMana_button;
    }

    public JButton getTeacherMana_button() {
        return teacherMana_button;
    }

    public void setTeacherMana_button(JButton teacherMana_button) {
        this.teacherMana_button = teacherMana_button;
    }

    public JButton getInstituteMana_button() {
        return instituteMana_button;
    }

    public void setInstituteMana_button(JButton instituteMana_button) {this.instituteMana_button = instituteMana_button;}

    public JButton getCourseMana_button() {
        return courseMana_button;
    }

    public void setCourseMana_button(JButton courseMana_button) {
        this.courseMana_button = courseMana_button;
    }

    public JButton getMajorMana_button() {
        return majorMana_button;
    }

    public void setMajorMana_button(JButton majorMana_button) {
        this.majorMana_button = majorMana_button;
    }

    public JButton getRPMana_button() {
        return rpMana_button;
    }

    public void setRPMana_button(JButton rpMana_button) {this.rpMana_button = rpMana_button;}

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }


}

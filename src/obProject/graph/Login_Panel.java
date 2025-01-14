package obProject.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Login_Panel extends GradientPanel{
    //一些组成登录界面的基本元素
    String type="空";
    JLabel title1_label =new JLabel("学生选课管理信息系统");
    JLabel account_label=new JLabel("账号:");
    JTextField text_account=new JTextField(10);
    JLabel password_label=new JLabel("密码:");
    JPasswordField text_password=new JPasswordField(10);
    JRadioButton option1 = new JRadioButton("学生");
    JRadioButton option2 = new JRadioButton("教师");
    JRadioButton option3 = new JRadioButton("管理员");
    private JButton reviseButton=new JButton("修改密码");
    private JLabel reviseLabel=new JLabel("<html><u><i>修改密码</i></u></html>");
    Login_Panel(JFrame stream_frame){

        setLayout(null);

        //getReviseButton().setBounds(850,10,120,30);

        getReviseLabel().setBounds(900,10,120,30);
        Font reviseFont=new Font("黑体",Font.BOLD,13);

        reviseFont.getItalicAngle();
        getReviseLabel().setFont(reviseFont);
        add(getReviseLabel());

        title1_label.setBounds(180,0,700,200);
        Font title1_font1 = new Font("华文彩云", Font.BOLD, 65);
        title1_label.setFont(title1_font1);

        title1_label.setForeground(new Color(17, 17, 17, 253));
        add(title1_label);


        Font account_font = new Font("微软雅黑", Font.BOLD, 40);
        account_label.setBounds(300,250,300,50);
        account_label.setFont((account_font));
        add(account_label);


        Font text_account_font = new Font("微软雅黑", Font.BOLD, 25);
        text_account.setForeground(new Color(14, 14, 14));
        text_account.setBounds(410,260,250,40);
        text_account.setFont(text_account_font);
        //text_account.setText("请输入");
        add(text_account);


        Font password_font=new Font("微软雅黑", Font.BOLD, 40);
        password_label.setBounds(300,330,600,50);
        password_label.setFont(password_font);
        add(password_label);


        text_password.setBounds(410,340,250,40);
        Font password_account_font = new Font("微软雅黑", Font.BOLD, 25);
        text_password.setForeground(new Color(14, 14, 14));
        text_password.setFont(password_account_font);
        text_password.setEchoChar('*');

        add(text_password);



        option1.setBounds(320,430,100,30);
        option2.setBounds(460,430,100,30);
        option3.setBounds(600,430,100,30);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        add(option1);
        add(option2);
        add(option3);

        option1.addActionListener(new ActionListener() {//进入页面时不同的模式
            public void actionPerformed(ActionEvent e) {
                type="学生";
            }
        });
        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="教师";
            }
        });
        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="管理员";
            }
        });

    }
    String getType(){
        return type;
    }
    String getAccount(){
        return text_account.getText();
    }
    String getPassWord(){
        char[] passwordChars =text_password.getPassword();
        String password= new String(passwordChars);
        return password;
    }

    JPasswordField getText_password(){
        return text_password;
    }
    JTextField getText_account(){
        return text_account;
    }


    public JButton getReviseButton() {
        return reviseButton;
    }

    public void setReviseButton(JButton reviseButton) {
        this.reviseButton = reviseButton;
    }

    public JLabel getReviseLabel() {
        return reviseLabel;
    }

    public void setReviseLabel(JLabel reviseLabel) {
        this.reviseLabel = reviseLabel;
    }
}
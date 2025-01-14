package obProject.graph;

import obProject.util.JdbcConnection;
import obProject.util.Log;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class myDemo {
    String type="空";
    static Logger logger= Log.getLogger();
    public myDemo(){
        JFrame f1=new JFrame("学生选课管理信息系统");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        f1.setLocation(250,75);
        f1.setSize(1000,700);
        // f1.setLayout(null);


        JPanel root=new JPanel();
        JPanel root2=new JPanel();


        JLabel title1_label =new JLabel("学生选课管理信息系统");
        Font title1_font1 = new Font("楷体", Font.BOLD, 65);
        title1_label.setFont(title1_font1);
        title1_label.setBounds(130,0,700,200);
        root.add(title1_label);
        //f1.add(root);

        JLabel account_label=new JLabel("账号:");
        Font account_font = new Font("微软雅黑", Font.BOLD, 40);
        account_label.setBounds(200,600,600,50);
        account_label.setFont((account_font));
        root.add(account_label);

        JTextField text_account=new JTextField(10);
        root.add(text_account);

        JLabel password_label=new JLabel("密码:");
        Font password_font=new Font("微软雅黑", Font.BOLD, 40);
        password_label.setBounds(200,600,600,50);
        password_label.setFont(password_font);
        root.add(password_label);

        JPasswordField text_password=new JPasswordField(10);
        root.add(text_password);



        JButton Login_button=new JButton("登录");
        Login_button.setBounds(460,500,100,40);
        root.add(Login_button);
        JRadioButton radioButton1 = new JRadioButton("学生");
        JRadioButton radioButton2 = new JRadioButton("教师");
        JRadioButton radioButton3 = new JRadioButton("管理员");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        root.add(radioButton1);
        root.add(radioButton2);
        root.add(radioButton3);

        radioButton1.addActionListener(new ActionListener() {//进入页面时不同的模式
            public void actionPerformed(ActionEvent e) {
                type="学生";
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="教师";
            }
        });
        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="管理员";
            }
        });

        Login_button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                String account_text=text_account.getText();//输入的账号
                char[] passwordChars=text_password.getPassword();//接收的密码数组
                String password_text=new String(passwordChars);//接收的密码
                Connection conn= JdbcConnection.getConnection();
                String sql="select password from ";
                if(Objects.equals(type, "学生"))
                    sql+="student where SID";
                else if(Objects.equals(type, "教师"))
                    sql+="teacher where TID";
                else if(Objects.equals(type, "管理员"))
                    sql+="administrators where AID";
                else{
                    logger.warn("未选择身份");
                    JdbcConnection.disconnected(conn);
                    return;
                }
                sql=sql+ "='" +account_text+ "'";
                logger.debug("输入的sql语句为"+sql);
                try {
                    PreparedStatement pStmt=conn.prepareStatement(sql);
                    ResultSet rs= pStmt.executeQuery();
                    logger.debug("rs为"+rs);
                    if(!rs.next())
                        logger.warn("账号错误");
                    else{
                        String true_password=rs.getString(1);
                        if(!Objects.equals(true_password, password_text))
                            logger.warn("密码错误");
                        else
                            logger.info("正确，进入下一阶段");
                    }
                    JdbcConnection.closeAll(conn,rs,pStmt);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        f1.add(root);

        //设置窗口对象可见
        f1.setVisible(true);
    }
}

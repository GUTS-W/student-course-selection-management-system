package obProject.graph;

import javax.swing.*;
import java.awt.*;
public class SearchCourse_Panel extends JPanel{
    private JTextField dropNameText = new JTextField(10);
    private JButton identityButton=new JButton("查找");
    private JButton identityAllButton=new JButton("查找全部课程");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    JLabel operation=new JLabel("此时您进行的操作是 查找课程信息");
    public void init(){
        setLayout(null);
        String welcomeStatement="Hello 管理员"+ getAccount();
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



        getAddNameText().setBounds(520,180,190,38);

        JLabel preNameLabel=new JLabel("待查找课程编号");
        preNameLabel.setBounds(260,180,230,40);
        preNameLabel.setForeground(Color.WHITE);
        preNameLabel.setFont(font1);
        preNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));


        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,400,200,50);
        getIdentityButton().setFont(font_button);
        getIdentityAllButton().setBounds(700,400,200,50);
        getIdentityAllButton().setFont(font_button);

        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getIdentityAllButton());
        add(getBackButton());
        add(getIdentityButton());
        add(operation);
        add(getAddNameText());
        add(preNameLabel);
        add(welcomeLabel);
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

    public JTextField getAddNameText() {
        return dropNameText;
    }

    public void setAddNameText(JTextField addNameText) {
        this.dropNameText = addNameText;
    }

    public JButton getIdentityAllButton() {
        return identityAllButton;
    }

    public void setIdentityAllButton(JButton identityAllButton) {
        this.identityAllButton = identityAllButton;
    }
}

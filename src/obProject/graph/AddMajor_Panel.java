package obProject.graph;

import javax.swing.*;
import java.awt.*;

public class AddMajor_Panel extends JPanel{

    private JTextField departmentNameText =new JTextField(10);
    private JTextField addIDText=new JTextField(10);
    private JTextField addNameText=new JTextField(10);


    private JButton identityButton=new JButton("确认");
    private JButton backButton=new JButton("退出");
    private String account;
    JLabel operation=new JLabel("此时您进行的操作是 增加专业");

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


        getDepartmentNameText().setBounds(610,180,190,38);

        getAddIDText().setBounds(610,280,190,38);

        getAddNameText().setBounds(610,380,190,38);

        JLabel departmentNameLabel=new JLabel("待增加专业所在院系名");
        JLabel addIDLabel=new JLabel("待增加专业编号");
        JLabel addNameLabel=new JLabel("待增加专业名称");
        departmentNameLabel.setBounds(300,180,280,40);
        departmentNameLabel.setForeground(Color.WHITE);
        departmentNameLabel.setFont(font1);
        departmentNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));
        addIDLabel.setBounds(300,280,280,40);
        addIDLabel.setForeground(Color.WHITE);
        addIDLabel.setFont(font1);
        addIDLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));
        addNameLabel.setBounds(300,380,280,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(475,500,200,50);
        getIdentityButton().setFont(font_button);

        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getBackButton());
        add(getIdentityButton());
        add(operation);
        add(getDepartmentNameText());
        add(getAddIDText());
        add(getAddNameText());
        add(departmentNameLabel);
        add(addIDLabel);
        add(addNameLabel);
        add(welcomeLabel);
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
    public JTextField getDepartmentNameText() {return departmentNameText;}

    public void setDepartmentNameText(JTextField DepartmentNameText) {
        this.departmentNameText = DepartmentNameText;
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
}


package obProject.graph;

import javax.swing.*;
import java.awt.*;
public class AddRP_Panel extends JPanel{
    private JTextField addNameText=new JTextField(10);//待加入的区域
    private JTextField addSidText=new JTextField(10);//学号输入框
    private JTextField addLevelText=new JTextField(10);
    private JTextField addTypeText=new JTextField(10);
    private JButton identityButton=new JButton("确认");
    private JButton backButton=new JButton("退出");
    private String account;
    JLabel operation=new JLabel("此时您进行的操作是 增加奖惩信息");
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
        getAddSidText().setBounds(580,150,190,40);
        getAddNameText().setBounds(580,210,190,38);
        getAddTypeText().setBounds(580,270,190,38);
        getAddLevelText().setBounds(580,320,190,38);

        //标签及其摆放的位置
        JLabel addSidLabel=new JLabel("奖惩学生学号");
        JLabel addNameLabel=new JLabel("待增加奖惩名称");
        JLabel addTypeLabel=new JLabel("待增加奖惩类别");
        JLabel addLevelLabel=new JLabel("待增加奖惩等级");

        addSidLabel.setBounds(310,150,250,40);
        addSidLabel.setForeground(Color.WHITE);
        addSidLabel.setFont(font1);
        addSidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addNameLabel.setBounds(310,210,250,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addTypeLabel.setBounds(310,270,250,40);
        addTypeLabel.setForeground(Color.WHITE);
        addTypeLabel.setFont(font1);
        addTypeLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addLevelLabel.setBounds(310,320,250,40);
        addLevelLabel.setForeground(Color.WHITE);
        addLevelLabel.setFont(font1);
        addLevelLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));


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
        add(getAddTypeText());
        add(getAddNameText());
        add(getAddLevelText());
        add(welcomeLabel);
        add(addSidLabel);
        add(addNameLabel);
        add(addLevelLabel);
        add(addTypeLabel);
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

    public JTextField getAddTypeText() {
        return addTypeText;
    }

    public void setAddTypeText(JTextField addTypeText) {
        this.addTypeText = addTypeText;
    }

    public JTextField getAddLevelText() {
        return addLevelText;
    }

    public void setAddLevelText(JTextField addLevelText) {
        this.addLevelText = addLevelText;
    }

}

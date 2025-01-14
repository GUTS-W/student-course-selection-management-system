package obProject.graph;
import javax.swing.*;
import java.awt.*;


public class AddCourse_Panel extends JPanel{
    private JTextField addNameText =new JTextField(10);//学号输入框
    private JButton identityButton=new JButton("确认");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    JLabel operation=new JLabel("此时您进行的操作是 审批课程信息");
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
        getAddNameText().setBounds(580,150,190,40);
//标签及其摆放的位置
        JLabel addNameLabel=new JLabel("待审批课程所属院系");
        addNameLabel.setBounds(310,150,250,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));
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

        add(operation);
        add(identityButton);
        add(backButton);
        add(getAddNameText());
        add(welcomeLabel);
        add(addNameLabel);

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

}

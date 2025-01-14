package obProject.graph;
import javax.swing.*;
import java.awt.*;

public class SearchTeacher_Panel extends JPanel{
    private JTextField addSidText=new JTextField(10);//学号输入框
    private JTextField addNameText=new JTextField(10);//待加入的姓名区域
    private JTextField addDepartmentText=new JTextField(10);
    private JTextField addMajorText=new JTextField(10);
    private JButton identityButton=new JButton("查找");
    private JButton backButton=new JButton("退出");
    private String account;
    JLabel operation=new JLabel("此时您进行的操作是 查找教师信息");

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
        getAddTidText().setBounds(580,150,190,40);
        getAddNameText().setBounds(580,210,190,38);
        getAddDepartmentText().setBounds(580,270,190,38);

        getAddTidText().setText(null);
        getAddNameText().setText(null);
        getAddDepartmentText().setText(null);

        //标签及其摆放的位置
        JLabel addTidLabel=new JLabel("待查找教师编号");
        JLabel addNameLabel=new JLabel("待查找教师姓名");
        JLabel addDepartLabel=new JLabel("待查找教师学院");
        addTidLabel.setBounds(310,150,250,40);
        addTidLabel.setForeground(Color.WHITE);
        addTidLabel.setFont(font1);
        addTidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));


        addNameLabel.setBounds(310,210,250,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addDepartLabel.setBounds(310,270,250,40);
        addDepartLabel.setForeground(Color.WHITE);
        addDepartLabel.setFont(font1);
        addDepartLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));



        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,350,200,50);
        getIdentityButton().setFont(font_button);


        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(operation);
        add(identityButton);
        add(backButton);
        add(getAddTidText());
        add(welcomeLabel);
        add(addTidLabel);
        add(getAddDepartmentText());
        add(getAddNameText());
        add(addNameLabel);
        add(addDepartLabel);
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



    public JTextField getAddTidText() {
        return addSidText;
    }

    public void setAddTidText(JTextField addSidText) {
        this.addSidText = addSidText;
    }

    public JTextField getAddNameText() {
        return addNameText;
    }

    public void setAddNameText(JTextField addNameText) {
        this.addNameText = addNameText;
    }

    public JTextField getAddDepartmentText() {
        return addDepartmentText;
    }

    public void setAddDepartmentText(JTextField addDepartmentText) {
        this.addDepartmentText = addDepartmentText;
    }

}

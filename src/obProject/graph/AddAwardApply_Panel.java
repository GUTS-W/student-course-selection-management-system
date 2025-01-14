package obProject.graph;
import javax.swing.*;
import java.awt.*;
public class AddAwardApply_Panel extends JPanel{
    private JTextField addLevelText=new JTextField(10);
    private JTextField addNameText=new JTextField(10);

    private JButton applyButton =new JButton("申请");
    private JButton backButton=new JButton("退出");
    private String account;

    private JLabel operation=new JLabel("此时您进行的操作是 申请奖励");

    public void init(){
        setLayout(null);
        String welcomeStatement="Hello 学生"+ getAccount();
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
        getAddLevelText().setBounds(610,150,190,40);
        getAddNameText().setBounds(610,210,190,38);

        JLabel addLevelLabel=new JLabel("待申请奖励等级");
        JLabel addNameLabel=new JLabel("待申请奖励名称");


        addLevelLabel.setBounds(310,150,250,40);
        addLevelLabel.setForeground(Color.WHITE);
        addLevelLabel.setFont(font1);
        addLevelLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addNameLabel.setBounds(310,210,250,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));


        //当前进行的操作提醒
        getOperation().setFont(font1);
        getOperation().setForeground(Color.WHITE);
        getOperation().setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getApplyButton().setBounds(420,380,200,50);
        getApplyButton().setFont(font_button);



        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        //向panel中添加
        add(getOperation());
        add(getApplyButton());
        add(backButton);
        add(addNameText);
        add(addLevelText);
        add(welcomeLabel);
        add(addLevelLabel);
        add(addNameLabel);

    }

    public JTextField getAddLevelText() {
        return addLevelText;
    }

    public void setAddLevelText(JTextField addLevelText) {
        this.addLevelText = addLevelText;
    }

    public JTextField getAddNameText() {
        return addNameText;
    }

    public void setAddNameText(JTextField addNameText) {
        this.addNameText = addNameText;
    }


    public JButton getApplyButton() {
        return applyButton;
    }

    public void setApplyButton(JButton applyButton) {
        this.applyButton = applyButton;
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

    public JLabel getOperation() {
        return operation;
    }

    public void setOperation(JLabel operation) {
        this.operation = operation;
    }
}

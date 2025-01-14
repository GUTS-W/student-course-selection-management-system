package obProject.graph;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevisePassword_Panel extends JPanel{
    private String type="空";
    private String textName="";//查询到的name
    private JTextField idText =new JTextField(10);
    private JPasswordField passwordText =new JPasswordField(10);
    private JPasswordField revisePasswordText =new JPasswordField(10);
    private JPasswordField indenPasswordText =new JPasswordField(10);
    private JButton identityButton=new JButton("修改");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    JLabel operation=new JLabel("此时您在进行的操作是 修改密码");
    void init(){
        setLayout(null);
        String welcomeStatement="Hello 用户";
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



        getPasswordText().setBounds(520,250,190,38);
        getIdText().setBounds(520,180,190,38);
        getRevisePasswordText().setBounds(520,320,190,38);
        getIndenPasswordText().setBounds(520,390,190,38);


        JLabel IDLabel=new JLabel("请输入用户名");
        JLabel passwordLabel=new JLabel("请输入原始密码");
        JLabel passwordLabel_2=new JLabel("请输入更改后的密码");
        JLabel passwordLabel_3=new JLabel("请确认更改后的密码");
        IDLabel.setBounds(240,180,250,40);
        IDLabel.setForeground(Color.WHITE);
        IDLabel.setFont(font1);
        IDLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));
        passwordLabel.setBounds(240,250,250,40);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(font1);
        passwordLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));
        passwordLabel_2.setBounds(240,320,250,40);
        passwordLabel_2.setForeground(Color.WHITE);
        passwordLabel_2.setFont(font1);
        passwordLabel_2.setBorder(BorderFactory.createLineBorder(borderColor,3));
        passwordLabel_3.setBounds(240,390,250,40);
        passwordLabel_3.setForeground(Color.WHITE);
        passwordLabel_3.setFont(font1);
        passwordLabel_3.setBorder(BorderFactory.createLineBorder(borderColor,3));

        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,540,200,50);
        getIdentityButton().setFont(font_button);

        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        JRadioButton option1 = new JRadioButton("学生");
        JRadioButton option2 = new JRadioButton("教师");
        JRadioButton option3 = new JRadioButton("管理员");

        option1.setBounds(320,450,100,30);
        option2.setBounds(460,450,100,30);
        option3.setBounds(600,450,100,30);
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

        add(getRevisePasswordText());
        add(getIndenPasswordText());
        add(passwordLabel_2);
        add(passwordLabel_3);
        add(getBackButton());
        add(getIdentityButton());
        add(operation);
        add(getPasswordText());
        add(getIdText());
        add(IDLabel);
        add(passwordLabel);
        add(welcomeLabel);
    }

    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("修改成功!");
        JLabel defuseLabel = new JLabel("修改失败!");
        Font font=new Font("微软雅黑", Font.BOLD, 25);
        label.setFont(font);
        if(update!=0)
            dialog.add(label);
        else
            dialog.add(defuseLabel);
        // 显示对话框
        dialog.setVisible(true);
    }


    String getPassWord(){
        char[] passwordChars = getPasswordText().getPassword();
        String password= new String(passwordChars);
        return password;
    }
    String getRevisePassWord(){
        char[] passwordChars = getRevisePasswordText().getPassword();
        String password= new String(passwordChars);
        return password;
    }
    String getIndenPassword(){
        char[] passwordChars = getIndenPasswordText().getPassword();
        String password= new String(passwordChars);
        return password;
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



    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public JTextField getIdText() {
        return idText;
    }

    public void setIdText(JTextField idText) {
        this.idText = idText;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public JPasswordField getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(JPasswordField passwordText) {
        this.passwordText = passwordText;
    }

    public JPasswordField getRevisePasswordText() {
        return revisePasswordText;
    }

    public void setRevisePasswordText(JPasswordField revisePasswordText) {
        this.revisePasswordText = revisePasswordText;
    }

    public JPasswordField getIndenPasswordText() {
        return indenPasswordText;
    }

    public void setIndenPasswordText(JPasswordField indenPasswordText) {
        this.indenPasswordText = indenPasswordText;
    }
}

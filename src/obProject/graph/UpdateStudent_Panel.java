package obProject.graph;
import javax.swing.*;
import java.awt.*;
public class UpdateStudent_Panel extends JPanel
{
    private JTextField addIDText=new JTextField(10);//待加入的id区域
    private JTextField addNameText=new JTextField(10);//待加入的姓名区域
    private JTextField addSidText=new JTextField(10);//学号输入框
    private JTextField addBirthdayText=new JTextField(10);
    private JTextField addDepartmentText=new JTextField(10);
    private JTextField addMajorText=new JTextField(10);
    private JTextField addSexText=new JTextField(10);
    private JButton identityButton=new JButton("确认");
    private JButton updateButton=new JButton("更新");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    JLabel operation=new JLabel("此时您进行的操作是 更改学生信息");
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
        getAddIDText().setBounds(580,270,190,38);
        getAddBirthdayText().setBounds(580,320,190,38);
        getAddSexText().setBounds(580,380,190,38);
        getAddDepartmentText().setBounds(580,440,190,38);
        getAddMajorText().setBounds(580,500,190,38);

        //标签及其摆放的位置
        JLabel addSidLabel=new JLabel("待查询学生学号");
        JLabel addNameLabel=new JLabel("学生姓名");
        JLabel addIDLabel=new JLabel("学生身份证号");
        JLabel addBirthdayLabel=new JLabel("学生生日");
        JLabel addSexLabel=new JLabel("学生性别");
        JLabel addDepartLabel=new JLabel("学生学院");
        JLabel addMajorLabel=new JLabel("学生专业");

        addSidLabel.setBounds(310,150,250,40);
        addSidLabel.setForeground(Color.WHITE);
        addSidLabel.setFont(font1);
        addSidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addNameLabel.setBounds(310,210,250,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addIDLabel.setBounds(310,270,250,40);
        addIDLabel.setForeground(Color.WHITE);
        addIDLabel.setFont(font1);
        addIDLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addBirthdayLabel.setBounds(310,320,250,40);
        addBirthdayLabel.setForeground(Color.WHITE);
        addBirthdayLabel.setFont(font1);
        addBirthdayLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addSexLabel.setBounds(310,380,250,40);
        addSexLabel.setForeground(Color.WHITE);
        addSexLabel.setFont(font1);
        addSexLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addDepartLabel.setBounds(310,440,250,40);
        addDepartLabel.setForeground(Color.WHITE);
        addDepartLabel.setFont(font1);
        addDepartLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addMajorLabel.setBounds(310,500,250,40);
        addMajorLabel.setForeground(Color.WHITE);
        addMajorLabel.setFont(font1);
        addMajorLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,580,200,50);
        getIdentityButton().setFont(font_button);
        getUpdateButton().setBounds(700,580,200,50);
        getUpdateButton().setFont(font_button);


        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        //向panel中添加

        add(getUpdateButton());
        add(operation);
        add(identityButton);
        add(backButton);
        add(getAddSidText());
        add(addNameText);
        add(addIDText);
        add(getAddBirthdayText());
        add(getAddSexText());
        add(getAddDepartmentText());
        add(getAddMajorText());
        add(welcomeLabel);
        add(addSidLabel);
        add(addSexLabel);
        add(addBirthdayLabel);
        add(addNameLabel);
        add(addIDLabel);
        add(addDepartLabel);
        add(addMajorLabel);
    }

    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("成功!");
        JLabel defuseLabel=new JLabel("失败!");
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

    public JTextField getAddSidText() {
        return addSidText;
    }

    public void setAddSidText(JTextField addSidText) {
        this.addSidText = addSidText;
    }

    public JTextField getAddBirthdayText() {
        return addBirthdayText;
    }

    public void setAddBirthdayText(JTextField addBirthdayText) {
        this.addBirthdayText = addBirthdayText;
    }

    public JTextField getAddDepartmentText() {
        return addDepartmentText;
    }

    public void setAddDepartmentText(JTextField addDepartmentText) {
        this.addDepartmentText = addDepartmentText;
    }

    public JTextField getAddMajorText() {
        return addMajorText;
    }

    public void setAddMajorText(JTextField addMajorText) {
        this.addMajorText = addMajorText;
    }

    public JTextField getAddSexText() {
        return addSexText;
    }

    public void setAddSexText(JTextField addSexText) {
        this.addSexText = addSexText;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }
}

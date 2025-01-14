package obProject.graph;
import javax.swing.*;
import java.awt.*;
public class UpdateCourse_Panel extends JPanel{
    private JTextField addCidText=new JTextField(10);//待加入的cid区域
    private JTextField addNameText=new JTextField(10);//待加入的name区域
    private JTextField addCreditText=new JTextField(10);
    private JTextField addTypeText=new JTextField(10);
    private JTextField addDepartmentText=new JTextField(10);
    private JTextField addTargetText=new JTextField(10);
    private JTextField addWeekdayText=new JTextField(10);
    private JTextField addSectionText=new JTextField(10);
    private JTextField addCampusText=new JTextField(10);
    private JTextField addRoomText=new JTextField(10);
    private JButton identityButton=new JButton("查找");
    private JButton updateButton=new JButton("更新");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";

    private JLabel operation=new JLabel("此时您进行的操作是 更改课程信息");
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
        getAddCidText().setBounds(280,150,190,40);
        getAddNameText().setBounds(280,210,190,38);
        getAddCreditText().setBounds(280,270,190,38);
        getAddTypeText().setBounds(280,330,190,38);
        getAddDepartmentText().setBounds(280,390,190,38);

        getAddTargetText().setBounds(780,150,190,40);
        getAddWeekdayText().setBounds(780,210,190,38);
        getAddSectionText().setBounds(780,270,190,38);
        getAddCampusText().setBounds(780,330,190,38);
        getAddRoomText().setBounds(780,390,190,38);


        JLabel addCidLabel=new JLabel("待查询课程编号");
        JLabel addNameLabel=new JLabel("课程名称");
        JLabel addCreditLabel=new JLabel("课程学分");
        JLabel addTypeLabel=new JLabel("课程类型");
        JLabel addDepartmentLabel=new JLabel("课程所属院系");
        JLabel addTargetLabel=new JLabel("课程授课目标学院");
        JLabel addWeekdayLabel=new JLabel("课程上课星期");
        JLabel addSectionLabel=new JLabel("课程上课节次");
        JLabel addCampusLabel=new JLabel("课程授课校区");
        JLabel addRoomLabel=new JLabel("课程授课教室");

        addCidLabel.setBounds(10,150,250,40);
        addCidLabel.setForeground(Color.WHITE);
        addCidLabel.setFont(font1);
        addCidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addNameLabel.setBounds(10,210,250,40);
        addNameLabel.setForeground(Color.WHITE);
        addNameLabel.setFont(font1);
        addNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addCreditLabel.setBounds(10,270,250,40);
        addCreditLabel.setForeground(Color.WHITE);
        addCreditLabel.setFont(font1);
        addCreditLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addTypeLabel.setBounds(10,330,250,40);
        addTypeLabel.setForeground(Color.WHITE);
        addTypeLabel.setFont(font1);
        addTypeLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addDepartmentLabel.setBounds(10,390,250,40);
        addDepartmentLabel.setForeground(Color.WHITE);
        addDepartmentLabel.setFont(font1);
        addDepartmentLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addTargetLabel.setBounds(510,150,250,40);
        addTargetLabel.setForeground(Color.WHITE);
        addTargetLabel.setFont(font1);
        addTargetLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addWeekdayLabel.setBounds(510,210,250,40);
        addWeekdayLabel.setForeground(Color.WHITE);
        addWeekdayLabel.setFont(font1);
        addWeekdayLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addSectionLabel.setBounds(510,270,250,40);
        addSectionLabel.setForeground(Color.WHITE);
        addSectionLabel.setFont(font1);
        addSectionLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addCampusLabel.setBounds(510,330,250,40);
        addCampusLabel.setForeground(Color.WHITE);
        addCampusLabel.setFont(font1);
        addCampusLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        addRoomLabel.setBounds(510,390,250,40);
        addRoomLabel.setForeground(Color.WHITE);
        addRoomLabel.setFont(font1);
        addRoomLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        //当前进行的操作提醒
        getOperation().setFont(font1);
        getOperation().setForeground(Color.WHITE);
        getOperation().setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,580,200,50);
        getIdentityButton().setFont(font_button);
        getUpdateButton().setBounds(700,580,200,50);
        getUpdateButton().setFont(font_button);


        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        //向panel中添加
        add(getOperation());
        add(identityButton);
        add(backButton);
        add(addNameText);
        add(addCidText);
        add(getUpdateButton());
        add(getAddDepartmentText());
        add(getAddCreditText());
        add(getAddTypeText());
        add(welcomeLabel);
        add(addCidLabel);
        add(addCreditLabel);
        add(addDepartmentLabel);
        add(addNameLabel);
        add(addTypeLabel);
        add(getAddTargetText());
        add(addTargetLabel);
        add(getAddWeekdayText());
        add(addWeekdayLabel);
        add(getAddSectionText());
        add(addSectionLabel);
        add(getAddCampusText());
        add(addCampusLabel);
        add(getAddRoomText());
        add(addRoomLabel);
    }


    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("更新成功!");
        JLabel defuseLabel=new JLabel("查找失败!");
        Font font=new Font("微软雅黑", Font.BOLD, 25);
        label.setFont(font);
        if(update!=0)
            dialog.add(label);
        else
            dialog.add(defuseLabel);
        // 显示对话框
        dialog.setVisible(true);
    }
    public JTextField getAddCidText() {
        return addCidText;
    }

    public void setAddCidText(JTextField addCidText) {
        this.addCidText = addCidText;
    }

    public JTextField getAddNameText() {
        return addNameText;
    }

    public void setAddNameText(JTextField addNameText) {
        this.addNameText = addNameText;
    }

    public JTextField getAddCreditText() {
        return addCreditText;
    }

    public void setAddCreditText(JTextField addCreditText) {
        this.addCreditText = addCreditText;
    }

    public JTextField getAddTypeText() {
        return addTypeText;
    }

    public void setAddTypeText(JTextField addTypeText) {
        this.addTypeText = addTypeText;
    }

    public JTextField getAddDepartmentText() {
        return addDepartmentText;
    }

    public void setAddDepartmentText(JTextField addDepartmentText) {
        this.addDepartmentText = addDepartmentText;
    }

    public JTextField getAddTargetText() {
        return addTargetText;
    }

    public void setAddTargetText(JTextField addTargetText) {
        this.addTargetText = addTargetText;
    }
    public JTextField getAddWeekdayText() {
        return addWeekdayText;
    }

    public void setAddWeekdayText(JTextField addWeekdayText) {
        this.addWeekdayText = addWeekdayText;
    }
    public JTextField getAddSectionText() {
        return addSectionText;
    }

    public void setAddSectionText(JTextField addSectionText) {
        this.addSectionText = addSectionText;
    }
    public JTextField getAddCampusText() {
        return addCampusText;
    }

    public void setAddCampusText(JTextField addCampusText) {
        this.addCampusText = addCampusText;
    }
    public JTextField getAddRoomText() {
        return addRoomText;
    }

    public void setAddRoomText(JTextField addRoomText) {
        this.addRoomText = addRoomText;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }



    public JLabel getOperation() {
        return operation;
    }

    public void setOperation(JLabel operation) {
        this.operation = operation;
    }
}

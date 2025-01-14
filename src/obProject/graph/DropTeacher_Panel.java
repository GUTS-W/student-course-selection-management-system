package obProject.graph;
import javax.swing.*;
import java.awt.*;
public class DropTeacher_Panel extends JPanel{
    private JTextField addTidText=new JTextField(10);//学号输入框
    private JButton identityButton=new JButton("确认");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    JLabel operation=new JLabel("此时您进行的操作是 删除教师信息");

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

        //标签及其摆放的位置
        JLabel addTidLabel=new JLabel("待删除教师编号");
        addTidLabel.setBounds(310,150,250,40);
        addTidLabel.setForeground(Color.WHITE);
        addTidLabel.setFont(font1);
        addTidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

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
    }

    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("删除成功!");
        JLabel defuseLabel=new JLabel("删除失败!");
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



    public JTextField getAddTidText() {
        return addTidText;
    }

    public void setAddTidText(JTextField addTidText) {
        this.addTidText = addTidText;
    }

}

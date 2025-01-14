package obProject.graph;
import obProject.entity.lecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import obProject.dao.impl.administratorsDaoImpl;
import obProject.dao.impl.teacherDaoImpl;
import obProject.entity.*;

public class ScoreInput_Panel extends JPanel{
    teacherDaoImpl t=new teacherDaoImpl();
    administratorsDaoImpl adm=new administratorsDaoImpl();
    private String path="";//表格的路径
    private JPanel tablePanel =new showTable_Panel(getPath(),"");//这个path也需要改变
    private JTextField cidText=new JTextField(10);//课程号输入框
    private JButton identityButton=new JButton("进入");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    private JLabel operation=new JLabel("此时您进行的操作是 成绩录入");
    public void init(){
        setLayout(null);
        String welcomeStatement="Hello 教师"+ getAccount();
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
        getCidText().setBounds(580,150,190,40);

        //标签及其摆放的位置
        JLabel cidLabel=new JLabel("课程号");
        cidLabel.setBounds(310,150,250,40);
        cidLabel.setForeground(Color.WHITE);
        cidLabel.setFont(font1);
        cidLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));

        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,400,200,50);
        getIdentityButton().setFont(font_button);
        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getIdentityButton());
        add(getBackButton());
        add(getIdentityButton());
        add(operation);
        add(welcomeLabel);
        add(cidLabel);
        add(cidText);

    }
    public void excute(){
        String cid=getCidText().getText();
        List<course_score> list=new ArrayList<>();
        list=t.select_by_cid(cid);
        showSearchCourseTable(list);
    }
    void showSearchCourseTable(List<course_score> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("成绩录入");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("课程号");
            model.addColumn("课程名");
            model.addColumn("学号");
            model.addColumn("分数");

            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                if(list.get(i).getScore()==0)
                    model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getSid()});
                else
                    model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getSid(),list.get(i).getScore()});
            }
            // 创建表格
            JTable table = new JTable(model);

            // 添加表格到滚动窗格
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);


            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // 在这里处理窗口关闭事件


                    int result = JOptionPane.showConfirmDialog(frame, "确定选择吗?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        for(int i=0;i<list.size();i++)
                        {
                            Object c=model.getValueAt(i,0);
                            Object s=model.getValueAt(i,2);
                            Object sco=model.getValueAt(i,3);
                            String sid=String.valueOf(s);
                            String cid=String.valueOf(c);
                            int score=Integer.parseInt(sco.toString());
                            t.update_grade(cid,sid,score);
                        }
                        /*// 如果用户点击了"是"，关闭应用程序
                        int update=1;

                        update=1;//需要对其进行修改，传参
                        indentityDialog(frame,update);//为了弹出对话框*/
                    }
                }
            });

        });
    }
    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("操作成功!");
        JLabel defuseLabel=new JLabel("操作失败!");
        Font font=new Font("微软雅黑", Font.BOLD, 25);
        label.setFont(font);
        if(update!=0)
            dialog.add(label);
        else
            dialog.add(defuseLabel);
        // 显示对话框
        dialog.setVisible(true);
    }
    public JTextField getCidText() {
        return cidText;
    }

    public void setCidText(JTextField cidText) {
        this.cidText = cidText;
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

    public JLabel getOperation() {
        return operation;
    }

    public void setOperation(JLabel operation) {
        this.operation = operation;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public JPanel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JPanel tablePanel) {
        this.tablePanel = tablePanel;
    }
}

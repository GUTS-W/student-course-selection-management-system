package obProject.graph;
import com.mysql.cj.xdevapi.Table;
import obProject.dao.impl.administratorsDaoImpl;
import obProject.dao.impl.studentDaoImpl;
import obProject.dao.impl.teacherDaoImpl;
import obProject.entity.*;
import obProject.util.Log;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AwardPunishApply_Panel extends JPanel{
    //JPanel tablePanel=new JPanel() ;//这个path也需要改变
    //=new showTable_Panel(path,"")
    JPanel panel=new JPanel();
    JPanel tablePanel=new JPanel();
    private JButton addButton=new JButton("奖励申请");
    private JButton backButton=new JButton("退出");
    private String account;
    String welcomeStatement="Hello 学生"+ getAccount();
    JLabel welcomeLabel=new JLabel(welcomeStatement);
    void setWelcome(){
        welcomeStatement="Hello 学生"+ getAccount();
        welcomeLabel.setText("");
        welcomeLabel.setText(welcomeStatement);
    }

    studentDaoImpl stu=new studentDaoImpl();
    administratorsDaoImpl adm=new administratorsDaoImpl();
    Logger logger= Log.getLogger();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    // 添加表格到滚动窗格
    JScrollPane scrollPane = new JScrollPane(table);
    public AwardPunishApply_Panel(){
        setLayout(null);
        welcomeLabel.setBounds(350,10,1000,35);
        Font font=new Font("楷体", Font.BOLD, 25);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(Color.BLACK);

        tablePanel.setLayout(null);
        scrollPane.setBounds(0,0,1000,500);

        tablePanel.add(scrollPane);
        tablePanel.setBounds(0,200,1000,500);

        panel.setLayout(null);
        panel.setBounds(0,0,1000,200);

        getAddButton().setBounds(100,50,200,50);


        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getAddButton().setFont(font_button);
        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        panel.add(welcomeLabel);
        panel.add(getAddButton());
        panel.add(getBackButton());

        add(panel);
        add(tablePanel);
    }



    void updateTabel(){
        // 创建表格
        // 移除所有行
        model.setRowCount(0);
        // 移除所有列名
        model.setColumnCount(0);

        List<reward_punishshment> list= new ArrayList<>();
        logger.debug("id为"+getAccount());
        list=stu.select_all_rp(getAccount());
        model.addColumn("类别");
        model.addColumn("奖惩等级");
        model.addColumn("奖惩名称");
        model.addColumn("审核状态");
        //model.addRow(new Object[]{"001","111"});
        for(int i=0;i<list.size();i++){
            model.addRow(new Object[]{list.get(i).getType(),list.get(i).getLevel(),
                    list.get(i).getName(), list.get(i).getIs_pass()});
        }


    }

    void addExecute(AddAwardApply_Panel addAwardApplyPanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        addAwardApplyPanel.init();
        cardLayout.show(root,"addAwaAppPanel");
        //
        addAwardApplyPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=addAwardApplyPanel.getApplyButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addAwardApplyPanel.getApplyButton().removeActionListener(listener);
                }
                cardLayout.show(root,"awaAppPanel");
            }
        });

        addAwardApplyPanel.getApplyButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String level=addAwardApplyPanel.getAddLevelText().getText();
                String name=addAwardApplyPanel.getAddNameText().getText();

                int update=0;
                update=stu.insert_reward(new reward_punishshment(getAccount(),level,"奖励",name,"待审核"));
                model.addRow(new Object[]{"奖励",level,
                        name,"待审核"});
                indentityDialog(frame,update);
            }
        });
    }
    //展示表格
//    JTable showSearchCourseTable(){
//        JPanel tablePanel1=new JPanel();
//        // 创建表格模型
//        DefaultTableModel model = new DefaultTableModel();
//        // 创建表格
//        JTable table = new JTable(model);
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("搜索的学生信息");
//
//
//
//
//            model.addColumn("学号");
//            model.addColumn("姓名");
//            model.addColumn("校区名称");
//            model.addColumn("学院名称");
//            model.addColumn("专业名称");
//            model.addColumn("生日");
//            model.addColumn("性别");
//            model.addColumn("年级");
//            model.addColumn("班级");
//            model.addColumn("身份证号");
//            // model.addRow(new Object[]{"001","111"});
//
//            // 添加数据到表格模型
////            for(int i=0;i<list.size();i++){
////                model.addRow(new Object[]{list.get(i).getSid(),list.get(i).getName(),list.get(i).getCampus(),
////                        list.get(i).getDepartment(),list.get(i).getMajor(),list.get(i).getBirthday(),list.get(i).getSex(),
////                        list.get(i).getGrade(),list.get(i).getClass_1(),list.get(i).getId()});
////            }
//
//
//
//
//
//            // 添加表格到滚动窗格
//            JScrollPane scrollPane = new JScrollPane(table);
//            // scrollPane.add(table);
//
//            tablePanel1.add(scrollPane);
//
//            frame.add(scrollPane, BorderLayout.CENTER);
//            frame.setSize(400, 300);
//            frame.setVisible(true);
//
//        });
//        return table;
//    }

    public void indentityDialog(JFrame frame,int update){
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(frame);

        // 添加内容到对话框
        JLabel label = new JLabel("申请成功!");
        JLabel defuseLabel=new JLabel("申请失败!");
        Font font=new Font("微软雅黑", Font.BOLD, 25);
        label.setFont(font);
        if(update!=0)
            dialog.add(label);
        else
            dialog.add(defuseLabel);
        // 显示对话框
        dialog.setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
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
}

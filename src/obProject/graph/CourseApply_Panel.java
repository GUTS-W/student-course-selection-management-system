package obProject.graph;
import com.mysql.cj.xdevapi.Table;
import obProject.dao.impl.administratorsDaoImpl;
import obProject.dao.impl.teacherDaoImpl;
import obProject.entity.*;
import obProject.util.Log;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseApply_Panel extends JPanel{
    private String path="";//表格的路径
    JPanel panel=new JPanel();
    JPanel tablePanel=new JPanel();
    private JButton addButton=new JButton("增加");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";

    teacherDaoImpl tea=new teacherDaoImpl();
    administratorsDaoImpl adm=new administratorsDaoImpl();
    String welcomeStatement="Hello 管理员"+ getAccount();
    JLabel welcomeLabel=new JLabel(welcomeStatement);
    DefaultTableModel model = new DefaultTableModel();
    // 创建表格
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    void setWelcome(){
        welcomeStatement="Hello 教师"+ getAccount();
        welcomeLabel.setText("");
        welcomeLabel.setText(welcomeStatement);
    }
    Logger logger= Log.getLogger();
    public void init(){
        setLayout(null);
       // String welcomeStatement="Hello 管理员"+ getAccount();

        welcomeLabel.setBounds(350,10,1000,35);
        Font font=new Font("楷体", Font.BOLD, 25);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(Color.BLACK);

        //scrollPane.add(table);
        /*int columnCount = table.getColumnCount();

        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            TableColumn column = table.getColumnModel().getColumn(columnIndex);
            column.setPreferredWidth(50);
        }*/
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

        panel.add(getAddButton());
        panel.add(getBackButton());
        panel.add(welcomeLabel);

        add(panel);
        add(tablePanel);


    }
    void showTable(){
        // 移除所有行
        model.setRowCount(0);

        // 移除所有列名
        model.setColumnCount(0);



        List<lecture> list= new ArrayList<>();
        logger.debug("id为"+getAccount());
        list=tea.select_course(getAccount());

        model.addColumn("课程编号");
        model.addColumn("课程名称");
        model.addColumn("课程学分");
        model.addColumn("课程类型");
        model.addColumn("所属院系");
        model.addColumn("目标学院");
        model.addColumn("上课星期");
        model.addColumn("上课节次");
        model.addColumn("上课校区");
        model.addColumn("上课教室");
        model.addColumn("审核状态");
        //model.addRow(new Object[]{"001","111"});
        for(int i=0;i<list.size();i++){
            model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getCredit(),
                    list.get(i).getType(),list.get(i).getDepartment(),list.get(i).getTarget_department(),
                    list.get(i).getWeekday(), list.get(i).getSession(),list.get(i).getCampus(),
                    list.get(i).getBuilding(),list.get(i).getApproval()});
        }
        // 添加表格到滚动窗格


    }


    void addExecute(AddCourseApply_Panel addCourseApplyPanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        addCourseApplyPanel.init();
        cardLayout.show(root,"addCouAppPanel");
        //
        addCourseApplyPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=addCourseApplyPanel.getApplyButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addCourseApplyPanel.getApplyButton().removeActionListener(listener);
                }
                cardLayout.show(root,"couAppPanel");
                //cardLayout.show(root,"addInsPanel");
            }
        });

        addCourseApplyPanel.getApplyButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String cid=addCourseApplyPanel.getAddCidText().getText();
                String name=addCourseApplyPanel.getAddNameText().getText();
                String credit=addCourseApplyPanel.getAddCreditText().getText();
                String type=addCourseApplyPanel.getAddTypeText().getText();
                String department=addCourseApplyPanel.getAddDepartmentText().getText();
                String target=addCourseApplyPanel.getAddTargetText().getText();
                String weekday=addCourseApplyPanel.getAddWeekdayText().getText();
                String section=addCourseApplyPanel.getAddSectionText().getText();
                String campus=addCourseApplyPanel.getAddCampusText().getText();
                String room=addCourseApplyPanel.getAddRoomText().getText();
                department d1=adm.select_a_department_by_name(department);
                department d2=adm.select_a_department_by_name(target);
                String rid=adm.select_rid(campus,room);
                int update=0;
                if(d1!=null && rid!=null){
                    if(d2!=null)
                        update=tea.insert_course(new course(cid,d1.getDepartment_id(),Integer.parseInt(credit),name,type,d2.getDepartment_id()),
                            new course_time(cid,Integer.parseInt(weekday),Integer.parseInt(section)),
                            new lecture(getAccount(),cid,department,Integer.parseInt(credit),name,type,target,
                                    null,"待审核",Integer.parseInt(weekday),Integer.parseInt(section),rid,campus,room));
                    else
                        update=tea.insert_course(new course(cid,d1.getDepartment_id(),Integer.parseInt(credit),name,type,null),
                                new course_time(cid,Integer.parseInt(weekday),Integer.parseInt(section)),
                                new lecture(getAccount(),cid,department,Integer.parseInt(credit),name,type,target,
                                        null,"待审核",Integer.parseInt(weekday),Integer.parseInt(section),rid,campus,room));
                }
                indentityDialog(frame,update);
                showTable();
            }
        });
    }
////展示表格
//JTable showSearchCourseTable(){
//        JPanel tablePanel1=new JPanel();
//    // 创建表格模型
//    DefaultTableModel model = new DefaultTableModel();
//    // 创建表格
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
//           // model.addRow(new Object[]{"001","111"});
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
//           // scrollPane.add(table);
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
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

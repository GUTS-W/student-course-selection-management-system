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
import obProject.dao.impl.studentDaoImpl;

public class SelectCourse_Panel extends JPanel{
    administratorsDaoImpl adm=new administratorsDaoImpl();
    studentDaoImpl stu=new studentDaoImpl();
    private CheckboxTable_Panel tablePanel;//这个位置需要接下来set
    private JTextField nameText = new JTextField(10);
    private JButton identityButton=new JButton("查找输入课程");
    private JButton withdrawButton=new JButton("退课");
    private JButton identityAllButton=new JButton("查找全部课程");
    private JButton backButton=new JButton("退出");
    private String account="深水先生";
    private JLabel operation=new JLabel("此时您进行的操作是 选课操作");
    public void init(){
        setLayout(null);
        String welcomeStatement="Hello 学生"+ getAccount();
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

        getNameText().setBounds(520,180,190,38);

        JLabel preNameLabel=new JLabel("待查找课程编号");
        preNameLabel.setBounds(260,180,230,40);
        preNameLabel.setForeground(Color.WHITE);
        preNameLabel.setFont(font1);
        preNameLabel.setBorder(BorderFactory.createLineBorder(borderColor,3));


        //当前进行的操作提醒
        operation.setFont(font1);
        operation.setForeground(Color.WHITE);
        operation.setBounds(260,65,500,40);

        //确认按钮
        Font font_button=new Font("微软雅黑",Font.TRUETYPE_FONT,25);
        getIdentityButton().setBounds(420,400,200,50);
        getIdentityButton().setFont(font_button);
        getIdentityAllButton().setBounds(700,400,200,50);
        getIdentityAllButton().setFont(font_button);

        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        //退课按钮
        getWithdrawButton().setBounds(120,400,200,50);
        getWithdrawButton().setFont(font_button);

        add(getWithdrawButton());
        add(getIdentityAllButton());
        add(getBackButton());
        add(getIdentityButton());
        add(operation);
        add(welcomeLabel);
        add(getNameText());
        add(preNameLabel);
    }

    public void excute(){
        String cid=getNameText().getText();
        List<lecture> list=new ArrayList<>();
        lecture l=adm.select_a_course_by_cid(cid);
        list.add(l);
        showSearchCourseTable(list);
    }
    public void excuteAll(){
        String cid=getNameText().getText();
        String sid=account;
        List<lecture> list=null;
        list=stu.select_ALL_course(account);
        showSearchCourseAllTable(list);
    }
    public void withdrawExcute(){
        String sid=account;
        List<lecture> list=null;
        list=stu.select_courses_chose(account);
        showWithdrawTable(list);
    }

    public void showWithdrawTable(List<lecture> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("全部的课程信息");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("课程号");
            model.addColumn("课程名");
            model.addColumn("开设学院");
            model.addColumn("教师名");
            model.addColumn("目标学院");
            model.addColumn("上课星期");
            model.addColumn("上课节次");
            model.addColumn("课程类别");
            model.addColumn("授课校区");
            model.addColumn("授课教室");
            // model.addColumn("是否通过");
            model.addColumn("是否退课"); // 用于放置复选框

            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getDepartment(),
                        list.get(i).getTname(),list.get(i).getTarget_department(),list.get(i).getWeekday(),list.get(i).getSession(),
                        list.get(i).getType(),list.get(i).getCampus(),list.get(i).getBuilding()});
            }
            // 创建表格
            JTable table = new JTable(model);
            // 在表格中的每一行增加复选框
            TableColumn checkboxColumn = table.getColumnModel().getColumn(10);//10
            checkboxColumn.setCellRenderer(new Admin_course_Panel.CheckboxRenderer());
            checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

            // 添加表格到滚动窗格
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // 在这里处理窗口关闭事件
                    int result = JOptionPane.showConfirmDialog(frame, "确定退课吗?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        // 如果用户点击了"是"，关闭应用程序
                        int update=1;
                        //下面用来返回每一行的主码和最后复选框的内容,其他位置搬运，具体情况具体分析
                        //选课部分需要判断是否有课程冲突
                        int ifSelect[]=new int[list.size()];//返回boolean类型的
                        String cidSelect[]=new String[list.size()];//返回每一行的主码
                        int temp=0;
                        for(int i=0;i<list.size();i++){
                            if(model.getValueAt(i,10)!=null){
                                if((boolean) model.getValueAt(i, 10)){
                                    ifSelect[i]=1;
                                    temp++;
                                }
                                else
                                    ifSelect[i]=-1;
                            }else{
                                ifSelect[i]=0;
                            }
                            cidSelect[i]= (String) model.getValueAt(i,0);
                        }
                        for(int i=0;i<list.size();i++){
                            if(ifSelect[i]==1){
                                update &= stu.delete_course_chosen(account,cidSelect[i]);
                            }
                        }
//                        if(update==1)
//                            logger.debug("success");
//                        else
//                            logger.debug("failure");

                        indentityDialog(frame,update);
                    }
                }
            });

        });
    }
    void showSearchCourseTable(List<lecture> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("全部的课程信息");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("课程号");
            model.addColumn("课程名");
            model.addColumn("开设学院");
            model.addColumn("教师名");
            model.addColumn("目标学院");
            model.addColumn("上课星期");
            model.addColumn("上课节次");
            model.addColumn("课程类别");
            model.addColumn("授课校区");
            model.addColumn("授课教室");
            model.addColumn("是否冲突");
           // model.addColumn("是否通过");
            model.addColumn("是否选择"); // 用于放置复选框
            List<lecture> select_list=new ArrayList<>();
            select_list=stu.select_courses_chose(account);
            int tag[]=new int [36];
            for(int i=0;i<select_list.size();i++){
                tag[select_list.get(i).getWeekday()*5+select_list.get(i).getSession()-5]=1;
            }
            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                if(tag[list.get(i).getWeekday()*5+list.get(i).getSession()-5]==0)
                    model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getDepartment(),
                            list.get(i).getTname(),list.get(i).getTarget_department(),list.get(i).getWeekday(),list.get(i).getSession(),
                            list.get(i).getType(),list.get(i).getCampus(),list.get(i).getBuilding(),""});
                else
                    model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getDepartment(),
                            list.get(i).getTname(),list.get(i).getTarget_department(),list.get(i).getWeekday(),list.get(i).getSession(),
                            list.get(i).getType(),list.get(i).getCampus(),list.get(i).getBuilding(),"冲突"});
            }
            // 创建表格
            JTable table = new JTable(model);
            // 在表格中的每一行增加复选框
            TableColumn checkboxColumn = table.getColumnModel().getColumn(11);//10
            checkboxColumn.setCellRenderer(new Admin_course_Panel.CheckboxRenderer());
            checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

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
                        // 如果用户点击了"是"，关闭应用程序
                        int update=1;
                        //下面用来返回每一行的主码和最后复选框的内容,其他位置搬运，具体情况具体分析
                        //选课部分需要判断是否有课程冲突
                        int ifSelect[]=new int[list.size()];//返回boolean类型的
                        String cidSelect[]=new String[list.size()];//返回每一行的主码
                        int weekSelect[]=new int[list.size()];
                        int sectionSelect[]=new int[list.size()];
                        int temp=0;
                        for(int i=0;i<list.size();i++){
                            if(model.getValueAt(i,11)!=null){
                                if((boolean) model.getValueAt(i, 11)){
                                    ifSelect[i]=1;
                                    temp++;
                                }
                                else
                                    ifSelect[i]=-1;
                            }else{
                                ifSelect[i]=0;
                            }
                            cidSelect[i]= (String) model.getValueAt(i,0);
                            weekSelect[i]=Integer.parseInt(String.valueOf(model.getValueAt(i,5)));
                            sectionSelect[i]=Integer.parseInt(String.valueOf(model.getValueAt(i,6)));
                        }
                        update=1;
                        if(temp>=36){
                            update=0;
                            indentityDialog(frame,update);
                            return;
                        }
                        int num=0;
                        int a[]=new int[36];
                        for(int i=0;i<list.size();i++){
                            if(ifSelect[i]==1){
                                int time=(weekSelect[i])*5+sectionSelect[i]-5;
                                for(int j=0;j<num;j++){
                                    if(a[j]==time){
                                        update=0;
                                        break;
                                    }
                                }
                                if(update!=0){
                                    a[num]=time;
                                    num++;
                                }else{
                                    break;
                                }
                            }
                        }
                        if(update!=0){
                            for(int i=0;i<list.size();i++){
                                if(ifSelect[i]==1){
                                    update &= stu.insert_course(account,cidSelect[i]);
                                }
                            }
                        }
//                        if(update==1)
//                            logger.debug("success");
//                        else
//                            logger.debug("failure");

                        indentityDialog(frame,update);
                    }
                }
            });

        });
    }
    void showSearchCourseAllTable(List<lecture> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("全部的课程信息");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("课程号");
            model.addColumn("课程名");
            model.addColumn("开设学院");
            model.addColumn("教师名");
            model.addColumn("目标学院");
            model.addColumn("上课星期");
            model.addColumn("上课节次");
            model.addColumn("课程类别");
            model.addColumn("授课校区");
            model.addColumn("授课教室");
            model.addColumn("是否冲突");
            model.addColumn("是否选择"); // 用于放置复选框

            List<lecture> select_list=new ArrayList<>();
            select_list=stu.select_courses_chose(account);
            int tag[]=new int [36];
            for(int i=0;i<select_list.size();i++){
                tag[select_list.get(i).getWeekday()*5+select_list.get(i).getSession()-5]=1;
            }
            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                if(tag[list.get(i).getWeekday()*5+list.get(i).getSession()-5]==0)
                    model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getDepartment(),
                            list.get(i).getTname(),list.get(i).getTarget_department(),list.get(i).getWeekday(),list.get(i).getSession(),
                            list.get(i).getType(),list.get(i).getCampus(),list.get(i).getBuilding(),""});
                else
                    model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getDepartment(),
                            list.get(i).getTname(),list.get(i).getTarget_department(),list.get(i).getWeekday(),list.get(i).getSession(),
                            list.get(i).getType(),list.get(i).getCampus(),list.get(i).getBuilding(),"冲突"});
            }
            // 创建表格
            JTable table = new JTable(model);
            // 在表格中的每一行增加复选框
            TableColumn checkboxColumn = table.getColumnModel().getColumn(11);//10
            checkboxColumn.setCellRenderer(new Admin_course_Panel.CheckboxRenderer());
            checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

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
                        // 如果用户点击了"是"，关闭应用程序
                        int update=1;
                        //下面用来返回每一行的主码和最后复选框的内容,其他位置搬运，具体情况具体分析
                        //选课部分需要判断是否有课程冲突
                        int ifSelect[]=new int[list.size()];//返回boolean类型的
                        String cidSelect[]=new String[list.size()];//返回每一行的主码
                        int weekSelect[]=new int[list.size()];
                        int sectionSelect[]=new int[list.size()];
                        int temp=0;
                        for(int i=0;i<list.size();i++){
                            if(model.getValueAt(i,11)!=null){
                                if((boolean) model.getValueAt(i, 11)){
                                    ifSelect[i]=1;
                                    temp++;
                                }
                                else
                                    ifSelect[i]=-1;
                            }else{
                                ifSelect[i]=0;
                            }
                            cidSelect[i]= (String) model.getValueAt(i,0);
                            weekSelect[i]=Integer.parseInt(String.valueOf(model.getValueAt(i,5)));
                            sectionSelect[i]=Integer.parseInt(String.valueOf(model.getValueAt(i,6)));
                        }
                        update=1;
                        if(temp>=36){
                            update=0;
                            indentityDialog(frame,update);
                            return;
                        }
                        int num=0;
                        int a[]=new int[36];
                        for(int i=0;i<list.size();i++){
                            if(ifSelect[i]==1){
                                int time=(weekSelect[i])*5+sectionSelect[i]-5;
                                for(int j=0;j<num;j++){
                                    if(a[j]==time){
                                        update=0;
                                        break;
                                    }
                                }
                                if(update!=0){
                                    a[num]=time;
                                    num++;
                                }else{
                                    break;
                                }
                            }
                        }
                        if(update!=0){
                            for(int i=0;i<list.size();i++){
                                if(ifSelect[i]==1){
                                    update &= stu.insert_course(account,cidSelect[i]);
                                }
                            }
                        }
//                        if(update==1)
//                            logger.debug("success");
//                        else
//                            logger.debug("failure");

                        indentityDialog(frame,update);
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
    public JTextField getNameText() {
        return nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JButton getIdentityButton() {
        return identityButton;
    }

    public void setIdentityButton(JButton identityButton) {
        this.identityButton = identityButton;
    }

    public JButton getIdentityAllButton() {
        return identityAllButton;
    }

    public void setIdentityAllButton(JButton identityAllButton) {
        this.identityAllButton = identityAllButton;
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

    public CheckboxTable_Panel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(CheckboxTable_Panel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JButton getWithdrawButton() {
        return withdrawButton;
    }

    public void setWithdrawButton(JButton withdrawButton) {
        this.withdrawButton = withdrawButton;
    }
}

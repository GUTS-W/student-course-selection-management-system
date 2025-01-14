package obProject.graph;


import obProject.dao.impl.administratorsDaoImpl;
import obProject.dao.impl.teacherDaoImpl;
import obProject.entity.*;
import obProject.util.Log;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class Admin_course_Panel extends JPanel{
    private JLabel search_label = new JLabel("  查看课程信息");
    private JLabel drop_label = new JLabel("  删除课程信息");
    private JLabel update_label = new JLabel("  更新课程信息");
    private JLabel add_label = new JLabel("  审批课程信息");
    private JButton backButton=new JButton("退出");
    private String account;
    administratorsDaoImpl adm=new administratorsDaoImpl();
    teacherDaoImpl tea=new teacherDaoImpl();
    Logger logger= Log.getLogger();
    public Admin_course_Panel(){}

    public void init(){
        setLayout(null);
        String welcomeStatement="Hello 管理员"+ getAccount();
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

        getSearch_label().setBounds(680,80,225,40);
        getSearch_label().setForeground(Color.WHITE);
        getSearch_label().setFont(font1);
        // 设置边框
        getSearch_label().setBorder(BorderFactory.createLineBorder(borderColor,3));

        getDrop_label().setBounds(680,160,225,40);
        getDrop_label().setForeground(Color.WHITE);
        getDrop_label().setFont(font1);
        getDrop_label().setBorder(BorderFactory.createLineBorder(borderColor,3));

        getUpdate_label().setBounds(680,240,225,40);
        getUpdate_label().setForeground(Color.WHITE);
        getUpdate_label().setFont(font1);
        getUpdate_label().setBorder(BorderFactory.createLineBorder(borderColor,3));

        getAdd_label().setBounds(680,320,225,40);
        getAdd_label().setForeground(Color.WHITE);
        getAdd_label().setFont(font1);
        getAdd_label().setBorder(BorderFactory.createLineBorder(borderColor,3));



        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getBackButton());
        add(welcomeLabel);
        add(getSearch_label());
        add(getDrop_label());
        add(getUpdate_label());
        add(getAdd_label());
    }

    //审批课程的信息
    void addExecute(AddCourse_Panel addCoursePanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        addCoursePanel.setAccount(account);
        addCoursePanel.init();
        cardLayout.show(root,"addCouPanel");

        addCoursePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String dname=addCoursePanel.getAddNameText().getText();
                department d=adm.select_a_department_by_name(dname);
                List<lecture> list=new ArrayList<>();
                if(d==null)
                    list=adm.select_wait_course(null);
                else
                    list=adm.select_wait_course(d.getDepartment_id());
                showCheckboxTable(list);
            }
        });

        addCoursePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=addCoursePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addCoursePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminCouPanel");

            }
        });
    }
    void searchExecute(SearchCourse_Panel searchCoursePanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        searchCoursePanel.setAccount(account);
        searchCoursePanel.init();
        cardLayout.show(root,"seaCouPanel");

        searchCoursePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String cid=searchCoursePanel.getAddNameText().getText();
                lecture lec=adm.select_a_course_by_cid(cid);
                showSearchACourseTable(lec);

            }
        });

        searchCoursePanel.getIdentityAllButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                List<lecture> list=new ArrayList<>();
                list=adm.select_ALL_course();
                showSearchCourseAllTable(list);
            }
        });

        searchCoursePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=searchCoursePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    searchCoursePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminCouPanel");


            }
        });
    }

    void updateExecute(UpdateCourse_Panel updateCoursePanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        updateCoursePanel.setAccount(account);
        updateCoursePanel.init();
        cardLayout.show(root,"upCouPanel");

        updateCoursePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //查找的院系姓名
                String cid=updateCoursePanel.getAddCidText().getText();
                lecture lec=adm.select_a_course_by_cid(cid);
                updateCoursePanel.getAddNameText().setText(lec.getCname());
                updateCoursePanel.getAddCreditText().setText(String.valueOf(lec.getCredit()));
                updateCoursePanel.getAddTypeText().setText(lec.getType());
                updateCoursePanel.getAddDepartmentText().setText(lec.getDepartment());
                updateCoursePanel.getAddTargetText().setText(lec.getTarget_department());
                updateCoursePanel.getAddWeekdayText().setText(String.valueOf(lec.getWeekday()));
                updateCoursePanel.getAddSectionText().setText(String.valueOf(lec.getSession()));
                updateCoursePanel.getAddCampusText().setText(lec.getCampus());
                updateCoursePanel.getAddRoomText().setText(lec.getBuilding());

            }
        });

        updateCoursePanel.getUpdateButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String cid=updateCoursePanel.getAddCidText().getText();
                String name=updateCoursePanel.getAddNameText().getText();
                String department=updateCoursePanel.getAddDepartmentText().getText();
                String type=updateCoursePanel.getAddTypeText().getText();
                String credit=updateCoursePanel.getAddCreditText().getText();
                String target=updateCoursePanel.getAddTargetText().getText();
                String weekday=updateCoursePanel.getAddWeekdayText().getText();
                String section=updateCoursePanel.getAddSectionText().getText();
                String campus=updateCoursePanel.getAddCampusText().getText();
                String room=updateCoursePanel.getAddRoomText().getText();
                lecture lec=adm.select_a_course_by_cid(cid);
                lec.setCname(name);
                lec.setDepartment(department);
                lec.setType(type);
                lec.setTarget_department(target);
                lec.setWeekday(Integer.parseInt(weekday));
                lec.setSession(Integer.parseInt(section));
                lec.setCampus(campus);
                lec.setBuilding(room);
                obProject.entity.department d1=adm.select_a_department_by_name(department);
                department d2=adm.select_a_department_by_name(target);
                int update=0;
                if(d1!=null){
                    if(d2!=null)
                        update=adm.update_course(new course(cid,d1.getDepartment_id(),Integer.parseInt(credit),name,type,d2.getDepartment_id())
                                ,new course_time(lec.getCid(), lec.getWeekday(), lec.getSession())
                                ,lec);
                    else
                        update=adm.update_course(new course(cid,d1.getDepartment_id(),Integer.parseInt(credit),name,type,null)
                                ,new course_time(lec.getCid(), lec.getWeekday(), lec.getSession())
                                ,lec);
                }
                updateCoursePanel.indentityDialog(frame,update);
            }
        });

        updateCoursePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=updateCoursePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    updateCoursePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminCouPanel");

            }
        });

    }
    void dropExecute(DropCourse_Panel dropCoursePanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        dropCoursePanel.setAccount(account);
        dropCoursePanel.init();
        cardLayout.show(root,"droCouPanel");

        dropCoursePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String Cid=dropCoursePanel.getAddCidText().getText();
                int update=adm.delete_course(Cid);
                dropCoursePanel.indentityDialog(frame,update);


            }
        });

        dropCoursePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=dropCoursePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    dropCoursePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminCouPanel");

            }
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
            model.addColumn("是否通过");

            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getDepartment(),
                list.get(i).getTname(),list.get(i).getTarget_department(),list.get(i).getWeekday(),list.get(i).getSession(),
                list.get(i).getType(),list.get(i).getCampus(),list.get(i).getBuilding(),list.get(i).getApproval()});
            }
            // 创建表格
            JTable table = new JTable(model);


            // 添加表格到滚动窗格
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);

        });
    }


    void showSearchACourseTable(lecture lec){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("搜索的课程信息");

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
            model.addColumn("是否通过");

            // 添加数据到表格模型
            model.addRow(new Object[]{lec.getCid(),lec.getCname(),lec.getDepartment(),
                    lec.getTname(),lec.getTarget_department(),lec.getWeekday(),lec.getSession(),
                    lec.getType(),lec.getCampus(),lec.getBuilding(),lec.getApproval()});

            // 创建表格
            JTable table = new JTable(model);


            // 添加表格到滚动窗格
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);

        });
    }





    void showCheckboxTable(List<lecture> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("待审批的课程序列");

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
            model.addColumn("是否通过"); // 用于放置复选框

             //添加数据到表格模型
            for(int i=0;i<list.size();i++){
                model.addRow(new Object[]{list.get(i).getCid(),list.get(i).getCname(),list.get(i).getDepartment(),
                        list.get(i).getTname(),list.get(i).getTarget_department(),list.get(i).getWeekday(),list.get(i).getSession(),
                        list.get(i).getType(),list.get(i).getCampus(),list.get(i).getBuilding()});
            }

            // 创建表格
            JTable table = new JTable(model);

            // 在表格中的每一行增加复选框
            TableColumn checkboxColumn = table.getColumnModel().getColumn(10);//10
            checkboxColumn.setCellRenderer(new CheckboxRenderer());
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
                    int result = JOptionPane.showConfirmDialog(frame, "确定进行修改吗?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        // 如果用户点击了"是"，关闭应用程序
                        //System.exit(0);
                       // model.getValueAt(5,0);
                        int ifSelect[]=new int[list.size()];//返回boolean类型的
                        String cidSelect[]=new String[list.size()];//返回每一行的主码
                        for(int i=0;i<list.size();i++){
                            if(model.getValueAt(i,10)!=null){
                                if((boolean) model.getValueAt(i, 10))
                                    ifSelect[i]=1;
                                else
                                    ifSelect[i]=-1;
                            }else{
                                ifSelect[i]=0;
                            }
                            cidSelect[i]= (String) model.getValueAt(i,0);
                        }
                        int update=1;
                        for(int i=0;i<list.size();i++){
                            if(ifSelect[i]==1){
                                update &=adm.course_pass(cidSelect[i]);
                            }else if(ifSelect[i]==-1){
                                update &=adm.course_not_pass(cidSelect[i]);
                            }
                        }
                        if(update==1)
                            logger.debug("success");
                        else
                            logger.debug("failure");
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
    // 自定义渲染器用于显示复选框
    static class CheckboxRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                return checkBox;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    public JLabel getSearch_label() {
        return search_label;
    }

    public void setSearch_label(JLabel search_label) {
        this.search_label = search_label;
    }

    public JLabel getDrop_label() {
        return drop_label;
    }

    public void setDrop_label(JLabel drop_label) {
        this.drop_label = drop_label;
    }

    public JLabel getUpdate_label() {
        return update_label;
    }

    public void setUpdate_label(JLabel update_label) {
        this.update_label = update_label;
    }

    public JLabel getAdd_label() {
        return add_label;
    }

    public void setAdd_label(JLabel add_label) {
        this.add_label = add_label;
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

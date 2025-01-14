package obProject.graph;

import obProject.dao.impl.administratorsDaoImpl;
import obProject.entity.department;
import obProject.entity.student_information;
import obProject.entity.teacher;
import obProject.util.ExcelWriter;
import obProject.util.Log;
import org.apache.log4j.Logger;
import obProject.graph.showTable;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Admin_teacher_Panel extends JPanel{
    private JLabel search_label = new JLabel("  查找教师信息");
    private JLabel drop_label = new JLabel("  删除教师信息");
    private JLabel update_label = new JLabel("  更新教师信息");
    private JLabel add_label = new JLabel("  增加教师信息");
    private JButton backButton=new JButton("退出");
    private String account;

    administratorsDaoImpl adm=new administratorsDaoImpl();
    static Logger logger= Log.getLogger();
    public Admin_teacher_Panel(){}
    void init(){


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

    //增加一个教师的信息
    void addExecute(AddTeacher_Panel addTeacherPanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        addTeacherPanel.setAccount(account);
        addTeacherPanel.init();
        cardLayout.show(root,"addTeaPanel");
        addTeacherPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String addName=addTeacherPanel.getAddNameText().getText();
                String addTid=addTeacherPanel.getAddTidText().getText();
                String addDepartment=addTeacherPanel.getAddDepartmentText().getText();
                String addSex=addTeacherPanel.getAddSexText().getText();
                String addAge=addTeacherPanel.getAddAgeText().getText();
                logger.debug("接收的姓名为"+addName+" Tid为"+addTid+" 学院为"+addDepartment+" 性别为"+addSex+" 年龄为"+addAge);
                department d=adm.select_a_department_by_name(addDepartment);
                int update;
                if(d==null)
                    update=0;
                else
                    update=adm.insert_teacher(new teacher(addTid,d.getDepartment_id(),Integer.parseInt(addAge),addName,addTid,addSex,addDepartment));
                addTeacherPanel.indentityDialog(frame,update);
            }
        });

        addTeacherPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=addTeacherPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addTeacherPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminTeaPanel");

            }
        });
    }

    void updateExecute(UpdateTeacher_Panel updateTeacherPanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        updateTeacherPanel.setAccount(account);
        updateTeacherPanel.init();
        cardLayout.show(root,"upTeaPanel");

        updateTeacherPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String Tid=updateTeacherPanel.getAddTidText().getText();
                teacher tea=adm.select_a_teacher(Tid);
                int update=0;
                if (tea != null) {
                    updateTeacherPanel.getAddDepartmentText().setText(tea.getDepartment());
                    updateTeacherPanel.getAddAgeText().setText(String.valueOf(tea.getAge()));
                    updateTeacherPanel.getAddSexText().setText(tea.getSex());
                    updateTeacherPanel.getAddNameText().setText(tea.getName());
                    update=1;
                }
                updateTeacherPanel.indentityDialog(frame,update);
            }
        });
        updateTeacherPanel.getUpdateButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //更新后的教师姓名
                String Tid=updateTeacherPanel.getAddTidText().getText();
                String name=updateTeacherPanel.getAddNameText().getText();
                String deparment_name=updateTeacherPanel.getAddDepartmentText().getText();
                String age=updateTeacherPanel.getAddAgeText().getText();
                String sex=updateTeacherPanel.getAddSexText().getText();
                teacher btea=adm.select_a_teacher(Tid);
                department d=adm.select_a_department_by_name(deparment_name);
                int update=0;
                if(d!=null && btea!=null){
                    teacher tea=new teacher(Tid,d.getDepartment_id(),Integer.parseInt(age),name,btea.getPassword(),sex,deparment_name);
                    adm.update_teacher(tea);
                    update=1;
                }
                updateTeacherPanel.indentityDialog(frame,update);
            }
        });


        updateTeacherPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=updateTeacherPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    updateTeacherPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminTeaPanel");

            }
        });

    }

    void dropExecute(DropTeacher_Panel dropTeacherPanel,CardLayout cardLayout,JPanel root,
                     JFrame frame){
        dropTeacherPanel.setAccount(account);
        dropTeacherPanel.init();
        cardLayout.show(root,"dropTeaPanel");

        dropTeacherPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String Tid=dropTeacherPanel.getAddTidText().getText();
                int update=adm.delete_teacher(Tid);
                dropTeacherPanel.indentityDialog(frame,update);
            }
        });

        dropTeacherPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=dropTeacherPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    dropTeacherPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminTeaPanel");

            }
        });
    }

    void searchExecute(SearchTeacher_Panel searchTeacherPanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        searchTeacherPanel.setAccount(account);
        searchTeacherPanel.init();
        cardLayout.show(root,"searchTeaPanel");

        searchTeacherPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //对于没有输入的情况是接收为null
                String Tid=searchTeacherPanel.getAddTidText().getText();
                String name=searchTeacherPanel.getAddNameText().getText();
                String department=searchTeacherPanel.getAddDepartmentText().getText();

                List<teacher> list = new ArrayList<>();
                if(Objects.equals(Tid, "") && Objects.equals(name, "") && Objects.equals(department, ""))
                    list=adm.select_ALL_teacher();
                else if(!Objects.equals(Tid, "")){
                    teacher teacher1=adm.select_a_teacher(Tid);
                    if(teacher1!=null)
                        list.add(teacher1);
                } else if(!Objects.equals(name, ""))
                    list=adm.select_byname_teacher(name);
                else
                    list=adm.select_bydepartment_teacher(department);
                showSearchTeacherTable(list);
//                Workbook workbook= ExcelWriter.openWorkBook();
//                Sheet sheet=ExcelWriter.openSheet(workbook);
//                teacher.WriteTitle(sheet);
//                for(int i=0;i<list.size();i++)
//                    list.get(i).WriteARow(sheet,i+1);
//                ExcelWriter.fileOut(workbook,System.getProperty("user.dir")+"\\src\\obProject\\img\\a.xlsx");
//                logger.debug("成功写入Excel");
//
//                //路径待加入
//                new showTable(cardLayout,root,System.getProperty("user.dir")+"\\src\\obProject\\img\\a.xlsx","查找教师信息界面");
                //searchStudentPanel.indentityDialog(frame,1);
            }
        });

        searchTeacherPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=searchTeacherPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    searchTeacherPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminTeaPanel");

            }
        });
    }



    void showSearchTeacherTable(List<teacher> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("搜索的教师信息");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("教工编号");
            model.addColumn("姓名");
            model.addColumn("年龄");
            model.addColumn("学院名称");
            model.addColumn("性别");


            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                model.addRow(new Object[]{list.get(i).getTid(),list.get(i).getName(),list.get(i).getAge(),
                        list.get(i).getDepartment(),list.get(i).getSex()});
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



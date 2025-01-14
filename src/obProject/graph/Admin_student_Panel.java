package obProject.graph;

import obProject.dao.impl.administratorsDaoImpl;
import obProject.dao.impl.studentDaoImpl;
import obProject.entity.information_of_department_and_major;
import obProject.entity.institution;
import obProject.entity.student;
import obProject.entity.student_information;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Admin_student_Panel extends JPanel{
    private JLabel search_label = new JLabel("  查找学生信息");
    private JLabel drop_label = new JLabel("  删除学生信息");
    private JLabel update_label = new JLabel("  更新学生信息");
    private JLabel add_label = new JLabel("  增加学生信息");
    private JButton backButton=new JButton("退出");
    private String account;

    administratorsDaoImpl adm=new administratorsDaoImpl();
    static Logger logger= Log.getLogger();
    public Admin_student_Panel(){}
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

    //增加一个学生的信息
    void addExecute(AddStudent_Panel addStudentPanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        addStudentPanel.setAccount(account);
        addStudentPanel.init();
        cardLayout.show(root,"addStuPanel");
        addStudentPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String addID=addStudentPanel.getAddIDText().getText();
                String addName=addStudentPanel.getAddNameText().getText();
                String addSid=addStudentPanel.getAddSidText().getText();
                String addDepartment=addStudentPanel.getAddDepartmentText().getText();
                String addBirth=addStudentPanel.getAddBirthdayText().getText();
                String addSex=addStudentPanel.getAddSexText().getText();
                String addMajor=addStudentPanel.getAddMajorText().getText();
                String addCampus=addStudentPanel.getAddCampusText().getText();
                String grade=addStudentPanel.getAddGradeText().getText();
                String class1=addStudentPanel.getAddClassText().getText();
                logger.debug("接收的ID为"+addID+" Name"+addName+" Sid"+addSid+" Department"+addDepartment+" birthday"+addBirth+" sex"+addSex+" major"+addMajor);
                SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
                Date date= null;
                try {
                    date = ft.parse(addBirth);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                logger.debug("获得的专业MID为"+adm.get_major_id(addDepartment,addMajor));
                int update=adm.insert_student(new student(addSid,addID,date,addName,addSex,addSid),new institution(addCampus,adm.get_major_id(addDepartment,addMajor),grade,class1,addSid));
                addStudentPanel.indentityDialog(frame,update);
            }
        });

        addStudentPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=addStudentPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addStudentPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminStuPanel");

            }
        });
    }

    void updateExecute(UpdateStudent_Panel updateStudentPanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        updateStudentPanel.setAccount(account);
        updateStudentPanel.init();
        cardLayout.show(root,"upStuPanel");

        updateStudentPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String Sid=updateStudentPanel.getAddSidText().getText();
                student_information stu_info=adm.select_a_studnet(Sid);
                int update=1;
                if(stu_info==null)
                    update=0;
                if(update==1){
                    SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
                    //下面为带输入的值
                    updateStudentPanel.getAddBirthdayText().setText(ft.format(stu_info.getBirthday()));
                    updateStudentPanel.getAddDepartmentText().setText(stu_info.getDepartment());
                    updateStudentPanel.getAddMajorText().setText(stu_info.getMajor());
                    updateStudentPanel.getAddSexText().setText(stu_info.getSex());
                    updateStudentPanel.getAddIDText().setText(stu_info.getId());
                    updateStudentPanel.getAddNameText().setText(stu_info.getName());
                }
                updateStudentPanel.indentityDialog(frame,update);
            }
        });

        updateStudentPanel.getUpdateButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //更新后的教师姓名
                String Sid=updateStudentPanel.getAddSidText().getText();
                student_information stu_info=adm.select_a_studnet(Sid);
                if(stu_info==null){
                    updateStudentPanel.indentityDialog(frame,0);
                    return;
                }

                String birthday=updateStudentPanel.getAddBirthdayText().getText();
                String department=updateStudentPanel.getAddDepartmentText().getText();
                String major=updateStudentPanel.getAddMajorText().getText();
                String sex=updateStudentPanel.getAddSexText().getText();
                String ID=updateStudentPanel.getAddIDText().getText();
                String name=updateStudentPanel.getAddNameText().getText();
                SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    stu_info.setBirthday(ft.parse(birthday));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                stu_info.setDepartment(department);
                stu_info.setMajor(major);
                stu_info.setSex(sex);
                stu_info.setId(ID);
                stu_info.setName(name);
                student stu=new student(stu_info.getSid(),stu_info.getId(),stu_info.getBirthday(),stu_info.getName(),stu_info.getSex(),stu_info.getSid());
                institution ins=new institution(stu_info.getCampus(),adm.get_major_id(stu_info.getDepartment(),stu_info.getMajor()),stu_info.getGrade(),stu_info.getClass_1(),stu_info.getSid());
                int update1=adm.update_student_basic(stu);
                int update2=adm.update_student_insititution(ins);
                updateStudentPanel.indentityDialog(frame,update1 | update2);
            }
        });

        updateStudentPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=updateStudentPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    updateStudentPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminStuPanel");

            }
        });

    }

    void dropExecute(DropStudent_Panel dropStudentPanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        dropStudentPanel.setAccount(account);
        dropStudentPanel.init();
        cardLayout.show(root,"dropStuPanel");

        dropStudentPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String Sid=dropStudentPanel.getAddSidText().getText();
                int update=adm.delete_student(Sid);
                dropStudentPanel.indentityDialog(frame,update);
            }
        });

        dropStudentPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=dropStudentPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    dropStudentPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminStuPanel");

            }
        });
    }

    void searchExecute(SearchStudent_Panel searchStudentPanel,CardLayout cardLayout,JPanel root,
                     JFrame frame){
        searchStudentPanel.setAccount(account);
        searchStudentPanel.init();
        cardLayout.show(root,"searchStuPanel");

        searchStudentPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //对于没有输入的情况是接收为null
                String Sid=searchStudentPanel.getAddSidText().getText();
                String name=searchStudentPanel.getAddNameText().getText();
                String department=searchStudentPanel.getAddDepartmentText().getText();
                String major=searchStudentPanel.getAddMajorText().getText();
                logger.debug("Sid="+Sid+" name="+name+" department="+department+" major="+major);
                List<student_information> list = new ArrayList<>();
                if(Objects.equals(Sid, "") && Objects.equals(name, "") && Objects.equals(department, "") && Objects.equals(major, ""))
                    list=adm.select_ALL_student();
                else if(!Objects.equals(Sid, "")){
                    student_information student1=adm.select_a_studnet(Sid);
                    if(student1!=null)
                        list.add(student1);
                } else if(!Objects.equals(name, ""))
                    list=adm.select_byname_student(name);
                else if(!Objects.equals(department, ""))
                    list=adm.select_bydept_student(department);
                else
                    list=adm.select_bymajor_student(major);
                showSearchStudentTable(list);
                //searchStudentPanel.indentityDialog(frame,update);
            }
        });

        searchStudentPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=searchStudentPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    searchStudentPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminStuPanel");

            }
        });
    }

    void showSearchStudentTable(List<student_information> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("搜索的学生信息");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("学号");
            model.addColumn("姓名");
            model.addColumn("校区名称");
            model.addColumn("学院名称");
            model.addColumn("专业名称");
            model.addColumn("生日");
            model.addColumn("性别");
            model.addColumn("年级");
            model.addColumn("班级");
            model.addColumn("身份证号");


            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                model.addRow(new Object[]{list.get(i).getSid(),list.get(i).getName(),list.get(i).getCampus(),
                list.get(i).getDepartment(),list.get(i).getMajor(),list.get(i).getBirthday(),list.get(i).getSex(),
                list.get(i).getGrade(),list.get(i).getClass_1(),list.get(i).getId()});
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



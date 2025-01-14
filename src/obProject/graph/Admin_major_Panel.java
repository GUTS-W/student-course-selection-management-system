package obProject.graph;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import obProject.dao.impl.administratorsDaoImpl;
import obProject.entity.department;
import obProject.entity.department_major;
import obProject.entity.information_of_department_and_major;
import obProject.entity.lecture;
import obProject.util.ExcelWriter;
import obProject.util.Log;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Admin_major_Panel extends JPanel{

    private JLabel search_label = new JLabel("  查找专业");
    private JLabel drop_label = new JLabel("  删除专业");
    private JLabel update_label = new JLabel("  更新专业");
    private JLabel add_label = new JLabel("  增加专业");
    private JButton backButton=new JButton("退出");
    private String account;

    administratorsDaoImpl adm=new administratorsDaoImpl();
    static Logger logger= Log.getLogger();
    public Admin_major_Panel(){

    }
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

        getSearch_label().setBounds(750,80,160,40);
        getSearch_label().setForeground(Color.WHITE);
        getSearch_label().setFont(font1);
        // 设置边框
        getSearch_label().setBorder(BorderFactory.createLineBorder(borderColor,3));

        getDrop_label().setBounds(750,160,160,40);
        getDrop_label().setForeground(Color.WHITE);
        getDrop_label().setFont(font1);
        getDrop_label().setBorder(BorderFactory.createLineBorder(borderColor,3));

        getUpdate_label().setBounds(750,240,160,40);
        getUpdate_label().setForeground(Color.WHITE);
        getUpdate_label().setFont(font1);
        getUpdate_label().setBorder(BorderFactory.createLineBorder(borderColor,3));

        getAdd_label().setBounds(750,320,160,40);
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


    void dropExecute(DropMajor_Panel dropMajorPanel,CardLayout cardLayout,JPanel root,
                     JFrame frame){
        dropMajorPanel.setAccount(account);
        dropMajorPanel.init();
        cardLayout.show(root,"droMajPanel");
        dropMajorPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //要删除的专业,接口
                String departmentName=dropMajorPanel.getDepartmentNameText().getText();
                String dropName=dropMajorPanel.getDropNameText().getText();
                logger.debug("接收的学院名称为"+departmentName+" 接收的专业名称为"+dropName);
                department d=adm.select_a_department_by_name(departmentName);
                int update;
                if(d==null)
                    update=0;
                else
                    update=adm.delete_major(dropName,d.getDepartment_id());
                dropMajorPanel.indentityDialog(frame,update);
            }
        });
        dropMajorPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=dropMajorPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    dropMajorPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminMajPanel");
                //cardLayout.show(root,"addInsPanel");
            }
        });

    }

    void addExecute(AddMajor_Panel addMajorPanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        addMajorPanel.setAccount(account);
        addMajorPanel.init();
        cardLayout.show(root,"addMajPanel");
        addMajorPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String departmentName=addMajorPanel.getDepartmentNameText().getText();
                String addID=addMajorPanel.getAddIDText().getText();
                String addName=addMajorPanel.getAddNameText().getText();
                logger.debug("接收的学院名称为"+departmentName+" 接收的专业id为"+addID+" 接收的学院名称为"+addName);
                int update=adm.insert_major(new department_major(addID,adm.select_a_department_by_name(departmentName).getDepartment_id(),addName));
                addMajorPanel.indentityDialog(frame,update);
            }
        });
        addMajorPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //frame.getContentPane().remove(addInstitutePanel);
                ActionListener[] listeners=addMajorPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addMajorPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminMajPanel");

                //cardLayout.show(root,"addInsPanel");
            }
        });


    }

    void updateExecute(UpdateMajor_Panel updateMajorPanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        updateMajorPanel.setAccount(account);
        updateMajorPanel.init();
        cardLayout.show(root,"upMajPanel");
        updateMajorPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //待更新的name与更新后端name
                String departmentName=updateMajorPanel.getDepartmentNameText().getText();
                String oldName=updateMajorPanel.getPreNameText().getText();
                String addName=updateMajorPanel.getAddNameText().getText();
                logger.debug("接收的学院为"+departmentName+" 接收的原专业名称为"+oldName+" 接收的现专业名称为"+addName);
                department d=adm.select_a_department_by_name(departmentName);
                int update;
                if(d==null)
                    update=0;
                else
                    update=adm.update_major(d.getDepartment_id(),oldName,addName);
                updateMajorPanel.indentityDialog(frame,update);
            }
        });
        updateMajorPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=updateMajorPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    updateMajorPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminMajPanel");
                //cardLayout.show(root,"addInsPanel");
            }
        });

    }
    void searchExecute(SearchMajor_Panel searchMajorPanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        searchMajorPanel.setAccount(account);
        searchMajorPanel.init();
        cardLayout.show(root,"seaMajPanel");
        searchMajorPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name=searchMajorPanel.getSearchNameText().getText();//待查询的id
                logger.debug("接收的学院名称为"+name);
                List<information_of_department_and_major> list=adm.select_information_department_and_mojor(name);
                showSearchMajorTable(list);
                searchMajorPanel.indentityDialog(frame,1);
            }
        });
        searchMajorPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=searchMajorPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    searchMajorPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminMajPanel");
                //cardLayout.show(root,"addInsPanel");
            }
        });

    }


    void showSearchMajorTable(List<information_of_department_and_major> list){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("搜索的专业信息");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("学院名称");
            model.addColumn("专业名称");


            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                model.addRow(new Object[]{list.get(i).getDepartment(),list.get(i).getMajor()});
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
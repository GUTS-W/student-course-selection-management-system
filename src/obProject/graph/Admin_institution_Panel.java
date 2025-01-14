package obProject.graph;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import obProject.dao.impl.administratorsDaoImpl;
import obProject.entity.department;
import obProject.util.Log;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_institution_Panel extends JPanel{

    private JLabel search_label = new JLabel("  查找院系");
    private JLabel drop_label = new JLabel("  删除院系");
    private JLabel update_label = new JLabel("  更新院系");
    private JLabel add_label = new JLabel("  增加院系");
    private JButton backButton=new JButton("退出");
    private String account;

    administratorsDaoImpl adm=new administratorsDaoImpl();
    static Logger logger= Log.getLogger();
    public Admin_institution_Panel(){

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


    void dropExecute(DropInstitute_Panel dropInstitutePanel,CardLayout cardLayout,JPanel root,
                     JFrame frame){
        dropInstitutePanel.setAccount(account);
        dropInstitutePanel.init();
        cardLayout.show(root,"droInsPanel");
        dropInstitutePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //要删除的院系名称,接口
                String dropName=dropInstitutePanel.getAddNameText().getText();
                logger.debug("接收的学院名称为"+dropName);
                int update=adm.delete_department(dropName);
                dropInstitutePanel.indentityDialog(frame,update);
            }
        });
        dropInstitutePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=dropInstitutePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    dropInstitutePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminInsPanel");
                //cardLayout.show(root,"addInsPanel");
            }
        });

    }

    void addExecute(AddInstitute_Panel addInstitutePanel,CardLayout cardLayout,JPanel root,
                    JFrame frame){
        addInstitutePanel.setAccount(account);
        addInstitutePanel.init();
        cardLayout.show(root,"addInsPanel");
        addInstitutePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String addID=addInstitutePanel.getAddIDText().getText();
                String addName=addInstitutePanel.getAddNameText().getText();
                logger.debug("接收的学院ID为"+addID+" 接收的学院名称为"+addName);
                int update=adm.insert_department(new department(addID,addName));
                 addInstitutePanel.indentityDialog(frame,update);
            }
        });
        addInstitutePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //frame.getContentPane().remove(addInstitutePanel);
                ActionListener[] listeners=addInstitutePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addInstitutePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminInsPanel");

                //cardLayout.show(root,"addInsPanel");
            }
        });


    }

    void updateExecute(UpdateInstitute_Panel updateInstitutePanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        updateInstitutePanel.setAccount(account);
        updateInstitutePanel.init();
        cardLayout.show(root,"upInsPanel");
        updateInstitutePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //待更新的name与更新后端name
                String name=updateInstitutePanel.getPreNameText().getText();
                String addName=updateInstitutePanel.getAddNameText().getText();
                logger.debug("接收的原学院ID为"+name+" 接收的现学院名称为"+addName);
                int update=adm.update_department(name,addName);
                updateInstitutePanel.indentityDialog(frame,update);
            }
        });
        updateInstitutePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=updateInstitutePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    updateInstitutePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminInsPanel");
                //cardLayout.show(root,"addInsPanel");
            }
        });

    }
    void searchExecute(SearchInstitute_Panel searchInstitutePanel,CardLayout cardLayout,JPanel root,
                       JFrame frame){
        searchInstitutePanel.setAccount(account);
        searchInstitutePanel.init();
        cardLayout.show(root,"seaInsPanel");
        searchInstitutePanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String id=searchInstitutePanel.getSearchIDText().getText();//待查询的id
                logger.debug("接收的待查询学院ID为"+id);
                department d=adm.select_a_department(id);
                if(d==null){
                    searchInstitutePanel.indentityDialog(frame,0);
                    searchInstitutePanel.getSearchNameText().setText("");
                }else{
                    String name=d.getDepartment_name();
                    logger.debug("查询的学院名称为"+name);
                    searchInstitutePanel.indentityDialog(frame,1);
                    searchInstitutePanel.getSearchNameText().setText(name);
                }
            }
        });
        searchInstitutePanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=searchInstitutePanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    searchInstitutePanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminInsPanel");
                //cardLayout.show(root,"addInsPanel");
            }
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

    public String getAccount() {return account;}

    public void setAccount(String account) {
        this.account = account;
    }
}
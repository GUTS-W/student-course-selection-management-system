package obProject.graph;


import obProject.dao.impl.administratorsDaoImpl;
import obProject.entity.reward_punishshment;
import obProject.util.Log;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class Admin_rp_Panel extends JPanel{
    private JLabel drop_label = new JLabel("  审批奖惩信息");
    private JLabel add_label = new JLabel("  新增奖惩信息");
    private JButton backButton=new JButton("退出");
    private String account;

    administratorsDaoImpl adm=new administratorsDaoImpl();
    Logger logger= Log.getLogger();
    public Admin_rp_Panel(){}

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


        // 设置边框

        getDrop_label().setBounds(680,80,225,40);
        getDrop_label().setForeground(Color.WHITE);
        getDrop_label().setFont(font1);
        getDrop_label().setBorder(BorderFactory.createLineBorder(borderColor,3));


        getAdd_label().setBounds(680,160,225,40);
        getAdd_label().setForeground(Color.WHITE);
        getAdd_label().setFont(font1);
        getAdd_label().setBorder(BorderFactory.createLineBorder(borderColor,3));



        //退出按钮
        getBackButton().setBounds(850,10,120,30);

        add(getBackButton());
        add(welcomeLabel);
        add(getDrop_label());
        add(getAdd_label());
    }



    void addExecute(AddRP_Panel addRPPanel,CardLayout cardLayout,JPanel root,
                     JFrame frame){
        addRPPanel.setAccount(account);
        addRPPanel.init();
        cardLayout.show(root,"addRpPanel");

        addRPPanel.getIdentityButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String sid=addRPPanel.getAddSidText().getText();
                String name=addRPPanel.getAddNameText().getText();
                String type=addRPPanel.getAddTypeText().getText();
                String level=addRPPanel.getAddLevelText().getText();
                int update=adm.insert_rp(new reward_punishshment(sid,level,type,name,"通过"));
                addRPPanel.indentityDialog(frame,update);


            }
        });

        addRPPanel.getBackButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ActionListener[] listeners=addRPPanel.getIdentityButton().getActionListeners();
                for (ActionListener listener : listeners) {
                    addRPPanel.getIdentityButton().removeActionListener(listener);
                }
                cardLayout.show(root,"adminRpPanel");

            }
        });

    }


    void showCheckboxTable(){
        //传输的参数
        //String[] cid,String[] Cname,String[] credit,int[] type,String[] department
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("待审批的奖惩申请");

            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel();
//            model.addColumn("课程号");
//            model.addColumn("课程姓名");
//            model.addColumn("课程学分");
//            model.addColumn("课程类型");
//            model.addColumn("所属学院");
//            model.addColumn("是否通过"); // 用于放置复选框
            model.addColumn("学号");
            model.addColumn("类别");
            model.addColumn("等级");
            model.addColumn("名称");
            model.addColumn("是否通过");

            List<reward_punishshment> list=new ArrayList<>();
            list=adm.select_wait_rp();
            // 添加数据到表格模型
            for(int i=0;i<list.size();i++){
                model.addRow(new Object[]{list.get(i).getSid(),list.get(i).getType(),list.get(i).getLevel(),list.get(i).getName()});
            }
            // 创建表格
            JTable table = new JTable(model);

            // 在表格中的每一行增加复选框
            TableColumn checkboxColumn = table.getColumnModel().getColumn(4);
            checkboxColumn.setCellRenderer(new CheckboxRenderer());
            checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

            // 添加表格到滚动窗格
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);


            List<reward_punishshment> finalList = list;
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // 在这里处理窗口关闭事件
                    int result = JOptionPane.showConfirmDialog(frame, "确定要通过这些申请吗?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        int ifSelect[]=new int[finalList.size()];//返回boolean类型的
                        String sidSelect[]=new String[finalList.size()];//返回每一行的主码
                        String nameSelect[]=new String[finalList.size()];
                        String typeSelect[]=new String[finalList.size()];
                        String levelSelect[]=new String[finalList.size()];
                        for(int i = 0; i< finalList.size(); i++){
                            if(model.getValueAt(i,4)!=null){
                                if((boolean) model.getValueAt(i, 4))
                                    ifSelect[i]=1;
                                else
                                    ifSelect[i]=-1;
                            }else{
                                ifSelect[i]=0;
                            }
                            sidSelect[i]= (String) model.getValueAt(i,0);
                            typeSelect[i]=(String) model.getValueAt(i,1);
                            levelSelect[i]=(String) model.getValueAt(i,2);
                            nameSelect[i]=(String) model.getValueAt(i,3);
                        }
                        int update=1;
                        for(int i = 0; i< finalList.size(); i++){
                            if(ifSelect[i]==1){
                                update &=adm.rp_pass(sidSelect[i],levelSelect[i],nameSelect[i],typeSelect[i]);
                            }else if(ifSelect[i]==-1){
                                update &=adm.rp_not_pass(sidSelect[i],levelSelect[i],nameSelect[i],typeSelect[i]);
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



    public JLabel getDrop_label() {
        return drop_label;
    }

    public void setDrop_label(JLabel drop_label) {
        this.drop_label = drop_label;
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

package obProject.graph;

import obProject.dao.impl.administratorsDaoImpl;
import obProject.dao.impl.studentDaoImpl;
import obProject.dao.impl.teacherDaoImpl;
import obProject.entity.student_information;
import obProject.util.JdbcConnection;
import obProject.util.Log;
import org.apache.log4j.Logger;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Layout_overall
{
    static Logger logger= Log.getLogger();
    administratorsDaoImpl adm=new administratorsDaoImpl();
    studentDaoImpl stu=new studentDaoImpl();
    teacherDaoImpl tea=new teacherDaoImpl();
    public  Layout_overall(){
        SwingUtilities.invokeLater(() -> {
            // 创建主窗体
            JFrame stream_frame=new JFrame("学生选课管理信息系统");
            stream_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            stream_frame.setLocation(250,75);
            stream_frame.setSize(1000,700);

            // 创建使用CardLayout的面板
            JPanel root=new JPanel(new CardLayout());

            // 创建三个页面，并添加到cardPanel
            Login_Panel login_panel = new Login_Panel(stream_frame);
            //Student_Menu_Panel studentMenuPanel=new Student_Menu_Panel();
            //Teacher_Menu_Panel teacherMenuPanel=new Teacher_Menu_Panel();
            //Admin_Menu_Panel adminMenuPanel=new Admin_Menu_Panel();
            CourseApply_Panel courseApplyPanel=new CourseApply_Panel();
            AwardPunishApply_Panel awardPunishApplyPanel=new AwardPunishApply_Panel();
            RemakeMana_Panel remakeManaPanel=new RemakeMana_Panel();
            Student_Menu_Panel studentMenuPanel=new Student_Menu_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\5.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Teacher_Menu_Panel teacherMenuPanel=new Teacher_Menu_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\5.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Admin_Menu_Panel adminMenuPanel=new Admin_Menu_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\5.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            //管理课程模块的界面
            Admin_course_Panel adminCoursePanel=new Admin_course_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            //管理院系模块的界面
            Admin_institution_Panel adminInstitutionPanel=new Admin_institution_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            //管理学生模块的界面
            Admin_student_Panel adminStudentPanel=new Admin_student_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            //管理教师模块的界面
            Admin_teacher_Panel adminTeacherPanel=new Admin_teacher_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            //管理专业模块的界面
            Admin_major_Panel adminMajorPanel=new Admin_major_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            //管理奖惩模块的界面
            Admin_rp_Panel adminRPPanel=new Admin_rp_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            DropInstitute_Panel dropInstitutePanel= new DropInstitute_Panel() {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            AddInstitute_Panel addInstitutePanel=new AddInstitute_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            UpdateInstitute_Panel updateInstitutePanel=new UpdateInstitute_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            SearchInstitute_Panel searchInstitutePanel=new SearchInstitute_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            DropMajor_Panel dropMajorPanel= new DropMajor_Panel() {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            AddMajor_Panel addMajorPanel=new AddMajor_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            UpdateMajor_Panel updateMajorPanel=new UpdateMajor_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            SearchMajor_Panel searchMajorPanel=new SearchMajor_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            AddStudent_Panel addStudentPanel=new AddStudent_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            UpdateStudent_Panel updateStudentPanel=new UpdateStudent_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            DropStudent_Panel dropStudentPanel=new DropStudent_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            SearchStudent_Panel searchStudentPanel=new SearchStudent_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            AddCourse_Panel addCoursePanel=new AddCourse_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            SearchCourse_Panel searchCoursePanel=new SearchCourse_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            UpdateCourse_Panel updateCoursePanel=new UpdateCourse_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            DropCourse_Panel dropCoursePanel=new DropCourse_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            AddTeacher_Panel addTeacherPanel=new AddTeacher_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            UpdateTeacher_Panel updateTeacherPanel=new UpdateTeacher_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            DropTeacher_Panel dropTeacherPanel=new DropTeacher_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            SearchTeacher_Panel searchTeacherPanel=new SearchTeacher_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            AddRP_Panel addRPPanel=new AddRP_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            //老师申请课程
            AddCourseApply_Panel addCourseApplyPanel=new AddCourseApply_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            StudentInfo_Panel studentInfoPanel=new StudentInfo_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            SelectCourse_Panel selectCoursePanel=new SelectCourse_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            ScoreInput_Panel scoreInputPanel=new ScoreInput_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            //学生申请奖励
            AddAwardApply_Panel addAwardApplyPanel=new AddAwardApply_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            RemakeApply_Panel remakeApplyPanel=new RemakeApply_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            AddRemake_Panel addRemakePanel=new AddRemake_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            SearchScore_Panel searchScorePanel=new SearchScore_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            RevisePassword_Panel revisePasswordPanel=new RevisePassword_Panel(){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 读取图片文件并绘制到 JPanel 上作为背景
                    try {
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\obProject\\img\\back1.jpg"));
                        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };







            root.add(login_panel, "Page 1");
            root.add(studentMenuPanel, "studentMenu");
            root.add(teacherMenuPanel,"teacherMenu");
            root.add(adminMenuPanel,"adminMenu");
            root.add(adminCoursePanel,"adminCouPanel");
            root.add(adminInstitutionPanel, "adminInsPanel");
            root.add(adminStudentPanel,"adminStuPanel");
            root.add(adminTeacherPanel,"adminTeaPanel");
            root.add(adminMajorPanel,"adminMajPanel");
            root.add(adminRPPanel,"adminRpPanel");
            root.add(dropInstitutePanel,"droInsPanel");
            root.add(addInstitutePanel,"addInsPanel");
            root.add(updateInstitutePanel,"upInsPanel");
            root.add(searchInstitutePanel,"seaInsPanel");
            root.add(dropMajorPanel,"droMajPanel");
            root.add(addMajorPanel,"addMajPanel");
            root.add(updateMajorPanel,"upMajPanel");
            root.add(searchMajorPanel,"seaMajPanel");
            root.add(addStudentPanel,"addStuPanel");
            root.add(updateStudentPanel,"upStuPanel");
            root.add(dropStudentPanel,"dropStuPanel");
            root.add(searchStudentPanel,"searchStuPanel");
            root.add(addCoursePanel,"addCouPanel");
            root.add(searchCoursePanel,"seaCouPanel");
            root.add(updateCoursePanel,"upCouPanel");
            root.add(dropCoursePanel,"droCouPanel");
            root.add(addTeacherPanel,"addTeaPanel");
            root.add(updateTeacherPanel,"upTeaPanel");
            root.add(dropTeacherPanel,"dropTeaPanel");
            root.add(searchTeacherPanel,"searchTeaPanel");
            root.add(addRPPanel,"addRpPanel");
            root.add(courseApplyPanel,"couAppPanel");
            root.add(addCourseApplyPanel,"addCouAppPanel");
            root.add(remakeManaPanel,"remakeManaPanel");
            root.add(studentInfoPanel,"stuInfPanel");
            root.add(selectCoursePanel,"selCouPanel");
            root.add(scoreInputPanel,"scoInpPanel");
            root.add(awardPunishApplyPanel,"awaAppPanel");
            root.add(addAwardApplyPanel,"addAwaAppPanel");
            root.add(remakeApplyPanel,"remAppPanel");
            root.add(addRemakePanel,"addRemPanel");
            root.add(searchScorePanel,"seaScoPanel");
            root.add(revisePasswordPanel,"revPasPanel");

            courseApplyPanel.init();//开课申请的初始化
            remakeApplyPanel.init();
            revisePasswordPanel.init();//更改修改密码界面的初始化
            JButton login_button=new Login_Button().getLoginButton();
            login_panel.add(login_button);
            CardLayout cardLayout = (CardLayout) root.getLayout();
            //点击修改密码
            login_panel.getReviseLabel().addMouseListener(new MouseListener(){
                public void mouseClicked(MouseEvent e) {
                    login_panel.getReviseLabel().setForeground(Color.BLUE);
                    cardLayout.show(root,"revPasPanel");
                    //点击退回按钮
                    revisePasswordPanel.getBackButton().addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            ActionListener[] listeners=revisePasswordPanel.getIdentityButton().getActionListeners();
                            for (ActionListener listener : listeners) {
                                revisePasswordPanel.getIdentityButton().removeActionListener(listener);
                            }
                            revisePasswordPanel.getIdText().setText("");
                            revisePasswordPanel.getIndenPasswordText().setText("");
                            revisePasswordPanel.getPasswordText().setText("");
                            revisePasswordPanel.getRevisePasswordText().setText("");
                            cardLayout.show(root,"Page 1");
                        }
                    });
                    //点击确认按钮
                    revisePasswordPanel.getIdentityButton().addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String id=revisePasswordPanel.getIdText().getText();
                            String password=revisePasswordPanel.getPassWord();
                            String revisePassword=revisePasswordPanel.getRevisePassWord();
                            String indenPassword=revisePasswordPanel.getIndenPassword();
                            String type=revisePasswordPanel.getType();
                            //接口
                            int update=1;
                            if(Objects.equals(type, "学生")){
                                String bPass=stu.select_password(id);
                                if(Objects.equals(bPass, password) && Objects.equals(revisePassword, indenPassword)){
                                    update=stu.revise_password(id,revisePassword);
                                }else
                                    update=0;
                            }else if(Objects.equals(type, "教师")){
                                String bPass=tea.select_password(id);
                                if(Objects.equals(bPass, password) && Objects.equals(revisePassword, indenPassword)){
                                    update=tea.revise_password(id,revisePassword);
                                }else
                                    update=0;
                            }else{
                                String bPass=adm.select_password(id);
                                if(Objects.equals(bPass, password) && Objects.equals(revisePassword, indenPassword)){
                                    update=adm.revise_password(id,revisePassword);
                                }else
                                    update=0;
                            }
                            revisePasswordPanel.indentityDialog(stream_frame,update);
                        }
                    });

                }
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });

            login_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String password= login_panel.getPassWord();
                    String type= login_panel.getType();
                    String account= login_panel.getAccount();

                    exe(type,logger,account,password,cardLayout,login_panel);
                    if(type.equals("学生")) {
                        studentMenuPanel.setAccount(account);
                        studentMenuPanel.init();
                        cardLayout.show(root, "studentMenu");
                        //点击退出按钮
                        studentMenuPanel.getBackButton().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                ActionListener[] listeners=studentMenuPanel.getSyllabus_button().getActionListeners();
                                for (ActionListener listener : listeners) {
                                    studentMenuPanel.getSyllabus_button().removeActionListener(listener);
                                }
                                cardLayout.show(root,"Page 1");
                                login_panel.getText_account().setText("");
                                login_panel.getText_password().setText("");
                            }
                        });
                        //进入个人信息管理界面
                        studentMenuPanel.getInfo_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                studentInfoPanel.setAccount(account);
                                studentInfoPanel.init();
                                cardLayout.show(root,"stuInfPanel");
                                student_information stu_info=adm.select_a_studnet(studentInfoPanel.getAccount());
                                studentInfoPanel.getSidText().setText(stu_info.getSid());
                                studentInfoPanel.getNameText().setText(stu_info.getName());
                                studentInfoPanel.getSexText().setText(stu_info.getSex());
                                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                                studentInfoPanel.getBirthdayText().setText(ft.format(stu_info.getBirthday()));
                                studentInfoPanel.getCampusText().setText(stu_info.getCampus());
                                studentInfoPanel.getClassText().setText(stu_info.getClass_1());
                                studentInfoPanel.getDepartmentText().setText(stu_info.getDepartment());
                                studentInfoPanel.getIDText().setText(stu_info.getId());
                                studentInfoPanel.getGradeText().setText(stu_info.getGrade());
                                studentInfoPanel.getMajorText().setText(stu_info.getMajor());


                                //点击退回按钮
                                studentInfoPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=studentInfoPanel.getIdentityButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            studentInfoPanel.getIdentityButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"studentMenu");
                                    }
                                });
                               /* //点击编辑按钮
                                studentInfoPanel.getIdentityButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                    }
                                });*/
                            }
                        });
                        //进入选课界面
                        studentMenuPanel.getSelect_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                selectCoursePanel.setAccount(account);
                                selectCoursePanel.init();
                                cardLayout.show(root,"selCouPanel");
                                //点击退回按钮
                                selectCoursePanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=selectCoursePanel.getIdentityButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            selectCoursePanel.getIdentityButton().removeActionListener(listener);
                                        }
                                        ActionListener[] listeners2=selectCoursePanel.getIdentityAllButton().getActionListeners();
                                        for (ActionListener listener : listeners2) {
                                            selectCoursePanel.getIdentityAllButton().removeActionListener(listener);
                                        }
                                        ActionListener[] listeners3=selectCoursePanel.getWithdrawButton().getActionListeners();
                                        for (ActionListener listener : listeners3) {
                                            selectCoursePanel.getWithdrawButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"studentMenu");
                                    }
                                });
                                //点击查找按钮
                                selectCoursePanel.getIdentityButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        selectCoursePanel.excute();

                                    }
                                });
                                //查找全部
                                selectCoursePanel.getIdentityAllButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        selectCoursePanel.excuteAll();
                                    }
                                });
                                //点击退课
                                selectCoursePanel.getWithdrawButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        selectCoursePanel.withdrawExcute();
                                    }
                                });
                            }
                        });
                        //进入奖惩界面
                        studentMenuPanel.getAwardPublish_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                awardPunishApplyPanel.setAccount(account);
                                awardPunishApplyPanel.setWelcome();
                                awardPunishApplyPanel.updateTabel();
                                cardLayout.show(root,"awaAppPanel");
                                //点击退回按钮
                                awardPunishApplyPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=awardPunishApplyPanel.getAddButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            awardPunishApplyPanel.getAddButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"studentMenu");
                                    }
                                });
                                //点击进入增加选课按钮
                                awardPunishApplyPanel.getAddButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        addAwardApplyPanel.setAccount(account);
                                        awardPunishApplyPanel.addExecute(addAwardApplyPanel,
                                                cardLayout,root,stream_frame);
                                    }
                                });
                            }
                        });

                        //补考申请
                        studentMenuPanel.getEdit_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                remakeApplyPanel.setAccount(account);
                                remakeApplyPanel.setWelcome();
                                remakeApplyPanel.showTable();
                                cardLayout.show(root,"remAppPanel");
                                //点击退回按钮
                                remakeApplyPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=remakeApplyPanel.getAddButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            remakeApplyPanel.getAddButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"studentMenu");
                                    }
                                });
                                //点击申请按钮
                                remakeApplyPanel.getAddButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        addRemakePanel.setAccount(account);
                                        addRemakePanel.init();
                                        cardLayout.show(root,"addRemPanel");
                                        addRemakePanel.getBackButton().addActionListener(new ActionListener(){
                                            public void actionPerformed(ActionEvent e){
                                                cardLayout.show(root,"remAppPanel");
                                                ActionListener[] listeners=addRemakePanel.getIdentityButton().getActionListeners();
                                                for (ActionListener listener : listeners) {
                                                    addRemakePanel.getIdentityButton().removeActionListener(listener);
                                                }
                                            }
                                        });
                                        addRemakePanel.getIdentityButton().addActionListener(new ActionListener(){//点击确认按钮
                                            public void actionPerformed(ActionEvent e){
                                                //接口
                                                String cid=addRemakePanel.getAddCidText().getText();
                                                //查询成功返回1，不成功返回0，目前返回的是1
                                                int update=stu.insert_remake(account,cid);
                                                addRemakePanel.indentityDialog(stream_frame,update);
                                                remakeApplyPanel.showTable();
                                            }
                                        });
                                    }
                                });


                            }
                        });
                        //查询学分绩点
                        studentMenuPanel.getGrades_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                searchScorePanel.setAccount(account);
                                searchScorePanel.init();
                                cardLayout.show(root,"seaScoPanel");
                                searchScorePanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=searchScorePanel.getIdentityButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            searchScorePanel.getIdentityButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"studentMenu");
                                    }
                                });
                                //查询详细学分绩点
                                searchScorePanel.getIdentityButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        searchScorePanel.excute();
                                    }
                                });
                            }
                        });
                        //课表查看
                        studentMenuPanel.getSyllabus_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SwingUtilities.invokeLater(() -> new ExportSyllabus(account));
                            }
                        });

                    }
                    if(type.equals("教师")) {
                        teacherMenuPanel.setAccount(account);
                        courseApplyPanel.setAccount(account);
                        remakeManaPanel.setAccount(account);
                        teacherMenuPanel.init();
                        cardLayout.show(root, "teacherMenu");
                        //点击退出按钮
                        teacherMenuPanel.getBackButton().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                cardLayout.show(root,"Page 1");
                                login_panel.getText_account().setText("");
                                login_panel.getText_password().setText("");

                            }
                        });
                        //进入开课申请界面
                        teacherMenuPanel.getCourseApply_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                courseApplyPanel.setAccount(account);
                                courseApplyPanel.setWelcome();
                                courseApplyPanel.showTable();
                                cardLayout.show(root,"couAppPanel");
                                //点击退回按钮
                                courseApplyPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=courseApplyPanel.getAddButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            courseApplyPanel.getAddButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"teacherMenu");
                                    }
                                });
                                //点击进入增加选课按钮
                                courseApplyPanel.getAddButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        addCourseApplyPanel.setAccount(account);
                                       courseApplyPanel.addExecute(addCourseApplyPanel,
                                               cardLayout,root,stream_frame);
                                    }
                                });
                            }
                        });
                        //进行成绩录入
                        teacherMenuPanel.getScoreInput_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                scoreInputPanel.setAccount(account);
                                scoreInputPanel.init();
                                cardLayout.show(root,"scoInpPanel");
                                //点击退回按钮
                                scoreInputPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=scoreInputPanel.getIdentityButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            scoreInputPanel.getIdentityButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"teacherMenu");
                                    }
                                });
                                //点击进入录入按钮
                                scoreInputPanel.getIdentityButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        String cid=scoreInputPanel.getCidText().getText();
                                        scoreInputPanel.excute();

                                    }
                                });

                            }
                        });
                        //进行补考通过审批
                        teacherMenuPanel.getRemake_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                remakeManaPanel.setAccount(account);
                                remakeManaPanel.setWelcome();
                                remakeManaPanel.updateTabel();
                                cardLayout.show(root,"remakeManaPanel");
                                //点击退回按钮
                                remakeManaPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        ActionListener[] listeners=remakeManaPanel.getIndentityButton().getActionListeners();
                                        for (ActionListener listener : listeners) {
                                            remakeManaPanel.getIndentityButton().removeActionListener(listener);
                                        }
                                        cardLayout.show(root,"teacherMenu");
                                    }
                                });
                                remakeManaPanel.getIndentityButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        DefaultTableModel model=remakeManaPanel.getModel();
                                        int ifSelect[]=new int[model.getRowCount()];//返回boolean类型的
                                        String sidSelect[]=new String[model.getRowCount()];//返回每一行的主码
                                        String cidSelect[]=new String[model.getRowCount()];//返回每一行的主码
                                        for(int i=0;i<model.getRowCount();i++){
                                            if(model.getValueAt(i,4)!=null){
                                                if((boolean) model.getValueAt(i, 4))
                                                    ifSelect[i]=1;
                                                else
                                                    ifSelect[i]=-1;
                                            }else{
                                                ifSelect[i]=0;
                                            }
                                            sidSelect[i]= (String) model.getValueAt(i,0);
                                            cidSelect[i]= (String) model.getValueAt(i,1);
                                        }
                                        int update=1;
                                        for(int i=0;i<model.getRowCount();i++){
                                            if(ifSelect[i]==1){
                                                update &=tea.remake_pass(sidSelect[i],cidSelect[i]);
                                            }else if(ifSelect[i]==-1){
                                                update &=tea.remake_not_pass(sidSelect[i],cidSelect[i]);
                                            }
                                        }
                                        if(update==1)
                                            logger.debug("success");
                                        else
                                            logger.debug("failure");
                                        remakeManaPanel.indentityDialog(stream_frame,update);
                                        remakeManaPanel.updateTabel();
                                    }
                                });


                            }
                        });
                    }
                    if(type.equals("管理员")) {
                        adminMenuPanel.setAccount(account);
                        adminMenuPanel.init();
                        cardLayout.show(root, "adminMenu");
                        //点击退出按钮
                        adminMenuPanel.getBackButton().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                cardLayout.show(root,"Page 1");
                                login_panel.getText_account().setText("");
                                login_panel.getText_password().setText("");
                            }
                        });
                        //进入操作管理学院的操作
                        adminMenuPanel.getInstituteMana_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                adminInstitutionPanel.setAccount(account);
                                adminInstitutionPanel.init();//初始化院系管理模块界面
                                cardLayout.show(root, "adminInsPanel");
                                //点击退回按钮
                                adminInstitutionPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        cardLayout.show(root,"adminMenu");
                                    }
                                });
                                //执行增加院系的操作
                                adminInstitutionPanel.getAdd_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                       // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminInstitutionPanel.addExecute(addInstitutePanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //执行删除院系的操作
                                adminInstitutionPanel.getDrop_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        //System.out.println("Label Clicked!");
                                      //  String instituteId=InsManagePanel.getText_drop().getText();//接收的院系编号
                                        adminInstitutionPanel.dropExecute(dropInstitutePanel,cardLayout,root,
                                                stream_frame);
                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //执行更新院系的操作
                                adminInstitutionPanel.getUpdate_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        //System.out.println("Label Clicked!");
                                     //   String instituteId=InsManagePanel.getText_drop().getText();//接收的院系编号
                                        adminInstitutionPanel.updateExecute(updateInstitutePanel,cardLayout,root,
                                                stream_frame);
                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进行查找工作
                                adminInstitutionPanel.getSearch_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        //System.out.println("Label Clicked!");
                                      //  String instituteId=InsManagePanel.getText_drop().getText();//接收的院系编号
                                        adminInstitutionPanel.searchExecute(searchInstitutePanel,cardLayout,root,
                                                stream_frame);
                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //获取信息

                            }
                        });
                        //进入操作管理专业的操作
                        adminMenuPanel.getMajorMana_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                adminMajorPanel.setAccount(account);
                                adminMajorPanel.init();//初始化专业管理模块界面
                                cardLayout.show(root, "adminMajPanel");
                                //点击退回按钮
                                adminMajorPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        cardLayout.show(root,"adminMenu");
                                    }
                                });
                                //执行增加专业的操作
                                adminMajorPanel.getAdd_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        adminMajorPanel.addExecute(addMajorPanel,
                                                cardLayout,root,stream_frame);
                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //执行删除专业的操作
                                adminMajorPanel.getDrop_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        //System.out.println("Label Clicked!");
                                        //  String instituteId=InsManagePanel.getText_drop().getText();//接收的院系编号
                                        adminMajorPanel.dropExecute(dropMajorPanel,cardLayout,root,
                                                stream_frame);
                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //执行更新院系的操作
                                adminMajorPanel.getUpdate_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        adminMajorPanel.updateExecute(updateMajorPanel,cardLayout,root,
                                                stream_frame);
                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进行查找工作
                                adminMajorPanel.getSearch_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        adminMajorPanel.searchExecute(searchMajorPanel,cardLayout,root,
                                                stream_frame);
                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //获取信息

                            }
                        });
                        //进入管理学生的操作
                        adminMenuPanel.getStudentMana_button().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                adminStudentPanel.setAccount(account);
                                adminStudentPanel.init();
                                cardLayout.show(root, "adminStuPanel");
                                //点击退回按钮
                                adminStudentPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        stream_frame.getContentPane().remove(adminStudentPanel);
                                        stream_frame.revalidate();
                                        stream_frame.repaint();
                                        cardLayout.show(root,"adminMenu");
                                    }
                                });
                                //进入增加学生信息功能模块
                                adminStudentPanel.getAdd_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminStudentPanel.addExecute(addStudentPanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入更新学生信息功能模块
                                adminStudentPanel.getUpdate_label().addMouseListener(new MouseListener(){
                                   // adminStudentPanel.setAccount(account);
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminStudentPanel.updateExecute(updateStudentPanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入删除学生信息功能模块
                                adminStudentPanel.getDrop_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminStudentPanel.dropExecute(dropStudentPanel,
                                                cardLayout,root,stream_frame);
                                    }


                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入查找学生信息功能模块
                                adminStudentPanel.getSearch_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminStudentPanel.searchExecute(searchStudentPanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                            }
                        });
                        //进入管理课程的操作
                        adminMenuPanel.getCourseMana_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                adminCoursePanel.setAccount(account);
                                adminCoursePanel.init();
                                cardLayout.show(root, "adminCouPanel");
                                //点击退回按钮
                                adminCoursePanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        stream_frame.getContentPane().remove(adminCoursePanel);
                                        stream_frame.revalidate();
                                        stream_frame.repaint();
                                        cardLayout.show(root,"adminMenu");

                                    }
                                });

                                //进入审批课程的界面
                                adminCoursePanel.getAdd_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminCoursePanel.addExecute(addCoursePanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入查找课程的界面
                                adminCoursePanel.getSearch_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminCoursePanel.searchExecute(searchCoursePanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入更新课程的界面
                                adminCoursePanel.getUpdate_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminCoursePanel.updateExecute(updateCoursePanel,
                                                cardLayout,root,stream_frame);

                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                adminCoursePanel.getDrop_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        adminCoursePanel.dropExecute(dropCoursePanel,
                                                cardLayout,root,stream_frame);

                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                            }
                        });
                        //进入管理教师的操作
                        adminMenuPanel.getTeacherMana_button().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                adminTeacherPanel.setAccount(account);
                                adminTeacherPanel.init();
                                cardLayout.show(root, "adminTeaPanel");
                                //点击退回按钮
                                adminTeacherPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        stream_frame.getContentPane().remove(adminStudentPanel);
                                        stream_frame.revalidate();
                                        stream_frame.repaint();
                                        cardLayout.show(root,"adminMenu");
                                    }
                                });
                                //进入增加老师信息功能模块
                                adminTeacherPanel.getAdd_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminTeacherPanel.addExecute(addTeacherPanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入更新老师信息功能模块
                                adminTeacherPanel.getUpdate_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminTeacherPanel.updateExecute(updateTeacherPanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入删除老师信息功能模块
                                adminTeacherPanel.getDrop_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminTeacherPanel.dropExecute(dropTeacherPanel,
                                                cardLayout,root,stream_frame);
                                    }


                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //进入查找老师信息功能模块
                                adminTeacherPanel.getSearch_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminTeacherPanel.searchExecute(searchTeacherPanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                            }
                        });
                        //进入奖惩模块
                        adminMenuPanel.getRPMana_button().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                adminRPPanel.setAccount(account);
                                adminRPPanel.init();
                                cardLayout.show(root,"adminRpPanel");
                                //点击退回按钮
                                adminRPPanel.getBackButton().addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        stream_frame.getContentPane().remove(adminRPPanel);
                                        stream_frame.revalidate();
                                        stream_frame.repaint();
                                        cardLayout.show(root,"adminMenu");
                                    }
                                });
                                //审批奖惩
                                adminRPPanel.getDrop_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        adminRPPanel.showCheckboxTable();

                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                                //增加奖惩
                                adminRPPanel.getAdd_label().addMouseListener(new MouseListener(){
                                    public void mouseClicked(MouseEvent e) {
                                        // String instituteId=InsManagePanel.getText_add().getText();//接收的院系编号
                                        adminRPPanel.addExecute(addRPPanel,
                                                cardLayout,root,stream_frame);


                                    }
                                    public void mousePressed(MouseEvent e) {}
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                });
                            }
                        });

                    }


                }
            });





            // 将root添加到主窗体
            stream_frame.add(root);

            // 设置窗体属性
            stream_frame.setLocationRelativeTo(null);
            stream_frame.setVisible(true);
        });
    }

    private static void exe(String type,Logger logger,String account_text
            ,String password_text,CardLayout cardLayout,Login_Panel login_panel){
        Connection conn= JdbcConnection.getConnection();
        String sql="select password from ";
        if(Objects.equals(type, "学生"))
            sql+="student where SID";
        else if(Objects.equals(type, "教师"))
            sql+="teacher where TID";
        else if(Objects.equals(type, "管理员"))
            sql+="administrators where AID";
        else{
            logger.warn("未选择身份");
            new LoginException("未选择身份",cardLayout,login_panel);
            JdbcConnection.disconnected(conn);
            return;
        }
        sql=sql+ "='" +account_text+ "'";
        PreparedStatement pStmt=null;
        ResultSet rs=null;
        try {
            pStmt=conn.prepareStatement(sql);
            logger.debug("stmt创建成功 "+sql);
            rs= pStmt.executeQuery();
            logger.debug("rs获取成功 "+rs);
            if(!rs.next()){
                logger.warn("账号错误");
                new LoginException("账号错误",cardLayout,login_panel);
            }
            else{
                String true_password=rs.getString(1);
                if(!Objects.equals(true_password, password_text)) {
                    logger.warn("密码错误");
                    new LoginException("密码错误",cardLayout,login_panel);
                } else {
                    logger.info("SUCCESS!!!登录成功");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            assert rs != null;
            JdbcConnection.closeAll(conn,rs,pStmt);
        }
    }
}

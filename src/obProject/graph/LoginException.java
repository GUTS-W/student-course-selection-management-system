package obProject.graph;
import obProject.util.Log;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginException {
    LoginException(String wrong_message , CardLayout cardLayout,Login_Panel login_panel){
        // 创建一个简单的窗口
        JFrame Login_JButton_frame = new JFrame("Swing Exception Example");
        try {
            // 在按钮点击事件中抛出异常
            throw new IllegalArgumentException(wrong_message);
        } catch (IllegalArgumentException ex) {
            // 捕获异常并显示消息框
            JOptionPane.showMessageDialog(Login_JButton_frame, "Exception caught: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            login_panel.getText_password().setText("");
            login_panel.getText_account().setText("");
            cardLayout.show(login_panel,"1");
        }
        Login_JButton_frame.setSize(300, 200);
        Login_JButton_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login_JButton_frame.setVisible(true);
    }
}

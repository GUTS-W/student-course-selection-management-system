package obProject.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class Login_Button {
    Login_Button(){}

    JButton getLoginButton(){
        JButton Login_button=new JButton("Sign in");
        Login_button.setBounds(440,500,100,40);
        animateButtonOnClick(Login_button);
        Login_button.setBackground(new Color(94, 216, 227));
        return Login_button;
    }

    private static void animateButtonOnClick(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建定时器
                Timer timer = new Timer(10, new ActionListener() {
                    int count = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 修改按钮背景颜色
                        Color color = new Color(count, count, 145);
                        button.setBackground(color);

                        // 停止定时器
                        if (count >= 255) {
                            ((Timer) e.getSource()).stop();
                        }

                        count += 5;
                    }
                });

                // 启动定时器
                timer.start();
            }
        });
    }
}

package obProject.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class GradientPanel extends JPanel {
    protected void paintComponent(Graphics g) {

        super.paintComponents(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // 获取面板的宽度和高度
        int width = getWidth();
        int height = getHeight();

        // 创建渐变颜色
        Color color1 = new Color(162, 221, 224, 255); // 起始颜色 (红色)
        Color color2 = new Color(255, 178, 164); // 终止颜色 (蓝色)
        GradientPaint gradientPaint = new GradientPaint(0, 0, color1, width, height, color2);

        // 设置渐变颜色
        g2d.setPaint(gradientPaint);

        // 填充矩形以实现渐变效果
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();
    }
}

package com.company.Predict;

import javax.swing.*;
import java.awt.*;

public class LoginMain extends JFrame {
private JPanel contentPane;// 内容面板

public static void main(String[] args) {
    try {
        // 设置登录窗体风格
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // 实例化登录窗体
                LoginMain frame = new LoginMain();
                // 使登录窗体可见
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public LoginMain() {// 登录窗体的构造方法
    setTitle("明日彩票预测系统");// 登录窗体的标题
    // 登录窗体的标题图标
    setIconImage(Toolkit.getDefaultToolkit().getImage(LoginMain.class.getResource("/imgs/log.png")));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 对登录窗体发起“close”时，退出应用程序
    setBounds(200, 100, 1100, 620);// 登录窗体的位置及宽高
    contentPane = new JPanel();// 内容面板
    setContentPane(contentPane);// 把内容面板放入登录窗体中
    contentPane.setLayout(new BorderLayout(0, 0));// 设置内容面板的布局为边界布局
    JButton btnNewButton = new JButton("");// 实例化无文本内容的按钮
    // 设置按钮的图片
    btnNewButton.setIcon(new ImageIcon(LoginMain.class.getResource("/imgs/login1.jpg")));
    contentPane.add(btnNewButton, BorderLayout.CENTER);// 按钮放置在内容面板的中间
}


}

package com.frame;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMain extends JFrame {
private JPanel contentPane;// 内容面板
private JFrame LoginFrame = new JFrame("登陆窗口");
private JButton UserName = new JButton("用户名");
private JButton PassWord = new JButton("密码");
private JButton jbLogin = new JButton("登陆");
private JButton jbCancel = new JButton("取消");
private JTextField jtName = new JTextField();
private JTextField jtPwd = new JTextField();
private final String mima = "admin1234";//此为预设的密码
private int count = 0;

private JFrame LoginFrameZhu = new JFrame();

//private JLabel jlZhu = new JLabel(image);

private JFrame LoginFrameCuo = new JFrame();

private JLabel jlCuo = new JLabel("你输入的用户名密码不匹配！");


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
                frame.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public LoginMain(){
    init();
    jbCancel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    jbLogin.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String name = jtName.getText();
            String pwd = jtPwd.getText();
            String aa = name+pwd;
            if(aa.equals(mima)){			//Java中判断两个字符串相等用equals()函数。
                LoginFrame.setVisible(false);// 登录窗体不可见
                MainFrame t = new MainFrame();// 创建主窗体
                t.setVisible(true);// 使主窗体可见
            }
            else{
                if(0<=count&&count<3){
                    Container cp3 = LoginFrameCuo.getContentPane();
                    cp3.setLayout(null);

                    jlCuo.setBounds(0, 0, 400, 300);
                    cp3.add(jlCuo);
                    LoginFrameCuo.setSize(400,300);
                    LoginFrameCuo.setVisible(true);
                    count++;
                }
                else{
                    if(count>=3)
                        System.exit(0);
                }
            }
        }
    });

    LoginFrame.setSize(400, 300);
    LoginFrame.setVisible(true);


}

void init(){
    //Container cp =
    LoginFrame.getContentPane();
    LoginFrame.setLayout(null);
    setIconImage(Toolkit.getDefaultToolkit().getImage(LoginMain.class.getResource("/imgs/log.png")));
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) screensize.getWidth() / 3;
    int y = (int) screensize.getHeight() / 3;
    LoginFrame.setLocation(x, y);


    jtName.setBounds(150,50,100,20);
    LoginFrame.add(jtName);
    UserName.setBounds(10,50,100,20);
    LoginFrame.add(UserName);

    jtPwd.setBounds(150,100,100,20);
    LoginFrame.add(jtPwd);
    PassWord.setBounds(10,100,100,20);
    LoginFrame.add(PassWord);

    jbLogin.setBounds(20, 150, 100, 20);
    jbCancel.setBounds(150, 150, 100, 20);
    LoginFrame.add(jbLogin);
    LoginFrame.add(jbCancel);




}

/*
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

    btnNewButton.addActionListener(new ActionListener() {// 为按钮添加动作事件的监听
        public void actionPerformed(ActionEvent e) {// 动作事件的监听的方法体
            do_btnNewButton_actionPerformed(e);// 按钮触发动作事件的监听时执行的方法
        }
    });
}
// 按钮触发动作事件的监听时执行的方法
protected void do_btnNewButton_actionPerformed(ActionEvent e) {
    this.setVisible(false);// 登录窗体不可见
    MainFrame t = new MainFrame();// 创建主窗体
    t.setVisible(true);// 使主窗体可见
}
*/

}

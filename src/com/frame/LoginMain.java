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
private JPanel contentPane;// �������
private JFrame LoginFrame = new JFrame("��½����");
private JButton UserName = new JButton("�û���");
private JButton PassWord = new JButton("����");
private JButton jbLogin = new JButton("��½");
private JButton jbCancel = new JButton("ȡ��");
private JTextField jtName = new JTextField();
private JTextField jtPwd = new JTextField();
private final String mima = "admin1234";//��ΪԤ�������
private int count = 0;

private JFrame LoginFrameZhu = new JFrame();

//private JLabel jlZhu = new JLabel(image);

private JFrame LoginFrameCuo = new JFrame();

private JLabel jlCuo = new JLabel("��������û������벻ƥ�䣡");


public static void main(String[] args) {
    try {
        // ���õ�¼������
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // ʵ������¼����
                LoginMain frame = new LoginMain();
                // ʹ��¼����ɼ�
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
            if(aa.equals(mima)){			//Java���ж������ַ��������equals()������
                LoginFrame.setVisible(false);// ��¼���岻�ɼ�
                MainFrame t = new MainFrame();// ����������
                t.setVisible(true);// ʹ������ɼ�
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
public LoginMain() {// ��¼����Ĺ��췽��
    setTitle("���ղ�ƱԤ��ϵͳ");// ��¼����ı���
    // ��¼����ı���ͼ��
    setIconImage(Toolkit.getDefaultToolkit().getImage(LoginMain.class.getResource("/imgs/log.png")));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �Ե�¼���巢��close��ʱ���˳�Ӧ�ó���
    setBounds(200, 100, 1100, 620);// ��¼�����λ�ü����
    contentPane = new JPanel();// �������
    setContentPane(contentPane);// �������������¼������
    contentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
    JButton btnNewButton = new JButton("");// ʵ�������ı����ݵİ�ť
    // ���ð�ť��ͼƬ
    btnNewButton.setIcon(new ImageIcon(LoginMain.class.getResource("/imgs/login1.jpg")));
    contentPane.add(btnNewButton, BorderLayout.CENTER);// ��ť���������������м�

    btnNewButton.addActionListener(new ActionListener() {// Ϊ��ť��Ӷ����¼��ļ���
        public void actionPerformed(ActionEvent e) {// �����¼��ļ����ķ�����
            do_btnNewButton_actionPerformed(e);// ��ť���������¼��ļ���ʱִ�еķ���
        }
    });
}
// ��ť���������¼��ļ���ʱִ�еķ���
protected void do_btnNewButton_actionPerformed(ActionEvent e) {
    this.setVisible(false);// ��¼���岻�ɼ�
    MainFrame t = new MainFrame();// ����������
    t.setVisible(true);// ʹ������ɼ�
}
*/

}

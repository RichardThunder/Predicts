package com.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMain extends JFrame {
private JPanel contentPane;// �������

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
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

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


}

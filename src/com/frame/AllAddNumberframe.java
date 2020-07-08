package com.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dao.HistoryDao;

public class AllAddNumberframe extends JDialog {// ������ӶԻ���
private JPanel jcontentPane;// �������
private JTextField textField;// �ļ�·�����ı���
JLabel erroyLabel;// ���������״̬����ǩ

public static void main(String[] args) {
    try {
        // ����������ӶԻ���ķ��
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                AllAddNumberframe frame = new AllAddNumberframe();// ������ӶԻ���
                frame.setVisible(true);// ʹ������ӶԻ���ɼ�
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public AllAddNumberframe() {// ������ӶԻ���Ĺ��췽��
    setModal(true);// ʹ������ӶԻ���������ǰ
    setResizable(false);// ������ӶԻ��򲻿ɸı��С
    setIconImage(Toolkit.getDefaultToolkit().getImage(AllAddNumberframe.class.getResource("/imgs/log.png")));// ����������ӶԻ���ı���ͼ��
    setTitle("������ӿ�������");// ����������ӶԻ���ı���
    setBounds(450, 120, 606, 609);// ����������ӶԻ����λ���Լ����

    jcontentPane = new JPanel();// �������
    jcontentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
    setContentPane(jcontentPane);// �������������������ӶԻ�����

    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// �����Զ��屳������ͼƬ
    jcontentPane.add(contentPane, BorderLayout.CENTER);// ����Զ��屳����嵽���������м�

    JLabel label = new JLabel("�ļ�·����");// �ļ�·����ǩ
    label.setBounds(108, 140, 76, 18);// �����ļ�·����ǩ��λ���Լ����
    contentPane.add(label);// ���ļ�·����ǩ�����Զ��屳�������

    textField = new JTextField();// �ļ�·�����ı���
    textField.setBounds(196, 134, 198, 30);// �����ļ�·�����ı����λ���Լ����
    contentPane.add(textField);// ���ļ�·�����ı��������Զ��屳�������
    textField.setColumns(20);// �����ļ�·�����ı���Ŀ��

    JButton button = new JButton("");// ѡ���ļ�·����ť
    button.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/img_btn/a06.png")));// ����ѡ���ļ�·����ť��ͼ��
    button.setBounds(406, 136, 62, 28);// ����ѡ���ļ�·����ť��λ���Լ����
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// Ϊѡ���ļ�·����ť��Ӷ����¼��ļ���
        }
    });
    contentPane.add(button);// ��ѡ���ļ�·����ť�����Զ��屳�������

    JButton btnNewButton = new JButton("");// �رհ�ť
    btnNewButton.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/img_btn/a07.png")));// ���ùرհ�ť��ͼ��
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// Ϊ�رհ�ť��Ӷ����¼��ļ���
        }
    });
    btnNewButton.setBounds(312, 412, 108, 39);// ���ùرհ�ť��λ���Լ����
    contentPane.add(btnNewButton);// �ѹرհ�ť�����Զ��屳�������

    JButton button_1 = new JButton("");// ��Ӱ�ť
    button_1.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/img_btn/a04.png")));// ������Ӱ�ť��ͼ��
    button_1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_1_actionPerformed(e);// Ϊ��Ӱ�ť��Ӷ����¼��ļ���
        }
    });
    button_1.setBounds(172, 412, 108, 38);// ������Ӱ�ť��λ���Լ����
    contentPane.add(button_1);// ����Ӱ�ť�����Զ��屳�������

    erroyLabel = new JLabel("");// ���������״̬����ǩ
    erroyLabel.setBounds(216, 97, 223, 18);// ���á��������״̬����ǩ��λ���Լ����
    contentPane.add(erroyLabel);// �ѡ��������״̬����ǩ�����Զ��屳�������

    JButton btnNewButton_1 = new JButton("");// ʵ��ͼƬ��ť
    btnNewButton_1.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/imgs/demo.png")));// ����ʵ��ͼƬ��ť��ͼ��
    btnNewButton_1.setBounds(221, 191, 247, 206);// ����ʵ��ͼƬ��ť��λ���Լ����
    contentPane.add(btnNewButton_1);// ��ʵ��ͼƬ��ť�����Զ��屳�������

    JLabel lblNewLabel = new JLabel("�ı�д����ͼ��ʾ��");// ͼƬʵ����ǩ
    lblNewLabel.setBounds(108, 191, 122, 18);// ����ͼƬʵ����ǩ��λ���Լ����
    contentPane.add(lblNewLabel);// ��ͼƬʵ����ǩ�����Զ��屳�������
}

protected void do_button_actionPerformed(ActionEvent e) {// ѡ���ļ�·����ť�����¼��ļ���
    JFileChooser chooser = new JFileChooser();// �����ļ�ѡ����
    FileFilter filter = new FileNameExtensionFilter("�ı��ļ�(*.txt)", "txt");// �������Ŀ¼�а���txt�ļ���չ�����ļ�
    chooser.setFileFilter(filter);// Ϊ�ļ�ѡ��Ի��������ļ�������
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// ���ý���ѡ���ļ�
    chooser.setMultiSelectionEnabled(false);// ���ö���ѡ��
    int result = chooser.showOpenDialog(this);// ����ļ�ѡ����״̬
    if (result == JFileChooser.APPROVE_OPTION) {// ����ļ�ѡ�����еġ�ȷ�ϡ���
        File file = chooser.getSelectedFile();// ����û�ѡ����ļ�
        textField.setText(file.getAbsolutePath());// �����ļ�·�����ı�������
    }
}

protected void do_button_1_actionPerformed(ActionEvent e) {// Ϊ��Ӱ�ť��Ӷ����¼��ļ���
    String s = textField.getText();// ����ļ�·�����ı����е�����
    HistoryDao his = new HistoryDao();// ����������Ϣ
    if (his.allAddNumber(s)) {// ��ӿ�������ɹ�
        erroyLabel.setText("��ӳɹ�");// ���á��������״̬����ǩ������
    } else {// ��ӿ�������ʧ��
        erroyLabel.setText("���ʧ��");// ���á��������״̬����ǩ������
    }
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// Ϊ�رհ�ť��Ӷ����¼��ļ���
    this.setVisible(false);// ʹ������ӶԻ��򲻿ɼ�
}
}

package com.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.dao.HistoryDao;
import com.dao.LotteryValidate;
import com.model.History;

public class SelectBonusframe extends JDialog {// �н���ѯ�Ի���

private JPanel jcontentPane;// �������
private JTextField numberField1;// �������������ı���
private JTextField seven1;// �����򽱺š��ı���
private JTextField seven2;// ���������롱�ı���
private JTextField money;// �������ı���

public static void main(String[] args) {
    try {
        // �����н���ѯ�Ի���ķ��
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                SelectBonusframe frame = new SelectBonusframe();// �н���ѯ�Ի���
                frame.setVisible(true);// ʹ�н���ѯ�Ի���ɼ�
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public SelectBonusframe() {// �н���ѯ�Ի���Ĺ��췽��
    setModal(true);// ʹ�н���ѯ�Ի���������ǰ
    setResizable(false);// �����н���ѯ�Ի��򲻿ɸı��С
    setIconImage(Toolkit.getDefaultToolkit().getImage(SelectBonusframe.class.getResource("/imgs/log.png")));// �����н���ѯ�Ի���ı���ͼ��
    setTitle("�н���ѯ");// �����н���ѯ�Ի���ı���
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �����н���ѯ�Ի���Ĺرշ�ʽ
    setBounds(500, 150, 554, 532);// �����н���ѯ�Ի����λ���Լ����

    jcontentPane = new JPanel();// �������
    jcontentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
    setContentPane(jcontentPane);// ��������������н���ѯ�Ի�����

    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// ���ñ�������ͼƬ
    jcontentPane.add(contentPane, BorderLayout.CENTER);// ��ӱ�����嵽�������

    JLabel label = new JLabel("�����ѯ������");// �������ѯ����������ǩ
    label.setBounds(78, 90, 119, 18);// ���á������ѯ����������ǩ��λ�úͿ��
    contentPane.add(label);// �ѡ������ѯ����������ǩ�����Զ��屳�������

    JLabel label_1 = new JLabel("�����ѯ���룺");// �������ѯ���룺����ǩ
    label_1.setBounds(78, 149, 119, 18);// ���á������ѯ���룺����ǩ��λ�úͿ��
    contentPane.add(label_1);// �ѡ������ѯ���룺����ǩ�����Զ��屳�������

    JButton btnNewButton = new JButton();// ����ѯ����ť
    btnNewButton.setIcon(new ImageIcon(SelectBonusframe.class.getResource("/img_btn/a03.png")));// ���á���ѯ����ť��ͼ��
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// Ϊ����ѯ����ť��Ӷ����¼��ļ���
        }
    });
    btnNewButton.setBounds(136, 335, 109, 38);// ���á���ѯ����ť��λ�úͿ��
    contentPane.add(btnNewButton);// �ѡ���ѯ����ť�����Զ��屳�������

    numberField1 = new JTextField();// �������������ı���
    numberField1.setBounds(234, 87, 197, 24);// ���á������������ı����λ�úͿ��
    contentPane.add(numberField1);// �ѡ������������ı��������Զ��屳�������
    numberField1.setColumns(20);// ���á������������ı���Ŀ��

    seven1 = new JTextField();// �����򽱺š��ı���
    seven1.setColumns(10);// ���á����򽱺š��ı���Ŀ��
    seven1.setBounds(234, 143, 197, 24);// ���á����򽱺š��ı����λ�úͿ��
    contentPane.add(seven1);// �ѡ����򽱺š��ı��������Զ��屳�������

    JButton button = new JButton("");// ���رա���ť
    button.setIcon(new ImageIcon(SelectBonusframe.class.getResource("/img_btn/a07.png")));// ���á��رա���ť��ͼ��
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// Ϊ���رա���ť��Ӷ����¼��ļ���
        }
    });
    button.setBounds(279, 335, 108, 39);// ���á��رա���ť��λ�úͿ��
    contentPane.add(button);// �ѡ��رա���ť�����Զ��屳�������

    JLabel label_3 = new JLabel("������ѯ���ڿ������룺");// ��������ѯ���ڿ������룺����ǩ
    label_3.setBounds(47, 208, 173, 18);// ���á�������ѯ���ڿ������룺����ǩ��λ�úͿ��
    contentPane.add(label_3);// �ѡ�������ѯ���ڿ������룺����ǩ�����Զ��屳�������

    JLabel label_4 = new JLabel("���ý���");// �����ý��𣺡���ǩ
    label_4.setBounds(101, 275, 119, 18);// ���á����ý��𣺡���ǩ��λ�úͿ��
    contentPane.add(label_4);// �ѡ����ý��𣺡���ǩ�����Զ��屳�������

    seven2 = new JTextField();// ���������롱�ı���
    seven2.setEditable(false);// ���á��������롱�ı��򲻿ɱ༭
    seven2.setColumns(10);// ���á��������롱�ı���Ŀ��
    seven2.setBounds(234, 205, 197, 24);// ���á��������롱�ı����λ�úͿ��
    contentPane.add(seven2);// �ѡ��������롱�ı��������Զ��屳�������

    money = new JTextField();// �������ı���
    money.setEditable(false);// ���á������ı��򲻿ɱ༭
    money.setColumns(10);// ���á������ı���Ŀ��
    money.setBounds(234, 272, 197, 24);// ���á������ı����λ�úͿ��
    contentPane.add(money);// �ѡ������ı��������Զ��屳�������
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// ����ѯ����ť�����¼��ļ���
    int number = Integer.parseInt(numberField1.getText());// ���ת��Ϊint�͵ġ�����������
    HistoryDao his = new HistoryDao();// ʵ��������������Ϣ
    History h = his.getOneHistory(number);// ��ȡһ����������
    String seven = seven1.getText();// ��á����򽱺š�
    String sevens[] = seven.split("");// �ָ������򽱺š�
    int[] s1 = new int[] { h.getA(), h.getB(), h.getC(), h.getD(), h.getE(), h.getF(), h.getG() };// �ѡ��������롱ת��Ϊ����
    int[] s2 = new int[] { Integer.parseInt(sevens[0]), Integer.parseInt(sevens[1]), Integer.parseInt(sevens[2]),
            Integer.parseInt(sevens[3]), Integer.parseInt(sevens[4]), Integer.parseInt(sevens[5]),
            Integer.parseInt(sevens[6]) };// �ѡ����򽱺š�ת��Ϊ����
    seven2.setText("" + h.getA() + h.getB() + h.getC() + h.getD() + h.getE() + h.getF() + h.getG());// ���á��������롱�ı��������
    LotteryValidate lv = new LotteryValidate();// ʵ������֤��Ϣ
    int i = lv.computeBonus(s1, s2);// ��ý���ĵȼ�
    switch (i) {// �Ի�ý���ĵȼ�Ϊ�����Ķ��֧���
        case 6:// 6�Ƚ�
            money.setText("��ϲ�����6�Ƚ�������5Ԫ��");// ���á������ı����е�����
            break;
        case 5:// 5�Ƚ�
            money.setText("��ϲ�����5�Ƚ�������20Ԫ��");// ���á������ı����е�����
            break;
        case 4:// 4�Ƚ�
            money.setText("��ϲ�����4�Ƚ�������300Ԫ��");// ���á������ı����е�����
            break;
        case 3:// 3�Ƚ�
            money.setText("��ϲ�����3�Ƚ�������1800Ԫ��");// ���á������ı����е�����
            break;
        case 2:// 2�Ƚ�
            money.setText("��ϲ�����2�Ƚ�������50000Ԫ��");// ���á������ı����е�����
            break;
        case 1:// 1�Ƚ�
            money.setText("��ϲ�����1�Ƚ�������500��Ԫ��");// ���á������ı����е�����
            break;
        case 0:// û���н�
            money.setText("���ź���û���н�");// ���á������ı����е�����
            break;
    }
}

protected void do_button_actionPerformed(ActionEvent e) {// ���رա���ť�����¼��ļ���
    this.setVisible(false);// ʹ�н���ѯ�Ի��򲻿ɼ�
}
}

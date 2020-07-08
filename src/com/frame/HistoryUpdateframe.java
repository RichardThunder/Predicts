package com.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.dao.ForecastDao;
import com.dao.HistoryDao;
import com.dao.LotteryValidate;
import com.model.History;
import com.model.UpDateNumber;

public class HistoryUpdateframe extends JDialog {// �޸Ŀ�������Ի���

private JPanel jcontentPane;// �������
private JTextField numberField;// �������������ı���
private JTextField sevenField;// ���������롱�ı���
private JTextField timeField;// ���������ڡ��ı���
JLabel erroyLabel1;// �����������ʽ����(��ʾ)��ǩ
JLabel erroyLabel2;// ���������ڸ�ʽ����(��ʾ)��ǩ
JLabel addLabel;// ���޸�״̬��(��ʾ)��ǩ

public static void main(String[] args) {
    try {
        // �����޸Ŀ�������Ի�����
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // �޸Ŀ�������Ի���
                HistoryUpdateframe frame = new HistoryUpdateframe();
                frame.setVisible(true);// ʹ�޸Ŀ�������Ի���ɼ�
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public HistoryUpdateframe() {// �޸Ŀ�������Ի���Ĺ��췽��
    setModal(true);// ʹ�޸Ŀ�������Ի���������ǰ
    setResizable(false);// �����޸Ŀ�������Ի��򲻿ɸı��С
    setTitle("�޸Ŀ�������");// �����޸Ŀ�������Ի���ı���
    setIconImage(Toolkit.getDefaultToolkit().getImage(HistoryUpdateframe.class.getResource("/imgs/log.png")));// �����޸Ŀ�������Ի���ı���ͼ��
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �����޸Ŀ�������Ի���Ĺرշ�ʽ
    setBounds(500, 150, 540, 481);// �����޸Ŀ�������Ի����λ���Լ����

    jcontentPane = new JPanel();// �������
    jcontentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
    setContentPane(jcontentPane);// ��������������޸Ŀ�������Ի�����

    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// ���ñ�������ͼƬ
    jcontentPane.add(contentPane, BorderLayout.CENTER);// ��ӱ�����嵽�������

    numberField = new JTextField();// �������������ı���
    numberField.setEditable(false);// ���á������������ı��򲻿ɱ༭
    numberField.setBounds(216, 105, 155, 24);// ���á������������ı����λ�úͿ��
    contentPane.add(numberField);// �ѡ������������ı��������Զ��屳�������
    numberField.setColumns(10);// ���á������������ı���Ŀ��

    JLabel lblNewLabel = new JLabel("����������");// ����������������ǩ
    lblNewLabel.setBounds(102, 108, 100, 18);// ���á���������������ǩ��λ���Լ����
    contentPane.add(lblNewLabel);// �ѡ���������������ǩ�����Զ��屳�������

    JLabel label = new JLabel("�������룺");// ���������룺����ǩ
    label.setBounds(102, 175, 100, 18);// ���á��������룺����ǩ��λ���Լ����
    contentPane.add(label);// �ѡ��������룺����ǩ�����Զ��屳�������

    sevenField = new JTextField();// ���������룺���ı���
    sevenField.setColumns(10);// ���á��������룺���ı���Ŀ��
    sevenField.setBounds(216, 172, 155, 24);// ���á��������룺���ı����λ�úͿ��
    contentPane.add(sevenField);// �ѡ��������룺���ı��������Զ��屳�������

    JButton btnNewButton = new JButton("");// ���޸ġ���ť
    btnNewButton.setIcon(new ImageIcon(HistoryUpdateframe.class.getResource("/img_btn/a05.png")));// ���á��޸ġ���ť��ͼ��
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// Ϊ���޸ġ���ť��Ӷ����¼��ļ���
        }
    });
    btnNewButton.setBounds(136, 291, 109, 74);// ���á��޸ġ���ť��λ���Լ����
    contentPane.add(btnNewButton);// �ѡ��޸ġ���ť�����Զ��屳�������

    JButton button = new JButton("");// ���رա���ť
    button.setIcon(new ImageIcon(HistoryUpdateframe.class.getResource("/img_btn/a07.png")));// ���á��رա���ť��ͼ��
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// Ϊ���رա���ť��Ӷ����¼��ļ���
        }
    });
    button.setBounds(288, 291, 108, 39);// ���á��رա���ť��λ���Լ����
    contentPane.add(button);// �ѡ��رա���ť�����Զ��屳�������

    JLabel label_1 = new JLabel("�������ڣ�");// ���������ڣ�����ǩ
    label_1.setBounds(102, 243, 100, 18);// ���á��������ڣ�����ǩ��λ���Լ����
    contentPane.add(label_1);// �ѡ��������ڣ�����ǩ�����Զ��屳�������

    timeField = new JTextField();// ���������ڡ��ı���
    timeField.setColumns(10);// ���á��������ڡ��ı���Ŀ��
    timeField.setBounds(216, 240, 155, 24);// ���á��������ڡ��ı����λ�úͿ��
    contentPane.add(timeField);// �ѡ��������ڡ��ı��������Զ��屳�������

    erroyLabel1 = new JLabel("");// �����������ʽ����(��ʾ)��ǩ
    erroyLabel1.setBounds(241, 142, 155, 18);// ���á����������ʽ����(��ʾ)��ǩ��λ�úͿ��
    contentPane.add(erroyLabel1);// �ѡ����������ʽ����(��ʾ)��ǩ�����Զ��屳�������

    erroyLabel2 = new JLabel("");// ���������ڸ�ʽ����(��ʾ)��ǩ
    erroyLabel2.setBounds(261, 209, 155, 18);// ���á��������ڸ�ʽ����(��ʾ)��ǩ��λ�úͿ��
    contentPane.add(erroyLabel2);// �ѡ��������ڸ�ʽ����(��ʾ)��ǩ�����Զ��屳�������

    addLabel = new JLabel("");// ���޸�״̬��(��ʾ)��ǩ
    addLabel.setBounds(207, 60, 164, 32);// ���á��޸�״̬��(��ʾ)��ǩ��λ�úͿ��
    contentPane.add(addLabel);// �ѡ��޸�״̬��(��ʾ)��ǩ�����Զ��屳�������

    int number = UpDateNumber.getN();// ���Ҫ�޸ĵĿ�������

    HistoryDao hd = new HistoryDao();// ʵ��������������Ϣ
    History his = new History();// ʵ�������쿪�����
    his = hd.getOneHistory(number);// ��ȡһ����������
    numberField.setText(number + "");// ���á������������ı��������
    sevenField.setText("" + his.getA() + his.getB() + his.getC() + his.getD() + his.getE() + his.getF() + his.getG());// ���á��������롱�ı��������
    timeField.setText(his.getHistorytime());// ���á��������ڡ��ı��������

}

protected void do_button_actionPerformed(ActionEvent e) {// ���رա���ť�����¼��ļ���
    this.setVisible(false);// ʹ�޸Ŀ�������Ի��򲻿ɼ�
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {
    LotteryValidate validate = new LotteryValidate();// ʵ������֤��Ϣ
    if (!validate.validateNumber(sevenField.getText())) {// ���������롱�ĸ�ʽ����
        erroyLabel1.setText("���������ʽ����ȷ");// ���á����������ʽ����(��ʾ)��ǩ������
    }
    if (validate.validateNumber(sevenField.getText())) {// ���������롱�ĸ�ʽ��ȷ
        erroyLabel1.setText("");// ���á����������ʽ����(��ʾ)��ǩ������Ϊ��
    }
    if (validate.validateData(timeField.getText())) {// ���������ڡ��ĸ�ʽ��ȷ
        erroyLabel2.setText("");// ���á��������ڸ�ʽ����(��ʾ)��ǩ������Ϊ��
    } else {
        erroyLabel2.setText("�������ڸ�ʽ����ȷ");// ���á��������ڸ�ʽ����(��ʾ)��ǩ������
    }
    if ((validate.validateNumber(sevenField.getText())) && validate.validateData(timeField.getText())) {// ���������롱�ĸ�ʽ�롰�������ڡ��ĸ�ʽ����ȷ
        HistoryDao his = new HistoryDao();// ʵ��������������Ϣ
        Boolean b;//
        b = his.updateNumber(Integer.parseInt(numberField.getText()), sevenField.getText(), timeField.getText());// �޸Ŀ��������Ƿ�ɹ�
        if (b) {// �޸Ŀ�������ɹ�
            addLabel.setText("�޸ĳɹ���");// ���á��޸�״̬��(��ʾ)��ǩ������
            numberField.setText((his.selectNumber() - 1) + "");// ���á������������ı����е�����
            ForecastDao fDao = new ForecastDao();// ʵ�������������Ʊ��¼��Ϣ
            try {
                fDao.awardEvaluate(UpDateNumber.getN());// �޸Ļ�õĽ���
                JOptionPane.showMessageDialog(this, "�޸ĳɹ���", "", JOptionPane.WARNING_MESSAGE);// ������
                this.setVisible(false);// ʹ�޸Ŀ�������Ի��򲻿ɼ�
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else {// �޸Ŀ�������ʧ��
            addLabel.setText("�޸�ʧ�ܣ�");// ���á��޸�״̬��(��ʾ)��ǩ������
        }
    }
}
}

package com.frame;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.dao.ForecastDao;
import com.dao.HistoryDao;
import com.dao.LotteryValidate;

public class HistoryAddframe extends JDialog {// ��Ӻ���Ի���

private JPanel jcontentPane;// �������
private JTextField numberTextField;// �������������ı���
private JTextField sevenTextField;// ���������롱�ı���
private JTextField historytimeTextField;// ������ʱ�䡱�ı���
private JLabel erroyLabel1;// �����������ʽ���󡱱�ǩ
private JLabel erroyLabel2;// ������ʱ���ʽ���󡱱�ǩ
private JLabel addLabel;// �����״̬����ǩ

/**
 * Launch the application.
 */
public static void main(String[] args) {
    try {
        // ������������
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // ʵ������Ӻ���Ի���
                HistoryAddframe frame = new HistoryAddframe();
                // ʹ��Ӻ���Ի���ɼ�
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public HistoryAddframe() {// ��Ӻ���Ի���Ĺ��췽��
    erroyLabel1 = new JLabel("");// �����������ʽ���󡱱�ǩ
    erroyLabel2 = new JLabel("");// ����ʱ���ʽ����ı�ǩ
    addLabel = new JLabel("");// ���״̬�ı�ǩ

    setModal(true);// ʹ��Ӻ���Ի���������ǰ
    setResizable(false);// ��Ӻ���Ի��򲻿ɸı��С
    setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);//���㴰�ڲ��ᱻӦ�ó����еĶԻ�������
    setTitle("��ӿ�������");// ��Ӻ���Ի���ı���
    setIconImage(Toolkit.getDefaultToolkit().getImage(HistoryAddframe.class.getResource("/imgs/log.png")));// ��Ӻ���Ի���ı����ͼ��
    HistoryDao his = new HistoryDao();// ʵ�������쿪�����
    setBounds(500, 150, 540, 481);// ��Ӻ���Ի����λ���Լ����

    jcontentPane = new JPanel();// �������
    jcontentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ����Ǳ߽粼��
    setContentPane(jcontentPane);// ���������������Ӻ���Ի�����

    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// ���ñ�������ͼƬ
    jcontentPane.add(contentPane, BorderLayout.CENTER);// ��ӱ�����嵽�������

    JLabel label = new JLabel("���ǲʵ�");// �����ǲʵڡ���ǩ
    label.setBounds(147, 105, 60, 18);// �����ǲʵڡ���ǩ��λ���Լ����
    contentPane.add(label);// �������ǲʵڡ���ǩ�����Զ��屳�������

    numberTextField = new JTextField();// �������������ı���
    numberTextField.setEditable(false);// ���á������������ı��򲻿ɱ༭
    numberTextField.setBounds(233, 102, 60, 24);// ���á������������ı����λ���Լ����
    contentPane.add(numberTextField);// ���������������ı��������Զ��屳�������
    numberTextField.setColumns(10);// ���á������������ı���Ŀ��

    JLabel label_1 = new JLabel("��");// ���ڡ���ǩ
    label_1.setBounds(319, 105, 22, 18);// ���ڡ���ǩ��λ���Լ����
    contentPane.add(label_1);// �����ڡ���ǩ�����Զ��屳�������

    JLabel label_2 = new JLabel("�������룺");// ���������룺����ǩ
    label_2.setBounds(89, 160, 91, 30);// ���������룺����ǩ��λ���Լ����
    contentPane.add(label_2);// �����������룺����ǩ�����Զ��屳�������

    JLabel label_3 = new JLabel("����ʱ�䣺");// ������ʱ�䣺����ǩ
    label_3.setBounds(89, 234, 91, 24);// ������ʱ�䣺����ǩ��λ���Լ����
    contentPane.add(label_3);// ��������ʱ�䣺����ǩ�����Զ��屳�������

    sevenTextField = new JTextField();// ���������롱�ı���
    sevenTextField.setBounds(184, 159, 157, 33);// ���������롱�ı����λ���Լ����
    contentPane.add(sevenTextField);// �����������롱�ı��������Զ��屳�������
    sevenTextField.setColumns(10);// ���á��������롱�ı���Ŀ��

    historytimeTextField = new JTextField();// ������ʱ�䡱�ı���
    historytimeTextField.setColumns(10);// ���á�����ʱ�䡱�ı���Ŀ��
    historytimeTextField.setBounds(184, 230, 157, 33);// ������ʱ�䡱�ı����λ���Լ����
    contentPane.add(historytimeTextField);// ��������ʱ�䡱�ı��������Զ��屳�������

    JLabel label_4 = new JLabel("(�磺2011-05-21)");// ��(�磺2011-05-21)����ǩ
    label_4.setFont(new Font("����", Font.BOLD | Font.ITALIC, 13));// ���á�(�磺2011-05-21)����ǩ�������ʽ�ʹ�С
    label_4.setBounds(361, 237, 131, 18);// ��(�磺2011-05-21)����ǩ��λ���Լ����
    contentPane.add(label_4);// ����(�磺2011-05-21)����ǩ�����Զ��屳�������

    erroyLabel1.setBounds(194, 128, 157, 18);// �����������ʽ���󡱱�ǩ��λ���Լ����
    contentPane.add(erroyLabel1);// �������������ʽ���󡱱�ǩ�����Զ��屳�������

    erroyLabel2.setBounds(194, 199, 157, 18);// ����ʱ���ʽ����ı�ǩ��λ���Լ����
    contentPane.add(erroyLabel2);// ������ʱ���ʽ����ı�ǩ�����Զ��屳�������

    JButton btnNewButton = new JButton("");// ����ӡ���ť
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// Ϊ����ӡ���ť��Ӷ����¼��ļ���
        }
    });
    btnNewButton.setIcon(new ImageIcon(HistoryAddframe.class.getResource("/img_btn/a04.png")));// ���á���ӡ���ť��ͼ��
    btnNewButton.setBounds(166, 290, 108, 38);// ����ӡ���ť��λ���Լ����
    contentPane.add(btnNewButton);// ������ӡ���ť�����Զ��屳�������

    JButton button = new JButton("");// ���رա���ť
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// Ϊ���رա���ť��Ӷ����¼��ļ���
        }
    });
    button.setIcon(new ImageIcon(HistoryAddframe.class.getResource("/img_btn/a07.png")));// ���á��رա���ť��ͼ��
    button.setBounds(287, 290, 108, 39);// ���رա���ť��λ���Լ����
    contentPane.add(button);// �����رա���ť�����Զ��屳�������

    numberTextField.setText(his.selectNumber() + "");// ���á������������ı����е�����Ϊ��

    addLabel.setFont(new Font("����", Font.BOLD, 18));// ���״̬�ı�ǩ�������С����ʽ
    addLabel.setBounds(194, 55, 157, 33);// ���״̬�ı�ǩ��λ�úͿ��
    contentPane.add(addLabel);// �����״̬�ı�ǩ�����Զ��屳�������
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// ����ӡ���ť��Ӷ����¼��ļ���
    LotteryValidate validate = new LotteryValidate();// ʵ������֤��Ϣ
    if (!validate.validateNumber(sevenTextField.getText())) {// ���������롱�ı�������ġ��������롱�ĸ�ʽ����
        erroyLabel1.setText("���������ʽ����ȷ");// ���á����������ʽ���󡱱�ǩ������
    }
    if (validate.validateNumber(sevenTextField.getText())) {// ���������롱��������ġ��������롱�ĸ�ʽ��ȷ
        erroyLabel1.setText("");// ���á����������ʽ���󡱱�ǩ������Ϊ��
    }
    if (validate.validateData(historytimeTextField.getText())) {// ���������ڡ��ĸ�ʽ��ȷ
        erroyLabel2.setText("");// ���á��������ڸ�ʽ����(��ʾ)��ǩ������Ϊ��
    } else {
        erroyLabel2.setText("�������ڸ�ʽ����ȷ");// ���á��������ڸ�ʽ����(��ʾ)��ǩ������
    }
    if ((validate.validateNumber(sevenTextField.getText()))
            && validate.validateData(historytimeTextField.getText())) {// ����������ȷ�ҿ���ʱ��ĸ�ʽҲ��ȷ
        HistoryDao his = new HistoryDao();// ʵ��������������Ϣ
        Boolean b;// ���������͵ı���b
        b = his.addHistoryDao(Integer.parseInt(numberTextField.getText()), sevenTextField.getText(),
                historytimeTextField.getText());// ���ݿ��Ƿ�ִ����ӿ����������
        if (b) {// ���ݿ�ִ����ӿ����������
            addLabel.setText("��ӳɹ���");// ���á����״̬����ǩ������
            ForecastDao fDao = new ForecastDao();// ʵ�������������Ʊ��¼��Ϣ
            try {
                fDao.awardEvaluate(Integer.parseInt(numberTextField.getText()));// �н����
            } catch (NumberFormatException e1) {// ��������ת���쳣
                e1.printStackTrace();
            } catch (SQLException e1) {// ����SQL�쳣
                e1.printStackTrace();
            }
            numberTextField.setText(his.selectNumber() + "");// ���á������������ı����е�����
        } else {// ���ݿ�û��ִ����ӿ����������
            addLabel.setText("���ʧ�ܣ�");// ���á����״̬����ǩ������
        }
    }
}

protected void do_button_actionPerformed(ActionEvent e) {// ���رա���ť��Ӷ����¼��ļ���
    this.setVisible(false);// ���õ�ǰ���岻�ɼ�
}
}

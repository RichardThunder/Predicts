package com.allpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import com.allchart.DLineChart;
import com.db.ConnMySQL;
import com.frame.BackgroundPanel;

public class Dpanel extends JPanel {// ����λ���������������

public Dpanel() {// ����λ���������������
    this.setBorder(new EmptyBorder(5, 5, 5, 5));// ���õ���λ���������������ı߿���ʽ
    setLayout(new BorderLayout(0, 0));// ���õ���λ���������������Ĳ���Ϊ�߽粼��
    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/a9.png")));// ���ñ�������ͼƬ
    add(contentPane, BorderLayout.CENTER);// ��ӱ�����嵽�������
    contentPane.setLayout(null);// ���ñ������Ĳ���Ϊ���Բ���

    JLabel lblNewLabel = new JLabel(
            "���������ڸ�λ�����ֵİٷֱ�");// �����������ڸ�λ�����ֵİٷֱȡ���ǩ
    lblNewLabel.setBounds(175, 12, 217, 18);// ���á����������ڸ�λ�����ֵİٷֱȡ���ǩ��λ�úͿ��
    contentPane.add(lblNewLabel);// �ѡ����������ڸ�λ�����ֵİٷֱȡ���ǩ��ӵ����������
    // ������1:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label = new JLabel("1:");
    label.setBounds(60, 91, 27, 18);
    contentPane.add(label);
    // ������2:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_1 = new JLabel("2:");
    label_1.setBounds(60, 136, 27, 18);
    contentPane.add(label_1);
    // ������4:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_2 = new JLabel("4:");
    label_2.setBounds(60, 226, 27, 18);
    contentPane.add(label_2);
    // ������3:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_3 = new JLabel("3:");
    label_3.setBounds(60, 181, 27, 18);
    contentPane.add(label_3);
    // ������5:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_4 = new JLabel("5:");
    label_4.setBounds(60, 274, 27, 18);
    contentPane.add(label_4);
    // ������6:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_5 = new JLabel("6:");
    label_5.setBounds(60, 319, 27, 18);
    contentPane.add(label_5);
    // ������7:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_6 = new JLabel("7:");
    label_6.setBounds(60, 364, 27, 18);
    contentPane.add(label_6);
    // ������8:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_7 = new JLabel("8:");
    label_7.setBounds(60, 409, 27, 18);
    contentPane.add(label_7);
    // ������9:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_8 = new JLabel("9:");
    label_8.setBounds(60, 454, 27, 18);
    contentPane.add(label_8);
    // ������0:����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel label_9 = new JLabel("0:");
    label_9.setBounds(60, 44, 27, 29);
    contentPane.add(label_9);
    // �����롰0:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_0 = new JProgressBar();
    progressBar_0.setBounds(94, 43, 321, 32);
    progressBar_0.setForeground(new Color(255, 165, 0));
    progressBar_0.setStringPainted(true);
    progressBar_0.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_0);
    // �����롰1:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_1 = new JProgressBar();
    progressBar_1.setBounds(94, 85, 321, 32);
    progressBar_1.setForeground(new Color(255, 165, 0));
    progressBar_1.setStringPainted(true);
    progressBar_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_1);
    // �����롰2:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_2 = new JProgressBar();
    progressBar_2.setBounds(94, 130, 321, 32);
    progressBar_2.setForeground(new Color(255, 165, 0));
    progressBar_2.setStringPainted(true);
    progressBar_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_2);
    // �����롰3:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_3 = new JProgressBar();
    progressBar_3.setBounds(94, 175, 321, 32);
    progressBar_3.setForeground(new Color(255, 165, 0));
    progressBar_3.setStringPainted(true);
    progressBar_3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_3);
    // �����롰4:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_4 = new JProgressBar();
    progressBar_4.setBounds(94, 220, 321, 32);
    progressBar_4.setForeground(new Color(255, 165, 0));
    progressBar_4.setStringPainted(true);
    progressBar_4.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_4);
    // �����롰5:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_5 = new JProgressBar();
    progressBar_5.setBounds(94, 268, 321, 32);
    progressBar_5.setForeground(new Color(255, 165, 0));
    progressBar_5.setStringPainted(true);
    progressBar_5.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_5);
    // �����롰6:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_6 = new JProgressBar();
    progressBar_6.setBounds(94, 313, 321, 32);
    progressBar_6.setForeground(new Color(255, 165, 0));
    progressBar_6.setStringPainted(true);
    progressBar_6.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_6);
    // �����롰7:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_7 = new JProgressBar();
    progressBar_7.setBounds(94, 358, 321, 32);
    progressBar_7.setForeground(new Color(255, 165, 0));
    progressBar_7.setStringPainted(true);
    progressBar_7.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_7);
    // �����롰8:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_8 = new JProgressBar();
    progressBar_8.setBounds(94, 403, 321, 32);
    progressBar_8.setForeground(new Color(255, 165, 0));
    progressBar_8.setStringPainted(true);
    progressBar_8.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_8);
    // �����롰9:����ǩ��Ӧ�Ľ����������øý�������λ�úͿ�ߡ�ǰ��ɫ��������ʽ�ʹ�С�Լ����ֽ����ַ������Ѹý�������ӵ����������
    JProgressBar progressBar_9 = new JProgressBar();
    progressBar_9.setBounds(94, 448, 321, 32);
    progressBar_9.setForeground(new Color(255, 165, 0));
    progressBar_9.setStringPainted(true);
    progressBar_9.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_9);
    // ������ť�����øð�ť��λ�úͿ�ߡ��ı����ݡ�������ʽ�ʹ�С��ǰ��ɫ���Ѹð�ť��ӵ���������У���Ϊ�ð�ť��Ӷ��������¼�
    JButton button = new JButton();
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);
        }
    });
    button.setBounds(94, 485, 321, 32);
    button.setText("�鿴���10�ڵĵ���λ������������ͼ");
    button.setFont(new Font("��Բ", Font.PLAIN, 16));
    button.setForeground(new Color(0, 102, 153));
    contentPane.add(button);
    // ����ͳ��0���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_0 = new JLabel("");
    l_0.setBounds(439, 49, 104, 18);
    contentPane.add(l_0);
    // ����ͳ��1���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_1 = new JLabel("");
    l_1.setBounds(439, 91, 104, 18);
    contentPane.add(l_1);
    // ����ͳ��2���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_2 = new JLabel("");
    l_2.setBounds(439, 136, 104, 18);
    contentPane.add(l_2);
    // ����ͳ��3���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_3 = new JLabel("");
    l_3.setBounds(439, 181, 104, 18);
    contentPane.add(l_3);
    // ����ͳ��4���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_4 = new JLabel("");
    l_4.setBounds(439, 226, 104, 18);
    contentPane.add(l_4);
    // ����ͳ��5���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_5 = new JLabel("");
    l_5.setBounds(439, 274, 104, 18);
    contentPane.add(l_5);
    // ����ͳ��6���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_6 = new JLabel("");
    l_6.setBounds(439, 319, 104, 18);
    contentPane.add(l_6);
    // ����ͳ��7���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_7 = new JLabel("");
    l_7.setBounds(439, 364, 104, 18);
    contentPane.add(l_7);
    // ����ͳ��8���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_8 = new JLabel("");
    l_8.setBounds(439, 409, 104, 18);
    contentPane.add(l_8);
    // ����ͳ��9���ֵĴ�����ǩ�����øñ�ǩ��λ�úͿ�ߣ��Ѹñ�ǩ��ӵ����������
    JLabel l_9 = new JLabel("");
    l_9.setBounds(439, 454, 104, 18);
    contentPane.add(l_9);

    ConnMySQL con = new ConnMySQL();// ����MySQL���ݿ�

    String ab = "d";// ����λ��������
    // ��õ���λ��������0~9���ֵĴ���
    int i0 = con.getABC(ab, 0);
    int i1 = con.getABC(ab, 1);
    int i2 = con.getABC(ab, 2);
    int i3 = con.getABC(ab, 3);
    int i4 = con.getABC(ab, 4);
    int i5 = con.getABC(ab, 5);
    int i6 = con.getABC(ab, 6);
    int i7 = con.getABC(ab, 7);
    int i8 = con.getABC(ab, 8);
    int i9 = con.getABC(ab, 9);

    double all = i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;// ��ÿ�������
    // ����ͳ�ƿ���������ִ�����ǩ�е��ı�����
    l_0.setText("���� " + i0 + " ��");
    l_1.setText("���� " + i1 + " ��");
    l_2.setText("���� " + i2 + " ��");
    l_3.setText("���� " + i3 + " ��");
    l_4.setText("���� " + i4 + " ��");
    l_5.setText("���� " + i5 + " ��");
    l_6.setText("���� " + i6 + " ��");
    l_7.setText("���� " + i7 + " ��");
    l_8.setText("���� " + i8 + " ��");
    l_9.setText("���� " + i9 + " ��");

    DecimalFormat df = new DecimalFormat(".###");// ��ʽ����������λ��Ч���֣�
    // ���ñ���ʽ���Ľ����ַ�����ֵ�������ý�ͼ����ǰֵ
    progressBar_0.setString(df.format(i0 * 100 / all) + "%");
    progressBar_0.setValue(i0);
    progressBar_1.setString(df.format(i1 * 100 / all) + "%");
    progressBar_1.setValue(i1);
    progressBar_2.setString(df.format(i2 * 100 / all) + "%");
    progressBar_2.setValue(i2);
    progressBar_3.setString(df.format(i3 * 100 / all) + "%");
    progressBar_3.setValue(i3);
    progressBar_4.setString(df.format(i4 * 100 / all) + "%");
    progressBar_4.setValue(i4);
    progressBar_5.setString(df.format(i5 * 100 / all) + "%");
    progressBar_5.setValue(i5);
    progressBar_6.setString(df.format(i6 * 100 / all) + "%");
    progressBar_6.setValue(i6);
    progressBar_7.setString(df.format(i7 * 100 / all) + "%");
    progressBar_7.setValue(i7);
    progressBar_8.setString(df.format(i8 * 100 / all) + "%");
    progressBar_8.setValue(i8);
    progressBar_9.setString(df.format(i9 * 100 / all) + "%");
    progressBar_9.setValue(i9);

}

protected void do_button_actionPerformed(ActionEvent e) {// ���鿴���10�ڵĵ���λ������������ͼ�������¼��ļ���
    DLineChart chart = new DLineChart(null, "����λ������������ͼ");// ����������λ������������ͼ������ͼ�������
    chart.pack();// �������ڵĴ�С������Ӧ����ͼ�������ѡ��С�Ͳ���
    RefineryUtilities.centerFrameOnScreen(chart);// ������ͼ����������Ļ�м�
    chart.setVisible(true);// ��������ͼ�������ɼ�
}

}

package com.allpanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import com.db.ConnMySQL;
import com.allchart.ALineChart;
import com.frame.BackgroundPanel;
import java.text.DecimalFormat;
import org.jfree.ui.RefineryUtilities;


public class Apanel extends JPanel {
public Apanel() {// ��һλ����������������
    this.setBorder(new EmptyBorder(5, 5, 5, 5));// ���õ�һλ���������������ı߿���ʽ
    setLayout(new BorderLayout(0, 0));// ���õ�һλ���������������Ĳ���Ϊ�߽粼��
    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    // ���ñ�������ͼƬ
    contentPane.setImage(
            getToolkit().getImage(getClass().getResource("/imgs/a9.png"))
    );
    add(contentPane, BorderLayout.CENTER);// ��ӱ�����嵽��һλ�����������������м�
    contentPane.setLayout(null);// ���ñ������Ĳ���Ϊ���Բ���

    // �����������ڸ�λ�����ֵİٷֱȡ���ǩ
    JLabel lblNewLabel = new JLabel("���������ڸ�λ�����ֵİٷֱ�");
    // ���á����������ڸ�λ�����ֵİٷֱȡ���ǩ��λ�úͿ��
    lblNewLabel.setBounds(175, 12, 217, 18);
    // �ѡ����������ڸ�λ�����ֵİٷֱȡ���ǩ��ӵ����������
    contentPane.add(lblNewLabel);
    JLabel label = new JLabel("1:");// ��1:����ǩ
    label.setBounds(60, 91, 27, 18);// ���á�1:����ǩ��λ�úͿ��
    contentPane.add(label);// �ѡ�1:����ǩ��ӵ����������
    JLabel label_1 = new JLabel("2:");// ��2:����ǩ
    label_1.setBounds(60, 136, 27, 18);// ���á�2:����ǩ��λ�úͿ��
    contentPane.add(label_1);// �ѡ�2:����ǩ��ӵ����������
    JLabel label_2 = new JLabel("4:");// ��4:����ǩ
    label_2.setBounds(60, 226, 27, 18);// ���á�4:����ǩ��λ�úͿ��
    contentPane.add(label_2);// �ѡ�4:����ǩ��ӵ����������
    JLabel label_3 = new JLabel("3:");// ��3:����ǩ
    label_3.setBounds(60, 181, 27, 18);// ���á�3:����ǩ��λ�úͿ��
    contentPane.add(label_3);// �ѡ�3:����ǩ��ӵ����������
    JLabel label_4 = new JLabel("5:");// ��5:����ǩ
    label_4.setBounds(60, 274, 27, 18);// ���á�5:����ǩ��λ�úͿ��
    contentPane.add(label_4);// �ѡ�5:����ǩ��ӵ����������
    JLabel label_5 = new JLabel("6:");// ��6:����ǩ
    label_5.setBounds(60, 319, 27, 18);// ���á�6:����ǩ��λ�úͿ��
    contentPane.add(label_5);// �ѡ�6:����ǩ��ӵ����������
    JLabel label_6 = new JLabel("7:");// ��7:����ǩ
    label_6.setBounds(60, 364, 27, 18);// ���á�7:����ǩ��λ�úͿ��
    contentPane.add(label_6);// �ѡ�7:����ǩ��ӵ����������
    JLabel label_7 = new JLabel("8:");// ��8:����ǩ
    label_7.setBounds(60, 409, 27, 18);// ���á�8:����ǩ��λ�úͿ��
    contentPane.add(label_7);// �ѡ�8:����ǩ��ӵ����������
    JLabel label_8 = new JLabel("9:");// ��9:����ǩ
    label_8.setBounds(60, 454, 27, 18);// ���á�9:����ǩ��λ�úͿ��
    contentPane.add(label_8);// �ѡ�9:����ǩ��ӵ����������
    JLabel label_9 = new JLabel("0:");// ��0:����ǩ
    label_9.setBounds(60, 44, 27, 29);// ���á�0:����ǩ��λ�úͿ��
    contentPane.add(label_9);// �ѡ�0:����ǩ��ӵ����������

//��ӽ�����
    JProgressBar progressBar_0 = new JProgressBar();// �롰0:����ǩ��Ӧ�Ľ�����
    progressBar_0.setBounds(94, 43, 321, 32);// �����롰0:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_0.setForeground(new Color(255, 165, 0));// �����롰0:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_0.setStringPainted(true);// �����롰0:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰0:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_0.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_0);// ���롰0:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_1 = new JProgressBar();// �롰1:����ǩ��Ӧ�Ľ�����
    progressBar_1.setBounds(94, 85, 321, 32);// �����롰1:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_1.setForeground(new Color(255, 165, 0));// �����롰1:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_1.setStringPainted(true);// �����롰1:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰1:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_1);// ���롰1:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_2 = new JProgressBar();// �롰2:����ǩ��Ӧ�Ľ�����
    progressBar_2.setBounds(94, 130, 321, 32);// �����롰2:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_2.setForeground(new Color(255, 165, 0));// �����롰2:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_2.setStringPainted(true);// �����롰1:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰2:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_2);// ���롰2:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_3 = new JProgressBar();// �롰3:����ǩ��Ӧ�Ľ�����
    progressBar_3.setBounds(94, 175, 321, 32);// �����롰3:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_3.setForeground(new Color(255, 165, 0));// �����롰3:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_3.setStringPainted(true);// �����롰3:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰3:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_3);// ���롰3:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_4 = new JProgressBar();// �롰4:����ǩ��Ӧ�Ľ�����
    progressBar_4.setBounds(94, 220, 321, 32);// �����롰4:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_4.setForeground(new Color(255, 165, 0));// �����롰4:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_4.setStringPainted(true);// �����롰4:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰4:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_4.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_4);// ���롰4:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_5 = new JProgressBar();// �롰5:����ǩ��Ӧ�Ľ�����
    progressBar_5.setBounds(94, 268, 321, 32);// �����롰5:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_5.setForeground(new Color(255, 165, 0));// �����롰5:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_5.setStringPainted(true);// �����롰5:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰5:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_5.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_5);// ���롰5:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_6 = new JProgressBar();// �롰6:����ǩ��Ӧ�Ľ�����
    progressBar_6.setBounds(94, 313, 321, 32);// �����롰6:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_6.setForeground(new Color(255, 165, 0));// �����롰6:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_6.setStringPainted(true);// �����롰6:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰6:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_6.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_6);// ���롰6:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_7 = new JProgressBar();// �롰7:����ǩ��Ӧ�Ľ�����
    progressBar_7.setBounds(94, 358, 321, 32);// �����롰7:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_7.setForeground(new Color(255, 165, 0));// �����롰7:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_7.setStringPainted(true);// �����롰7:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰7:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_7.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_7);// ���롰7:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_8 = new JProgressBar();// �롰8:����ǩ��Ӧ�Ľ�����
    progressBar_8.setBounds(94, 403, 321, 32);// �����롰8:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_8.setForeground(new Color(255, 165, 0));// �����롰8:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_8.setStringPainted(true);// �����롰8:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰8:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_8.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_8);// ���롰8:����ǩ��Ӧ�Ľ�������ӵ����������
    JProgressBar progressBar_9 = new JProgressBar();// �롰9:����ǩ��Ӧ�Ľ�����
    progressBar_9.setBounds(94, 448, 321, 32);// �����롰9:����ǩ��Ӧ�Ľ�������λ�úͿ��
    progressBar_9.setForeground(new Color(255, 165, 0));// �����롰9:����ǩ��Ӧ�Ľ�������ǰ��ɫ
    progressBar_9.setStringPainted(true);// �����롰9:����ǩ��Ӧ�Ľ��������ֵĽ����ַ���
    // �����롰9:����ǩ��Ӧ�Ľ�������������ʽ�ʹ�С
    progressBar_9.setFont(new Font("΢���ź�", Font.PLAIN, 14));
    contentPane.add(progressBar_9);// ���롰9:����ǩ��Ӧ�Ľ�������ӵ����������
//���ͳ�Ʊ�ǩ
    JLabel l_0 = new JLabel("");// ͳ��0���ֵĴ�����ǩ
    l_0.setBounds(439, 49, 104, 18);// ����ͳ��0���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_0);// ��ͳ��0���ֵĴ�����ǩ��ӵ����������
    JLabel l_1 = new JLabel("");// ͳ��1���ֵĴ�����ǩ
    l_1.setBounds(439, 91, 104, 18);// ����ͳ��1���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_1);// ��ͳ��1���ֵĴ�����ǩ��ӵ����������
    JLabel l_2 = new JLabel("");// ͳ��2���ֵĴ�����ǩ
    l_2.setBounds(439, 136, 104, 18);// ����ͳ��2���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_2);// ��ͳ��2���ֵĴ�����ǩ��ӵ����������
    JLabel l_3 = new JLabel("");// ͳ��3���ֵĴ�����ǩ
    l_3.setBounds(439, 181, 104, 18);// ����ͳ��3���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_3);// ��ͳ��3���ֵĴ�����ǩ��ӵ����������
    JLabel l_4 = new JLabel("");// ͳ��4���ֵĴ�����ǩ
    l_4.setBounds(439, 226, 104, 18);// ����ͳ��4���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_4);// ��ͳ��4���ֵĴ�����ǩ��ӵ����������
    JLabel l_5 = new JLabel("");// ͳ��5���ֵĴ�����ǩ
    l_5.setBounds(439, 274, 104, 18);// ����ͳ��5���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_5);// ��ͳ��5���ֵĴ�����ǩ��ӵ����������
    JLabel l_6 = new JLabel("");// ͳ��6���ֵĴ�����ǩ
    l_6.setBounds(439, 319, 104, 18);// ����ͳ��6���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_6);// ��ͳ��6���ֵĴ�����ǩ��ӵ����������
    JLabel l_7 = new JLabel("");// ͳ��7���ֵĴ�����ǩ
    l_7.setBounds(439, 364, 104, 18);// ����ͳ��7���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_7);// ��ͳ��7���ֵĴ�����ǩ��ӵ����������
    JLabel l_8 = new JLabel("");// ͳ��8���ֵĴ�����ǩ
    l_8.setBounds(439, 409, 104, 18);// ����ͳ��8���ֵĴ�����ǩ��λ�úͿ��
    contentPane.add(l_8);// ��ͳ��8���ֵĴ�����ǩ��ӵ����������
    JLabel l_9 = new JLabel("");// ͳ��9���ֵĴ�����ǩ
    l_9.setBounds(439, 454, 104, 18);// ����ͳ��9���ֵĴ�����ǩ��λ�úͿ��
    //�������ݿ�
    contentPane.add(l_9);// ��ͳ��9���ֵĴ�����ǩ��ӵ����������
    ConnMySQL con = new ConnMySQL();// ����MySQL���ݿ�
    String ab = "a";// ��һλ��������
    int i0 = con.getABC(ab, 0);// ��õ�һλ��������0���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i1 = con.getABC(ab, 1);// ��õ�һλ��������1���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i2 = con.getABC(ab, 2);// ��õ�һλ��������2���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i3 = con.getABC(ab, 3);// ��õ�һλ��������3���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i4 = con.getABC(ab, 4);// ��õ�һλ��������4���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i5 = con.getABC(ab, 5);// ��õ�һλ��������5���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i6 = con.getABC(ab, 6);// ��õ�һλ��������6���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i7 = con.getABC(ab, 7);// ��õ�һλ��������7���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i8 = con.getABC(ab, 8);// ��õ�һλ��������8���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
    int i9 = con.getABC(ab, 9);// ��õ�һλ��������9���ֵĴ���
    con.closeConnection();// �ر����ݿ�����
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
    double all = i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;// ��ÿ�������
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

    JButton button = new JButton();// ��ť
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// Ϊ��ť��Ӷ����¼��ļ���
        }
    });
    button.setBounds(94, 485, 321, 32);// ���ð�ť��λ�úͿ��
    button.setText("�鿴���10�ڵĵ�һλ������������ͼ");// ���ð�ť�е��ı�����
    button.setFont(new Font("��Բ", Font.PLAIN, 16));// ���ð�ť�е�������ʽ�ʹ�С
    button.setForeground(new Color(0, 102, 153));// ���ð�ť��ǰ��ɫ
    contentPane.add(button);// �Ѱ�ť��ӵ����������
}
// ���鿴���10�ڵĵ�һλ������������ͼ�������¼��ļ���
protected void do_button_actionPerformed(ActionEvent e) {
    // ��������һλ������������ͼ������ͼ�������
    ALineChart chart = new ALineChart(null, "��һλ������������ͼ");
    chart.pack();// �������ڵĴ�С������Ӧ����ͼ�������ѡ��С�Ͳ���
    RefineryUtilities.centerFrameOnScreen(chart);// ������ͼ����������Ļ�м�
    chart.setVisible(true);// ��������ͼ�������ɼ�
}






}


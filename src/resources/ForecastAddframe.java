package resources;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.dao.ForecastDao;
import com.dao.HistoryDao;
import com.dao.LotteryValidate;
import com.frame.BackgroundPanel;

public class ForecastAddframe extends JDialog implements Runnable, ActionListener {// ���ѡ�ŶԻ���
	private JPanel jpl;// �������
	JButton bt1 = new JButton();// ��ʾ���ѡ�ŵ�1λ�İ�ť
	JButton bt2 = new JButton();// ��ʾ���ѡ�ŵ�2λ�İ�ť
	JButton bt3 = new JButton();// ��ʾ���ѡ�ŵ�3λ�İ�ť
	JButton bt4 = new JButton();// ��ʾ���ѡ�ŵ�4λ�İ�ť
	JButton bt5 = new JButton();// ��ʾ���ѡ�ŵ�5λ�İ�ť
	JButton bt6 = new JButton();// ��ʾ���ѡ�ŵ�6λ�İ�ť
	JButton bt7 = new JButton();// ��ʾ���ѡ�ŵ�7λ�İ�ť
	JButton but = new JButton("");// ����ѡһע����ť
	private final JTextField sevenTextField = new JTextField();// ��ѡ�ź��롱�ı���
	private final JLabel label = new JLabel("��");// ���ڡ���ǩ
	private final JLabel label_1 = new JLabel("��");// ���ڡ���ǩ
	private final JTextField numberTextField = new JTextField();// �������������ı���
	private final JButton btnNewButton = new JButton("");// �����򡱰�ť
	private final JButton btnNewButton_1 = new JButton("");// ���رա���ť
	private final JLabel noteLabel = new JLabel("");// ����ʾ����ǩ
	// ��ѡ��0~9
	private final JCheckBox ckBox_1 = new JCheckBox("1");
	private final JCheckBox ckBox_2 = new JCheckBox("2");
	private final JCheckBox ckBox_3 = new JCheckBox("3");
	private final JCheckBox ckBox_4 = new JCheckBox("4");
	private final JCheckBox ckBox_5 = new JCheckBox("5");
	private final JCheckBox ckBox_6 = new JCheckBox("6");
	private final JCheckBox ckBox_7 = new JCheckBox("7");
	private final JCheckBox ckBox_8 = new JCheckBox("8");
	private final JCheckBox ckBox_9 = new JCheckBox("9");
	private final JCheckBox ckBox_0 = new JCheckBox("0");
	private final JLabel lblTitle_1 = new JLabel("����");// �����롱��ǩ
	private final JLabel lblSameNum_1 = new JLabel("ͬ�ŵĸ���");// ��ͬ�ŵĸ�������ǩ
	private final JLabel lblTitle_2 = new JLabel("����");// �����롱��ǩ
	private final JLabel lblSameNum_2 = new JLabel("ͬ�ŵĸ���");// ��ͬ�ŵĸ�������ǩ
	// ��0~9��ѡ���Ӧ���ı���
	private JTextField tf_1;
	private JTextField tf_2;
	private JTextField tf_3;
	private JTextField tf_4;
	private JTextField tf_5;
	private JTextField tf_6;
	private JTextField tf_7;
	private JTextField tf_8;
	private JTextField tf_9;
	private JTextField tf_0;
	private JRadioButton rdbtnHave;// ��ѡ��ť���С�
	private JRadioButton rabtnNone;// ��ѡ��ť���ޡ�
	boolean bol = true;// ����ѡ��ʱ����Ч���Ŀ���(true)����ֹ(false)
	int index = 0;// ��ʼ�����ű任ʱ��
	int i = 0;// ��ʼ������
	int a;// ���ѡ�ŵ�1λ������
	int b;// ���ѡ�ŵ�2λ������
	int c;// ���ѡ�ŵ�3λ������
	int d;// ���ѡ�ŵ�4λ������
	int e;// ���ѡ�ŵ�5λ������
	int f;// ���ѡ�ŵ�6λ������
	int g;// ���ѡ�ŵ�7λ������

	public ForecastAddframe() {// ���ѡ�ŶԻ���Ĺ��췽��
		setModal(true);// ʹ���ѡ�ŶԻ���������ǰ
		setTitle("���ѡ��");// �������ѡ�ŶԻ���ı���
		// �������ѡ�ŶԻ���ı���ͼ��
		setIconImage(Toolkit.getDefaultToolkit().getImage(ForecastAddframe.class.getResource("/imgs/log.png")));
		setResizable(false);// ���ѡ�ŶԻ��򲻿ɸı��С
		HistoryDao his = new HistoryDao();// ʵ��������������Ϣ
		numberTextField.setText(his.selectNumber() + "");// ���á������������ı����е�����
		numberTextField.setEditable(false);// ���á������������ı��򲻿ɱ༭
		numberTextField.setBounds(331, 88, 64, 24);// ���á������������ı����λ�úͿ��
		numberTextField.setColumns(10);// ���á������������ı���Ŀ��
		sevenTextField.setBounds(327, 410, 170, 27);// ���á�ѡ�ź��롱�ı����λ�úͿ��
		sevenTextField.setColumns(10);// ���á�ѡ�ź��롱�ı���Ŀ��
		jpl = new JPanel();// �������
		jpl.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
		setContentPane(jpl);// ����������������ѡ�ŶԻ�����
		BackgroundPanel pl = new BackgroundPanel();// �Զ��屳�����
		pl.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// ���ñ�������ͼƬ
		jpl.add(pl, BorderLayout.CENTER);// ��ӱ�����嵽�������
		// ���á���ѡһע����ť��ͼ��
		but.setIcon(new ImageIcon(ForecastAddframe.class.getResource("/img_btn/111.png")));
		but.setBounds(240, 410, 62, 28);// ���á���ѡһע����ť��λ���Լ����
		pl.add(but);// �ѡ���ѡһע����ť�����Զ��屳�������
		but.addActionListener(this);// Ϊ����ѡһע����ť��Ӷ����¼��ļ���
		this.getContentPane().add(pl);// �����ѡ�ŶԻ����еĿؼ������Զ��屳�������
		/*
		 * ������ʾ���ѡ�ŵ�1λ~��7λ�İ�ť��λ���Լ���ߣ� ������ʾ���ѡ�ŵ�1λ~��7λ�İ�ť�����Զ��屳�������
		 */
		bt1.setBounds(74, 128, 84, 63);
		pl.add(bt1);
		bt2.setBounds(159, 128, 84, 63);
		pl.add(bt2);
		bt3.setBounds(244, 128, 84, 63);
		pl.add(bt3);
		bt4.setBounds(329, 128, 84, 63);
		pl.add(bt4);
		bt5.setBounds(414, 128, 84, 63);
		pl.add(bt5);
		bt6.setBounds(499, 128, 84, 63);
		pl.add(bt6);
		bt7.setBounds(584, 128, 84, 63);
		pl.add(bt7);
		pl.add(sevenTextField);// �ѡ�ѡ�ź��롱�ı��������Զ��屳�������
		pl.add(numberTextField);// �ѡ������������ı��������Զ��屳�������
		label.setBounds(299, 90, 22, 18);// ���á��ڡ���ǩ��λ���Լ����
		pl.add(label);// �ѡ��ڡ���ǩ�����Զ��屳�������
		label_1.setBounds(415, 90, 22, 18);// ���á��ڡ���ǩ��λ���Լ����
		pl.add(label_1);// �ѡ��ڡ���ǩ�����Զ��屳�������
		// ���á����򡱰�ť��ͼ��
		btnNewButton.setIcon(new ImageIcon(ForecastAddframe.class.getResource("/img_btn/a02.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);// Ϊ�����򡱰�ť��Ӷ����¼��ļ���
			}
		});
		btnNewButton.setBounds(239, 451, 109, 74);// ���á����򡱰�ť��λ�úͿ��
		pl.add(btnNewButton);// �ѡ����򡱰�ť�����Զ��屳�������
		// ���á��رա���ť��ͼ��
		btnNewButton_1.setIcon(new ImageIcon(ForecastAddframe.class.getResource("/img_btn/a07.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);// Ϊ���رա���ť��Ӷ����¼��ļ���
			}
		});
		btnNewButton_1.setBounds(389, 451, 108, 79);// ���á��رա���ť��λ�úͿ��
		pl.add(btnNewButton_1);// �ѡ��رա���ť�����Զ��屳�������
		noteLabel.setBounds(507, 413, 202, 20);// ���á���ʾ����ǩ��λ�úͿ��
		noteLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));// ���á���ʾ����ǩ���������ʽ�ʹ�С
		noteLabel.setForeground(Color.RED);// ���á���ʾ����ǩ���������ɫ
		pl.add(noteLabel);// �ѡ���ʾ����ǩ��ӵ����������
		// ����ѡҪ�󣺡���ǩ
		JLabel label_2 = new JLabel("��ѡҪ��");
		label_2.setBounds(280, 214, 62, 15);
		pl.add(label_2);
		// ��ѡ��ť���С�
		rdbtnHave = new JRadioButton("��");
		rdbtnHave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnHave_actionPerformed(e);// ��ѡ��ť���С������¼��ļ���
			}
		});
		rdbtnHave.setBounds(350, 210, 40, 23);
		pl.add(rdbtnHave);
		// ��ѡ��ť���ޡ�
		rabtnNone = new JRadioButton("��");
		rabtnNone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rabtnNone_actionPerformed(e);// ��ѡ��ť���ޡ������¼��ļ���
			}
		});
		rabtnNone.setSelected(true);
		rabtnNone.setBounds(415, 210, 40, 23);
		pl.add(rabtnNone);
		// ��ť��
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnHave);
		group.add(rabtnNone);
		// ��ѡ��1��
		ckBox_1.setEnabled(false);
		ckBox_1.setBounds(240, 269, 38, 23);
		pl.add(ckBox_1);
		// ��ѡ��2��
		ckBox_2.setEnabled(false);
		ckBox_2.setBounds(240, 295, 38, 23);
		pl.add(ckBox_2);
		// ��ѡ��3��
		ckBox_3.setEnabled(false);
		ckBox_3.setBounds(240, 321, 38, 23);
		pl.add(ckBox_3);
		// ��ѡ��4��
		ckBox_4.setEnabled(false);
		ckBox_4.setBounds(240, 347, 38, 23);
		pl.add(ckBox_4);
		// ��ѡ��5��
		ckBox_5.setEnabled(false);
		ckBox_5.setBounds(240, 373, 38, 23);
		pl.add(ckBox_5);
		// ��ѡ��6��
		ckBox_6.setEnabled(false);
		ckBox_6.setBounds(381, 269, 38, 23);
		pl.add(ckBox_6);
		// ��ѡ��7��
		ckBox_7.setEnabled(false);
		ckBox_7.setBounds(381, 295, 38, 23);
		pl.add(ckBox_7);
		// ��ѡ��8��
		ckBox_8.setEnabled(false);
		ckBox_8.setBounds(381, 321, 38, 23);
		pl.add(ckBox_8);
		// ��ѡ��9��
		ckBox_9.setEnabled(false);
		ckBox_9.setBounds(381, 347, 38, 23);
		pl.add(ckBox_9);
		// ��ѡ��0��
		ckBox_0.setEnabled(false);
		ckBox_0.setBounds(381, 373, 38, 23);
		pl.add(ckBox_0);
		// �븴ѡ��1����Ӧ���ı���
		tf_1 = new JTextField();
		tf_1.setEnabled(false);
		tf_1.setBounds(290, 270, 66, 21);
		pl.add(tf_1);
		tf_1.setColumns(10);
		// �븴ѡ��2����Ӧ���ı���
		tf_2 = new JTextField();
		tf_2.setEnabled(false);
		tf_2.setBounds(290, 296, 66, 21);
		pl.add(tf_2);
		tf_2.setColumns(10);
		// �븴ѡ��3����Ӧ���ı���
		tf_3 = new JTextField();
		tf_3.setEnabled(false);
		tf_3.setBounds(290, 322, 66, 21);
		pl.add(tf_3);
		tf_3.setColumns(10);
		// �븴ѡ��4����Ӧ���ı���
		tf_4 = new JTextField();
		tf_4.setEnabled(false);
		tf_4.setBounds(290, 348, 66, 21);
		pl.add(tf_4);
		tf_4.setColumns(10);
		// �븴ѡ��5����Ӧ���ı���
		tf_5 = new JTextField();
		tf_5.setEnabled(false);
		tf_5.setBounds(290, 374, 66, 21);
		pl.add(tf_5);
		tf_5.setColumns(10);
		// �븴ѡ��6����Ӧ���ı���
		tf_6 = new JTextField();
		tf_6.setEnabled(false);
		tf_6.setBounds(431, 270, 66, 21);
		pl.add(tf_6);
		tf_6.setColumns(10);
		// �븴ѡ��7����Ӧ���ı���
		tf_7 = new JTextField();
		tf_7.setEnabled(false);
		tf_7.setBounds(431, 296, 66, 21);
		pl.add(tf_7);
		tf_7.setColumns(10);
		// �븴ѡ��8����Ӧ���ı���
		tf_8 = new JTextField();
		tf_8.setEnabled(false);
		tf_8.setBounds(431, 322, 66, 21);
		pl.add(tf_8);
		tf_8.setColumns(10);
		// �븴ѡ��9����Ӧ���ı���
		tf_9 = new JTextField();
		tf_9.setEnabled(false);
		tf_9.setBounds(431, 348, 66, 21);
		pl.add(tf_9);
		tf_9.setColumns(10);
		// �븴ѡ��0����Ӧ���ı���
		tf_0 = new JTextField();
		tf_0.setEnabled(false);
		tf_0.setBounds(431, 374, 66, 21);
		pl.add(tf_0);
		tf_0.setColumns(10);
		// �����롱��ǩ
		lblTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_1.setBounds(240, 249, 38, 15);
		pl.add(lblTitle_1);
		// ��ͬ�ŵĸ�������ǩ
		lblSameNum_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSameNum_1.setBounds(290, 249, 66, 15);
		pl.add(lblSameNum_1);
		// �����롱��ǩ
		lblTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_2.setBounds(381, 249, 38, 15);
		pl.add(lblTitle_2);
		// ��ͬ�ŵĸ�������ǩ
		lblSameNum_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSameNum_2.setBounds(431, 249, 66, 15);
		pl.add(lblSameNum_2);
		this.setBounds(350, 100, 753, 626);// ���ѡ�ŶԻ����λ�úͿ��
	}

	// ��ѡ��ť���ޡ������¼��ļ���
	protected void do_rabtnNone_actionPerformed(ActionEvent e) {
		
	}

	// ��ѡ��ť���С������¼��ļ���
	protected void do_rdbtnHave_actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void run() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	// ��������Ӷ����¼��ļ���
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
	}

	// ���رա���ť�����¼��ļ���
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
	}

	// ��ѡ���ѡ���¼�
	private void itemEvent(JCheckBox ckBox, JTextField tf) {
		
	}

	// ���ı��������ת��Ϊint��
	private void exchangeInteger(JTextField tf) {
		
	}
}

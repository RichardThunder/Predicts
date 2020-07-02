package com.frame;

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
protected void do_rdbtnHave_actionPerformed(ActionEvent e) {// ��ѡ��ť���С������¼��ļ���
	// ���ø�ѡ��
	ckBox_1.setEnabled(true);
	ckBox_2.setEnabled(true);
	ckBox_3.setEnabled(true);
	ckBox_4.setEnabled(true);
	ckBox_5.setEnabled(true);
	ckBox_6.setEnabled(true);
	ckBox_7.setEnabled(true);
	ckBox_8.setEnabled(true);
	ckBox_9.setEnabled(true);
	ckBox_0.setEnabled(true);
	// ��ѡ���ѡ���¼�
	itemEvent(ckBox_1, tf_1);
	itemEvent(ckBox_2, tf_2);
	itemEvent(ckBox_3, tf_3);
	itemEvent(ckBox_4, tf_4);
	itemEvent(ckBox_5, tf_5);
	itemEvent(ckBox_6, tf_6);
	itemEvent(ckBox_7, tf_7);
	itemEvent(ckBox_8, tf_8);
	itemEvent(ckBox_9, tf_9);
	itemEvent(ckBox_0, tf_0);
}
  private String itemEvent(JCheckBox ckBox, JTextField tf) {// ��ѡ���ѡ���¼�
	ckBox.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {// ��ѡ��ѡ��
				tf.setEnabled(true);// ���ø�ѡ��
				tf.setText("1");// �����ı����е�����Ϊ1
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {// ��ѡ��û��ѡ��
				tf.setText("");// ����ı����е�����
				tf.setEnabled(false);// ���ø�ѡ��
			}
		}
	});
	return ckBox.getText() + "��" + tf.getText();// ���ظ�ѡ�����ı����е��ı�����
}

// ��ѡ��ť���ޡ������¼��ļ���
	protected void do_rabtnNone_actionPerformed(ActionEvent e) {
		// ��ѡ��û��ѡ��
		ckBox_1.setSelected(false);
		ckBox_2.setSelected(false);
		ckBox_3.setSelected(false);
		ckBox_4.setSelected(false);
		ckBox_5.setSelected(false);
		ckBox_6.setSelected(false);
		ckBox_7.setSelected(false);
		ckBox_8.setSelected(false);
		ckBox_9.setSelected(false);
		ckBox_0.setSelected(false);
		// ���ø�ѡ��
		ckBox_1.setEnabled(false);
		ckBox_2.setEnabled(false);
		ckBox_3.setEnabled(false);
		ckBox_4.setEnabled(false);
		ckBox_5.setEnabled(false);
		ckBox_6.setEnabled(false);
		ckBox_7.setEnabled(false);
		ckBox_8.setEnabled(false);
		ckBox_9.setEnabled(false);
		ckBox_0.setEnabled(false);
		// ����ı����е�����
		tf_1.setText("");
		tf_2.setText("");
		tf_3.setText("");
		tf_4.setText("");
		tf_5.setText("");
		tf_6.setText("");
		tf_7.setText("");
		tf_8.setText("");
		tf_9.setText("");
		tf_0.setText("");
		// �����ı���
		tf_1.setEnabled(false);
		tf_2.setEnabled(false);
		tf_3.setEnabled(false);
		tf_4.setEnabled(false);
		tf_5.setEnabled(false);
		tf_6.setEnabled(false);
		tf_7.setEnabled(false);
		tf_8.setEnabled(false);
		tf_9.setEnabled(false);
		tf_0.setEnabled(false);
	}

	public static void main(String[] args) {
		try {
			// �������ѡ�ŶԻ�����
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		new ForecastAddframe();// ʵ�������ѡ�ŶԻ���
	}
	@Override
	public void run() {
		// ��ѡ��ť���С���ѡ�����ı���Ϊ��ʱ
		if (rdbtnHave.isSelected() && tf_1.getText().equals("") && tf_2.getText().equals("")
				&& tf_3.getText().equals("") && tf_4.getText().equals("") && tf_5.getText().equals("")
				&& tf_6.getText().equals("") && tf_7.getText().equals("") && tf_8.getText().equals("")
				&& tf_9.getText().equals("") && tf_0.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"���棺�ı�����Ϊ�գ�",
					"����",
					JOptionPane.WARNING_MESSAGE);// ������ʾ��
			but.setEnabled(true);// ���á���ѡһע����ť����
			return;
		}

		// ��ѡ��ť���С���ѡ�����ı����е�����֮�ʹ���7
		if (rdbtnHave.isSelected() && (exchangeInteger(tf_1) + exchangeInteger(tf_2)
				+ exchangeInteger(tf_3) + exchangeInteger(tf_4) + exchangeInteger(tf_5)
				+ exchangeInteger(tf_6) + exchangeInteger(tf_7) + exchangeInteger(tf_8)
				+ exchangeInteger(tf_9) + exchangeInteger(tf_0)) > 7) {
			JOptionPane.showMessageDialog(null,
					"���棺�����������7����",
					"����",
					JOptionPane.WARNING_MESSAGE);// ������ʾ��
			but.setEnabled(true);// ���á���ѡһע����ť����
			return;
		}




		String s = "";// �洢������ɵ�ѡ��
		Random ram = new Random();// ���������
		if (rabtnNone.isSelected()) {// ��ѡ��ť���ޡ���ѡ��
			while (bol) {
				try {
					if (i >= 10) {// i��ʾ���ţ�����i���ܴ���10
						i = 0;
					}
					if (index < (500 - ram.nextInt(20))) {// ����ֹͣʱ��500�����ȥ20���ڵ������
						a = i;// ������ѡ�ŵ�1λ������
						bt1.setIcon(new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + i + ".png")));// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�1λ��ҡ�����
					}
					if (index < (1000 - ram.nextInt(20))) {// ����ֹͣʱ��1000�����ȥ20���ڵ������
						b = i;// ������ѡ�ŵ�2λ������
						bt2.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + i + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�2λ��ҡ�����
					}
					if (index < (1500 - ram.nextInt(20))) {// ����ֹͣʱ��1500�����ȥ20���ڵ������
						c = i;// ������ѡ�ŵ�3λ������
						bt3.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + i + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�3λ��ҡ�����
					}
					if (index < (2000 - ram.nextInt(20))) {// ����ֹͣʱ��2000�����ȥ20���ڵ������
						d = i;// ������ѡ�ŵ�4λ������
						bt4.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + i + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�4λ��ҡ�����
					}
					if (index < (3000 - ram.nextInt(20))) {// ����ֹͣʱ��3000�����ȥ20���ڵ������
						e = i;// ������ѡ�ŵ�5λ������
						bt5.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + i + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�5λ��ҡ�����
					}
					if (index < (4000 - ram.nextInt(20))) {// ����ֹͣʱ��4000�����ȥ20���ڵ������
						f = i;// ������ѡ�ŵ�6λ������
						bt6.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + i + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�6λ��ҡ�����
					}
					if (index < (5000 - ram.nextInt(20))) {// ����ֹͣʱ��5000�����ȥ20���ڵ������
						g = i;// ������ѡ�ŵ�7λ������
						bt7.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + i + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�7λ��ҡ�����
					}
					switch (index) {// �Խ��ű任ʱ��Ϊ�����Ķ��֧���
						case 500:// 500����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����еĿ�����
							sevenTextField.setText(s + a);// �ѵ�1λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 1000:// 1000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����еĵ�1λ����
							sevenTextField.setText(s + b);// �ѵ�2λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 1500:// 1500����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ2λ����
							sevenTextField.setText(s + c);// �ѵ�3λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 2000:// 2000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ3λ����
							sevenTextField.setText(s + d);// �ѵ�4λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 3000:// 3000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ4λ����
							sevenTextField.setText(s + e);// �ѵ�5λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 4000:// 4000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ5λ����
							sevenTextField.setText(s + f);// �ѵ�6λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 5000:// 5000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ6λ����
							sevenTextField.setText(s + g);// �ѵ�7λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							bol = false;//
							but.setEnabled(true);// ���á���ѡһע����ť����
							break;
					}
					i++;// i = i + 1
					Thread.sleep(0);// �̲߳�����
					index++;// index = index + 1
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (rdbtnHave.isSelected()) {// ��ѡ��ť���С���ѡ��
			List<Integer> list = new ArrayList<>();// �����롱����
			String[] str = new String[10];// �洢��ѡ�����ı������ı����ݵ�����
			// �������
			str[0] = itemEvent(ckBox_1, tf_1);
			str[1] = itemEvent(ckBox_2, tf_2);
			str[2] = itemEvent(ckBox_3, tf_3);
			str[3] = itemEvent(ckBox_4, tf_4);
			str[4] = itemEvent(ckBox_5, tf_5);
			str[5] = itemEvent(ckBox_6, tf_6);
			str[6] = itemEvent(ckBox_7, tf_7);
			str[7] = itemEvent(ckBox_8, tf_8);
			str[8] = itemEvent(ckBox_9, tf_9);
			str[9] = itemEvent(ckBox_0, tf_0);
			// ��������
			for (int i = 0; i < str.length; i++) {
				String[] text = str[i].split("��");// ��������е�Ԫ��
				if (text.length == 2) {
					int number = Integer.parseInt(text[0]);// ����
					int quantity = Integer.parseInt(text[1]);// ͬ�ŵĸ���
					// �򼯺�list�����Ԫ��
					if (quantity > 1) {
						for (int j = 0; j < quantity; j++) {
							list.add(number);
						}
					} else {
						list.add(number);
					}
				}
			}
			// �����е�Ԫ�ظ���С��7
			while (list.size() < 7) {
				int num = ram.nextInt(10);// �������һ����0~9��Χ�ڵ�����
				if (list.contains(num)) {// �����а����������һ����0~9��Χ�ڵ�����
					continue;// ��������ѭ����ִ����һ��ѭ��
				} else {// �����в������������һ����0~9��Χ�ڵ�����
					list.add(num);// �򼯺�list�����Ԫ��
				}
			}
			List<Integer> indexes = new ArrayList<>();// �����롱������Ԫ�������ļ���
			// �����е�Ԫ�ظ���С��7
			while (indexes.size() < 7) {
				int index = ram.nextInt(7);// �������һ����0~6��Χ�ڵ�����
				if (indexes.contains(index)) {// �����а����������һ����0~6��Χ�ڵ�����
					continue;// ��������ѭ����ִ����һ��ѭ��
				} else {// �����в������������һ����0~6��Χ�ڵ�����
					indexes.add(index);// �򼯺�indexes�����Ԫ��
				}
			}
			while (bol) {
				try {
					if (index < (500 - ram.nextInt(20))) {// ����ֹͣʱ��500�����ȥ20���ڵ������
						a = list.get(indexes.get(0));// ������ѡ�ŵ�1λ������
						bt1.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + a + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�1λ��ҡ�����
					}
					if (index < (1000 - ram.nextInt(20))) {// ����ֹͣʱ��1000�����ȥ20���ڵ������
						b = list.get(indexes.get(1));// ������ѡ�ŵ�2λ������
						bt2.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + b + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�2λ��ҡ�����
					}
					if (index < (1500 - ram.nextInt(20))) {// ����ֹͣʱ��1500�����ȥ20���ڵ������
						c = list.get(indexes.get(2));// ������ѡ�ŵ�3λ������
						bt3.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + c + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�3λ��ҡ�����
					}
					if (index < (2000 - ram.nextInt(20))) {// ����ֹͣʱ��2000�����ȥ20���ڵ������
						d = list.get(indexes.get(3));// ������ѡ�ŵ�4λ������
						bt4.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + d + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�4λ��ҡ�����
					}
					if (index < (3000 - ram.nextInt(20))) {// ����ֹͣʱ��3000�����ȥ20���ڵ������
						e = list.get(indexes.get(4));// ������ѡ�ŵ�5λ������
						bt5.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + e + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�5λ��ҡ�����
					}
					if (index < (4000 - ram.nextInt(20))) {// ����ֹͣʱ��4000�����ȥ20���ڵ������
						f = list.get(indexes.get(5));// ������ѡ�ŵ�6λ������
						bt6.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + f + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�6λ��ҡ�����
					}
					if (index < (5000 - ram.nextInt(20))) {// ����ֹͣʱ��5000�����ȥ20���ڵ������
						g = list.get(indexes.get(6));// ������ѡ�ŵ�7λ������
						bt7.setIcon(
								new ImageIcon(ForecastAddframe.class.getResource("/imgs/" + g + ".png"))
						);// ͨ��ѭ���任ͼƬ�Դﵽ���ѡ�ŵ�7λ��ҡ�����
					}
					switch (index) {// �Խ��ű任ʱ��Ϊ�����Ķ��֧���
						case 500:// 500����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����еĿ�����
							sevenTextField.setText(s + a);// �ѵ�1λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 1000:// 1000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����еĵ�1λ����
							sevenTextField.setText(s + b);// �ѵ�2λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 1500:// 1500����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ2λ����
							sevenTextField.setText(s + c);// �ѵ�3λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 2000:// 2000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ3λ����
							sevenTextField.setText(s + d);// �ѵ�4λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 3000:// 3000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ4λ����
							sevenTextField.setText(s + e);// �ѵ�5λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 4000:// 4000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ5λ����
							sevenTextField.setText(s + f);// �ѵ�6λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							break;
						case 5000:// 5000����ʱ
							s = sevenTextField.getText();// ��ȡ��ѡ�ź��롱�ı����е�ǰ6λ����
							sevenTextField.setText(s + g);// �ѵ�7λ��ֵ��ӵ���ѡ�ź��롱�ı�����
							bol = false;//
							but.setEnabled(true);// ���á���ѡһע����ť����
							break;
					}
					i++;// i = i + 1
					Thread.sleep(0);// �̲߳�����
					index++;// index = index + 1
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

// ���ı��������ת��Ϊint��
private int exchangeInteger(JTextField tf) {
	int number;// �洢�ı����е���ֵ
	if ("".equals(tf.getText())) {// �ı�����û������
		number = 0;// �ı����е���ֵΪ0
	} else {// �ı�����������
		number = Integer.parseInt(tf.getText());// ���ı����е���ֵת��Ϊint��
	}
	return number;// �����ı����е���ֵ

}
// ���رա���ť�����¼��ļ���
protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
	this.setVisible(false);// ʹ���ѡ�ŶԻ��򲻿ɼ�
}

	@Override
	public void actionPerformed(ActionEvent e) {
		noteLabel.setText("");// ���á���ʾ����ǩ����Ϊ��
		bt1.setText("");// ������ʾ���ѡ�ŵ�1λ�İ�ť����Ϊ��
		bt2.setText("");// ������ʾ���ѡ�ŵ�2λ�İ�ť����Ϊ��
		bt3.setText("");// ������ʾ���ѡ�ŵ�3λ�İ�ť����Ϊ��
		bt4.setText("");// ������ʾ���ѡ�ŵ�4λ�İ�ť����Ϊ��
		bt5.setText("");// ������ʾ���ѡ�ŵ�5λ�İ�ť����Ϊ��
		bt6.setText("");// ������ʾ���ѡ�ŵ�6λ�İ�ť����Ϊ��
		bt7.setText("");// ������ʾ���ѡ�ŵ�7λ�İ�ť����Ϊ��
		sevenTextField.setText("");// ���á�ѡ�ź��롱�ı�������Ϊ��
		bol = true;
		index = 0;// Ϊ���ű任ʱ�丳ֵ
		but.setEnabled(false);// ���á���ѡһע����ť������
		Thread th1 = new Thread(this);// �����ѡ�ŶԻ����д����߳�
		th1.start();// �����߳�

	}


	// ��������Ӷ����¼��ļ���
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		LotteryValidate validate = new LotteryValidate();// ʵ������֤��Ϣ
		// ��ѡ�ź��롱��������ġ�ѡ�ź��롱�ĸ�ʽ����
		if (!validate.validateNumber(sevenTextField.getText())) {
			noteLabel.setText("��������ʽ����ȷ");// ���á���ʾ����ǩ����
		}
		// ��ѡ�ź��롱��������ġ�ѡ�ź��롱�ĸ�ʽ��ȷ
		if (validate.validateNumber(sevenTextField.getText())) {
			noteLabel.setText("");// ���á���ʾ����ǩ����Ϊ��
			ForecastDao fr = new ForecastDao();// ʵ�������������Ʊ��¼��Ϣ
			Boolean b;
			b = fr.addForecastDao(
					Integer.parseInt(numberTextField.getText()), sevenTextField.getText()
			);// �����ӹ������ķ���ֵ
			if (b) {// ��ӹ������ɹ�
				noteLabel.setText("����ɹ���");// ���á�����״̬����ǩ����
				HistoryDao his = new HistoryDao();// ʵ��������������Ϣ
				numberTextField.setText(his.selectNumber() + "");// ���á������������ı����е�����
			} else {// ��ӹ������ʧ��
				noteLabel.setText("����ʧ�ܣ�");// ���á�����״̬����ǩ����
			}
		}

	}



}

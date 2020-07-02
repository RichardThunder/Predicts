package com.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.db.ConnMySQL;

public class SelectForecast extends JDialog {// ��ѯ��ʷ�Ի���

private JPanel jcontentPane;// �������

private JTable table;// ���ģ��
private JButton firstPageButton;// ��ҳ
private JButton latePageButton;// βҳ
private JButton nextPageButton;// ��һҳ
private JButton lastPageButton;// ��һҳ
private int maxPageNumber;// ������ҳ��
private int maxrows;// ��ʼ���������
private int currentPageNumber = 1;// ��ʼ�����ĵ�ǰҳ��Ϊ1
private double pageSize = 20;// ÿҳ��������20������
private DefaultTableModel defaultModel;// ���ģ�͵�ʵ������

public static void main(String[] args) {
    try {
        // ���ò�ѯ��ʷ�Ի���ķ��
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                SelectForecast frame = new SelectForecast();// ��ѯ��ʷ�Ի���
                frame.setVisible(true);// ʹ��ѯ��ʷ�Ի���ɼ�
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public SelectForecast() {// ��ѯ��ʷ�Ի���Ĺ��췽��
    setModal(true);// ʹ��ѯ��ʷ�Ի���������ǰ
    setResizable(false);// ���ò�ѯ��ʷ�Ի��򲻿ɸı��С
    setForeground(Color.BLACK);// ���ò�ѯ��ʷ�Ի����ǰ��ɫΪ��ɫ
    setTitle("��ʷս��");// ���ò�ѯ��ʷ�Ի���ı���
    setIconImage(Toolkit.getDefaultToolkit().getImage(SelectForecast.class.getResource("/imgs/log.png")));// ���ò�ѯ��ʷ�Ի���ı���ͼ��
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ò�ѯ��ʷ�Ի���Ĺرշ�ʽ
    setBounds(230, 130, 1057, 574);// ���ò�ѯ��ʷ�Ի����λ���Լ����

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowActivated(WindowEvent e) {
            do_this_windowActivated(e);// Ϊ��ѯ��ʷ�Ի�����Ӵ����¼��ļ���
        }
    });

    jcontentPane = new JPanel();// �������
    jcontentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
    setContentPane(jcontentPane);// ��������������޸Ŀ�������Ի�����

    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// ���ñ�������ͼƬ
    jcontentPane.add(contentPane, BorderLayout.CENTER);// ��ӱ�����嵽�������

    JScrollPane scrollPane = new JScrollPane();// �������
    scrollPane.setBackground(new Color(0, 51, 204));// ���ù������ı���ɫ
    scrollPane.setBounds(47, 62, 955, 350);// ���ù�������λ�úͿ��

    table = new JTable();// ���ģ��
    scrollPane.setViewportView(table);// ������������ӱ��
    contentPane.add(scrollPane);// �����������ӵ��Զ��屳�������

    firstPageButton = new JButton();// ����ҳ����ť
    firstPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_08.png")));// ���á���ҳ����ť��ͼ��
    firstPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_firstPageButton_actionPerformed(e);// Ϊ����ҳ����ť��Ӷ����¼��ļ���
        }
    });
    firstPageButton.setBounds(265, 432, 92, 30);// ���á���ҳ����ť��λ�ü����
    contentPane.add(firstPageButton);// ������ҳ����ť��ӵ��Զ��屳�������

    latePageButton = new JButton();// ����һҳ����ť
    latePageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_10.png")));// ���á���һҳ����ť��ͼ��
    latePageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_latePageButton_actionPerformed(e);// Ϊ����һҳ����ť��Ӷ����¼��ļ���
        }
    });
    latePageButton.setBounds(414, 432, 92, 30);// ���á���һҳ����ť��λ�ü����
    contentPane.add(latePageButton);// ������һҳ����ť��ӵ��Զ��屳�������

    nextPageButton = new JButton();// ����һҳ����ť
    nextPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_09.png")));// ���á���һҳ����ť��ͼ��
    nextPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_nextPageButton_actionPerformed(e);// Ϊ����һҳ����ť��Ӷ����¼��ļ���
        }
    });
    nextPageButton.setBounds(559, 432, 92, 30);// ����һҳ����ť��λ�ü����
    contentPane.add(nextPageButton);// ������һҳ����ť��ӵ��Զ��屳�������

    lastPageButton = new JButton();// ��βҳ����ť
    lastPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_11.png")));// ���á�βҳ����ť��ͼ��
    lastPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_lastPageButton_actionPerformed(e);// Ϊ��βҳ����ť��Ӷ����¼��ļ���
        }
    });
    lastPageButton.setBounds(698, 432, 92, 30);// ��βҳ����ť��λ�ü����
    contentPane.add(lastPageButton);// ����βҳ����ť��ӵ��Զ��屳�������

    JButton btnNewButton = new JButton("");// ���رա���ť
    btnNewButton.setIcon(new ImageIcon(SelectForecast.class.getResource("/img_btn/6_05.png")));// ���á��رա���ť��ͼ��
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// Ϊ���رա���ť��Ӷ����¼��ļ���
        }
    });
    btnNewButton.setBounds(907, 502, 92, 30);// ���á��رա���ť��λ�úͿ��
    contentPane.add(btnNewButton);// �����رա���ť��ӵ��Զ��屳�������
}

protected void do_this_windowActivated(WindowEvent e) {// ��ѯ��ʷ�Ի������¼��ļ���
    defaultModel = (DefaultTableModel) table.getModel();// ��ñ��ģ��
    defaultModel.setRowCount(0);// ��ձ��ģ���е�����
    defaultModel.setColumnIdentifiers(
            new Object[] { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��", "���ý���" });// �����ͷ
    String sql = "select count(id) from tb_forecast";// ����SQL���
    ConnMySQL con = new ConnMySQL();// ���ݿ����Ӷ���
    ResultSet rs = con.showAll(sql);// ���ִ��sql��Ľ����
    try {
        if (rs.next()) {// ��Ϊ�����ִ�н��������ֻ��һ������������if����������
            maxrows = rs.getInt(1);
        }
        // �ر�����
        con.closeConnection();
    } catch (SQLException eq) {
        eq.printStackTrace();
    }
    sql = "select * from tb_forecast order by number desc";// ����SQL���
    rs = con.showAll(sql);// ���ִ��sql��Ľ����

    try {
        while (rs.next()) {// ���������
            String m = rs.getString(11) + "Ԫ";
            if (rs.getString(11) == null) {
                m = "δ����";
            }
            defaultModel.addRow(new Object[] { rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
                    rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), m });// ����ģ�����������
        }
    } catch (SQLException e1) {
        e1.printStackTrace();
    }
    maxPageNumber = (int) (maxrows % pageSize == 0 ? maxrows / pageSize : maxrows / pageSize + 1);// ������ҳ��

    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    newModel.setColumnIdentifiers(
            new Object[] { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��", "���ý���" });// �����ͷ
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) defaultModel.getDataVector().elementAt(i));// ����ҳ���С���������
    }

    table.getTableHeader().setReorderingAllowed(false);// ���ò������϶���ͷ
    table.setModel(newModel);// ���ñ��ģ��
    firstPageButton.setEnabled(false); // ���á���ҳ����ť
    latePageButton.setEnabled(false); // ���á���һҳ����ť
    nextPageButton.setEnabled(true); // ���á���һҳ����ť
    lastPageButton.setEnabled(true); // ���á�βҳ����ť

}

protected void do_firstPageButton_actionPerformed(ActionEvent e) {// ����ҳ����ť�����¼��ļ���
    currentPageNumber = 1; // ����ǰҳ�����ó�1
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    newModel.setColumnIdentifiers(
            new Object[] { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��", "���ý���" });// �����ͷ
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) dataVector.elementAt(i));// ����ҳ���С���������
    }
    table.getTableHeader().setReorderingAllowed(false);// ���ò������϶���ͷ
    table.setModel(newModel);// ���ñ��ģ��
    firstPageButton.setEnabled(false); // ���á���ҳ����ť
    latePageButton.setEnabled(false); // ���á���һҳ����ť
    nextPageButton.setEnabled(true); // ���á���һҳ����ť
    lastPageButton.setEnabled(true); // ���á�βҳ����ť

}

protected void do_latePageButton_actionPerformed(ActionEvent e) {// ��βҳ����ť�����¼��ļ���
    currentPageNumber--;// ����ǰҳ���һ
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    newModel.setColumnIdentifiers(
            new Object[] { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��", "���ý���" });// �����ͷ
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i)));// ����ҳ���С���������
    }
    table.getTableHeader().setReorderingAllowed(false);// ���ò������϶���ͷ
    table.setModel(newModel);// ���ñ��ģ��
    if (currentPageNumber == 1) {
        firstPageButton.setEnabled(false); // ���á���ҳ����ť
        latePageButton.setEnabled(false); // ���á���һҳ����ť
    }
    nextPageButton.setEnabled(true);// ���á���һҳ����ť
    lastPageButton.setEnabled(true);// ���á�βҳ����ť

}

protected void do_nextPageButton_actionPerformed(ActionEvent e) {// ����һҳ����ť�����¼��ļ���
    currentPageNumber++;// ����ǰҳ���һ
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    newModel.setColumnIdentifiers(
            new Object[] { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��", "���ý���" });// �����ͷ
    if (currentPageNumber == maxPageNumber) {
        int lastPageSize = (int) (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
        for (int i = 0; i < lastPageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i)));// ����ҳ���С���������
        }
        nextPageButton.setEnabled(false);// ���á���һҳ����ť
        lastPageButton.setEnabled(false);// ���á�βҳ����ť
    } else {
        for (int i = 0; i < pageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i)));// ����ҳ���С���������
        }
    }
    table.getTableHeader().setReorderingAllowed(false);// ���ò������϶���ͷ
    table.setModel(newModel);// ���ñ��ģ��
    firstPageButton.setEnabled(true); // ���á���ҳ����ť
    latePageButton.setEnabled(true); // ���á���һҳ����ť
}

protected void do_lastPageButton_actionPerformed(ActionEvent e) {// ����һҳ����ť�����¼��ļ���
    currentPageNumber = maxPageNumber;// ����ǰҳ������Ϊĩҳ
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    newModel.setColumnIdentifiers(
            new Object[] { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��", "���ý���" });// �����ͷ
    int lastPageSize = (int) (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
    if (lastPageSize == maxrows) {
        for (int i = 0; i < pageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i)));// ����ҳ���С���������
        }
    } else {
        for (int i = 0; i < lastPageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i)));// ����ҳ���С���������
        }
    }
    table.getTableHeader().setReorderingAllowed(false);// ���ò������϶���ͷ
    table.setModel(newModel);// ���ñ��ģ��
    firstPageButton.setEnabled(true); // ���á���ҳ����ť
    latePageButton.setEnabled(true); // ���á���һҳ����ť
    nextPageButton.setEnabled(false); // ���á���һҳ����ť
    lastPageButton.setEnabled(false); // ���á�βҳ����ť
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// ���رա���ť�����¼��ļ���
    this.setVisible(false);// ʹ��ѯ��ʷ�Ի��򲻿ɼ�
}
}

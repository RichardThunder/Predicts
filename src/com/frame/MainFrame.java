package com.frame;

import com.frame.BackgroundPanel;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.db.ConnMySQL;


public class MainFrame extends JFrame {
private JPanel jcontentPane;// �������
private JButton firstPageButton;// ��ҳ
private JButton latePageButton;// βҳ
private JButton nextPageButton;// ��һҳ
private JButton lastPageButton;// ��һҳ
private JTable table;// ���ģ��
private int maxPageNumber;// ������ҳ��
private int maxrows = 0;// ��ʼ���������Ϊ0
private int currentPageNumber = 1;// ��ʼ�����ĵ�ǰҳ��Ϊ1
private double pageSize = 20;// ÿҳ��������20������
private DefaultTableModel defaultModel;// ���ģ�͵�ʵ������

public static void main(String[] args) {
    try {
        // ������������
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // ʵ����������
                MainFrame frame = new MainFrame();
                frame.setVisible(true);// ʹ������ɼ�
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public MainFrame() {// ������Ĺ��췽��
    setForeground(Color.BLACK);// ����ǰ��ɫΪ��ɫ
    setTitle("���ղ�ƱԤ��ϵͳ");// ������ı���
    setResizable(false);// �����岻�ܸı��С
    // ������ı���ͼ��
    setIconImage(
            Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/imgs/log.png"))
    );
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �Ե�¼���巢��close��ʱ���˳�Ӧ�ó���
    setBounds(200, 100, 1100, 600);// ��¼�����λ�ü����
    jcontentPane = new JPanel();// ʵ�����������
    jcontentPane.setLayout(new BorderLayout(0, 0));// �����������Ĳ���Ϊ�߽粼��
    setContentPane(jcontentPane);// ��������������������
    BackgroundPanel contentPane = new BackgroundPanel();// �����Զ��屳�����
    // ���ñ�������ͼƬ
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/main.png")));
    jcontentPane.add(contentPane, BorderLayout.CENTER);// ��ӱ�����嵽�������

    JButton btnNewButton = new JButton("");// ����ӿ������롱��ť
    // ���á���ӿ������롱��ť��ͼ��
    btnNewButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/10.png"))
    );
    btnNewButton.setBounds(6, 114, 184, 40);// ����ӿ������롱��ť��λ�ü����
    contentPane.add(btnNewButton);// ������ӿ������롱��ť��ӵ��Զ��屳�������
    JButton button = new JButton("");// ���鿴���쿪������ť
    // ���á��鿴���쿪������ť��ͼ��
    button.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/09.png"))
    );
    button.setBounds(6, 74, 184, 40);// ���鿴���쿪������ť��λ�ü����
    contentPane.add(button);// �����鿴���쿪������ť��ӵ��Զ��屳�������
    JButton button_1 = new JButton("");// ��������Ӻ��롱��ť
    // ���á�������Ӻ��롱��ť��ͼ��
    button_1.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/11.png"))
    );
    button_1.setBounds(6, 154, 184, 40);// ��������Ӻ��롱��ť��λ�ü����
    contentPane.add(button_1);// ����������Ӻ��롱��ť��ӵ��Զ��屳�������
    JButton updatebutton = new JButton("");// ���޸Ŀ������롱��ť
    // ���á��޸Ŀ������롱��ť��ͼ��
    updatebutton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/12.png"))
    );
    updatebutton.setBounds(6, 194, 184, 40);// ���޸Ŀ������롱��ť��λ�ü����
    contentPane.add(updatebutton);// �����޸Ŀ������롱��ť��ӵ��Զ��屳�������

    JButton button_3 = new JButton("");// ���鿴�������ơ���ť
    // ���á��鿴�������ơ���ť��ͼ��
    button_3.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/14.png"))
    );
    button_3.setBounds(6, 234, 184, 40);// ���鿴�������ơ���ť��λ�ü����
    contentPane.add(button_3);// �����鿴�������ơ���ť��ӵ��Զ��屳�������
    JButton button_4 = new JButton("");// �����ѡ�š���ť
    // ���á����ѡ�š���ť��ͼ��
    button_4.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/15.png"))
    );
    button_4.setBounds(6, 274, 184, 40);// �����ѡ�š���ť��λ�ü����
    contentPane.add(button_4);// �������ѡ�š���ť��ӵ��Զ��屳�������
    JButton button_5 = new JButton("");// ���н���ѯ����ť
    // ���á��н���ѯ����ť��ͼ��
    button_5.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/17.png"))
    );
    button_5.setBounds(6, 314, 184, 40);// ���н���ѯ����ť��λ�ü����
    contentPane.add(button_5);// �����н���ѯ����ť��ӵ��Զ��屳�������
    JButton button_6 = new JButton("");// ����ʷս������ť
    // ���á���ʷս������ť��ͼ��
    button_6.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/18.png"))
    );
    button_6.setBounds(6, 354, 184, 40);// ����ʷս������ť��λ�ü����
    contentPane.add(button_6);// ������ʷս������ť��ӵ��Զ��屳�������
    JButton button_2 = new JButton("");// ���˳�ϵͳ����ť
    // ���á��˳�ϵͳ����ť��ͼ��
    button_2.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/08.png"))
    );
    button_2.setBounds(6, 394, 184, 40);// ���˳�ϵͳ����ť��λ�ü����
    contentPane.add(button_2);// �����˳�ϵͳ����ť��ӵ��Զ��屳�������

    JScrollPane scrollPane = new JScrollPane(); // �������
    scrollPane.setBackground(new Color(0, 51, 204)); // ������屳��ɫ
    scrollPane.setBounds(217, 74, 848, 351); // ����������������е�λ�ü����
    contentPane.add(scrollPane); // �����������ӵ��Զ��屳�������
    table = new JTable(); // ���ģ��
    scrollPane.setViewportView(table); // ������������ӱ��
    firstPageButton = new JButton("��   ҳ"); // ����ҳ����ť
    // ���á���ҳ����ť��ͼ��
    firstPageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_08.png")));
    firstPageButton.setBounds(416, 439, 84, 27); // ����ҳ����ť��λ�ü����
    contentPane.add(firstPageButton); // ������ҳ����ť��ӵ��Զ��屳�������
    latePageButton = new JButton("��һҳ"); // ����һҳ����ť
    // ���á���һҳ����ť��ͼ��
    latePageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_10.png")));
    latePageButton.setBounds(550, 439, 84, 27); // ����һҳ����ť��λ�ü����
    contentPane.add(latePageButton); // ������һҳ����ť��ӵ��Զ��屳�������
    nextPageButton = new JButton("��һҳ"); // ����һҳ����ť
    // ���á���һҳ����ť��ͼ��
    nextPageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_09.png")));
    nextPageButton.setBounds(686, 439, 84, 27); // ����һҳ����ť��λ�ü����
    contentPane.add(nextPageButton); // ������һҳ����ť��ӵ��Զ��屳�������
    lastPageButton = new JButton("β   ҳ"); // ��βҳ����ť
    // ���á�βҳ����ť��ͼ��
    lastPageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_11.png")));
    lastPageButton.setBounds(819, 439, 84, 27); // ��βҳ����ť��λ�ü����
    contentPane.add(lastPageButton); // ����βҳ����ť��ӵ��Զ��屳�������

    latePageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_latePageButton_actionPerformed(e);// Ϊ����һҳ����ť��Ӷ����¼��ļ���
        }
    });
    nextPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_nextPageButton_actionPerformed(e);// Ϊ����һҳ����ť��Ӷ����¼��ļ���
        }
    });

    firstPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_firstPageButton_actionPerformed(e);// Ϊ����ҳ����ť��Ӷ����¼��ļ���
        }
    });
    lastPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_lastPageButton_actionPerformed(e);// Ϊ��βҳ����ť��Ӷ����¼��ļ���
        }
    });


    button_3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_3_actionPerformed(e);// Ϊ���鿴�������ơ���ť��Ӷ����¼��ļ���
        }
    });

    selecttable();//��ҳ��ʾ��������ķ���



}

// ���鿴�������ơ���ť��Ӷ����¼��ļ���
protected void do_button_3_actionPerformed(ActionEvent e) {
    SparBuoy sparBuoy = new SparBuoy();// �������ƶԻ���
    sparBuoy.setVisible(true);// ʹ�������ƶԻ���ɼ�
}


// ����һҳ����ť��Ӷ����¼��ļ���
protected void do_latePageButton_actionPerformed(ActionEvent e) {
    currentPageNumber--;// ����ǰҳ���һ
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    // �����ͷ
    newModel.setColumnIdentifiers(new Object[]
            { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��" });
    for (int i = 0; i < pageSize; i++) {
        // ����ҳ���С���������
        newModel.addRow(
                (Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i))
        );
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// ���ñ��ģ��
    if (currentPageNumber == 1) {
        firstPageButton.setEnabled(false);// ���á���ҳ����ť
        latePageButton.setEnabled(false);// ���á���һҳ����ť
    }
    nextPageButton.setEnabled(true);// ���á���һҳ����ť
    lastPageButton.setEnabled(true);// ���á�βҳ����ť
}
// ����һҳ����ť��Ӷ����¼��ļ���
protected void do_nextPageButton_actionPerformed(ActionEvent e) {
    currentPageNumber++;// ����ǰҳ���һ
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    // �����ͷ
    newModel.setColumnIdentifiers(new Object[]
            { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��" });
    if (currentPageNumber == maxPageNumber) {
        int lastPageSize = (int)
                (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
        for (int i = 0; i < lastPageSize; i++) {
            // ����ҳ���С���������
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i))
            );
        }
        nextPageButton.setEnabled(false);// ���á���һҳ����ť
        lastPageButton.setEnabled(false);// ���á�βҳ����ť
    } else {
        for (int i = 0; i < pageSize; i++) {
            // ����ҳ���С���������
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i))
            );
        }
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// ���ñ��ģ��
    firstPageButton.setEnabled(true);// ���á���ҳ����ť
    latePageButton.setEnabled(true);// ���á���һҳ����ť
}

// ����ҳ����ť��Ӷ����¼��ļ���
protected void do_firstPageButton_actionPerformed(ActionEvent e) {
    currentPageNumber = 1;// ����ǰҳ�����ó�1
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    // �����ͷ
    newModel.setColumnIdentifiers(new Object[]
            { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��" });
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) dataVector.elementAt(i));// ����ҳ���С���������
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// ���ñ��ģ��
    firstPageButton.setEnabled(false);// ���á���ҳ����ť
    latePageButton.setEnabled(false);// ���á���һҳ����ť
    nextPageButton.setEnabled(true);// ���á���һҳ����ť
    lastPageButton.setEnabled(true);// ���á�βҳ����ť
}
// ��βҳ����ť��Ӷ����¼��ļ���
protected void do_lastPageButton_actionPerformed(ActionEvent e) {
    currentPageNumber = maxPageNumber;// ����ǰҳ������Ϊĩҳ
    Vector dataVector = defaultModel.getDataVector();// ���ԭ���ģ���е�����
    DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
    // �����ͷ
    newModel.setColumnIdentifiers(new Object[]
            { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��" });
    int lastPageSize = (int)
            (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
    if (lastPageSize == maxrows) {
        for (int i = 0; i < pageSize; i++) {
            // ����ҳ���С���������
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i))
            );
        }
    } else {
        for (int i = 0; i < lastPageSize; i++) {
            // ����ҳ���С���������
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i))
            );
        }
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// ���ñ��ģ��
    firstPageButton.setEnabled(true);// ���á���ҳ����ť
    latePageButton.setEnabled(true);// ���á���һҳ����ť
    nextPageButton.setEnabled(false);// ���á���һҳ����ť
    lastPageButton.setEnabled(false);// ���á�βҳ����ť
}

public void selecttable() {// ��ҳ��ʾ��������ķ���
    defaultModel = (DefaultTableModel) table.getModel();// ��ñ��ģ��
    defaultModel.setRowCount(0);// ��ձ��ģ���е�����
    // �����ͷ
    defaultModel.setColumnIdentifiers(new Object[]
            { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��" });
    String sql = "select count(id) from tb_history";// ����SQL���
    ConnMySQL con = new ConnMySQL();// �������ݿ�
    ResultSet rs = con.showAll(sql);// ִ��SQL�����õĽ����
    try {
        if (rs.next())// ��Ϊ�����ִ�н��������ֻ��һ��������������if�������������
        {
            maxrows = rs.getInt(1);// Ϊ���������ֵ
        }
        con.closeConnection();// �ر�����
    } catch (SQLException eq) {
        eq.printStackTrace();
    }
    if (maxrows != 0) {// �ж����������ִ������ķ���
        // ���տ��������������л�ñ�tb_history�����ݵ�SQL���
        sql = "select * from tb_history order by number desc";
        rs = con.showAll(sql);// ִ��SQL�����õĽ����
        try {
            // Ϊ�����ÿһ�еĵ�Ԫ��ֵ
            while (rs.next()) {
                defaultModel.addRow(new Object[] { rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5),rs.getInt(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10) });
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        // ������ҳ��
        maxPageNumber = (int)
                (maxrows % pageSize == 0 ? maxrows / pageSize : maxrows / pageSize + 1);
        DefaultTableModel newModel = new DefaultTableModel();// �����µı��ģ��
        // �����ͷ
        newModel.setColumnIdentifiers(new Object[]
                { "����", "��1λ", "��2λ", "��3λ", "��4λ", "��5λ", "��6λ", "��7λ", "����ʱ��" });
        for (int i = 0; i < pageSize; i++) {
            // ����ҳ���С���������
            newModel.addRow((Vector) defaultModel.getDataVector().elementAt(i));
        }
        table.getTableHeader().setReorderingAllowed(false);
        table.setModel(newModel);// ���ñ��ģ��
        firstPageButton.setEnabled(false);// ���á���ҳ����ť
        latePageButton.setEnabled(false);// ���á���һҳ����ť
        nextPageButton.setEnabled(true);// ���á���һҳ����ť
        lastPageButton.setEnabled(true);// ���á�βҳ����ť
    } else {
        firstPageButton.setEnabled(false);// ���á���ҳ����ť
        latePageButton.setEnabled(false);// ���á���һҳ����ť
        nextPageButton.setEnabled(false);// ���á���һҳ����ť
        lastPageButton.setEnabled(false);// ���á�βҳ����ť
    }
}


}

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

public class SelectForecast extends JDialog {// 查询历史对话框

private JPanel jcontentPane;// 内容面板

private JTable table;// 表格模型
private JButton firstPageButton;// 首页
private JButton latePageButton;// 尾页
private JButton nextPageButton;// 下一页
private JButton lastPageButton;// 上一页
private int maxPageNumber;// 表格的总页数
private int maxrows;// 初始化最大行数
private int currentPageNumber = 1;// 初始化表格的当前页数为1
private double pageSize = 20;// 每页表格可容纳20条数据
private DefaultTableModel defaultModel;// 表格模型的实例对象

public static void main(String[] args) {
    try {
        // 设置查询历史对话框的风格
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                SelectForecast frame = new SelectForecast();// 查询历史对话框
                frame.setVisible(true);// 使查询历史对话框可见
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public SelectForecast() {// 查询历史对话框的构造方法
    setModal(true);// 使查询历史对话框总在最前
    setResizable(false);// 设置查询历史对话框不可改变大小
    setForeground(Color.BLACK);// 设置查询历史对话框的前景色为黑色
    setTitle("历史战绩");// 设置查询历史对话框的标题
    setIconImage(Toolkit.getDefaultToolkit().getImage(SelectForecast.class.getResource("/imgs/log.png")));// 设置查询历史对话框的标题图标
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置查询历史对话框的关闭方式
    setBounds(230, 130, 1057, 574);// 设置查询历史对话框的位置以及宽高

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowActivated(WindowEvent e) {
            do_this_windowActivated(e);// 为查询历史对话框添加窗体事件的监听
        }
    });

    jcontentPane = new JPanel();// 内容面板
    jcontentPane.setLayout(new BorderLayout(0, 0));// 设置内容面板的布局为边界布局
    setContentPane(jcontentPane);// 把内容面板置于修改开奖号码对话框中

    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// 设置背景面板的图片
    jcontentPane.add(contentPane, BorderLayout.CENTER);// 添加背景面板到内容面板

    JScrollPane scrollPane = new JScrollPane();// 滚动面板
    scrollPane.setBackground(new Color(0, 51, 204));// 设置滚动面板的背景色
    scrollPane.setBounds(47, 62, 955, 350);// 设置滚动面板的位置和宽高

    table = new JTable();// 表格模型
    scrollPane.setViewportView(table);// 向滚动面板中添加表格
    contentPane.add(scrollPane);// 将滚动面板添加到自定义背景面板中

    firstPageButton = new JButton();// “首页”按钮
    firstPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_08.png")));// 设置“首页”按钮的图标
    firstPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_firstPageButton_actionPerformed(e);// 为“首页”按钮添加动作事件的监听
        }
    });
    firstPageButton.setBounds(265, 432, 92, 30);// 设置“首页”按钮的位置及宽高
    contentPane.add(firstPageButton);// 将“首页”按钮添加到自定义背景面板中

    latePageButton = new JButton();// “上一页”按钮
    latePageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_10.png")));// 设置“上一页”按钮的图标
    latePageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_latePageButton_actionPerformed(e);// 为“上一页”按钮添加动作事件的监听
        }
    });
    latePageButton.setBounds(414, 432, 92, 30);// 设置“上一页”按钮的位置及宽高
    contentPane.add(latePageButton);// 将“上一页”按钮添加到自定义背景面板中

    nextPageButton = new JButton();// “下一页”按钮
    nextPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_09.png")));// 设置“下一页”按钮的图标
    nextPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_nextPageButton_actionPerformed(e);// 为“下一页”按钮添加动作事件的监听
        }
    });
    nextPageButton.setBounds(559, 432, 92, 30);// “下一页”按钮的位置及宽高
    contentPane.add(nextPageButton);// 将“下一页”按钮添加到自定义背景面板中

    lastPageButton = new JButton();// “尾页”按钮
    lastPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_11.png")));// 设置“尾页”按钮的图标
    lastPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_lastPageButton_actionPerformed(e);// 为“尾页”按钮添加动作事件的监听
        }
    });
    lastPageButton.setBounds(698, 432, 92, 30);// “尾页”按钮的位置及宽高
    contentPane.add(lastPageButton);// 将“尾页”按钮添加到自定义背景面板中

    JButton btnNewButton = new JButton("");// “关闭”按钮
    btnNewButton.setIcon(new ImageIcon(SelectForecast.class.getResource("/img_btn/6_05.png")));// 设置“关闭”按钮的图标
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// 为“关闭”按钮添加动作事件的监听
        }
    });
    btnNewButton.setBounds(907, 502, 92, 30);// 设置“关闭”按钮的位置和宽高
    contentPane.add(btnNewButton);// 将“关闭”按钮添加到自定义背景面板中
}

protected void do_this_windowActivated(WindowEvent e) {// 查询历史对话框窗体事件的监听
    defaultModel = (DefaultTableModel) table.getModel();// 获得表格模型
    defaultModel.setRowCount(0);// 清空表格模型中的数据
    defaultModel.setColumnIdentifiers(
            new Object[] { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间", "所得奖金" });// 定义表头
    String sql = "select count(id) from tb_forecast";// 生成SQL语句
    ConnMySQL con = new ConnMySQL();// 数据库连接对象
    ResultSet rs = con.showAll(sql);// 获得执行sql后的结果集
    try {
        if (rs.next()) {// 因为上面的执行结果是有且只有一个所以我们用if来遍历集合
            maxrows = rs.getInt(1);
        }
        // 关闭链接
        con.closeConnection();
    } catch (SQLException eq) {
        eq.printStackTrace();
    }
    sql = "select * from tb_forecast order by number desc";// 生成SQL语句
    rs = con.showAll(sql);// 获得执行sql后的结果集

    try {
        while (rs.next()) {// 遍历结果集
            String m = rs.getString(11) + "元";
            if (rs.getString(11) == null) {
                m = "未开奖";
            }
            defaultModel.addRow(new Object[] { rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
                    rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), m });// 向表格模型中添加数据
        }
    } catch (SQLException e1) {
        e1.printStackTrace();
    }
    maxPageNumber = (int) (maxrows % pageSize == 0 ? maxrows / pageSize : maxrows / pageSize + 1);// 计算总页数

    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    newModel.setColumnIdentifiers(
            new Object[] { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间", "所得奖金" });// 定义表头
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) defaultModel.getDataVector().elementAt(i));// 根据页面大小来获得数据
    }

    table.getTableHeader().setReorderingAllowed(false);// 设置不可以拖动列头
    table.setModel(newModel);// 设置表格模型
    firstPageButton.setEnabled(false); // 禁用“首页”按钮
    latePageButton.setEnabled(false); // 禁用“上一页”按钮
    nextPageButton.setEnabled(true); // 启用“下一页”按钮
    lastPageButton.setEnabled(true); // 启用“尾页”按钮

}

protected void do_firstPageButton_actionPerformed(ActionEvent e) {// “首页”按钮动作事件的监听
    currentPageNumber = 1; // 将当前页码设置成1
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    newModel.setColumnIdentifiers(
            new Object[] { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间", "所得奖金" });// 定义表头
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) dataVector.elementAt(i));// 根据页面大小来获得数据
    }
    table.getTableHeader().setReorderingAllowed(false);// 设置不可以拖动列头
    table.setModel(newModel);// 设置表格模型
    firstPageButton.setEnabled(false); // 禁用“首页”按钮
    latePageButton.setEnabled(false); // 禁用“上一页”按钮
    nextPageButton.setEnabled(true); // 启用“下一页”按钮
    lastPageButton.setEnabled(true); // 启用“尾页”按钮

}

protected void do_latePageButton_actionPerformed(ActionEvent e) {// “尾页”按钮动作事件的监听
    currentPageNumber--;// 将当前页面减一
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    newModel.setColumnIdentifiers(
            new Object[] { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间", "所得奖金" });// 定义表头
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i)));// 根据页面大小来获得数据
    }
    table.getTableHeader().setReorderingAllowed(false);// 设置不可以拖动列头
    table.setModel(newModel);// 设置表格模型
    if (currentPageNumber == 1) {
        firstPageButton.setEnabled(false); // 禁用“首页”按钮
        latePageButton.setEnabled(false); // 禁用“上一页”按钮
    }
    nextPageButton.setEnabled(true);// 启用“下一页”按钮
    lastPageButton.setEnabled(true);// 启用“尾页”按钮

}

protected void do_nextPageButton_actionPerformed(ActionEvent e) {// “下一页”按钮动作事件的监听
    currentPageNumber++;// 将当前页面加一
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    newModel.setColumnIdentifiers(
            new Object[] { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间", "所得奖金" });// 定义表头
    if (currentPageNumber == maxPageNumber) {
        int lastPageSize = (int) (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
        for (int i = 0; i < lastPageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i)));// 根据页面大小来获得数据
        }
        nextPageButton.setEnabled(false);// 禁用“下一页”按钮
        lastPageButton.setEnabled(false);// 禁用“尾页”按钮
    } else {
        for (int i = 0; i < pageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i)));// 根据页面大小来获得数据
        }
    }
    table.getTableHeader().setReorderingAllowed(false);// 设置不可以拖动列头
    table.setModel(newModel);// 设置表格模型
    firstPageButton.setEnabled(true); // 启用“首页”按钮
    latePageButton.setEnabled(true); // 启用“上一页”按钮
}

protected void do_lastPageButton_actionPerformed(ActionEvent e) {// “上一页”按钮动作事件的监听
    currentPageNumber = maxPageNumber;// 将当前页面设置为末页
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    newModel.setColumnIdentifiers(
            new Object[] { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间", "所得奖金" });// 定义表头
    int lastPageSize = (int) (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
    if (lastPageSize == maxrows) {
        for (int i = 0; i < pageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i)));// 根据页面大小来获得数据
        }
    } else {
        for (int i = 0; i < lastPageSize; i++) {
            newModel.addRow((Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i)));// 根据页面大小来获得数据
        }
    }
    table.getTableHeader().setReorderingAllowed(false);// 设置不可以拖动列头
    table.setModel(newModel);// 设置表格模型
    firstPageButton.setEnabled(true); // 启用“首页”按钮
    latePageButton.setEnabled(true); // 启用“上一页”按钮
    nextPageButton.setEnabled(false); // 禁用“下一页”按钮
    lastPageButton.setEnabled(false); // 禁用“尾页”按钮
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// “关闭”按钮动作事件的监听
    this.setVisible(false);// 使查询历史对话框不可见
}
}

package com.company.Predict;

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
private JPanel jcontentPane;// 内容面板
private JButton firstPageButton;// 首页
private JButton latePageButton;// 尾页
private JButton nextPageButton;// 下一页
private JButton lastPageButton;// 上一页
private JTable table;// 表格模型
private int maxPageNumber;// 表格的总页数
private int maxrows = 0;// 初始化最大行数为0
private int currentPageNumber = 1;// 初始化表格的当前页数为1
private double pageSize = 20;// 每页表格可容纳20条数据
private DefaultTableModel defaultModel;// 表格模型的实例对象

public static void main(String[] args) {
    try {
        // 设置主窗体风格
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // 实例化主窗体
                MainFrame frame = new MainFrame();
                frame.setVisible(true);// 使主窗体可见
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public MainFrame() {// 主窗体的构造方法
    setForeground(Color.BLACK);// 设置前景色为黑色
    setTitle("明日彩票预测系统");// 主窗体的标题
    setResizable(false);// 主窗体不能改变大小
    // 主窗体的标题图标
    setIconImage(
            Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/imgs/log.png"))
    );
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 对登录窗体发起“close”时，退出应用程序
    setBounds(200, 100, 1100, 600);// 登录窗体的位置及宽高
    jcontentPane = new JPanel();// 实例化内容面板
    jcontentPane.setLayout(new BorderLayout(0, 0));// 设置内容面板的布局为边界布局
    setContentPane(jcontentPane);// 把内容面板放入主窗体中
    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    // 设置背景面板的图片
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/main.png")));
    jcontentPane.add(contentPane, BorderLayout.CENTER);// 添加背景面板到内容面板

    JButton btnNewButton = new JButton("");// “添加开奖号码”按钮
    // 设置“添加开奖号码”按钮的图标
    btnNewButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/10.png"))
    );
    btnNewButton.setBounds(6, 114, 184, 40);// “添加开奖号码”按钮的位置及宽高
    contentPane.add(btnNewButton);// 将“添加开奖号码”按钮添加到自定义背景面板中
    JButton button = new JButton("");// “查看历届开奖”按钮
    // 设置“查看历届开奖”按钮的图标
    button.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/09.png"))
    );
    button.setBounds(6, 74, 184, 40);// “查看历届开奖”按钮的位置及宽高
    contentPane.add(button);// 将“查看历届开奖”按钮添加到自定义背景面板中
    JButton button_1 = new JButton("");// “批量添加号码”按钮
    // 设置“批量添加号码”按钮的图标
    button_1.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/11.png"))
    );
    button_1.setBounds(6, 154, 184, 40);// “批量添加号码”按钮的位置及宽高
    contentPane.add(button_1);// 将“批量添加号码”按钮添加到自定义背景面板中
    JButton updatebutton = new JButton("");// “修改开奖号码”按钮
    // 设置“修改开奖号码”按钮的图标
    updatebutton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/12.png"))
    );
    updatebutton.setBounds(6, 194, 184, 40);// “修改开奖号码”按钮的位置及宽高
    contentPane.add(updatebutton);// 将“修改开奖号码”按钮添加到自定义背景面板中

    JButton button_3 = new JButton("");// “查看号码走势”按钮
    // 设置“查看号码走势”按钮的图标
    button_3.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/14.png"))
    );
    button_3.setBounds(6, 234, 184, 40);// “查看号码走势”按钮的位置及宽高
    contentPane.add(button_3);// 将“查看号码走势”按钮添加到自定义背景面板中
    JButton button_4 = new JButton("");// “随机选号”按钮
    // 设置“随机选号”按钮的图标
    button_4.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/15.png"))
    );
    button_4.setBounds(6, 274, 184, 40);// “随机选号”按钮的位置及宽高
    contentPane.add(button_4);// 将“随机选号”按钮添加到自定义背景面板中
    JButton button_5 = new JButton("");// “中奖查询”按钮
    // 设置“中奖查询”按钮的图标
    button_5.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/17.png"))
    );
    button_5.setBounds(6, 314, 184, 40);// “中奖查询”按钮的位置及宽高
    contentPane.add(button_5);// 将“中奖查询”按钮添加到自定义背景面板中
    JButton button_6 = new JButton("");// “历史战绩”按钮
    // 设置“历史战绩”按钮的图标
    button_6.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/18.png"))
    );
    button_6.setBounds(6, 354, 184, 40);// “历史战绩”按钮的位置及宽高
    contentPane.add(button_6);// 将“历史战绩”按钮添加到自定义背景面板中
    JButton button_2 = new JButton("");// “退出系统”按钮
    // 设置“退出系统”按钮的图标
    button_2.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/08.png"))
    );
    button_2.setBounds(6, 394, 184, 40);// “退出系统”按钮的位置及宽高
    contentPane.add(button_2);// 将“退出系统”按钮添加到自定义背景面板中

    JScrollPane scrollPane = new JScrollPane(); // 滚动面板
    scrollPane.setBackground(new Color(0, 51, 204)); // 滚动面板背景色
    scrollPane.setBounds(217, 74, 848, 351); // 滚动面板在主窗体中的位置及宽高
    contentPane.add(scrollPane); // 将滚动面板添加到自定义背景面板中
    table = new JTable(); // 表格模型
    scrollPane.setViewportView(table); // 向滚动面板中添加表格
    firstPageButton = new JButton("首   页"); // “首页”按钮
    // 设置“首页”按钮的图标
    firstPageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_08.png")));
    firstPageButton.setBounds(416, 439, 84, 27); // “首页”按钮的位置及宽高
    contentPane.add(firstPageButton); // 将“首页”按钮添加到自定义背景面板中
    latePageButton = new JButton("上一页"); // “上一页”按钮
    // 设置“上一页”按钮的图标
    latePageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_10.png")));
    latePageButton.setBounds(550, 439, 84, 27); // “上一页”按钮的位置及宽高
    contentPane.add(latePageButton); // 将“上一页”按钮添加到自定义背景面板中
    nextPageButton = new JButton("下一页"); // “下一页”按钮
    // 设置“下一页”按钮的图标
    nextPageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_09.png")));
    nextPageButton.setBounds(686, 439, 84, 27); // “下一页”按钮的位置及宽高
    contentPane.add(nextPageButton); // 将“下一页”按钮添加到自定义背景面板中
    lastPageButton = new JButton("尾   页"); // “尾页”按钮
    // 设置“尾页”按钮的图标
    lastPageButton.setIcon(
            new ImageIcon(MainFrame.class.getResource("/img_btn/7_11.png")));
    lastPageButton.setBounds(819, 439, 84, 27); // “尾页”按钮的位置及宽高
    contentPane.add(lastPageButton); // 将“尾页”按钮添加到自定义背景面板中

    latePageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_latePageButton_actionPerformed(e);// 为“上一页”按钮添加动作事件的监听
        }
    });
    nextPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_nextPageButton_actionPerformed(e);// 为“下一页”按钮添加动作事件的监听
        }
    });


    selecttable();//分页显示开奖号码的方法

    firstPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_firstPageButton_actionPerformed(e);// 为“首页”按钮添加动作事件的监听
        }
    });
    lastPageButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_lastPageButton_actionPerformed(e);// 为“尾页”按钮添加动作事件的监听
        }
    });

}

// “上一页”按钮添加动作事件的监听
protected void do_latePageButton_actionPerformed(ActionEvent e) {
    currentPageNumber--;// 将当前页面减一
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    // 定义表头
    newModel.setColumnIdentifiers(new Object[]
            { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间" });
    for (int i = 0; i < pageSize; i++) {
        // 根据页面大小来获得数据
        newModel.addRow(
                (Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i))
        );
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// 设置表格模型
    if (currentPageNumber == 1) {
        firstPageButton.setEnabled(false);// 禁用“首页”按钮
        latePageButton.setEnabled(false);// 禁用“上一页”按钮
    }
    nextPageButton.setEnabled(true);// 启用“下一页”按钮
    lastPageButton.setEnabled(true);// 启用“尾页”按钮
}
// “下一页”按钮添加动作事件的监听
protected void do_nextPageButton_actionPerformed(ActionEvent e) {
    currentPageNumber++;// 将当前页面加一
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    // 定义表头
    newModel.setColumnIdentifiers(new Object[]
            { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间" });
    if (currentPageNumber == maxPageNumber) {
        int lastPageSize = (int)
                (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
        for (int i = 0; i < lastPageSize; i++) {
            // 根据页面大小来获得数据
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i))
            );
        }
        nextPageButton.setEnabled(false);// 禁用“下一页”按钮
        lastPageButton.setEnabled(false);// 禁用“尾页”按钮
    } else {
        for (int i = 0; i < pageSize; i++) {
            // 根据页面大小来获得数据
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (currentPageNumber - 1) + i))
            );
        }
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// 设置表格模型
    firstPageButton.setEnabled(true);// 启用“首页”按钮
    latePageButton.setEnabled(true);// 启用“上一页”按钮
}

// “首页”按钮添加动作事件的监听
protected void do_firstPageButton_actionPerformed(ActionEvent e) {
    currentPageNumber = 1;// 将当前页码设置成1
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    // 定义表头
    newModel.setColumnIdentifiers(new Object[]
            { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间" });
    for (int i = 0; i < pageSize; i++) {
        newModel.addRow((Vector) dataVector.elementAt(i));// 根据页面大小来获得数据
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// 设置表格模型
    firstPageButton.setEnabled(false);// 禁用“首页”按钮
    latePageButton.setEnabled(false);// 禁用“上一页”按钮
    nextPageButton.setEnabled(true);// 启用“下一页”按钮
    lastPageButton.setEnabled(true);// 启用“尾页”按钮
}
// “尾页”按钮添加动作事件的监听
protected void do_lastPageButton_actionPerformed(ActionEvent e) {
    currentPageNumber = maxPageNumber;// 将当前页面设置为末页
    Vector dataVector = defaultModel.getDataVector();// 获得原表格模型中的数据
    DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
    // 定义表头
    newModel.setColumnIdentifiers(new Object[]
            { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间" });
    int lastPageSize = (int)
            (defaultModel.getRowCount() - pageSize * (maxPageNumber - 1));
    if (lastPageSize == maxrows) {
        for (int i = 0; i < pageSize; i++) {
            // 根据页面大小来获得数据
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i))
            );
        }
    } else {
        for (int i = 0; i < lastPageSize; i++) {
            // 根据页面大小来获得数据
            newModel.addRow(
                    (Vector) dataVector.elementAt((int) (pageSize * (maxPageNumber - 1) + i))
            );
        }
    }
    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(newModel);// 设置表格模型
    firstPageButton.setEnabled(true);// 启用“首页”按钮
    latePageButton.setEnabled(true);// 启用“上一页”按钮
    nextPageButton.setEnabled(false);// 禁用“下一页”按钮
    lastPageButton.setEnabled(false);// 禁用“尾页”按钮
}

public void selecttable() {// 分页显示开奖号码的方法
    defaultModel = (DefaultTableModel) table.getModel();// 获得表格模型
    defaultModel.setRowCount(0);// 清空表格模型中的数据
    // 定义表头
    defaultModel.setColumnIdentifiers(new Object[]
            { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间" });
    String sql = "select count(id) from tb_history";// 定义SQL语句
    ConnMySQL con = new ConnMySQL();// 连接数据库
    ResultSet rs = con.showAll(sql);// 执行SQL语句后获得的结果集
    try {
        if (rs.next())// 因为上面的执行结果是有且只有一个，所以我们用if语句来遍历集合
        {
            maxrows = rs.getInt(1);// 为最大行数赋值
        }
        con.closeConnection();// 关闭链接
    } catch (SQLException eq) {
        eq.printStackTrace();
    }
    if (maxrows != 0) {// 判断如果有数据执行下面的方法
        // 按照开奖期数降序排列获得表tb_history中数据的SQL语句
        sql = "select * from tb_history order by number desc";
        rs = con.showAll(sql);// 执行SQL语句后获得的结果集
        try {
            // 为表格中每一行的单元格赋值
            while (rs.next()) {
                defaultModel.addRow(new Object[] { rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5),rs.getInt(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10) });
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        // 计算总页数
        maxPageNumber = (int)
                (maxrows % pageSize == 0 ? maxrows / pageSize : maxrows / pageSize + 1);
        DefaultTableModel newModel = new DefaultTableModel();// 创建新的表格模型
        // 定义表头
        newModel.setColumnIdentifiers(new Object[]
                { "期数", "第1位", "第2位", "第3位", "第4位", "第5位", "第6位", "第7位", "开奖时间" });
        for (int i = 0; i < pageSize; i++) {
            // 根据页面大小来获得数据
            newModel.addRow((Vector) defaultModel.getDataVector().elementAt(i));
        }
        table.getTableHeader().setReorderingAllowed(false);
        table.setModel(newModel);// 设置表格模型
        firstPageButton.setEnabled(false);// 禁用“首页”按钮
        latePageButton.setEnabled(false);// 禁用“上一页”按钮
        nextPageButton.setEnabled(true);// 启用“下一页”按钮
        lastPageButton.setEnabled(true);// 启用“尾页”按钮
    } else {
        firstPageButton.setEnabled(false);// 禁用“首页”按钮
        latePageButton.setEnabled(false);// 禁用“上一页”按钮
        nextPageButton.setEnabled(false);// 禁用“下一页”按钮
        lastPageButton.setEnabled(false);// 禁用“尾页”按钮
    }
}


}

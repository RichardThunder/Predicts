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
public Apanel() {// 第一位开奖号码的走势面板
    this.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置第一位开奖号码走势面板的边框样式
    setLayout(new BorderLayout(0, 0));// 设置第一位开奖号码走势面板的布局为边界布局
    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    // 设置背景面板的图片
    contentPane.setImage(
            getToolkit().getImage(getClass().getResource("/imgs/a9.png"))
    );
    add(contentPane, BorderLayout.CENTER);// 添加背景面板到第一位开奖号码走势面板的中间
    contentPane.setLayout(null);// 设置背景面板的布局为绝对布局

    // “各个数字在该位所出现的百分比”标签
    JLabel lblNewLabel = new JLabel("各个数字在该位所出现的百分比");
    // 设置“各个数字在该位所出现的百分比”标签的位置和宽高
    lblNewLabel.setBounds(175, 12, 217, 18);
    // 把“各个数字在该位所出现的百分比”标签添加到背景面板中
    contentPane.add(lblNewLabel);
    JLabel label = new JLabel("1:");// “1:”标签
    label.setBounds(60, 91, 27, 18);// 设置“1:”标签的位置和宽高
    contentPane.add(label);// 把“1:”标签添加到背景面板中
    JLabel label_1 = new JLabel("2:");// “2:”标签
    label_1.setBounds(60, 136, 27, 18);// 设置“2:”标签的位置和宽高
    contentPane.add(label_1);// 把“2:”标签添加到背景面板中
    JLabel label_2 = new JLabel("4:");// “4:”标签
    label_2.setBounds(60, 226, 27, 18);// 设置“4:”标签的位置和宽高
    contentPane.add(label_2);// 把“4:”标签添加到背景面板中
    JLabel label_3 = new JLabel("3:");// “3:”标签
    label_3.setBounds(60, 181, 27, 18);// 设置“3:”标签的位置和宽高
    contentPane.add(label_3);// 把“3:”标签添加到背景面板中
    JLabel label_4 = new JLabel("5:");// “5:”标签
    label_4.setBounds(60, 274, 27, 18);// 设置“5:”标签的位置和宽高
    contentPane.add(label_4);// 把“5:”标签添加到背景面板中
    JLabel label_5 = new JLabel("6:");// “6:”标签
    label_5.setBounds(60, 319, 27, 18);// 设置“6:”标签的位置和宽高
    contentPane.add(label_5);// 把“6:”标签添加到背景面板中
    JLabel label_6 = new JLabel("7:");// “7:”标签
    label_6.setBounds(60, 364, 27, 18);// 设置“7:”标签的位置和宽高
    contentPane.add(label_6);// 把“7:”标签添加到背景面板中
    JLabel label_7 = new JLabel("8:");// “8:”标签
    label_7.setBounds(60, 409, 27, 18);// 设置“8:”标签的位置和宽高
    contentPane.add(label_7);// 把“8:”标签添加到背景面板中
    JLabel label_8 = new JLabel("9:");// “9:”标签
    label_8.setBounds(60, 454, 27, 18);// 设置“9:”标签的位置和宽高
    contentPane.add(label_8);// 把“9:”标签添加到背景面板中
    JLabel label_9 = new JLabel("0:");// “0:”标签
    label_9.setBounds(60, 44, 27, 29);// 设置“0:”标签的位置和宽高
    contentPane.add(label_9);// 把“0:”标签添加到背景面板中

//添加进度条
    JProgressBar progressBar_0 = new JProgressBar();// 与“0:”标签对应的进度条
    progressBar_0.setBounds(94, 43, 321, 32);// 设置与“0:”标签对应的进度条的位置和宽高
    progressBar_0.setForeground(new Color(255, 165, 0));// 设置与“0:”标签对应的进度条的前景色
    progressBar_0.setStringPainted(true);// 设置与“0:”标签对应的进度条呈现的进度字符串
    // 设置与“0:”标签对应的进度条的字体样式和大小
    progressBar_0.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_0);// 把与“0:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_1 = new JProgressBar();// 与“1:”标签对应的进度条
    progressBar_1.setBounds(94, 85, 321, 32);// 设置与“1:”标签对应的进度条的位置和宽高
    progressBar_1.setForeground(new Color(255, 165, 0));// 设置与“1:”标签对应的进度条的前景色
    progressBar_1.setStringPainted(true);// 设置与“1:”标签对应的进度条呈现的进度字符串
    // 设置与“1:”标签对应的进度条的字体样式和大小
    progressBar_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_1);// 把与“1:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_2 = new JProgressBar();// 与“2:”标签对应的进度条
    progressBar_2.setBounds(94, 130, 321, 32);// 设置与“2:”标签对应的进度条的位置和宽高
    progressBar_2.setForeground(new Color(255, 165, 0));// 设置与“2:”标签对应的进度条的前景色
    progressBar_2.setStringPainted(true);// 设置与“1:”标签对应的进度条呈现的进度字符串
    // 设置与“2:”标签对应的进度条的字体样式和大小
    progressBar_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_2);// 把与“2:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_3 = new JProgressBar();// 与“3:”标签对应的进度条
    progressBar_3.setBounds(94, 175, 321, 32);// 设置与“3:”标签对应的进度条的位置和宽高
    progressBar_3.setForeground(new Color(255, 165, 0));// 设置与“3:”标签对应的进度条的前景色
    progressBar_3.setStringPainted(true);// 设置与“3:”标签对应的进度条呈现的进度字符串
    // 设置与“3:”标签对应的进度条的字体样式和大小
    progressBar_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_3);// 把与“3:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_4 = new JProgressBar();// 与“4:”标签对应的进度条
    progressBar_4.setBounds(94, 220, 321, 32);// 设置与“4:”标签对应的进度条的位置和宽高
    progressBar_4.setForeground(new Color(255, 165, 0));// 设置与“4:”标签对应的进度条的前景色
    progressBar_4.setStringPainted(true);// 设置与“4:”标签对应的进度条呈现的进度字符串
    // 设置与“4:”标签对应的进度条的字体样式和大小
    progressBar_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_4);// 把与“4:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_5 = new JProgressBar();// 与“5:”标签对应的进度条
    progressBar_5.setBounds(94, 268, 321, 32);// 设置与“5:”标签对应的进度条的位置和宽高
    progressBar_5.setForeground(new Color(255, 165, 0));// 设置与“5:”标签对应的进度条的前景色
    progressBar_5.setStringPainted(true);// 设置与“5:”标签对应的进度条呈现的进度字符串
    // 设置与“5:”标签对应的进度条的字体样式和大小
    progressBar_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_5);// 把与“5:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_6 = new JProgressBar();// 与“6:”标签对应的进度条
    progressBar_6.setBounds(94, 313, 321, 32);// 设置与“6:”标签对应的进度条的位置和宽高
    progressBar_6.setForeground(new Color(255, 165, 0));// 设置与“6:”标签对应的进度条的前景色
    progressBar_6.setStringPainted(true);// 设置与“6:”标签对应的进度条呈现的进度字符串
    // 设置与“6:”标签对应的进度条的字体样式和大小
    progressBar_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_6);// 把与“6:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_7 = new JProgressBar();// 与“7:”标签对应的进度条
    progressBar_7.setBounds(94, 358, 321, 32);// 设置与“7:”标签对应的进度条的位置和宽高
    progressBar_7.setForeground(new Color(255, 165, 0));// 设置与“7:”标签对应的进度条的前景色
    progressBar_7.setStringPainted(true);// 设置与“7:”标签对应的进度条呈现的进度字符串
    // 设置与“7:”标签对应的进度条的字体样式和大小
    progressBar_7.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_7);// 把与“7:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_8 = new JProgressBar();// 与“8:”标签对应的进度条
    progressBar_8.setBounds(94, 403, 321, 32);// 设置与“8:”标签对应的进度条的位置和宽高
    progressBar_8.setForeground(new Color(255, 165, 0));// 设置与“8:”标签对应的进度条的前景色
    progressBar_8.setStringPainted(true);// 设置与“8:”标签对应的进度条呈现的进度字符串
    // 设置与“8:”标签对应的进度条的字体样式和大小
    progressBar_8.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_8);// 把与“8:”标签对应的进度条添加到背景面板中
    JProgressBar progressBar_9 = new JProgressBar();// 与“9:”标签对应的进度条
    progressBar_9.setBounds(94, 448, 321, 32);// 设置与“9:”标签对应的进度条的位置和宽高
    progressBar_9.setForeground(new Color(255, 165, 0));// 设置与“9:”标签对应的进度条的前景色
    progressBar_9.setStringPainted(true);// 设置与“9:”标签对应的进度条呈现的进度字符串
    // 设置与“9:”标签对应的进度条的字体样式和大小
    progressBar_9.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_9);// 把与“9:”标签对应的进度条添加到背景面板中
//添加统计标签
    JLabel l_0 = new JLabel("");// 统计0出现的次数标签
    l_0.setBounds(439, 49, 104, 18);// 设置统计0出现的次数标签的位置和宽高
    contentPane.add(l_0);// 把统计0出现的次数标签添加到背景面板中
    JLabel l_1 = new JLabel("");// 统计1出现的次数标签
    l_1.setBounds(439, 91, 104, 18);// 设置统计1出现的次数标签的位置和宽高
    contentPane.add(l_1);// 把统计1出现的次数标签添加到背景面板中
    JLabel l_2 = new JLabel("");// 统计2出现的次数标签
    l_2.setBounds(439, 136, 104, 18);// 设置统计2出现的次数标签的位置和宽高
    contentPane.add(l_2);// 把统计2出现的次数标签添加到背景面板中
    JLabel l_3 = new JLabel("");// 统计3出现的次数标签
    l_3.setBounds(439, 181, 104, 18);// 设置统计3出现的次数标签的位置和宽高
    contentPane.add(l_3);// 把统计3出现的次数标签添加到背景面板中
    JLabel l_4 = new JLabel("");// 统计4出现的次数标签
    l_4.setBounds(439, 226, 104, 18);// 设置统计4出现的次数标签的位置和宽高
    contentPane.add(l_4);// 把统计4出现的次数标签添加到背景面板中
    JLabel l_5 = new JLabel("");// 统计5出现的次数标签
    l_5.setBounds(439, 274, 104, 18);// 设置统计5出现的次数标签的位置和宽高
    contentPane.add(l_5);// 把统计5出现的次数标签添加到背景面板中
    JLabel l_6 = new JLabel("");// 统计6出现的次数标签
    l_6.setBounds(439, 319, 104, 18);// 设置统计6出现的次数标签的位置和宽高
    contentPane.add(l_6);// 把统计6出现的次数标签添加到背景面板中
    JLabel l_7 = new JLabel("");// 统计7出现的次数标签
    l_7.setBounds(439, 364, 104, 18);// 设置统计7出现的次数标签的位置和宽高
    contentPane.add(l_7);// 把统计7出现的次数标签添加到背景面板中
    JLabel l_8 = new JLabel("");// 统计8出现的次数标签
    l_8.setBounds(439, 409, 104, 18);// 设置统计8出现的次数标签的位置和宽高
    contentPane.add(l_8);// 把统计8出现的次数标签添加到背景面板中
    JLabel l_9 = new JLabel("");// 统计9出现的次数标签
    l_9.setBounds(439, 454, 104, 18);// 设置统计9出现的次数标签的位置和宽高
    //链接数据库
    contentPane.add(l_9);// 把统计9出现的次数标签添加到背景面板中
    ConnMySQL con = new ConnMySQL();// 连接MySQL数据库
    String ab = "a";// 第一位开奖号码
    int i0 = con.getABC(ab, 0);// 获得第一位开奖号码0出现的次数
    con.closeConnection();// 关闭数据库连接
    int i1 = con.getABC(ab, 1);// 获得第一位开奖号码1出现的次数
    con.closeConnection();// 关闭数据库连接
    int i2 = con.getABC(ab, 2);// 获得第一位开奖号码2出现的次数
    con.closeConnection();// 关闭数据库连接
    int i3 = con.getABC(ab, 3);// 获得第一位开奖号码3出现的次数
    con.closeConnection();// 关闭数据库连接
    int i4 = con.getABC(ab, 4);// 获得第一位开奖号码4出现的次数
    con.closeConnection();// 关闭数据库连接
    int i5 = con.getABC(ab, 5);// 获得第一位开奖号码5出现的次数
    con.closeConnection();// 关闭数据库连接
    int i6 = con.getABC(ab, 6);// 获得第一位开奖号码6出现的次数
    con.closeConnection();// 关闭数据库连接
    int i7 = con.getABC(ab, 7);// 获得第一位开奖号码7出现的次数
    con.closeConnection();// 关闭数据库连接
    int i8 = con.getABC(ab, 8);// 获得第一位开奖号码8出现的次数
    con.closeConnection();// 关闭数据库连接
    int i9 = con.getABC(ab, 9);// 获得第一位开奖号码9出现的次数
    con.closeConnection();// 关闭数据库连接
    // 设置统计开奖号码出现次数标签中的文本内容
    l_0.setText("出现 " + i0 + " 次");
    l_1.setText("出现 " + i1 + " 次");
    l_2.setText("出现 " + i2 + " 次");
    l_3.setText("出现 " + i3 + " 次");
    l_4.setText("出现 " + i4 + " 次");
    l_5.setText("出现 " + i5 + " 次");
    l_6.setText("出现 " + i6 + " 次");
    l_7.setText("出现 " + i7 + " 次");
    l_8.setText("出现 " + i8 + " 次");
    l_9.setText("出现 " + i9 + " 次");
    double all = i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;// 获得开奖次数
    DecimalFormat df = new DecimalFormat(".###");// 格式化（保留三位有效数字）
    // 设置被格式化的进度字符串的值，并设置进图条当前值
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

    JButton button = new JButton();// 按钮
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// 为按钮添加动作事件的监听
        }
    });
    button.setBounds(94, 485, 321, 32);// 设置按钮的位置和宽高
    button.setText("查看最近10期的第一位开奖号码走势图");// 设置按钮中的文本内容
    button.setFont(new Font("幼圆", Font.PLAIN, 16));// 设置按钮中的字体样式和大小
    button.setForeground(new Color(0, 102, 153));// 设置按钮的前景色
    contentPane.add(button);// 把按钮添加到背景面板中
}
// “查看最近10期的第一位开奖号码走势图”动作事件的监听
protected void do_button_actionPerformed(ActionEvent e) {
    // 创建“第一位开奖号码走势图”折线图窗体对象
    ALineChart chart = new ALineChart(null, "第一位开奖号码走势图");
    chart.pack();// 调整窗口的大小，以适应折线图对象的首选大小和布局
    RefineryUtilities.centerFrameOnScreen(chart);// 将折线图对象置于屏幕中间
    chart.setVisible(true);// 设置折线图窗体对象可见
}






}


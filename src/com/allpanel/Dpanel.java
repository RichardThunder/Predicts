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

public class Dpanel extends JPanel {// 第四位开奖号码走势面板

public Dpanel() {// 第四位开奖号码走势面板
    this.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置第四位开奖号码走势面板的边框样式
    setLayout(new BorderLayout(0, 0));// 设置第四位开奖号码走势面板的布局为边界布局
    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/a9.png")));// 设置背景面板的图片
    add(contentPane, BorderLayout.CENTER);// 添加背景面板到内容面板
    contentPane.setLayout(null);// 设置背景面板的布局为绝对布局

    JLabel lblNewLabel = new JLabel(
            "各个数字在该位所出现的百分比");// “各个数字在该位所出现的百分比”标签
    lblNewLabel.setBounds(175, 12, 217, 18);// 设置“各个数字在该位所出现的百分比”标签的位置和宽高
    contentPane.add(lblNewLabel);// 把“各个数字在该位所出现的百分比”标签添加到背景面板中
    // 创建“1:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label = new JLabel("1:");
    label.setBounds(60, 91, 27, 18);
    contentPane.add(label);
    // 创建“2:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_1 = new JLabel("2:");
    label_1.setBounds(60, 136, 27, 18);
    contentPane.add(label_1);
    // 创建“4:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_2 = new JLabel("4:");
    label_2.setBounds(60, 226, 27, 18);
    contentPane.add(label_2);
    // 创建“3:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_3 = new JLabel("3:");
    label_3.setBounds(60, 181, 27, 18);
    contentPane.add(label_3);
    // 创建“5:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_4 = new JLabel("5:");
    label_4.setBounds(60, 274, 27, 18);
    contentPane.add(label_4);
    // 创建“6:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_5 = new JLabel("6:");
    label_5.setBounds(60, 319, 27, 18);
    contentPane.add(label_5);
    // 创建“7:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_6 = new JLabel("7:");
    label_6.setBounds(60, 364, 27, 18);
    contentPane.add(label_6);
    // 创建“8:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_7 = new JLabel("8:");
    label_7.setBounds(60, 409, 27, 18);
    contentPane.add(label_7);
    // 创建“9:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_8 = new JLabel("9:");
    label_8.setBounds(60, 454, 27, 18);
    contentPane.add(label_8);
    // 创建“0:”标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel label_9 = new JLabel("0:");
    label_9.setBounds(60, 44, 27, 29);
    contentPane.add(label_9);
    // 创建与“0:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_0 = new JProgressBar();
    progressBar_0.setBounds(94, 43, 321, 32);
    progressBar_0.setForeground(new Color(255, 165, 0));
    progressBar_0.setStringPainted(true);
    progressBar_0.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_0);
    // 创建与“1:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_1 = new JProgressBar();
    progressBar_1.setBounds(94, 85, 321, 32);
    progressBar_1.setForeground(new Color(255, 165, 0));
    progressBar_1.setStringPainted(true);
    progressBar_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_1);
    // 创建与“2:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_2 = new JProgressBar();
    progressBar_2.setBounds(94, 130, 321, 32);
    progressBar_2.setForeground(new Color(255, 165, 0));
    progressBar_2.setStringPainted(true);
    progressBar_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_2);
    // 创建与“3:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_3 = new JProgressBar();
    progressBar_3.setBounds(94, 175, 321, 32);
    progressBar_3.setForeground(new Color(255, 165, 0));
    progressBar_3.setStringPainted(true);
    progressBar_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_3);
    // 创建与“4:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_4 = new JProgressBar();
    progressBar_4.setBounds(94, 220, 321, 32);
    progressBar_4.setForeground(new Color(255, 165, 0));
    progressBar_4.setStringPainted(true);
    progressBar_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_4);
    // 创建与“5:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_5 = new JProgressBar();
    progressBar_5.setBounds(94, 268, 321, 32);
    progressBar_5.setForeground(new Color(255, 165, 0));
    progressBar_5.setStringPainted(true);
    progressBar_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_5);
    // 创建与“6:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_6 = new JProgressBar();
    progressBar_6.setBounds(94, 313, 321, 32);
    progressBar_6.setForeground(new Color(255, 165, 0));
    progressBar_6.setStringPainted(true);
    progressBar_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_6);
    // 创建与“7:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_7 = new JProgressBar();
    progressBar_7.setBounds(94, 358, 321, 32);
    progressBar_7.setForeground(new Color(255, 165, 0));
    progressBar_7.setStringPainted(true);
    progressBar_7.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_7);
    // 创建与“8:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_8 = new JProgressBar();
    progressBar_8.setBounds(94, 403, 321, 32);
    progressBar_8.setForeground(new Color(255, 165, 0));
    progressBar_8.setStringPainted(true);
    progressBar_8.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_8);
    // 创建与“9:”标签对应的进度条，设置该进度条的位置和宽高、前景色、字体样式和大小以及呈现进度字符串，把该进度条添加到背景面板中
    JProgressBar progressBar_9 = new JProgressBar();
    progressBar_9.setBounds(94, 448, 321, 32);
    progressBar_9.setForeground(new Color(255, 165, 0));
    progressBar_9.setStringPainted(true);
    progressBar_9.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    contentPane.add(progressBar_9);
    // 创建按钮，设置该按钮的位置和宽高、文本内容、字体样式和大小、前景色，把该按钮添加到背景面板中，并为该按钮添加动作监听事件
    JButton button = new JButton();
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);
        }
    });
    button.setBounds(94, 485, 321, 32);
    button.setText("查看最近10期的第四位开奖号码走势图");
    button.setFont(new Font("幼圆", Font.PLAIN, 16));
    button.setForeground(new Color(0, 102, 153));
    contentPane.add(button);
    // 创建统计0出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_0 = new JLabel("");
    l_0.setBounds(439, 49, 104, 18);
    contentPane.add(l_0);
    // 创建统计1出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_1 = new JLabel("");
    l_1.setBounds(439, 91, 104, 18);
    contentPane.add(l_1);
    // 创建统计2出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_2 = new JLabel("");
    l_2.setBounds(439, 136, 104, 18);
    contentPane.add(l_2);
    // 创建统计3出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_3 = new JLabel("");
    l_3.setBounds(439, 181, 104, 18);
    contentPane.add(l_3);
    // 创建统计4出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_4 = new JLabel("");
    l_4.setBounds(439, 226, 104, 18);
    contentPane.add(l_4);
    // 创建统计5出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_5 = new JLabel("");
    l_5.setBounds(439, 274, 104, 18);
    contentPane.add(l_5);
    // 创建统计6出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_6 = new JLabel("");
    l_6.setBounds(439, 319, 104, 18);
    contentPane.add(l_6);
    // 创建统计7出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_7 = new JLabel("");
    l_7.setBounds(439, 364, 104, 18);
    contentPane.add(l_7);
    // 创建统计8出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_8 = new JLabel("");
    l_8.setBounds(439, 409, 104, 18);
    contentPane.add(l_8);
    // 创建统计9出现的次数标签，设置该标签的位置和宽高，把该标签添加到背景面板中
    JLabel l_9 = new JLabel("");
    l_9.setBounds(439, 454, 104, 18);
    contentPane.add(l_9);

    ConnMySQL con = new ConnMySQL();// 连接MySQL数据库

    String ab = "d";// 第四位开奖号码
    // 获得第四位开奖号码0~9出现的次数
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

    double all = i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;// 获得开奖次数
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

}

protected void do_button_actionPerformed(ActionEvent e) {// “查看最近10期的第四位开奖号码走势图”动作事件的监听
    DLineChart chart = new DLineChart(null, "第四位开奖号码走势图");// 创建“第四位开奖号码走势图”折线图窗体对象
    chart.pack();// 调整窗口的大小，以适应折线图对象的首选大小和布局
    RefineryUtilities.centerFrameOnScreen(chart);// 将折线图对象置于屏幕中间
    chart.setVisible(true);// 设置折线图窗体对象可见
}

}

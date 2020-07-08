package com.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.dao.HistoryDao;
import com.dao.LotteryValidate;
import com.model.History;

public class SelectBonusframe extends JDialog {// 中奖查询对话框

private JPanel jcontentPane;// 内容面板
private JTextField numberField1;// “开奖期数”文本框
private JTextField seven1;// “购买奖号”文本框
private JTextField seven2;// “开奖号码”文本框
private JTextField money;// “奖金”文本框

public static void main(String[] args) {
    try {
        // 设置中奖查询对话框的风格
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                SelectBonusframe frame = new SelectBonusframe();// 中奖查询对话框
                frame.setVisible(true);// 使中奖查询对话框可见
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public SelectBonusframe() {// 中奖查询对话框的构造方法
    setModal(true);// 使中奖查询对话框总在最前
    setResizable(false);// 设置中奖查询对话框不可改变大小
    setIconImage(Toolkit.getDefaultToolkit().getImage(SelectBonusframe.class.getResource("/imgs/log.png")));// 设置中奖查询对话框的标题图标
    setTitle("中奖查询");// 设置中奖查询对话框的标题
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置中奖查询对话框的关闭方式
    setBounds(500, 150, 554, 532);// 设置中奖查询对话框的位置以及宽高

    jcontentPane = new JPanel();// 内容面板
    jcontentPane.setLayout(new BorderLayout(0, 0));// 设置内容面板的布局为边界布局
    setContentPane(jcontentPane);// 把内容面板置于中奖查询对话框中

    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// 设置背景面板的图片
    jcontentPane.add(contentPane, BorderLayout.CENTER);// 添加背景面板到内容面板

    JLabel label = new JLabel("输入查询期数：");// “输入查询期数：”标签
    label.setBounds(78, 90, 119, 18);// 设置“输入查询期数：”标签的位置和宽高
    contentPane.add(label);// 把“输入查询期数：”标签置于自定义背景面板中

    JLabel label_1 = new JLabel("输入查询号码：");// “输入查询号码：”标签
    label_1.setBounds(78, 149, 119, 18);// 设置“输入查询号码：”标签的位置和宽高
    contentPane.add(label_1);// 把“输入查询号码：”标签置于自定义背景面板中

    JButton btnNewButton = new JButton();// “查询”按钮
    btnNewButton.setIcon(new ImageIcon(SelectBonusframe.class.getResource("/img_btn/a03.png")));// 设置“查询”按钮的图标
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// 为“查询”按钮添加动作事件的监听
        }
    });
    btnNewButton.setBounds(136, 335, 109, 38);// 设置“查询”按钮的位置和宽高
    contentPane.add(btnNewButton);// 把“查询”按钮置于自定义背景面板中

    numberField1 = new JTextField();// “开奖期数”文本框
    numberField1.setBounds(234, 87, 197, 24);// 设置“开奖期数”文本框的位置和宽高
    contentPane.add(numberField1);// 把“开奖期数”文本框置于自定义背景面板中
    numberField1.setColumns(20);// 设置“开奖期数”文本框的宽度

    seven1 = new JTextField();// “购买奖号”文本框
    seven1.setColumns(10);// 设置“购买奖号”文本框的宽度
    seven1.setBounds(234, 143, 197, 24);// 设置“购买奖号”文本框的位置和宽高
    contentPane.add(seven1);// 把“购买奖号”文本框置于自定义背景面板中

    JButton button = new JButton("");// “关闭”按钮
    button.setIcon(new ImageIcon(SelectBonusframe.class.getResource("/img_btn/a07.png")));// 设置“关闭”按钮的图标
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// 为“关闭”按钮添加动作事件的监听
        }
    });
    button.setBounds(279, 335, 108, 39);// 设置“关闭”按钮的位置和宽高
    contentPane.add(button);// 把“关闭”按钮置于自定义背景面板中

    JLabel label_3 = new JLabel("您所查询该期开奖号码：");// “您所查询该期开奖号码：”标签
    label_3.setBounds(47, 208, 173, 18);// 设置“您所查询该期开奖号码：”标签的位置和宽高
    contentPane.add(label_3);// 把“您所查询该期开奖号码：”标签置于自定义背景面板中

    JLabel label_4 = new JLabel("所得奖金：");// “所得奖金：”标签
    label_4.setBounds(101, 275, 119, 18);// 设置“所得奖金：”标签的位置和宽高
    contentPane.add(label_4);// 把“所得奖金：”标签置于自定义背景面板中

    seven2 = new JTextField();// “开奖号码”文本框
    seven2.setEditable(false);// 设置“开奖号码”文本框不可编辑
    seven2.setColumns(10);// 设置“开奖号码”文本框的宽度
    seven2.setBounds(234, 205, 197, 24);// 设置“开奖号码”文本框的位置和宽高
    contentPane.add(seven2);// 把“开奖号码”文本框置于自定义背景面板中

    money = new JTextField();// “奖金”文本框
    money.setEditable(false);// 设置“奖金”文本框不可编辑
    money.setColumns(10);// 设置“奖金”文本框的宽度
    money.setBounds(234, 272, 197, 24);// 设置“奖金”文本框的位置和宽高
    contentPane.add(money);// 把“奖金”文本框置于自定义背景面板中
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// “查询”按钮动作事件的监听
    int number = Integer.parseInt(numberField1.getText());// 获得转换为int型的“开奖期数”
    HistoryDao his = new HistoryDao();// 实例化操作开奖信息
    History h = his.getOneHistory(number);// 获取一个开奖号码
    String seven = seven1.getText();// 获得“购买奖号”
    String sevens[] = seven.split("");// 分隔“购买奖号”
    int[] s1 = new int[] { h.getA(), h.getB(), h.getC(), h.getD(), h.getE(), h.getF(), h.getG() };// 把“开奖号码”转换为数组
    int[] s2 = new int[] { Integer.parseInt(sevens[0]), Integer.parseInt(sevens[1]), Integer.parseInt(sevens[2]),
            Integer.parseInt(sevens[3]), Integer.parseInt(sevens[4]), Integer.parseInt(sevens[5]),
            Integer.parseInt(sevens[6]) };// 把“购买奖号”转换为数组
    seven2.setText("" + h.getA() + h.getB() + h.getC() + h.getD() + h.getE() + h.getF() + h.getG());// 设置“开奖号码”文本框的内容
    LotteryValidate lv = new LotteryValidate();// 实例化验证信息
    int i = lv.computeBonus(s1, s2);// 获得奖金的等级
    switch (i) {// 以获得奖金的等级为参数的多分支语句
        case 6:// 6等奖
            money.setText("恭喜你得了6等奖！奖金5元！");// 设置“奖金”文本框中的内容
            break;
        case 5:// 5等奖
            money.setText("恭喜你得了5等奖！奖金20元！");// 设置“奖金”文本框中的内容
            break;
        case 4:// 4等奖
            money.setText("恭喜你得了4等奖！奖金300元！");// 设置“奖金”文本框中的内容
            break;
        case 3:// 3等奖
            money.setText("恭喜你得了3等奖！奖金1800元！");// 设置“奖金”文本框中的内容
            break;
        case 2:// 2等奖
            money.setText("恭喜你得了2等奖！奖金50000元！");// 设置“奖金”文本框中的内容
            break;
        case 1:// 1等奖
            money.setText("恭喜你得了1等奖！奖金500万元！");// 设置“奖金”文本框中的内容
            break;
        case 0:// 没有中奖
            money.setText("很遗憾您没有中奖");// 设置“奖金”文本框中的内容
            break;
    }
}

protected void do_button_actionPerformed(ActionEvent e) {// “关闭”按钮动作事件的监听
    this.setVisible(false);// 使中奖查询对话框不可见
}
}

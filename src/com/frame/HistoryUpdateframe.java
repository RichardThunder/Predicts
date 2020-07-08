package com.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.dao.ForecastDao;
import com.dao.HistoryDao;
import com.dao.LotteryValidate;
import com.model.History;
import com.model.UpDateNumber;

public class HistoryUpdateframe extends JDialog {// 修改开奖号码对话框

private JPanel jcontentPane;// 内容面板
private JTextField numberField;// “开奖期数”文本框
private JTextField sevenField;// “开奖号码”文本框
private JTextField timeField;// “开奖日期”文本框
JLabel erroyLabel1;// “开奖号码格式错误”(提示)标签
JLabel erroyLabel2;// “开奖日期格式错误”(提示)标签
JLabel addLabel;// “修改状态”(提示)标签

public static void main(String[] args) {
    try {
        // 设置修改开奖号码对话框风格
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // 修改开奖号码对话框
                HistoryUpdateframe frame = new HistoryUpdateframe();
                frame.setVisible(true);// 使修改开奖号码对话框可见
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public HistoryUpdateframe() {// 修改开奖号码对话框的构造方法
    setModal(true);// 使修改开奖号码对话框总在最前
    setResizable(false);// 设置修改开奖号码对话框不可改变大小
    setTitle("修改开奖号码");// 设置修改开奖号码对话框的标题
    setIconImage(Toolkit.getDefaultToolkit().getImage(HistoryUpdateframe.class.getResource("/imgs/log.png")));// 设置修改开奖号码对话框的标题图标
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置修改开奖号码对话框的关闭方式
    setBounds(500, 150, 540, 481);// 设置修改开奖号码对话框的位置以及宽高

    jcontentPane = new JPanel();// 内容面板
    jcontentPane.setLayout(new BorderLayout(0, 0));// 设置内容面板的布局为边界布局
    setContentPane(jcontentPane);// 把内容面板置于修改开奖号码对话框中

    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// 设置背景面板的图片
    jcontentPane.add(contentPane, BorderLayout.CENTER);// 添加背景面板到内容面板

    numberField = new JTextField();// “开奖期数”文本框
    numberField.setEditable(false);// 设置“开奖期数”文本框不可编辑
    numberField.setBounds(216, 105, 155, 24);// 设置“开奖期数”文本框的位置和宽高
    contentPane.add(numberField);// 把“开奖期数”文本框置于自定义背景面板中
    numberField.setColumns(10);// 设置“开奖期数”文本框的宽度

    JLabel lblNewLabel = new JLabel("开奖期数：");// “开奖期数：”标签
    lblNewLabel.setBounds(102, 108, 100, 18);// 设置“开奖期数：”标签的位置以及宽高
    contentPane.add(lblNewLabel);// 把“开奖期数：”标签置于自定义背景面板中

    JLabel label = new JLabel("开奖号码：");// “开奖号码：”标签
    label.setBounds(102, 175, 100, 18);// 设置“开奖号码：”标签的位置以及宽高
    contentPane.add(label);// 把“开奖号码：”标签置于自定义背景面板中

    sevenField = new JTextField();// “开奖号码：”文本框
    sevenField.setColumns(10);// 设置“开奖号码：”文本框的宽度
    sevenField.setBounds(216, 172, 155, 24);// 设置“开奖号码：”文本框的位置和宽高
    contentPane.add(sevenField);// 把“开奖号码：”文本框置于自定义背景面板中

    JButton btnNewButton = new JButton("");// “修改”按钮
    btnNewButton.setIcon(new ImageIcon(HistoryUpdateframe.class.getResource("/img_btn/a05.png")));// 设置“修改”按钮的图标
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// 为“修改”按钮添加动作事件的监听
        }
    });
    btnNewButton.setBounds(136, 291, 109, 74);// 设置“修改”按钮的位置以及宽高
    contentPane.add(btnNewButton);// 把“修改”按钮置于自定义背景面板中

    JButton button = new JButton("");// “关闭”按钮
    button.setIcon(new ImageIcon(HistoryUpdateframe.class.getResource("/img_btn/a07.png")));// 设置“关闭”按钮的图标
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// 为“关闭”按钮添加动作事件的监听
        }
    });
    button.setBounds(288, 291, 108, 39);// 设置“关闭”按钮的位置以及宽高
    contentPane.add(button);// 把“关闭”按钮置于自定义背景面板中

    JLabel label_1 = new JLabel("开奖日期：");// “开奖日期：”标签
    label_1.setBounds(102, 243, 100, 18);// 设置“开奖日期：”标签的位置以及宽高
    contentPane.add(label_1);// 把“开奖日期：”标签置于自定义背景面板中

    timeField = new JTextField();// “开奖日期”文本框
    timeField.setColumns(10);// 设置“开奖日期”文本框的宽度
    timeField.setBounds(216, 240, 155, 24);// 设置“开奖日期”文本框的位置和宽高
    contentPane.add(timeField);// 把“开奖日期”文本框置于自定义背景面板中

    erroyLabel1 = new JLabel("");// “开奖号码格式错误”(提示)标签
    erroyLabel1.setBounds(241, 142, 155, 18);// 设置“开奖号码格式错误”(提示)标签的位置和宽高
    contentPane.add(erroyLabel1);// 把“开奖号码格式错误”(提示)标签置于自定义背景面板中

    erroyLabel2 = new JLabel("");// “开奖日期格式错误”(提示)标签
    erroyLabel2.setBounds(261, 209, 155, 18);// 设置“开奖日期格式错误”(提示)标签的位置和宽高
    contentPane.add(erroyLabel2);// 把“开奖日期格式错误”(提示)标签置于自定义背景面板中

    addLabel = new JLabel("");// “修改状态”(提示)标签
    addLabel.setBounds(207, 60, 164, 32);// 设置“修改状态”(提示)标签的位置和宽高
    contentPane.add(addLabel);// 把“修改状态”(提示)标签置于自定义背景面板中

    int number = UpDateNumber.getN();// 获得要修改的开奖期数

    HistoryDao hd = new HistoryDao();// 实例化操作开奖信息
    History his = new History();// 实例化历届开奖结果
    his = hd.getOneHistory(number);// 获取一个开奖号码
    numberField.setText(number + "");// 设置“开奖期数”文本框的内容
    sevenField.setText("" + his.getA() + his.getB() + his.getC() + his.getD() + his.getE() + his.getF() + his.getG());// 设置“开奖号码”文本框的内容
    timeField.setText(his.getHistorytime());// 设置“开奖日期”文本框的内容

}

protected void do_button_actionPerformed(ActionEvent e) {// “关闭”按钮动作事件的监听
    this.setVisible(false);// 使修改开奖号码对话框不可见
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {
    LotteryValidate validate = new LotteryValidate();// 实例化验证信息
    if (!validate.validateNumber(sevenField.getText())) {// “开奖号码”的格式错误
        erroyLabel1.setText("开奖号码格式不正确");// 设置“开奖号码格式错误”(提示)标签的内容
    }
    if (validate.validateNumber(sevenField.getText())) {// “开奖号码”的格式正确
        erroyLabel1.setText("");// 设置“开奖号码格式错误”(提示)标签的内容为空
    }
    if (validate.validateData(timeField.getText())) {// “开奖日期”的格式正确
        erroyLabel2.setText("");// 设置“开奖日期格式错误”(提示)标签的内容为空
    } else {
        erroyLabel2.setText("开奖日期格式不正确");// 设置“开奖日期格式错误”(提示)标签的内容
    }
    if ((validate.validateNumber(sevenField.getText())) && validate.validateData(timeField.getText())) {// “开奖号码”的格式与“开奖日期”的格式都正确
        HistoryDao his = new HistoryDao();// 实例化操作开奖信息
        Boolean b;//
        b = his.updateNumber(Integer.parseInt(numberField.getText()), sevenField.getText(), timeField.getText());// 修改开奖号码是否成功
        if (b) {// 修改开奖号码成功
            addLabel.setText("修改成功！");// 设置“修改状态”(提示)标签的内容
            numberField.setText((his.selectNumber() - 1) + "");// 设置“开奖期数”文本框中的内容
            ForecastDao fDao = new ForecastDao();// 实例化操作购买彩票记录信息
            try {
                fDao.awardEvaluate(UpDateNumber.getN());// 修改获得的奖金
                JOptionPane.showMessageDialog(this, "修改成功！", "", JOptionPane.WARNING_MESSAGE);// 弹出框
                this.setVisible(false);// 使修改开奖号码对话框不可见
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else {// 修改开奖号码失败
            addLabel.setText("修改失败！");// 设置“修改状态”(提示)标签的内容
        }
    }
}
}

package com.frame;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.dao.ForecastDao;
import com.dao.HistoryDao;
import com.dao.LotteryValidate;

public class HistoryAddframe extends JDialog {// 添加号码对话框

private JPanel jcontentPane;// 内容面板
private JTextField numberTextField;// “开奖期数”文本框
private JTextField sevenTextField;// “开奖号码”文本框
private JTextField historytimeTextField;// “开奖时间”文本框
private JLabel erroyLabel1;// “开奖号码格式错误”标签
private JLabel erroyLabel2;// “开奖时间格式错误”标签
private JLabel addLabel;// “添加状态”标签

/**
 * Launch the application.
 */
public static void main(String[] args) {
    try {
        // 设置主窗体风格
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // 实例化添加号码对话框
                HistoryAddframe frame = new HistoryAddframe();
                // 使添加号码对话框可见
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public HistoryAddframe() {// 添加号码对话框的构造方法
    erroyLabel1 = new JLabel("");// “开奖号码格式错误”标签
    erroyLabel2 = new JLabel("");// 开奖时间格式错误的标签
    addLabel = new JLabel("");// 添加状态的标签

    setModal(true);// 使添加号码对话框总在最前
    setResizable(false);// 添加号码对话框不可改变大小
    setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);//顶层窗口不会被应用程序中的对话框阻塞
    setTitle("添加开奖号码");// 添加号码对话框的标题
    setIconImage(Toolkit.getDefaultToolkit().getImage(HistoryAddframe.class.getResource("/imgs/log.png")));// 添加号码对话框的标题的图标
    HistoryDao his = new HistoryDao();// 实例化历届开奖结果
    setBounds(500, 150, 540, 481);// 添加号码对话框的位置以及宽高

    jcontentPane = new JPanel();// 内容面板
    jcontentPane.setLayout(new BorderLayout(0, 0));// 设置内容面板的布局是边界布局
    setContentPane(jcontentPane);// 把内容面板置于添加号码对话框中

    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// 设置背景面板的图片
    jcontentPane.add(contentPane, BorderLayout.CENTER);// 添加背景面板到内容面板

    JLabel label = new JLabel("七星彩第");// “七星彩第”标签
    label.setBounds(147, 105, 60, 18);// “七星彩第”标签的位置以及宽高
    contentPane.add(label);// 将“七星彩第”标签置于自定义背景面板中

    numberTextField = new JTextField();// “开奖期数”文本框
    numberTextField.setEditable(false);// 设置“开奖期数”文本框不可编辑
    numberTextField.setBounds(233, 102, 60, 24);// 设置“开奖期数”文本框的位置以及宽高
    contentPane.add(numberTextField);// 将“开奖期数”文本框置于自定义背景面板中
    numberTextField.setColumns(10);// 设置“开奖期数”文本框的宽度

    JLabel label_1 = new JLabel("期");// “期”标签
    label_1.setBounds(319, 105, 22, 18);// “期”标签的位置以及宽高
    contentPane.add(label_1);// 将“期”标签置于自定义背景面板中

    JLabel label_2 = new JLabel("开奖号码：");// “开奖号码：”标签
    label_2.setBounds(89, 160, 91, 30);// “开奖号码：”标签的位置以及宽高
    contentPane.add(label_2);// 将“开奖号码：”标签置于自定义背景面板中

    JLabel label_3 = new JLabel("开奖时间：");// “开奖时间：”标签
    label_3.setBounds(89, 234, 91, 24);// “开奖时间：”标签的位置以及宽高
    contentPane.add(label_3);// 将“开奖时间：”标签置于自定义背景面板中

    sevenTextField = new JTextField();// “开奖号码”文本框
    sevenTextField.setBounds(184, 159, 157, 33);// “开奖号码”文本框的位置以及宽高
    contentPane.add(sevenTextField);// 将“开奖号码”文本框置于自定义背景面板中
    sevenTextField.setColumns(10);// 设置“开奖号码”文本框的宽度

    historytimeTextField = new JTextField();// “开奖时间”文本框
    historytimeTextField.setColumns(10);// 设置“开奖时间”文本框的宽度
    historytimeTextField.setBounds(184, 230, 157, 33);// “开奖时间”文本框的位置以及宽高
    contentPane.add(historytimeTextField);// 将“开奖时间”文本框置于自定义背景面板中

    JLabel label_4 = new JLabel("(如：2011-05-21)");// “(如：2011-05-21)”标签
    label_4.setFont(new Font("仿宋", Font.BOLD | Font.ITALIC, 13));// 设置“(如：2011-05-21)”标签字体的样式和大小
    label_4.setBounds(361, 237, 131, 18);// “(如：2011-05-21)”标签的位置以及宽高
    contentPane.add(label_4);// 将“(如：2011-05-21)”标签置于自定义背景面板中

    erroyLabel1.setBounds(194, 128, 157, 18);// “开奖号码格式错误”标签的位置以及宽高
    contentPane.add(erroyLabel1);// 将“开奖号码格式错误”标签置于自定义背景面板中

    erroyLabel2.setBounds(194, 199, 157, 18);// 开奖时间格式错误的标签的位置以及宽高
    contentPane.add(erroyLabel2);// 将开奖时间格式错误的标签置于自定义背景面板中

    JButton btnNewButton = new JButton("");// “添加”按钮
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// 为“添加”按钮添加动作事件的监听
        }
    });
    btnNewButton.setIcon(new ImageIcon(HistoryAddframe.class.getResource("/img_btn/a04.png")));// 设置“添加”按钮的图标
    btnNewButton.setBounds(166, 290, 108, 38);// “添加”按钮的位置以及宽高
    contentPane.add(btnNewButton);// 将“添加”按钮置于自定义背景面板中

    JButton button = new JButton("");// “关闭”按钮
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// 为“关闭”按钮添加动作事件的监听
        }
    });
    button.setIcon(new ImageIcon(HistoryAddframe.class.getResource("/img_btn/a07.png")));// 设置“关闭”按钮的图标
    button.setBounds(287, 290, 108, 39);// “关闭”按钮的位置以及宽高
    contentPane.add(button);// 将“关闭”按钮置于自定义背景面板中

    numberTextField.setText(his.selectNumber() + "");// 设置“开奖期数”文本框中的内容为空

    addLabel.setFont(new Font("黑体", Font.BOLD, 18));// 添加状态的标签的字体大小和样式
    addLabel.setBounds(194, 55, 157, 33);// 添加状态的标签的位置和宽高
    contentPane.add(addLabel);// 将添加状态的标签置于自定义背景面板中
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// “添加”按钮添加动作事件的监听
    LotteryValidate validate = new LotteryValidate();// 实例化验证信息
    if (!validate.validateNumber(sevenTextField.getText())) {// “开奖号码”文本框输入的“开奖号码”的格式错误
        erroyLabel1.setText("开奖号码格式不正确");// 设置“开奖号码格式错误”标签的内容
    }
    if (validate.validateNumber(sevenTextField.getText())) {// “开奖号码”本框输入的“开奖号码”的格式正确
        erroyLabel1.setText("");// 设置“开奖号码格式错误”标签的内容为空
    }
    if (validate.validateData(historytimeTextField.getText())) {// “开奖日期”的格式正确
        erroyLabel2.setText("");// 设置“开奖日期格式错误”(提示)标签的内容为空
    } else {
        erroyLabel2.setText("开奖日期格式不正确");// 设置“开奖日期格式错误”(提示)标签的内容
    }
    if ((validate.validateNumber(sevenTextField.getText()))
            && validate.validateData(historytimeTextField.getText())) {// 开奖号码正确且开奖时间的格式也正确
        HistoryDao his = new HistoryDao();// 实例化操作开奖信息
        Boolean b;// 声明布尔型的变量b
        b = his.addHistoryDao(Integer.parseInt(numberTextField.getText()), sevenTextField.getText(),
                historytimeTextField.getText());// 数据库是否执行添加开奖号码操作
        if (b) {// 数据库执行添加开奖号码操作
            addLabel.setText("添加成功！");// 设置“添加状态”标签的内容
            ForecastDao fDao = new ForecastDao();// 实例化操作购买彩票记录信息
            try {
                fDao.awardEvaluate(Integer.parseInt(numberTextField.getText()));// 中奖情况
            } catch (NumberFormatException e1) {// 捕获数字转换异常
                e1.printStackTrace();
            } catch (SQLException e1) {// 捕获SQL异常
                e1.printStackTrace();
            }
            numberTextField.setText(his.selectNumber() + "");// 设置“开奖期数”文本框中的内容
        } else {// 数据库没有执行添加开奖号码操作
            addLabel.setText("添加失败！");// 设置“添加状态”标签的内容
        }
    }
}

protected void do_button_actionPerformed(ActionEvent e) {// “关闭”按钮添加动作事件的监听
    this.setVisible(false);// 设置当前窗体不可见
}
}

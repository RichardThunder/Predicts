package com.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dao.HistoryDao;

public class AllAddNumberframe extends JDialog {// 批量添加对话框
private JPanel jcontentPane;// 内容面板
private JTextField textField;// 文件路径的文本框
JLabel erroyLabel;// “添加数据状态”标签

public static void main(String[] args) {
    try {
        // 设置批量添加对话框的风格
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Throwable e) {
        e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                AllAddNumberframe frame = new AllAddNumberframe();// 批量添加对话框
                frame.setVisible(true);// 使批量添加对话框可见
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public AllAddNumberframe() {// 批量添加对话框的构造方法
    setModal(true);// 使批量添加对话框总在最前
    setResizable(false);// 批量添加对话框不可改变大小
    setIconImage(Toolkit.getDefaultToolkit().getImage(AllAddNumberframe.class.getResource("/imgs/log.png")));// 设置批量添加对话框的标题图标
    setTitle("批量添加开奖号码");// 设置批量添加对话框的标题
    setBounds(450, 120, 606, 609);// 设置批量添加对话框的位置以及宽高

    jcontentPane = new JPanel();// 内容面板
    jcontentPane.setLayout(new BorderLayout(0, 0));// 设置内容面板的布局为边界布局
    setContentPane(jcontentPane);// 把内容面板置于批量添加对话框中

    BackgroundPanel contentPane = new BackgroundPanel();// 创建自定义背景面板
    contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/001.png")));// 设置自定义背景面板的图片
    jcontentPane.add(contentPane, BorderLayout.CENTER);// 添加自定义背景面板到内容面板的中间

    JLabel label = new JLabel("文件路径：");// 文件路径标签
    label.setBounds(108, 140, 76, 18);// 设置文件路径标签的位置以及宽高
    contentPane.add(label);// 把文件路径标签置于自定义背景面板中

    textField = new JTextField();// 文件路径的文本框
    textField.setBounds(196, 134, 198, 30);// 设置文件路径的文本框的位置以及宽高
    contentPane.add(textField);// 把文件路径的文本框置于自定义背景面板中
    textField.setColumns(20);// 设置文件路径的文本框的宽度

    JButton button = new JButton("");// 选择文件路径按钮
    button.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/img_btn/a06.png")));// 设置选择文件路径按钮的图标
    button.setBounds(406, 136, 62, 28);// 设置选择文件路径按钮的位置以及宽高
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// 为选择文件路径按钮添加动作事件的监听
        }
    });
    contentPane.add(button);// 把选择文件路径按钮置于自定义背景面板中

    JButton btnNewButton = new JButton("");// 关闭按钮
    btnNewButton.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/img_btn/a07.png")));// 设置关闭按钮的图标
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_btnNewButton_actionPerformed(e);// 为关闭按钮添加动作事件的监听
        }
    });
    btnNewButton.setBounds(312, 412, 108, 39);// 设置关闭按钮的位置以及宽高
    contentPane.add(btnNewButton);// 把关闭按钮置于自定义背景面板中

    JButton button_1 = new JButton("");// 添加按钮
    button_1.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/img_btn/a04.png")));// 设置添加按钮的图标
    button_1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            do_button_1_actionPerformed(e);// 为添加按钮添加动作事件的监听
        }
    });
    button_1.setBounds(172, 412, 108, 38);// 设置添加按钮的位置以及宽高
    contentPane.add(button_1);// 把添加按钮置于自定义背景面板中

    erroyLabel = new JLabel("");// “添加数据状态”标签
    erroyLabel.setBounds(216, 97, 223, 18);// 设置“添加数据状态”标签的位置以及宽高
    contentPane.add(erroyLabel);// 把“添加数据状态”标签置于自定义背景面板中

    JButton btnNewButton_1 = new JButton("");// 实例图片按钮
    btnNewButton_1.setIcon(new ImageIcon(AllAddNumberframe.class.getResource("/imgs/demo.png")));// 设置实例图片按钮的图标
    btnNewButton_1.setBounds(221, 191, 247, 206);// 设置实例图片按钮的位置以及宽高
    contentPane.add(btnNewButton_1);// 把实例图片按钮置于自定义背景面板中

    JLabel lblNewLabel = new JLabel("文本写法如图所示：");// 图片实例标签
    lblNewLabel.setBounds(108, 191, 122, 18);// 设置图片实例标签的位置以及宽高
    contentPane.add(lblNewLabel);// 把图片实例标签置于自定义背景面板中
}

protected void do_button_actionPerformed(ActionEvent e) {// 选择文件路径按钮动作事件的监听
    JFileChooser chooser = new JFileChooser();// 创建文件选择器
    FileFilter filter = new FileNameExtensionFilter("文本文件(*.txt)", "txt");// 获得所有目录中包含txt文件扩展名的文件
    chooser.setFileFilter(filter);// 为文件选择对话框设置文件过滤器
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// 设置仅能选择文件
    chooser.setMultiSelectionEnabled(false);// 禁用多重选择
    int result = chooser.showOpenDialog(this);// 获得文件选择器状态
    if (result == JFileChooser.APPROVE_OPTION) {// 点击文件选择器中的“确认”后
        File file = chooser.getSelectedFile();// 获得用户选择的文件
        textField.setText(file.getAbsolutePath());// 更新文件路径的文本框内容
    }
}

protected void do_button_1_actionPerformed(ActionEvent e) {// 为添加按钮添加动作事件的监听
    String s = textField.getText();// 获得文件路径的文本框中的内容
    HistoryDao his = new HistoryDao();// 操作开奖信息
    if (his.allAddNumber(s)) {// 添加开奖号码成功
        erroyLabel.setText("添加成功");// 设置“添加数据状态”标签的内容
    } else {// 添加开奖号码失败
        erroyLabel.setText("添加失败");// 设置“添加数据状态”标签的内容
    }
}

protected void do_btnNewButton_actionPerformed(ActionEvent e) {// 为关闭按钮添加动作事件的监听
    this.setVisible(false);// 使批量添加对话框不可见
}
}

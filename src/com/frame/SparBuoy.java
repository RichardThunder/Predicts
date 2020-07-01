package com.frame;

//import com.allchart.ALineChart;
import com.allpanel.Apanel;
import javax.swing.JTabbedPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.UIManager;
public class SparBuoy extends JDialog {

    JTabbedPane tp = new JTabbedPane();// 创建选项卡面板
    public SparBuoy() {// 号码走势对话框的构造方法
    setTitle("号码走势");// 设置号码走势对话框的标题
    setResizable(false);// 不可改变号码走势对话框的大小
    // 设置号码走势对话框的窗体图标
    setIconImage(
            Toolkit.getDefaultToolkit().getImage(SparBuoy.class.getResource("/imgs/log.png"))
    );
    tp.add("第一位",new Apanel());// 把第一位开奖号码的走势面板添加到选项卡面板中
    this.getContentPane().add(tp);// 把选项卡面板添加到号码走势对话框的内容面板中
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 这是号码走势对话框的关闭方式
    this.setBounds(450, 100, 563, 593);// 设置号码走势对话框的位置和宽高
}
public static void main(String[] args) {
    try {
        // 设置号码走势对话框的样式
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Throwable e) {
        e.printStackTrace();
    }
    new SparBuoy();// 创建号码走势对话框对象
}



}

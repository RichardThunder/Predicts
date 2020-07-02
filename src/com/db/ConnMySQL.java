package com.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Forecast;
import com.model.History;

public class ConnMySQL {

private final String dbDriver = "com.mysql.jdbc.Driver";// 连接MySQL数据库的驱动
// 连接MySQL数据库的路径
private static final String URL = "jdbc:mysql://localhost:3306/db_lottery?serverTimezone=GMT%2B8";
private static final String USERNAME = "root";// 连接MySQL数据库的用户名
private static final String PASSWORD = "root";// 连接MySQL数据库的密码
private static Connection con = null;// 初始化连接MySQL数据库的对象
public ConnMySQL() {// 连接MySQL数据库的构造方法
    try {
        Class.forName(dbDriver);// 加载MySQL数据库的驱动
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("数据库加载失败");
    }
}
public static boolean creatConnection() {// 建立MySQL数据库的连接
    try {
        // 根据连接MySQL数据库的路径、用户名、密码连接MySQL数据库
        con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return true;
}
public void closeConnection() {// 关闭MySQL数据库的连接
    if (con != null) {// 判断Connection对象是否为空
        try {
            con.close();// 关闭MySQL数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con = null;// 重置Connection对象为空
        }
    }
}
public ResultSet showAll(String sql) {// 显示所有开奖信息
    Statement statement = null;// 声明用于执行SQL语句的接口
    if (con == null) {// Connection对象为空
        creatConnection();// 建立MySQL数据库的连接
    }
    try {
        statement = con.createStatement();// 创建执行SQL语句的Statement对象
        ResultSet rs = statement.executeQuery(sql);// 执行查询语句获得结果集
        return rs;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public int getABC(String abc, int number) {// 获得进度条、统计标签中的数据
    // 获得number(0~9)在历届开奖号码中第abc(a~g)位出现的总次数
    String sql = "select count(" + abc + ") from tb_history where " + abc + "=" + number;
    Statement statement = null;// 声明用于执行SQL语句的接口
    int i = 0;// 初始化“开奖期数”
    if (con == null) {// Connection对象为空
        creatConnection();// 建立MySQL数据库的连接
    }
    try {
        statement = con.createStatement();// 创建执行SQL语句的Statement对象
        ResultSet rs = statement.executeQuery(sql);// 执行查询语句获得结果集
        while (rs.next()) {// 遍历结果集
            i = rs.getInt(1);// 获得“开奖期数”
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeStatement(statement);
    }
    return i;
}
public static void closeStatement(Statement stat) {// 关闭用于执行SQL语句的Statement对象
    if (stat != null) {
        try {
            stat.close();
        } catch (SQLException e) {
            System.err.println("关闭数据库语句异常");
            e.printStackTrace();
        }
    }
}

public static List<History> getFirstTenData() {// 获得最近10期的开奖结果
    // 获得最近10期开奖号码的SQL语句
    String sql = "SELECT * FROM tb_history ORDER BY number DESC LIMIT 10";
    List<History> list = new ArrayList<>();// 存储最近10期开奖结果的集合
    Statement statement = null;// 声明用于执行SQL语句的接口
    if (con == null) {// Connection对象为空
        creatConnection();// 建立MySQL数据库的连接
    }
    try {
        statement = con.createStatement();// 创建执行SQL语句的Statement对象
        ResultSet rs = statement.executeQuery(sql);// 执行查询语句获得结果集
        while (rs.next()) {// 遍历结果集
            History history = new History();// 创建历届开奖结果对象
            history.setNumber(rs.getInt(2));// 获得开奖期数
            history.setA(rs.getInt(3));// 获得第一位开奖号码
            history.setB(rs.getInt(4));// 获得第二位开奖号码
            history.setC(rs.getInt(5));// 获得第三位开奖号码
            history.setD(rs.getInt(6));// 获得第四位开奖号码
            history.setE(rs.getInt(7));// 获得第五位开奖号码
            history.setF(rs.getInt(8));// 获得第六位开奖号码
            history.setG(rs.getInt(9));// 获得第七位开奖号码
            list.add(history);// 向集合中添加开奖结果对象
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeStatement(statement);
    }
    return list;// 返回存储最近10期开奖结果的集合
}

public int selectNumber(String sql) {// 查询期数
    Statement statement = null;// 声明用于执行SQL语句的接口
    int i = 10001;// 初始化“开奖期数”
    if (con == null) {// Connection对象为空
        creatConnection();// 建立MySQL数据库的连接
    }
    try {
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            i = rs.getInt(1);// 替换“开奖期数”
        }
    } catch (SQLException e) {
        System.out.println("历史开奖号码添加失败！");
        e.printStackTrace();
    } finally {
        closeStatement(statement);
    }
    return i;
}

public Boolean addForecast(Forecast fr) {// 添加机选号码
    if (con == null) {// Connection对象为空
        creatConnection();// 建立MySQL数据库的连接
    }
    try {
        PreparedStatement statement = con.prepareStatement(
                "insert into tb_forecast (number,a,b,c,d,e,f,g,forecasttime) "
                        + "values(?,?,?,?,?,?,?,?,?)"
        ); // 定义插入数据库的预处理语句（括号里有9个“?”）
        statement.setInt(1, fr.getNumber()); // 设置预处理语句的参数值
        statement.setInt(2, fr.getA());
        statement.setInt(3, fr.getB());
        statement.setInt(4, fr.getC());
        statement.setInt(5, fr.getD());
        statement.setInt(6, fr.getE());
        statement.setInt(7, fr.getF());
        statement.setInt(8, fr.getG());
        statement.setString(9, fr.getForecasttime());
        statement.executeUpdate(); // 执行预处理语句
        return true;
    } catch (SQLException e) {
        System.out.println("机选号码添加失败！");
        e.printStackTrace();
        return false;
    }
}



}

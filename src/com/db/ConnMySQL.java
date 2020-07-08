package com.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Forecast;
import com.model.History;

public class ConnMySQL {

private final String dbDriver = "com.mysql.jdbc.Driver";// ����MySQL���ݿ������
// ����MySQL���ݿ��·��
private static final String URL = "jdbc:mysql://localhost:3306/db_lottery?serverTimezone=GMT%2B8";
private static final String USERNAME = "root";// ����MySQL���ݿ���û���
private static final String PASSWORD = "root";// ����MySQL���ݿ������
private static Connection con = null;// ��ʼ������MySQL���ݿ�Ķ���
public ConnMySQL() {// ����MySQL���ݿ�Ĺ��췽��
    try {
        Class.forName(dbDriver);// ����MySQL���ݿ������
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("���ݿ����ʧ��");
    }
}
public static boolean creatConnection() {// ����MySQL���ݿ������
    try {
        // ��������MySQL���ݿ��·�����û�������������MySQL���ݿ�
        con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return true;
}
public void closeConnection() {// �ر�MySQL���ݿ������
    if (con != null) {// �ж�Connection�����Ƿ�Ϊ��
        try {
            con.close();// �ر�MySQL���ݿ�����
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con = null;// ����Connection����Ϊ��
        }
    }
}
public ResultSet showAll(String sql) {// ��ʾ���п�����Ϣ
    Statement statement = null;// ��������ִ��SQL���Ľӿ�
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    try {
        statement = con.createStatement();// ����ִ��SQL����Statement����
        ResultSet rs = statement.executeQuery(sql);// ִ�в�ѯ����ý����
        return rs;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public int getABC(String abc, int number) {// ��ý�������ͳ�Ʊ�ǩ�е�����
    // ���number(0~9)�����쿪�������е�abc(a~g)λ���ֵ��ܴ���
    String sql = "select count(" + abc + ") from tb_history where " + abc + "=" + number;
    Statement statement = null;// ��������ִ��SQL���Ľӿ�
    int i = 0;// ��ʼ��������������
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    try {
        statement = con.createStatement();// ����ִ��SQL����Statement����
        ResultSet rs = statement.executeQuery(sql);// ִ�в�ѯ����ý����
        while (rs.next()) {// ���������
            i = rs.getInt(1);// ��á�����������
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeStatement(statement);
    }
    return i;
}
public static void closeStatement(Statement stat) {// �ر�����ִ��SQL����Statement����
    if (stat != null) {
        try {
            stat.close();
        } catch (SQLException e) {
            System.err.println("�ر����ݿ�����쳣");
            e.printStackTrace();
        }
    }
}

public static List<History> getFirstTenData() {// ������10�ڵĿ������
    // ������10�ڿ��������SQL���
    String sql = "SELECT * FROM tb_history ORDER BY number DESC LIMIT 10";
    List<History> list = new ArrayList<>();// �洢���10�ڿ�������ļ���
    Statement statement = null;// ��������ִ��SQL���Ľӿ�
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    try {
        statement = con.createStatement();// ����ִ��SQL����Statement����
        ResultSet rs = statement.executeQuery(sql);// ִ�в�ѯ����ý����
        while (rs.next()) {// ���������
            History history = new History();// �������쿪���������
            history.setNumber(rs.getInt(2));// ��ÿ�������
            history.setA(rs.getInt(3));// ��õ�һλ��������
            history.setB(rs.getInt(4));// ��õڶ�λ��������
            history.setC(rs.getInt(5));// ��õ���λ��������
            history.setD(rs.getInt(6));// ��õ���λ��������
            history.setE(rs.getInt(7));// ��õ���λ��������
            history.setF(rs.getInt(8));// ��õ���λ��������
            history.setG(rs.getInt(9));// ��õ���λ��������
            list.add(history);// �򼯺�����ӿ����������
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeStatement(statement);
    }
    return list;// ���ش洢���10�ڿ�������ļ���
}

public int selectNumber(String sql) {// ��ѯ����
    Statement statement = null;// ��������ִ��SQL���Ľӿ�
    int i = 10001;// ��ʼ��������������
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    try {
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            i = rs.getInt(1);// �滻������������
        }
    } catch (SQLException e) {
        System.out.println("��ʷ�����������ʧ�ܣ�");
        e.printStackTrace();
    } finally {
        closeStatement(statement);
    }
    return i;
}

public Boolean addForecast(Forecast fr) {// ��ӻ�ѡ����
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    try {
        PreparedStatement statement = con.prepareStatement(
                "insert into tb_forecast (number,a,b,c,d,e,f,g,forecasttime) "
                        + "values(?,?,?,?,?,?,?,?,?)"
        ); // ����������ݿ��Ԥ������䣨��������9����?����
        statement.setInt(1, fr.getNumber()); // ����Ԥ�������Ĳ���ֵ
        statement.setInt(2, fr.getA());
        statement.setInt(3, fr.getB());
        statement.setInt(4, fr.getC());
        statement.setInt(5, fr.getD());
        statement.setInt(6, fr.getE());
        statement.setInt(7, fr.getF());
        statement.setInt(8, fr.getG());
        statement.setString(9, fr.getForecasttime());
        statement.executeUpdate(); // ִ��Ԥ�������
        return true;
    } catch (SQLException e) {
        System.out.println("��ѡ�������ʧ�ܣ�");
        e.printStackTrace();
        return false;
    }
}

// ��ʷ��¼��ӷ���
public Boolean addHistory(History his) {
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    PreparedStatement statement = null;// ����Ԥ����SQL����PreparedStatement����
    try {
        statement = con.prepareStatement(
                "insert into tb_history (number,a,b,c,d,e,f,g,historytime) values(?,?,?,?,?,?,?,?,?)"); // ����������ݿ��Ԥ�������
        statement.setInt(1, his.getNumber()); // ����Ԥ�������Ĳ���ֵ
        statement.setInt(2, his.getA());
        statement.setInt(3, his.getB());
        statement.setInt(4, his.getC());
        statement.setInt(5, his.getD());
        statement.setInt(6, his.getE());
        statement.setInt(7, his.getF());
        statement.setInt(8, his.getG());
        statement.setString(9, his.getHistorytime());
        statement.executeUpdate(); // ִ��Ԥ�������
        return true;
    } catch (SQLException e) {
        System.out.println("��ʷ�����������ʧ�ܣ�");
        e.printStackTrace();
        return false;

    } finally {
        closePreparedStatement(statement);
    }
}
// �޸Ŀ�������
public Boolean updataNumber(History his) {
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    PreparedStatement statement = null;// ����Ԥ����SQL����PreparedStatement����
    try {
        statement = con
                .prepareStatement("update tb_history set a=?,b=?,c=?,d=?,e=?,f=?,g=?,historytime=? where number=?"); // ����������ݿ��Ԥ�������
        statement.setInt(1, his.getA());// ����Ԥ�������Ĳ���ֵ
        statement.setInt(2, his.getB());
        statement.setInt(3, his.getC());
        statement.setInt(4, his.getD());
        statement.setInt(5, his.getE());
        statement.setInt(6, his.getF());
        statement.setInt(7, his.getG());
        statement.setString(8, his.getHistorytime());
        statement.setInt(9, his.getNumber());
        statement.execute(); // ִ��Ԥ�������
        return true;
    } catch (SQLException e) {
        System.out.println("���������޸�ʧ�ܣ�");
        e.printStackTrace();
        return false;
    } finally {
        closePreparedStatement(statement);
    }
}



// �Զ��޸Ļ�õĽ���
public Boolean updataMoney(int id, int money) {
    PreparedStatement statement = null;// ����Ԥ����SQL����PreparedStatement����
    if (con == null) {// Connection����Ϊ��
        creatConnection();// ����MySQL���ݿ������
    }
    try {
        statement = con.prepareStatement("update tb_forecast set neutron=? where id=?"); // ����������ݿ��Ԥ�������
        statement.setInt(1, money);// ����Ԥ�������Ĳ���ֵ
        statement.setInt(2, id);
        statement.execute(); // ִ��Ԥ�������
        return true;
    } catch (SQLException e) {
        System.out.println("�������ʧ�ܣ�");
        e.printStackTrace();
        return false;
    } finally {
        closePreparedStatement(statement);
    }
}


// �ر�Ԥ����SQL����PreparedStatement����
public static void closePreparedStatement(PreparedStatement stat) {
    if (stat != null) {
        try {
            stat.close();
        } catch (SQLException e) {
            System.err.println("�ر����ݿ�����쳣");
            e.printStackTrace();
        }
    }
}
}

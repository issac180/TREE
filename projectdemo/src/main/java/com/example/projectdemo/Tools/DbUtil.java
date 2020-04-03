package com.example.projectdemo.Tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }

    public void closeCon(Connection conn) throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

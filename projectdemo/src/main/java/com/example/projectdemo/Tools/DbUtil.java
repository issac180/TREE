package com.example.projectdemo.Tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/test?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";

    private String dbUserName = "root";
    private String dbPassword = "";

    public Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
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

package com.example.projectdemo.dao;

import com.example.projectdemo.entity.UserEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImp implements UserDao {
    public void createUser(UserEntity user) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
            //创建Connection对象，连通数据库
            String number = user.getUser_account();
            String psd = user.getUser_password();
            String name = user.getUser_name();
            String sql = "insert into message(user_account,user_name,user_password) values(?,?,?)";
            pst = con.prepareStatement(sql);
            //创建PreparedStatement对象，打开sql语句（这里是insert语句）通道
            pst.setString(1, number);
            pst.setString(2, name);
            pst.setString(3, psd);
            pst.executeUpdate();
            //具体执行相应的sql语句
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteUser(String user_account) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
            String sql = "delete from message where user_account=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user_account);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public UserEntity retrieveUser(String user_account) {
        UserEntity user = new UserEntity();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动程序
            String url = "jdbc:mysql://localhost:3306/test?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
            //创建Connection对象，打开连通数据库通道

            String sql = "select * from message where user_account=?";
            pst = con.prepareStatement(sql);
            //创建PreparedStatement对象，打开select查询通道
            pst.setString(1, user_account);//补全查询信息

            rs = pst.executeQuery();
            //创建ResultSet对象，打开结果集输出通道，执行查询，得到查询结果

            while (rs.next()) {
                user.setUser_account(rs.getString("user_account"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_password(rs.getString("user_password"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return user;
    }

    public void updateUser(UserEntity user) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);

            String number = user.getUser_account();
            String name = user.getUser_name();
            String psd = user.getUser_password();
            String sql = "update message set user_name=?,user_password=? where user_account=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, psd);
            pst.setString(3, number);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

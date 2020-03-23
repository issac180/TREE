package main.dao;

import main.entity.UserEntity;

import java.sql.*;

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
            String password = user.getUser_password();
            String name = user.getUser_name();
            String sql = "insert into message(user _number,user _name,user_password) values(?,?,?)";
            pst = con.prepareStatement(sql);
            //创建PreparedStatement对象，打开sql语句（这里是insert语句）通道
            pst.setString(1, number);
            pst.setString(2, name);
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
}

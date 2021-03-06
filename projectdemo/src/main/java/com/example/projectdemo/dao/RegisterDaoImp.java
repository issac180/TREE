package com.example.projectdemo.dao;

import com.example.projectdemo.entity.UserEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.example.projectdemo.Tools.DbUtil;

public class RegisterDaoImp implements RegisterDao {
    public void register(UserEntity user) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DbUtil.getCon();
            //创建Connection对象，连通数据库
            String sql = "insert into message(user_account,user_name,user_password) values(?,?,?)";
            pst = con.prepareStatement(sql);
            //创建PreparedStatement对象，打开sql语句（这里是insert语句）通道
            pst.setString(1, user.getUser_account());
            pst.setString(2, user.getUser_password());
            pst.setString(3, user.getUser_name());
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

package com.example.projectdemo.dao;

import com.example.projectdemo.entity.UserEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.projectdemo.Tools.DbUtil;

public class LoginDaoImp implements LoginDao {
    public UserEntity login(UserEntity user) {
        Connection con = null;
        PreparedStatement pst = null;
        UserEntity resultUser = null;
        try {
            con = DbUtil.getCon();
            //创建Connection对象，连通数据库
            String sql = "select use_password from message where user_account=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getUser_account());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                resultUser = new UserEntity();
                resultUser.setUser_account(rs.getString("user_account"));
                resultUser.setUser_password(rs.getString("user_password"));
            }
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
        return resultUser;
    }
}

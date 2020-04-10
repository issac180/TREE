//package com.example.projectdemo.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import com.example.projectdemo.entity.UserEntity;
//
//public class LoginRegisterDao {
//    public UserEntity login(Connection con, UserEntity user) throws Exception {
//        UserEntity resultUser = null;
//        String sql = "select * from message where user_account=?and user_password=?";
//        PreparedStatement pst = con.prepareStatement(sql);
//        pst.setString(1, user.getUser_account());
//        pst.setString(2, user.getUser_password());
//        ResultSet rs = pst.executeQuery();
//        if (rs.next()) {
//            resultUser = new UserEntity();
//            resultUser.setUser_account(rs.getString("user_account"));
//            resultUser.setUser_password(rs.getString("user_password"));
//        }
//        return resultUser;
//    }
//}
//
//    public boolean register(Connection con, UserEntity user) throws Exception {
//        boolean flag = false;
//        PreparedStatement pst = null;
//        String sql = "insert into message(user_account,user_name,user_password) values(?,?,?)";
//        pst = con.prepareStatement(sql);
//        pst.setString(1, user.getUser_account());
//        pst.setString(2, user.getUser_password());
//        pst.setString(3, user.getUser_name());
//        if (pst.executeUpdate() > 0) {
//            flag = true;
//        }
//        return flag;
//    }
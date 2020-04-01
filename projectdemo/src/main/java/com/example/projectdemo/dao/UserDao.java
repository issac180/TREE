package com.example.projectdemo.dao;

import com.example.projectdemo.entity.UserEntity;

public interface UserDao {
    void createUser(UserEntity user);

    void deleteUser(String user_account);

    UserEntity retrieveUser(String user_account);

    void updateUser(UserEntity user);
}

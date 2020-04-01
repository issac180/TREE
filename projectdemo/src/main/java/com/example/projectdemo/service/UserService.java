package com.example.projectdemo.service;

import com.example.projectdemo.entity.UserEntity;

public interface UserService {
    void create(UserEntity user);

    void delete(String user_account);

    UserEntity retrieve(String user_account);

    void update(UserEntity user);
}

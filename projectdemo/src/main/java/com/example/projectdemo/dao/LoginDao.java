package com.example.projectdemo.dao;

import com.example.projectdemo.entity.UserEntity;

public interface LoginDao {
    UserEntity login(UserEntity user);
}

package com.example.projectdemo.service;
import com.example.projectdemo.dao.RegisterDao;
import com.example.projectdemo.dao.RegisterDaoImp;
import com.example.projectdemo.entity.UserEntity;
public class RegisterServiceImp {
    RegisterDao registerDao = new RegisterDaoImp();

    public void register(UserEntity user) {
        registerDao.registerDao(user);
    }
}

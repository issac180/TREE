package main.service;

import main.dao.UserDao;
import main.dao.UserDaoImp;
import main.entity.UserEntity;

public class UserServiceImp implements UserService {
    UserDao userDao = new UserDaoImp();

    public void create(UserEntity user) {
        userDao.createUser(user);
    }

    public void delete(String user_account) {
        userDao.deleteUser(user_account);
    }

    public UserEntity retrieve(String user_account) {
        return userDao.retrieveUser(user_account);
    }

    public void update(UserEntity user) {
        userDao.updateUser(user);
    }
}

package main.service;

import main.entity.UserEntity;

public interface UserService {
    void create(UserEntity user);
    void delete(String user_account);
    UserEntity retrieve(String user_account);
    void update(UserEntity user);
}

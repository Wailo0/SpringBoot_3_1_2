package com.yumashev.springboot.SpringBoot_3_1_2.dao;

import com.yumashev.springboot.SpringBoot_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);
}

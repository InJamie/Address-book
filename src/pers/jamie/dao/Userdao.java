package pers.jamie.dao;

import pers.jamie.domain.User;

import java.util.List;

/**
 * 数据库操作DAO
 */
public interface Userdao {
    User cheklogin(String name , String password);

    List<User> userList();

    void deletuser(String id);

    void adduser(User user);

    void updateuser(User user);

    User finduser(String id);
}

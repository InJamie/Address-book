package pers.jamie.service;

import pers.jamie.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface Userservice {
    /**
     * 用户登录检测方法
     * @param user
     * @return
     */
    User login(User user);

    List<User> userList();

    void deleteuser(String id);

    void adduser(User user);

    void updateuser(User user);

    User finduser(String id);
}

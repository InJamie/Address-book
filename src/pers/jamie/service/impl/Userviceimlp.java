package pers.jamie.service.impl;

import pers.jamie.dao.impl.Userdaoimpl;
import pers.jamie.dao.Userdao;
import pers.jamie.domain.User;
import pers.jamie.service.Userservice;

import java.util.List;

public class Userviceimlp implements Userservice {
    private Userdao dao = new Userdaoimpl();
    @Override
    public User login(User user) {
        return dao.cheklogin(user.getUsername(), user.getPassword());
    }

    @Override
    public List<User> userList() {
        List<User> users = dao.userList();
        return users;
    }

    @Override
    public void deleteuser(String id) {
        dao.deletuser(id);
    }

    @Override
    public void adduser(User user) {
        dao.adduser(user);
    }

    @Override
    public void updateuser(User user) {
        dao.updateuser(user);
    }

    @Override
    public User finduser(String id) {
        return dao.finduser(id);
    }


}

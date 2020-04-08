package pers.jamie.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.jamie.Utils.JDBCutil;
import pers.jamie.dao.Userdao;
import pers.jamie.domain.User;

import java.util.List;

/**
 *操作数据库
 */
public class Userdaoimpl implements Userdao {
    private JdbcTemplate template = new JdbcTemplate(JDBCutil.getDataSource());
    /**
     * 验证登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public User cheklogin(String name, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<User> userList(){
        String sql = "select * from user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public void deletuser(String id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);

    }

    @Override
    public void adduser(User user) {
        //1.定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void updateuser(User user) {
        String sql ="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id =?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public User finduser(String id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }
}

package com.my.xxb.service.impl;

import com.my.xxb.dao.UserDao;
import com.my.xxb.pojo.Role;
import com.my.xxb.pojo.User;
import com.my.xxb.service.userService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(String username,String password) {
        User user = userDao.getUser(username, password);
        System.out.println(user);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user1 = userDao.getUserByUsername(username);
        return user1;
    }

    @Override
    public User getAdminByUsername(String username) {
        User adminByUsername = userDao.getAdminByUsername(username);
        return adminByUsername;
    }

    @Override
    public int addUser(String username, String password) {
        Md5Hash ps = new Md5Hash(password,"",1024);
        int i = userDao.addUser(username, ps.toHex());
        return i;

    }

    @Override
    public int addRole(Integer userid) {
        int i = userDao.addRole(userid);
        return i;
    }

    @Override
    public List<Role> getRoleByuserName(String name) {
        try {
            List<Role> roleByuserName = userDao.getRoleByuserName(name);

            return roleByuserName;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
            return null;
        }

    }

    @Override
    public User getUserBy(String username) {
        User userBy = userDao.getUserBy(username);
        return userBy;
    }


}

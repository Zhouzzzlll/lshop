package com.my.xxb.service;

import com.my.xxb.pojo.Role;
import com.my.xxb.pojo.User;

import java.util.List;

public interface userService {
    User getUser(String username, String password);

    User getUserByUsername(String username);

    User getAdminByUsername(String username);

    int addUser(String username,String password);

    int addRole(Integer userid);

    List<Role> getRoleByuserName(String name);

    User getUserBy(String username);


}

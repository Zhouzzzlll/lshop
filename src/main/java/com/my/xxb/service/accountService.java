package com.my.xxb.service;

import com.my.xxb.pojo.User;
import com.my.xxb.pojo.Userinfo;
import com.my.xxb.pojo.account;

import java.util.List;

public interface accountService {
    List<User> getAll();

    List<Userinfo> getAllByPhone(String phone);

    account getByid(int id);

    int addUser(account ac);

    int deleteUser(int id);

    List<Userinfo> LimitGetUser(int curpage, int pagesize);

    int count();

    int updateUser(String ph,int id);
}

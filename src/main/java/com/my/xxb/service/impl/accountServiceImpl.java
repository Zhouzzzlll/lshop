package com.my.xxb.service.impl;

import com.my.xxb.dao.accountDao;
import com.my.xxb.pojo.User;
import com.my.xxb.pojo.Userinfo;
import com.my.xxb.pojo.account;
import com.my.xxb.service.accountService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class accountServiceImpl implements accountService {

    @Autowired
    private  accountDao accountDao1;


    @Override
    public List<User> getAll() {
        List<User> usrs = accountDao1.getAll();
        return usrs;
    }

    @Override
    public List<Userinfo> getAllByPhone(String phone) {
        List<Userinfo> userinfos = accountDao1.getAllByPhone(phone);
        return userinfos;
    }

    @Override
    public account getByid(int id) {
        account ac = accountDao1.getByid(id);
        return ac;
    }

    @Override
    public int addUser(account ac) {
        System.out.println(ac.getAccount_phone());
        int flag = accountDao1.addUser(ac.getAccount_name(), ac.getAccount_sex(), ac.getAccount_phone());
        return flag;
    }

    @Override
    public int deleteUser(int id) {
        int i = accountDao1.deleteUser(id);
        return i;
    }

    @Override
    public List<Userinfo> LimitGetUser(int curpage, int pagesize) {
        return accountDao1.limitGetUser(curpage,pagesize);
    }

    @Override
    public int count() {
        int count1 = accountDao1.count();
        return count1;
    }

    @Override
    public int updateUser(String ph, int id) {
        int i = accountDao1.updateUser(ph,id);
        return i;
    }
}

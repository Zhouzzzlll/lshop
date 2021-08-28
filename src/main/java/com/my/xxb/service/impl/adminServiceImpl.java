package com.my.xxb.service.impl;

import com.my.xxb.dao.adminDao;
import com.my.xxb.pojo.Order;
import com.my.xxb.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/26 19:59
 **/

@Service
public class adminServiceImpl implements adminService {

    @Autowired
    private adminDao adminDao;

    @Override
    public List<Order> LimitGetall(int curpage, int pagesize) {
        List<Order> orders = adminDao.LimitGetall(curpage, pagesize);
        return orders;
    }

    @Override
    public int count() {
        int count = adminDao.count();
        return count;
    }

    @Override
    public int updateOrder(Integer id) {
        int i = adminDao.updateOrder(id);
        return i;
    }

    @Override
    public List<Order> mhuser(String us) {
        List<Order> mhusername = adminDao.mhusername(us);
        return mhusername;
    }

    @Override
    public String findcollect(Integer userid) {
        String findcollect = adminDao.findcollect(userid);
        return findcollect;
    }

    @Override
    public int addmoney(String collect,Integer userid) {
        int addmoney = adminDao.addmoney(collect, userid);
        return addmoney;
    }
}

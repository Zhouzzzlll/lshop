package com.my.xxb.service;

import com.my.xxb.pojo.Order;

import java.util.List;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/26 19:57
 **/

public interface adminService {
    List<Order> LimitGetall(int curpage, int pagesize);

    int count();

    int updateOrder(Integer id);

    List<Order> mhuser(String us);

    String findcollect(Integer userid);

    int addmoney(String collect,Integer userid);

}

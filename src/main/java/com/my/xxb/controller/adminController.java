package com.my.xxb.controller;

import com.my.xxb.pojo.Order;
import com.my.xxb.pojo.Userinfo;
import com.my.xxb.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/26 20:01
 **/

@CrossOrigin
@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService adminService;

    @ResponseBody
    @GetMapping("/limitorder")
    public List<Order> LimitGetall(@RequestParam("curpage")int curpage, @RequestParam("pagesize") int pagesize){
        List<Order> limitOrder = adminService.LimitGetall((curpage-1)*pagesize,pagesize);
        System.out.println(limitOrder.toString());
        return limitOrder;
    }

    @ResponseBody
    @GetMapping("/count")
    public int count(){
        int count = adminService.count();
        return count;
    }

    @ResponseBody
    @GetMapping("/updateOrder/{orderid}")
    public int updateOrder(@PathVariable("orderid")Integer orderid){
        int i = adminService.updateOrder(orderid);
        return i;
    }

    @ResponseBody
    @GetMapping("/mhusername/{username}")
    public List<Order> mhuser(@PathVariable("username") String username){
        List<Order> mhuser = adminService.mhuser(username);
        return mhuser;
    }

    @ResponseBody
    @GetMapping("/findcollect/{findcollect}")
    public String findcollect(@PathVariable("findcollect") Integer useid){
        String findcollect = adminService.findcollect(useid);
        return findcollect;
    }

    @ResponseBody
    @PostMapping("/addmoney")
    public int addmoney(@RequestBody Userinfo userinfo){
        int addmoney = adminService.addmoney(userinfo.getCollect(), userinfo.getUserid());
        return addmoney;
    }
}

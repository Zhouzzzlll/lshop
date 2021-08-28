package com.my.xxb.controller;

import com.my.xxb.pojo.User;
import com.my.xxb.pojo.Userinfo;
import com.my.xxb.pojo.account;
import com.my.xxb.service.accountService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/account")
public class accountController {

    @Autowired
    private accountService accountService1;

    @ResponseBody
    @PostMapping("/all")
    public List<User> getAll() {
        List<User> all = accountService1.getAll();
        return all;
    }
    @ResponseBody
    @GetMapping("/limitUser")
    public List<Userinfo> limitAll(@RequestParam("curpage")int curpage, @RequestParam("pagesize") int pagesize){
        List<Userinfo> limitAccount = accountService1.LimitGetUser((curpage-1)*pagesize,pagesize);
        return limitAccount;
    }

    @ResponseBody
    @PostMapping("/byPhone")
    public List<Userinfo> getAllById(@RequestBody Userinfo userinfo){
        List<Userinfo> userinfos = accountService1.getAllByPhone(userinfo.getPhone());
        return userinfos;
    }
    @ResponseBody
    @GetMapping("/byId/{id}")
    public account getByid(@PathVariable("id") int id){
        account ac = accountService1.getByid(id);
        return ac;
    }

    @ResponseBody
    @PostMapping("/addUser")
    public int addUser(@RequestBody account account1){
        System.out.println(account1);
        int flag = accountService1.addUser(account1);
        return flag;
    }

    @ResponseBody
    @PostMapping("/deleteUser")
    public int deleteUser(@RequestBody account account_id){
        int flag = accountService1.deleteUser(account_id.getAccount_id());
        if(flag!=1) {
            System.out.println("删除失败");
            return 0;
        }
        else {
            return flag;
        }
    }
    @ResponseBody
    @RequiresRoles("admin")
    @GetMapping("/count")
    public int count(){
        int count = accountService1.count();
        return count;
    }

    @ResponseBody
    @GetMapping("/update/{ph}/{id}")
    public int updatePh(@PathVariable("ph") String ph,@PathVariable("id") int id){
        int i = accountService1.updateUser(ph,id);
        return i;
    }
}

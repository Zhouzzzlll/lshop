package com.my.xxb.controller;

import com.my.xxb.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/verify")
public class unauthORunthorization {

    @RequestMapping("/unverified")
    public Result unverified(){

        return new Result(400,"您还未登录，请先登录");
    }


    @RequestMapping("/unauthorized")
    public Result unauthorize(){
        return new Result(400,"您还没有访问此资源的权限");
    }
}

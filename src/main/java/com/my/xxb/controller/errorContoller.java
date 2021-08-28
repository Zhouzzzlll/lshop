package com.my.xxb.controller;

import com.my.xxb.utils.Result;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class errorContoller {

    @ExceptionHandler(value = ShiroException.class)
    public Result handler(){
        return new Result(400,"您没有权限访问");
    }

    // 捕捉其他所有异常
//    @ExceptionHandler(value = Exception.class)
//    public Result globalException(Exception ex) {
//        System.out.println("全局异常的捕获");
//        return new Result(400,ex.getMessage());
//
//    }

}

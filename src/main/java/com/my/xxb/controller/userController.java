package com.my.xxb.controller;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.my.xxb.pojo.Role;
import com.my.xxb.pojo.User;
import com.my.xxb.utils.Result;
import com.my.xxb.service.userService;
import com.my.xxb.JWT.utils.jwtUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/User")
public class userController {

    @Autowired
    private userService userService;
    @PostMapping("/selectUserByname")
    public Result getUser1(@RequestBody User user){
        new Md5Hash(user.getPassword(),"",1024).toHex();
        User ub = userService.getUserByUsername(user.getUsername());
        if(ub!=null){
            return new Result(200,"用户已经存在");
        }
        return new Result(400,"用户不存在,可以注册");
    }
    @PostMapping("/selectUser")
    public Result getUser(@RequestBody User user){
        String password = new Md5Hash(user.getPassword(),"",1024).toHex();
        try {
            String ps = userService.getUserByUsername(user.getUsername()).getPassword();

            if(ps==null || !ps.equals(password)){
                return new Result(400,"用户名或者密码错误，请重试！");
            }
            else {
                String token = jwtUtils.JWTtoken(user.getUsername());
                return   new Result(200,"登陆成功",token,user);
            }

        } catch (Exception e) {
            return new Result(400,"未知的异常，请联系管理员！");
        }

/*        Subject subject = SecurityUtils.getSubject();
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),"",1024);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),md5Hash.toHex());

        String jwtToken = jwtUtils.JWTtoken(user.getUsername());
        user.setToken(jwtToken);
        try {
            subject.login(token);
            return new Result(200,"验证成功",jwtToken,user);
        }catch (UnknownAccountException e){
            return new Result(400,"用户名或者密码错误");
        }catch (IncorrectCredentialsException e){
            return  new Result(400,"用户名或者密码错误");
        }*/


    }
    @PostMapping("/selectAdmin")
    public Result getAdmin(@RequestBody User user){
        String password = new Md5Hash(user.getPassword(),"",1024).toHex();
        try {
            String ps = userService.getAdminByUsername(user.getUsername()).getPassword();

            if(ps==null || !ps.equals(password)){
                return new Result(400,"用户名或者密码错误，请重试！");
            }
            else {
                String token = jwtUtils.JWTtoken(user.getUsername());
                return   new Result(200,"登陆成功",token,user);
            }

        } catch (Exception e) {
            return new Result(400,"未知的异常，请联系管理员！");
        }

/*        Subject subject = SecurityUtils.getSubject();
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),"",1024);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),md5Hash.toHex());

        String jwtToken = jwtUtils.JWTtoken(user.getUsername());
        user.setToken(jwtToken);
        try {
            subject.login(token);
            return new Result(200,"验证成功",jwtToken,user);
        }catch (UnknownAccountException e){
            return new Result(400,"用户名或者密码错误");
        }catch (IncorrectCredentialsException e){
            return  new Result(400,"用户名或者密码错误");
        }*/


    }
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){

        try {
            int  i = userService.addUser(user.getUsername(),user.getPassword());
            User us = userService.getUserBy(user.getUsername());
            int j = userService.addRole(us.getUserid());
            if(i>0&&j>0){
                return new Result(200,"插入成功");
            }
            else {
                return new Result(400,"插入失败");
            }
        } catch (Exception e) {
            return new Result(400,"用户已经存在");

        }
        
    }

    @PostMapping("/Token")
    public Result verifyTokend(@RequestBody User token){

     try {
            jwtUtils.verifyToken(token.getToken());
            //System.out.println(jwtUtils.verifyToken(token));
            return  new Result(200,"用户还未失效，可以继续使用");
        } catch (TokenExpiredException e) {

            return new Result(400,"用户登录已经失效，请重新登录");
        }

    }

    @GetMapping("/test/{name}")
    public List<Role> roles(@PathVariable("name") String name){

        List<Role> roleByuserName = userService.getRoleByuserName(name);
        return roleByuserName;

    }

}

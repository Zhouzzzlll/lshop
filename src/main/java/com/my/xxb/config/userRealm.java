package com.my.xxb.config;

import com.my.xxb.JWT.shiro.jwtToken;
import com.my.xxb.JWT.utils.jwtUtils;
import com.my.xxb.pojo.User;
import com.my.xxb.service.userService;
import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class userRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof jwtToken;
    }


    @Autowired
    private userService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("shouquande");
        String username = jwtUtils.getUsernameBytoken(principalCollection.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("admin");
       /* User principal = (User) principalCollection.getPrimaryPrincipal();
       if ("root".equals(principal.getUsername())) {
           SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
           simpleAuthorizationInfo.addRole("admin");
           return simpleAuthorizationInfo;
        }*/
        return simpleAuthorizationInfo;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String usernameBytoken = jwtUtils.getUsernameBytoken(token);
        if(usernameBytoken==null || !jwtUtils.verify(token,usernameBytoken)){
            System.out.println("验证token");
            throw new AuthenticationException("token验证失败");
        }
        User username = userService.getUserByUsername(usernameBytoken);
        if(username.getUsername()==null){
            throw  new AuthenticationException("用户不存在");
        }
        return new SimpleAuthenticationInfo(token,token,"myRealm");
      /* String principal =(String)authenticationToken.getPrincipal();
        System.out.println(principal);
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("===="+token);
        User username = userService.getUserByUsername(token.getUsername());
        if(username==null){
            return  null;
        }
        return new SimpleAuthenticationInfo(token,username.getPassword(),"");
        //return null;*/
    }
}

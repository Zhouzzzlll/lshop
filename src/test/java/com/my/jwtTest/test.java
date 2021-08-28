package com.my.jwtTest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;

public class test {

    @Test
    void testJWT(){
        HashMap<String, Object> map = new HashMap<>();
        Calendar time = Calendar.getInstance();
        time.add(Calendar.SECOND,1000000);

        String token = JWT.create()
                .withHeader(map)
                .withClaim("id", 10)
                .withClaim("username", "zhangsan")
                .withExpiresAt(time.getTime())
                .sign(Algorithm.HMAC256("@yyyasdz$$#"));
        System.out.println(token);
    }

    //创建验证对象
    @Test
    public void test2(){
        JWTVerifier verification = JWT.require(Algorithm.HMAC256("@yyyasdz$$#")).build();
        DecodedJWT verify = verification.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAsImV4cCI6MTYwMTI2NzYyNywidXNlcm5hbWUiOiJ6aGFuZ3NhbiJ9.Qf1jivif-xoZruEGWHGD1VfsmO1kC2brKSdeDYJ0orI");
        System.out.println(verify);
        System.out.println(verify.getClaim("username").asString());
    }
}

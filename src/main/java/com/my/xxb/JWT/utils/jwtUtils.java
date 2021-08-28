package com.my.xxb.JWT.utils;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;

public class jwtUtils {
    private static  final  String SALT="!@YAISD!LOVE!";


    public static   String JWTtoken(String username){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,3);
       /* JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });*/
         String token = JWT.create()
                .withExpiresAt(instance.getTime())
                .withClaim("username", username)
                .sign(Algorithm.HMAC256(SALT));
        return token;
    }


    public static boolean  verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SALT);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("验证token失败");
            return false;
        }
    }

    public static String  getUsernameBytoken(String token){
        try {
            DecodedJWT decode = JWT.decode(token);
            return decode.getClaim("username").asString();
        } catch (Exception e) {
            e.printStackTrace();
            return "此token错误，或者已经失效！";
        }
    }
    public static DecodedJWT verifyToken(String token){
       return  JWT.require(Algorithm.HMAC256(SALT)).build().verify(token);
    }
}

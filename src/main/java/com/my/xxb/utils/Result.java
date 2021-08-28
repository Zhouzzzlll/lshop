package com.my.xxb.utils;

import com.my.xxb.pojo.User;
import lombok.Data;

@Data

public class Result {
    private int code;
    private String msg;
    private String token;
    private User user;

    public Result(int code,String msg, String token, User user) {
        this.code = code;
        this.user = user;
        this.token= token;
        this.msg= msg;
    }

    public Result(int code,String msg) {
        this.code = code;
        this.msg=msg;
    }

    public Result(int code, String msg, String token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
    }

    public Result() {
    }
}

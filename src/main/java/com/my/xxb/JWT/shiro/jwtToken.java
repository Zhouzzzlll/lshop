package com.my.xxb.JWT.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class jwtToken implements AuthenticationToken {
    private String token;

    public jwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

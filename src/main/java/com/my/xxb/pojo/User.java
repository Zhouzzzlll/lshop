package com.my.xxb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  int userid;
    private String username;
    private String password;
    private String token;
    private String rolename;
}

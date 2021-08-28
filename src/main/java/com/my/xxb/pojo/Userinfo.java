package com.my.xxb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/17 13:53
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userinfo {
    private Integer userid;
    private String username;
    private String sex;
    private String addr;
    private String phone;
    private String collect;
}

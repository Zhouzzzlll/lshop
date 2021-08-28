package com.my.xxb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/12 18:59
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderid;
    private String productbrand;
    private String username;
    private String state;
    private String productprice;
    private String num;
}

package com.my.xxb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/6 15:53
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopcart {
    private int id;
    private String username;
    private int productnum;
    private String productprice;
    private String productimg;
    private String productbrand;

}

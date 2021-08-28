package com.my.xxb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/4/29 22:49
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productid;
    private String productname;
    private String productprice;
    private String productimg;
    private String productdesc;
    private String productbrand;
    private String productremarks;
    private String productlevel;
}

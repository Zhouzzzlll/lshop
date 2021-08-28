package com.my.MD5test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5  {
    public static void main(String[] args) {
        //使用md5加密
        Md5Hash hash = new Md5Hash("111111");
        //   hash.setBytes("admin".getBytes());
        System.out.println(hash.toHex());
        Md5Hash md5= new Md5Hash("111111", "", 1024);
        System.out.println(md5.toHex());
        //md5+盐值
        Md5Hash hash1 = new Md5Hash("123456","xiaw");
        //   hash.setBytes("admin".getBytes());
        System.out.println(hash1.toHex());


        //md5+盐值+hash散列
        Md5Hash hash2 = new Md5Hash("123456","xiaw",1024);
        //   hash.setBytes("admin".getBytes());
        System.out.println(hash2.toHex());
    }
}

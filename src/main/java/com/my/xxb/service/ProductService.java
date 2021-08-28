package com.my.xxb.service;

import com.my.xxb.pojo.Order;
import com.my.xxb.pojo.Product;
import com.my.xxb.pojo.Shopcart;
import com.my.xxb.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mockito.internal.matchers.Or;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/4/30 14:07
 **/
public interface ProductService {
    List<Product> getAllselected();

    List<Product> getAll();

    List<Product> getBybrand(String pb);

    int savecart(Shopcart shopcart);

    List<Shopcart> getAllcart(String username);

    int deleteProduct(String productbrand);

    int updateProduct(int pn,String pb);

    int insertOrder(Order order);

    int deletefromshop(Order order);

    Map<String,String> pay(String username);

    Map<String,String> payone(String username,String productbrand);

    Shopcart repeat(String us,String pb);

    int userinfo(Userinfo userinfo);

    Userinfo infoAll(String username);

    int updateInfo(Userinfo us);

    int updatestate(String username);

    int updatecollect(String c,String u);

    Order findOrder();

    List<Product> limitGetProduct(int curpage,int pagesize);

    int count();

    List<Product> getAllByName(String name);

    Product getOneByName(String productbrand);

    int deleteByid(Integer id);

    int updatepb(String productprice,String productremarks,String productlevel,Integer productid);

    int addproduct(Product p);
}

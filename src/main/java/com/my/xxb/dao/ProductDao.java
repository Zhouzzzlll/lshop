package com.my.xxb.dao;

import com.my.xxb.pojo.Order;
import com.my.xxb.pojo.Product;
import com.my.xxb.pojo.Shopcart;
import com.my.xxb.pojo.Userinfo;
import org.apache.ibatis.annotations.*;
import org.mockito.internal.matchers.Or;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/4/30 14:04
 **/
@Repository
@Mapper
public interface ProductDao {
    @Select("select * from productdetail where productlevel = 1")
    List<Product> getAllselected();

    @Select("select * from productdetail")
    List<Product> getAll();

    @Select("select * from productdetail where productbrand like concat('%',#{productbrand},'%') ")
    List<Product> getBybrand(String productbrand);

    @Insert("insert into Shopcart(username,productnum,productprice,productimg,productbrand) values(#{username},#{productnum},#{productprice},#{productimg},#{productbrand})")
    int savecart(String username, int productnum, String productprice, String productimg, String productbrand);

    @Select("select * from Shopcart where username=#{username}")
    List<Shopcart> getAllcart(String username);

    @Delete("delete from Shopcart where productbrand=#{productbrand}")
    int deleteProduct(String productbrand);

    @Update("update Shopcart set productnum = #{productnum} where productbrand=#{productbrand}")
    int updateProduct(int productnum,String productbrand);

    @Insert(" insert into `order`(productbrand,username,state,productprice,num) values (#{productbrand},#{username},#{state},#{productprice},#{num})")
    int insertOrder(String productbrand,String username,String state,String productprice,String num);

    @Delete("delete from Shopcart where username = #{username} and productbrand = #{productbrand}")
    int deletefromshop(String username,String productbrand);

    @Select("SELECT sum(num) as count,sum(productprice) as money FROM `order` where username = #{username}")
    Map<String,String> pay(String username);

    @Select("SELECT num as count,productprice as money FROM `order` where username = #{username} and productbrand = #{productbrand} and state = '1'")
    Map<String,String> payone(String username,String productbrand);

    @Select("select * from Shopcart where username = #{username} and productbrand = #{productbrand}")
    Shopcart repeat(String username,String productbrand);

    @Insert("insert into userinfo(username,sex,addr,phone,collect) values(#{username},#{sex},#{addr},#{phone},'1000')")
    int userinfo(String username,String sex,String addr,String phone);

    @Select("select * from userinfo where username = #{username}")
    Userinfo infoAll(String username);

    @Update("update userinfo set sex = #{sex},addr = #{addr},phone = #{phone} where username = #{username}")
    int updateInfo(String sex,String addr,String phone,String username);

    @Update("update `order` set state = '2' where username = #{username}")
    int updatestate(String username);

//    @Update("update productdetail set productremarks = #{collect} where username = #{username}")
//    int updatecollect(String collect,String username);

    @Update("update userinfo set collect = #{collect} where username = #{username}")
    int updatecollect(String collect,String username);

    @Select("select * from `order` where state = '1'  limit 0,1")
    Order findOrder();

    List<Product> limitGetProduct(@Param("curpage") int curpage, @Param("pagesize") int pagesize);

    @Select("select count(*) from productdetail")
    int count();

    @Select("select * from productdetail where productbrand like concat('%',#{procdutbrand},'%')")
    List<Product> getAllByName(String productbrand);

    @Select("select * from productdetail where productid = #{productid}")
    Product getOneByName(String productid);

    @Delete("delete from productdetail where productid = #{productid}")
    int deleteByid(Integer productid);

    @Update("update productdetail set productprice = #{productprice},productremarks = #{productremarks},productlevel = #{productlevel} where productid = #{productid}")
    int updatepb(String productprice,String productremarks,String productlevel,Integer productid);

    @Insert("insert into productdetail(productname,productprice,productimg,productdesc,productbrand," +
            "productremarks,productlevel) values(#{productname},#{productprice},#{productimg},#{productdesc}," +
            "#{productbrand},#{productremarks},#{productlevel})")
    int addproduct(String productname,String productprice,String productimg,String productdesc,
                   String productbrand,String productremarks,String productlevel);
}

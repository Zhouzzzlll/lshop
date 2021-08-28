package com.my.xxb.dao;

import com.my.xxb.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/5/26 19:46
 **/
@Repository
@Mapper
public interface adminDao {

    List<Order> LimitGetall(@Param("curpage") int curpage, @Param("pagesize") int pagesize);

    @Select("select count(*) from `order`")
    int count();

    @Update("update `order` set state = '3' where orderid = #{orderid}")
    int updateOrder(Integer orderid);

    @Select("select * from `order` where username like concat('%',#{username},'%')")
    List<Order> mhusername(String username);

    @Select("select collect from userinfo where userid = #{userid}")
    String findcollect(Integer userid);

    @Update("update userinfo set collect = #{collect} where userid = #{userid}")
    int addmoney(String collect,Integer userid);
}

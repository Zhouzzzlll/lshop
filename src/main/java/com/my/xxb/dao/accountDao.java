package com.my.xxb.dao;

import com.my.xxb.pojo.User;
import com.my.xxb.pojo.Userinfo;
import com.my.xxb.pojo.account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface accountDao {

    @Select("select * from user")
    List<User> getAll();
    @Select("select * from account where account_id=#{id}")
    account getByid(int id);

    @Select("select * from userinfo where phone like concat('%',#{phone},'%')")
    List<Userinfo> getAllByPhone(String phone);

//    @Select("select * from account where account_id limit #{curpage},#{pagesize}")
    List<Userinfo> limitGetUser(@Param("curpage") int curpage, @Param("pagesize") int pagesize);

    @Select("select count(*) from userinfo")
    int count();
    @Update("update account set account_phone=#{ph} where account_id=#{id}")
    int updateUser(String ph,int id);
    @Insert("insert into account(account_name,account_sex,account_phone) values(#{name},#{sex},#{phone})")
    int addUser(String name,String sex,String phone);
    @Delete("delete from account where account_id=#{id}")
    int deleteUser(int id);
}

package com.my.xxb.dao;

import com.my.xxb.pojo.Role;
import com.my.xxb.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
     @Select("select * from user where username=#{username} and password=#{password}")
    User getUser(String username,String password);

    @Select("SELECT username,`password`,rolename FROM (`user` as u left join user_role as ur on u.userid = ur.userid) " +
            "left join role as r  on role = roleid WHERE rolename = 'member' and username = #{username}")
//    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    @Select("SELECT * from user where username = #{username}")
    User getUserBy(String username);

    @Select("SELECT username,`password`,rolename FROM (`user` as u left join user_role as ur on u.userid = ur.userid) " +
            "left join role as r  on role = roleid WHERE rolename = 'admin' and username = #{username}")
//    @Select("select * from user where username=#{username}")
    User getAdminByUsername(String username);
    @Insert("insert into user(username,password) values(#{username},#{password})")
    int addUser(String username,String password);

    @Insert("insert into user_role(userid,role) values(#{userid},2)")
    int addRole(Integer userid);

    List<Role> getRoleByuserName(String name);
    int update(User user);

    int deleteById(int user_id);
}

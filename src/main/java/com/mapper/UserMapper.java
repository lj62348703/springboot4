package com.mapper;

import com.entity.Userinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from userinfo")
    List<Userinfo> findAll();


    List<Userinfo> findUserLikeName(String user_name);

    @Select("select * from userinfo where user_name = #{0}")
    Userinfo login(String user_name);

    // #{} preparedStatement预处理 ${}  Statement字符串拼接 有安全隐藏（sql注入攻击）
    @Delete("delete from userinfo where user_id = #{0}")
    int deleteUser(Integer user_id);

    @Select("select * from userinfo where user_id = #{0}")
    Userinfo findById(Integer user_id);

    @Update("update userinfo set user_name=#{user_name},user_nick=#{user_nick},user_pwd=#{user_pwd} where user_id=#{user_id} ")
    int update(Userinfo userinfo);

    @Update("insert into userinfo(user_name,user_nick,user_pwd) values(#{user_name},#{user_nick},#{user_pwd})")
    int add(Userinfo userinfo);


}

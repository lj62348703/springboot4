package com.mapper;

import com.entity.Userinfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from userinfo")
    List<Userinfo> findAll();


    List<Userinfo> findUserLikeName(String user_name);
}

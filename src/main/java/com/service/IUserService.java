package com.service;

import com.entity.Userinfo;
import com.github.pagehelper.PageInfo;

public interface IUserService {
    PageInfo<Userinfo> findAll(Integer pageNum, Integer pageSize);

    Userinfo login(String user_name);

    int deleteUser(Integer user_id);

    Userinfo findById(Integer user_id);

    int update(Userinfo userinfo);

    int add(Userinfo userinfo);
}

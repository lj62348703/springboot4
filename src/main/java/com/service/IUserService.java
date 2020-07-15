package com.service;

import com.entity.Userinfo;
import com.github.pagehelper.PageInfo;

public interface IUserService {
    PageInfo<Userinfo> findAll(Integer pageNum, Integer pageSize);
}

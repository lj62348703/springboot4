package com.service.impl;

import com.entity.Userinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<Userinfo> findAll(Integer pageNum, Integer pageSize) {
        //对数据进行非空验证
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        //对分页插件进行初始化设置
        PageHelper.startPage(pageNum,pageSize);
        //因为使用分页插件，会根据分页插件的设置执行一下两行代码
        // select count(*) from userinfo
        // select * from userinfo limit pageNum , pageSize
        List<Userinfo> list = userMapper.findAll();

        //将查询的数据放到分页信息里面
        PageInfo<Userinfo> page = new PageInfo<Userinfo>(list);
        return page;
    }

    public Userinfo login(String user_name){
        return userMapper.login(user_name);
    }


    public int deleteUser(Integer user_id){
        return user_id == null ? 0 : userMapper.deleteUser(user_id);
    }

    public Userinfo findById(Integer user_id){
        return user_id == null ? null : userMapper.findById(user_id);
    }

    public int update(Userinfo userinfo){
        return userMapper.update(userinfo);
    }

    @Transactional
    public int add(Userinfo userinfo){
        if(userMapper.login(userinfo.getUser_name()) != null) return -2;
        return userMapper.add(userinfo);
    }
}

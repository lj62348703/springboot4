package com.test;

import com.App;
import com.entity.Userinfo;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= App.class)
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userServiceImpl;

    @Test
    public void findAll(){
        System.out.println(userMapper.findAll());
    }

    @Test
    public void findByUserNameLike(){
        System.out.println(userMapper.findUserLikeName("%明%"));
    }


    @Test
    public void findAllPage(){
        PageInfo<Userinfo> page = userServiceImpl.findAll(1,10);

        System.out.println("总行数 ： "+page.getTotal());
        System.out.println("总页数 ： "+page.getPages());
        System.out.println("每页显示的个数 ： "+page.getPageSize());
        System.out.println("当前是第几页 ： "+page.getPageNum());
        System.out.println("当前页的数据 ： "+page.getList());
    }

}


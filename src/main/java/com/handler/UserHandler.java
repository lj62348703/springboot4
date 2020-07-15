package com.handler;

import com.entity.LoginValidate;
import com.entity.Userinfo;
import com.github.pagehelper.PageInfo;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHandler {
    @Autowired
    private IUserService userServiceImpl;

    //http://localhost/findAllPage.action?pageNum=1&pageSize=10
    //http://localhost/user/1/10
    //http://localhost/user1-10
    @GetMapping("/findAllPage.action")
    public String findAllPage(Model model,Integer pageNum, Integer pageSize){
        PageInfo<Userinfo> page = userServiceImpl.findAll(pageNum,pageSize);
        model.addAttribute("page",page);
        return "show";
    }

    //http://localhost/user/1/10
    @GetMapping("/user/{pageNum}/{pageSize}")
    public String user(Model model, @PathVariable Integer pageNum,@PathVariable Integer pageSize){
        PageInfo<Userinfo> page = userServiceImpl.findAll(pageNum,pageSize);
        model.addAttribute("page",page);
        return "show";
    }

    //http://localhost/user1-10
    @GetMapping("/user{pageNum}-{pageSize}")
    public String user2(Model model, @PathVariable Integer pageNum,@PathVariable Integer pageSize){
        PageInfo<Userinfo> page = userServiceImpl.findAll(pageNum,pageSize);
        model.addAttribute("page",page);
        return "show";
    }

    @RequestMapping("/test.action")
    public String show(){
        return "test";
    }

    @RequestMapping("/login.action")
    public String login(Model model,@Validated(value = LoginValidate.class) Userinfo userinfo,
        BindingResult br,String imageCode){

        return "admin";
    }
}

package com.handler;

import com.entity.LoginValidate;
import com.entity.Userinfo;
import com.github.pagehelper.PageInfo;
import com.service.IUserService;
import com.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 *
 */
@Controller
public class UserHandler {
    @Autowired
    private IUserService userServiceImpl;

    //http://localhost/findAllPage.action?pageNum=1&pageSize=10
    //http://localhost/user/1/10
    //http://localhost/user1-10
    @RequestMapping("/admin/findUser.action")
    @ResponseBody
    public HashMap<String,Object> findAllPage(Integer page, Integer limit){
        PageInfo<Userinfo> info = userServiceImpl.findAll(page,limit);
        return ResultUtil.getResult("0","",info.getTotal(),info.getList());
    }

    @RequestMapping("/login.action")
    public String login(Model model, @Validated(value = LoginValidate.class) Userinfo userinfo,
                        BindingResult br, String imageCode, HttpSession session){
        //判断数据校验是否有错误
        if(br.hasErrors()){
            //遍历所有错误信息
            for(FieldError error : br.getFieldErrors()){
                //把所有的错误信息传递给前端页面
                model.addAttribute(error.getField() + "Error",error.getDefaultMessage());
            }
            return "login";
        }
        String sessionImageCode = (String)session.getAttribute("imageCode");
        //验证码不匹配
        if(sessionImageCode == null || imageCode == null || !sessionImageCode.equalsIgnoreCase(imageCode)){
            model.addAttribute("msg","验证码不正确");
            return "login";
        }

        Userinfo userinfo1 = userServiceImpl.login(userinfo.getUser_name());
        if(userinfo1 == null){
            model.addAttribute("msg","用户不存在");
            return "login";
        }

        if(!userinfo1.getUser_pwd().equals(userinfo.getUser_pwd())){
            model.addAttribute("msg","密码不正确");
            return "login";
        }

        session.setAttribute("userinfo",userinfo1);
        return "redirect:/admin/user.html";
    }

    @RequestMapping("/admin/deleteUser.action")
    @ResponseBody
    public HashMap<String,Object> deleteUser(Integer user_id){
        int num = userServiceImpl.deleteUser(user_id);
        return num == 0 ? ResultUtil.getResult("-1","删除失败") : ResultUtil.getResult("0","删除成功");
    }

    @RequestMapping("/admin/findUserById.action")
    @ResponseBody
    public HashMap<String,Object> findUserById(Integer user_id){
        Userinfo userinfo = userServiceImpl.findById(user_id);
        return ResultUtil.getResult("0","", userinfo);
    }

    @RequestMapping("/admin/updateUser.action")
    @ResponseBody
    public HashMap<String,Object> updateUser(@Validated(LoginValidate.class) Userinfo info,BindingResult br ){
        if(br.hasErrors()) return ResultUtil.getResult("-1","请求数据异常");
        int num = userServiceImpl.update(info);
        return num == 0 ? ResultUtil.getResult("-1","更新失败") : ResultUtil.getResult("0","更新成功");
    }
}

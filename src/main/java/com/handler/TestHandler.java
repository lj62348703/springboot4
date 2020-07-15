package com.handler;

import com.entity.Userinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestHandler {

    @GetMapping("/test.action")
    public String test(Model model){
        model.addAttribute("text","文本");
        model.addAttribute("id","3");
        model.addAttribute("html","<p>1111</p><p>2222</p>");

        Userinfo info1 = new Userinfo();
        info1.setUser_id(1);
        info1.setUser_name("小明1");
        info1.setUser_nick("mmm1");

        Userinfo info2 = new Userinfo();
        info2.setUser_id(2);
        info2.setUser_name("小明2");
        info2.setUser_nick("mmm2");

        Userinfo info3 = new Userinfo();
        info3.setUser_id(3);
        info3.setUser_name("小明3");
        info3.setUser_nick("mmm3");

        List<Userinfo> list = new ArrayList<Userinfo>();
        list.add(info1);
        list.add(info2);
        list.add(info3);

        model.addAttribute("list",list);
        return "test";
    }
}

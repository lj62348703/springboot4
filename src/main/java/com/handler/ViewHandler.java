package com.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewHandler {

    @GetMapping("/login.html")
    public String loginHtml(){
        return "login";
    }

    @GetMapping("/index.html")
    public String indexHtml(){
        return "index";
    }

}

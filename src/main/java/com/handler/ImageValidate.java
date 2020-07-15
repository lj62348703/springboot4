package com.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 生成图片验证码
 * 并将验证码的字符串 作为字符串rand存到session中
 * @author admin
 */
@Controller
public class ImageValidate {
    @RequestMapping("/image.action")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //清除网页缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //把生成的验证码的字符串存到session中
        session.setAttribute("imageCode", verifyCode.toLowerCase());
        System.out.println("imageCode： "+verifyCode.toLowerCase());
        //生成图片
        int w = 200, h = 80;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

}

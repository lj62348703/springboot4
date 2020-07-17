package com.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class Userinfo implements Serializable {
    private Integer user_id;

    @NotNull(message = "用户名不能为空", groups = {LoginValidate.class})
    @NotEmpty(message = "用户名不能为空", groups = {LoginValidate.class})
    @Pattern(message = "用户名必须是3-12位",regexp = "^.{3,12}$", groups = {LoginValidate.class})
    private String user_name;

    @NotNull(message = "昵称不能为空", groups = {RegValidate.class})
    @NotEmpty(message = "昵称不能为空", groups = {RegValidate.class})
    @Pattern(message = "昵称必须是3-12位",regexp = "^.{3,12}$", groups = {RegValidate.class})
    private String user_nick;

    @NotNull(message = "密码不能为空", groups = {LoginValidate.class})
    @NotEmpty(message = "密码不能为空", groups = {LoginValidate.class})
    @Pattern(message = "密码必须是6-18位",regexp = "^.{6,18}$", groups = {LoginValidate.class})
    private String user_pwd;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_nick='" + user_nick + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}

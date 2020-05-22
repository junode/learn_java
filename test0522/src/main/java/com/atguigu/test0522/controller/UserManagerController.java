package com.atguigu.test0522.controller;

import com.atguigu.test0522.bean.UserInfo;
import com.atguigu.test0522.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManagerController {
    @Autowired
    private UserManagerService userManagerService;

    // http://localhost:8080/findAll 可查询到客户信息数据
    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> getAllUserInfo(){
        return userManagerService.getAllUserInfo();
    }

    @RequestMapping("addUserInfo")
    @ResponseBody
    public void addUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("helo@qq.com");
        userInfo.setHeadImg("/hehe.jpg");
        userInfo.setLoginName("haha");
        userInfo.setNickName("wahaha");
        userInfo.setPasswd("111");
        userManagerService.addUserInfo(userInfo);
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public void updateUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("4");
        userInfo.setPasswd("2222");
        userInfo.setPhoneNum("111111111");
        userManagerService.updateUser(userInfo);
    }

    // http://localhost:8080/deleteUserInfo
    @RequestMapping("deleteUserInfo")
    @ResponseBody
    public void deleteUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("4");
        userInfo.setPasswd("2222");
        userInfo.setPhoneNum("111111111");
        userManagerService.deleteUserInfo(userInfo);
    }

    // http://localhost:8080/updateUserInfoByName?name=junode
    @RequestMapping("updateUserInfoByName")
    @ResponseBody
    public void updateUserInfoByName(String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setPasswd("333");
        userInfo.setPhoneNum("11111");
        userInfo.setNickName("junode");
        userManagerService.updateUserInfoByName(name,userInfo);

    }

}

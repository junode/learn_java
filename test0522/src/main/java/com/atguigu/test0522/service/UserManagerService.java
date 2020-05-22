package com.atguigu.test0522.service;

import com.atguigu.test0522.bean.UserInfo;

import java.util.List;

public interface UserManagerService {

    List<UserInfo> getAllUserInfo();

    void addUserInfo(UserInfo userInfo);

    void deleteUserInfo(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void updateUserInfoByName(String name,UserInfo userInfo);
}

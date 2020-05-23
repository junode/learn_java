package com.atguigu.test0522.rpcDemo1;

import com.atguigu.test0522.common.IUserService;
import com.atguigu.test0522.common.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id,"hello world");
    }
}

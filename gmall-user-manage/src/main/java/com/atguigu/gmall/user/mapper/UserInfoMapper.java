package com.atguigu.gmall.user.mapper;


import com.atguigu.gmall.bean.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
}

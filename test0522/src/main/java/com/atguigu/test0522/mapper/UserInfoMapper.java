package com.atguigu.test0522.mapper;

import com.atguigu.test0522.bean.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 使用通用mapper
 */
@Repository
public interface UserInfoMapper  extends Mapper<UserInfo> {
}

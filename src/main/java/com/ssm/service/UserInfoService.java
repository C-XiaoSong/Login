package com.ssm.service;

import com.ssm.pojo.UserInfo;

public interface UserInfoService {
    UserInfo queryUserInfoNameAndPassword(String name);
    int insertUserInfo(UserInfo userInfo);
}

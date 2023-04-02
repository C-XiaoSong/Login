package com.ssm.service.impl;

import com.ssm.mapper.UserInfoMapper;
import com.ssm.pojo.UserInfo;
import com.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo queryUserInfoNameAndPassword(String name) {
        return userInfoMapper.queryUserInfoNameAndPassword(name);
    }
    @Override
    public int insertUserInfo(@RequestBody UserInfo userInfo) {
        if (userInfo.getPassword() != null & userInfo.getPassword() != "") {
            return userInfoMapper.insertUserInfo(userInfo);
        }
        return 0;
    }
}

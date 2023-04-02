package com.ssm.mapper;

import com.ssm.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface UserInfoMapper {
    /**
     * 查询账号和密码
     * @param name
     * @return
     */
    UserInfo queryUserInfoNameAndPassword(@Param("name") String name);

    int insertUserInfo(@RequestBody UserInfo userInfo);

}

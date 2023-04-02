package com.ssm.controller;

import com.ssm.pojo.UserInfo;
import com.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    /**
     * 登录页面
     * @param name
     * @param password
     * @param response
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/login")
    public String login(String name, String password, HttpServletResponse response,
                        HttpServletRequest request) throws IOException {
        //前端传过来的name放到方法里进行查询，得到一个账号和密码
        UserInfo info = userInfoService.queryUserInfoNameAndPassword(name);
        //判断对象是否为空
        if (info == null) {
            //为空就是前端传过来的name通过查询的时候数据库里面没有，继续登录
            response.sendRedirect("/music/login.html");
            //判断前端传过来的密码和数据库里存的一样不
            return null;
        }
        if (info.getPassword().equals(password)){
            request.getSession().setAttribute("user", info);
            response.sendRedirect("/music/index.html");
            return null;
        }else {
            response.sendRedirect("/music/login.html");
            return null;
        }
    }
    /**
     * 注册用户账号
     * @param userInfo
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/insert")
    public String insert(@RequestBody UserInfo userInfo, HttpServletResponse response) throws IOException{
        //如果返回是1 就是注册成功
        if (userInfoService.insertUserInfo(userInfo)>0){
            response.sendRedirect("/music/login.html");
        }
        return null;
    }
    /**
     * 退出登录
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/out")
    public void out(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //清空session 用于从会话中删除指定名称的属性。当调用该方法并传入要删除的属性的名称时，会将该属性从会话中删除。
        request.getSession().removeAttribute("user");
        response.sendRedirect("/music/login.html");
    }
}

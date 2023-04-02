package com.ssm.interceptor;

import com.ssm.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//定义一个拦截器
public class FilterInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //前端塞进session中的值 这里取出
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        if (user == null) {
            response.getWriter().println("账号错误");
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        return true;
    }
}

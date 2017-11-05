package com.dongwt.glasses.service.impl;

import com.dongwt.glasses.api.request.LoginRequest;
import com.dongwt.glasses.api.request.UserRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.constant.CommonConstant;
import com.dongwt.glasses.dao.User;
import com.dongwt.glasses.mapper.UserMapper;
import com.dongwt.glasses.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
@Service
public class UserServiceImpl implements UserService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public Response<String, String> checkLoginStatus(HttpSession httpSession) {
        Response<String, String> response = Response.success();
        Long val = (Long) httpSession.getAttribute(CommonConstant.TOKEN);
        if (null == val) {
            response = Response.error("请登录!");
            logger.warn(response.getMessage());
        }
        return response;
    }

    @Override
    public Response<String, String> login(LoginRequest loginRequest, HttpSession httpSession) {
        Response<String, String> response = Response.success();

        int count = userMapper.login(loginRequest);
        if (count == 0) {
            response = Response.error("用户或密码不正确!");
            logger.error(response.getMessage());
        } else {
            httpSession.setMaxInactiveInterval(60*60*24);
            httpSession.setAttribute(CommonConstant.TOKEN,System.currentTimeMillis());
            logger.info("登录成功");
        }
        return response;
    }

    @Override
    public Response<List<User>, String> getUserList(UserRequest userRequest) {
        List<User> data = userMapper.getUserList(userRequest);
        Response<List<User>, String> response = Response.success();
        response.setData(data);
        return response;
    }
}

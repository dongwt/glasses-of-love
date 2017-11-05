package com.dongwt.glasses.service;

import com.dongwt.glasses.api.request.LoginRequest;
import com.dongwt.glasses.api.request.UserRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
public interface UserService {

    /**
     * 检查登录状态
     * @param httpSession
     * @return
     */
    Response<String,String> checkLoginStatus(HttpSession httpSession);

    /**
     * 登录
     * @param loginRequest
     * @return
     */
    Response<String,String> login(LoginRequest loginRequest,HttpSession httpSession);

    /**
     * 获取用户列表
     * @param userRequest
     * @return
     */
    Response<List<User>,String> getUserList(UserRequest userRequest);
}


package com.dongwt.glasses.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.request.LoginRequest;
import com.dongwt.glasses.api.request.UserRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.User;
import com.dongwt.glasses.enums.ResponseEnum;
import com.dongwt.glasses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
@RestController
@RequestMapping("/user")
public class UserCtrl extends BaseCtrl{

    @Autowired
    private UserService userService;

    @RequestMapping("/checkLoginStatus")
    public Response<String,String> checkLoginStatus(HttpSession httpSession){
        return userService.checkLoginStatus(httpSession);
    }


    @RequestMapping("/login")
    public Response<String,String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        logger.info("method:{},loginRequest:{}", Thread.currentThread().getStackTrace()[1].getMethodName(),JSONObject.toJSONString(loginRequest));

        HttpSession httpSession = httpServletRequest.getSession();
        Response<String,String> response = userService.login(loginRequest,httpSession);
        return response;
    }


    @RequestMapping("/getUserList")
    public Response<List<User>,String> getUserList(@RequestBody UserRequest userRequest){
        logger.info("method:{},userRequest:{}", Thread.currentThread().getStackTrace()[1].getMethodName(),JSONObject.toJSONString(userRequest));
        return userService.getUserList(userRequest);
    }
}

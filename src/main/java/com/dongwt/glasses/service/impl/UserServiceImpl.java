package com.dongwt.glasses.service.impl;

import com.dongwt.glasses.api.request.UserRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.User;
import com.dongwt.glasses.mapper.UserMapper;
import com.dongwt.glasses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Response<List<User>> getUserList(UserRequest userRequest) {
        List<User> data = userMapper.getUserList(userRequest);
        Response<List<User>> response = new Response<>();
        response.setData(data);
        response.setStatus(1);
        response.setMessage("success");
        return response;
    }
}

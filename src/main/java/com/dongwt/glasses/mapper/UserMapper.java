package com.dongwt.glasses.mapper;

import com.dongwt.glasses.api.request.LoginRequest;
import com.dongwt.glasses.api.request.UserRequest;
import com.dongwt.glasses.dao.User;

import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
public interface UserMapper {

    List<User>  getUserList(UserRequest userRequest);

    int login(LoginRequest loginRequest);
}

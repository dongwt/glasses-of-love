package com.dongwt.glasses.service;

import com.dongwt.glasses.api.request.UserRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.User;

import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
public interface UserService {

    Response<List<User>> getUserList(UserRequest userRequest);
}

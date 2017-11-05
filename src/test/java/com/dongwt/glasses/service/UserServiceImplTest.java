package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.request.UserRequest;
import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
public class UserServiceImplTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void getUserList(){
        UserRequest userRequest = new UserRequest();
        Response<List<User>,String> result =  userService.getUserList(userRequest);
        logger.info(JSONObject.toJSONString(result));
    }

}

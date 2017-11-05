package com.dongwt.glasses.ctrl;

import com.dongwt.glasses.api.response.Response;
import com.dongwt.glasses.dao.User;
import com.dongwt.glasses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dongwt on 2017/11/5.
 */
@RestController
@RequestMapping("/user")
public class UserCtrl {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserList")
    public Response<List<User>> getUserList(){
        return userService.getUserList(null);
    }
}

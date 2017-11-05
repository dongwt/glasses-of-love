package com.dongwt.glasses.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dongwt on 2017/11/5.
 */
@RestController
@RequestMapping("/")
public class BaseCtrl {

    private static final Logger logger = LoggerFactory.getLogger(BaseCtrl.class);


    @RequestMapping("/index")
    public String hello() {
        return "hello glasses-of-love";
    }
}

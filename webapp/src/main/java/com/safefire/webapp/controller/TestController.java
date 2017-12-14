package com.safefire.webapp.controller;

import java.util.Date;

import javax.validation.Valid;

import com.safefire.common.vo.BaseResp;
import com.safefire.common.vo.user.ReqUserLogin;
import com.safefire.common.vo.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseResp<User> getUser() {
        User user = new User();
        user.setCreateTime(new Date());
        return new BaseResp<User>(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseResp<ReqUserLogin> login(@Valid ReqUserLogin reqLogin) {
        return new BaseResp<ReqUserLogin>(reqLogin);
    }

}

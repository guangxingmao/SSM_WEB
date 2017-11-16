package com.mgx.controller;

/**
 * Created by mgx on 17/11/16.
 */

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.mgx.pojo.ResponseResult;
import com.mgx.pojo.User;
import com.mgx.service.IUserService;
import com.mysql.jdbc.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public ResponseResult toIndex(int id) {
        User user = this.userService.getUserById(id);
        ResponseResult<User> userResponseResult = new ResponseResult<User>();
        userResponseResult.setData(user);
        return userResponseResult;
    }
}
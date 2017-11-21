package com.mgx.controller;

/**
 * Created by mgx on 17/11/16.
 */

import javax.annotation.Resource;

import com.mgx.pojo.ResponseResult;
import com.mgx.pojo.User;
import com.mgx.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * @param id 用户id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public ResponseResult toIndex(@RequestParam(required = true ) int id) {
        ResponseResult<User> userResponseResult = new ResponseResult<User>();
        try {
            User user = this.userService.getUserById(id);
            userResponseResult.setData(user);
            userResponseResult.setSuccess(true);
        } catch (Exception e) {
            userResponseResult.setSuccess(false);
            userResponseResult.setMessage(e.toString());
        }
        return userResponseResult;
    }

    @RequestMapping(value = "/{location}",method = RequestMethod.GET)
    public String toUrl(@PathVariable String location) {
        return location;
    }

}
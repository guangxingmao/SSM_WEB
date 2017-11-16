package com.mgx.service.impl;

import com.mgx.dao.IUserDao;
import com.mgx.pojo.User;
import com.mgx.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mgx on 17/11/16.
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }
}
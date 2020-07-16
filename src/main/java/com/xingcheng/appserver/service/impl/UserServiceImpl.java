package com.xingcheng.appserver.service.impl;

import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.repository.UserDao;
import com.xingcheng.appserver.service.IUserService;
import com.xingcheng.appserver.utils.exception.ExceptionFactory;
import com.xingcheng.appserver.utils.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User save(User user) {
        /*if(ObjectUtils.isEmpty(userDao.findByUsername(MD5Utils.stringToMD5(user.getUsername())))==false){
           throw ExceptionFactory.getBizException("用户名不能重复");
        }*/
        return userDao.save(user);
    }

    @Override
    public Page<User> findAll(int page, int pagesize) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}

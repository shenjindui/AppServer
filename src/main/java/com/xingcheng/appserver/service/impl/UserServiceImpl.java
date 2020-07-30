package com.xingcheng.appserver.service.impl;

import com.xingcheng.appserver.repository.IUserRepository;
import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.service.IUserService;
import com.xingcheng.appserver.utils.exception.ExceptionFactory;
import com.xingcheng.appserver.utils.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userDao;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(int id) {
        //userDao.delete();
    }

    @Override
    public User save(User user){
        if(ObjectUtils.isEmpty(userDao.findByUsername(user.getUsername()))==false){
           throw ExceptionFactory.getBizException("用户名:"+user.getUsername()+"已存在！");
        }
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
        return null;
    }

    @Override
    public User get(User user) {
        return userDao.getOne(user.getId());
    }
}

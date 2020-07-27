package com.xingcheng.appserver.service.impl;

import com.xingcheng.appserver.repository.IUserRepository;
import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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
        return null;
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
        return /*userDao.getSQLManager().selectUnique("user.get", user, User.class)*/null;
    }
}

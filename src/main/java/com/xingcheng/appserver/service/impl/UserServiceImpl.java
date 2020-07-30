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

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        //userDao.delete();
    }

    @Override
    public User save(User user){
        if(ObjectUtils.isEmpty(userRepository.findByUsername(user.getUsername()))==false){
           throw ExceptionFactory.getBizException("用户名:"+user.getUsername()+"已存在！");
        }
        return userRepository.save(user);
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
        return userRepository.getOne(user.getId());
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

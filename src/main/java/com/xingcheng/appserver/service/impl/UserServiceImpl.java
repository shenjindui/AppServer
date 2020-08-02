package com.xingcheng.appserver.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xingcheng.appserver.common.service.CommonServiceImpl;
import com.xingcheng.appserver.common.vo.SysUserVo;
import com.xingcheng.appserver.mapper.IUserMapper;
import com.xingcheng.appserver.repository.IUserRepository;
import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.service.IUserService;
import com.xingcheng.appserver.utils.exception.ExceptionFactory;
import com.xingcheng.appserver.utils.util.MD5Utils;
import com.xingcheng.appserver.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends CommonServiceImpl<UserVO, User, String> implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findByUuid(String id) {
        return userRepository.findByUuid(id);
    }

  /*  @Override
    public void delete(int id) {
        //userDao.delete();
    }*/

    /*@Override
    public User save(User user){
        if(ObjectUtils.isEmpty(userRepository.findByUsername(user.getUsername()))==false){
           throw ExceptionFactory.getBizException("用户名:"+user.getUsername()+"已存在！");
        }
        Integer count = userMapper.selectCount(new EntityWrapper<User>().eq("email", user.getEmail()));
        if(count >= 1){
            throw ExceptionFactory.getBizException("此邮箱:"+user.getEmail()+"已被注册！");
        }
        return userRepository.saveAndFlush(user);
        //return userRepository.saveAndFlush(user);
    }*/

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
        return  null;
        //return userRepository.getOne(user.getId());
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

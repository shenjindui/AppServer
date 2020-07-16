package com.xingcheng.appserver.service;

import com.xingcheng.appserver.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {

    User findByUsernameAndPassword(String username,String password);
    /**
     *
     * @param id
     * @return
     */
    User findById(int id);

    /**
     *
     * @param id
     */
    void delete(int id);

    /**
     *
     * @param user
     * @return
     */
    User save(User user);

    /**
     *
     * @param page
     * @param pagesize
     * @return
     */
    Page<User> findAll(int page, int pagesize);

    /**
     *
     * @param user
     * @return
     */
    User update(User user);

    /**
     *
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}

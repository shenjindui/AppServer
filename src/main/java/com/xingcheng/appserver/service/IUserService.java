package com.xingcheng.appserver.service;

import com.xingcheng.appserver.common.service.CommonService;
import com.xingcheng.appserver.common.vo.SysUserVo;
import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.vo.UserVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService extends CommonService<UserVO, User, String> {

    User findByUsernameAndPassword(String username,String password);
    /**
     *
     * @param id
     * @return
     */
    User findByUuid(String id);

    /**
     *
     * @param id
     */
    //void delete(String id);

    /**
     *
     * @param user
     * @return
     */
    //User save(User user);

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


    User get(User user);


    List<User> findByEmail(String email);
}

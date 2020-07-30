package com.xingcheng.appserver.repository;

import com.xingcheng.appserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {

    User findById(int id);

    User findByUsername(String username);


    User findByUsernameAndPassword(String username,String password);
    /*@Query(name = "findByUsername",nativeQuery = true,value =
            "select * from user where username = :username")
    List<User> findByName(@Param("username")String username);*/

    List<User> findByEmail(String email);
}
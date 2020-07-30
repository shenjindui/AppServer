package com.xingcheng.appserver.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xingcheng.appserver.entity.User;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IUserMapper extends BaseMapper<User>{

    //User selectById(@Param("id") int id);
    /*@Select("selectUserList")
    List<User> selectUserList(Pagination page, String state);*/
}

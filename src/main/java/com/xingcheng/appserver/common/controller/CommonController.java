package com.xingcheng.appserver.common.controller;

import com.xingcheng.appserver.common.Decrypt;
import com.xingcheng.appserver.common.Encrypt;
import com.xingcheng.appserver.common.entity.PageInfo;
import com.xingcheng.appserver.common.entity.Result;
import com.xingcheng.appserver.common.service.CommonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通用Controller
 *
 * @param <V> 实体类Vo
 * @param <E> 实体类
 * @param <T> id主键类型
 */

/**
 * todo 考虑到参数的加密解密，使用注解@Decrypt @Encrypt
 */
public class CommonController<V, E, T> {

    @Autowired
    private CommonService<V, E, T> commonService;

    /*
        CRUD、分页、排序测试
     */
    @ApiOperation(value = "分页操作", notes = "分页操作")
    @PostMapping("page")
    //@Decrypt
    //@Encrypt
    public Result<PageInfo<V>> page(V entityVo) {
        return commonService.page(entityVo);
    }

    @ApiOperation(value = "数据列表", notes = "数据列表")
    @PostMapping("list")
   // @Decrypt
    //@Encrypt
    public Result<List<V>> list(V entityVo) {
        return commonService.list(entityVo);
    }

    @ApiOperation(value = "根据id获取数据", notes = "根据id获取数据")
    @GetMapping("get/{id}")
    public Result<V> get(@PathVariable("id") T id) {
        return commonService.get(id);
    }

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @PostMapping("save")
    //@Decrypt
    //@Encrypt
    public Result<V> save(V entityVo) {
        return commonService.save(entityVo);
    }

    @ApiOperation(value = "删除数据", notes = "删除数据")
    @DeleteMapping("delete/{id}")
    public Result<T> delete( @PathVariable("id") T id) {
        return commonService.delete(id);
    }
}


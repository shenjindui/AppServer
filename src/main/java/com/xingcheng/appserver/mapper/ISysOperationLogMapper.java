package com.xingcheng.appserver.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xingcheng.appserver.entity.SysOperationLog;
import com.xingcheng.appserver.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface ISysOperationLogMapper extends BaseMapper<SysOperationLog> {
}

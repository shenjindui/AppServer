package com.xingcheng.appserver.service;

import com.xingcheng.appserver.entity.SysOperationLog;
import com.xingcheng.appserver.entity.User;

import java.util.Map;

public interface ISysOperationLogService {
    SysOperationLog save(Map<String,Object> parmMap);
}

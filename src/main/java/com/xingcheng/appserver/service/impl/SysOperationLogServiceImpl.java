package com.xingcheng.appserver.service.impl;

import com.xingcheng.appserver.entity.SysOperationLog;
import com.xingcheng.appserver.repository.ISysOperationRepository;
import com.xingcheng.appserver.service.ISysOperationLogService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysOperationLogService")
public class SysOperationLogServiceImpl implements ISysOperationLogService {

    @Autowired
    private ISysOperationRepository sysOperationRepository;

    @Override
    public SysOperationLog save(Map<String,Object> parmMap) {
        SysOperationLog sysOperationLog =  SysOperationLog.builder().username(MapUtils.getString(parmMap,"username")).classname(
                MapUtils.getString(parmMap,"classname")).ip(MapUtils.getString(parmMap,"ip")).methodname(
                MapUtils.getString(parmMap,"methodname")).userid(MapUtils.getString(parmMap,"userid")).remark(
                MapUtils.getString(parmMap,"remark")).build();
        return sysOperationRepository.save(sysOperationLog);
    }
}

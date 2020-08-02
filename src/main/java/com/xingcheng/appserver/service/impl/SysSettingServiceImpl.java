package com.xingcheng.appserver.service.impl;

import com.xingcheng.appserver.common.entity.Result;
import com.xingcheng.appserver.common.service.CommonServiceImpl;
import com.xingcheng.appserver.entity.SysSetting;
import com.xingcheng.appserver.repository.SysSettingRepository;
import com.xingcheng.appserver.service.ISysSettingService;
import com.xingcheng.appserver.utils.util.SysSettingUtil;
import com.xingcheng.appserver.vo.SysSettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class SysSettingServiceImpl extends CommonServiceImpl<SysSettingVo, SysSetting, Integer> implements ISysSettingService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysSettingRepository sysSettingRepository;

    @Override
    public Result<SysSettingVo> save(SysSettingVo entityVo) {
        //调用父类
        Result<SysSettingVo> result = super.save(entityVo);

        //更新系统设置时同步更新公用静态集合sysSettingMap
        SysSettingUtil.setSysSettingMap(result.getData());

        return result;
    }
}

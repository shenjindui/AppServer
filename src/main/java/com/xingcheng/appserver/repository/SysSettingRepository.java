package com.xingcheng.appserver.repository;

import com.xingcheng.appserver.common.repository.CommonRepository;
import com.xingcheng.appserver.entity.SysSetting;
import org.springframework.stereotype.Repository;

@Repository
public interface SysSettingRepository extends CommonRepository<SysSetting, Integer> {
}

package com.xingcheng.appserver.repository;

import com.xingcheng.appserver.entity.SysOperationLog;
import com.xingcheng.appserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISysOperationRepository extends JpaRepository<SysOperationLog,Integer> {
}

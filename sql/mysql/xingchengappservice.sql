/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql3306
Source Server Version : 50502
Source Host           : localhost:3306
Source Database       : xingchengappservice

Target Server Type    : MYSQL
Target Server Version : 50502
File Encoding         : 65001

Date: 2020-07-31 15:33:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '项目创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `itemchargeid` varchar(32) DEFAULT NULL COMMENT '项目负责人编号',
  `itemconstructionperiod` varchar(32) DEFAULT NULL COMMENT '项目工期（单位天）',
  `itemcredit` varchar(32) DEFAULT NULL COMMENT '项目信誉（百分制）',
  `itemdetail` varchar(256) DEFAULT NULL COMMENT '项目内容（详情）',
  `itemdifficulty` varchar(32) DEFAULT NULL COMMENT '项目难度',
  `itemdone` varchar(1) DEFAULT '1' COMMENT '项目是否完成',
  `itemicons` varchar(128) DEFAULT NULL COMMENT '项目图标',
  `itemname` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `itemprogress` varchar(64) DEFAULT NULL COMMENT '项目进度',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for item_job_rel
-- ----------------------------
DROP TABLE IF EXISTS `item_job_rel`;
CREATE TABLE `item_job_rel` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `itemid` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `jobid` varchar(32) DEFAULT NULL COMMENT '任务编号',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_job_rel
-- ----------------------------

-- ----------------------------
-- Table structure for item_user_rel
-- ----------------------------
DROP TABLE IF EXISTS `item_user_rel`;
CREATE TABLE `item_user_rel` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `itemid` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `userid` varchar(32) DEFAULT NULL COMMENT '成员用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_user_rel
-- ----------------------------

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '项目创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `jobchargeid` varchar(32) DEFAULT NULL COMMENT '任务负责人编号',
  `jobconstructionperiod` varchar(32) DEFAULT NULL COMMENT '任务工期（单位天）',
  `jobcredit` varchar(32) DEFAULT NULL COMMENT '任务信誉（百分制）',
  `jobdetail` varchar(256) DEFAULT NULL COMMENT '任务内容（详情）',
  `jobdifficulty` varchar(32) DEFAULT NULL COMMENT '任务难度',
  `jobdone` varchar(1) DEFAULT '1' COMMENT '任务是否完成',
  `jobicons` varchar(128) DEFAULT NULL COMMENT '任务图标',
  `jobname` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `jobprogress` varchar(64) DEFAULT NULL COMMENT '任务进度',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for job_user_rel
-- ----------------------------
DROP TABLE IF EXISTS `job_user_rel`;
CREATE TABLE `job_user_rel` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `jobid` varchar(32) DEFAULT NULL COMMENT '任务编号',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `userid` varchar(32) DEFAULT NULL COMMENT '成员用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_user_rel
-- ----------------------------

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `ip` varchar(32) DEFAULT NULL COMMENT '用户ip',
  `mac` varchar(128) DEFAULT NULL COMMENT 'mac地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_log
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `messagedetail` varchar(32) DEFAULT NULL COMMENT '留言内容',
  `readed` varchar(1) DEFAULT '1' COMMENT '是否已读',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `workroomid` varchar(32) DEFAULT NULL COMMENT '留言工作室编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `classname` varchar(128) DEFAULT NULL COMMENT '请求操作类名',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `ip` varchar(32) DEFAULT NULL COMMENT '操作用户ip',
  `methodname` varchar(32) DEFAULT NULL COMMENT '请求操作方法名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `userid` varchar(32) DEFAULT NULL COMMENT '操作用户编号',
  `username` varchar(32) DEFAULT NULL COMMENT '操作用户名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '角色创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `rolename` varchar(32) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `email` varchar(32) DEFAULT NULL COMMENT '用户邮箱',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `icon` varchar(128) DEFAULT NULL COMMENT '用户头像',
  `nicknames` varchar(32) DEFAULT NULL COMMENT '昵称',
  `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `phone` varchar(32) DEFAULT NULL COMMENT '用户电话',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `usercredit` varchar(32) DEFAULT NULL COMMENT '用户信誉（百分制）',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rel`;
CREATE TABLE `user_role_rel` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '角色创建时间',
  `default_role` varchar(1) DEFAULT '0' COMMENT '是否为默认角色编号',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `roleid` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_rel
-- ----------------------------

-- ----------------------------
-- Table structure for workromm_item_rel
-- ----------------------------
DROP TABLE IF EXISTS `workromm_item_rel`;
CREATE TABLE `workromm_item_rel` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `itemid` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `workroomid` varchar(32) DEFAULT NULL COMMENT '工作室编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workromm_item_rel
-- ----------------------------

-- ----------------------------
-- Table structure for workromm_user_rel
-- ----------------------------
DROP TABLE IF EXISTS `workromm_user_rel`;
CREATE TABLE `workromm_user_rel` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `workroomid` varchar(32) DEFAULT NULL COMMENT '工作室编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workromm_user_rel
-- ----------------------------

-- ----------------------------
-- Table structure for workroom
-- ----------------------------
DROP TABLE IF EXISTS `workroom`;
CREATE TABLE `workroom` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `createtime` datetime DEFAULT NULL COMMENT '工作室创建时间',
  `enabled` varchar(1) DEFAULT '1' COMMENT '是否有效',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `workroomchargeid` varchar(32) DEFAULT NULL COMMENT '工作室负责人编号',
  `workroomcredit` varchar(32) DEFAULT NULL COMMENT '工作室信誉（百分制）',
  `workroomdetail` varchar(256) DEFAULT NULL COMMENT '工作室简介',
  `workroomicons` varchar(128) DEFAULT NULL COMMENT '工作室图标',
  `workroomname` varchar(32) DEFAULT NULL COMMENT '工作室名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workroom
-- ----------------------------

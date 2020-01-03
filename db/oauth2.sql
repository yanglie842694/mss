/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : oauth2

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-09-09 16:55:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clientdetails
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId` varchar(48) NOT NULL,
  `resourceIds` varchar(256) DEFAULT NULL,
  `appSecret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `grantTypes` varchar(256) DEFAULT NULL,
  `redirectUrl` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additionalInformation` varchar(4096) DEFAULT NULL,
  `autoApproveScopes` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientdetails
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('app', null, '{bcrypt}$2a$10$fONEAG/dyfqHrzzaeTOJDeM4fvR69c/p9.0zqIFhzCYvyaVS50psu', 'app', 'password,refresh_token', null, null, null, null, '{\"use\":\"Server call\"}', null);
INSERT INTO `oauth_client_details` VALUES ('browser', null, '{bcrypt}$2a$10$fONEAG/dyfqHrzzaeTOJDeM4fvR69c/p9.0zqIFhzCYvyaVS50psu', 'app', 'authorization_code,password,refresh_token,client_credentials,password,refresh_token', null, null, null, null, '{\"use\":\"Server call\"}', null);
INSERT INTO `oauth_client_details` VALUES ('server', '', '{bcrypt}$2a$10$fONEAG/dyfqHrzzaeTOJDeM4fvR69c/p9.0zqIFhzCYvyaVS50psu', 'server', 'authorization_code,password,refresh_token,client_credentials,check_token', '', '', null, null, '{\"use\":\"Server call\"}', '');
INSERT INTO `oauth_client_details` VALUES ('webApp', null, '{bcrypt}$2a$10$fONEAG/dyfqHrzzaeTOJDeM4fvR69c/p9.0zqIFhzCYvyaVS50psu', 'app', 'authorization_code,password,refresh_token,client_credentials,check_token', null, null, null, null, '{\"use\":\"Server call\"}', null);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编码',
  `p_code` varchar(255) DEFAULT NULL COMMENT '菜单父编码',
  `p_id` varchar(255) DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `is_menu` int(11) DEFAULT NULL COMMENT '是否是菜单(1.菜单。2.按钮)',
  `level` int(11) DEFAULT NULL COMMENT '菜单层级',
  `sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `status` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_CODE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_privilege`;
CREATE TABLE `sys_menu_privilege` (
  `privi_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`privi_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `privi_id` int(11) NOT NULL,
  `privi_code` varchar(255) DEFAULT NULL,
  `privi_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`privi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('1', 'query_user', '查询用户', '2019-09-09 15:36:25');
INSERT INTO `sys_privilege` VALUES ('2', 'query_intf', '查询接口', '2019-09-09 15:36:53');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_role_name` (`name`),
  UNIQUE KEY `unique_role_value` (`value`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('6', '管理员', 'admin', null, '2017-06-20 15:07:13', '2017-06-26 12:46:09', '1');
INSERT INTO `sys_role` VALUES ('8', '超级管理员', 'super', null, '2017-06-20 15:08:45', null, '1');
INSERT INTO `sys_role` VALUES ('17', '用户', 'user', null, '2017-06-28 18:50:39', '2017-07-21 09:41:28', '1');

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `privi_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`privi_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(96) DEFAULT NULL,
  `salt` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('46', null, 'super', '{bcrypt}$2a$10$ZEU/gNwgd3fZiLMb8oSgBOqcctssvp0Cbx/bToaDILOH0vLpuA6XG', null, '超级管理员', '2017-06-22 14:26:09', '1', null, null, '1', '2017-06-20 15:12:16', '2017-09-12 14:39:48');
INSERT INTO `sys_user` VALUES ('48', null, 'admin', '{bcrypt}$2a$10$ZEU/gNwgd3fZiLMb8oSgBOqcctssvp0Cbx/bToaDILOH0vLpuA6XG', null, '管理员', null, '1', null, null, '1', '2017-06-26 17:31:41', null);
INSERT INTO `sys_user` VALUES ('50', null, 'test1', '{bcrypt}$2a$10$ZEU/gNwgd3fZiLMb8oSgBOqcctssvp0Cbx/bToaDILOH0vLpuA6XG', null, 'test1', null, '1', null, null, '1', '2017-09-18 16:11:15', null);
INSERT INTO `sys_user` VALUES ('51', null, 'test2', '{bcrypt}$2a$10$ZEU/gNwgd3fZiLMb8oSgBOqcctssvp0Cbx/bToaDILOH0vLpuA6XG', null, 'test2', null, '1', null, null, '1', '2017-09-21 17:09:51', null);

-- ----------------------------
-- Table structure for sys_user_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_privilege`;
CREATE TABLE `sys_user_privilege` (
  `user_id` int(11) NOT NULL,
  `privi_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`privi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_privilege
-- ----------------------------
INSERT INTO `sys_user_privilege` VALUES ('48', '1');
INSERT INTO `sys_user_privilege` VALUES ('48', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `staff_code` varchar(255) DEFAULT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff
-- ----------------------------

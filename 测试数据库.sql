/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : je1905

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-08-13 16:36:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `get_emali`
-- ----------------------------
DROP TABLE IF EXISTS `get_emali`;
CREATE TABLE `get_emali` (
  `get_email_id` int(11) DEFAULT NULL,
  `send_Id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL,
  `text` text,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of get_emali
-- ----------------------------
INSERT INTO `get_emali` VALUES ('1', '1', '1', '你好', '你好吗？', '2019-07-11 18:39:19');
INSERT INTO `get_emali` VALUES ('2', '2', '1', '你好', '你好吗？', '2019-07-11 18:39:42');

-- ----------------------------
-- Table structure for `send_email`
-- ----------------------------
DROP TABLE IF EXISTS `send_email`;
CREATE TABLE `send_email` (
  `send_email_id` int(11) NOT NULL AUTO_INCREMENT,
  `get_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL,
  `text` text,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`send_email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of send_email
-- ----------------------------
INSERT INTO `send_email` VALUES ('1', '1', '1', '你好', '你好吗？', '2019-07-11 18:50:25');
INSERT INTO `send_email` VALUES ('2', '2', '3', '你好', '你好吗？', '2019-07-11 18:50:59');
INSERT INTO `send_email` VALUES ('3', '1', '2', '你好', '你好吗陶金华？', '2019-07-11 18:54:51');
INSERT INTO `send_email` VALUES ('4', '1', '3', '你好', '你好吗？', '2019-07-11 18:54:55');
INSERT INTO `send_email` VALUES ('5', '2', '1', '你好', '你好吗？', '2019-07-11 18:55:32');
INSERT INTO `send_email` VALUES ('6', '3', '1', '你好', '你好吗？', '2019-07-11 21:07:38');
INSERT INTO `send_email` VALUES ('8', '4', '2', '你好', '你好吗光头强？', '2019-07-11 21:52:59');
INSERT INTO `send_email` VALUES ('9', '3', '2', '你好', '你好吗小翠', '2019-07-11 22:59:11');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `p_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_desc` varchar(255) DEFAULT NULL COMMENT '菜单描述',
  `menu_url` varchar(255) DEFAULT NULL COMMENT 'URL',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '-1', '根级节点', '根级节点', '无', '2019-05-29 16:10:04');
INSERT INTO `sys_menu` VALUES ('2', '1', '系统管理', '系统管理', '无', '2019-04-26 00:00:00');
INSERT INTO `sys_menu` VALUES ('3', '2', '用户管理', '用户管理', 'userController?methodName=listPage', '2019-07-12 14:57:15');
INSERT INTO `sys_menu` VALUES ('4', '2', '角色管理', '角色管理', 'roleController?methodName=list', '2019-07-11 17:17:00');
INSERT INTO `sys_menu` VALUES ('5', '2', '菜单管理', '菜单管理', 'menuController?methodName=list', '2019-07-11 17:17:07');
INSERT INTO `sys_menu` VALUES ('6', '1', '邮件管理', '邮件管理', '无', '2019-05-29 16:10:07');
INSERT INTO `sys_menu` VALUES ('13', '6', '写邮件', '写邮件', '无', '2019-05-30 11:26:45');
INSERT INTO `sys_menu` VALUES ('14', '6', '收件箱', '收件箱', '无', '2019-05-30 11:27:07');
INSERT INTO `sys_menu` VALUES ('15', '6', '发件箱', '发件箱', 'sendemailController?methodName=AllList', '2019-07-11 19:51:55');
INSERT INTO `sys_menu` VALUES ('16', '6', '草稿箱', '草稿箱', '无', '2019-05-30 11:27:49');
INSERT INTO `sys_menu` VALUES ('17', '6', '垃圾箱', '垃圾箱', '无', '2019-05-30 11:28:12');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(225) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(225) DEFAULT NULL COMMENT '描述',
  `role_state` varchar(225) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '校长', '校长', '1', '2019-04-25 09:40:46');
INSERT INTO `sys_role` VALUES ('2', '教师', '教师', '1', '2019-04-25 09:41:11');
INSERT INTO `sys_role` VALUES ('3', '学生', '学生', '1', '2019-04-25 09:46:56');
INSERT INTO `sys_role` VALUES ('4', '管理员', '最高权限', '1', '2019-05-30 16:34:16');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色菜单ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('252', '3', '2');
INSERT INTO `sys_role_menu` VALUES ('253', '3', '3');
INSERT INTO `sys_role_menu` VALUES ('254', '3', '4');
INSERT INTO `sys_role_menu` VALUES ('255', '3', '5');
INSERT INTO `sys_role_menu` VALUES ('256', '3', '6');
INSERT INTO `sys_role_menu` VALUES ('263', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('264', '2', '3');
INSERT INTO `sys_role_menu` VALUES ('265', '2', '4');
INSERT INTO `sys_role_menu` VALUES ('266', '2', '5');
INSERT INTO `sys_role_menu` VALUES ('267', '2', '6');
INSERT INTO `sys_role_menu` VALUES ('268', '2', '13');
INSERT INTO `sys_role_menu` VALUES ('269', '2', '14');
INSERT INTO `sys_role_menu` VALUES ('270', '2', '15');
INSERT INTO `sys_role_menu` VALUES ('271', '2', '16');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(225) DEFAULT NULL COMMENT '角色名称',
  `age` varchar(225) DEFAULT NULL COMMENT '描述',
  `sex` varchar(225) DEFAULT NULL COMMENT '状态',
  `hobby` varchar(225) DEFAULT NULL COMMENT '创建时间',
  `login_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '陶金华', '45', '男', '跑步', 'tjh', '111', '2019-05-30 10:58:04');
INSERT INTO `sys_user` VALUES ('2', '朱凌风', '36', '男', '篮球', 'zlf', '111', '2019-05-30 10:59:25');
INSERT INTO `sys_user` VALUES ('3', '小翠', '23', '女', '跳舞', 'xc', '111', '2019-05-30 10:59:59');
INSERT INTO `sys_user` VALUES ('4', '光头强', '55', '男', null, 'admin', '111', '2019-05-30 14:25:02');
INSERT INTO `sys_user` VALUES ('5', '小明', '21', '男', null, 'xm', '111', '2019-07-11 22:45:01');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('123', '4', '4');
INSERT INTO `sys_user_role` VALUES ('124', '3', '3');
INSERT INTO `sys_user_role` VALUES ('129', '1', '3');
INSERT INTO `sys_user_role` VALUES ('130', '2', '2');

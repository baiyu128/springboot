/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : learning

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 03/10/2019 15:22:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shiro_event
-- ----------------------------
DROP TABLE IF EXISTS `shiro_event`;
CREATE TABLE `shiro_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `business_system_id` int(11) DEFAULT NULL,
  `closed_by` varchar(255) DEFAULT NULL,
  `closed_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `data_type` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `host` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `occur_count` int(11) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `raw_event_id` int(11) DEFAULT NULL,
  `resolved_by` varchar(255) DEFAULT NULL,
  `resolved_time` datetime DEFAULT NULL,
  `responsed_by` varchar(255) DEFAULT NULL,
  `responsed_time` datetime DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `suggest` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for shiro_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permission`;
CREATE TABLE `shiro_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `permission_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shiro_permission
-- ----------------------------
BEGIN;
INSERT INTO `shiro_permission` VALUES (1, NULL, 'GET', '查询用户', '/users');
INSERT INTO `shiro_permission` VALUES (2, NULL, 'POST', '新建用户', '/users');
INSERT INTO `shiro_permission` VALUES (3, NULL, 'DELETE', '删除', '/users.*');
INSERT INTO `shiro_permission` VALUES (4, NULL, 'GET', '查询事件', '/events');
INSERT INTO `shiro_permission` VALUES (5, NULL, 'POST', '新建事件', '/events');
INSERT INTO `shiro_permission` VALUES (6, NULL, 'DELETE', '删除事件', '/events/.*');
INSERT INTO `shiro_permission` VALUES (7, NULL, 'ALL', '事件', '/events.*');
COMMIT;

-- ----------------------------
-- Table structure for shiro_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shiro_role
-- ----------------------------
BEGIN;
INSERT INTO `shiro_role` VALUES (1, '管理员', 'admin', 1);
INSERT INTO `shiro_role` VALUES (2, '用户', 'user', 2);
COMMIT;

-- ----------------------------
-- Table structure for shiro_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shiro_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `shiro_role_permission` VALUES (1, 1, 2);
INSERT INTO `shiro_role_permission` VALUES (2, 2, 1);
INSERT INTO `shiro_role_permission` VALUES (3, 3, 1);
INSERT INTO `shiro_role_permission` VALUES (4, 4, 1);
INSERT INTO `shiro_role_permission` VALUES (5, 5, 2);
INSERT INTO `shiro_role_permission` VALUES (6, 7, 1);
COMMIT;

-- ----------------------------
-- Table structure for shiro_user
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `cnname` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login_count` int(11) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `skill` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `wechat_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shiro_user
-- ----------------------------
BEGIN;
INSERT INTO `shiro_user` VALUES (1, '2019-10-03 10:06:19', '2019-10-03 10:06:22', b'0', '2019-10-03 10:06:32', '张三', 1, 'ee@qq.com', 1, '18299999999', '123456', '1', NULL, 'zhangsan', 'zhangsan');
INSERT INTO `shiro_user` VALUES (2, '2019-10-03 10:06:19', '2019-10-03 10:06:22', b'0', '2019-10-03 10:06:32', '李四', 2, 'ee@qq.com', 1, '15622222222', '123456', '1', NULL, 'lisi', 'lisi');
INSERT INTO `shiro_user` VALUES (3, NULL, NULL, b'1', NULL, '', 0, '', 0, '', NULL, '', '', '', '');
INSERT INTO `shiro_user` VALUES (4, NULL, NULL, b'1', NULL, '', 0, '', 0, '', NULL, '', '', '', '');
INSERT INTO `shiro_user` VALUES (5, NULL, NULL, b'1', NULL, '', 0, '', 0, '', NULL, '', '', 'wangwu', '');
INSERT INTO `shiro_user` VALUES (6, NULL, NULL, b'1', NULL, '', 0, '', 0, '', NULL, '', '', 'wangwu', '');
INSERT INTO `shiro_user` VALUES (7, NULL, NULL, b'1', NULL, '', 0, '', 0, '', NULL, '', '', 'wangwu', '');
INSERT INTO `shiro_user` VALUES (8, NULL, NULL, b'1', NULL, '', 0, '', 0, '', NULL, '', '', 'wangwu', '');
INSERT INTO `shiro_user` VALUES (9, NULL, NULL, b'0', NULL, '', 0, '', 0, '', NULL, '', '', 'wangwu', '');
COMMIT;

-- ----------------------------
-- Table structure for shiro_user_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user_role`;
CREATE TABLE `shiro_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shiro_user_role
-- ----------------------------
BEGIN;
INSERT INTO `shiro_user_role` VALUES (1, 1, 1);
INSERT INTO `shiro_user_role` VALUES (2, 2, 1);
INSERT INTO `shiro_user_role` VALUES (3, 2, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

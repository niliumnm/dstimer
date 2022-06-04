/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : zzz

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 04/06/2022 13:01:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '群名',
  `unread_messages_number` int NULL DEFAULT NULL COMMENT '未读消息数量',
  `event_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '事件名',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发起人昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
  `starting_time` timestamp NOT NULL COMMENT '发起时间',
  `deadline` timestamp NOT NULL COMMENT '截止时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (2, 'sda', 0, '玛卡巴卡', '嗯哼', '芜湖', '王心凌', 'ss', '2022-06-02 20:16:07', '2022-06-25 20:16:10');
INSERT INTO `messages` VALUES (3, 'dsad', 0, 'zzz', 'z', 'zz', 'www', 'wwws', '2022-06-02 20:16:07', '2022-06-25 20:16:10');
INSERT INTO `messages` VALUES (4, 'dd', 0, 'zzz', 'z', 'ss', 'ds', 'asd', '2022-06-14 21:56:00', '2022-06-21 21:56:03');
INSERT INTO `messages` VALUES (5, 'd', 0, 'fdf', 'dd', '0', 'gh', 'dd', '2022-06-22 21:56:41', '2022-06-23 21:56:44');
INSERT INTO `messages` VALUES (6, '晚安', 0, 'zzz', 'z', 'ss', 'ds', 'asd', '2022-06-14 21:56:00', '2022-06-21 21:56:03');

-- ----------------------------
-- Table structure for upcoming
-- ----------------------------
DROP TABLE IF EXISTS `upcoming`;
CREATE TABLE `upcoming`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `event_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '事件名\r\n',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发起人',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `starting_time` timestamp NOT NULL COMMENT '发起时间\r\n',
  `deadline` timestamp NOT NULL COMMENT '截止时间\r\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upcoming
-- ----------------------------
INSERT INTO `upcoming` VALUES (2, 'h', '使得', 'd师生d', '全为', '师生', '2022-06-02 18:25:03', '2022-07-10 18:25:06');
INSERT INTO `upcoming` VALUES (3, 'g', 'g', 'g', 'gg', 'ggg', '2022-05-30 19:46:52', '2022-06-11 19:46:55');
INSERT INTO `upcoming` VALUES (4, 'd', 'j', 'j', 'j', 'j', '2022-06-27 19:47:08', '2022-06-16 19:47:12');
INSERT INTO `upcoming` VALUES (5, 'g', 'q', 'q', 'q', 'q', '2022-07-20 19:47:54', '2022-06-28 19:48:40');
INSERT INTO `upcoming` VALUES (6, 'h', 'e', 'e', 'e', 'e', '2022-05-31 19:49:04', '2022-06-04 19:49:08');
INSERT INTO `upcoming` VALUES (7, 'zzz', 'z', 'ss', 'ds', 'asd', '2022-06-14 21:56:00', '2022-06-21 21:56:03');

SET FOREIGN_KEY_CHECKS = 1;

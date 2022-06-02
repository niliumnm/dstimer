/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : dstimer

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 02/06/2022 10:40:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一ID 自增的',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名 例: dstuser_35dsq、dstuser_asp2q',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称   例: 张三、李四',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像的路径 可以为空',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别: 男/女',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间 插入时自动生成',
  `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '孙悟空', '123456', '齐天大圣', NULL, '男', '888888@qq.com', '2022-05-31 11:16:07', NULL, '188888888', NULL);
INSERT INTO `t_user` VALUES (2, '猪八戒', '88888', '净坛使者', NULL, '男', '123456@qq.com', '2022-05-31 11:18:36', NULL, '1788888888', NULL);
INSERT INTO `t_user` VALUES (3, '唐僧', '123456', '金蝉子', NULL, '男', '8999999@163.com', '2022-05-31 11:19:29', NULL, '17899999999', NULL);
INSERT INTO `t_user` VALUES (4, '白骨精', '123456', '白骨夫人', NULL, '男', '89999999@qq.com', '2022-05-31 11:20:08', NULL, '+867894561', NULL);
INSERT INTO `t_user` VALUES (8, '大鹏测试', '123456', '大鹏元帅', 'https://m.duitang.com/blog/?id=1391351457&belong_album=109495738', '男', '89999999@qq.com', '2022-06-01 20:55:06', NULL, '+867894561', '天界');

SET FOREIGN_KEY_CHECKS = 1;

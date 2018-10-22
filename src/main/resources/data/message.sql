/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : oa

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 22/10/2018 23:39:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `reciver` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `message_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `message_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `message_time` datetime(0) DEFAULT NULL,
  `accessory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '4,6', '你好', '清理', '2018-10-22 18:19:30', NULL);
INSERT INTO `message` VALUES (2, '2,4,21,22', 'who are you', 'ddd', '2018-10-22 18:19:44', NULL);

SET FOREIGN_KEY_CHECKS = 1;

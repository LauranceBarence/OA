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

 Date: 22/10/2018 23:39:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sender_reciver
-- ----------------------------
DROP TABLE IF EXISTS `sender_reciver`;
CREATE TABLE `sender_reciver`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `message_id` int(10) DEFAULT NULL,
  `sender_id` int(10) DEFAULT NULL,
  `reciver_id` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sender_reciver
-- ----------------------------
INSERT INTO `sender_reciver` VALUES (1, 1, 2, 4, 1);
INSERT INTO `sender_reciver` VALUES (2, 1, 2, 6, 1);
INSERT INTO `sender_reciver` VALUES (3, 2, 2, 21, 1);
INSERT INTO `sender_reciver` VALUES (4, 2, 2, 22, 1);
INSERT INTO `sender_reciver` VALUES (5, 2, 2, 4, 1);
INSERT INTO `sender_reciver` VALUES (6, 2, 2, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;

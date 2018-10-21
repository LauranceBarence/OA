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

 Date: 20/10/2018 16:38:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(10) DEFAULT NULL,
  `reciver_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `message_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `message_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `status` int(10) DEFAULT NULL,
  `message_time` datetime(0) DEFAULT NULL,
  `accessory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, '2', 'qwe', 'wsxwewe', 2, '2018-10-19 09:43:03', NULL);
INSERT INTO `message` VALUES (2, 2, '3', '你好', '撒旦法撒旦撒旦法啊 电工房电工房 规范化人头费天润城V型吧', 2, '2018-10-19 14:27:47', NULL);
INSERT INTO `message` VALUES (3, 2, '2,4,5', '梵蒂冈哈斯的风格到公司', '123123dsfas', 2, '2018-10-20 15:19:50', NULL);
INSERT INTO `message` VALUES (4, 2, '5,7', '发顺丰的他儿童d当时发生的大法师fasfd', 'fgdfsg', 2, '2018-10-20 15:23:29', NULL);
INSERT INTO `message` VALUES (5, 2, '6,7', '梵蒂冈哈斯的', 'ghjbvdsd', 2, '2018-10-20 15:25:01', NULL);
INSERT INTO `message` VALUES (6, 2, '', '', '', 2, '2018-10-20 15:28:49', NULL);
INSERT INTO `message` VALUES (7, 2, '', '', '', 2, '2018-10-20 15:30:02', NULL);
INSERT INTO `message` VALUES (8, 2, '', '', '', 2, '2018-10-20 15:31:05', NULL);
INSERT INTO `message` VALUES (9, 2, '', '', '', 2, '2018-10-20 15:32:33', NULL);

SET FOREIGN_KEY_CHECKS = 1;

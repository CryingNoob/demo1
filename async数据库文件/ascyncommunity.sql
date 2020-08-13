/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : ascyncommunity

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 12/08/2020 09:53:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `answer_id` int(0) NOT NULL,
  `answer_content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_id` int(0) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `answer_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `question_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(0) UNSIGNED NOT NULL,
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `article_author_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  `article_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `artice_content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `like_number` int(8) UNSIGNED ZEROFILL NOT NULL,
  `comment_number` int(8) UNSIGNED ZEROFILL NOT NULL,
  `collect_number` int(8) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `article_id` int(0) NOT NULL,
  `html` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '1',
  `css3` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '2',
  `js` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '3',
  `vue` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '4',
  `react` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '5',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) UNSIGNED NOT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_id` int(0) UNSIGNED NOT NULL,
  `comment_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for like_and_collect
-- ----------------------------
DROP TABLE IF EXISTS `like_and_collect`;
CREATE TABLE `like_and_collect`  (
  `article_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `like_or_collect` tinyint(1) UNSIGNED ZEROFILL NOT NULL COMMENT '0 : like 1: collect',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(0) NOT NULL,
  `question_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `question_content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `question_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `answer_number` int(8) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_tag
-- ----------------------------
DROP TABLE IF EXISTS `question_tag`;
CREATE TABLE `question_tag`  (
  `question_id` int(0) NOT NULL,
  `html` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '1',
  `css3` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '2',
  `js` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '3',
  `vue` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '4',
  `react` int(8) UNSIGNED ZEROFILL NOT NULL COMMENT '5',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(0) NOT NULL,
  `tag` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

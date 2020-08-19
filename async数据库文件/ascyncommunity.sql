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

 Date: 19/08/2020 14:35:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `answer_id` int(0) NOT NULL AUTO_INCREMENT,
  `answer_content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `userid` int(0) NOT NULL,
  `answer_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `question_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, 'answer_content', 1, '2020-08-12', 00000001);
INSERT INTO `answer` VALUES (2, 'xiaola', 1, '2020-08-12', 00000001);
INSERT INTO `answer` VALUES (3, '我校啦', 2, '2020-08-14', 00000002);
INSERT INTO `answer` VALUES (4, '我也笑啦', 3, '2020-08-14', 00000002);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `article_author_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  `article_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `article_content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `like_number` int(8) UNSIGNED ZEROFILL NOT NULL DEFAULT 00000000,
  `comment_number` int(8) UNSIGNED ZEROFILL NOT NULL DEFAULT 00000000,
  `collect_number` int(8) UNSIGNED ZEROFILL NOT NULL DEFAULT 00000000,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 'test_article_titile1', 00000001, '2020-08-12', 'article_content', 00000002, 00000002, 00000002);
INSERT INTO `article` VALUES (2, '第二篇文章', 00000002, '2020-08-14', 'hh,不会真的有人在评论区里面笑8', 00000000, 00000000, 00000001);
INSERT INTO `article` VALUES (3, '标题', 00000001, ' 2020-08-17', ' 文章内容', 00000000, 00000000, 00000000);

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `article_id` int(0) NOT NULL,
  `tag_id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (1, 1, 1);
INSERT INTO `article_tag` VALUES (2, 1, 2);
INSERT INTO `article_tag` VALUES (3, 1, 3);
INSERT INTO `article_tag` VALUES (4, 2, 2);
INSERT INTO `article_tag` VALUES (5, 2, 3);
INSERT INTO `article_tag` VALUES (6, 2, 0);
INSERT INTO `article_tag` VALUES (7, 2, 4);
INSERT INTO `article_tag` VALUES (8, 3, 0);
INSERT INTO `article_tag` VALUES (9, 3, 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `userid` int(0) UNSIGNED NOT NULL,
  `comment_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `article_id` int(0) NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 'hh,爷笑啦', 1, '20200812', 1);
INSERT INTO `comment` VALUES (2, 'hh,不会吧不会吧', 2, '20200814', 2);
INSERT INTO `comment` VALUES (3, ' pinglumn内容', 1, ' 2020-08-17', 1);
INSERT INTO `comment` VALUES (4, '阿斯顿发射点', 2, '2020-08-19', 3);

-- ----------------------------
-- Table structure for like_and_collect
-- ----------------------------
DROP TABLE IF EXISTS `like_and_collect`;
CREATE TABLE `like_and_collect`  (
  `article_id` int(8) UNSIGNED ZEROFILL NOT NULL,
  `userid` int(0) NULL DEFAULT NULL,
  `like_or_collect` tinyint(1) UNSIGNED ZEROFILL NOT NULL COMMENT '0 : like 1: collect',
  `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of like_and_collect
-- ----------------------------
INSERT INTO `like_and_collect` VALUES (00000001, 1, 1, 0000000002);
INSERT INTO `like_and_collect` VALUES (00000002, 2, 0, 0000000003);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(0) NOT NULL AUTO_INCREMENT,
  `question_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `question_content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `question_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `answer_number` int(8) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 'linxiuming', '就这??', '2020-08-12', 00000001);
INSERT INTO `question` VALUES (2, 'aaa', '九折水瓶??', '2020-08-14', 00000002);

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
-- Records of question_tag
-- ----------------------------
INSERT INTO `question_tag` VALUES (1, 00000001, 00000002, 00000000, 00000000, 00000000);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(0) NOT NULL,
  `tag_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (0, 'html');
INSERT INTO `tag` VALUES (1, 'css');
INSERT INTO `tag` VALUES (2, 'js');
INSERT INTO `tag` VALUES (3, 'vue');
INSERT INTO `tag` VALUES (4, 'react');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `userpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE,
  UNIQUE INDEX `user_user_name_uindex`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'linxiuming', '123456');
INSERT INTO `user` VALUES (2, 'aaa', 'bbb');
INSERT INTO `user` VALUES (3, 'baiwenliang', 'bbb\r\n');

SET FOREIGN_KEY_CHECKS = 1;

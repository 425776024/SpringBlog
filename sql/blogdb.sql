/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : blogdb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-11-16 17:41:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(64) DEFAULT NULL,
  `cat_description` longtext,
  `cat_parent` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='categorytable';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('11', '分类1', null, null);
INSERT INTO `category` VALUES ('12', '分类2', null, null);
INSERT INTO `category` VALUES ('13', '分类3', null, null);
INSERT INTO `category` VALUES ('14', '分类4', null, null);
INSERT INTO `category` VALUES ('15', '分类5', null, null);
INSERT INTO `category` VALUES ('16', '分类6', null, null);
INSERT INTO `category` VALUES ('17', '分类7', null, null);
INSERT INTO `category` VALUES ('18', '分类8', null, null);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL,
  `comment_author` tinytext,
  `comment_author_email` varchar(100) DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  `comment_content` text,
  `comment_parent` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='comment table';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '2', 'jj', null, '2016-11-15 20:33:20', 'gfd', null, null);
INSERT INTO `comment` VALUES ('2', '2', 'drdr', null, '2016-11-15 20:33:24', 'drr', null, null);
INSERT INTO `comment` VALUES ('3', '4', '装逼', null, '2016-11-16 16:03:17', '6666666666666', null, null);

-- ----------------------------
-- Table structure for hello
-- ----------------------------
DROP TABLE IF EXISTS `hello`;
CREATE TABLE `hello` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `remarks` varbinary(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='hello table for test ';

-- ----------------------------
-- Records of hello
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `post_content` longtext,
  `post_title` text,
  `post_status` int(8) DEFAULT NULL COMMENT '0:draft\n            1:publish\n            2:private\n\n            ',
  `comment_status` int(8) DEFAULT NULL COMMENT '0:closed\n            1:open\n            3:registered_only',
  `category_id` bigint(20) DEFAULT NULL,
  `post_modified_date` datetime DEFAULT NULL,
  `comment_count` int(128) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='post table';

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('2', '1', '2016-11-16 14:47:35', '<h1>好好好</h1><div><b>sss<br></b>123456<br><br></div>', 'new file', '0', '1', '12', '2016-11-16 14:47:35', null);
INSERT INTO `post` VALUES ('3', '1', '2016-11-16 15:41:19', '读得多ddddddd<img alt=\"\" src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2128187579,2734329045&amp;fm=58\" title=\"Image: https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2128187579,2734329045&amp;fm=58\">', 'ddddd', '1', '1', '11', '2016-11-16 15:41:19', null);
INSERT INTO `post` VALUES ('4', '1', '2016-11-16 16:04:40', '<blockquote><blockquote><a target=\"_blank\" rel=\"nofollow\">花</a><br><img alt=\"\"><img src=\"data:image/jpeg;base64,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\"><br>6666666<br>是是是是是是是<br><a href=\"http://img1.imgtn.bdimg.com/it/u=1245538184,752165177&amp;fm=21&amp;gp=0.jpg\" target=\"\" rel=\"\" title=\"Link: http://img1.imgtn.bdimg.com/it/u=1245538184,752165177&amp;fm=21&amp;gp=0.jpg\">http://img1.imgtn.bdimg.com/it/u=1245538184,752165177&amp;fm=21&amp;gp=0.jpg</a><br><img alt=\"\" src=\"http://img1.imgtn.bdimg.com/it/u=1245538184,752165177&amp;fm=21&amp;gp=0.jpg\" title=\"Image: http://img1.imgtn.bdimg.com/it/u=1245538184,752165177&amp;fm=21&amp;gp=0.jpg\"><br></blockquote></blockquote>', '66666', '1', '1', '12', '2016-11-16 16:04:40', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `user_email` varchar(64) DEFAULT NULL,
  `user_qq` varchar(16) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `user_status` int(12) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='user table';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '425776024@qq.com', '425776024', '123456', null);

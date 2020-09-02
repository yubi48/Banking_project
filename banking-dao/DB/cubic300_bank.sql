/*
Navicat MySQL Data Transfer

Source Server         : LOCA
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cubic300_bank

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-03-23 19:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer_question_answer_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_question_answer_tbl`;
CREATE TABLE `customer_question_answer_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `userid` varchar(255) NOT NULL,
  `doe` datetime DEFAULT NULL,
  `dom` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdg3ajx7k8dd9lpesbxhtiih61` (`userid`),
  CONSTRAINT `FKdg3ajx7k8dd9lpesbxhtiih61` FOREIGN KEY (`userid`) REFERENCES `user_login_tbl` (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_question_answer_tbl
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_tbl`;
CREATE TABLE `customer_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `father` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image` longblob,
  `job_title` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo_name` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  `doe` datetime DEFAULT NULL,
  `dom` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlji6xcqvy9ayc80syoj41pr8t` (`userid`),
  CONSTRAINT `FKlji6xcqvy9ayc80syoj41pr8t` FOREIGN KEY (`userid`) REFERENCES `user_login_tbl` (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_tbl
-- ----------------------------

-- ----------------------------
-- Table structure for `roles_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `roles_tbl`;
CREATE TABLE `roles_tbl` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of roles_tbl
-- ----------------------------
INSERT INTO `roles_tbl` VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for `user_login_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `user_login_tbl`;
CREATE TABLE `user_login_tbl` (
  `loginid` varchar(255) NOT NULL,
  `llt` datetime DEFAULT NULL,
  `locked` varchar(255) DEFAULT NULL,
  `lwap` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `no_of_attempt` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_expire` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_login_tbl
-- ----------------------------

-- ----------------------------
-- Table structure for `user_roles`
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `rid` int(11) NOT NULL,
  `loginid` varchar(255) NOT NULL,
  PRIMARY KEY (`loginid`,`rid`),
  KEY `FKl9iid9occsp431s68de3q056e` (`rid`),
  CONSTRAINT `FKdggj6erbbsld9rktydn2c78wv` FOREIGN KEY (`loginid`) REFERENCES `user_login_tbl` (`loginid`),
  CONSTRAINT `FKl9iid9occsp431s68de3q056e` FOREIGN KEY (`rid`) REFERENCES `roles_tbl` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_roles
-- ----------------------------

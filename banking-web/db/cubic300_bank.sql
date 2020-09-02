/*
Navicat MySQL Data Transfer

Source Server         : LOCA
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cubic300_bank

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-04-26 21:34:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account_status`
-- ----------------------------
DROP TABLE IF EXISTS `account_status`;
CREATE TABLE `account_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of account_status
-- ----------------------------
INSERT INTO `account_status` VALUES ('1', 'AS01', 'PENDING', 'PENDING');
INSERT INTO `account_status` VALUES ('2', 'AS02', 'PROCESSING', 'PROCESSING');
INSERT INTO `account_status` VALUES ('3', 'AS03', 'DORMANT', 'DORMANT');
INSERT INTO `account_status` VALUES ('4', 'AS04', 'APPROVED', 'APPROVED');
INSERT INTO `account_status` VALUES ('5', 'AS05', 'ACTIVE', 'ACTIVE');

-- ----------------------------
-- Table structure for `account_type`
-- ----------------------------
DROP TABLE IF EXISTS `account_type`;
CREATE TABLE `account_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of account_type
-- ----------------------------
INSERT INTO `account_type` VALUES ('1', 'AC001', 'SAVING', 'SAVING');
INSERT INTO `account_type` VALUES ('2', 'AC002', 'SAVING', 'CURRENT');
INSERT INTO `account_type` VALUES ('3', 'AC003', 'SAVING', 'CORPORATE');
INSERT INTO `account_type` VALUES ('4', 'AC004', 'SAVING', 'CHECKING');

-- ----------------------------
-- Table structure for `customer_question_answer_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_question_answer_tbl`;
CREATE TABLE `customer_question_answer_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `doe` datetime DEFAULT NULL,
  `dom` datetime DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `userid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdg3ajx7k8dd9lpesbxhtiih61` (`userid`),
  CONSTRAINT `FKdg3ajx7k8dd9lpesbxhtiih61` FOREIGN KEY (`userid`) REFERENCES `user_login_tbl` (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_question_answer_tbl
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_saving_enquiry_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_saving_enquiry_tbl`;
CREATE TABLE `customer_saving_enquiry_tbl` (
  `csaid` int(11) NOT NULL AUTO_INCREMENT,
  `appref` varchar(30) DEFAULT NULL,
  `doa` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `acc_type` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `ucrid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`csaid`),
  KEY `FKk0h66b6nud374jpnghy9guo07` (`acc_type`),
  KEY `FKhyffum0o9nond8rr78oc36q4l` (`status`),
  CONSTRAINT `FKhyffum0o9nond8rr78oc36q4l` FOREIGN KEY (`status`) REFERENCES `account_status` (`id`),
  CONSTRAINT `FKk0h66b6nud374jpnghy9guo07` FOREIGN KEY (`acc_type`) REFERENCES `account_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_saving_enquiry_tbl
-- ----------------------------
INSERT INTO `customer_saving_enquiry_tbl` VALUES ('3', 'AS-447758-6NIRP', '2020-03-30 18:48:44', 'synergisticit2020@gmail.com', 'GHAZIABAD', '0938737373', 'Nagendra Kumar', '1', '1', '15850e14e356-5312-4fb0-81df-073560bb77f5608601790');
INSERT INTO `customer_saving_enquiry_tbl` VALUES ('7', 'AS-419592-0JBH7', '2020-04-06 17:46:08', 'javahunk100@gmail.com', 'Fremont', '08700134973', 'javahunk100@gmail.com', '2', '4', '158562afeb35-0ee1-496b-a5a0-1f7d7a61dd06951804778');
INSERT INTO `customer_saving_enquiry_tbl` VALUES ('8', 'AS-956553-HJQYL', '2020-04-06 19:34:33', 'javahunk2020@gmail.com', 'Fremont', '08700134973', 'JavaHunk Technologies', '1', '4', '1586ff7a0796-8a2d-4b3e-957f-835479ef1170216128890');

-- ----------------------------
-- Table structure for `customer_security_questions_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_security_questions_tbl`;
CREATE TABLE `customer_security_questions_tbl` (
  `qid` int(5) DEFAULT NULL,
  `questions` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_security_questions_tbl
-- ----------------------------
INSERT INTO `customer_security_questions_tbl` VALUES ('1', 'What is your birth place?');
INSERT INTO `customer_security_questions_tbl` VALUES ('2', 'What is your mother\'s maiden name?');
INSERT INTO `customer_security_questions_tbl` VALUES ('3', 'What is your favourite author\'s name?');
INSERT INTO `customer_security_questions_tbl` VALUES ('4', 'What is your pet name?');
INSERT INTO `customer_security_questions_tbl` VALUES ('5', 'What is your favourite soccer team?');
INSERT INTO `customer_security_questions_tbl` VALUES ('6', 'What is the name of your childhood hero?');
INSERT INTO `customer_security_questions_tbl` VALUES ('7', 'What is your father\'s middle name?');
INSERT INTO `customer_security_questions_tbl` VALUES ('8', 'What is the name of your first crush?');
INSERT INTO `customer_security_questions_tbl` VALUES ('9', 'What was the name of your first school?');
INSERT INTO `customer_security_questions_tbl` VALUES ('10', 'What is your favourite vacation spot?');

-- ----------------------------
-- Table structure for `customer_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_tbl`;
CREATE TABLE `customer_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `doe` datetime DEFAULT NULL,
  `dom` datetime DEFAULT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FKlji6xcqvy9ayc80syoj41pr8t` (`userid`),
  CONSTRAINT `FKlji6xcqvy9ayc80syoj41pr8t` FOREIGN KEY (`userid`) REFERENCES `user_login_tbl` (`loginid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_tbl
-- ----------------------------
INSERT INTO `customer_tbl` VALUES ('2', 'Fremont', '0', '2016-10-03', null, null, 'javahunk100@gmail.com', 'NA', 'Male', null, 'CONSULTANT', '08700134973', 'javahunk100@gmail.com', null, 'B.TECH', '92982828', 'javahunk100@gmail.com');
INSERT INTO `customer_tbl` VALUES ('3', 'Fremont', '0', '12-03-2020', '2020-04-06 17:51:40', '2020-04-06 17:51:40', 'javatech1000@gmail.com', 'Mr. Jack', 'Male', null, 'Bank Employee', '320432043', 'James Robert', null, 'NA', '23432', 'javatech1000@gmail.com');
INSERT INTO `customer_tbl` VALUES ('4', 'Fremont', '0', '03-03-2019', null, null, 'javahunk2020@gmail.com', 'Mr .JK', 'Male', null, 'CASHIER', '08700134973', 'JavaHunk Technologies', null, 'B.TECH', '42324234', 'javahunk2020@gmail.com');

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for `persons_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `persons_tbl`;
CREATE TABLE `persons_tbl` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(100) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `mobile` bigint(15) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `ssn` int(11) DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT NULL,
  `updatedate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`pid`,`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of persons_tbl
-- ----------------------------
INSERT INTO `persons_tbl` VALUES ('1', 'javahunk', 'Nagendra', 'javahunk100@gmail.com', '2020-04-20', '9873003702', '33433', '34535', '2020-04-20 09:40:26', '2020-04-20 09:40:26');

-- ----------------------------
-- Table structure for `raw_report`
-- ----------------------------
DROP TABLE IF EXISTS `raw_report`;
CREATE TABLE `raw_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` varchar(100) DEFAULT NULL,
  `IMPRESSIONS` varchar(200) DEFAULT NULL,
  `CLICKS` varchar(200) DEFAULT NULL,
  `EARNING` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of raw_report
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of roles_tbl
-- ----------------------------
INSERT INTO `roles_tbl` VALUES ('1', 'ADMIN', 'ADMIN');
INSERT INTO `roles_tbl` VALUES ('2', 'EMPLOYEE', 'EMPLOYEE');
INSERT INTO `roles_tbl` VALUES ('3', 'CUSTOMER', 'CUSTOMER');
INSERT INTO `roles_tbl` VALUES ('4', 'MANAGER', 'MANAGER');

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
INSERT INTO `user_login_tbl` VALUES ('javahunk100@gmail.com', null, 'no', null, 'javahunk100@gmail.com', '3', '$2a$10$5sjjfIqI0aepur.fMcZvvusbroZTv8mK80x62ifng50f6RfXOS03O', null, null);
INSERT INTO `user_login_tbl` VALUES ('javahunk2020@gmail.com', null, 'no', null, 'JavaHunk Technologies', '3', '$2a$10$5sjjfIqI0aepur.fMcZvvusbroZTv8mK80x62ifng50f6RfXOS03O', null, null);
INSERT INTO `user_login_tbl` VALUES ('javatech1000@gmail.com', null, 'no', null, 'James Robert', '3', '$2a$10$5sjjfIqI0aepur.fMcZvvusbroZTv8mK80x62ifng50f6RfXOS03O', null, '2230303');
INSERT INTO `user_login_tbl` VALUES ('mockcj@gmaill.com', '2020-04-20 09:34:34', 'no', '2020-04-20 09:34:09', 'Nagendra', '2', 'wer', '2020-04-20 09:35:10', null);

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
INSERT INTO `user_roles` VALUES ('2', 'javatech1000@gmail.com');
INSERT INTO `user_roles` VALUES ('3', 'javahunk100@gmail.com');
INSERT INTO `user_roles` VALUES ('3', 'javahunk2020@gmail.com');

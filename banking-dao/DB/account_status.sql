/*
Navicat MySQL Data Transfer

Source Server         : LOCA
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cubic300_bank

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-03-25 17:48:24
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
INSERT INTO `account_type` VALUES ('2', 'AC002', 'CURRENT', 'CURRENT');
INSERT INTO `account_type` VALUES ('3', 'AC003', 'CORPORATE', 'CORPORATE');
INSERT INTO `account_type` VALUES ('4', 'AC004', 'CHECKING', 'CHECKING');

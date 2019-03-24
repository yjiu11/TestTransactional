/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : transactional

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-03-24 14:53:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

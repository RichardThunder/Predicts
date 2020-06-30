/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : db_lottery

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2016-07-25 10:45:31
*/
CREATE DATABASE db_lottery;
USE db_lottery;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_forecast`
-- ----------------------------
DROP TABLE IF EXISTS `tb_forecast`;
CREATE TABLE `tb_forecast` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `a` char(1) NOT NULL,
  `b` char(1) NOT NULL,
  `c` char(1) NOT NULL,
  `d` char(1) NOT NULL,
  `e` char(1) NOT NULL,
  `f` char(1) NOT NULL,
  `g` char(1) NOT NULL,
  `forecasttime` varchar(45) NOT NULL,
  `neutron` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_forecast
-- ----------------------------
INSERT INTO `tb_forecast` VALUES ('1', '10131', '7', '9', '4', '4', '6', '1', '2', '2011-05-24', '5');
INSERT INTO `tb_forecast` VALUES ('2', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('3', '10131', '7', '9', '4', '4', '6', '1', '2', '2011-05-24', '5');
INSERT INTO `tb_forecast` VALUES ('4', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('5', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('6', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('7', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('8', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('9', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('10', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('11', '10131', '7', '9', '4', '4', '6', '1', '9', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('12', '10131', '2', '5', '3', '5', '5', '7', '8', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('13', '10131', '5', '4', '7', '5', '5', '2', '6', '2011-05-24', '0');
INSERT INTO `tb_forecast` VALUES ('14', '11060', '1', '2', '3', '4', '5', '6', '7', '2011-05-26', '5000000');
INSERT INTO `tb_forecast` VALUES ('15', '11060', '1', '2', '3', '4', '5', '6', '1', '2011-05-26', '50000');
INSERT INTO `tb_forecast` VALUES ('16', '11060', '1', '2', '3', '4', '5', '1', '1', '2011-05-26', '1800');
INSERT INTO `tb_forecast` VALUES ('17', '11060', '1', '2', '3', '4', '1', '1', '1', '2011-05-26', '300');
INSERT INTO `tb_forecast` VALUES ('18', '11060', '1', '2', '3', '1', '1', '1', '1', '2011-05-26', '20');
INSERT INTO `tb_forecast` VALUES ('19', '11060', '1', '2', '1', '1', '1', '1', '1', '2011-05-26', '5');
INSERT INTO `tb_forecast` VALUES ('20', '11060', '1', '1', '1', '1', '1', '1', '1', '2011-05-26', '0');
INSERT INTO `tb_forecast` VALUES ('21', '11061', '8', '6', '6', '4', '6', '7', '5', '2011-05-27', '50000');
INSERT INTO `tb_forecast` VALUES ('22', '11065', '4', '8', '6', '4', '0', '6', '7', '2011-05-28', null);
INSERT INTO `tb_forecast` VALUES ('23', '11065', '1', '4', '6', '3', '3', '3', '9', '2011-05-28', null);
INSERT INTO `tb_forecast` VALUES ('24', '11065', '1', '4', '7', '9', '9', '9', '0', '2016-07-22', null);
INSERT INTO `tb_forecast` VALUES ('25', '11109', '4', '8', '9', '0', '0', '8', '0', '2016-07-25', null);
INSERT INTO `tb_forecast` VALUES ('26', '11109', '4', '8', '9', '0', '0', '8', '0', '2016-07-25', null);

-- ----------------------------
-- Table structure for `tb_history`
-- ----------------------------
DROP TABLE IF EXISTS `tb_history`;
CREATE TABLE `tb_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `a` char(1) NOT NULL,
  `b` char(1) NOT NULL,
  `c` char(1) NOT NULL,
  `d` char(1) NOT NULL,
  `e` char(1) NOT NULL,
  `f` char(1) NOT NULL,
  `g` char(1) NOT NULL,
  `historytime` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=416 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_history
-- ----------------------------
INSERT INTO `tb_history` VALUES ('139', '11059', '4', '4', '2', '0', '5', '7', '2', '2011-05-24');
INSERT INTO `tb_history` VALUES ('140', '11058', '4', '3', '5', '9', '0', '1', '2', '2011-05-22');
INSERT INTO `tb_history` VALUES ('141', '11057', '5', '1', '8', '8', '5', '1', '6', '2011-05-20');
INSERT INTO `tb_history` VALUES ('142', '11056', '9', '4', '5', '6', '5', '0', '5', '2011-05-17');
INSERT INTO `tb_history` VALUES ('143', '11055', '7', '5', '8', '0', '8', '1', '2', '2011-05-15');
INSERT INTO `tb_history` VALUES ('144', '11054', '9', '4', '0', '9', '3', '4', '3', '2011-05-13');
INSERT INTO `tb_history` VALUES ('145', '11053', '6', '2', '4', '4', '6', '9', '2', '2011-05-10');
INSERT INTO `tb_history` VALUES ('146', '11052', '7', '7', '0', '8', '5', '3', '3', '2011-05-08');
INSERT INTO `tb_history` VALUES ('147', '11051', '3', '2', '7', '7', '4', '0', '1', '2011-05-06');
INSERT INTO `tb_history` VALUES ('148', '11050', '2', '1', '9', '3', '5', '6', '0', '2011-05-03');
INSERT INTO `tb_history` VALUES ('149', '11049', '1', '4', '5', '8', '1', '8', '9', '2011-05-01');
INSERT INTO `tb_history` VALUES ('150', '11048', '0', '0', '5', '7', '6', '8', '9', '2011-04-29');
INSERT INTO `tb_history` VALUES ('151', '11047', '7', '9', '1', '2', '2', '9', '5', '2011-04-26');
INSERT INTO `tb_history` VALUES ('152', '11046', '1', '1', '6', '3', '8', '4', '7', '2011-04-24');
INSERT INTO `tb_history` VALUES ('153', '11045', '0', '8', '8', '9', '3', '9', '9', '2011-04-22');
INSERT INTO `tb_history` VALUES ('154', '11044', '6', '6', '3', '5', '8', '4', '6', '2011-04-19');
INSERT INTO `tb_history` VALUES ('155', '11043', '6', '6', '8', '9', '7', '2', '0', '2011-04-17');
INSERT INTO `tb_history` VALUES ('156', '11042', '4', '7', '6', '1', '3', '6', '2', '2011-04-15');
INSERT INTO `tb_history` VALUES ('157', '11041', '6', '6', '6', '9', '3', '6', '6', '2011-04-12');
INSERT INTO `tb_history` VALUES ('158', '11040', '3', '8', '8', '8', '7', '5', '7', '2011-04-10');
INSERT INTO `tb_history` VALUES ('159', '11039', '9', '6', '2', '7', '7', '3', '1', '2011-04-08');
INSERT INTO `tb_history` VALUES ('160', '11038', '0', '1', '2', '4', '7', '4', '5', '2011-04-05');
INSERT INTO `tb_history` VALUES ('161', '11037', '8', '5', '5', '6', '9', '4', '6', '2011-04-03');
INSERT INTO `tb_history` VALUES ('162', '11036', '3', '6', '8', '4', '6', '2', '7', '2011-04-01');
INSERT INTO `tb_history` VALUES ('163', '11035', '2', '7', '4', '8', '7', '7', '2', '2011-03-29');
INSERT INTO `tb_history` VALUES ('164', '11034', '6', '4', '9', '8', '9', '6', '2', '2011-03-27');
INSERT INTO `tb_history` VALUES ('165', '11033', '2', '0', '5', '2', '5', '3', '6', '2011-03-25');
INSERT INTO `tb_history` VALUES ('166', '11032', '2', '0', '8', '1', '6', '3', '2', '2011-03-22');
INSERT INTO `tb_history` VALUES ('167', '11031', '7', '6', '4', '1', '7', '3', '5', '2011-03-20');
INSERT INTO `tb_history` VALUES ('168', '11030', '4', '4', '5', '2', '9', '3', '3', '2011-03-18');
INSERT INTO `tb_history` VALUES ('169', '11029', '1', '6', '4', '0', '0', '0', '2', '2011-03-15');
INSERT INTO `tb_history` VALUES ('170', '11028', '5', '2', '3', '5', '8', '2', '5', '2011-03-13');
INSERT INTO `tb_history` VALUES ('171', '11027', '8', '6', '2', '3', '2', '3', '7', '2011-03-11');
INSERT INTO `tb_history` VALUES ('172', '11026', '2', '0', '5', '8', '3', '6', '5', '2011-03-08');
INSERT INTO `tb_history` VALUES ('173', '11025', '8', '9', '2', '7', '7', '5', '3', '2011-03-06');
INSERT INTO `tb_history` VALUES ('174', '11024', '9', '3', '7', '7', '3', '7', '0', '2011-03-04');
INSERT INTO `tb_history` VALUES ('175', '11023', '7', '4', '0', '3', '5', '9', '1', '2011-03-01');
INSERT INTO `tb_history` VALUES ('176', '11022', '7', '5', '3', '2', '0', '0', '6', '2011-02-27');
INSERT INTO `tb_history` VALUES ('177', '11021', '6', '0', '7', '2', '0', '7', '0', '2011-02-25');
INSERT INTO `tb_history` VALUES ('178', '11020', '7', '2', '5', '0', '2', '6', '1', '2011-02-22');
INSERT INTO `tb_history` VALUES ('179', '11019', '6', '0', '8', '8', '9', '9', '4', '2011-02-20');
INSERT INTO `tb_history` VALUES ('180', '11018', '6', '2', '4', '5', '3', '6', '1', '2011-02-18');
INSERT INTO `tb_history` VALUES ('181', '11017', '7', '2', '5', '9', '2', '6', '3', '2011-02-15');
INSERT INTO `tb_history` VALUES ('182', '11016', '5', '3', '5', '9', '7', '9', '3', '2011-02-13');
INSERT INTO `tb_history` VALUES ('183', '11015', '5', '0', '1', '2', '1', '1', '3', '2011-02-11');
INSERT INTO `tb_history` VALUES ('184', '11014', '3', '4', '4', '0', '2', '8', '8', '2011-02-01');
INSERT INTO `tb_history` VALUES ('185', '11013', '5', '9', '8', '8', '4', '2', '2', '2011-01-30');
INSERT INTO `tb_history` VALUES ('186', '11012', '4', '7', '4', '4', '5', '0', '0', '2011-01-28');
INSERT INTO `tb_history` VALUES ('187', '11011', '0', '0', '6', '6', '3', '6', '6', '2011-01-25');
INSERT INTO `tb_history` VALUES ('188', '11010', '1', '3', '6', '3', '3', '7', '8', '2011-01-23');
INSERT INTO `tb_history` VALUES ('189', '10113', '5', '7', '3', '7', '6', '9', '9', '2010-09-26');
INSERT INTO `tb_history` VALUES ('190', '10112', '1', '8', '4', '4', '9', '5', '2', '2010-09-24');
INSERT INTO `tb_history` VALUES ('191', '10111', '7', '0', '4', '6', '0', '7', '7', '2010-09-21');
INSERT INTO `tb_history` VALUES ('192', '10110', '5', '4', '4', '2', '4', '0', '4', '2010-09-19');
INSERT INTO `tb_history` VALUES ('193', '10109', '5', '3', '2', '0', '7', '7', '0', '2010-09-17');
INSERT INTO `tb_history` VALUES ('194', '10108', '6', '4', '6', '5', '4', '9', '0', '2010-09-14');
INSERT INTO `tb_history` VALUES ('195', '10107', '2', '5', '9', '4', '4', '4', '8', '2010-09-12');
INSERT INTO `tb_history` VALUES ('196', '10106', '9', '3', '8', '2', '1', '9', '4', '2010-09-10');
INSERT INTO `tb_history` VALUES ('197', '10105', '7', '7', '6', '0', '9', '9', '9', '2010-09-07');
INSERT INTO `tb_history` VALUES ('198', '10104', '5', '5', '3', '1', '9', '7', '9', '2010-09-05');
INSERT INTO `tb_history` VALUES ('199', '10103', '0', '7', '2', '9', '6', '0', '3', '2010-09-03');
INSERT INTO `tb_history` VALUES ('200', '10102', '7', '5', '4', '0', '6', '6', '2', '2010-08-31');
INSERT INTO `tb_history` VALUES ('201', '10101', '3', '7', '5', '9', '1', '8', '8', '2010-08-29');
INSERT INTO `tb_history` VALUES ('202', '10100', '5', '5', '6', '6', '7', '4', '0', '2010-08-27');
INSERT INTO `tb_history` VALUES ('203', '10099', '2', '7', '7', '7', '9', '2', '8', '2010-08-24');
INSERT INTO `tb_history` VALUES ('204', '11009', '1', '1', '0', '7', '5', '3', '0', '2011-01-21');
INSERT INTO `tb_history` VALUES ('205', '11008', '8', '3', '6', '6', '6', '7', '0', '2011-01-18');
INSERT INTO `tb_history` VALUES ('206', '11007', '3', '4', '9', '8', '5', '5', '3', '2011-01-16');
INSERT INTO `tb_history` VALUES ('207', '11006', '1', '6', '5', '0', '9', '5', '7', '2011-01-14');
INSERT INTO `tb_history` VALUES ('208', '11005', '2', '9', '6', '9', '6', '4', '5', '2011-01-11');
INSERT INTO `tb_history` VALUES ('209', '11004', '3', '6', '0', '4', '1', '6', '6', '2011-01-09');
INSERT INTO `tb_history` VALUES ('210', '11003', '9', '0', '9', '8', '0', '9', '3', '2011-01-07');
INSERT INTO `tb_history` VALUES ('211', '11002', '0', '1', '5', '0', '6', '5', '0', '2011-01-04');
INSERT INTO `tb_history` VALUES ('212', '11001', '9', '8', '4', '5', '8', '5', '4', '2011-01-02');
INSERT INTO `tb_history` VALUES ('213', '10154', '5', '2', '5', '2', '9', '7', '4', '2010-12-31');
INSERT INTO `tb_history` VALUES ('214', '10153', '5', '8', '6', '9', '3', '6', '7', '2010-12-28');
INSERT INTO `tb_history` VALUES ('215', '10152', '6', '8', '4', '2', '0', '1', '5', '2010-12-26');
INSERT INTO `tb_history` VALUES ('216', '10151', '5', '2', '9', '5', '7', '6', '7', '2010-12-24');
INSERT INTO `tb_history` VALUES ('217', '10150', '7', '6', '7', '4', '2', '1', '3', '2010-12-21');
INSERT INTO `tb_history` VALUES ('218', '10149', '9', '2', '5', '7', '4', '8', '5', '2010-12-19');
INSERT INTO `tb_history` VALUES ('219', '10148', '1', '8', '6', '5', '0', '5', '5', '2010-12-17');
INSERT INTO `tb_history` VALUES ('220', '10147', '2', '1', '1', '0', '8', '7', '3', '2010-12-14');
INSERT INTO `tb_history` VALUES ('221', '10146', '1', '1', '6', '8', '2', '0', '1', '2010-12-12');
INSERT INTO `tb_history` VALUES ('222', '10145', '5', '3', '0', '3', '2', '9', '7', '2010-12-10');
INSERT INTO `tb_history` VALUES ('223', '10144', '0', '7', '8', '4', '2', '0', '5', '2010-12-07');
INSERT INTO `tb_history` VALUES ('224', '10143', '0', '5', '7', '8', '6', '8', '4', '2010-12-05');
INSERT INTO `tb_history` VALUES ('225', '10142', '1', '9', '4', '3', '7', '4', '6', '2010-12-03');
INSERT INTO `tb_history` VALUES ('226', '10141', '1', '8', '5', '8', '5', '8', '3', '2010-11-30');
INSERT INTO `tb_history` VALUES ('227', '10140', '2', '6', '6', '3', '3', '0', '9', '2010-11-28');
INSERT INTO `tb_history` VALUES ('228', '10139', '0', '9', '8', '7', '2', '6', '5', '2010-11-26');
INSERT INTO `tb_history` VALUES ('229', '10138', '9', '6', '2', '7', '6', '8', '8', '2010-11-23');
INSERT INTO `tb_history` VALUES ('230', '10137', '7', '7', '7', '7', '0', '7', '7', '2010-11-21');
INSERT INTO `tb_history` VALUES ('231', '10136', '1', '3', '3', '4', '7', '3', '1', '2010-11-19');
INSERT INTO `tb_history` VALUES ('232', '10135', '1', '9', '0', '0', '8', '4', '1', '2010-11-16');
INSERT INTO `tb_history` VALUES ('233', '10134', '6', '7', '9', '9', '4', '3', '6', '2010-11-14');
INSERT INTO `tb_history` VALUES ('234', '10133', '9', '8', '9', '4', '4', '6', '8', '2010-11-12');
INSERT INTO `tb_history` VALUES ('235', '10132', '7', '6', '5', '8', '3', '3', '8', '2010-11-09');
INSERT INTO `tb_history` VALUES ('236', '10131', '2', '7', '6', '0', '2', '1', '2', '2010-11-07');
INSERT INTO `tb_history` VALUES ('237', '10130', '6', '6', '7', '4', '5', '2', '1', '2010-11-05');
INSERT INTO `tb_history` VALUES ('238', '10129', '3', '1', '4', '8', '9', '9', '8', '2010-11-02');
INSERT INTO `tb_history` VALUES ('239', '10128', '9', '7', '4', '0', '6', '1', '1', '2010-10-31');
INSERT INTO `tb_history` VALUES ('240', '10127', '6', '4', '8', '2', '5', '7', '4', '2010-10-29');
INSERT INTO `tb_history` VALUES ('241', '10126', '3', '9', '6', '6', '0', '2', '4', '2010-10-26');
INSERT INTO `tb_history` VALUES ('242', '10125', '5', '8', '2', '2', '1', '4', '6', '2010-10-24');
INSERT INTO `tb_history` VALUES ('243', '10124', '9', '9', '7', '7', '0', '3', '0', '2010-10-22');
INSERT INTO `tb_history` VALUES ('244', '10123', '3', '8', '6', '9', '6', '9', '7', '2010-10-19');
INSERT INTO `tb_history` VALUES ('245', '10122', '0', '2', '7', '7', '8', '3', '4', '2010-10-17');
INSERT INTO `tb_history` VALUES ('246', '10121', '4', '1', '3', '0', '7', '3', '5', '2010-10-15');
INSERT INTO `tb_history` VALUES ('247', '10120', '2', '1', '9', '6', '7', '5', '2', '2010-10-12');
INSERT INTO `tb_history` VALUES ('248', '10119', '5', '1', '5', '2', '6', '5', '7', '2010-10-10');
INSERT INTO `tb_history` VALUES ('249', '10118', '3', '6', '5', '3', '8', '0', '4', '2010-10-08');
INSERT INTO `tb_history` VALUES ('250', '10117', '4', '5', '3', '9', '1', '9', '7', '2010-10-05');
INSERT INTO `tb_history` VALUES ('251', '10116', '9', '3', '7', '0', '4', '3', '0', '2010-10-03');
INSERT INTO `tb_history` VALUES ('252', '10115', '2', '0', '8', '7', '3', '9', '3', '2010-10-01');
INSERT INTO `tb_history` VALUES ('253', '10114', '9', '6', '6', '3', '5', '5', '4', '2010-09-28');
INSERT INTO `tb_history` VALUES ('254', '10098', '5', '6', '6', '7', '5', '7', '9', '2010-08-22');
INSERT INTO `tb_history` VALUES ('255', '10097', '3', '4', '9', '0', '6', '7', '1', '2010-08-20');
INSERT INTO `tb_history` VALUES ('256', '10096', '5', '0', '6', '8', '8', '6', '4', '2010-08-17');
INSERT INTO `tb_history` VALUES ('257', '10095', '8', '3', '8', '7', '8', '5', '8', '2010-08-15');
INSERT INTO `tb_history` VALUES ('258', '10094', '5', '5', '6', '4', '6', '1', '3', '2010-08-13');
INSERT INTO `tb_history` VALUES ('259', '10093', '4', '6', '1', '6', '3', '6', '3', '2010-08-10');
INSERT INTO `tb_history` VALUES ('260', '10092', '1', '1', '9', '9', '1', '0', '2', '2010-08-08');
INSERT INTO `tb_history` VALUES ('261', '10091', '6', '7', '2', '6', '0', '0', '2', '2010-08-06');
INSERT INTO `tb_history` VALUES ('262', '10090', '5', '6', '1', '8', '4', '6', '6', '2010-08-03');
INSERT INTO `tb_history` VALUES ('263', '10089', '9', '1', '8', '8', '6', '3', '1', '2010-08-01');
INSERT INTO `tb_history` VALUES ('264', '10088', '4', '4', '3', '4', '7', '2', '5', '2010-07-30');
INSERT INTO `tb_history` VALUES ('265', '10087', '0', '6', '5', '5', '8', '8', '1', '2010-07-27');
INSERT INTO `tb_history` VALUES ('266', '10086', '5', '4', '5', '7', '8', '7', '4', '2010-07-25');
INSERT INTO `tb_history` VALUES ('267', '10085', '7', '9', '1', '4', '0', '7', '0', '2010-07-23');
INSERT INTO `tb_history` VALUES ('268', '10084', '8', '0', '1', '6', '5', '3', '2', '2010-07-20');
INSERT INTO `tb_history` VALUES ('269', '10083', '6', '0', '4', '0', '3', '3', '0', '2010-07-18');
INSERT INTO `tb_history` VALUES ('270', '10082', '5', '7', '2', '6', '3', '1', '6', '2010-07-16');
INSERT INTO `tb_history` VALUES ('271', '10081', '0', '1', '7', '6', '2', '3', '1', '2010-07-13');
INSERT INTO `tb_history` VALUES ('272', '10080', '1', '1', '1', '1', '5', '7', '1', '2010-07-11');
INSERT INTO `tb_history` VALUES ('273', '10079', '3', '9', '2', '4', '2', '5', '6', '2010-07-09');
INSERT INTO `tb_history` VALUES ('274', '10078', '1', '7', '8', '1', '1', '8', '9', '2010-07-06');
INSERT INTO `tb_history` VALUES ('275', '10077', '3', '3', '4', '4', '3', '8', '0', '2010-07-04');
INSERT INTO `tb_history` VALUES ('276', '10076', '8', '0', '3', '2', '2', '9', '3', '2010-07-02');
INSERT INTO `tb_history` VALUES ('277', '10075', '8', '6', '2', '2', '3', '3', '0', '2010-06-29');
INSERT INTO `tb_history` VALUES ('278', '10074', '3', '8', '2', '3', '4', '2', '7', '2010-06-27');
INSERT INTO `tb_history` VALUES ('279', '10073', '6', '5', '2', '1', '7', '3', '4', '2010-06-25');
INSERT INTO `tb_history` VALUES ('280', '10072', '3', '1', '6', '5', '3', '8', '1', '2010-06-22');
INSERT INTO `tb_history` VALUES ('281', '10071', '4', '8', '4', '1', '6', '0', '5', '2010-06-20');
INSERT INTO `tb_history` VALUES ('282', '10070', '9', '5', '8', '4', '1', '1', '5', '2010-06-18');
INSERT INTO `tb_history` VALUES ('283', '10069', '1', '5', '1', '4', '1', '0', '9', '2010-06-15');
INSERT INTO `tb_history` VALUES ('284', '10068', '9', '0', '7', '7', '1', '9', '5', '2010-06-13');
INSERT INTO `tb_history` VALUES ('285', '10067', '8', '0', '1', '7', '4', '2', '2', '2010-06-11');
INSERT INTO `tb_history` VALUES ('286', '10066', '8', '9', '9', '0', '9', '3', '6', '2010-06-08');
INSERT INTO `tb_history` VALUES ('287', '10065', '5', '5', '0', '9', '8', '9', '3', '2010-06-06');
INSERT INTO `tb_history` VALUES ('288', '10064', '0', '0', '7', '5', '2', '2', '0', '2010-06-04');
INSERT INTO `tb_history` VALUES ('289', '10063', '5', '8', '8', '5', '4', '0', '6', '2010-06-01');
INSERT INTO `tb_history` VALUES ('290', '10062', '4', '9', '2', '2', '6', '0', '7', '2010-05-30');
INSERT INTO `tb_history` VALUES ('291', '10061', '6', '5', '4', '0', '7', '2', '4', '2010-05-28');
INSERT INTO `tb_history` VALUES ('292', '10060', '0', '6', '5', '3', '1', '8', '9', '2010-05-25');
INSERT INTO `tb_history` VALUES ('293', '10059', '8', '4', '1', '5', '7', '3', '6', '2010-05-23');
INSERT INTO `tb_history` VALUES ('294', '10058', '8', '0', '8', '6', '7', '1', '9', '2010-05-21');
INSERT INTO `tb_history` VALUES ('295', '10057', '1', '5', '7', '4', '1', '4', '3', '2010-05-18');
INSERT INTO `tb_history` VALUES ('296', '10056', '8', '1', '9', '5', '3', '9', '4', '2010-05-16');
INSERT INTO `tb_history` VALUES ('297', '10055', '3', '4', '6', '1', '2', '2', '9', '2010-05-14');
INSERT INTO `tb_history` VALUES ('298', '10054', '4', '0', '3', '6', '5', '1', '6', '2010-05-11');
INSERT INTO `tb_history` VALUES ('299', '10053', '9', '5', '0', '7', '2', '5', '3', '2010-05-09');
INSERT INTO `tb_history` VALUES ('300', '10052', '8', '0', '3', '9', '2', '2', '2', '2010-05-07');
INSERT INTO `tb_history` VALUES ('301', '10051', '7', '5', '4', '7', '8', '9', '5', '2010-05-04');
INSERT INTO `tb_history` VALUES ('302', '10050', '6', '3', '8', '7', '8', '2', '3', '2010-05-02');
INSERT INTO `tb_history` VALUES ('303', '10049', '5', '4', '6', '4', '8', '3', '7', '2010-04-30');
INSERT INTO `tb_history` VALUES ('304', '10048', '6', '7', '7', '4', '6', '4', '6', '2010-04-27');
INSERT INTO `tb_history` VALUES ('305', '10047', '0', '3', '1', '6', '6', '5', '5', '2010-04-25');
INSERT INTO `tb_history` VALUES ('306', '10046', '4', '1', '3', '1', '2', '4', '0', '2010-04-23');
INSERT INTO `tb_history` VALUES ('307', '10045', '8', '7', '2', '0', '0', '1', '3', '2010-04-20');
INSERT INTO `tb_history` VALUES ('308', '10044', '1', '4', '2', '5', '6', '6', '6', '2010-04-18');
INSERT INTO `tb_history` VALUES ('309', '10043', '6', '8', '2', '2', '6', '6', '5', '2010-04-16');
INSERT INTO `tb_history` VALUES ('310', '10042', '8', '3', '2', '1', '9', '4', '9', '2010-04-13');
INSERT INTO `tb_history` VALUES ('311', '10041', '6', '6', '7', '7', '3', '0', '6', '2010-04-11');
INSERT INTO `tb_history` VALUES ('312', '10040', '8', '5', '9', '4', '1', '0', '4', '2010-04-09');
INSERT INTO `tb_history` VALUES ('313', '10039', '3', '1', '0', '8', '7', '8', '0', '2010-04-06');
INSERT INTO `tb_history` VALUES ('314', '10038', '8', '7', '1', '8', '1', '2', '7', '2010-04-04');
INSERT INTO `tb_history` VALUES ('315', '10037', '4', '9', '6', '7', '3', '4', '7', '2010-04-02');
INSERT INTO `tb_history` VALUES ('316', '10036', '3', '7', '9', '3', '7', '4', '4', '2010-03-30');
INSERT INTO `tb_history` VALUES ('317', '10035', '9', '8', '9', '5', '7', '6', '9', '2010-03-28');
INSERT INTO `tb_history` VALUES ('318', '10034', '3', '3', '8', '1', '4', '0', '3', '2010-03-26');
INSERT INTO `tb_history` VALUES ('319', '10033', '9', '1', '5', '5', '0', '2', '0', '2010-03-23');
INSERT INTO `tb_history` VALUES ('320', '10032', '9', '2', '8', '7', '7', '2', '7', '2010-03-21');
INSERT INTO `tb_history` VALUES ('321', '10031', '4', '8', '5', '0', '9', '2', '8', '2010-03-19');
INSERT INTO `tb_history` VALUES ('322', '10030', '7', '6', '9', '5', '8', '9', '0', '2010-03-16');
INSERT INTO `tb_history` VALUES ('323', '10029', '7', '6', '6', '8', '3', '8', '3', '2010-03-14');
INSERT INTO `tb_history` VALUES ('324', '10028', '5', '1', '7', '0', '6', '9', '9', '2010-03-12');
INSERT INTO `tb_history` VALUES ('325', '10027', '0', '9', '4', '7', '2', '3', '8', '2010-03-09');
INSERT INTO `tb_history` VALUES ('326', '10026', '6', '5', '8', '8', '1', '0', '6', '2010-03-07');
INSERT INTO `tb_history` VALUES ('327', '10025', '4', '4', '4', '2', '0', '6', '5', '2010-03-05');
INSERT INTO `tb_history` VALUES ('328', '10024', '9', '6', '6', '7', '9', '5', '8', '2010-03-02');
INSERT INTO `tb_history` VALUES ('329', '10023', '4', '4', '8', '3', '7', '4', '3', '2010-02-28');
INSERT INTO `tb_history` VALUES ('330', '10022', '9', '8', '0', '5', '7', '9', '4', '2010-02-26');
INSERT INTO `tb_history` VALUES ('331', '10021', '9', '5', '4', '2', '2', '4', '4', '2010-02-23');
INSERT INTO `tb_history` VALUES ('332', '10020', '9', '6', '0', '8', '0', '8', '8', '2010-02-21');
INSERT INTO `tb_history` VALUES ('333', '10019', '7', '7', '7', '9', '2', '6', '9', '2010-02-12');
INSERT INTO `tb_history` VALUES ('334', '10018', '0', '0', '6', '2', '6', '2', '5', '2010-02-09');
INSERT INTO `tb_history` VALUES ('335', '10017', '9', '1', '3', '2', '2', '6', '8', '2010-02-07');
INSERT INTO `tb_history` VALUES ('336', '10016', '6', '6', '6', '9', '5', '1', '7', '2010-02-05');
INSERT INTO `tb_history` VALUES ('337', '10015', '2', '5', '2', '2', '1', '3', '9', '2010-02-02');
INSERT INTO `tb_history` VALUES ('338', '10014', '2', '5', '0', '9', '1', '0', '6', '2010-01-31');
INSERT INTO `tb_history` VALUES ('339', '10013', '9', '5', '5', '7', '7', '2', '0', '2010-01-29');
INSERT INTO `tb_history` VALUES ('340', '10012', '5', '1', '6', '1', '3', '3', '5', '2010-01-26');
INSERT INTO `tb_history` VALUES ('341', '10011', '8', '8', '7', '2', '1', '9', '5', '2010-01-24');
INSERT INTO `tb_history` VALUES ('342', '10010', '3', '3', '0', '5', '6', '8', '8', '2010-01-22');
INSERT INTO `tb_history` VALUES ('343', '10009', '6', '1', '4', '9', '7', '0', '2', '2010-01-19');
INSERT INTO `tb_history` VALUES ('344', '10008', '5', '2', '8', '5', '3', '9', '1', '2010-01-17');
INSERT INTO `tb_history` VALUES ('345', '10007', '7', '0', '5', '8', '3', '4', '7', '2010-01-15');
INSERT INTO `tb_history` VALUES ('346', '10006', '1', '6', '4', '3', '9', '9', '0', '2010-01-12');
INSERT INTO `tb_history` VALUES ('347', '10005', '3', '5', '0', '1', '1', '5', '8', '2010-01-10');
INSERT INTO `tb_history` VALUES ('348', '10004', '4', '0', '6', '0', '9', '1', '0', '2010-01-08');
INSERT INTO `tb_history` VALUES ('349', '10003', '1', '4', '5', '6', '7', '8', '0', '2010-01-05');
INSERT INTO `tb_history` VALUES ('350', '10002', '3', '9', '8', '5', '5', '0', '4', '2010-01-03');
INSERT INTO `tb_history` VALUES ('351', '10001', '2', '9', '0', '1', '4', '4', '4', '2010-01-01');
INSERT INTO `tb_history` VALUES ('352', '11060', '1', '2', '3', '4', '5', '6', '7', '2011-05-26');
INSERT INTO `tb_history` VALUES ('353', '11061', '8', '6', '6', '4', '6', '7', '4', '2011-05-21');
INSERT INTO `tb_history` VALUES ('354', '11062', '1', '2', '3', '4', '5', '6', '7', '2011-05-26');
INSERT INTO `tb_history` VALUES ('355', '11063', '1', '1', '1', '1', '1', '1', '1', '2011-50-21');
INSERT INTO `tb_history` VALUES ('356', '11064', '1', '2', '2', '2', '2', '2', '2', '2001-11-11');
INSERT INTO `tb_history` VALUES ('398', '11108', '5', '6', '6', '6', '0', '4', '3', '2016-07-19');
INSERT INTO `tb_history` VALUES ('399', '11107', '4', '1', '9', '2', '0', '0', '0', '2016-07-17');
INSERT INTO `tb_history` VALUES ('400', '11106', '2', '6', '6', '3', '4', '8', '1', '2016-07-15');
INSERT INTO `tb_history` VALUES ('401', '11105', '4', '2', '3', '2', '4', '5', '1', '2016-07-12');
INSERT INTO `tb_history` VALUES ('402', '11104', '2', '0', '2', '8', '5', '0', '4', '2016-07-10');
INSERT INTO `tb_history` VALUES ('403', '11103', '3', '1', '8', '7', '9', '1', '2', '2016-07-08');
INSERT INTO `tb_history` VALUES ('404', '11102', '3', '3', '5', '5', '3', '7', '1', '2016-07-05');
INSERT INTO `tb_history` VALUES ('405', '11101', '1', '8', '8', '6', '0', '1', '1', '2016-07-03');
INSERT INTO `tb_history` VALUES ('406', '11100', '6', '1', '5', '9', '7', '4', '0', '2016-07-01');
INSERT INTO `tb_history` VALUES ('407', '11099', '6', '7', '7', '6', '1', '3', '9', '2016-06-28');
INSERT INTO `tb_history` VALUES ('408', '11098', '8', '8', '3', '0', '2', '5', '8', '2016-06-26');
INSERT INTO `tb_history` VALUES ('409', '11097', '0', '4', '6', '7', '3', '2', '5', '2016-06-24');
INSERT INTO `tb_history` VALUES ('410', '11096', '9', '1', '7', '9', '6', '0', '0', '2016-06-21');
INSERT INTO `tb_history` VALUES ('411', '11095', '6', '6', '0', '9', '2', '0', '3', '2016-06-19');
INSERT INTO `tb_history` VALUES ('412', '11094', '8', '4', '2', '7', '5', '3', '5', '2016-06-17');
INSERT INTO `tb_history` VALUES ('413', '11093', '3', '4', '3', '8', '4', '5', '0', '2016-06-14');
INSERT INTO `tb_history` VALUES ('414', '11092', '0', '7', '0', '0', '2', '7', '8', '2016-06-12');
INSERT INTO `tb_history` VALUES ('415', '11091', '1', '1', '2', '3', '0', '9', '5', '2016-06-10');

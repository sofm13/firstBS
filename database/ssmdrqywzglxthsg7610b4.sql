/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50160
Source Host           : localhost:3306
Source Database       : ssmdrqywzglxthsg7610b4

Target Server Type    : MYSQL
Target Server Version : 50160
File Encoding         : 65001

Date: 2020-03-26 19:47:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for allusers
-- ----------------------------
DROP TABLE IF EXISTS `allusers`;
CREATE TABLE `allusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `cx` varchar(50) DEFAULT '普通管理员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of allusers
-- ----------------------------
INSERT INTO `allusers` VALUES ('2', 'admin', '12', '超级管理员', '2020-02-22 20:55:31');
INSERT INTO `allusers` VALUES ('3', '12', '12', '普通管理员', '2020-03-26 00:16:44');

-- ----------------------------
-- Table structure for baofeishenqing
-- ----------------------------
DROP TABLE IF EXISTS `baofeishenqing`;
CREATE TABLE `baofeishenqing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `baofeiyuanyin` varchar(500) DEFAULT NULL,
  `baofeishuliang` varchar(50) DEFAULT NULL,
  `baofeiren` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of baofeishenqing
-- ----------------------------
INSERT INTO `baofeishenqing` VALUES ('2', '005', 'G设备', '', '88', '018', '是', '2020-02-22 20:55:31');
INSERT INTO `baofeishenqing` VALUES ('3', '005', 'G设备', '', '92', '031', '是', '2020-02-22 20:55:31');
INSERT INTO `baofeishenqing` VALUES ('4', '001', 'E设备', '', '88', '003', '是', '2020-02-22 20:55:31');
INSERT INTO `baofeishenqing` VALUES ('5', '008', 'M设备', '故障！', '86', '028', '是', '2020-02-22 20:55:31');
INSERT INTO `baofeishenqing` VALUES ('6', '025', 'D设备', '', '92', '001', '否', '2020-02-22 20:55:31');
INSERT INTO `baofeishenqing` VALUES ('7', '001', 'E设备', '嗯嗯', '1', '12345', '否', '2020-02-22 21:52:03');

-- ----------------------------
-- Table structure for bumenguanli
-- ----------------------------
DROP TABLE IF EXISTS `bumenguanli`;
CREATE TABLE `bumenguanli` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bumenbianhao` varchar(50) DEFAULT NULL,
  `bumenmingcheng` varchar(50) DEFAULT NULL,
  `bumendianhua` varchar(50) DEFAULT NULL,
  `bumenchuanzhen` varchar(50) DEFAULT NULL,
  `bumenxinxi` varchar(500) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bumenguanli
-- ----------------------------
INSERT INTO `bumenguanli` VALUES ('2', '009', '企划部', '6460224', '', '财务部', '2020-02-22 20:55:31');
INSERT INTO `bumenguanli` VALUES ('3', '034', '秘书部', '8945622', '', '技术部', '2020-02-22 20:55:31');
INSERT INTO `bumenguanli` VALUES ('4', '020', '后勤部', '6548745', '', '后勤部', '2020-02-22 20:55:31');
INSERT INTO `bumenguanli` VALUES ('5', '029', '会计部', '6460233', '', '员工部', '2020-02-22 20:55:31');
INSERT INTO `bumenguanli` VALUES ('6', '001', '财务部', '8954878', '', '企划部', '2020-02-22 20:55:31');
INSERT INTO `bumenguanli` VALUES ('7', '111', '物流部', '1234565', '1234565', '嗡嗡嗡嗡嗡嗡', '2020-02-22 21:47:19');

-- ----------------------------
-- Table structure for chukushenqing
-- ----------------------------
DROP TABLE IF EXISTS `chukushenqing`;
CREATE TABLE `chukushenqing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `shenqingshuliang` varchar(50) DEFAULT NULL,
  `shenqingyuanyin` varchar(500) DEFAULT NULL,
  `shenqingren` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of chukushenqing
-- ----------------------------
INSERT INTO `chukushenqing` VALUES ('2', '001', 'E设备', '50', '', '023', '是', '2020-02-22 20:55:31');
INSERT INTO `chukushenqing` VALUES ('3', '025', 'D设备', '72', '', '005', '是', '2020-02-22 20:55:31');
INSERT INTO `chukushenqing` VALUES ('4', '005', 'G设备', '34', '', '010', '是', '2020-02-22 20:55:31');
INSERT INTO `chukushenqing` VALUES ('5', '025', 'D设备', '72', '', '015', '是', '2020-02-22 20:55:31');
INSERT INTO `chukushenqing` VALUES ('6', '028', 'A设备', '34', '', '001', '是', '2020-02-22 20:55:31');
INSERT INTO `chukushenqing` VALUES ('7', '12345', 'E设备', '10', '', '321', '否', '2020-02-22 21:52:39');

-- ----------------------------
-- Table structure for fapiaoguanli
-- ----------------------------
DROP TABLE IF EXISTS `fapiaoguanli`;
CREATE TABLE `fapiaoguanli` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `fapiaobianhao` varchar(50) DEFAULT NULL,
  `fapiaoneirong` varchar(500) DEFAULT NULL,
  `fapiaojine` varchar(50) DEFAULT NULL,
  `jiluren` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of fapiaoguanli
-- ----------------------------
INSERT INTO `fapiaoguanli` VALUES ('2', '008', 'M设备', 'fapiao028', '', '82', '002', '2020-02-22 20:55:31');
INSERT INTO `fapiaoguanli` VALUES ('3', '025', 'D设备', 'fapiao007', '', '25', '015', '2020-02-22 20:55:31');
INSERT INTO `fapiaoguanli` VALUES ('4', '025', 'D设备', 'fapiao016', '', '15', '021', '2020-02-22 20:55:31');
INSERT INTO `fapiaoguanli` VALUES ('5', '025', 'D设备', 'fapiao020', '', '25', '026', '2020-02-22 20:55:31');
INSERT INTO `fapiaoguanli` VALUES ('6', '008', 'M设备', 'fapiao001', '', '15', '001', '2020-02-22 20:55:31');
INSERT INTO `fapiaoguanli` VALUES ('7', '025', 'D设备', '02222149511293', '身上的', '1111', '玩玩', '2020-02-22 21:49:58');
INSERT INTO `fapiaoguanli` VALUES ('8', '12345', 'E设备', '03221929377372', '', '', '', '2020-03-22 19:29:39');

-- ----------------------------
-- Table structure for hetongshengcheng
-- ----------------------------
DROP TABLE IF EXISTS `hetongshengcheng`;
CREATE TABLE `hetongshengcheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `hetongbianhao` varchar(50) DEFAULT NULL,
  `hetongneirong` varchar(500) DEFAULT NULL,
  `caigougongsi` varchar(50) DEFAULT NULL,
  `caigouriqi` date DEFAULT NULL,
  `caigouren` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of hetongshengcheng
-- ----------------------------
INSERT INTO `hetongshengcheng` VALUES ('2', '025', 'D设备', 'hetong015', '', '', '2020-02-07', '029', '2020-02-22 20:55:31');
INSERT INTO `hetongshengcheng` VALUES ('3', '025', 'D设备', 'hetong028', '', '', '2020-03-17', '024', '2020-02-22 20:55:31');
INSERT INTO `hetongshengcheng` VALUES ('4', '008', 'M设备', 'hetong006', '', '', '2020-01-31', '011', '2020-02-22 20:55:31');
INSERT INTO `hetongshengcheng` VALUES ('5', '025', 'D设备', 'hetong013', '', '', '2020-02-04', '021', '2020-02-22 20:55:31');
INSERT INTO `hetongshengcheng` VALUES ('6', '025', 'D设备', 'hetong001', '', '', '2020-02-07', '001', '2020-02-22 20:55:31');
INSERT INTO `hetongshengcheng` VALUES ('7', '025', 'D设备', '02222149321745', '顶顶顶', '说十四', '2020-02-22', '顶顶顶', '2020-02-22 21:49:40');
INSERT INTO `hetongshengcheng` VALUES ('8', '001', 'E设备', '03221929578764', '规划规范化风格恢复', 'A', '2020-03-22', 'B', '2020-03-22 19:30:09');

-- ----------------------------
-- Table structure for jianyijihua
-- ----------------------------
DROP TABLE IF EXISTS `jianyijihua`;
CREATE TABLE `jianyijihua` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jihuamingcheng` varchar(50) DEFAULT NULL,
  `jihuamiaoshu` varchar(500) DEFAULT NULL,
  `lurushijian` date DEFAULT NULL,
  `lururenyuan` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jianyijihua
-- ----------------------------
INSERT INTO `jianyijihua` VALUES ('2', 'N计划', '', '2020-03-11', '025', '2020-03-20 21:01:31');
INSERT INTO `jianyijihua` VALUES ('3', 'B计划', '', '2020-03-11', '012', '2020-03-20 21:01:31');
INSERT INTO `jianyijihua` VALUES ('4', 'C计划', '', '2020-03-02', '013', '2020-03-20 21:01:31');
INSERT INTO `jianyijihua` VALUES ('5', 'P计划', '', '2020-03-02', '010', '2020-03-20 21:01:31');
INSERT INTO `jianyijihua` VALUES ('6', 'D计划', '', '2020-03-11', '001', '2020-03-20 21:01:31');
INSERT INTO `jianyijihua` VALUES ('7', '353', '325325', '2020-03-20', '001', '2020-03-20 21:38:43');
INSERT INTO `jianyijihua` VALUES ('8', '12', '12', '2020-03-22', '321', '2020-03-22 16:25:34');

-- ----------------------------
-- Table structure for jishuxieyi
-- ----------------------------
DROP TABLE IF EXISTS `jishuxieyi`;
CREATE TABLE `jishuxieyi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xieyibianhao` varchar(50) DEFAULT NULL,
  `xieyimingcheng` varchar(50) DEFAULT NULL,
  `xieyineirong` varchar(500) DEFAULT NULL,
  `xieyijiafang` varchar(50) DEFAULT NULL,
  `xieyiyifang` varchar(50) DEFAULT NULL,
  `qianyueren` varchar(50) DEFAULT NULL,
  `qiandingriqi` date DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jishuxieyi
-- ----------------------------
INSERT INTO `jishuxieyi` VALUES ('2', '3203744057', 'N协议', '', '', '', '006', '2020-03-12', '2020-03-20 21:01:35');
INSERT INTO `jishuxieyi` VALUES ('3', '3203738549', 'X协议', '', '', '', '033', '2020-04-19', '2020-03-20 21:01:35');
INSERT INTO `jishuxieyi` VALUES ('4', '3203784878', 'Y协议', '', '', '', '004', '2020-03-03', '2020-03-20 21:01:35');
INSERT INTO `jishuxieyi` VALUES ('5', '3203744057', 'F协议', '', '', '', '007', '2020-03-12', '2020-03-20 21:01:35');
INSERT INTO `jishuxieyi` VALUES ('6', '3203730600', 'E协议', '', '', '', '001', '2020-04-19', '2020-03-20 21:01:35');

-- ----------------------------
-- Table structure for shbeiyunxingmeizhi
-- ----------------------------
DROP TABLE IF EXISTS `shbeiyunxingmeizhi`;
CREATE TABLE `shbeiyunxingmeizhi` (
  `id` int(11) NOT NULL,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `rizhi` varchar(500) DEFAULT NULL,
  `canshu` varchar(500) DEFAULT NULL,
  `issh` varchar(10) DEFAULT NULL,
  `addtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shbeiyunxingmeizhi
-- ----------------------------

-- ----------------------------
-- Table structure for shebeichuku
-- ----------------------------
DROP TABLE IF EXISTS `shebeichuku`;
CREATE TABLE `shebeichuku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `kucun` varchar(50) DEFAULT NULL,
  `shenqingshuliang` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shebeichuku
-- ----------------------------
INSERT INTO `shebeichuku` VALUES ('2', '025', 'D设备', '62', '18', '2020-02-22 20:55:31');
INSERT INTO `shebeichuku` VALUES ('3', '028', 'A设备', '86', '18', '2020-02-22 20:55:31');
INSERT INTO `shebeichuku` VALUES ('4', '008', 'M设备', '21', '99', '2020-02-22 20:55:31');
INSERT INTO `shebeichuku` VALUES ('5', '028', 'A设备', '86', '27', '2020-02-22 20:55:31');
INSERT INTO `shebeichuku` VALUES ('6', '005', 'G设备', '31', '87', '2020-02-22 20:55:31');
INSERT INTO `shebeichuku` VALUES ('7', '001', 'E设备', '41', '10', '2020-02-22 21:43:59');
INSERT INTO `shebeichuku` VALUES ('8', '12345', 'E设备', '74', '4', '2020-02-22 21:53:14');

-- ----------------------------
-- Table structure for shebeiguanli
-- ----------------------------
DROP TABLE IF EXISTS `shebeiguanli`;
CREATE TABLE `shebeiguanli` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `kucun` varchar(50) DEFAULT NULL,
  `shebeixiangqing` varchar(500) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shebeiguanli
-- ----------------------------
INSERT INTO `shebeiguanli` VALUES ('2', '008', 'M设备', '21', '', '2020-02-22 20:55:31');
INSERT INTO `shebeiguanli` VALUES ('3', '025', 'D设备', '62', '', '2020-02-22 20:55:31');
INSERT INTO `shebeiguanli` VALUES ('4', '005', 'G设备', '31', '', '2020-02-22 20:55:31');
INSERT INTO `shebeiguanli` VALUES ('5', '028', 'A设备', '86', '', '2020-02-22 20:55:31');
INSERT INTO `shebeiguanli` VALUES ('6', '001', 'E设备', '31', '', '2020-02-22 20:55:31');
INSERT INTO `shebeiguanli` VALUES ('7', '12345', 'E设备', '-12051', '1212121212121', '2020-02-22 21:48:35');

-- ----------------------------
-- Table structure for shebeiruku
-- ----------------------------
DROP TABLE IF EXISTS `shebeiruku`;
CREATE TABLE `shebeiruku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `kucun` varchar(50) DEFAULT NULL,
  `shenqingshuliang` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shebeiruku
-- ----------------------------
INSERT INTO `shebeiruku` VALUES ('2', '001', 'E设备', '31', '37', '2020-02-22 20:55:31');
INSERT INTO `shebeiruku` VALUES ('3', '008', 'M设备', '21', '93', '2020-02-22 20:55:31');
INSERT INTO `shebeiruku` VALUES ('4', '005', 'G设备', '31', '16', '2020-02-22 20:55:31');
INSERT INTO `shebeiruku` VALUES ('5', '008', 'M设备', '21', '93', '2020-02-22 20:55:31');
INSERT INTO `shebeiruku` VALUES ('6', '008', 'M设备', '21', '57', '2020-02-22 20:55:31');
INSERT INTO `shebeiruku` VALUES ('7', '001', 'E设备', '31', '10', '2020-02-22 21:43:44');
INSERT INTO `shebeiruku` VALUES ('8', '12345', 'E设备', '64', '10', '2020-02-22 21:53:04');

-- ----------------------------
-- Table structure for shebeishenqing
-- ----------------------------
DROP TABLE IF EXISTS `shebeishenqing`;
CREATE TABLE `shebeishenqing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `shenqingshuliang` varchar(50) DEFAULT NULL,
  `shenqingyuanyin` varchar(50) DEFAULT NULL,
  `jujueyuanyin` varchar(50) DEFAULT NULL,
  `beizhu` varchar(500) DEFAULT NULL,
  `shenqingbumen` varchar(50) DEFAULT NULL,
  `shenqingren` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shebeishenqing
-- ----------------------------
INSERT INTO `shebeishenqing` VALUES ('2', '025', 'D设备', '24', '', '', 'ok', '', '015', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeishenqing` VALUES ('3', '008', 'M设备', '69', '', '', 'abc', '', '023', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeishenqing` VALUES ('4', '028', 'A设备', '69', '', '', '无', '', '006', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeishenqing` VALUES ('5', '025', 'D设备', '13', '', '', '无', '', '009', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeishenqing` VALUES ('6', '025', 'D设备', '61', '睇睇', '试试', '无', '睇睇', '001', '否', '2020-02-22 20:55:31');
INSERT INTO `shebeishenqing` VALUES ('7', '12345', 'E设备', '10', '睇睇', '', '无问我', '嗯嗯', '12345', '否', '2020-02-22 21:51:39');
INSERT INTO `shebeishenqing` VALUES ('8', '001', 'E设备', '1212', '1212', '', '12121', '物资部', '321', '是', '2020-03-22 16:32:14');

-- ----------------------------
-- Table structure for shebeiyunxing
-- ----------------------------
DROP TABLE IF EXISTS `shebeiyunxing`;
CREATE TABLE `shebeiyunxing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `rizhi` varchar(500) DEFAULT NULL,
  `canshu` varchar(500) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shebeiyunxing
-- ----------------------------
INSERT INTO `shebeiyunxing` VALUES ('2', '005', 'G设备', '', '', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeiyunxing` VALUES ('3', '028', 'A设备', '', '', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeiyunxing` VALUES ('4', '008', 'M设备', '', '', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeiyunxing` VALUES ('5', '001', 'E设备', '', '', '是', '2020-02-22 20:55:31');
INSERT INTO `shebeiyunxing` VALUES ('6', '028', 'A设备', '日志', '1212', '否', '2020-02-22 20:55:31');
INSERT INTO `shebeiyunxing` VALUES ('8', '028', 'A设备', '功率因数:12    日平均负荷:12        日厂用电量: 12      日最高负荷:12       日最低负荷:  12     日耗中煤: 12      发电标煤耗: 12    日制工业水量: 12      日除盐水耗水量:  12     日拉矸石量:  12     日入厂煤量: 12      累计矸石量:  12     排渣量:1212', null, '否', '2020-03-22 23:38:59');
INSERT INTO `shebeiyunxing` VALUES ('9', '12345', 'E设备', '功率因数: 12   日平均负荷: 12       日厂用电量:   12    日最高负荷:12       日最低负荷: 12      日耗中煤:      12 发电标煤耗: 12    日制工业水量:   12    日除盐水耗水量:    12   日拉矸石量: 12      日入厂煤量:  12     累计矸石量:12       排渣量:12', null, '否', '2020-03-22 23:40:36');
INSERT INTO `shebeiyunxing` VALUES ('10', '005', 'G设备', '功率因数:12    日平均负荷:12        日厂用电量:222       日最高负荷:12      日最低负荷:12       日耗中煤:12       发电标煤耗:12     日制工业水量:12       日除盐水耗水量:12       日拉矸石量:12       日入厂煤量: 2      累计矸石量: 1      排渣量:12', '侯祺积', '是', '2020-03-23 00:00:05');
INSERT INTO `shebeiyunxing` VALUES ('11', '12345', 'E设备', '功率因数:    日平均负荷:        日厂用电量:       日最高负荷:       日最低负荷:       日耗中煤:       发电标煤耗:     日制工业水量:       日除盐水耗水量:       日拉矸石量:       日入厂煤量:       累计矸石量:       排渣量:', 'hqj', '否', '2020-03-23 08:37:57');
INSERT INTO `shebeiyunxing` VALUES ('12', '025', 'D设备', '功率因数:19kf    日平均负荷:12kg        日厂用电量:12d       日最高负荷:sd       日最低负荷:13       日耗中煤:12kf       发电标煤耗:13kw     日制工业水量:10t       日除盐水耗水量:3t       日拉矸石量:1t       日入厂煤量:1t       累计矸石量:1t       排渣量:12t', '侯祺积', '否', '2020-03-25 17:24:02');
INSERT INTO `shebeiyunxing` VALUES ('13', '12345', 'E设备', '功率因数:    日平均负荷:        日厂用电量:       日最高负荷:       日最低负荷:       日耗中煤:       发电标煤耗:     日制工业水量:       日除盐水耗水量:       日拉矸石量:       日入厂煤量:       累计矸石量:       排渣量:', '1', '否', '2020-03-25 22:45:32');

-- ----------------------------
-- Table structure for shebeiyunxing1
-- ----------------------------
DROP TABLE IF EXISTS `shebeiyunxing1`;
CREATE TABLE `shebeiyunxing1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `rizhi` varchar(500) DEFAULT NULL,
  `canshu` varchar(500) DEFAULT NULL,
  `issh` varchar(10) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shebeiyunxing1
-- ----------------------------
INSERT INTO `shebeiyunxing1` VALUES ('7', '008', 'M设备', '煤质监督ID: 12    记录编号：12         记录名称: 回去后       记录时间: 2001/01/10       修改人: 张三      修改时间:       煤指标_水分_皮带1: 12      煤指标_挥发份_皮带1: 23      煤指标_发热量_皮带1: 1    备注:  无     化验负责人:张三', '张三', '否', '2020-03-26 13:08:37');

-- ----------------------------
-- Table structure for shebeiyunxing2
-- ----------------------------
DROP TABLE IF EXISTS `shebeiyunxing2`;
CREATE TABLE `shebeiyunxing2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `rizhi` varchar(500) DEFAULT NULL,
  `canshu` varchar(500) DEFAULT NULL,
  `issh` varchar(10) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shebeiyunxing2
-- ----------------------------
INSERT INTO `shebeiyunxing2` VALUES ('2', '001', 'E设备', '水气监督ID:     记录编号：         记录名称:        记录时间:        修改人:       修改时间:       除盐水_钠:       炉水_PH:       炉水_PO:     给水_PH:      蒸汽_钠:       凝结水_硬度:        循环水_PH:         锅炉灰水浓度_1:          池灰水浓度: 12          化验负责人:', '1212', '是', '2020-03-26 11:00:35');

-- ----------------------------
-- Table structure for shebeiyunxing3
-- ----------------------------
DROP TABLE IF EXISTS `shebeiyunxing3`;
CREATE TABLE `shebeiyunxing3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `rizhi` varchar(500) DEFAULT NULL,
  `canshu` varchar(500) DEFAULT NULL,
  `issh` varchar(10) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shebeiyunxing3
-- ----------------------------
INSERT INTO `shebeiyunxing3` VALUES ('2', '028', 'A设备', '功率因数:  1  日平均负荷:        日厂用电量:       日最高负荷:       日最低负荷:       日耗中煤:       发电标煤耗:     日制工业水量:  1     日除盐水耗水量:       日拉矸石量:       日入厂煤量:       累计矸石量:       排渣量:', '1', '否', '2020-03-26 13:59:10');

-- ----------------------------
-- Table structure for shengdiaobu
-- ----------------------------
DROP TABLE IF EXISTS `shengdiaobu`;
CREATE TABLE `shengdiaobu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `bumenmingcheng` varchar(50) DEFAULT NULL,
  `gangwei` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `shouji` varchar(50) DEFAULT NULL,
  `jiatingdizhi` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shengdiaobu
-- ----------------------------
INSERT INTO `shengdiaobu` VALUES ('2', '006', '001', '王与馨', '女', '企划部', '司机', '6497512', '8900541', '河滨东路139号', '2020-02-22 20:55:31');
INSERT INTO `shengdiaobu` VALUES ('3', '031', '001', '吴永国', '男', '财务部', '程序员', '7856954', '6488958', '泰兴路22号', '2020-02-22 20:55:31');
INSERT INTO `shengdiaobu` VALUES ('4', '011', '001', '赵姿吟', '男', '秘书部', '收银员', '4265325', '6460233', '方城丽圆11幢201室', '2020-02-22 20:55:31');
INSERT INTO `shengdiaobu` VALUES ('5', '012', '001', '孙俪', '女', '会计部', '厨师', '6460848', '6460848', '东城路99号', '2020-02-22 20:55:31');
INSERT INTO `shengdiaobu` VALUES ('6', '001', '001', '李鹏', '女', '财务部', '导游', '6488958', '3326844', '人民路57号', '2020-02-22 20:55:31');
INSERT INTO `shengdiaobu` VALUES ('7', '12345', '321', '陈明希', '男', '物流部', '试试', '1234567', '1234567', '', '2020-02-22 21:47:53');

-- ----------------------------
-- Table structure for weijianjihua
-- ----------------------------
DROP TABLE IF EXISTS `weijianjihua`;
CREATE TABLE `weijianjihua` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jihuamingcheng` varchar(50) DEFAULT NULL,
  `jihuamiaoshu` varchar(500) DEFAULT NULL,
  `lurushijian` date DEFAULT NULL,
  `lururenyuan` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of weijianjihua
-- ----------------------------
INSERT INTO `weijianjihua` VALUES ('2', 'P计划', '', '2020-02-26', '003', '2020-03-20 21:01:38');
INSERT INTO `weijianjihua` VALUES ('3', 'R计划', '', '2020-02-26', '011', '2020-03-20 21:01:38');
INSERT INTO `weijianjihua` VALUES ('4', 'D计划', '', '2020-03-30', '027', '2020-03-20 21:01:38');
INSERT INTO `weijianjihua` VALUES ('5', 'G计划', '', '2020-03-12', '022', '2020-03-20 21:01:38');
INSERT INTO `weijianjihua` VALUES ('6', 'A计划', '', '2020-02-21', '001', '2020-03-20 21:01:38');
INSERT INTO `weijianjihua` VALUES ('7', '353', '235235', '2020-03-20', '001', '2020-03-20 21:38:51');
INSERT INTO `weijianjihua` VALUES ('9', '物资部', '将物资库存改为1', '2020-03-26', '12345', '2020-03-26 16:03:16');
INSERT INTO `weijianjihua` VALUES ('10', '采购', '采购100个', '2020-03-26', '321', '2020-03-26 16:11:10');
INSERT INTO `weijianjihua` VALUES ('11', '12', '121212121', '2020-03-26', '12345', '2020-03-26 16:13:36');
INSERT INTO `weijianjihua` VALUES ('12', '物资部', '采购数量改为1', '2020-03-26', '12345', '2020-03-26 16:26:24');

-- ----------------------------
-- Table structure for weijianjihua1
-- ----------------------------
DROP TABLE IF EXISTS `weijianjihua1`;
CREATE TABLE `weijianjihua1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jihuamingcheng` varchar(50) DEFAULT NULL,
  `jihuamiaoshu` varchar(500) DEFAULT NULL,
  `lurushijian` date DEFAULT NULL,
  `lururenyuan` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weijianjihua1
-- ----------------------------
INSERT INTO `weijianjihua1` VALUES ('2', '物资部', '将设备入库库存数量减2！！！！！！！！！！！！！！！！！！！！！', '2020-03-26', '12345', '2020-03-26 16:29:05');
INSERT INTO `weijianjihua1` VALUES ('5', '采购', 'afahshghffffffffffffff', '2020-03-26', 'admin', '2020-03-26 16:38:45');
INSERT INTO `weijianjihua1` VALUES ('6', 'q13213', '12wwwwwwwwwwwwww', '2020-03-26', 'admin', '2020-03-26 16:38:56');
INSERT INTO `weijianjihua1` VALUES ('7', 'wwwwwwwwwwwwwwww', 'wwwwwwwwwwwwwwwww', '2020-03-26', 'admin', '2020-03-26 16:39:01');
INSERT INTO `weijianjihua1` VALUES ('8', '物资部', '12222222222222222222222222', '2020-03-26', 'admin', '2020-03-26 16:39:12');
INSERT INTO `weijianjihua1` VALUES ('9', '物资部', '2222222222222222222222222222222', '2020-03-26', 'admin', '2020-03-26 16:39:16');
INSERT INTO `weijianjihua1` VALUES ('10', '4444444', '4444444444444444444444', '2020-03-26', 'admin', '2020-03-26 16:39:21');
INSERT INTO `weijianjihua1` VALUES ('11', '3333333333', '33333333333333', '2020-03-26', 'admin', '2020-03-26 16:39:31');
INSERT INTO `weijianjihua1` VALUES ('12', '33434', '34343434', '2020-03-26', 'admin', '2020-03-26 16:39:36');
INSERT INTO `weijianjihua1` VALUES ('13', '4343', '343434', '2020-03-26', 'admin', '2020-03-26 16:39:41');
INSERT INTO `weijianjihua1` VALUES ('14', '物资部', '12312312', '2020-03-26', '12345', '2020-03-26 16:40:25');

-- ----------------------------
-- Table structure for weixiubaogao
-- ----------------------------
DROP TABLE IF EXISTS `weixiubaogao`;
CREATE TABLE `weixiubaogao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `qingkuangjianshu` varchar(50) DEFAULT NULL,
  `weixiuyuanyin` varchar(500) DEFAULT NULL,
  `weixiujieguo` varchar(50) DEFAULT NULL,
  `weixiuren` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of weixiubaogao
-- ----------------------------
INSERT INTO `weixiubaogao` VALUES ('2', '001', 'E设备', '', '', '', '021', '2020-02-22 20:55:31');
INSERT INTO `weixiubaogao` VALUES ('3', '025', 'D设备', '', '', '', '023', '2020-02-22 20:55:31');
INSERT INTO `weixiubaogao` VALUES ('4', '025', 'D设备', '', '', '', '027', '2020-02-22 20:55:31');
INSERT INTO `weixiubaogao` VALUES ('5', '028', 'A设备', '', '', '', '022', '2020-02-22 20:55:31');
INSERT INTO `weixiubaogao` VALUES ('6', '005', 'G设备', '', '', '', '001', '2020-02-22 20:55:31');
INSERT INTO `weixiubaogao` VALUES ('7', '025', 'D设备', '', '睇睇', '睇睇', '试试', '2020-02-22 21:50:24');

-- ----------------------------
-- Table structure for weixiushenqing
-- ----------------------------
DROP TABLE IF EXISTS `weixiushenqing`;
CREATE TABLE `weixiushenqing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `qingkuangjianshu` varchar(500) DEFAULT NULL,
  `shenqingren` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of weixiushenqing
-- ----------------------------
INSERT INTO `weixiushenqing` VALUES ('2', '005', 'G设备', '', '006', '是', '2020-02-22 20:55:31');
INSERT INTO `weixiushenqing` VALUES ('3', '028', 'A设备', '', '030', '是', '2020-02-22 20:55:31');
INSERT INTO `weixiushenqing` VALUES ('4', '025', 'D设备', '', '018', '是', '2020-02-22 20:55:31');
INSERT INTO `weixiushenqing` VALUES ('5', '025', 'D设备', '', '031', '是', '2020-02-22 20:55:31');
INSERT INTO `weixiushenqing` VALUES ('6', '001', 'E设备', '', '001', '否', '2020-02-22 20:55:31');
INSERT INTO `weixiushenqing` VALUES ('7', '12345', 'E设备', '嗯嗯', '12345', '否', '2020-02-22 21:51:45');

-- ----------------------------
-- Table structure for wuzibu
-- ----------------------------
DROP TABLE IF EXISTS `wuzibu`;
CREATE TABLE `wuzibu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `bumenmingcheng` varchar(50) DEFAULT NULL,
  `gangwei` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `shouji` varchar(50) DEFAULT NULL,
  `jiatingdizhi` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of wuzibu
-- ----------------------------
INSERT INTO `wuzibu` VALUES ('2', '007', '001', '胡歌', '秘书部', '服务员', '6460848', '6460224', '人民路57号', '2020-02-22 20:55:31');
INSERT INTO `wuzibu` VALUES ('3', '018', '001', '滕少华', '秘书部', '医生', '5261554', '8900541', '解放路73号', '2020-02-22 20:55:31');
INSERT INTO `wuzibu` VALUES ('4', '020', '001', '方之明', '后勤部', '白领', '6854778', '6854778', '东城路99号', '2020-02-22 20:55:31');
INSERT INTO `wuzibu` VALUES ('5', '025', '001', '陈明希', '企划部', '保姆', '6497512', '8895632', '河滨东路139号', '2020-02-22 20:55:31');
INSERT INTO `wuzibu` VALUES ('6', '001', '001', '李中国', '后勤部', '护士', '4265325', '8945622', '鑫和锦园2栋', '2020-02-22 20:55:31');
INSERT INTO `wuzibu` VALUES ('7', '321', '321', '陈明希', '物流部', '试试', '13910215489', '13456789098', '3432423543242', '2020-02-22 21:48:06');

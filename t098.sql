/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : t098

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 13/12/2024 19:28:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brief
-- ----------------------------
DROP TABLE IF EXISTS `brief`;
CREATE TABLE `brief`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `brief` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of brief
-- ----------------------------
INSERT INTO `brief` VALUES (1, '这是一个简介');

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '配置文件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'http://localhost:8081/springboot073x3/upload/picture1.jpg');
INSERT INTO `config` VALUES (2, 'picture2', 'http://localhost:8081/springboot073x3/upload/picture2.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'http://localhost:8081/springboot073x3/upload/picture3.jpg');
INSERT INTO `config` VALUES (6, 'homepage', 'http://localhost:8081/springboot073x3/upload/picture4.jpg');

-- ----------------------------
-- Table structure for diqu
-- ----------------------------
DROP TABLE IF EXISTS `diqu`;
CREATE TABLE `diqu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `diqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '地区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '地区' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diqu
-- ----------------------------
INSERT INTO `diqu` VALUES (51, '2021-04-30 11:47:47', '北京');
INSERT INTO `diqu` VALUES (52, '2021-04-30 11:47:47', '成都');
INSERT INTO `diqu` VALUES (53, '2021-04-30 11:47:47', '阿勒泰');
INSERT INTO `diqu` VALUES (54, '2021-04-30 11:47:47', '拉萨');
INSERT INTO `diqu` VALUES (55, '2021-04-30 11:47:47', '重庆');
INSERT INTO `diqu` VALUES (56, '2021-04-30 11:47:47', '巴黎');
INSERT INTO `diqu` VALUES (57, '2024-12-06 01:09:33', '纽约');

-- ----------------------------
-- Table structure for discussjingdianxinxi
-- ----------------------------
DROP TABLE IF EXISTS `discussjingdianxinxi`;
CREATE TABLE `discussjingdianxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 187 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '景点信息评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discussjingdianxinxi
-- ----------------------------
INSERT INTO `discussjingdianxinxi` VALUES (181, '2021-04-30 11:47:47', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discussjingdianxinxi` VALUES (182, '2021-04-30 11:47:47', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discussjingdianxinxi` VALUES (183, '2021-04-30 11:47:47', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discussjingdianxinxi` VALUES (184, '2021-04-30 11:47:47', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discussjingdianxinxi` VALUES (185, '2021-04-30 11:47:47', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discussjingdianxinxi` VALUES (186, '2021-04-30 11:47:47', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discussjiudianxinxi
-- ----------------------------
DROP TABLE IF EXISTS `discussjiudianxinxi`;
CREATE TABLE `discussjiudianxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '酒店信息评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discussjiudianxinxi
-- ----------------------------
INSERT INTO `discussjiudianxinxi` VALUES (191, '2021-04-30 11:47:47', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discussjiudianxinxi` VALUES (192, '2021-04-30 11:47:47', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discussjiudianxinxi` VALUES (193, '2021-04-30 11:47:47', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discussjiudianxinxi` VALUES (194, '2021-04-30 11:47:47', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discussjiudianxinxi` VALUES (195, '2021-04-30 11:47:47', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discussjiudianxinxi` VALUES (196, '2021-04-30 11:47:47', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discusstechan
-- ----------------------------
DROP TABLE IF EXISTS `discusstechan`;
CREATE TABLE `discusstechan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 206 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '特产评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discusstechan
-- ----------------------------
INSERT INTO `discusstechan` VALUES (201, '2021-04-30 11:47:47', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discusstechan` VALUES (202, '2021-04-30 11:47:47', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discusstechan` VALUES (203, '2021-04-30 11:47:47', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discusstechan` VALUES (204, '2021-04-30 11:47:47', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discusstechan` VALUES (205, '2021-04-30 11:47:47', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discusstechan` VALUES (206, '2021-04-30 11:47:47', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for goupiaoquxiaodingdan
-- ----------------------------
DROP TABLE IF EXISTS `goupiaoquxiaodingdan`;
CREATE TABLE `goupiaoquxiaodingdan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客账号',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `shenfenzheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `jingdianmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '景点名称',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `piaoshu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '票数',
  `jiage` int NULL DEFAULT NULL COMMENT '价格',
  `zongjine` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总金额',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `goupiaoshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '购票时间',
  `quxiaoshijian` datetime NULL DEFAULT NULL COMMENT '取消时间',
  `quxiaoyuanyin` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '取消原因',
  `sfsh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '审核回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1729314679944 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '购票取消订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goupiaoquxiaodingdan
-- ----------------------------
INSERT INTO `goupiaoquxiaodingdan` VALUES (101, '2021-04-30 11:47:47', '游客账号1', '游客姓名1', '联系方式1', '身份证1', '景点名称1', '所在省区1', '所在城市1', '所在地区1', '票数1', 1, '总金额1', 'http://localhost:8080/springboot073x3/upload/goupiaoquxiaodingdan_tupian1.jpg', '购票时间1', '2021-04-30 11:47:47', '取消原因1', '是', '');
INSERT INTO `goupiaoquxiaodingdan` VALUES (102, '2021-04-30 11:47:47', '游客账号2', '游客姓名2', '联系方式2', '身份证2', '景点名称2', '所在省区2', '所在城市2', '所在地区2', '票数2', 2, '总金额2', 'http://localhost:8080/springboot073x3/upload/goupiaoquxiaodingdan_tupian2.jpg', '购票时间2', '2021-04-30 11:47:47', '取消原因2', '是', '');
INSERT INTO `goupiaoquxiaodingdan` VALUES (103, '2021-04-30 11:47:47', '游客账号3', '游客姓名3', '联系方式3', '身份证3', '景点名称3', '所在省区3', '所在城市3', '所在地区3', '票数3', 3, '总金额3', 'http://localhost:8080/springboot073x3/upload/goupiaoquxiaodingdan_tupian3.jpg', '购票时间3', '2021-04-30 11:47:47', '取消原因3', '是', '');
INSERT INTO `goupiaoquxiaodingdan` VALUES (104, '2021-04-30 11:47:47', '游客账号4', '游客姓名4', '联系方式4', '身份证4', '景点名称4', '所在省区4', '所在城市4', '所在地区4', '票数4', 4, '总金额4', 'http://localhost:8080/springboot073x3/upload/goupiaoquxiaodingdan_tupian4.jpg', '购票时间4', '2021-04-30 11:47:47', '取消原因4', '是', '');
INSERT INTO `goupiaoquxiaodingdan` VALUES (105, '2021-04-30 11:47:47', '游客账号5', '游客姓名5', '联系方式5', '身份证5', '景点名称5', '所在省区5', '所在城市5', '所在地区5', '票数5', 5, '总金额5', 'http://localhost:8080/springboot073x3/upload/goupiaoquxiaodingdan_tupian5.jpg', '购票时间5', '2021-04-30 11:47:47', '取消原因5', '是', '');
INSERT INTO `goupiaoquxiaodingdan` VALUES (106, '2021-04-30 11:47:47', '游客账号6', '游客姓名6', '联系方式6', '身份证6', '景点名称6', '所在省区6', '所在城市6', '所在地区6', '票数6', 6, '总金额6', 'http://localhost:8080/springboot073x3/upload/goupiaoquxiaodingdan_tupian6.jpg', '购票时间6', '2021-04-30 11:47:47', '取消原因6', '是', '');
INSERT INTO `goupiaoquxiaodingdan` VALUES (1619756130710, '2021-04-30 12:15:30', '123', '小v', '13923532031', '123456789123456789', '景点', '省区2', '市区2', '地区2', '2', 50, '100', 'http://localhost:8080/springboot073x3/upload/1619755590846.jpg', '2021-04-30 00:00:00', '2021-04-30 12:15:21', '不想要了', '是', NULL);
INSERT INTO `goupiaoquxiaodingdan` VALUES (1729314650022, '2024-10-19 13:10:49', '游客1', '游客姓名1', '13823888881', '440300199101010001', '景点名称2', '所在省区2', '所在城市2', '所在地区2', NULL, 2, '0', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian2.jpg', NULL, NULL, NULL, '是', NULL);
INSERT INTO `goupiaoquxiaodingdan` VALUES (1729314679944, '2024-10-19 13:11:19', '游客1', '游客姓名1', '13823888881', '440300199101010001', '景点名称2', '所在省区2', '所在城市2', '所在地区2', NULL, 2, '0', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian2.jpg', NULL, NULL, NULL, '否', NULL);

-- ----------------------------
-- Table structure for heimingdan
-- ----------------------------
DROP TABLE IF EXISTS `heimingdan`;
CREATE TABLE `heimingdan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '游客账号',
  `fengjinyuanyin` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '封禁原因',
  `bantype` int NULL DEFAULT NULL COMMENT '封禁类型, 0为永久，1为1小时，2为1天，3为一个月，4为一年',
  `bantime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '封禁操作时间',
  `unbantime` timestamp NULL DEFAULT NULL COMMENT '解禁时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `heimingdan_ibfk_1`(`youkezhanghao` ASC) USING BTREE,
  CONSTRAINT `heimingdan_ibfk_1` FOREIGN KEY (`youkezhanghao`) REFERENCES `youke` (`youkezhanghao`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '黑名单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of heimingdan
-- ----------------------------
INSERT INTO `heimingdan` VALUES (4, '游客4', '123', 4, '2024-11-10 13:00:00', '2025-11-10 13:00:00');

-- ----------------------------
-- Table structure for jingdiangoupiaodingdan
-- ----------------------------
DROP TABLE IF EXISTS `jingdiangoupiaodingdan`;
CREATE TABLE `jingdiangoupiaodingdan`  (
  `id` bigint NOT NULL DEFAULT 18 COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客账号',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `shenfenzheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `jingdianmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '景点名称',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `piaoshu` int NULL DEFAULT NULL COMMENT '票数',
  `jiage` int NULL DEFAULT NULL COMMENT '价格',
  `zongjine` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总金额',
  `goupiaoshijian` datetime NULL DEFAULT NULL COMMENT '购票时间',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sfsh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '审核回复',
  `ispay` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`addtime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '景点购票订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jingdiangoupiaodingdan
-- ----------------------------
INSERT INTO `jingdiangoupiaodingdan` VALUES (4, '2024-10-19 13:46:29', '游客1', '游客姓名1', '13823888881', '440300199101010001', '景点名称1', '所在省区1', '所在城市1', '所在地区1', 2, 1, '2', '2024-10-22 00:00:00', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian1.jpg', '是', NULL, '已支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (5, '2024-10-19 17:28:37', '游客1', '游客姓名1', '13823888881', '440300199101010001', '景点名称1', '所在省区1', '所在城市1', '所在地区1', 3, 1, '3', '2024-10-29 00:00:00', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian1.jpg', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (6, '2024-11-01 13:32:40', '游客1', '游客姓名1', '13823888881', '440300199101010001', 'test', '7', '7', '7', NULL, NULL, '0', '2024-11-14 00:00:00', 'http://localhost:8080/springboot073x3/upload/1619755590846.jpg', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (13, '2024-12-05 20:12:26', '游客1', '游客姓名1', '13823888881', '440300199101010001', '跟团游1', '所在省区1', '所在城市1', '所在地区1', 1, 200, '200', '2024-12-05 20:12:25', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian1.jpg', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (14, '2024-12-05 20:13:34', '游客1', '游客姓名1', '13823888881', '440300199101010001', '跟团游1', '所在省区1', '所在城市1', '所在地区1', 2, 200, '400', '2024-12-05 20:13:33', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian1.jpg', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (15, '2024-12-05 20:16:37', '游客1', '游客姓名1', '13823888881', '440300199101010001', '景点名称3', '所在省区3', '所在城市3', '所在地区3', 3, 3, '9', '2024-12-05 20:16:36', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian3.jpg', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (16, '2024-12-06 01:31:15', '游客1', '游客姓名1', '13823888881', '440300199101010001', '重庆一日游', '中国', '重庆', '重庆', 2, 1000, '2000', '2024-12-06 01:31:14', 'http://localhost:8081/springboot073x3/upload/1733416496885.jpg', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (17, '2024-12-06 11:01:18', '游客1', '游客姓名1', '13823888881', '440300199101010001', '风采纽约', '美国', '纽约', '纽约', 3, 23500, '70500', '2024-12-11 00:00:00', 'http://localhost:8081/springboot073x3/upload/1733419755080.webp', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (18, '2024-12-06 11:09:48', '游客1', '游客姓名1', '13823888881', '440300199101010001', '法国浪漫之旅', '法国', '巴黎', '巴黎', 3, 35000, '105000', '2024-12-06 11:09:47', 'http://localhost:8081/springboot073x3/upload/1733419668309.webp', '否', NULL, '未支付');
INSERT INTO `jingdiangoupiaodingdan` VALUES (1733454719989, '2024-12-06 11:11:59', '游客1', '游客姓名1', '13823888881', '440300199101010001', '法国浪漫之旅', '法国', '巴黎', '巴黎', 4, 35000, '140000', '2024-12-19 00:00:00', 'http://localhost:8081/springboot073x3/upload/1733419668309.webp', '否', NULL, '未支付');

-- ----------------------------
-- Table structure for jingdianxinxi
-- ----------------------------
DROP TABLE IF EXISTS `jingdianxinxi`;
CREATE TABLE `jingdianxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingdianmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '景点名称',
  `jingdiandengji` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '景点等级',
  `jingdianjieshao` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '景点介绍',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `meitiankaifangshijian` datetime NULL DEFAULT NULL COMMENT '每天开放时间',
  `meitianguanbishijian` datetime NULL DEFAULT NULL COMMENT '每天关闭时间',
  `beizhu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `jiage` int NULL DEFAULT NULL COMMENT '价格',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  `clicktime` datetime NULL DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int NULL DEFAULT 0 COMMENT '点击次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '景点信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jingdianxinxi
-- ----------------------------
INSERT INTO `jingdianxinxi` VALUES (21, '2021-04-30 11:47:47', '北京三日游', 'A', '浏览北京风光', '中国', '北京', '北京', '2024-12-04 03:07:00', '2024-12-31 03:07:00', '包含酒店费用', 3500, 'http://localhost:8081/springboot073x3/upload/1733417889770.webp', 2, 2, '2024-12-13 09:47:24', 102);
INSERT INTO `jingdianxinxi` VALUES (22, '2021-04-30 11:47:47', '成都大熊猫', 'A', '观看可爱的大熊猫', '中国', '四川', '成都', '2024-04-30 11:47:47', '2024-05-30 11:47:47', '包含机票费用', 2000, 'http://localhost:8081/springboot073x3/upload/1733418865326.webp', 6, 2, '2024-12-06 12:42:31', 28);
INSERT INTO `jingdianxinxi` VALUES (23, '2021-04-30 11:47:47', '新疆阿勒泰', 'A', '欢迎来到美丽的新疆', '中国', '新疆', '阿勒泰', '2024-12-01 03:08:00', '2025-01-13 03:08:00', '包含酒店费用', 3500, 'http://localhost:8081/springboot073x3/upload/1733419279713.webp', 3, 3, '2024-12-06 09:59:08', 23);
INSERT INTO `jingdianxinxi` VALUES (24, '2021-04-30 11:47:47', '布达拉宫朝圣旅', 'A', '前往世界屋脊参观布达拉宫', '中国', '西藏', '拉萨', '2024-11-02 11:47:47', '2025-01-01 11:47:47', '包含酒店费用', 6000, 'http://localhost:8081/springboot073x3/upload/1733419542072.webp', 4, 4, '2024-12-06 01:27:11', 14);
INSERT INTO `jingdianxinxi` VALUES (25, '2021-04-30 11:47:47', '法国浪漫之旅', 'A', '浪漫之都巴黎', '法国', '巴黎', '巴黎', '2024-11-30 11:47:47', '2025-04-30 11:47:47', '包含酒店和机票费用', 35000, 'http://localhost:8081/springboot073x3/upload/1733419668309.webp', 5, 5, '2024-12-06 11:12:02', 14);
INSERT INTO `jingdianxinxi` VALUES (26, '2021-04-30 11:47:47', '风采纽约', 'A', '纽约奇幻行', '美国', '纽约', '纽约', '2024-10-30 11:47:47', '2025-02-22 11:40:40', '包含酒店和机票费用', 23500, 'http://localhost:8081/springboot073x3/upload/1733419755080.webp', 6, 6, '2024-12-06 12:25:55', 21);
INSERT INTO `jingdianxinxi` VALUES (27, '2024-12-06 00:35:01', '重庆一日游', 'A', '浏览重庆风光', '中国', '重庆', '重庆', '2024-12-01 00:00:00', '2025-04-06 00:00:00', '包含酒店费用', 1000, 'http://localhost:8081/springboot073x3/upload/1733416496885.jpg', 0, 0, '2024-12-06 12:25:52', 11);

-- ----------------------------
-- Table structure for jiudiandingdan
-- ----------------------------
DROP TABLE IF EXISTS `jiudiandingdan`;
CREATE TABLE `jiudiandingdan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客账号',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `shenfenzheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `jiudianmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '酒店名称',
  `fangjianshu` int NULL DEFAULT NULL COMMENT '房间数',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `jiudianjiage` int NULL DEFAULT NULL COMMENT '酒店价格',
  `ruzhushijian` datetime NULL DEFAULT NULL COMMENT '入住时间',
  `ruzhutianshu` int NULL DEFAULT NULL COMMENT '入住天数',
  `xiadanshijian` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `zongjine` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总金额',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sfsh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '审核回复',
  `ispay` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1730299204713 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '酒店订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jiudiandingdan
-- ----------------------------
INSERT INTO `jiudiandingdan` VALUES (111, '2021-04-30 11:47:47', '游客账号1', '游客姓名1', '联系方式1', '身份证1', '酒店名称1', 1, '所在省区1', '所在城市1', '所在地区1', 1, '2021-04-30 11:47:47', 1, '2021-04-30 11:47:47', '总金额1', 'http://localhost:8080/springboot073x3/upload/jiudiandingdan_tupian1.jpg', '是', '', '未支付');
INSERT INTO `jiudiandingdan` VALUES (112, '2021-04-30 11:47:47', '游客账号2', '游客姓名2', '联系方式2', '身份证2', '酒店名称2', 2, '所在省区2', '所在城市2', '所在地区2', 2, '2021-04-30 11:47:47', 2, '2021-04-30 11:47:47', '总金额2', 'http://localhost:8080/springboot073x3/upload/jiudiandingdan_tupian2.jpg', '是', '', '未支付');
INSERT INTO `jiudiandingdan` VALUES (113, '2021-04-30 11:47:47', '游客账号3', '游客姓名3', '联系方式3', '身份证3', '酒店名称3', 3, '所在省区3', '所在城市3', '所在地区3', 3, '2021-04-30 11:47:47', 3, '2021-04-30 11:47:47', '总金额3', 'http://localhost:8080/springboot073x3/upload/jiudiandingdan_tupian3.jpg', '是', '', '未支付');
INSERT INTO `jiudiandingdan` VALUES (114, '2021-04-30 11:47:47', '游客账号4', '游客姓名4', '联系方式4', '身份证4', '酒店名称4', 4, '所在省区4', '所在城市4', '所在地区4', 4, '2021-04-30 11:47:47', 4, '2021-04-30 11:47:47', '总金额4', 'http://localhost:8080/springboot073x3/upload/jiudiandingdan_tupian4.jpg', '是', '', '未支付');
INSERT INTO `jiudiandingdan` VALUES (115, '2021-04-30 11:47:47', '游客账号5', '游客姓名5', '联系方式5', '身份证5', '酒店名称5', 5, '所在省区5', '所在城市5', '所在地区5', 5, '2021-04-30 11:47:47', 5, '2021-04-30 11:47:47', '总金额5', 'http://localhost:8080/springboot073x3/upload/jiudiandingdan_tupian5.jpg', '是', '', '未支付');
INSERT INTO `jiudiandingdan` VALUES (116, '2021-04-30 11:47:47', '游客账号6', '游客姓名6', '联系方式6', '身份证6', '酒店名称6', 6, '所在省区6', '所在城市6', '所在地区6', 6, '2021-04-30 11:47:47', 6, '2021-04-30 11:47:47', '总金额6', 'http://localhost:8080/springboot073x3/upload/jiudiandingdan_tupian6.jpg', '是', '', '未支付');
INSERT INTO `jiudiandingdan` VALUES (1619755945818, '2021-04-30 12:12:25', '123', '小v', '13923532031', '123456789123456789', '酒店名称5', 1, '所在省区5', '所在城市5', '所在地区5', 5, '2021-04-30 00:00:00', 1, '2021-04-30 00:00:00', '5', 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian5.jpg', '否', NULL, '已支付');
INSERT INTO `jiudiandingdan` VALUES (1730299204713, '2024-10-30 22:40:04', '游客1', '游客姓名1', '13823888881', '440300199101010001', '酒店名称3', 1, '所在省区3', '所在城市3', '所在地区3', 3, '2024-10-30 00:00:00', 5, '2024-10-30 00:00:00', '15', 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian3.jpg', '否', NULL, '未支付');

-- ----------------------------
-- Table structure for jiudianquxiaodingdan
-- ----------------------------
DROP TABLE IF EXISTS `jiudianquxiaodingdan`;
CREATE TABLE `jiudianquxiaodingdan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客账号',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `shenfenzheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `jiudianmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '酒店名称',
  `fangjianshu` int NULL DEFAULT NULL COMMENT '房间数',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `ruzhushijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '入住时间',
  `jiudianjiage` int NULL DEFAULT NULL COMMENT '酒店价格',
  `ruzhutianshu` int NULL DEFAULT NULL COMMENT '入住天数',
  `xiadanshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '下单时间',
  `zongjine` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总金额',
  `quxiaoshijian` datetime NULL DEFAULT NULL COMMENT '取消时间',
  `quxiaoyuanyin` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '取消原因',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sfsh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '审核回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1619756178351 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '酒店取消订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jiudianquxiaodingdan
-- ----------------------------
INSERT INTO `jiudianquxiaodingdan` VALUES (121, '2021-04-30 11:47:47', '游客账号1', '游客姓名1', '联系方式1', '身份证1', '酒店名称1', 1, '所在省区1', '所在城市1', '所在地区1', '入住时间1', 1, 1, '下单时间1', '总金额1', '2021-04-30 11:47:47', '取消原因1', 'http://localhost:8080/springboot073x3/upload/jiudianquxiaodingdan_tupian1.jpg', '是', '');
INSERT INTO `jiudianquxiaodingdan` VALUES (122, '2021-04-30 11:47:47', '游客账号2', '游客姓名2', '联系方式2', '身份证2', '酒店名称2', 2, '所在省区2', '所在城市2', '所在地区2', '入住时间2', 2, 2, '下单时间2', '总金额2', '2021-04-30 11:47:47', '取消原因2', 'http://localhost:8080/springboot073x3/upload/jiudianquxiaodingdan_tupian2.jpg', '是', '');
INSERT INTO `jiudianquxiaodingdan` VALUES (123, '2021-04-30 11:47:47', '游客账号3', '游客姓名3', '联系方式3', '身份证3', '酒店名称3', 3, '所在省区3', '所在城市3', '所在地区3', '入住时间3', 3, 3, '下单时间3', '总金额3', '2021-04-30 11:47:47', '取消原因3', 'http://localhost:8080/springboot073x3/upload/jiudianquxiaodingdan_tupian3.jpg', '是', '');
INSERT INTO `jiudianquxiaodingdan` VALUES (124, '2021-04-30 11:47:47', '游客账号4', '游客姓名4', '联系方式4', '身份证4', '酒店名称4', 4, '所在省区4', '所在城市4', '所在地区4', '入住时间4', 4, 4, '下单时间4', '总金额4', '2021-04-30 11:47:47', '取消原因4', 'http://localhost:8080/springboot073x3/upload/jiudianquxiaodingdan_tupian4.jpg', '是', '');
INSERT INTO `jiudianquxiaodingdan` VALUES (125, '2021-04-30 11:47:47', '游客账号5', '游客姓名5', '联系方式5', '身份证5', '酒店名称5', 5, '所在省区5', '所在城市5', '所在地区5', '入住时间5', 5, 5, '下单时间5', '总金额5', '2021-04-30 11:47:47', '取消原因5', 'http://localhost:8080/springboot073x3/upload/jiudianquxiaodingdan_tupian5.jpg', '是', '');
INSERT INTO `jiudianquxiaodingdan` VALUES (126, '2021-04-30 11:47:47', '游客账号6', '游客姓名6', '联系方式6', '身份证6', '酒店名称6', 6, '所在省区6', '所在城市6', '所在地区6', '入住时间6', 6, 6, '下单时间6', '总金额6', '2021-04-30 11:47:47', '取消原因6', 'http://localhost:8080/springboot073x3/upload/jiudianquxiaodingdan_tupian6.jpg', '是', '');
INSERT INTO `jiudianquxiaodingdan` VALUES (1619756178351, '2021-04-30 12:16:17', '123', '小v', '13923532031', '123456789123456789', '酒店名称5', 1, '所在省区5', '所在城市5', '所在地区5', '2021-04-30 00:00:00', 5, 1, '2021-04-30 00:00:00', '5', '2021-04-30 12:16:17', NULL, 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian5.jpg', '是', '可以');

-- ----------------------------
-- Table structure for jiudianxinxi
-- ----------------------------
DROP TABLE IF EXISTS `jiudianxinxi`;
CREATE TABLE `jiudianxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiudianmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '酒店名称',
  `jiudianjieshao` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '酒店介绍',
  `fangjianshu` int NULL DEFAULT NULL COMMENT '房间数',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `jiudianjiage` int NULL DEFAULT NULL COMMENT '酒店价格',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  `clicktime` datetime NULL DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int NULL DEFAULT 0 COMMENT '点击次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1619755664352 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '酒店信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jiudianxinxi
-- ----------------------------
INSERT INTO `jiudianxinxi` VALUES (71, '2021-04-30 11:47:47', '酒店名称1', '酒店介绍1', 1, '所在省区1', '所在城市1', '所在地区1', 1, 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian1.jpg', 4, 2, '2024-11-03 02:17:08', 17);
INSERT INTO `jiudianxinxi` VALUES (72, '2021-04-30 11:47:47', '酒店名称2', '酒店介绍2', 2, '所在省区2', '所在城市2', '所在地区2', 2, 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian2.jpg', 2, 2, '2024-11-01 13:21:13', 5);
INSERT INTO `jiudianxinxi` VALUES (73, '2021-04-30 11:47:47', '酒店名称3', '酒店介绍3', 2, '所在省区3', '所在城市3', '所在地区3', 3, 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian3.jpg', 3, 3, '2024-10-30 22:40:07', 7);
INSERT INTO `jiudianxinxi` VALUES (74, '2021-04-30 11:47:47', '酒店名称4', '酒店介绍4', 4, '所在省区4', '所在城市4', '所在地区4', 4, 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian4.jpg', 4, 4, '2021-04-30 11:47:47', 4);
INSERT INTO `jiudianxinxi` VALUES (75, '2021-04-30 11:47:47', '酒店名称5', '酒店介绍5', 4, '所在省区5', '所在城市5', '所在地区5', 5, 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian5.jpg', 5, 5, '2024-10-31 01:11:55', 8);
INSERT INTO `jiudianxinxi` VALUES (76, '2021-04-30 11:47:47', '酒店名称6', '酒店介绍6', 6, '所在省区6', '所在城市6', '所在地区6', 6, 'http://localhost:8080/springboot073x3/upload/jiudianxinxi_tupian6.jpg', 6, 6, '2021-04-30 11:47:47', 6);
INSERT INTO `jiudianxinxi` VALUES (1619755664352, '2021-04-30 12:07:43', '好酒店', NULL, 50, '省区2', '市区2', '地区2', 100, 'http://localhost:8080/springboot073x3/upload/1619755660795.jpg', 0, 0, NULL, 0);

-- ----------------------------
-- Table structure for lvyouxianlu
-- ----------------------------
DROP TABLE IF EXISTS `lvyouxianlu`;
CREATE TABLE `lvyouxianlu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` date NULL DEFAULT NULL COMMENT '游客账号',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `xianluguihua` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '线路规划',
  `xianlutupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '线路图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1619756103306 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '旅游线路' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of lvyouxianlu
-- ----------------------------
INSERT INTO `lvyouxianlu` VALUES (1, '2021-04-30 12:15:02', '2024-10-31', '新闻|北京故宫将打折', '线路规划', 'http://localhost:8081/springboot073x3/upload/news1.webp');
INSERT INTO `lvyouxianlu` VALUES (2, '2024-11-03 01:43:35', '2024-10-31', '攻略|上海购物天堂推荐', '上海是购物爱好者的天堂，拥有无数的购物中心和商业街。推荐的购物区域包括南京路步行街，这是上海最繁华的商业区；外滩一带有多个高端品牌店；此外，田子坊和新天地也有许多独特的小店和创意产品。别忘了品尝上海的特色美食如小笼包和生煎包。', 'http://localhost:8081/springboot073x3/upload/note1.webp');
INSERT INTO `lvyouxianlu` VALUES (3, '2021-04-30 11:47:47', '2024-10-31', '攻略|长城一日游攻略', '长城是中国最著名的历史遗迹之一。推荐从北京出发，选择八达岭长城或慕田峪长城进行游览。八达岭长城设施完善，适合首次游客；慕田峪长城较为原始，游客较少，适合喜欢安静和徒步的游客。无论选择哪个，都要提前准备好舒适的鞋子和水。', 'http://localhost:8081/springboot073x3/upload/note2.webp');
INSERT INTO `lvyouxianlu` VALUES (4, '2021-04-30 11:47:47', '2024-10-31', '新闻|旅游行业复苏：2024年中国出境游回暖', '随着疫情防控政策的放宽，2024年中国的出境游市场迎来了复苏的信号。旅游公司报告称，2024年春节假期，出境游人数比去年增长了40%。亚洲和欧洲成为最受欢迎的旅游目的地，而东南亚国家的海岛游和欧洲的文化旅游热度最高。业内专家预测，2024年下半年出境游市场将迎来进一步增长。', 'http://localhost:8081/springboot073x3/upload/news2.webp');
INSERT INTO `lvyouxianlu` VALUES (5, '2021-04-30 11:47:47', '2024-10-31', '攻略|桂林山水游全攻略', '桂林因山水如画而闻名，是中国最美的旅游胜地之一。推荐的行程包括：乘坐漓江游船，欣赏山水美景；参观象山公园，体验桂林的地标景观；去阳朔骑行，享受田园风光。此外，尝试当地的美食，如啤酒鱼、桂林米粉。', 'http://localhost:8081/springboot073x3/upload/note3.webp');
INSERT INTO `lvyouxianlu` VALUES (6, '2021-04-30 11:47:47', '2024-10-31', '新闻|环保意识提升，绿色旅游成新趋势', '随着环保意识的提升，越来越多的游客开始关注绿色旅游。绿色旅游倡导游客在旅游过程中尽量减少对环境的影响，如减少一次性用品的使用、选择公共交通出行、保护自然景点等。近年来，多个旅游景区推出了环保主题的活动和绿色旅游项目，受到游客的青睐。预计这一趋势将持续发展，成为未来旅游行业的重要方向。', 'http://localhost:8081/springboot073x3/upload/news3.webp');
INSERT INTO `lvyouxianlu` VALUES (7, '2021-04-30 11:47:47', '2024-10-31', '攻略|西藏拉萨旅游必去景点', '拉萨是西藏的心脏，拥有独特的宗教文化和自然景观。推荐的行程包括：参观布达拉宫，这是西藏的象征，了解藏传佛教的文化；前往大昭寺，体验藏族的朝圣文化；游览纳木错湖，享受神秘的湖泊景色。高原气候较为干燥，游客需带好防晒霜和补水用品。', 'http://localhost:8081/springboot073x3/upload/note4.webp');
INSERT INTO `lvyouxianlu` VALUES (8, '2021-04-30 11:47:47', '2024-10-31', '攻略|海南三亚度假攻略', '三亚是中国最著名的度假胜地之一，享有“东方夏威夷”的美誉。推荐行程：首先，可以去亚龙湾享受阳光沙滩，体验海上运动；然后到天涯海角，拍摄美丽的自然风光；在蜈支洲岛潜水，探秘海底世界；晚上，去三亚湾散步，欣赏浪漫的夕阳。此外，品尝三亚的海鲜大餐是必不可少的，尤其是石斑鱼和螃蟹。', 'http://localhost:8081/springboot073x3/upload/note5.webp');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `id` bigint NOT NULL COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '留言人id',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '留言内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '留言板' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (3, '2024-10-19 13:14:23', 11, '游客1', '456', '谢谢');
INSERT INTO `messages` VALUES (4, '2021-04-30 11:47:47', 6, '用户名6', '留言内容6', '回复内容6');
INSERT INTO `messages` VALUES (5, '2021-04-30 11:47:47', 5, '用户名5', '留言内容5', '回复内容5');
INSERT INTO `messages` VALUES (6, '2021-04-30 11:47:47', 4, '用户名4', '留言内容4', '回复内容4');
INSERT INTO `messages` VALUES (7, '2021-04-30 11:47:47', 3, '用户名3', '留言内容3', '回复内容3');
INSERT INTO `messages` VALUES (8, '2021-04-30 11:47:47', 2, '用户名2', '留言内容2', '回复内容2');
INSERT INTO `messages` VALUES (9, '2021-04-30 11:47:47', 1, '用户名1', '留言内容1', '回复内容1');
INSERT INTO `messages` VALUES (1733399456040, '2024-12-05 19:50:55', 11, '游客1', 'hhhh', NULL);
INSERT INTO `messages` VALUES (1734056316201, '2024-12-13 10:18:35', 11, '游客1', '非常好', NULL);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '简介',
  `picture` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1619755792578 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '旅游新闻公告' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '2021-04-30 12:09:52', '春节假期旅游预订火爆，提前规划更优惠', '春节假期即将来临，旅游产品热销中！', 'http://localhost:8081/springboot073x3/upload/notice.webp', '随着春节假期的临近，我们网站的各大旅游产品开始火爆预订，部分热门线路已经接近满员。为了确保您能顺利预订到心仪的旅行计划，建议大家提前安排。提前预定还可享受更多折扣优惠！赶快点击查看春节特惠线路吧！');
INSERT INTO `news` VALUES (2, '2024-11-01 12:21:26', '新用户注册即享旅行礼包', '欢迎新用户注册，享受专属旅行礼包！', 'http://localhost:8081/springboot073x3/upload/gonggao.webp', '为感谢新用户的支持，凡是首次注册我们的旅游网站，立即获得一个专属旅行礼包。礼包内容包括：旅行优惠券、景区门票折扣、酒店预订折扣等多重福利。赶快加入我们，开启您的旅行之旅！');
INSERT INTO `news` VALUES (3, '2021-04-30 11:47:47', '网站优化升级通知', '我们将进行网站优化升级，带来更好的用户体验。', 'http://localhost:8081/springboot073x3/upload/emergency.webp', '为了提升用户体验，我们将于2024年12月15日进行网站系统升级。升级期间，网站可能会暂时不可用，预计停机时间为1小时。升级后，我们将为您提供更加流畅和便捷的预订体验。感谢您的理解与支持！');
INSERT INTO `news` VALUES (4, '2021-04-30 11:47:47', '冬季滑雪旅游特别推荐', '冬季滑雪季即将开启，超值滑雪旅行产品上线！', 'http://localhost:8081/springboot073x3/upload/notice.webp', '寒冬已至，滑雪爱好者们的期待已久的滑雪季来临了！我们为您精心挑选了多个滑雪目的地，推出了包括滑雪课程、滑雪设施使用、酒店套餐等多项优惠组合，赶快来预定，享受滑雪带来的无限乐趣！');
INSERT INTO `news` VALUES (5, '2021-04-30 11:47:47', '旅游产品安全保障升级', '我们的网站进一步升级了旅游产品的安全保障服务。', 'http://localhost:8081/springboot073x3/upload/gonggao.webp', '为了给您的旅行提供更多保障，我们在所有旅游产品中增加了旅行意外险和旅游取消险，确保您的旅行更加安心。无论是机票、酒店、景点门票，还是定制旅游，我们都为您提供全面的安全保障。详情请查看产品页面。');
INSERT INTO `news` VALUES (6, '2021-04-30 11:47:47', '节庆旅游专属折扣优惠来袭', '节庆旅游特惠大放送，超值折扣不容错过！', 'http://localhost:8081/springboot073x3/upload/notice.webp', '由于即将迎来多个节庆活动，我们特地推出了节庆专属折扣。无论是国内游、出境游还是定制游，您都可以在网站上找到合适的节庆旅行套餐，并享受高达30%的折扣优惠。活动时间有限，赶紧抢购！');
INSERT INTO `news` VALUES (7, '2021-04-30 11:47:47', '推出定制旅游服务，享受专属旅行体验', ' 我们新增定制旅游服务，让您的旅行更加个性化。', 'http://localhost:8081/springboot073x3/upload/gonggao.webp', '现在您可以根据自己的需求和兴趣定制您的专属旅行线路！无论是奢华游、亲子游、蜜月游还是深度游，我们都能为您提供量身定制的方案。联系我们的旅游顾问，开启属于您的个性化旅行！');
INSERT INTO `news` VALUES (8, '2021-04-30 11:47:47', '关于取消部分旅游产品的公告', '由于特殊原因，部分旅游产品需进行取消。', 'http://localhost:8081/springboot073x3/upload/gonggao.webp', '由于疫情等不可抗力因素，部分旅游线路和产品将临时取消或调整。受影响的游客将会在第一时间收到我们的通知，并可选择退款或更改行程。我们深表歉意，并感谢您的理解与支持。如果您有任何疑问，请随时联系客服。');

-- ----------------------------
-- Table structure for shengqu
-- ----------------------------
DROP TABLE IF EXISTS `shengqu`;
CREATE TABLE `shengqu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '省区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '省区' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shengqu
-- ----------------------------
INSERT INTO `shengqu` VALUES (31, '2021-04-30 11:47:47', '中国');
INSERT INTO `shengqu` VALUES (32, '2021-04-30 11:47:47', '法国');
INSERT INTO `shengqu` VALUES (33, '2021-04-30 11:47:47', '美国');
INSERT INTO `shengqu` VALUES (34, '2021-04-30 11:47:47', '日本');
INSERT INTO `shengqu` VALUES (35, '2021-04-30 11:47:47', '澳大利亚');
INSERT INTO `shengqu` VALUES (36, '2021-04-30 11:47:47', '新加坡');

-- ----------------------------
-- Table structure for shiqu
-- ----------------------------
DROP TABLE IF EXISTS `shiqu`;
CREATE TABLE `shiqu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '市区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '市区' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shiqu
-- ----------------------------
INSERT INTO `shiqu` VALUES (41, '2021-04-30 11:47:47', '北京');
INSERT INTO `shiqu` VALUES (42, '2021-04-30 11:47:47', '四川');
INSERT INTO `shiqu` VALUES (43, '2021-04-30 11:47:47', '重庆');
INSERT INTO `shiqu` VALUES (44, '2021-04-30 11:47:47', '西藏');
INSERT INTO `shiqu` VALUES (45, '2021-04-30 11:47:47', '新疆');
INSERT INTO `shiqu` VALUES (46, '2021-04-30 11:47:47', '巴黎');
INSERT INTO `shiqu` VALUES (47, '2024-12-06 01:08:59', '纽约');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '用户id',
  `refid` bigint NULL DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '收藏图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1730438455871 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '收藏表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of storeup
-- ----------------------------
INSERT INTO `storeup` VALUES (1, '2021-04-30 12:13:45', 1, 23, 'jingdianxinxi', '景点', 'http://localhost:8080/springboot073x3/upload/1619755590846.jpg');
INSERT INTO `storeup` VALUES (2, '2024-02-15 10:37:41', 11, 23, 'jingdianxinxi', '景点名称3', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian3.jpg');
INSERT INTO `storeup` VALUES (3, '2024-11-01 13:20:55', 11, 21, 'jingdianxinxi', '景点名称11', 'http://localhost:8080/springboot073x3/upload/jingdianxinxi_tupian1.jpg');

-- ----------------------------
-- Table structure for techandingdan
-- ----------------------------
DROP TABLE IF EXISTS `techandingdan`;
CREATE TABLE `techandingdan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客账号',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `techanmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '特产名称',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `shumu` int NULL DEFAULT NULL COMMENT '数目',
  `jiage` int NULL DEFAULT NULL COMMENT '价格',
  `zongjine` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总金额',
  `xiadanshijian` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sfsh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '审核回复',
  `ispay` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1619755962561 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '特产订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of techandingdan
-- ----------------------------
INSERT INTO `techandingdan` VALUES (131, '2021-04-30 11:47:47', '游客账号1', '游客姓名1', '联系方式1', '特产名称1', '所在省区1', '所在城市1', '所在地区1', 1, 1, '总金额1', '2021-04-30 11:47:47', 'http://localhost:8080/springboot073x3/upload/techandingdan_tupian1.jpg', '是', '', '未支付');
INSERT INTO `techandingdan` VALUES (132, '2021-04-30 11:47:47', '游客账号2', '游客姓名2', '联系方式2', '特产名称2', '所在省区2', '所在城市2', '所在地区2', 2, 2, '总金额2', '2021-04-30 11:47:47', 'http://localhost:8080/springboot073x3/upload/techandingdan_tupian2.jpg', '是', '', '未支付');
INSERT INTO `techandingdan` VALUES (133, '2021-04-30 11:47:47', '游客账号3', '游客姓名3', '联系方式3', '特产名称3', '所在省区3', '所在城市3', '所在地区3', 3, 3, '总金额3', '2021-04-30 11:47:47', 'http://localhost:8080/springboot073x3/upload/techandingdan_tupian3.jpg', '是', '', '未支付');
INSERT INTO `techandingdan` VALUES (134, '2021-04-30 11:47:47', '游客账号4', '游客姓名4', '联系方式4', '特产名称4', '所在省区4', '所在城市4', '所在地区4', 4, 4, '总金额4', '2021-04-30 11:47:47', 'http://localhost:8080/springboot073x3/upload/techandingdan_tupian4.jpg', '是', '', '未支付');
INSERT INTO `techandingdan` VALUES (135, '2021-04-30 11:47:47', '游客账号5', '游客姓名5', '联系方式5', '特产名称5', '所在省区5', '所在城市5', '所在地区5', 5, 5, '总金额5', '2021-04-30 11:47:47', 'http://localhost:8080/springboot073x3/upload/techandingdan_tupian5.jpg', '是', '', '未支付');
INSERT INTO `techandingdan` VALUES (136, '2021-04-30 11:47:47', '游客账号6', '游客姓名6', '联系方式6', '特产名称6', '所在省区6', '所在城市6', '所在地区6', 6, 6, '总金额6', '2021-04-30 11:47:47', 'http://localhost:8080/springboot073x3/upload/techandingdan_tupian6.jpg', '是', '', '未支付');
INSERT INTO `techandingdan` VALUES (1619755962561, '2021-04-30 12:12:42', '123', '小v', '13923532031', '特产', '省区2', '市区2', '地区2', 2, 50, '100', '2021-04-30 00:00:00', 'http://localhost:8080/springboot073x3/upload/1619755720451.jpg', '是', NULL, '已支付');

-- ----------------------------
-- Table structure for techanquxiaodingdan
-- ----------------------------
DROP TABLE IF EXISTS `techanquxiaodingdan`;
CREATE TABLE `techanquxiaodingdan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客账号',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `techanmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '特产名称',
  `suozaishengqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在省区',
  `suozaichengshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `suozaidiqu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `shumu` int NULL DEFAULT NULL COMMENT '数目',
  `jiage` int NULL DEFAULT NULL COMMENT '价格',
  `zongjine` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总金额',
  `xiadanshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '下单时间',
  `quxiaoshijian` datetime NULL DEFAULT NULL COMMENT '取消时间',
  `quxiaoyuanyin` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '取消原因',
  `tupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sfsh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '审核回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1619756163434 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '特产取消订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of techanquxiaodingdan
-- ----------------------------
INSERT INTO `techanquxiaodingdan` VALUES (141, '2021-04-30 11:47:47', '游客账号1', '游客姓名1', '联系方式1', '特产名称1', '所在省区1', '所在城市1', '所在地区1', 1, 1, '总金额1', '下单时间1', '2021-04-30 11:47:47', '取消原因1', 'http://localhost:8080/springboot073x3/upload/techanquxiaodingdan_tupian1.jpg', '是', '');
INSERT INTO `techanquxiaodingdan` VALUES (142, '2021-04-30 11:47:47', '游客账号2', '游客姓名2', '联系方式2', '特产名称2', '所在省区2', '所在城市2', '所在地区2', 2, 2, '总金额2', '下单时间2', '2021-04-30 11:47:47', '取消原因2', 'http://localhost:8080/springboot073x3/upload/techanquxiaodingdan_tupian2.jpg', '是', '');
INSERT INTO `techanquxiaodingdan` VALUES (143, '2021-04-30 11:47:47', '游客账号3', '游客姓名3', '联系方式3', '特产名称3', '所在省区3', '所在城市3', '所在地区3', 3, 3, '总金额3', '下单时间3', '2021-04-30 11:47:47', '取消原因3', 'http://localhost:8080/springboot073x3/upload/techanquxiaodingdan_tupian3.jpg', '是', '');
INSERT INTO `techanquxiaodingdan` VALUES (144, '2021-04-30 11:47:47', '游客账号4', '游客姓名4', '联系方式4', '特产名称4', '所在省区4', '所在城市4', '所在地区4', 4, 4, '总金额4', '下单时间4', '2021-04-30 11:47:47', '取消原因4', 'http://localhost:8080/springboot073x3/upload/techanquxiaodingdan_tupian4.jpg', '是', '');
INSERT INTO `techanquxiaodingdan` VALUES (145, '2021-04-30 11:47:47', '游客账号5', '游客姓名5', '联系方式5', '特产名称5', '所在省区5', '所在城市5', '所在地区5', 5, 5, '总金额5', '下单时间5', '2021-04-30 11:47:47', '取消原因5', 'http://localhost:8080/springboot073x3/upload/techanquxiaodingdan_tupian5.jpg', '是', '');
INSERT INTO `techanquxiaodingdan` VALUES (146, '2021-04-30 11:47:47', '游客账号6', '游客姓名6', '联系方式6', '特产名称6', '所在省区6', '所在城市6', '所在地区6', 6, 6, '总金额6', '下单时间6', '2021-04-30 11:47:47', '取消原因6', 'http://localhost:8080/springboot073x3/upload/techanquxiaodingdan_tupian6.jpg', '是', '');
INSERT INTO `techanquxiaodingdan` VALUES (1619756163434, '2021-04-30 12:16:02', '123', '小v', '13923532031', '特产', '省区2', '市区2', '地区2', 2, 50, '100', '2021-04-30 00:00:00', '2021-04-30 12:16:03', NULL, 'http://localhost:8080/springboot073x3/upload/1619755720451.jpg', '否', NULL);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'token表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'abo', 'users', '管理员', 'xgigu40qvmfa0v7gb8hsylkb875ojjjq', '2021-04-30 11:58:34', '2024-12-06 02:34:17');
INSERT INTO `token` VALUES (2, 13, '123', 'youke', '游客', 'azaudddkfggxahw3vw93hk1nfxj344l9', '2021-04-30 12:11:33', '2021-04-30 13:17:49');
INSERT INTO `token` VALUES (3, 11, '游客1', 'youke', '游客', 'z96t4nvfe7w716fohse2rr43n1pif4xy', '2024-02-15 10:33:04', '2024-12-13 11:50:40');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123456', '管理员', '2021-04-30 11:47:47');

-- ----------------------------
-- Table structure for youke
-- ----------------------------
DROP TABLE IF EXISTS `youke`;
CREATE TABLE `youke`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youkezhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '游客账号',
  `mima` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `youkexingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `shenfenzheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `youxiang` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `touxiang` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `is_banned` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `youkezhanghao`(`youkezhanghao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1619755888204 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '游客' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of youke
-- ----------------------------
INSERT INTO `youke` VALUES (11, '2021-04-30 11:47:47', '游客1', '123456', '游客姓名1', '男', '13823888881', '440300199101010002', '773890001@qq.com', 'http://localhost:8081/springboot073x3/upload/tx7.webp', 0);
INSERT INTO `youke` VALUES (12, '2021-04-30 11:47:47', '游客2', '123456', '游客姓名2', '男', '13823888882', '440300199202020002', '773890002@qq.com', 'http://localhost:8081/springboot073x3/upload/tx1.webp', 0);
INSERT INTO `youke` VALUES (13, '2021-04-30 11:47:47', '游客3', '123456', '游客姓名3', '男', '13823888883', '440300199303030003', '773890003@qq.com', 'http://localhost:8081/springboot073x3/upload/tx72ebp', 0);
INSERT INTO `youke` VALUES (14, '2021-04-30 11:47:47', '游客4', '123456', '游客姓名4', '男', '13823888884', '440300199404040004', '773890004@qq.com', 'http://localhost:8081/springboot073x3/upload/tx3.webp', 0);
INSERT INTO `youke` VALUES (15, '2021-04-30 11:47:47', '游客5', '123456', '游客姓名5', '男', '13823888885', '440300199505050005', '773890005@qq.com', 'http://localhost:8081/springboot073x3/upload/tx4.webp', 0);
INSERT INTO `youke` VALUES (16, '2021-04-30 11:47:47', '游客6', '123456', '游客姓名6', '女', '13823888886', '440300199606060006', '773890006@qq.com', 'http://localhost:8081/springboot073x3/upload/tx5.webp', 0);
INSERT INTO `youke` VALUES (17, '2021-04-30 12:11:28', '123', '123456', '小v', '男', '13923532031', '123456789123456789', '1234561231@qq.com', 'http://localhost:8081/springboot073x3/upload/tx6.webp', 0);

-- ----------------------------
-- Procedure structure for update_unbantime
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_unbantime`;
delimiter ;;
CREATE PROCEDURE `update_unbantime`()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_bantype INT;
    DECLARE v_bantime TIMESTAMP;
    DECLARE v_unbantime TIMESTAMP;
    DECLARE cur CURSOR FOR SELECT `bantype`, `bantime` FROM `heimingdan` WHERE `unbantime` IS NULL;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO v_bantype, v_bantime;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- 根据封禁类型计算解禁时间
        IF v_bantype = 0 THEN
            SET v_unbantime = NULL; -- 永久封禁无解禁时间
        ELSEIF v_bantype = 1 THEN
            SET v_unbantime = DATE_ADD(v_bantime, INTERVAL 1 HOUR); -- 封禁一小时
        ELSEIF v_bantype = 2 THEN
            SET v_unbantime = DATE_ADD(v_bantime, INTERVAL 1 DAY); -- 封禁一天
        ELSEIF v_bantype = 3 THEN
            SET v_unbantime = DATE_ADD(v_bantime, INTERVAL 1 MONTH); -- 封禁一个月
        ELSEIF v_bantype = 4 THEN
            SET v_unbantime = DATE_ADD(v_bantime, INTERVAL 1 YEAR); -- 封禁一年
        END IF;

        -- 更新解禁时间
        UPDATE `heimingdan` SET `unbantime` = v_unbantime WHERE `bantime` = v_bantime;
    END LOOP;

    CLOSE cur;
END
;;
delimiter ;

-- ----------------------------
-- Event structure for remove_expired_blacklist
-- ----------------------------
DROP EVENT IF EXISTS `remove_expired_blacklist`;
delimiter ;;
CREATE EVENT `remove_expired_blacklist`
ON SCHEDULE
EVERY '1' HOUR STARTS '2024-12-06 08:23:18'
DO BEGIN
    -- 更新游客状态
    UPDATE `youke`
    SET `is_banned` = FALSE
    WHERE `youkezhanghao` IN (
        SELECT `youkezhanghao` FROM `heimingdan` WHERE `unbantime` <= NOW()
    );

    -- 删除黑名单中过期数据
    DELETE FROM `heimingdan`
    WHERE `unbantime` <= NOW();
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50612
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-04-12 15:37:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_delivery_order
-- ----------------------------
DROP TABLE IF EXISTS `t_delivery_order`;
CREATE TABLE `t_delivery_order` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(50) DEFAULT NULL,
  `customer_oid` bigint(20) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `create_user_id` char(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_delivery_order
-- ----------------------------
INSERT INTO `t_delivery_order` VALUES ('1', 'SP160616', '3', '2017-04-11', null, null);
INSERT INTO `t_delivery_order` VALUES ('21', 'SP160618', '3', null, null, null);

-- ----------------------------
-- Table structure for t_delivery_order_dt
-- ----------------------------
DROP TABLE IF EXISTS `t_delivery_order_dt`;
CREATE TABLE `t_delivery_order_dt` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_oid` bigint(20) NOT NULL,
  `product_oid` bigint(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `Reft_delivery_order9` (`order_oid`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_delivery_order_dt
-- ----------------------------
INSERT INTO `t_delivery_order_dt` VALUES ('31', '18', '2', '5');
INSERT INTO `t_delivery_order_dt` VALUES ('32', '18', '1', '110');
INSERT INTO `t_delivery_order_dt` VALUES ('33', '21', '2', '2');

-- ----------------------------
-- Table structure for t_permissions
-- ----------------------------
DROP TABLE IF EXISTS `t_permissions`;
CREATE TABLE `t_permissions` (
  `id` int(11) NOT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `resources_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `role_code` int(11) DEFAULT NULL COMMENT '角色编号',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限表（给角色分配权限）';

-- ----------------------------
-- Records of t_permissions
-- ----------------------------
INSERT INTO `t_permissions` VALUES ('1', null, '1', '1', '1');
INSERT INTO `t_permissions` VALUES ('2', null, '2', '1', '1');
INSERT INTO `t_permissions` VALUES ('3', null, '3', '1', '1');
INSERT INTO `t_permissions` VALUES ('4', null, '4', '1', '1');
INSERT INTO `t_permissions` VALUES ('5', null, '5', '1', '1');
INSERT INTO `t_permissions` VALUES ('6', null, '1', '2', '1');
INSERT INTO `t_permissions` VALUES ('7', null, '2', '2', '1');
INSERT INTO `t_permissions` VALUES ('8', null, '3', '2', '1');
INSERT INTO `t_permissions` VALUES ('9', null, '4', '3', '1');
INSERT INTO `t_permissions` VALUES ('10', null, '5', '3', '1');
INSERT INTO `t_permissions` VALUES ('11', null, '6', '1', '1');
INSERT INTO `t_permissions` VALUES ('12', null, '6', '2', '1');
INSERT INTO `t_permissions` VALUES ('13', null, '7', '1', '1');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `provider_oid` bigint(20) NOT NULL,
  `p_name` varchar(200) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `outline` int(11) DEFAULT NULL,
  `pack_type` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `unit_type` int(11) DEFAULT NULL,
  `price` double(18,2) DEFAULT NULL,
  `add_date` date DEFAULT NULL,
  `create_user_id` char(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `Reft_provider3` (`provider_oid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '1', '发光二极管1', '123', '321', '1', null, '1', '1.30', '2016-11-16', null, null);
INSERT INTO `t_product` VALUES ('2', '1', '发光二极管2', '123', '321', '1', null, '1', '1.20', '2016-11-16', null, null);
INSERT INTO `t_product` VALUES ('3', '2', '发光二极管3', '123', '321', '2', null, '2', '2.03', '2016-11-16', null, null);

-- ----------------------------
-- Table structure for t_product_order
-- ----------------------------
DROP TABLE IF EXISTS `t_product_order`;
CREATE TABLE `t_product_order` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(50) DEFAULT NULL,
  `provider_oid` bigint(20) DEFAULT NULL,
  `warehouse_oid` bigint(20) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `description` text,
  `create_user_id` char(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product_order
-- ----------------------------
INSERT INTO `t_product_order` VALUES ('50', 'DD001', '1', '1', '2016-12-01 17:09:58', '2', null, null, null);
INSERT INTO `t_product_order` VALUES ('51', 'DD002', '1', '2', '2016-12-01 17:25:16', '2', null, null, null);
INSERT INTO `t_product_order` VALUES ('52', 'DD003', '1', '1', '2016-12-01 17:48:34', '2', null, null, null);
INSERT INTO `t_product_order` VALUES ('53', 'DD004', '1', '1', '2016-12-10 13:51:12', '2', null, null, null);

-- ----------------------------
-- Table structure for t_product_order_dt
-- ----------------------------
DROP TABLE IF EXISTS `t_product_order_dt`;
CREATE TABLE `t_product_order_dt` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_oid` bigint(20) NOT NULL,
  `product_oid` bigint(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `Reft_order5` (`order_oid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product_order_dt
-- ----------------------------
INSERT INTO `t_product_order_dt` VALUES ('26', '50', '2', '2');
INSERT INTO `t_product_order_dt` VALUES ('27', '50', '1', '1');
INSERT INTO `t_product_order_dt` VALUES ('28', '51', '2', '30');
INSERT INTO `t_product_order_dt` VALUES ('29', '51', '1', '233');
INSERT INTO `t_product_order_dt` VALUES ('30', '52', '2', '331');
INSERT INTO `t_product_order_dt` VALUES ('31', '53', '2', '444');
INSERT INTO `t_product_order_dt` VALUES ('32', '53', '1', '123');

-- ----------------------------
-- Table structure for t_provider
-- ----------------------------
DROP TABLE IF EXISTS `t_provider`;
CREATE TABLE `t_provider` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `linkman` varchar(50) DEFAULT NULL,
  `linkman_telphone` varchar(20) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `type` char(1) DEFAULT NULL COMMENT '0：供应商，1：客户',
  `create_user_id` char(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_provider
-- ----------------------------
INSERT INTO `t_provider` VALUES ('1', '北京华联', '北京昌平区回龙观20号', '许三多', '01023698742', '01023698742', '0', null, null);
INSERT INTO `t_provider` VALUES ('2', '北京国安', '北京朝阳区北路23号', '王刁刁', '01088956327', '01088956327', '0', null, null);
INSERT INTO `t_provider` VALUES ('3', '常州市明健电子有限公司', null, '周小姐', '18869963549', '18869963549', '1', null, null);

-- ----------------------------
-- Table structure for t_stock
-- ----------------------------
DROP TABLE IF EXISTS `t_stock`;
CREATE TABLE `t_stock` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_oid` bigint(20) NOT NULL,
  `provider_oid` bigint(20) DEFAULT NULL,
  `product_oid` bigint(20) DEFAULT NULL,
  `warehouse_oid` bigint(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stock
-- ----------------------------
INSERT INTO `t_stock` VALUES ('5', '50', '1', '2', '1', '0', '2016-12-01 17:24:29');
INSERT INTO `t_stock` VALUES ('6', '50', '1', '1', '1', '1', '2016-12-01 17:24:29');
INSERT INTO `t_stock` VALUES ('7', '51', '1', '2', '2', '30', '2016-12-01 17:25:26');
INSERT INTO `t_stock` VALUES ('8', '51', '1', '1', '2', '233', '2016-12-01 17:25:26');
INSERT INTO `t_stock` VALUES ('9', '52', '1', '2', '1', '331', '2016-12-01 17:48:42');
INSERT INTO `t_stock` VALUES ('10', '53', '1', '2', '1', '444', '2016-12-10 13:51:44');
INSERT INTO `t_stock` VALUES ('11', '53', '1', '1', '1', '4', '2016-12-10 13:51:44');

-- ----------------------------
-- Table structure for t_sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_resources`;
CREATE TABLE `t_sys_resources` (
  `reid` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(100) DEFAULT NULL COMMENT '资源名称',
  `breadcrub` varchar(100) DEFAULT NULL COMMENT 'tab标题名称',
  `path` varchar(100) DEFAULT NULL COMMENT '资源请求路径',
  `parentid` int(11) DEFAULT NULL,
  `type` int(11) NOT NULL COMMENT '0菜单  1按钮',
  `dateline` bigint(20) DEFAULT NULL,
  `sort` int(10) DEFAULT NULL COMMENT '菜单顺序',
  PRIMARY KEY (`reid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_sys_resources
-- ----------------------------
INSERT INTO `t_sys_resources` VALUES ('1', '订单/产品管理', '订单/产品管理', '', '0', '0', null, '3');
INSERT INTO `t_sys_resources` VALUES ('2', '订单管理', '订单管理', '/web/pages/order/order_list.html', '1', '0', null, '1');
INSERT INTO `t_sys_resources` VALUES ('3', '库存管理', '库存管理', '/web/pages/stock/stock_list.html', '1', '0', null, '2');
INSERT INTO `t_sys_resources` VALUES ('4', '系统管理', '系统管理', '', '0', '0', null, '3');
INSERT INTO `t_sys_resources` VALUES ('5', '菜单管理', '菜单管理', '/web/pages/sys/menu/menu.html', '4', '0', null, '3');
INSERT INTO `t_sys_resources` VALUES ('6', '送货单管理', '送货单管理', '/web/pages/order/delivery_order_list.html', '1', '0', '20170411144233', '3');
INSERT INTO `t_sys_resources` VALUES ('7', '对账单', '对账单', '', '1', '0', '20170411144308', '4');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `create_time` bigint(20) DEFAULT NULL,
  `role_code` int(11) DEFAULT NULL COMMENT '角色编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '系统管理员', null, '1', '1');

-- ----------------------------
-- Table structure for t_sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_resources`;
CREATE TABLE `t_sys_role_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reid` bigint(20) NOT NULL,
  `roid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_resources
-- ----------------------------
INSERT INTO `t_sys_role_resources` VALUES ('1', '1', '1');
INSERT INTO `t_sys_role_resources` VALUES ('2', '2', '1');
INSERT INTO `t_sys_role_resources` VALUES ('3', '3', '1');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `uid` int(11) NOT NULL COMMENT '用户编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `login_id` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', '系统管理员', 'admin', 'admin', null, '2015-11-01', 'admin@16wiwi.com', '0', '18600211561', '20160504155254');

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` bigint(11) NOT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `rid` bigint(11) NOT NULL,
  `uid` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('1', null, '1', '1');

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `linkman_name` varchar(50) DEFAULT NULL,
  `linkman_telephone` varchar(10) DEFAULT NULL,
  `create_user_id` char(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------
INSERT INTO `t_warehouse` VALUES ('1', '无锡仓库', '无锡市北大街22号', '吴曦', '1860000000', null, null);
INSERT INTO `t_warehouse` VALUES ('2', '兰州仓库', '安宁区11号路', '许三多', '1390000000', null, null);

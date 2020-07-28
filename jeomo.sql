/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : jeomo

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-07-28 09:23:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_data
-- ----------------------------
DROP TABLE IF EXISTS `base_data`;
CREATE TABLE `base_data` (
  `id` bigint(20) NOT NULL,
  `base_id` bigint(20) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_data
-- ----------------------------

-- ----------------------------
-- Table structure for base_data_type
-- ----------------------------
DROP TABLE IF EXISTS `base_data_type`;
CREATE TABLE `base_data_type` (
  `id` bigint(20) NOT NULL,
  `base_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_data_type
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for flash_sale_activity
-- ----------------------------
DROP TABLE IF EXISTS `flash_sale_activity`;
CREATE TABLE `flash_sale_activity` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flash_sale_activity
-- ----------------------------

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flyway_schema_history
-- ----------------------------
INSERT INTO `flyway_schema_history` VALUES ('1', '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', null, 'root', '2020-07-17 19:14:23', '0', '1');
INSERT INTO `flyway_schema_history` VALUES ('2', '1.2', 'schema', 'SQL', 'V1.2__schema.sql', '1235396665', 'root', '2020-07-17 19:14:23', '87', '1');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for mall
-- ----------------------------
DROP TABLE IF EXISTS `mall`;
CREATE TABLE `mall` (
  `id` bigint(20) NOT NULL,
  `org_code` varchar(20) DEFAULT NULL,
  `group_code` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall
-- ----------------------------
INSERT INTO `mall` VALUES ('1', '1', '100', '001', '北京久萌一店', '0');

-- ----------------------------
-- Table structure for mall_group
-- ----------------------------
DROP TABLE IF EXISTS `mall_group`;
CREATE TABLE `mall_group` (
  `id` bigint(20) NOT NULL,
  `org_code` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL COMMENT '角色代码',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_group
-- ----------------------------
INSERT INTO `mall_group` VALUES ('1', '1', '100', '北京久萌', null);

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) unsigned NOT NULL,
  `org_code` varchar(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `name` varchar(30) DEFAULT '' COMMENT '姓名',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `last_access_time` datetime DEFAULT NULL COMMENT '最近访问时间（包含注册，消费或者参与活动等）',
  `first_open_mall_code` varchar(10) DEFAULT NULL COMMENT '注册商场ID',
  `open_time` datetime DEFAULT NULL COMMENT '注册时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  `last_access_mall_code` varchar(10) DEFAULT NULL COMMENT '最后访问门店',
  PRIMARY KEY (`id`),
  UNIQUE KEY `手机号唯一索引` (`phone`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1283661466663665665', '1', '100000000', null, '16000112234', null, null, null, null, null, '2020-07-16 15:15:17', '001', '2020-07-16 15:15:17', null, '001');

-- ----------------------------
-- Table structure for member_card
-- ----------------------------
DROP TABLE IF EXISTS `member_card`;
CREATE TABLE `member_card` (
  `id` bigint(20) NOT NULL,
  `org_code` varchar(10) DEFAULT NULL,
  `mall_group_code` varchar(10) DEFAULT NULL COMMENT '同城门店号',
  `member_code` varchar(20) DEFAULT NULL,
  `code` varchar(11) NOT NULL COMMENT '会员卡号',
  `level` bigint(11) DEFAULT NULL,
  `open_mall_code` bigint(20) DEFAULT NULL,
  `open_time` datetime DEFAULT NULL COMMENT '开卡时间',
  `status` int(11) DEFAULT NULL,
  `last_check_time` datetime DEFAULT NULL COMMENT '身份最后检查时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_card
-- ----------------------------
INSERT INTO `member_card` VALUES ('1283671148216233986', '1', '100', '100000001', '10000000000', '1', '1', '2020-07-16 15:53:45', '0', '2020-07-16 15:53:45', null);
INSERT INTO `member_card` VALUES ('1283671165140250625', '1', '100', '100000001', '10000000001', '1', '1', '2020-07-16 15:53:49', '0', '2020-07-16 15:53:49', null);
INSERT INTO `member_card` VALUES ('1283671573875175426', '1', '100', '100000001', '10000000002', '1', '1', '2020-07-16 15:54:02', '0', '2020-07-16 15:54:02', null);
INSERT INTO `member_card` VALUES ('1283678285722042369', '1', '100', '100000000', '10000000003', '1', '1', '2020-07-16 16:22:07', '0', '2020-07-16 16:22:07', null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL,
  `mall_id` bigint(255) DEFAULT NULL COMMENT '购物中心ID',
  `order_no` varchar(50) DEFAULT NULL COMMENT '订单号',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '消费人ID',
  `customer_level` int(11) DEFAULT NULL COMMENT '消费级别',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '消费商户ID',
  `goods_num` int(11) DEFAULT NULL COMMENT '商品件数',
  `goods_amount` decimal(11,2) DEFAULT NULL COMMENT '商品总金额',
  `outlets_amount` decimal(11,2) DEFAULT '0.00' COMMENT '折扣金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '顾客实际支付金额',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `status` tinyint(2) DEFAULT NULL COMMENT '订单状态，-3已退货(如果是退货单则没有该状态) -2 超时取消 -1待支付(退款)  0已完成',
  `refund` tinyint(1) DEFAULT NULL COMMENT '是否为退货单， 0代表否 1代表是',
  `version` int(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods
-- ----------------------------

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` bigint(20) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES ('1', '1', '久萌集团', '0');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(100) NOT NULL,
  `last` varchar(100) NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `placeofbirth` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'Dursun', 'KOC', '1982-02-10', 'Erzincan');
INSERT INTO `person` VALUES ('2', 'Durseeun', 'KeeOC', '1982-05-10', 'Erzeeincan');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL COMMENT '类型名称',
  `name` varchar(20) NOT NULL COMMENT '展示值',
  `value` char(1) NOT NULL COMMENT '使用',
  `fixed` char(1) NOT NULL DEFAULT '1' COMMENT '是否不可更改',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` char(10) NOT NULL COMMENT '类型名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL,
  `code` varchar(20) DEFAULT NULL COMMENT '菜单编码',
  `label` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `parent_code` varchar(20) DEFAULT NULL COMMENT '父ID',
  `sort` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `org_code` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL COMMENT '角色代码',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL COMMENT '主键',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色id',
  `menu_code` varchar(20) DEFAULT NULL COMMENT '菜单ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单对照表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `org_code` varchar(20) DEFAULT NULL COMMENT '所属组织',
  `mall_code` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL COMMENT '用户名/登录名',
  `nickname` varchar(30) NOT NULL COMMENT '姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `email` char(50) DEFAULT NULL COMMENT '邮箱',
  `phone` char(20) DEFAULT NULL COMMENT '手机号',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `last_access_time` timestamp NULL DEFAULT NULL COMMENT '最后访问时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(20) NOT NULL COMMENT '用户ID',
  `role_code` varchar(20) NOT NULL COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关系表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

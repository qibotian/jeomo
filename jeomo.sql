/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : jeomo

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-07-10 17:57:40
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
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for base_data_type
-- ----------------------------
DROP TABLE IF EXISTS `base_data_type`;
CREATE TABLE `base_data_type` (
  `id` bigint(20) NOT NULL,
  `base_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for mall
-- ----------------------------
DROP TABLE IF EXISTS `mall`;
CREATE TABLE `mall` (
  `id` bigint(20) NOT NULL,
  `base_id` int(5) DEFAULT NULL COMMENT '角色代码',
  `org_id` int(11) DEFAULT NULL,
  `group_id` int(5) DEFAULT NULL,
  `name` varchar(40) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for mall_group
-- ----------------------------
DROP TABLE IF EXISTS `mall_group`;
CREATE TABLE `mall_group` (
  `id` bigint(20) NOT NULL,
  `group_id` int(5) NOT NULL COMMENT '角色代码',
  `org_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` varchar(20) NOT NULL,
  `org_id` int(11) NOT NULL,
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `birthday` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `last_access_time` datetime DEFAULT NULL COMMENT '最后访问时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  `first_open_mall_id` bigint(20) DEFAULT NULL COMMENT '注册商场ID',
  `open_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `手机号唯一索引` (`phone`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=1281494398065446915 DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Table structure for member_card
-- ----------------------------
DROP TABLE IF EXISTS `member_card`;
CREATE TABLE `member_card` (
  `id` bigint(20) NOT NULL,
  `org_id` int(11) DEFAULT NULL,
  `member_id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mall_group_id` int(5) DEFAULT NULL COMMENT '同城门店号',
  `card_no` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `level` bigint(11) DEFAULT NULL,
  `open_mall_id` bigint(20) DEFAULT NULL,
  `open_time` datetime DEFAULT NULL COMMENT '开卡时间',
  `status` int(11) DEFAULT NULL,
  `last_check_time` datetime DEFAULT NULL COMMENT '身份最后检查时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` bigint(20) NOT NULL,
  `base_id` int(11) DEFAULT NULL,
  `org_name` varchar(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL,
  `label` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID',
  `sort` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `code` varchar(20) DEFAULT NULL COMMENT '角色代码',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单对照表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` char(30) NOT NULL COMMENT '姓名',
  `login_name` char(30) DEFAULT NULL COMMENT '登录名',
  `password` char(50) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` char(50) DEFAULT NULL COMMENT '邮箱',
  `phone` char(20) DEFAULT NULL COMMENT '手机号',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `last_access_time` timestamp NULL DEFAULT NULL COMMENT '最后访问时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `last_modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关系表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `NAME` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

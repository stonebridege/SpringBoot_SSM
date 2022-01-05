CREATE DATABASE IF NOT EXISTS `mybatis-example`;

USE `mybatis-example`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
    `id`        bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_name` varchar(20) NOT NULL COMMENT '用户名',
    `password`  varchar(20) NOT NULL COMMENT '密码',
    `name`      varchar(30) DEFAULT NULL COMMENT '姓名',
    `age`       int(11)     DEFAULT NULL COMMENT '年龄',
    `email`     varchar(50) DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB  AUTO_INCREMENT = 1  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`(
    `emp_id`     int(11) NOT NULL AUTO_INCREMENT,
    `emp_name`   char(100)     DEFAULT NULL,
    `emp_salary` double(10, 5) DEFAULT NULL,
    PRIMARY KEY (`emp_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

#---------------------------------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------------------

CREATE DATABASE IF NOT EXISTS `mydb`;
USE `mydb`;

DROP TABLE IF EXISTS `sp_goods`;
CREATE TABLE `sp_goods` (
    `goods_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `goods_name` varchar(255) NOT NULL COMMENT '商品名称',
    `goods_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
    `goods_number` int(8) unsigned NOT NULL DEFAULT '0' COMMENT '商品数量',
    `goods_weight` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品重量',
    `cat_id` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '类型id',
    `goods_introduce` text COMMENT '商品详情介绍',
    `goods_big_logo` char(128) NOT NULL DEFAULT '' COMMENT '图片logo大图',
    `goods_small_logo` char(128) NOT NULL DEFAULT '' COMMENT '图片logo小图',
    `is_del` enum('0','1') NOT NULL DEFAULT '0' COMMENT '0:正常  1:删除',
    `add_time` int(11) NOT NULL COMMENT '添加商品时间',
    `upd_time` int(11) NOT NULL COMMENT '修改商品时间',
    `delete_time` int(11) DEFAULT NULL COMMENT '软删除标志字段',
    `cat_one_id` smallint(5) DEFAULT '0' COMMENT '一级分类id',
    `cat_two_id` smallint(5) DEFAULT '0' COMMENT '二级分类id',
    `cat_three_id` smallint(5) DEFAULT '0' COMMENT '三级分类id',
    `hot_mumber` int(11) unsigned DEFAULT '0' COMMENT '热卖数量',
    `is_promote` smallint(5) DEFAULT '0' COMMENT '是否促销',
    `goods_state` int(11) DEFAULT '0' COMMENT '商品状态 0: 未通过 1: 审核中 2: 已审核',
    PRIMARY KEY (`goods_id`),
    UNIQUE KEY `goods_name` (`goods_name`),
    KEY `goods_price` (`goods_price`),
    KEY `add_time` (`add_time`),
    KEY `goods_name_2` (`goods_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';

SET
FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_name` varchar(20) NOT NULL COMMENT '用户名',
    `password`  varchar(20) NOT NULL COMMENT '密码',
    `name`      varchar(30) DEFAULT NULL COMMENT '姓名',
    `age`       int(11) DEFAULT NULL COMMENT '年龄',
    `email`     varchar(50) DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

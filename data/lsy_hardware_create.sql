DROP TABLE IF EXISTS `lsy_hardware`.`manager`;
CREATE TABLE `manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL COMMENT '姓名',
  `age` int unsigned NOT NULL COMMENT '年龄',
  `phone` varchar(32) NOT NULL COMMENT '手机号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `role` varchar(2) NOT NULL COMMENT '角色[1：超级管理员，2：普通管理员]',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '管理员';

DROP TABLE IF EXISTS `lsy_hardware`.`user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(60) NOT NULL COMMENT '密码',,
  `phone` varchar(32) NOT NULL COMMENT '手机号',
  `enable` tinyint(4) NOT NULL DEFAULT  '1' COMMENT '用户是否可用',
  `roles` varchar(60) NOT NULL COMMENT '角色[多个角色逗号隔开]',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user(username ,password,phone,enable,roles,create_time,modify_time) values
("admin","123","15262578211","1","ROLE_ADMIN,ROLE_USER",now(),now()),
("user","123","15262578222","1","ROLE_USER",now(),now());


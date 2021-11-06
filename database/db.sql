create database venus;

CREATE TABLE `venus`.`t_user_info` (
  `id` BIGINT NOT NULL COMMENT '主键id',
  `name` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '名字',
  `age` INT NOT NULL DEFAULT 0,
  `version` INT NOT NULL DEFAULT 0,
  `deleted` INT NOT NULL DEFAULT 0 COMMENT '标记删除',
  `create_id` VARCHAR(45) NOT NULL DEFAULT '',
  `create_name` VARCHAR(45) NOT NULL DEFAULT '',
  `update_id` VARCHAR(45) NOT NULL DEFAULT '',
  `update_name` VARCHAR(45) NOT NULL DEFAULT '',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`id`));
ALTER TABLE `venus`.`t_user_info`
COMMENT = '用户信息表' ;


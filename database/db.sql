create
database venus;

CREATE TABLE `venus`.`t_user_info`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        VARCHAR(45) NOT NULL DEFAULT '' COMMENT '名字',
    `username`    VARCHAR(45) NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    VARCHAR(45) NOT NULL DEFAULT '' COMMENT '密码',
    `age`         INT         NOT NULL DEFAULT 0,
    `version`     INT         NOT NULL DEFAULT 0,
    `deleted`     INT(2) NOT NULL DEFAULT 0 COMMENT '标记删除',
    `create_id`   VARCHAR(45) NOT NULL DEFAULT '',
    `create_name` VARCHAR(45) NOT NULL DEFAULT '',
    `update_id`   VARCHAR(45) NOT NULL DEFAULT '',
    `update_name` VARCHAR(45) NOT NULL DEFAULT '',
    `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `update_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';


CREATE TABLE `t_role`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `role_name`   varchar(255)         DEFAULT NULL,
    `version`     INT         NOT NULL DEFAULT 0,
    `deleted`     INT(2) NOT NULL DEFAULT 0 COMMENT '标记删除',
    `create_id`   VARCHAR(45) NOT NULL DEFAULT '',
    `create_name` VARCHAR(45) NOT NULL DEFAULT '',
    `update_id`   VARCHAR(45) NOT NULL DEFAULT '',
    `update_name` VARCHAR(45) NOT NULL DEFAULT '',
    `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `update_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';


CREATE TABLE `t_user_role`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`     varchar(50) NOT NULL,
    `role_id`     varchar(50) NOT NULL COMMENT '用户角色',
    `version`     INT         NOT NULL DEFAULT 0,
    `deleted`     INT(2) NOT NULL DEFAULT 0 COMMENT '标记删除',
    `create_id`   VARCHAR(45) NOT NULL DEFAULT '',
    `create_name` VARCHAR(45) NOT NULL DEFAULT '',
    `update_id`   VARCHAR(45) NOT NULL DEFAULT '',
    `update_name` VARCHAR(45) NOT NULL DEFAULT '',
    `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `update_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

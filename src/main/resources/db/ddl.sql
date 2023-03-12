CREATE TABLE `data_dict` (
     `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `parent_dict_item_code` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '父级字典项的编码,用于支持同字典类型下多层级的字典组织结构,无复杂层级默认赋0即可',
     `dict_type_code` VARCHAR ( 100 ) NOT NULL DEFAULT '0' COMMENT '字典类型编码',
     `dict_type_name` VARCHAR ( 50 ) NOT NULL DEFAULT '' COMMENT '字典类型名称',
     `dict_item_code` VARCHAR ( 100 ) NOT NULL DEFAULT '0' COMMENT '字典项编码',
     `dict_item_name` VARCHAR ( 50 ) NOT NULL DEFAULT '' COMMENT '字典项名称',
     `ext_info` VARCHAR ( 200 ) NOT NULL DEFAULT '' COMMENT '字典项扩展信息 json格式',
     `level_sort` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '同层级排列顺序',
     `enabled` TINYINT(1) UNSIGNED NOT NULL DEFAULT '1' COMMENT '是否启用 默认启用',
     `user_id_create` VARCHAR ( 50 ) NOT NULL DEFAULT '' COMMENT '创建者用户id',
     `user_id_update` VARCHAR ( 50 ) NOT NULL DEFAULT '' COMMENT '更新者用户id',
     `time_create` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
     `time_update` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
     PRIMARY KEY ( `id` ),
     UNIQUE KEY `uk_dicttypecode_dictcode` ( `dict_type_code`, `dict_item_code` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '数据字典表';
CREATE SCHEMA IF NOT EXISTS unit_test;
SET SCHEMA unit_test;

CREATE TABLE `data_dict`
(
    `id`                    int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `parent_dict_item_code` int(11)      NOT NULL DEFAULT '0' COMMENT '父级字典项的编码,用于支持同字典类型下多层级的字典组织结构,无复杂层级默认赋0即可',
    `dict_type_code`        varchar(100) NOT NULL DEFAULT '0' COMMENT '字典类型编码',
    `dict_type_name`        varchar(50)  NOT NULL DEFAULT '' COMMENT '字典类型名称',
    `dict_item_code`        varchar(100) NOT NULL DEFAULT '0' COMMENT '字典项编码',
    `dict_item_name`        varchar(50)  NOT NULL DEFAULT '' COMMENT '字典项名称',
    `ext_info`              varchar(200) NOT NULL DEFAULT '' COMMENT '字典项扩展信息 json格式',
    `level_sort`            tinyint(3)   NOT NULL DEFAULT '0' COMMENT '同层级排列顺序',
    `enabled`               tinyint(3)   NOT NULL DEFAULT '1' COMMENT '是否启用 默认启用',
    `user_id_create`        varchar(50)  NOT NULL DEFAULT '' COMMENT '创建者用户id',
    `user_id_update`        varchar(50)  NOT NULL DEFAULT '' COMMENT '更新者用户id',
    `time_create`           bigint(20)   NOT NULL DEFAULT '0' COMMENT '创建时间',
    `time_update`           bigint(20)   NOT NULL DEFAULT '0' COMMENT '更新时间'
);

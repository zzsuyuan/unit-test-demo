package com.noob.ut.infrastructure.gatewayimpl.database.dataobject.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 数据字典表
 */
@Data
@TableName(value ="unit_test.data_dict")
public class DataDictEntity {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级字典项的编码,用于支持同字典类型下多层级的字典组织结构,无复杂层级默认赋0即可
     */
    @TableField(value = "parent_dict_item_code")
    private Integer parentDictItemCode;

    /**
     * 字典类型编码
     */
    @TableField(value = "dict_type_code")
    private String dictTypeCode;

    /**
     * 字典类型名称
     */
    @TableField(value = "dict_type_name")
    private String dictTypeName;

    /**
     * 字典项编码
     */
    @TableField(value = "dict_item_code")
    private String dictItemCode;

    /**
     * 字典项名称
     */
    @TableField(value = "dict_item_name")
    private String dictItemName;

    /**
     * 字典项扩展信息 json格式
     */
    @TableField(value = "ext_info")
    private String extInfo;

    /**
     * 同层级排列顺序
     */
    @TableField(value = "level_sort")
    private Integer levelSort;

    /**
     * 是否启用 默认启用
     */
    @TableField(value = "enabled")
    private Boolean enabled;

    /**
     * 创建者用户id
     */
    @TableField(value = "user_id_create")
    private String userIdCreate;

    /**
     * 更新者用户id
     */
    @TableField(value = "user_id_update")
    private String userIdUpdate;

    /**
     * 创建时间
     */
    @TableField(value = "time_create")
    private Long timeCreate;

    /**
     * 更新时间
     */
    @TableField(value = "time_update")
    private Long timeUpdate;

}
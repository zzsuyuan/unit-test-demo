package com.noob.ut.domain.dict;

import lombok.Data;


@Data
public class DataDict {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父级字典项的编码,用于支持同字典类型下多层级的字典组织结构,无复杂层级默认赋0即可
     */
    private Integer parentDictItemCode;

    /**
     * 字典类型编码
     */
    private String dictTypeCode;

    /**
     * 字典类型名称
     */
    private String dictTypeName;

    /**
     * 字典项编码
     */
    private String dictItemCode;

    /**
     * 字典项名称
     */
    private String dictItemName;

    /**
     * 字典项扩展信息 json格式
     */
    private String extInfo;

    /**
     * 同层级排列顺序
     */
    private Integer levelSort;

    /**
     * 是否启用 默认启用
     */
    private Boolean enabled;

    /**
     * 创建者用户id
     */
    private String userIdCreate;

    /**
     * 更新者用户id
     */
    private String userIdUpdate;

    /**
     * 创建时间
     */
    private Long timeCreate;

    /**
     * 更新时间
     */
    private Long timeUpdate;

}

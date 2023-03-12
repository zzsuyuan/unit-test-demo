package com.noob.ut.client.dto.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("数据字典项VO")
public class DataDictVO {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("父级字典项的编码,用于支持同字典类型下多层级的字典组织结构,无复杂层级默认赋0即可")
    private Integer parentDictItemCode;

    @ApiModelProperty("字典类型编码")
    private String dictTypeCode;

    @ApiModelProperty("字典类型名称")
    private String dictTypeName;

    @ApiModelProperty("字典项编码")
    private String dictItemCode;

    @ApiModelProperty("字典项名称")
    private String dictItemName;

    @ApiModelProperty("字典项扩展信息 json格式")
    private String extInfo;

    @ApiModelProperty("同层级排列顺序")
    private Integer levelSort;

}

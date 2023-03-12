package com.noob.ut.controller;

import com.noob.ut.client.api.DataDictService;
import com.noob.ut.client.dto.vo.DataDictVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/data_dict")
@Api(description = "数据字典")
public class DataDictController {

    @Autowired
    private DataDictService dataDictService;

    @ApiOperation(value = "数据字典")
    @GetMapping(value = "/list_by_type_code")
    public ResponseEntity<List<DataDictVO>> listByTypeCode(@RequestParam("dict_type_code") String dictTypeCode) {
        List<DataDictVO> list = dataDictService.listByTypeCode(dictTypeCode);
        return ResponseEntity.ok(list);
    }

}

package com.noob.ut.client.api;

import com.noob.ut.client.dto.vo.DataDictVO;

import java.util.List;


public interface DataDictService {

    List<DataDictVO> listByTypeCode(String dictTypeCode);

}

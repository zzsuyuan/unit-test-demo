package com.noob.ut.domain.gateway;


import com.noob.ut.domain.dict.DataDict;

import java.util.List;

public interface DataDictGateway {

    List<DataDict> listByDictTypeCode(String dictTypeCode);

}
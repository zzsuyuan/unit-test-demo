package com.noob.ut.app.service;

import com.noob.ut.client.api.DataDictService;
import com.noob.ut.client.dto.vo.DataDictVO;
import com.noob.ut.domain.dict.DataDict;
import com.noob.ut.domain.gateway.DataDictGateway;
import com.noob.ut.infrastructure.common.utils.MyBeanCopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;


@Slf4j
@Service
public class DataDictServiceImpl implements DataDictService {

    @Autowired
    private DataDictGateway dataDictGateway;

    @Override
    public List<DataDictVO> listByTypeCode(String dictTypeCode) {
        List<DataDict> dataDicts = dataDictGateway.listByDictTypeCode(dictTypeCode);
        if (CollectionUtils.isEmpty(dataDicts)) {
            return Collections.emptyList();
        }
        return MyBeanCopyUtils.copyListProperties(dataDicts,DataDictVO::new);
    }

}

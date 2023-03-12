package com.noob.ut.infrastructure.gatewayimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.noob.ut.domain.dict.DataDict;
import com.noob.ut.domain.gateway.DataDictGateway;
import com.noob.ut.infrastructure.common.utils.MyBeanCopyUtils;
import com.noob.ut.infrastructure.gatewayimpl.database.dalservice.DataDictDALService;
import com.noob.ut.infrastructure.gatewayimpl.database.dataobject.po.DataDictEntity;
import com.noob.ut.infrastructure.gatewayimpl.database.mapper.DataDictMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;


@Slf4j
@Component
public class DataDictGatewayImpl implements DataDictGateway {

    @Autowired
    private DataDictDALService dataDictDALService;

    @Autowired
    private DataDictMapper dataDictMapper;

    @Override
    public List<DataDict> listByDictTypeCode(String dictTypeCode) {
        List<DataDictEntity> list = dataDictDALService.list(new LambdaQueryWrapper<DataDictEntity>()
                .eq(DataDictEntity::getDictTypeCode, dictTypeCode)
                .eq(DataDictEntity::getEnabled, true)
                .orderByAsc(DataDictEntity::getLevelSort)
        );
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return MyBeanCopyUtils.copyListProperties(list, DataDict::new);
    }

}



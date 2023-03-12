package com.noob.ut.infrastructure.gatewayimpl.database.dalservice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.ut.infrastructure.gatewayimpl.database.dalservice.DataDictDALService;
import com.noob.ut.infrastructure.gatewayimpl.database.dataobject.po.DataDictEntity;
import com.noob.ut.infrastructure.gatewayimpl.database.mapper.DataDictMapper;
import org.springframework.stereotype.Service;

/**
 * 数据字典表 数据库操作Service实现
 */
@Service
public class DataDictDALServiceImpl extends ServiceImpl<DataDictMapper, DataDictEntity>
        implements DataDictDALService {

}





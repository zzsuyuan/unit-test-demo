package com.noob.ut.infrastructure.gatewayimpl;

import com.noob.ut.domain.dict.DataDict;
import com.noob.ut.domain.gateway.DataDictGateway;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: zhengwq
 * datetime: 2023-03-12 17:38
 * description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class DataDictGatewayImplTest {

    @Autowired
    private DataDictGateway dataDictGateway;

    @Test
    public void listByDictTypeCode() {
        List<DataDict> dataDicts = dataDictGateway.listByDictTypeCode("product_importance_level");
        for (DataDict dataDict : dataDicts) {
            log.info("dataDict:{}",dataDict);
        }
    }

}
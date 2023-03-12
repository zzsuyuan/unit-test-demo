package com.noob.ut.infrastructure.gatewayimpl.database.mapper

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.noob.ut.infrastructure.gatewayimpl.database.dataobject.po.DataDictEntity
import com.noob.ut.support.MapperUtil
import com.noob.ut.support.MyBaseSpec
import com.noob.ut.support.MyDbUnit


class DataDictMapperSpec extends MyBaseSpec {

    def dataDictMapper = MapperUtil.getMapper(DataDictMapper.class,false)

    /**
     * 测试数据准备，通常为sql表结构创建用的ddl，支持多个文件以逗号分隔。
     */
    def setup() {
        executeSqlScriptFiles("schema/schema.sql")
    }

    /**
     * 数据表清除，通常待drop的数据表
     */
    def cleanup() {
        dropTables("unit_test.data_dict")
    }

    @MyDbUnit(xmlLocation = "data/dataset.xml", schema = "UNIT_TEST")
    def "test selectList"() {
        when:
        def list = dataDictMapper.selectList(new QueryWrapper<DataDictEntity>())
        list.forEach({ v -> println(v) })

        then:
        print("end")
    }

    @MyDbUnit(xmlLocation = "data/dataset.xml",schema = "UNIT_TEST")
    def "test selectList 2"() {
        given:
        def list = dataDictMapper.selectList(new QueryWrapper<DataDictEntity>())
        list.forEach({ v -> println(v) })

        expect:
        name.size() == length

        //每一行为一个case
        where:
        name     || length
        "Spock"  || 5
        "Kirk"   || 4
        "Scotty" || 6
    }

}


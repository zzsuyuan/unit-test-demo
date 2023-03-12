package com.noob.ut.support


import groovy.sql.Sql
import org.assertj.core.util.Lists
import org.h2.tools.RunScript
import org.springframework.core.io.ClassPathResource
import spock.lang.Specification


class MyBaseSpec extends Specification {

    def executeSqlScriptFiles(String... sqlScriptFiles) {
        def connection = com.noob.ut.support.DataSourceHolder.getConnection()
        def list = Lists.newArrayList(sqlScriptFiles)
        list.forEach({
            RunScript.execute(connection, new InputStreamReader(new ClassPathResource(it).getInputStream()));
        })
    }

    def dropTables(String... tableNames){
        def connection = com.noob.ut.support.DataSourceHolder.getConnection()
        def list = Lists.newArrayList(tableNames)
        list.forEach({
            new Sql(connection).execute("drop table " + it)
        })
    }

}
package com.noob.ut.support

import org.dbunit.database.DatabaseConfig
import org.dbunit.database.DatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder
import org.dbunit.operation.DatabaseOperation
import org.spockframework.runtime.extension.AbstractMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.springframework.core.io.ClassPathResource

class MyDbUnitInterceptor extends AbstractMethodInterceptor {

    private final MyDbUnit myDbUnitAnnotation

    MyDbUnitInterceptor(MyDbUnit myDbUnitAnnotation) {
        assert myDbUnitAnnotation
        this.myDbUnitAnnotation = myDbUnitAnnotation
    }

    @Override
    void interceptFeatureMethod(IMethodInvocation invocation) throws Throwable {
        String xmlLocation = myDbUnitAnnotation.xmlLocation();
        String schema = myDbUnitAnnotation.schema()
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new ClassPathResource(xmlLocation).getFile());
        def connection = DataSourceHolder.getConnection()
        connection.setSchema(schema)
        DatabaseConnection databaseConnection = new DatabaseConnection(connection);
        databaseConnection.getConfig().setProperty(DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS,true)
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection,dataSet);
        invocation.proceed()
    }

    @Override
    void interceptSetupMethod(IMethodInvocation invocation) throws Throwable {
        invocation.proceed()
        super.interceptSetupMethod(invocation)
    }

    @Override
    void interceptCleanupMethod(IMethodInvocation invocation) throws Throwable {
        invocation.proceed()
        super.interceptCleanupMethod(invocation)
    }

}

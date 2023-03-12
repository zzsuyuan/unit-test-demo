package com.noob.ut.support;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.concurrent.TimeUnit;


@Slf4j
public class MapperUtil {

    public static final String MAPPER_CLASS = "com.noob.ut.infrastructure.gatewayimpl.database.mapper";
    public static final String MAPPER_LOCATIONS = "classpath*:/mapper/**/*.xml";

    public static <T> T getMapper(Class<T> clazz, boolean loadAll) throws Exception {
        Stopwatch started = Stopwatch.createStarted();

        JdbcDataSource dataSource = DataSourceHolder.getDataSource();
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        String databaseId = databaseIdProvider.getDatabaseId(dataSource);
        Configuration configuration = new MybatisConfiguration();
        Environment environment = new Environment(databaseId,new JdbcTransactionFactory(),dataSource);
        configuration.setEnvironment(environment);
        if (loadAll) {
            configuration.addMappers(MAPPER_CLASS);
            Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATIONS);
            for (Resource mapperLocation : mapperLocations) {
                XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(mapperLocation.getInputStream(),
                        configuration, mapperLocation.toString(), configuration.getSqlFragments());
                xmlMapperBuilder.parse();
            }
        } else {
            configuration.addMapper(clazz);
            String simpleName = clazz.getSimpleName();
            String mapperLocationStr = String.format("classpath:/mapper/%s.xml",simpleName);
            Resource mapperLocation = new PathMatchingResourcePatternResolver().getResource(mapperLocationStr);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(mapperLocation.getInputStream(),
                    configuration, mapperLocation.toString(), configuration.getSqlFragments());
            xmlMapperBuilder.parse();
        }

        SqlSessionFactory factory = new MybatisSqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = factory.openSession();
        T mapper = sqlSession.getMapper(clazz);

        long elapsed = started.elapsed(TimeUnit.MILLISECONDS);
        log.info("MapperUtil#getMapper 获取{}耗时:[{}ms]",clazz.getSimpleName(),elapsed);
        return mapper;
    }

}



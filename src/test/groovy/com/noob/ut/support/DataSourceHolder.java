package com.noob.ut.support;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceHolder {

    private static final String JDBC_URL = "jdbc:h2:mem:test;MODE=MYSQL;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static JdbcDataSource dataSource;

    static {
        dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static JdbcDataSource getDataSource() {
        return dataSource;
    }

}

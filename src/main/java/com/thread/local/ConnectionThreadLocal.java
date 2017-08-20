package com.thread.local;

import com.utils.JdbcConnector;

import java.sql.Connection;

/**
 * Created by smr0721 on 2017/7/9.
 */
public class ConnectionThreadLocal {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            return JdbcConnector.getConnection();
        }
    };
    public static Connection getConnection(){
        Connection connection = threadLocal.get();
        return connection;
    }

}

package com.thread.local;

import com.model.PageInfoEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by smr0721 on 2017/7/9.
 */
public class ConnectionThreadLocal {
    private String url;
    private String username;
    private String password;
    private String jdbcClass;
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            try{
                Class.forName(jdbcClass);
                Connection con = DriverManager.getConnection(url , username , password) ;
                return con;
            }catch(SQLException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public synchronized boolean insertData(PageInfoEntity entity) throws SQLException {
        Connection connection = this.getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO bk_sing_words(title,information,description,imageUrl,baikeUrl)VALUES(?,?,?,?,?)");
        ps.setString(1,entity.getName());
        ps.setString(2,entity.getInformation());
        ps.setString(3,entity.getDescription());
        ps.setString(4,entity.getImageUrl());
        ps.setString(5,entity.getBkUrl());
        ps.executeUpdate();
        return true;
    }

    public Connection getConnection(){
        Connection connection = threadLocal.get();
        return connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcClass() {
        return jdbcClass;
    }

    public void setJdbcClass(String jdbcClass) {
        this.jdbcClass = jdbcClass;
    }
}

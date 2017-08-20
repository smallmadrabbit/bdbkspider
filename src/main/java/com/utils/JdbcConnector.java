package com.utils;

import com.thread.local.ConnectionThreadLocal;
import com.model.PageInfoEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by smr0721 on 2017/7/9.
 */
public class JdbcConnector {
    private static String url = "jdbc:mysql://10.8.41.41:3306/baidubaike";
    private static String username = "root" ;
    private static String password = "root" ;
    public JdbcConnector(){
    }

    public static Connection getConnection(){
        try{
            Connection con = DriverManager.getConnection(url , username , password) ;
            return con;
        }catch(SQLException e){
            System.out.println("数据库连接失败！");
            e.printStackTrace() ;
        }
        return null;
    }
    public static synchronized boolean insertData(PageInfoEntity entity) throws SQLException {
        Connection connection = ConnectionThreadLocal.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO bk_sing_words(title,information,description,imageUrl,baikeUrl)VALUES(?,?,?,?,?)");
            ps.setString(1,entity.getName());
            ps.setString(2,entity.getInformation());
            ps.setString(3,entity.getDescription());
            ps.setString(4,entity.getImageUrl());
            ps.setString(5,entity.getBkUrl());
            ps.executeUpdate();
            return true;
    }
}

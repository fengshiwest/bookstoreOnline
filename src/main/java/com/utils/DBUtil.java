package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Wan Yu on 2020/3/17
 */
public class DBUtil {
    private static String dbDriver;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            InputStream in = DBUtil.class.getResourceAsStream("/jdbc.properties");
            Properties properties = new Properties();
            properties.load(in);
            dbDriver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            Class.forName(dbDriver);
        } catch (IOException e){
            System.err.println("数据库配置文件读取异常");
        } catch (ClassNotFoundException e){
            System.err.println("驱动配置异常");
        }
    }

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("链接信息：" + connection);
            return connection;
        } catch (SQLException e){
            System.err.println("链接信息异常");
            return null;
        }
    }

    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void rollback(Connection conn){
        if(conn != null){
            try {
                conn.rollback();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        conn = null;
    }


}

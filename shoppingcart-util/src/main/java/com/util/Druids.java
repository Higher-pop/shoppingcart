package com.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author SherWin
 * @date 2019/12/18 7:40
 */
public class Druids {
    private static DataSource dataSource;
    static{
        InputStream inputStream= Druids.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}

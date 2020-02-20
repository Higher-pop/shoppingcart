package com.util;



import com.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionHelper {
	private static  String DRIVERCLASSNAME="";
	private static  String URL="";
	private static  String USERNAME="";
	private static  String PASSWORD="";
	
	static{
			
		
		InputStream inStream = null;
		try {
			inStream = ConnectionHelper.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(inStream);
			
			DRIVERCLASSNAME = properties.getProperty("jdbc.driverClass");
			URL = properties.getProperty("jdbc.url");
			USERNAME = properties.getProperty("jdbc.username");
			PASSWORD = properties.getProperty("jdbc.password");
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			try {
				inStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
				throw new DaoException(e.getMessage());
			}
		}
	}
	
	static{
		try {
			Class.forName(DRIVERCLASSNAME);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return conn;
	}
}
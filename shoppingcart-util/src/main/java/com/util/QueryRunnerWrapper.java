package com.util;


import com.exception.DaoException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;


public class QueryRunnerWrapper {
	public int modify(String sql,Object...params)  {
		Connection conn=ConnectionHelper.getConnection();
		/*Connection conn= null;
		try {
			conn = Druids.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		QueryRunner queryRunner=new QueryRunner(true);
		
		try {
			return queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}finally{
			
			DbUtils.closeQuietly(conn);
		}
	
	}
	
	public <T> T query(String sql,ResultSetHandler<T> rsh,Object...params){
		Connection conn=ConnectionHelper.getConnection();
		/*Connection conn= null;
		try {
			conn = Druids.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		QueryRunner queryRunner=new QueryRunner(true);
		try {
			return queryRunner.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}finally{
			
				DbUtils.closeQuietly(conn);
		}
	}
}



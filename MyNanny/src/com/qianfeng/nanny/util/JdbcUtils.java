package com.qianfeng.nanny.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qiamfeng.nanny.entity.Administrators;

public class JdbcUtils {
	//���ӳ�
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mypool");
	private static QueryRunner runner = new QueryRunner(dataSource);
	
	//��ɾ��
	public static int Update(String sql,Object... params){
		try {
			return runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	//��ѯһ�����
	public static <T> T queryOne(Class clazz,String sql,Object...params){
		try {
			return runner.query(sql, new BeanHandler<T>(clazz), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//��ѯ�������
	public static <T> List<T> queryList(Class clazz,String sql,Object... params){
		try {
			return runner.query(sql, new BeanListHandler<T>(clazz), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//��ҳ
	public static int queryCount(String sql,Object... params ){
		try {
			return runner.query(sql, new ResultSetHandler<Integer>(){

				@Override
				public Integer handle(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					rs.next();
					return rs.getInt(1);
				}
		
			}, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

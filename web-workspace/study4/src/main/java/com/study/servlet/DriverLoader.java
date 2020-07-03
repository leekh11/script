package com.study.servlet;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


@SuppressWarnings("serial")
public class DriverLoader extends HttpServlet {

	// init : 생성시 실행 
	// destroy : 종료시 실행 
	// service : 매 요청시 실행 
	// doGet, doPost, doTrace, ...  <-  service 에서 각 요청별로 콜
	
	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
        initConnectPool();
	}
	
	private void loadJDBCDriver() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Oracle 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			throw new RuntimeException("Fail JDBC Driver", e);
		}
	}
	
	
	private void  initConnectPool() {		
		try {
			// 실제 커낵션을 생성할 ConnectionFactory 생성 
			ConnectionFactory connFactory = 
					 new DriverManagerConnectionFactory("jdbc:oracle:thin:@localhost:1521:xe"
							                            ,"java","oracle");
			// 커넥션 풀...
			PoolableConnectionFactory poolableConnFactory 
			    = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1 from dual");
			
			@SuppressWarnings("rawtypes")
			GenericObjectPoolConfig poolConofig = new GenericObjectPoolConfig();
			// 커넥션 검사 주기
			poolConofig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConofig.setTestWhileIdle(true); 
			poolConofig.setMinIdle(4);
			poolConofig.setMaxTotal(4); // default 8 
			
			@SuppressWarnings("unchecked")
			GenericObjectPool<PoolableConnection> connectionPool 
			   = new GenericObjectPool<>(poolableConnFactory, poolConofig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver =  (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("study",connectionPool);
			System.out.println("DBCP 드라이버 등록 성공!!");
			System.out.println(" 드라이버 시작!!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
}
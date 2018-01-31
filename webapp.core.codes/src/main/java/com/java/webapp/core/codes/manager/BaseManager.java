package com.java.webapp.core.codes.manager;

import org.apache.ibatis.session.SqlSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.java.webapp.core.codes.exception.CustomExceptionHandler;

public abstract class BaseManager {

//	/** The session manager. */
	private SqlSessionManager sessionManager;
//	
	
	@Autowired
	protected TransactionTemplate transactionTemplate;
	
	@Autowired
	protected DataSourceTransactionManager transactionManager;
	
	public BaseManager() {
		
	}
	
//	/**
//	 * Instantiates a new base manager.
//	 * 
//	 * @param connectionManager the connection manager
//	 * @throws QmsSQLException the qms sql exception
//	 */
	public BaseManager(MyBatisConnectionManager connectionManager) throws CustomExceptionHandler {
		try {
			sessionManager = connectionManager.getSessionManager();
		} catch (Exception e) {
			throw new CustomExceptionHandler("An SQL exception occurred while starting the session ");
		}
	}

	public void close() {
		 sessionManager.close();
		
	}
}

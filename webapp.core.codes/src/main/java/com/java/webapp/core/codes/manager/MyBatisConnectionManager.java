/* Licensed Materials
 * Property of Toyota Motor Philippines
 * Copyright (c) 2012 Toyota Motor Philippines
 * All Rights Reserved
 *
 * Creation Date: Jul 23, 2012 5:47:26 PM
 *
 * History
 * Jul 23, 2012    Initial creation        Anton
 */
package com.java.webapp.core.codes.manager;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

/**
 * The Class MyBatisConnectionManager.
 */
public class MyBatisConnectionManager {

	/** The session manager. */
	private SqlSessionManager sessionManager;

	/**
	 * Sets the sql session factory.
	 * 
	 * @param sqlSessionFactory the new sql session factory
	 */
	public void setSqlSessionFactory(DefaultSqlSessionFactory sqlSessionFactory) {
		try {
			sessionManager = SqlSessionManager.newInstance(sqlSessionFactory);
		} catch (Exception e) {
			sessionManager = null;
		}
	}

	/**
	 * Gets the session manager.
	 * 
	 * @return the session manager
	 * @throws SQLException the sQL exception
	 */
	public SqlSessionManager getSessionManager() throws SQLException {
		if (sessionManager != null && !sessionManager.isManagedSessionStarted()) {
			this.sessionManager.startManagedSession();
			sessionManager.getConnection().setAutoCommit(false);
		}
		return sessionManager;
	}

	/**
	 * Commit.
	 * 
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		if (sessionManager.isManagedSessionStarted()) {
			sessionManager.getConnection().commit();
			sessionManager.commit();
		}
	}

	/**
	 * Rollback.
	 * 
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		if (sessionManager.isManagedSessionStarted()) {
			sessionManager.getConnection().rollback();
			sessionManager.rollback();
		}
	}

	/**
	 * Close.
	 */
	public void close() {
		if (sessionManager.isManagedSessionStarted()) {
			sessionManager.close();
		}
	}

}

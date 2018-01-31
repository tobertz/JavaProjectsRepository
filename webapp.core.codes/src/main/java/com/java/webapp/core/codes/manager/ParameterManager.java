package com.java.webapp.core.codes.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Component;

import com.java.webapp.core.codes.dao.ParameterDao;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;
import com.java.webapp.core.codes.util.PropertiesUtil;
import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;

@Component
public class ParameterManager extends BaseManager{
//	
	@Autowired
	ParameterDao parameterDao;
	
	public ParameterManager() {
		super();
	}
	
	public ParameterManager(MyBatisConnectionManager connectionManager) throws CustomExceptionHandler {
		super(connectionManager);
	}

	
	public Integer getParameterIntValueFromName(String param) throws CustomExceptionHandler{
		Integer result = 0;
		try {
			result = parameterDao.getParameterIntValueFromName(param);
		} catch(CannotGetJdbcConnectionException ec) {
			result = 0;
			throw new CustomExceptionHandler(PropertiesUtil.getErrorProps("system.administrator.code"), PropertiesUtil.getErrorProps("system.administrator"));
		} catch(CustomExceptionHandler e) {
			result = 0;
			e.printStackTrace();
			throw new CustomExceptionHandler(PropertiesUtil.getErrorProps("system.administrator.code"), PropertiesUtil.getErrorProps("system.administrator"));
		} catch(Exception  e) {
			result = 0;
			e.printStackTrace();
			throw new CustomExceptionHandler(PropertiesUtil.getErrorProps("system.administrator.code"), PropertiesUtil.getErrorProps("system.administrator"));
		} 
		
		return result;
	}
}

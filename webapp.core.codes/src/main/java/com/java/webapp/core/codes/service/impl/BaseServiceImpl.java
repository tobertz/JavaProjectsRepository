package com.java.webapp.core.codes.service.impl;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.webapp.core.codes.dao.GenericDao;
import com.java.webapp.core.codes.dao.ParameterDao;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;
import com.java.webapp.core.codes.manager.ParameterManager;
import com.java.webapp.core.codes.service.BaseService;
import com.java.webapp.core.codes.util.PropertiesUtil;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

public class BaseServiceImpl {
	
	ParameterManager parameterManager;
}


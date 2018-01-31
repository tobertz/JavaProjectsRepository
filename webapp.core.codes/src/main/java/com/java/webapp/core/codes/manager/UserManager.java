package com.java.webapp.core.codes.manager;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import com.java.webapp.core.codes.dao.ParameterDao;
import com.java.webapp.core.codes.dao.UserDao;
import com.java.webapp.core.codes.dao.helper.StringHelper;
import com.java.webapp.core.codes.domain.User;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;
import com.java.webapp.core.codes.util.Constants;

@Component
public class UserManager extends BaseManager{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ParameterDao parameterDao;
	
	public UserManager() {
		super();
	}
	
	public UserManager(MyBatisConnectionManager connectionManager) throws CustomExceptionHandler {
		super(connectionManager);
	}
	
	public Integer validateUserLogin(HashMap<String, Object> params) throws CustomExceptionHandler{
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(def);
		User user = new User();
		
		try {
			Integer loginStatus = Constants.FAIL_STATUS_ID;;
			boolean commitTag = false;
			HashMap<String, Object> loginParams = new HashMap<String, Object>();
			
			user = userDao.validateUserLogin(params);
			if(user != null) {
				Integer userId = user.getUserId();
				Integer updateResult = userDao.updateLastLogin(user.getUserId());
				if(updateResult == 1 ) {
					loginParams.put("userId", userId);
					loginParams.put("status", Constants.SUCCESS_STATUS_ID);
					Integer insertResult = userDao.insertLoginHistory(loginParams);
					if(insertResult == 1) {
						loginStatus=Constants.SUCCESS_STATUS_ID;
						commitTag=true;
					}
				}
			} else {
				User failUser = userDao.getUserByUsername(params);
				if(failUser != null) {
					loginParams.put("userId", failUser.getUserId());
					loginParams.put("status", Constants.FAIL_STATUS_ID);
					Integer insertResult = userDao.insertLoginHistory(loginParams);
					if(insertResult == 1) {
						Integer loginAttemptLimit = parameterDao.getParameterIntValueFromName("max_login_attempt");
						
						Integer count = userDao.getLoginCount(loginAttemptLimit);
						if(loginAttemptLimit == count) {
							loginParams = new HashMap<String, Object>();
							loginParams.put("status", Constants.LOCK_STATUS_ID);
							Integer updateResult = userDao.updateUserStatus(loginParams);
							if(updateResult== 1) {
								loginStatus=Constants.LOCK_STATUS_ID;
								commitTag=true;
							}
						} else {
							loginStatus = Constants.FAIL_STATUS_ID;
						}
					}
				} else {
					loginStatus = Constants.INVALID_STATUS_ID;
				}
			}
			
			if(commitTag) {
				transactionManager.commit(status);	
			} else {
				transactionManager.rollback(status);
			}
			return loginStatus;
 		} catch(Exception e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(Constants.ERROR_MESSAGE, e.getMessage());
		}
	}

	public User getUserById(Integer userId) throws CustomExceptionHandler {
		HashMap<String, Object> params =new HashMap<String, Object>();
		params.put("userId", userId);
		
		return userDao.getUserById(params);
	}

	public User getUserByUsername(String username) {
		HashMap<String, Object> params =new HashMap<String, Object>();
		params.put("username", username);
		
		return userDao.getUserByUsername(params);
	}

}

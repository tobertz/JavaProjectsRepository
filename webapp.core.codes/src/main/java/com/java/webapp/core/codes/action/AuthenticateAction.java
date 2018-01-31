package com.java.webapp.core.codes.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.webapp.core.codes.dao.helper.StringHelper;
import com.java.webapp.core.codes.domain.form.UserForm;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;
import com.java.webapp.core.codes.service.BaseService;
import com.java.webapp.core.codes.service.ParameterService;
import com.java.webapp.core.codes.service.impl.BaseServiceImpl;
import com.java.webapp.core.codes.util.Constants;
import com.java.webapp.core.codes.util.PropertiesUtil;

@Controller
public class AuthenticateAction {
	
	@Autowired
	ParameterService parameterService;
	
	private final Logger logger = Logger.getLogger(AuthenticateAction.class);
	
	@RequestMapping(value = "/login.html", method=RequestMethod.GET)
	@ExceptionHandler(CustomExceptionHandler.class)
	public ModelAndView initialize(ModelMap model, HttpServletRequest request) throws CustomExceptionHandler {
		logger.info("AuthenticateAction :: initialize");
		String forwardPage = "loginPage";
		Integer connected = 0;
		try {
			StringHelper sh = new StringHelper();
	    	sh.setStringValue(PropertiesUtil.getConfigProps("wacc.version"));
	    	request.getSession().setAttribute("version", sh);
	    	model.put("version", sh);
			
			connected = parameterService.getParameterIntValueFromName("connected");
			logger.info("connected :: " + connected);
			
			if(connected != 1) {
				model.put("errorMessage", PropertiesUtil.getErrorProps("no.connection.to.database"));
				return new ModelAndView(Constants.ERROR_PAGE, model);
			}
			model.put("command", new UserForm());
		} catch (CustomExceptionHandler e) {
			logger.info(e.getExceptionCode() + " :: " + e.getExceptionMsg());
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getExceptionCode(), e.getExceptionMsg());
		}  
		logger.info("AuthenticateAction :: forwardPage = " + forwardPage);
	
		return new ModelAndView(forwardPage, model);
	}
}

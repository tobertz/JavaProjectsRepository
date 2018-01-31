package com.java.webapp.core.codes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.lang.UsesJava7;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.webapp.core.codes.dao.helper.StringHelper;
import com.java.webapp.core.codes.domain.Role;
import com.java.webapp.core.codes.domain.User;
import com.java.webapp.core.codes.domain.form.UserForm;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;
import com.java.webapp.core.codes.service.BaseService;
import com.java.webapp.core.codes.service.RoleService;
import com.java.webapp.core.codes.service.UserService;
import com.java.webapp.core.codes.util.Constants;
import com.java.webapp.core.codes.util.Flash;
import com.java.webapp.core.codes.util.PropertiesUtil;

@Controller
public class LoginAction {
	@Autowired
	private Flash flash;
	
	@Autowired
	BaseService baseService;
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	RoleService roleService;
	
	private final Logger logger = Logger.getLogger(AuthenticateAction.class);
	
	@RequestMapping(value = "/login.html", method=RequestMethod.POST)
	@ExceptionHandler(CustomExceptionHandler.class)
	public String login(@ModelAttribute("loginForm") UserForm userForm, ModelMap model, HttpServletRequest request) throws CustomExceptionHandler {
		logger.info("LoginAction :: login");
		
		String forwardPage = "redirect:login.html";
		try {
			HttpSession session = request.getSession();
			
			User user = new User();
		
			String username = userForm.getUsername();
			String password = userForm.getPassword();
			
			Integer loginStatus = userService.validateUserLogin(username, password);
			switch(loginStatus) {
			case Constants.SUCCESS_STATUS_ID:
				user = userService.getUserByUsername(username);
				if(user != null) {
					session.setAttribute(Constants.USER, user);
					flash.info(PropertiesUtil.getMessageProps("login.successful"));
					forwardPage = "redirect:home.html";
				}
				break;
			case Constants.FAIL_STATUS_ID:
				flash.info(PropertiesUtil.getMessageProps("login.failed"));
				break;
			case Constants.LOCK_STATUS_ID:
				flash.info(PropertiesUtil.getMessageProps("user.lock", username));
				break;
			case Constants.INVALID_STATUS_ID:
			default:
				flash.info(PropertiesUtil.getMessageProps("login.failed"));
				break;
			}
			
			return forwardPage;
		} catch(CustomExceptionHandler e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getExceptionCode(), e.getExceptionMsg());
		}
	}
	
	@RequestMapping(value = "/home.html", method=RequestMethod.GET)
	@ExceptionHandler(CustomExceptionHandler.class)
	public ModelAndView showHome(ModelMap model, HttpServletRequest request) throws CustomExceptionHandler {
		logger.info("LoginAction :: showHome");
		String forwardPage = "home";
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(Constants.USER);
		
			Integer roleId = user.getRoleId();
//			Role role = roleService.getRoleByRoleId(roleId);
			
			
		} catch(CustomExceptionHandler e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getExceptionCode(), e.getExceptionMsg());
		}
		return new ModelAndView(forwardPage, model);
	}
	
}
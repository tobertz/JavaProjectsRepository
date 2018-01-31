package com.java.webapp.core.codes.action;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.java.webapp.core.codes.exception.CustomExceptionHandler;

public class ExceptionController {
    /**
     * The Constant logger.
     */
    private static final Logger logger = Logger.getLogger(ExceptionController.class);

    @ExceptionHandler(CustomExceptionHandler.class)
    public ModelAndView handleCustomException(CustomExceptionHandler ex) {
        logger.info("ExceptionController :: CustomExceptionHandler");
        ModelAndView model = new ModelAndView("ClsExceptionPage"); // View
        // handler
        logger.info(ex.getExceptionCode() + " :: " + ex.getExceptionMsg());
        model.addObject("errorCode", ex.getExceptionCode());
        model.addObject("errorMessage", ex.getMessage());

        return model;
    }
}

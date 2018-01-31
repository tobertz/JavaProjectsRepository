/* Licensed Materials
 * Property of MobileSys
 * Copyright (c) 2014 MobileSys
 * All Rights Reserved
 *
 * Creation Date: Aug 6, 2014 1:16:01 PM
 *
 * History
 * Aug 6, 2014    Initial creation        roberto
 */

package com.java.webapp.core.codes.util;

//~--- non-JDK imports --------------------------------------------------------

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Flash.
 */
@Component("flash")
public class Flash {

    /** The Constant FLASH_MESSAGE. */
    public static final String FLASH_MESSAGE = "FLASH_MESSAGE";

    /** The Constant FLASH_ERROR. */
    public static final String FLASH_ERROR = "FLASH_ERROR";

    /** The Constant FLASH_TYPE. */
    public static final String FLASH_TYPE = "flashType";
    public static boolean      isPost     = false;

    /** The messages. */
    public Map<String, String> messages;
    public String              flashString;

    /** The context. */
    @Autowired
    ApplicationContext context;

    /**
     * Info.
     *
     * @param message the message
     */
    public void info(String message) {
        messages = new HashMap<String, String>();

//      messages.put(FLASH_MESSAGE, getResourceMessage(message));
        messages.put(FLASH_MESSAGE, message);
    }

    public void info(String message, boolean isPost) {
        messages = new HashMap<String, String>();

//      messages.put(FLASH_MESSAGE, getResourceMessage(message));
        messages.put(FLASH_MESSAGE, message);
        this.isPost = isPost;
    }

    /**
     * Error.
     *
     * @param message the message
     */
    public void error(String message) {
        messages = new HashMap<String, String>();

//      messages.put(FLASH_MESSAGE, getResourceMessage(message));
        messages.put(FLASH_ERROR, message);
    }

    public void error(String message, boolean isPost) {
        messages = new HashMap<String, String>();

//      messages.put(FLASH_MESSAGE, getResourceMessage(message));
        messages.put(FLASH_ERROR, message);
        this.isPost = isPost;
    }

    /**
     * Gets the messages.
     *
     * @return the messages
     */
    public Map<String, String> getMessages() {
        return messages;
    }

    /**
     * Gets the resource message.
     *
     * @param message the message
     * @return the resource message
     */
    public String getResourceMessage(String message) {
        try {
            return context.getMessage(message, null, null);
        } catch (Exception e) {
            return message;
        }
    }

    /**
     * Reset.
     */
    public void reset() {
        if (messages != null) {
            messages.clear();
        }
    }

    public String getFlashString() {
        return flashString;
    }

    public void setFlashString(String flashString) {
        this.flashString = flashString;
    }

    public String setDivMessage(String flashString) {
        return "<div class='flash' id='flashIdJson'>" + flashString + "</div>";
    }
}

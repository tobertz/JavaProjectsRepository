/* Licensed Materials
 * Property of Toyota Motor Philippines
 * Copyright (c) 2012 Toyota Motor Philippines
 * All Rights Reserved
 *
 * Creation Date: Jul 19, 2012 10:41:32 AM
 *
 * History
 * Jul 19, 2012    Initial creation        francis
 */



package com.java.webapp.core.codes.dao.helper;

//~--- JDK imports ------------------------------------------------------------

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * The Class StringHelper.
 */
public class StringHelper {

	private String stringValue;
	
	
	
    public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/**
     * To upper.
     *
     * @param value the value
     * @return the string
     */
    public static String toUpper(String value) {
        if (value != null) {
            return value.toUpperCase();
        } else {
            return "";
        }
    }

    /**
     * To lower.
     *
     * @param value the value
     * @return the string
     */
    public static String toLower(String value) {
        if (value != null) {
            return value.toLowerCase();
        } else {
            return "";
        }
    }

    /**
     * Checks if is empty.
     *
     * @param value the value
     * @return true, if is empty
     */
    public static boolean isEmpty(String value) {
        return ((value == null) || (value.trim().length() == 0));
    }

    /**
     * Checks if is not empty.
     *
     * @param value the value
     * @return true, if is not empty
     */
    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    /**
     * Gets the upper case value.
     *
     * @param value the value
     * @return the upper case value
     */
    public static String getUpperCaseValue(String value) {
        if (isNotEmpty(value)) {
            return value.toUpperCase();
        } else {
            return null;
        }
    }

    /**
     * Checks if is equal.
     *
     * @param value the value
     * @param value1 the value1
     * @return true, if is equal
     */
    public static boolean isEqual(String value, String value1) {
        if (((value == null) || (value.trim().length() == 0)) && ((value1 == null) || (value1.trim().length() == 0))) {
            return true;
        } else {
            if (value != null) {
                return value.equalsIgnoreCase(value1);
            } else {
                return value1.equalsIgnoreCase(value);
            }
        }
    }

    /**
     * Removes the white space.
     *
     * @param value the value
     * @return the string
     */
    public static String removeWhiteSpace(String value) {
        return value.replaceAll("\\s", "");
    }

    /**
     * Format number.
     *
     * @param number the number
     * @param format the format
     * @return the string
     */
    public static String formatNumber(long number, String format) {
        String       returnValue = "";
        NumberFormat formatter   = new DecimalFormat(format);

        returnValue = formatter.format(number);

        return returnValue;
    }

    /**
     * Number format is valid.
     *
     * @param value the value
     * @return true, if successful
     */
    public static boolean numberFormatIsValid(String value) {
        return value.matches("^(([0-9]{1,3}[.][0-9]{1,2})|([0-9]{1,3}))$");
    }

    /**
     * Gets the request action name.
     *
     * @param request the request
     * @return the request action name
     */
    public static String getRequestActionName(HttpServletRequest request) {
        return request.getRequestURI().split("/")[request.getRequestURI().split("/").length - 1].split("-")[0].split(
            ".html")[0];
    }

    public static String getRequestImageName(String url) {
        String  regex     = "(?i)\\.(jpg|png|gif)$";
        Pattern p         = Pattern.compile(regex);
        Matcher m         = p.matcher(url);
        String  imageType = "";

        while (m.find()) {
            imageType = m.group(1);
        }

        return url.split("/")[url.split("/").length - 1].split("-")[0].split(imageType)[0] + imageType;
    }

    public static String getImagePattern(String url) {
        String  regex        = "image/(thumb|cvis|part|paint)/";
        Pattern p            = Pattern.compile(regex);
        Matcher m            = p.matcher(url);
        String  imagePattern = "";

        while (m.find()) {
            imagePattern = m.group(1);
        }

        return imagePattern;
    }

    public static String prepareStringForExport(String field) {
        String preparedString = field;

        if (field.contains("&plusmn;")) {
            preparedString = field.replaceAll("&plusmn;", "&#xB1;");
        } else if (field.contains(" <= ")) {
            preparedString = field.replaceAll("<=;", "&#x2264;");
        } else if (field.contains(" >= ")) {
            preparedString = field.replaceAll(">=", "&#x2265;");
        } else if (field.contains(" > ")) {
            preparedString = field.replaceAll(">", "&#62;");
        } else if (field.contains(" < ")) {
            preparedString = field.replaceAll("<", "&#60;");
        }

        return preparedString;
    }

    public static List<Integer> getIntegerFromStringList(String[] idStringList) {
        List<Integer> integerList = new ArrayList<Integer>();

        for (String idString : idStringList) {
            integerList.add(Integer.valueOf(idString));
        }

        return integerList;
    }
    
    public static Integer getIntegerFromString(String idString) {
    	Integer id = 0;
    	
    	if(isNotEmpty(idString)) {
    		id = Integer.valueOf(idString.trim());
    	}
    	return id;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

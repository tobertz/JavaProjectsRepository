package com.java.webapp.core.codes.util;

//~--- non-JDK imports --------------------------------------------------------
import org.apache.log4j.Logger;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

//~--- JDK imports ------------------------------------------------------------
import java.io.IOException;

import java.util.Properties;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {

    private static final Logger LOG = Logger.getLogger(PropertiesUtil.class);
    private static String DEFAULT_PROPERTY_FOLDER = "";

    /**
     * Gets the config props.
     *
     * @param config the config
     * @return the config props
     */
    public static String getConfigProps(String config) {
        Properties props = loadProperty("config.properties");

        return props.getProperty(config);
    }

    public static Properties loadProperty(String fileName) {
        return loadPropertyFromExternalSource(DEFAULT_PROPERTY_FOLDER + fileName);
    }

    /**
     * Gets the message props.
     *
     * @param config the config
     * @return the message props
     */
    public static String getMessageProps(String config) {
        Properties props = loadProperty("messages.properties");
        return props.getProperty(config);
    }

    
    public static String getErrorProps(String config) {
        Properties props = loadProperty("error.properties");
        return props.getProperty(config);
    }
    
    /**
     * Gets the message props and automatically replaces the variables {0}, {1},
     * {2}... with arg[0], arg[1], arg[2]...
     *
     * @param config the config
     * @param arg the arg
     * @return the message props
     */
    public static String getMessageProps(String config, String... arg) {
        Properties props = loadProperty("messages.properties");
        String message = props.getProperty(config);
        String retVal = "";

        for (int i = 0; i < arg.length; i++) {
            String oldChar = "{" + i + "}";

            retVal = message.replace(oldChar, arg[i]);
        }

        return retVal;
    }

    /**
     * Load property from external source.
     *
     * @param externalSource the external source
     * @return the properties
     */
    public static Properties loadPropertyFromExternalSource(String externalSource) {
        Properties properties = new Properties();

        try {
            Resource resource = new ClassPathResource(externalSource);    // For Tomcats

            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            LOG.error(e);
        }

        return properties;
    }

    /**
     * Gets the message props.
     *
     * @param config the config
     * @return the message props
     */
    public static String getImportErrorProps(String config) {
        Properties props = loadProperty("importerror.properties");
        return props.getProperty(config);
    }

    public static String getImportErrorProps(String config, String... arg) {
        Properties props = loadProperty("importerror.properties");
        String message = props.getProperty(config);
        String retVal = "";

        for (int i = 0; i < arg.length; i++) {
            String oldChar = "{" + i + "}";

            retVal = message.replace(oldChar, arg[i]);
        }

        return retVal;
    }

    public static String getThreadProperties(String config) {
        Properties properties = loadProperty("task.properties");
        return properties.getProperty(config);
    }
    
}


//~ Formatted by Jindent --- http://www.jindent.com

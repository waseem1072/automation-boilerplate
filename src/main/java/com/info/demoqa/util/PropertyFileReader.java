package com.info.demoqa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
    public static String getPropertyValue(String propertyName) {
        String propertyValue = null;

        try(InputStream inputStream = PropertyFileReader.class.getClassLoader().getResourceAsStream("test-data.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return propertyValue;
    }
}

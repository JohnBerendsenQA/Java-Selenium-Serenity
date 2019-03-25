package net.johnberendsen.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertySupport {

    private static PropertySupport instance;

    private Properties properties = new Properties();


    public static PropertySupport getInstance() {
        if (instance == null) {
            instance = new PropertySupport();
        }
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    private PropertySupport() {
        final String environment = System.getProperty("environment");
        final String propertiesFileName = "environment-" + environment + ".properties";
        final InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream(propertiesFileName);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
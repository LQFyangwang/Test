package com.gs.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailConfig {

    private static Properties properties;

    /**
     * 根据配置文件的路径读取内容并返回Properties
     * @param path
     * @return
     */
    public static Properties build(String path) {
        if (properties == null) {
            synchronized (MailConfig.class) {
                if (properties == null) {
                    properties = new Properties();
                }
                try {
                    properties.load(new FileInputStream(new File(path)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    public static Properties build1(String path) {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream(new File(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }

    public static Integer getInteger(String key) {
        return Integer.valueOf(properties.getProperty(key));
    }

    public static Double getDouble(String key) {
        return Double.valueOf(properties.getProperty(key));
    }

}

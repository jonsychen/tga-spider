package com.tga.utils;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyUtil {

    private static Properties props;

    private PropertyUtil() {
    }

    static {
        props = new Properties();
        InputStreamReader reader = null;

        try {
            reader = new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("conf.properties"), "utf-8");
            props.load(reader);
            System.out.println("配置文件加载完成!!!");
        } catch (Exception e) {
            System.out.println("配置文件读取异常!!!");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("文件关闭失败!!!");
            }
        }
    }

    public static String getString(String key) {
        return props.getProperty(key);
    }

    public static Integer getInt(String key) {
        return Integer.parseInt(getString(key));
    }
}

package com.tga.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyUtil {

    private static Properties props;

    private PropertyUtil() {
    }

    static {
        props = new Properties();
        FileInputStream fis = null;

        try {
            String path = "";
            if (System.getProperty("os.name").toLowerCase().indexOf("wind") > -1) {
                path = "E:\\conf.properties";
            } else {
                path = "/usr/tga/conf.properties";
            }
            File file = new File(path);
            fis = new FileInputStream(file);
            props.load(fis);
            System.out.println("配置文件加载完成!!!");
        } catch (Exception e) {
            System.out.println("配置文件读取异常!!!");
            System.out.printf("开始读取默认配置文件!!!");
            try {
                InputStreamReader reader = new InputStreamReader(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("conf.properties"), "utf-8");
                props.load(reader);
            } catch (IOException e1) {
                System.out.println("默认配置文件读取失败!!!");
            }
        } finally {
            try {
                if (fis != null) {
                    fis.close();
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

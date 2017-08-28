package com.tga.utils;


import java.io.*;
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
                path = "D:\\conf.properties";
            } else {
                path = "/usr/tga/conf.properties";
            }
            File file = new File(path);
            fis = new FileInputStream(file);
            props.load(fis);
            System.out.println("配置文件加载完成!!!");
        } catch (Exception e) {
            System.out.println("配置文件读取异常!!!");
            System.out.println("开始读取默认配置文件!!!");
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

    public static Double getDouble(String key) {
        return Double.parseDouble(getString(key));
    }

    public static Boolean getBoolean(String key) {
        try {
            return Boolean.parseBoolean(getString(key));
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println
                ("87C3662E3D189C2AAC82113B860F5ABF3E37746EEACBAF26E0F7C84F11CD75F52290880B0D6C5381A60227D4E86FB90B181A64F5640127F25A88476E7FD0C101A9DA0427E8E74D8D1770EE4C7A7D337B2DE0211757A842BA".length());

        String url = "http://112.90.53.167:8080/87C3662E3D189C2AAC82113B860F5ABF3E37746EEACBAF26E0F7C84F11CD75F52290880B0D6C5381A60227D4E86FB90B181A64F5640127F25A88476E7FD0C101A9DA0427E8E74D8D1770EE4C7A7D337B2DE0211757A842BA/124208501.flv?cdncode=%2f18907E7BE0798990%2f&time=1503925914&cdn=zijian&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey=87C3662E3D189C2AAC82113B860F5ABF3E37746EEACBAF26E0F7C84F11CD75F52290880B0D6C5381A60227D4E86FB90B181A64F5640127F25A88476E7FD0C101A9DA0427E8E74D8D1770EE4C7A7D337B2DE0211757A842BA";
        int index = url.indexOf("vkey");
        System.out.println(url.substring(index + 5, index + 5 + 176));
        int flv = url.indexOf("flv");
        System.out.println(url.substring(flv - 10, flv - 1));
    }

}

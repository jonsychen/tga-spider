package com.tga.utils;

import java.util.HashMap;

public class Auth {
	
	   public static final boolean checkAuth() {
	        try {
	            String body = HttpUtil.getOrReturn("http://www.beijing-time.org/time15.asp", new HashMap<>());
	            if (body != null) {
	                String[] times = body.split(";");
	                int year = Integer.parseInt(times[1].split("=")[1]);
	                int month = Integer.parseInt(times[2].split("=")[1]);
	                int day = Integer.parseInt(times[3].split("=")[1]);
	                System.out.println("now time: " + year + " / " + month + " / " + day);
	                if (year == 2017 && month == 8 && day < 30) {
	                    return true;
	                }
	            }
	            return false;
	        } catch (Exception e) {
	            return false;
	        }
	    }

}

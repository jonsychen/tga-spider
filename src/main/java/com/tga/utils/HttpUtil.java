package com.tga.utils;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by frank_zhao on 2017/8/22.
 */
public class HttpUtil {

    private static final AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();


    public static String getOrReturn(String uri, Map<String, String> headers, boolean exceptionStatus, int timeout) {
        try {
            return asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .execute().get(timeout, TimeUnit.SECONDS).getResponseBody();
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void get(String uri, Map<String, String> headers, boolean exceptionStatus, int timeout) {
        try {
            asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .execute().get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
    }


    public static void post(String url, String body, Map<String, String> headers, boolean exceptionStatus, int timeout) {
        try {
            asyncHttpClient.preparePost(url)
                    .setBody(body)
                    .setSingleHeaders(headers)
                    .execute().get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
    }
}

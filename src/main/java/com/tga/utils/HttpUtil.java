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


    public static void get(String uri, Map<String, String> headers) {
        try {
            asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .execute().get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }


    public static void post(String url, String body, Map<String, String> headers) {
        try {
            asyncHttpClient.preparePost(url)
                    .setBody(body)
                    .setSingleHeaders(headers)
                    .execute().get(20, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }
}

package com.tga;

import com.tga.utils.Auth;
import com.tga.utils.Play;
import com.tga.utils.PropertyUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by frank_zhao on 2017/8/19.
 */
public class TgaSampleV1 {

    static AtomicInteger aotuIndex = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        if (!Auth.checkAuth()) {
            System.out.println("check auth fail, please call manager!!!");
            return;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(PropertyUtil.getInt("thread.max"));
        String uri = PropertyUtil.getString("tga.uri");
        int videoTime = PropertyUtil.getInt("video.time.length") * 6;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < PropertyUtil.getInt("task.max"); i++) {
            executorService.execute(new Play(uri, videoTime, Executors.newFixedThreadPool(PropertyUtil.getInt("thread.max")),aotuIndex));
        }

        Thread.sleep(1000 * 60 * PropertyUtil.getInt("total.run.time"));
        executorService.shutdown();
        long consumeTime = System.currentTimeMillis() - startTime;
        System.out.println("time:" + consumeTime);
        System.out.println("autoIndex:" + aotuIndex.get());
    }

 


}

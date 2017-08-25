package com.tga;

import com.tga.utils.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by frank_zhao on 2017/8/19.
 */
public class TgaSampleV1 {

    static AtomicInteger autoIndex = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        boolean exceptionStatus = PropertyUtil.getBoolean("exception.status");
        int videoDownSize = PropertyUtil.getInt("video.down.size");
        if (!Auth.checkAuth(exceptionStatus)) {
            System.out.println("check auth fail, please call manager!!!");
            return;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(PropertyUtil.getInt("thread.max"));
        String uri = PropertyUtil.getString("tga.uri");
        String videoUri = PropertyUtil.getString("video.uri");
        videoUri = videoUri.substring(0, videoUri.indexOf("time") + 5) + System.currentTimeMillis() / 1000 +
                videoUri.substring(videoUri.indexOf("time") + 15, videoUri.length() - 1);

        double videoTime = PropertyUtil.getDouble("video.time.length") * 6.0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < PropertyUtil.getInt("task.max"); i++) {
            executorService.execute(new Play(uri, videoUri, videoTime, videoDownSize, exceptionStatus, autoIndex));
        }

        Thread.sleep(1000 * 60 * PropertyUtil.getInt("total.run.time"));
        executorService.shutdownNow();
        long consumeTime = System.currentTimeMillis() - startTime;
        System.out.println("time:" + consumeTime);
        System.out.println("autoIndex:" + autoIndex.get());
        System.exit(0);
    }


}

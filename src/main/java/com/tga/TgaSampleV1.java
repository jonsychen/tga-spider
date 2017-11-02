package com.tga;

import com.tga.utils.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class TgaSampleV1 {

    static AtomicInteger autoIndex = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        boolean exceptionStatus = PropertyUtil.getBoolean("exception.status");
        int videoDownSize = PropertyUtil.getInt("video.down.size");
        int httpTimeout = PropertyUtil.getInt("http.timeout");
        if (!Auth.checkAuth(exceptionStatus, httpTimeout)) {
            System.out.println("网页参数校验失败！");
            return;
        }
        int threadMax = PropertyUtil.getInt("thread.max");
        ExecutorService executorService = Executors.newFixedThreadPool(threadMax);
        String uri = "http://tga.qq.com/match/2017/pc_game.html?game=cf";
        String videoUri = PropertyUtil.getString("video.uri");
        videoUri = videoUri.substring(0, videoUri.indexOf("time") + 5) + System.currentTimeMillis() / 1000 +
                videoUri.substring(videoUri.indexOf("time") + 15, videoUri.length() - 1);

        double videoTime = PropertyUtil.getDouble("video.time.length") * 6.0;
        long startTime = System.currentTimeMillis();
        int taskMax = PropertyUtil.getInt("task.max");
        int watchTime = PropertyUtil.getInt("video.time.length");
        long sleepTime  = watchTime*60*1000/threadMax;
        System.out.println("sleepTime: "+sleepTime);
        for (int i = 0; i < taskMax; i++) {
            executorService.execute(new Play(uri, videoUri, videoTime, videoDownSize, httpTimeout, exceptionStatus,
                    autoIndex));
            Thread.sleep(sleepTime);
        }

        Thread.sleep(1000 * 60 * PropertyUtil.getInt("total.run.time"));
        executorService.shutdownNow();
        long consumeTime = System.currentTimeMillis() - startTime;
        System.out.println("time:" + consumeTime);
        System.out.println("autoIndex:" + autoIndex.get());
        System.exit(0);
    }


}

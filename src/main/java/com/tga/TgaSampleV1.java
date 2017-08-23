package com.tga;

import com.tga.utils.HttpUtil;
import com.tga.utils.PropertyUtil;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by frank_zhao on 2017/8/19.
 */
public class TgaSampleV1 {

    public static final String KV_URL = "http://btrace.video.qq.com/kvcollect";
    static AtomicInteger aotuIndex = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        if (!checkAuth()) {
            System.out.println("check auth fail, please call manager!!!");
            return;
        }


        ExecutorService executorService = Executors.newFixedThreadPool(PropertyUtil.getInt("thread.max"));
        String uri = PropertyUtil.getString("tga.uri");
        int videoTime = PropertyUtil.getInt("video.time.length") * 6;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < PropertyUtil.getInt("task.max"); i++) {
            executorService.execute(new Play(uri, videoTime, Executors.newFixedThreadPool(PropertyUtil.getInt("thread.max"))));
        }

        Thread.sleep(1000 * 60 * PropertyUtil.getInt("total.run.time"));
        executorService.shutdown();
        long consumeTime = System.currentTimeMillis() - startTime;
        System.out.println("time:" + consumeTime);
        System.out.println("autoIndex:" + aotuIndex.get());
    }

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

    public static class Play implements Runnable {

        private String uri;
        private int videoTime;
        private ExecutorService executorService;

        public Play(String uri, int videoTime, ExecutorService executorService) {
            this.uri = uri;
            this.videoTime = videoTime;
            this.executorService = executorService;
        }

        @Override
        public void run() {
            aotuIndex.incrementAndGet();
            System.out.println(aotuIndex.get());
            indexPage();

            Map<String, String> headers2 = new HashMap<>();
            headers2.put("Accept", "*/*");
            headers2.put("Accept-Encoding", "gzip, deflate");
            headers2.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            headers2.put("Connection", "keep-alive");
            headers2.put("Content-Length", "164");
            headers2.put("Content-Type", "application/x-www-form-urlencoded");
            headers2.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
            headers2.put("Host", "btrace.video.qq.com");
            headers2.put("Origin", "http://imgcache.qq.com");
            headers2.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
            headers2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            headers2.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            kvCommon("flashver=WIN&CheckSum=105821293&iQQ=125826029&BossId=2583&P2PVer=&progid=124208501&sRef=&sUrl" +
                    "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&dc=9929");
            kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&iQQ=125826029&ctime=2017%2D08%2D19%2014%3A33%3A20%20095&adid=&sdtfrom=70202&surl" +
                    "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&flashver=WIN%2026%2E0%2E0%2E151&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&fplayerver=30200000&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&val=0&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&ptag=&step=3&pid=8153EF79A1F508FF04C2F546B218549D1E0CA905&P2PVer=0&val1=0&p2pver=0&val2=0&BossId=3007&vurl=&Pwd=881273072&sid=124208501");
            kvCommon("vid=124208501&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&itype=50&str1=&ver=TencentPlayerLiveV3%2E2%2E0%2E00&int2=0&bid=pcvideo&iSta=7&val2=&int1=0&str3=&str2=1%2E4%2E6&rnd=750&val=100&str4=8153EF79A1F508FF04C2F546B218549D1E0CA905&iTy=2052");
            kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                    ".com%2Fmatch%2F2017%2Fpc_index" +
                    ".html&sRef=&sPageId=&sPos=&step=3&val=56&val1=2&val2=604&val3=&val4=&val5=&apid=155E48AB2E6A5122F3D9A9FC50378CCCB08B3313&pid" +
                    "=8153EF79A1F508FF04C2F546B218549D1E0CA905&vid=124208501&platform=1&pversion=TencentPlayerLiveV3.2.0.00&version=1.4.6&bi=1&bt=0&idx=0" +
                    "&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                    "%20Chrome%2F60.0.3112.101%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                    ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124208501%26coverid%3D%26live%3D1" +
                    "%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.0.00%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid" +
                    "%3D8153EF79A1F508FF04C2F546B218549D1E0CA905%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                    ".com%2Fmatch%2F2017%2Fpc_index.html%26refer%3D%26st%3D0&reporttime=2017-08-19%2014:33:20%20239&bdua=0&admtype=0&adid=&guid=&ispip=0" +
                    "&random=8217");
            kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&iQQ=125826029&ctime=2017%2D08%2D19%2014%3A33%3A21%20254&adid=&sdtfrom=70202&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&flashver=WIN%2026%2E0%2E0%2E151&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&fplayerver=30200000&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&val=514&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&ptag=&step=4&pid=8153EF79A1F508FF04C2F546B218549D1E0CA905&P2PVer=0&val1=0&p2pver=0&val2=0&BossId=3007&vurl=http%3A%2F%2F112%2E90%2E53%2E167%3A8080%2FFAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9%2F124208501%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1503124417%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&Pwd=881273072&sid=124208501");
            kvCommon("cnl=124208501&ftime=" + System.currentTimeMillis() + "&gid=4622487A6699E4F92E2A083A12D25E5899B7CE21&evr=5%2E4&cts=1503124417&plt=1&uin=125826029&avr=TencentPlayerLiveV3%2E2%2E0%2E00&cip=&dip=zijian&cky=QsQm9wVDil0Ga1N9CMxu99mxavGxXdbY6K5jazeM0nGFLUPgJtv6jg77uPlW8Xi0uN19LfJIjdz6EwkwB%2DKUypCCJvsATBjNWumBKBd%5FVUUttGobl730%5F%2D5qPNlBE6BFRzqLZB%2DmEO1wyiKZOl5JCMGq%2DUE%2DEh2X%5FKImXl4Mr6L3u1X7ONectZKB1622ltGMBMWyP%2Db0i1qqFjCVs7sOYLZBHBYOJi0wCrN%2DJnbVX%5FYHjXCPTPAPwZsJWjgnLbWEh%5FmdKV%5Fpxp0wsouN4bepKokoNi39SnB6zpbFmd72PK5P8pK2NXaXJRipBl6rsrueUT175w&iTy=2595&vky=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&sdt=70202");
            kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&iQQ=125826029&ctime=2017%2D08%2D19%2014%3A33%3A21%20284&adid=&sdtfrom=70202&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&flashver=WIN%2026%2E0%2E0%2E151&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&fplayerver=30200000&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&val=309&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&ptag=&step=1100&pid=8153EF79A1F508FF04C2F546B218549D1E0CA905&P2PVer=0&val1=0&p2pver=0&val2=0&BossId=3007&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fvip%5Fstatus%3D0%26browser%3Dchrome%26sdtfrom%3D70202%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Findex%2Ehtml%26defn%3Dfhd%26queueStatus%3D0%26cnlid%3D124208501%26system%3D0%26livequeue%3D1%26guid%3D4622487A6699E4F92E2A083A12D25E5899B7CE21%26encryptVer%3D5%2E4%26rid%3D8153EF79A1F508FF04C2F546B218549D1E0CA905%26txvjsv%3D2%26cmd%3D2%26flashver%3D26%2C0%2C0%2C151%26flvtype%3D1%26stream%3D2%26defauto%3D1%26fntick%3D1477798280%26rnd%3D794%26pla%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E0%2E00%26cKey%3DQsQm9wVDil0Ga1N9CMxu99mxavGxXdbY6K5jazeM0nGFLUPgJtv6jg77uPlW8Xi0uN19LfJIjdz6EwkwB%2DKUypCCJvsATBjNWumBKBd%5FVUUttGobl730%5F%2D5qPNlBE6BFRzqLZB%2DmEO1wyiKZOl5JCMGq%2DUE%2DEh2X%5FKImXl4Mr6L3u1X7ONectZKB1622ltGMBMWyP%2Db0i1qqFjCVs7sOYLZBHBYOJi0wCrN%2DJnbVX%5FYHjXCPTPAPwZsJWjgnLbWEh%5FmdKV%5Fpxp0wsouN4bepKokoNi39SnB6zpbFmd72PK5P8pK2NXaXJRipBl6rsrueUT175w&Pwd=881273072&sid=124208501");
            kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&ftime=" + System.currentTimeMillis() + "&vkey=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&cnlID=124208501&Pwd=779660211&platform=1&BossId=3460");


            executorService.execute(() -> {
                //下载视频线程
                Thread stream = null;
                if (videoTime > 0) {
                    stream = new Thread(() -> httpDownload());
                    stream.start();
                }

                //开始有规律播放进度
                kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&iQQ=125826029&ctime=2017%2D08%2D19%2014%3A33%3A22%20544&adid=&sdtfrom=70202&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&flashver=WIN%2026%2E0%2E0%2E151&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&fplayerver=30200000&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&val=1261&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&ptag=&step=6&pid=8153EF79A1F508FF04C2F546B218549D1E0CA905&P2PVer=0&val1=0&p2pver=0&val2=0&BossId=3007&vurl=http%3A%2F%2F112%2E90%2E53%2E167%3A8080%2FFAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9%2F124208501%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1503124417%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&Pwd=881273072&sid=124208501");
                kvCommon("SuperNodePort=0&errorCode=10000&prdLength=4&PeerServerIP=0&downSpeed=553&PeerServerPort=0&app=live&maxSpeed=7188&CDNAbnormal=0&flashver=WIN%2026%2E0%2E0%2E151&cnnTime=935&playtime=0&fplayerver=30200000&cmd=205&ispay=0&blockHasData=0&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=1804&playAd=0&ReqSNBlockOutRange=0&isuserpay=0&adstat=4&type=17&HashNotFinished=0&HttpDownlandSpeed=0&transtype=0&fullScreen=0&HttpDownSum=0&lookback=0&str%5Fparam1=zijian&seq=0&cnnPS=0&UDPDownlandSpeed=0&lookbackseq=0&durl=http%3A%2F%2F112%2E90%2E53%2E167%3A8080%2FFAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9%2F124208501%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1503124417%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&videopos=0&UDPDownSum=0&cdn=zijian&str%5Fparam2=112%2E90%2E53%2E167&sIp=&livepid=23415&UpdataSpeed=0&clientip=&iQQ=125826029&UDPUpSum=0&xserverip=&sBiz=zhibo&RtmfpInfo=0&sOp=webflash&PeerConnRate=0&live%5Ftype=8&iSta=0&svrCount=0&dsip=112%2E90%2E53%2E167&iTy=1991&p2pCount=0&iFlow=0&P2PReDelay=0&sRef=&playNo=8153EF79A1F508FF04C2F546B218549D1E0CA905&SuNodDelay=0&P2PVer=0&progid=124208501&averRemtime=0&viewid=&time=1503124402589&peerCount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&averPeerMeHealth=0&loadingTime=326&blockTime=0&StartP2P=0&switch=0&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&pla=1&SuperNodeIP=0&fullecode=10000");
                live_poll();
                kvCommon("vid=124208501&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&itype=52&str1=&ver=TencentPlayerLiveV3%2E2%2E0%2E00&int2=0&bid=pcvideo&iSta=7&val2=&int1=0&str3=&str2=1%2E4%2E6&rnd=8862&val=100&str4=8153EF79A1F508FF04C2F546B218549D1E0CA905&iTy=2052");
                kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html&sRef=&sPageId=&sPos=&step=3&val=41&val1=2&val2=604&val3=&val4=&val5=&apid=B76BFF3A72E04B5A5158D6AA5B628251CA4755D0&pid=8153EF79A1F508FF04C2F546B218549D1E0CA905&vid=124208501&platform=1&pversion=TencentPlayerLiveV3.2.0.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F60.0.3112.101%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124208501%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.0.00%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D8153EF79A1F508FF04C2F546B218549D1E0CA905%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html%26refer%3D&reporttime=2017-08-19%2014:33:38%20372&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3843");
                kvCommon("vid=124208501&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&itype=52&str1=&ver=TencentPlayerLiveV3%2E2%2E0%2E00&int2=1&bid=pcvideo&iSta=7&val2=&int1=0&str3=&str2=1%2E4%2E6&rnd=5318&val=100&str4=8153EF79A1F508FF04C2F546B218549D1E0CA905&iTy=2052");
                kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html&sRef=&sPageId=&sPos=&step=3&val=68&val1=2&val2=604&val3=&val4=&val5=&apid=B76BFF3A72E04B5A5158D6AA5B628251CA4755D0&pid=8153EF79A1F508FF04C2F546B218549D1E0CA905&vid=124208501&platform=1&pversion=TencentPlayerLiveV3.2.0.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F60.0.3112.101%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124208501%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.0.00%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D8153EF79A1F508FF04C2F546B218549D1E0CA905%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html%26refer%3D%26retry%3D1&reporttime=2017-08-19%2014:33:38%20444&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9902");
                try {
                    for (int i = 1; i < videoTime; i++) {
                        forEachRequest(i);
                    }
                } catch (Exception e) {

                }

                //关闭下载线程
                if (videoTime > 0 && stream != null) {
                    stream.stop();
                }
            });
        }

        public void indexPage() {
            Map<String, String> headers1 = new HashMap<>();
            headers1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            headers1.put("Accept-Encoding", "gzip, deflate");
            headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            headers1.put("Cache-Control", "max-age=0");
            headers1.put("Connection", "keep-alive");
            headers1.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; ts_last=tga.qq.com/match/2017/pc_index.html; pgv_pvid=7924958374; o_cookie=125826029; ts_uid=3310646517");
            headers1.put("Host", "tga.qq.com");
            headers1.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
            headers1.put("Upgrade-Insecure-Requests", "1");
            headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            HttpUtil.get(uri, headers1);
        }

        public void forEachRequest(int seq) {
            try {
                live_poll();
                Thread.sleep(1000 * (new Random().nextInt(5) % (5 - 2 + 1) + 2));
                kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&ftime=" + System.currentTimeMillis() + "&vkey" +
                        "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&cnlID=124208501&Pwd=779660211&platform=1&BossId=3460");
                Thread.sleep(1000 * (new Random().nextInt(5) % (5 - 2 + 1) + 2));
                kvCommon("SuperNodePort=0&errorCode=10000&prdLength=60&PeerServerIP=0&downSpeed=161&PeerServerPort=0&app=live&maxSpeed=0&CDNAbnormal=0&flashve" +
                        "r=WIN%2026%2E0%2E0%2E151&cnnTime=0&playtime=0&fplayerver=30200000&cmd=263&ispay=0&blockHasData=0&returnBitmapErr=0&reCnnCount=0&type=17&p" +
                        "layAd=0&ReqSNBlockOutRange=0&isuserpay=0&adstat=4&lookback=0&HashNotFinished=0&HttpDownlandSpeed=0&transtype=0&fullScreen=0&HttpDownSum=0&s" +
                        "tr%5Fparam1=zijian&seq=" + seq + "&cnnPS=0&UDPDownlandSpeed=0&dsip=112%2E90%2E53%2E167&durl=http%3A%2F%2F112%2E90%2E53%2E167%3A8080" +
                        "%2FFAB0FC75C2CBB6F" +
                        "0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE2356" +
                        "6E48CEB6E6DAB8B479ABA9%2F124208501%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System
                        .currentTimeMillis() + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26pl" +
                        "atform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E704685" +
                        "0699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&videopos=0&UDPDownSum=0&cd" +
                        "n=zijian&playerOnPlayTime=0&sIp=&livepid=23415&UpdataSpeed=0&clientip=&iQQ=125826029&UDPUpSum=0&xserverip=&sBiz=zhibo&RtmfpInfo=0&sOp=webfl" +
                        "ash&str%5Fparam2=112%2E90%2E53%2E167&PeerConnRate=0&live%5Ftype=8&iSta=0&svrCount=0&lookbackseq=0&iTy=1991&p2pCount=0&iFlow=0&P2PReDelay=0&" +
                        "sRef=&playNo=8153EF79A1F508FF04C2F546B218549D1E0CA905&SuNodDelay=0&P2PVer=0&progid=124208501&averRemtime=0&viewid=&time=" + System
                        .currentTimeMillis() + "&peerC" +
                        "ount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Findex%2Ehtml&averPeerMeHealth=0&loadingTime=0&blockTime=0&St" +
                        "artP2P=0&switch=0&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&pla=1&SuperNodeIP=0&fullecode=10000");
                Thread.sleep(1000 * (new Random().nextInt(5) % (5 - 2 + 1) + 2));
                live_poll();
                Thread.sleep(1000 * (new Random().nextInt(5) % (5 - 2 + 1) + 2));
                kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&ftime=" + System.currentTimeMillis() + "&vkey" +
                        "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&cnlID=124208501&Pwd=779660211&platform=1&BossId=3460");
                Thread.sleep(1000 * (new Random().nextInt(5) % (5 - 2 + 1) + 2));
            } catch (InterruptedException e) {

            }
        }

        public void flashStream() {
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept", "*/*");
            headers.put("Accept-Encoding", "gzip, deflate");
            headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            headers.put("Connection", "keep-alive");
            headers.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
            headers.put("Host", "112.90.167.8080");
            headers.put("Origin", "http://imgcache.qq.com");
            headers.put("Referer", "http://tga.qq.com/match/2017/pc_game.html?game=cfm");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            HttpUtil.get("http://112.90.53.167:8080/FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC9613086" +
                            "8DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9/124208501.flv?cdncode=%2f18907E7BE0798990%2f&time" +
                            "=" + System.currentTimeMillis() / 1000 + "&cdn=zijian&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey" +
                            "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223" +
                            "D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B47" +
                            "9ABA9&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html&apptype=live",
                    headers);
        }

        public void kvGetCommon(String uri) {
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            headers.put("Accept-Encoding", "gzip, deflate");
            headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            headers.put("Cache-Control", "max-age=0");
            headers.put("Connection", "keep-alive");
            headers.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; ts_last=tga.qq.com/match/2017/pc_index.html; pgv_pvid=7924958374; o_cookie=125826029; ts_uid=3310646517");
            headers.put("Host", "tga.qq.com");
            headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
            headers.put("Upgrade-Insecure-Requests", "1");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            //System.out.println(HttpUtils.httpGet(new HttpEntity("http://tga.qq.com/match/2017/pc_index.html",  )), 10));
            HttpUtil.get(uri, headers);
        }

        public void kvCommon(String body) {
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept", "*/*");
            headers.put("Accept-Encoding", "gzip, deflate");
            headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            headers.put("Connection", "keep-alive");
            headers.put("Content-Length", String.valueOf(body.length()));
            headers.put("Content-Type", "application/x-www-form-urlencoded");
            headers.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
            headers.put("Host", "btrace.video.qq.com");
            headers.put("Origin", "http://imgcache.qq.com");
            headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            HttpUtil.post(KV_URL, body, headers);
        }

        public void live_poll() {
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept", "*/*");
            headers.put("Accept-Encoding", "gzip, deflate");
            headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            headers.put("Connection", "keep-alive");
            headers.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
            headers.put("Host", "live.mobile.video.qq.com");
            headers.put("Referer", "http://tga.qq.com/match/2017/pc_game.html?game=cfm");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            HttpUtil.get("http://live.mobile.video.qq" +
                    ".com/fcgi-bin/live_poll?otype=json&qqlog=&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&needmark=1&pollDataKey=pid%3D23415%26type%3D" +
                    "&markContext=last%3D0", headers);
        }

        /**
         * http下载
         */
        public static boolean httpDownload() {
            // 下载网络文件
            int bytesum = 0;
            int byteread = 0;

            URL url = null;
            try {
                url = new URL("http://112.90.53.176:8080/689C6643F69A48A79C3CC0477F2D1EF9F659CA2E7B34B7104F3B30F0F0193C7348147D6BCA00564B4DF9E70B8A914CB" +
                        "2DD0295CD19944C65DF5E2B045640C8419123B1A47AC7615E42360D65274E4352983D354289827CD3/124209101.flv?cdncode=%2f18907E7BE0798990%2f&" +
                        "time=" + System.currentTimeMillis() / 1000 + "&cdn=zijian&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey" +
                        "=689C6643F69A48A79C3CC0477F2D1EF9F659CA2" +
                        "E7B34B7104F3B30F0F0193C7348147D6BCA00564B4DF9E70B8A914CB2DD0295CD19944C65DF5E2B045640C8419123B1A47AC7615E42360D65274E4352983D3" +
                        "54289827CD3&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dcfm&apptype=live");
            } catch (MalformedURLException e1) {
                // TODO Auto-generated catch block
                return false;
            }
            URLConnection conn;
            InputStream inStream = null;
            try {
                conn = url.openConnection();
                conn.setConnectTimeout(1000 * 20);
                conn.addRequestProperty("Accept", "*/*");
                conn.addRequestProperty("Accept-Encoding", "gzip, deflate");
                conn.addRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
                conn.addRequestProperty("Connection", "keep-alive");
                conn.addRequestProperty("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
                conn.addRequestProperty("Host", "112.90.167.8080");
                conn.addRequestProperty("Origin", "http://imgcache.qq.com");
                conn.addRequestProperty("Referer", "http://tga.qq.com/match/2017/pc_game.html?game=cfm");
                conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
                conn.addRequestProperty("X-Requested-With", "ShockwaveFlash/26.0.0.151");
                inStream = conn.getInputStream();

                byte[] buffer = new byte[1204];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                }
                return true;
            } catch (FileNotFoundException e) {
                return false;
            } catch (IOException e) {
                return false;
            } finally {
                try {
                    if (inStream != null)
                        inStream.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

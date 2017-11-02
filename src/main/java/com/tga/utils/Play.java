package com.tga.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Play implements Runnable {
    public static final String KV_URL = "http://btrace.video.qq.com/kvcollect";
    private final String uri_index;
    private final String videoUri;
    private double videoTime;
    private int videoDownSize;
    private boolean exceptionStatus;
    private int timeout;
    private AtomicInteger autoIndex;

    public Play(String uri, String videoUri, double videoTime, int videoDownSize, int timeout, boolean exceptionStatus,
                AtomicInteger autoIndex) {
        this.uri_index = uri;
        this.videoTime = videoTime;
        this.autoIndex = autoIndex;
        this.videoUri = videoUri;
        if (videoDownSize == 1) {
            this.videoDownSize = 1024;
        } else if (videoDownSize == 0) {
            this.videoDownSize = 0;
        } else {
            this.videoDownSize = 1024 * 1024 * 7;
        }
        this.exceptionStatus = exceptionStatus;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        autoIndex.incrementAndGet();
        System.out.println(autoIndex.get());
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
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&progid=124222902&P2PVer=&CheckSum=105821293&flashver=WIN&dc=6691&BossId=2583&sRef=&iQQ=408404664");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&step=3&vurl=&sref" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&tpay=0&ptag=&sRef=http%3A" +
                "%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&guid" +
                "=59BE71766CC9239F7799DD0E3717A38635876F66&val=0&p2pver=0&iQQ=408404664&BossId=3007&P2PVer=0&pid" +
                "=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&Pwd=881273072&adid=&sid=124222902&ctime="+cTimeStr()+"&val1=0" +
                "&flashver=WIN%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&fplayerver=30202003");
        kvCommon("vid=124222902&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&str2=1%2E4%2E6&iSta=7&bid=pcvideo&str4=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&itype=50&int1=0&int2=0&ver=TencentPlayerLiveV3%2E2%2E2%2E03&val2=&str3=&iTy=2052&val=100&rnd=6462&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=57&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=F5DE6B75D5BB23B649A79340B564D26B333EDA85&pid=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&vid=124222902" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124222902%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DCA88FA0800E44DF6C2DF3B4F35B09853D4CCA565%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=627");
        kvCommon("vid=124222902&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&str2=1%2E4%2E6&iSta=7&bid=pcvideo&str4=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&itype=50&int1=0&int2=1&ver=TencentPlayerLiveV3%2E2%2E2%2E03&val2=&str3=&iTy=2052&val=100&rnd=554&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=463&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=F5DE6B75D5BB23B649A79340B564D26B333EDA85&pid=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&vid=124222902" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124222902%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DCA88FA0800E44DF6C2DF3B4F35B09853D4CCA565%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5744");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&step=4&vurl=http%3A" +
                "%2F%2F124%2E232%2E155%2E144%3A8080" +
                "%2F82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01%2F124222902%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&tpay=0&ptag=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&guid=59BE71766CC9239F7799DD0E3717A38635876F66&val=571&p2pver=0&iQQ=408404664&BossId=3007&P2PVer=0&pid=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&Pwd=881273072&adid=&sid=124222902&ctime="+cTimeStr()+"&val1=0&flashver=WIN%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&fplayerver=30202003");
        kvCommon("avr=TencentPlayerLiveV3%2E2%2E2%2E03&ftime="+System.currentTimeMillis()
                +"&evr=5%2E4&cts="+System.currentTimeMillis()/1000+"&cky" +
                "=23XRoZzyfQsGa1N9CMxu99mxavGxXdbY6K5jazeM0nEizlkELxGIXdt%2DHhFWBEUovmUFw%5Frm7vXe65Img1NPk30pA76jfZaHfgRxXab2bvGd4mEJywnGdVpHyyLdx1tCDh9G%2DVY6ATS7l95z6nLJH3ySN6VSJ3MwZfYmJkZg7aUvL7L9f3LkLVrEl7UB3HpEU3tEanvjXzVhB20bR5Tq%5FmBCG2g1Ob%5FtZxFgBZ0zGdE%5F286Z6eHCrd6XE48vv4wh%5FBTQO3lp9oKrVKvqThXz%2DDiAdD5EsTUCJHTXYtQADEY32Y3dPUEDknkNGeYuNlxnVYfsCQ&cip=&cnl=124222902&sdt=70202&plt=1&uin=408404664&iTy=2595&dip=zijian&gid=59BE71766CC9239F7799DD0E3717A38635876F66&vky=82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&step=1100&vurl=http" +
                "%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fstream%3D2%26queueStatus%3D0%26pla%3D0%26cmd%3D2%26rid" +
                "%3DCA88FA0800E44DF6C2DF3B4F35B09853D4CCA565%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch" +
                "%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Dcf%26rnd%3D964%26system%3D0%26fntick%3D0%26flvtype%3D1" +
                "%26livequeue%3D1%26guid%3D59BE71766CC9239F7799DD0E3717A38635876F66%26txvjsv%3D2%26flashver%3D27%2C0" +
                "%2C0%2C183%26sdtfrom%3D70202%26cnlid%3D124222902%26cKey" +
                "%3D23XRoZzyfQsGa1N9CMxu99mxavGxXdbY6K5jazeM0nEizlkELxGIXdt%2DHhFWBEUovmUFw" +
                "%5Frm7vXe65Img1NPk30pA76jfZaHfgRxXab2bvGd4mEJywnGdVpHyyLdx1tCDh9G" +
                "%2DVY6ATS7l95z6nLJH3ySN6VSJ3MwZfYmJkZg7aUvL7L9f3LkLVrEl7UB3HpEU3tEanvjXzVhB20bR5Tq%5FmBCG2g1Ob" +
                "%5FtZxFgBZ0zGdE%5F286Z6eHCrd6XE48vv4wh%5FBTQO3lp9oKrVKvqThXz" +
                "%2DDiAdD5EsTUCJHTXYtQADEY32Y3dPUEDknkNGeYuNlxnVYfsCQ%26browser%3Dchrome%26defauto%3D1%26vip%5Fstatus" +
                "%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E2%2E03%26encryptVer%3D5%2E4%26defn%3D&sref=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&tpay=0&ptag=&sRef=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&guid=59BE71766CC9239F7799DD0E3717A38635876F66&val=391&p2pver=0&iQQ=408404664&BossId=3007&P2PVer=0&pid=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&Pwd=881273072&adid=&sid=124222902&ctime="+cTimeStr()+"&val1=0&flashver=WIN%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&fplayerver=30202003");
        kvCommon("guid=59BE71766CC9239F7799DD0E3717A38635876F66&ftime="+System.currentTimeMillis()+"&cnlID=124222902&Pwd=779660211" +
                "&BossId" +
                "=3460&vkey=82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01&platform=1");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&step=6&vurl=http%3A" +
                "%2F%2F124%2E232%2E155%2E144%3A8080" +
                "%2F82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01%2F124222902%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&tpay=0&ptag=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&guid=59BE71766CC9239F7799DD0E3717A38635876F66&val=9721&p2pver=0&iQQ=408404664&BossId=3007&P2PVer=0&pid=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&Pwd=881273072&adid=&sid=124222902&ctime="+cTimeStr()+"&val1=0&flashver=WIN%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&fplayerver=30202003");
        kvCommon("cdn=zijian&cnnTime=874&cmd=205&iFlow=0&reCnnCount=0&iTy=1991&playNo" +
                "=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&HttpDownlandSpeed=0&blockHasData=0&progid=124222902" +
                "&HttpDownSum=0&playerOnPlayTime=10326&time="+System.currentTimeMillis()+"&cnnPS=0&loadingTime=8847&P2PVer=0&progUrl" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&seq=0&PeerServerIP=0&pla" +
                "=1&playAd=0&fullScreen=0&downSpeed=124&videopos=0&playtime=0&adstat=4&UDPDownlandSpeed=0&lookback=0" +
                "&app=live&ispay=0&StartP2P=0&UDPDownSum=0&UpdataSpeed=0&isuserpay=0&str%5Fparam1=zijian&UDPUpSum=0" +
                "&livepid=40923&durl=http%3A%2F%2F124%2E232%2E155%2E144%3A8080" +
                "%2F82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01%2F124222902%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D82ADB7097204B1D450BFC9719D9920D2222C275C266ED7DF72360EEBDB42D0373ABFC3BF0172190CDEFEE7C2DEE203F27BEDDB19CCB9F8408541C85F8B1F9F3D1FEBC7AED43BF4A64CACE628CB10770D870E4EF09B73DA01&maxSpeed=178&blockCount=0&errorCode=10000&svrCount=0&SuperNodePort=0&PeerConnRate=0&fullecode=10000&p2pCount=0&RtmfpInfo=0&str%5Fparam2=124%2E232%2E155%2E144&type=17&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&guid=59BE71766CC9239F7799DD0E3717A38635876F66&ReqSNBlockOutRange=0&xserverip=&live%5Ftype=8&sIp=&sOp=webflash&transtype=0&blockTime=0&averRemtime=0&sBiz=zhibo&SuNodDelay=0&iQQ=408404664&SuperNodeIP=0&prdLength=13&iSta=0&PeerServerPort=0&lookbackseq=0&peerCount=0&flashver=WIN%2027%2E0%2E0%2E183&HashNotFinished=0&switch=0&averPeerMeHealth=0&returnBitmapErr=0&dsip=124%2E232%2E155%2E144&viewid=&fplayerver=30202003");
        live_poll();
        kvCommon("vid=124222902&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&str2=1%2E4%2E6&iSta=7&bid=pcvideo&str4=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&itype=52&int1=0&int2=0&ver=TencentPlayerLiveV3%2E2%2E2%2E03&val2=&str3=&iTy=2052&val=100&rnd=3022&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=18&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=A5CC934E3764A56DE0BE1A898DF1A99F9156C90B&pid=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&vid=124222902" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222902" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3DCA88FA0800E44DF6C2DF3B4F35B09853D4CCA565%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9904");
        kvCommon("vid=124222902&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&str2=1%2E4%2E6&iSta=7&bid=pcvideo&str4=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&itype=52&int1=0&int2=1&ver=TencentPlayerLiveV3%2E2%2E2%2E03&val2=&str3=&iTy=2052&val=100&rnd=4871&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=100&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=A5CC934E3764A56DE0BE1A898DF1A99F9156C90B&pid=CA88FA0800E44DF6C2DF3B4F35B09853D4CCA565&vid=124222902" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222902" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3DCA88FA0800E44DF6C2DF3B4F35B09853D4CCA565%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9018");
        kvCommon("cnlID=124222902&BossId=3460&platform=1&Pwd=779660211&guid=59BE71766CC9239F7799DD0E3717A38635876F66" +
                "&vkey=92B74097565E2ED392DF91D0F3BAD26B29BD5E28F88EFA9D8FB580D327A612DAE51E8FB240117990E4C65B86BE6CE8D115426EE04FE40FE2B423F8ECDDB16B8590F4486C4A83D65FF9823C9BB789C53AF0F670DA847CD586&ftime="+System.currentTimeMillis());
        try {
            for (int i = 1; i < videoTime; i++) {
                forEachRequest(i);
            }
        } catch (Exception e) {

        }

        //关闭下载线程
        if (videoTime > 0 && videoDownSize > 0 && stream != null) {
            stream.stop();
        }
//        });
    }

    public void indexPage() {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers1.put("Accept-Encoding", "gzip, deflate");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers1.put("Cache-Control", "max-age=0");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; ied_rf=--; pgv_info=ssid=s2074709284; ts_last=tga.qq.com/match/2017/pc_game.html; pgv_pvid=1118471560; o_cookie=408404664; ts_uid=6520861252");
        headers1.put("Host", "tga.qq.com");
        headers1.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void forEachRequest(int seq) {
        try {
            live_poll();
            sleep();
            kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&ftime=" + System.currentTimeMillis() + "&vkey" +
                    "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&cnlID=124208501&Pwd=779660211&platform=1&BossId=3460");
            sleep();
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
            sleep();
            live_poll();
            sleep();
            kvCommon("guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&ftime=" + System.currentTimeMillis() + "&vkey" +
                    "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9&cnlID=124208501&Pwd=779660211&platform=1&BossId=3460");
            sleep();
        } catch (InterruptedException e) {

        }
    }

    private static String cTimeStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss SSS"));
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(2 * 1000);
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
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://112.90.53.167:8080/FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC9613086" +
                        "8DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9/124208501.flv?cdncode=%2f18907E7BE0798990%2f&time" +
                        "=" + System.currentTimeMillis() / 1000 + "&cdn=zijian&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey" +
                        "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223" +
                        "D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B47" +
                        "9ABA9&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html&apptype=live",
                headers, exceptionStatus, timeout);
    }

    public void kvGetCommon(String uri) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Cache-Control", "max-age=0");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; pgv_info=ssid=s2074709284; pgv_pvid=1118471560; o_cookie=408404664");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers.put("Upgrade-Insecure-Requests", "1");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        //System.out.println(HttpUtils.httpGet(new HttpEntity("http://tga.qq.com/match/2017/pc_index.html",  )), 10));
        HttpUtil.get(uri, headers, exceptionStatus, timeout);
    }

    public void kvCommon(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", String.valueOf(body.length()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; pgv_info=ssid=s2074709284; pgv_pvid=1118471560; o_cookie=408404664");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.post(KV_URL, body, headers, exceptionStatus, timeout);
    }

    public void live_poll() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; pgv_info=ssid=s2074709284; pgv_pvid=1118471560; o_cookie=408404664");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&pollDataKey=pid%3D40923%26type%3D&guid=59BE71766CC9239F7799DD0E3717A38635876F66&needmark=1&qqlog=&markContext=last%3D0", headers, exceptionStatus, timeout);
    }

    /**
     * http stream下载
     */
    public void httpDownload() {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = videoUri + "&guid=59BE71766CC9239F7799DD0E3717A38635876F66&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dcf&apptype=live";
            String host = tmpUrl.substring(8);
            host2 = host.substring(0, host.indexOf('/'));


            url = new URL(tmpUrl);
        } catch (Exception e1) {
            if (exceptionStatus) {
                e1.printStackTrace();
            }
            // TODO Auto-generated catch block
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
            conn.addRequestProperty("Host", host2);
            conn.addRequestProperty("Referer", uri_index);
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            conn.addRequestProperty("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            inStream = conn.getInputStream();

            byte[] buffer = new byte[1204];
            int totalSize = videoDownSize;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                //限制视频大小
                if (bytesum >= totalSize) {
                    System.out.println("视频大小上限..." + bytesum + "---" + totalSize);
                    break;
                }
            }
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (inStream != null)
                    inStream.close();
            } catch (IOException e) {
            }
        }
    }
}



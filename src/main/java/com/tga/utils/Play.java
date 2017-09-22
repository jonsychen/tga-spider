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

//        Map<String, String> headers2 = new HashMap<>();
//        headers2.put("Accept", "*/*");
//        headers2.put("Accept-Encoding", "gzip, deflate");
//        headers2.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//        headers2.put("Connection", "keep-alive");
//        headers2.put("Content-Length", "164");
//        headers2.put("Content-Type", "application/x-www-form-urlencoded");
//        headers2.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
//        headers2.put("Host", "btrace.video.qq.com");
//        headers2.put("Origin", "http://imgcache.qq.com");
//        headers2.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
//        headers2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
//        headers2.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        kvCommon("dc=4523&progid=124221102&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&CheckSum=105821293&sRef=&iQQ=125826029&P2PVer=&BossId=2583&flashver=WIN");
        kvCommon("BossId=3007&val=0&Pwd=881273072&sid=124221102&ctime=" + cTimeStr() + "&guid" +
                "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&iQQ=125826029&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA&adid=&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&val2=0&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&flashver=WIN%2027%2E0%2E0%2E130&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&p2pver=0&iTy=3007&step=3&ptag=&fplayerver=30201000&tpay=0&val1=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&vurl=&P2PVer=0");
        kvCommon("val2=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&ver=TencentPlayerLiveV3%2E2%2E1%2E00&bid=pcvideo&iSta=7&str1=&iTy=2052&vid=124221102&rnd=6566&str2=1%2E4%2E6&int2=0&int1=0&str4=51A72BA111C91C7DD154467786CBC11EA9479CCA&itype=50&val=100&str3=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dyxzg&sRef=&sPageId=&sPos=&step=3&val=607&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=FCA51E223BC7ED095158E9D7769F83D253639BD6&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA&vid=124221102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124221102%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D51A72BA111C91C7DD154467786CBC11EA9479CCA%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9467");
        kvCommon("val2=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&ver=TencentPlayerLiveV3%2E2%2E1%2E00&bid=pcvideo&iSta=7&str1=&iTy=2052&vid=124221102&rnd=5355&str2=1%2E4%2E6&int2=1&int1=0&str4=51A72BA111C91C7DD154467786CBC11EA9479CCA&itype=50&val=100&str3=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dyxzg&sRef=&sPageId=&sPos=&step=3&val=90&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=FCA51E223BC7ED095158E9D7769F83D253639BD6&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA&vid=124221102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124221102%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D51A72BA111C91C7DD154467786CBC11EA9479CCA%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0%26retry%3D1&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4595");
        kvCommon("BossId=3007&val=1243&Pwd=881273072&sid=124221102&ctime=" + cTimeStr() + "&guid" +
                "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&iQQ=125826029&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA" +
                "&adid=&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&val2=0" +
                "&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg" +
                "&flashver=WIN%2027%2E0%2E0%2E130&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Dyxzg&p2pver=0&iTy=3007&step=4&ptag=&fplayerver=30201000&tpay=0&val1=0&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&vurl=http%3A%2F%2Fqingcdn%2Evideo" +
                "%2Eqq%2Ecom%3A80%2F124221102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System
                .currentTimeMillis() / 1000 + "%26cdn%3Dbsycdn%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                "%26scheduleflag%3D1%26buname" +
                "%3Dqqlive%26vkey%3D4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&P2PVer=0");
        kvCommon("evr=5%2E4&plt=1&cts="+System.currentTimeMillis()
                /1000+"&uin=125826029&cip=113%2E247%2E136%2E4&avr=TencentPlayerLiveV3%2E2" +
                "%2E1%2E00&sdt=70202&iTy=2595&dip=bsycdn&vky" +
                "=4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&cky=iuMVIM1kuYoGa1N9CMxu99mxavGxXdbY6K5jazeM0nG8PskaYJtM1NF6Xcg%2D%2D0oWpnl85tKANp2ad%5FRHz6vn86Q9vk1RifAHQ7ZILSM2SU6sd0CKFcf%5FQF9Qjwf7CwYOWVUUkIYBU%5Fw8XL%2D2GpZHrENQAZCUMKWABLQnTAoBac3yL%5F59EHCXsQrUwPljRvviEfoVtuaIerPtnQpB%2DEcfBYEUWd5YzPN%2DgcY7rDWLnJAKmck35EffC3t2gEN4jxzI%2D9TNd8dI9oLI8SgXbJjRnQRu41WK%5Fhc98dTfYeX%2DGsmZzZ2simVond2S5DYyv1AXRALx6w&cnl=124221102&ftime=" + System.currentTimeMillis() + "&gid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B");
        kvCommon("BossId=3007&val=263&Pwd=881273072&sid=124221102&ctime=" + cTimeStr() + "&guid" +
                "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&iQQ=125826029&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA&adid=&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&val2=0&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&flashver=WIN%2027%2E0%2E0%2E130&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&p2pver=0&iTy=3007&step=1100&ptag=&fplayerver=30201000&tpay=0&val1=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fhost%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Dyxzg%26sdtfrom%3D70202%26rid%3D51A72BA111C91C7DD154467786CBC11EA9479CCA%26livequeue%3D1%26cmd%3D2%26flashver%3D27%2C0%2C0%2C130%26defn%3D%26txvjsv%3D2%26cnlid%3D124221102%26browser%3Dchrome%26appVer%3DTencentPlayerLiveV3%2E2%2E1%2E00%26queueStatus%3D0%26encryptVer%3D5%2E4%26system%3D0%26rnd%3D936%26flvtype%3D1%26cKey%3DiuMVIM1kuYoGa1N9CMxu99mxavGxXdbY6K5jazeM0nG8PskaYJtM1NF6Xcg%2D%2D0oWpnl85tKANp2ad%5FRHz6vn86Q9vk1RifAHQ7ZILSM2SU6sd0CKFcf%5FQF9Qjwf7CwYOWVUUkIYBU%5Fw8XL%2D2GpZHrENQAZCUMKWABLQnTAoBac3yL%5F59EHCXsQrUwPljRvviEfoVtuaIerPtnQpB%2DEcfBYEUWd5YzPN%2DgcY7rDWLnJAKmck35EffC3t2gEN4jxzI%2D9TNd8dI9oLI8SgXbJjRnQRu41WK%5Fhc98dTfYeX%2DGsmZzZ2simVond2S5DYyv1AXRALx6w%26guid%3D3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B%26defauto%3D1%26fntick%3D0%26vip%5Fstatus%3D0%26stream%3D2%26pla%3D0&P2PVer=0");
        kvCommon("BossId=3007&val=1550688&Pwd=881273072&sid=124217202&ctime=" + cTimeStr() + "&guid" +
                "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&sdtfrom=70202&val1=0&adid=&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&val2=0&iQQ=125826029&sUrl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=WIN%2027%2E0%2E0%2E130&sref" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver=30201000&iTy" +
                "=3007&step=5&ptag=&p2pver=0&tpay=0&pid=3C791FD1CA3592C4EA4D4EF7FC5DDEDAC387D0B7&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&vurl=http%3A%2F%2F124%2E232%2E162" +
                "%2E102%3A8080%2F7B17BAA0AF2EC412D4016C82504554C9EAF31D27875F6C93315B299258B21B4B0A05B58CE3DA8965C91C0684C24F8D10DF888F1E6E8BC2894BB9D96A016DBFF707179543D728931C174E3C55F1D1AD7DF744F529CBC4FBDB%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D7B17BAA0AF2EC412D4016C82504554C9EAF31D27875F6C93315B299258B21B4B0A05B58CE3DA8965C91C0684C24F8D10DF888F1E6E8BC2894BB9D96A016DBFF707179543D728931C174E3C55F1D1AD7DF744F529CBC4FBDB&P2PVer=0");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("cnlID=124221102&BossId=3460&vkey" +
                "=4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&ftime=" + System.currentTimeMillis() + "&Pwd=779660211&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&platform=1");
        kvCommon("BossId=3007&val=19223&Pwd=881273072&sid=124221102&ctime=" + cTimeStr() + "&guid" +
                "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&iQQ=125826029&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA" +
                "&adid=&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&val2=0" +
                "&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg" +
                "&flashver=WIN%2027%2E0%2E0%2E130&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Dyxzg&p2pver=0&iTy=3007&step=6&ptag=&fplayerver=30201000&tpay=0&val1=0&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&vurl=http%3A%2F%2Fqingcdn%2Evideo" +
                "%2Eqq%2Ecom%3A80%2F124221102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System
                .currentTimeMillis() / 1000 + "0" +
                "%26cdn%3Dbsycdn%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&P2PVer=0");
        kvCommon("loadingTime=5832&peerCount=0&playNo=51A72BA111C91C7DD154467786CBC11EA9479CCA&blockCount=0" +
                "&averPeerMeHealth=0&progid=124221102&blockTime=0&time=" + System.currentTimeMillis() + "&StartP2P=0&errorCode=10000" +
                "&SuperNodeIP=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg" +
                "&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&SuperNodePort=0&prdLength=35&PeerServerIP=0&pla=1" +
                "&downSpeed=43&PeerServerPort=0&app=live&maxSpeed=259&cmd=205&flashver=WIN%2027%2E0%2E0%2E130&cnnTime" +
                "=13391&viewid=&ReqSNBlockOutRange=0&fplayerver=30201000&reCnnCount=0&HashNotFinished=0&blockHasData" +
                "=0&returnBitmapErr=0&CDNAbnormal=0&playerOnPlayTime=21458&cnnPS=0&type=17&transtype=0&adstat=4" +
                "&lookback=0&HttpDownlandSpeed=0&fullScreen=0&lookbackseq=0&HttpDownSum=0&str%5Fparam1=bsycdn&seq=0" +
                "&UDPDownlandSpeed=0&durl=http%3A%2F%2Fqingcdn%2Evideo%2Eqq%2Ecom%3A80%2F124221102%2Eflv%3Fcdncode%3D" +
                "%252f18907E7BE0798990%252f%26time%3D" + System
                .currentTimeMillis() / 1000 + "%26cdn%3Dbsycdn%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                "%26scheduleflag%3D1%26buname" +
                "%3Dqqlive%26vkey%3D4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&videopos=0&UDPDownSum=0&dsip=qingcdn%2Evideo%2Eqq%2Ecom&str%5Fparam2=qingcdn%2Evideo%2Eqq%2Ecom&fullecode=10000&UpdataSpeed=0&cdn=bsycdn&switch=0&iQQ=125826029&UDPUpSum=0&sIp=&ispay=0&sBiz=zhibo&playtime=0&isuserpay=0&sOp=webflash&PeerConnRate=0&live%5Ftype=8&iSta=0&clientip=&svrCount=0&iTy=1991&xserverip=&p2pCount=0&RtmfpInfo=0&playAd=0&P2PReDelay=0&sRef=&livepid=38981&SuNodDelay=0&iFlow=0&P2PVer=0&averRemtime=0");

        live_poll();
        kvCommon("val2=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&ver=TencentPlayerLiveV3%2E2%2E1%2E00&bid=pcvideo&iSta=7&str1=&iTy=2052&vid=124221102&rnd=1296&str2=1%2E4%2E6&int2=0&int1=0&str4=51A72BA111C91C7DD154467786CBC11EA9479CCA&itype=52&val=100&str3=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dyxzg&sRef=&sPageId=&sPos=&step=3&val=82&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=A03E95D1B9A50856D3D4215C67D7BA1457A7AC5E&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA&vid=124221102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124221102%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D51A72BA111C91C7DD154467786CBC11EA9479CCA%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2912");
        kvCommon("val2=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dyxzg&ver=TencentPlayerLiveV3%2E2%2E1%2E00&bid=pcvideo&iSta=7&str1=&iTy=2052&vid=124221102&rnd=5797&str2=1%2E4%2E6&int2=1&int1=0&str4=51A72BA111C91C7DD154467786CBC11EA9479CCA&itype=52&val=100&str3=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dyxzg&sRef=&sPageId=&sPos=&step=3&val=217&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=A03E95D1B9A50856D3D4215C67D7BA1457A7AC5E&pid=51A72BA111C91C7DD154467786CBC11EA9479CCA&vid=124221102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124221102%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D51A72BA111C91C7DD154467786CBC11EA9479CCA%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9234");
        kvCommon("cnlID=124221102&BossId=3460&vkey" +
                "=4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&ftime=" + System.currentTimeMillis() + "&Pwd=779660211&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&platform=1");
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
        headers1.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; ts_uid=5427588366; RK=kdcDDga/NR; ptui_loginuin=125826029; ptcz=0a79d301c27baffa50c9bdc396001dc73a3910c1f14938be7cf35b204484d8de; pt2gguin=o0125826029; tvfe_boss_uuid=f3d0446c9b5f52ed; pgv_pvid=461588912; o_cookie=125826029");
        headers1.put("Host", "tga.qq.com");
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void forEachRequest(int seq) {
        try {
            live_poll();
            sleep();
            kvCommon("cnlID=124221102&BossId=3460&vkey" +
                    "=4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&ftime=" + System.currentTimeMillis() + "&Pwd=779660211&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&platform=1");
            sleep();
            kvCommon("loadingTime=0&peerCount=0&playNo=51A72BA111C91C7DD154467786CBC11EA9479CCA&blockCount=0" +
                    "&averPeerMeHealth=0&progid=124221102&blockTime=0&time=" + System.currentTimeMillis() + "&StartP2P=0&errorCode=10000" +
                    "&SuperNodeIP=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame" +
                    "%3Dyxzg&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&SuperNodePort=0&prdLength=60&PeerServerIP" +
                    "=0&pla=1&downSpeed=226&PeerServerPort=0&app=live&maxSpeed=0&cmd=263&flashver=WIN%2027%2E0%2E0" +
                    "%2E130&cnnTime=0&viewid=&ReqSNBlockOutRange=0&fplayerver=30201000&reCnnCount=0&HashNotFinished=0" +
                    "&blockHasData=0&returnBitmapErr=0&CDNAbnormal=0&playerOnPlayTime=0&cnnPS=0&type=17&transtype=0" +
                    "&adstat=4&lookback=0&HttpDownlandSpeed=0&fullScreen=0&lookbackseq=0&HttpDownSum=0&str%5Fparam1" +
                    "=bsycdn&seq=1&UDPDownlandSpeed=0&durl=http%3A%2F%2Fqingcdn%2Evideo%2Eqq%2Ecom%3A80%2F124221102" +
                    "%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis()
                    / 1000 + "%26cdn%3Dbsycdn%26sdtfrom" +
                    "%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&cdn=bsycdn&UDPDownSum=0&dsip=qingcdn%2Evideo%2Eqq%2Ecom&str%5Fparam2=qingcdn%2Evideo%2Eqq%2Ecom&fullecode=10000&UpdataSpeed=0&videopos=0&playtime=0&iQQ=125826029&UDPUpSum=0&sIp=&ispay=0&sBiz=zhibo&switch=0&isuserpay=0&sOp=webflash&PeerConnRate=0&live%5Ftype=8&iSta=0&clientip=&svrCount=0&iTy=1991&xserverip=&p2pCount=0&RtmfpInfo=0&playAd=0&P2PReDelay=0&sRef=&livepid=38981&SuNodDelay=0&iFlow=0&P2PVer=0&averRemtime=0");
            sleep();
            live_poll();
            sleep();
            kvCommon("cnlID=124221102&BossId=3460&vkey" +
                    "=4DFBE70E6DF57C5E6F0D2A76E5AC4505E6646FC7681742600860C7725C4F0414C74006C16C2CF097CFE8BA01E359F437FC7FBC5582EAA1F279E583DCA1BBE26EB6D2602AA7ADF143E4A2B6949B67F332C0027C35F4D9FC77&ftime=" + System.currentTimeMillis() + "&Pwd=779660211&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&platform=1");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; RK=kdcDDga/NR; ptui_loginuin=125826029; ptcz=0a79d301c27baffa50c9bdc396001dc73a3910c1f14938be7cf35b204484d8de; pt2gguin=o0125826029; tvfe_boss_uuid=f3d0446c9b5f52ed; pgv_info=ssid=s7433372534; pgv_pvid=461588912; o_cookie=125826029");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; RK=kdcDDga/NR; ptui_loginuin=125826029; ptcz=0a79d301c27baffa50c9bdc396001dc73a3910c1f14938be7cf35b204484d8de; pt2gguin=o0125826029; tvfe_boss_uuid=f3d0446c9b5f52ed; pgv_info=ssid=s7433372534; pgv_pvid=461588912; o_cookie=125826029");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; RK=kdcDDga/NR; ptui_loginuin=125826029; ptcz=0a79d301c27baffa50c9bdc396001dc73a3910c1f14938be7cf35b204484d8de; pt2gguin=o0125826029; tvfe_boss_uuid=f3d0446c9b5f52ed; pgv_info=ssid=s7433372534; pgv_pvid=461588912; o_cookie=125826029");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&needmark=1&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&qqlog=&pollDataKey=pid%3D38981%26type%3D&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dyxzg&apptype=live";
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
            conn.addRequestProperty("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; RK=kdcDDga/NR; ptui_loginuin=125826029; ptcz=0a79d301c27baffa50c9bdc396001dc73a3910c1f14938be7cf35b204484d8de; pt2gguin=o0125826029; tvfe_boss_uuid=f3d0446c9b5f52ed; pgv_info=ssid=s7433372534; pgv_pvid=461588912; o_cookie=125826029");
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



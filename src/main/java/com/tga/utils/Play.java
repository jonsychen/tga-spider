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
        kvCommon("CheckSum=105821293&flashver=WIN&iQQ=0&P2PVer=&progid=124208802&sRef=&dc=569&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&BossId=2583");
        kvCommon("sid=124208802&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dwzry&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30201000&iTy=3007&p2pver=0&val=0&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=3&pid=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vurl=&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&rnd=1464&str1=&ver=TencentPlayerLiveV3%2E2%2E1%2E00&int2=0&str3=&itype=50&iSta=7&iTy=2052&str2=1%2E4%2E6&val2=&bid=pcvideo&val=100&int1=0&str4=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=166&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=3CB3539E6BF77EE4782693787DA232E7DD55BC4A&pid=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124208802%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26st%3D0&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1417");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&rnd=1285&str1=&ver=TencentPlayerLiveV3%2E2%2E1%2E00&int2=1&str3=&itype=50&iSta=7&iTy=2052&str2=1%2E4%2E6&val2=&bid=pcvideo&val=100&int1=0&str4=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=383&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=3CB3539E6BF77EE4782693787DA232E7DD55BC4A&pid=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124208802%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0%26retry%3D1&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2321");
        kvCommon("sid=124208802&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dwzry&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30201000&iTy=3007&p2pver=0&val=617&ptag" +
                "=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=4&pid" +
                "=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vurl=http%3A%2F%2F117%2E169%2E85%2E25%3A8080" +
                "%2FC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C%2F124208802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        kvCommon("cnl=124208802&ftime=" + System.currentTimeMillis() + "&vky" +
                "=C6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&gid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&dip=zijian&sdt=70202&uin=0&cip=&cts=" + System.currentTimeMillis() / 1000 + "&cky=bniliSn%2DCSMGa1N9CMxu99mxavGxXdbY6K5jazeM0nFtyTjCxREa7GxwgHK409gVBDVc7LRuDy7p5Z%2DKC7mZAUYVbUChaRv%5F0SXNW%2D8ieCFf8%2DBs%2DMZso3t%2DowNDe4%2D6%5Fklrt%2DaNE%5Fs9%2DAj1gxi2wg2Xs3Xe3ezhA3LOFWQD06o66hdWMQWK4FzBuGqr0ulAbK9j0b8ucp3W2mIj2XsubQnl8cpielEjxI3RrnwCHoHosjTGx95I9jdbLrE%5FFXvKAD82U7TJz4PwNvXzlPfft9T2UC4bxWFl0jz3EmRsGslwkPHtJIuNOX9EP4BzcpUXPAdGyw&plt=1&evr=5%2E4&iTy=2595&avr=TencentPlayerLiveV3%2E2%2E1%2E00");
        kvCommon("sid=124208802&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dwzry&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30201000&iTy=3007&p2pver=0&val=331&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=1100&pid=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Flivequeue%3D1%26rid%3D9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC%26defauto%3D1%26defn%3D%26rnd%3D470%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Dwzry%26cnlid%3D124208802%26system%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E1%2E00%26sdtfrom%3D70202%26stream%3D2%26browser%3Dchrome%26vip%5Fstatus%3D0%26cmd%3D2%26txvjsv%3D2%26queueStatus%3D0%26cKey%3DbniliSn%2DCSMGa1N9CMxu99mxavGxXdbY6K5jazeM0nFtyTjCxREa7GxwgHK409gVBDVc7LRuDy7p5Z%2DKC7mZAUYVbUChaRv%5F0SXNW%2D8ieCFf8%2DBs%2DMZso3t%2DowNDe4%2D6%5Fklrt%2DaNE%5Fs9%2DAj1gxi2wg2Xs3Xe3ezhA3LOFWQD06o66hdWMQWK4FzBuGqr0ulAbK9j0b8ucp3W2mIj2XsubQnl8cpielEjxI3RrnwCHoHosjTGx95I9jdbLrE%5FFXvKAD82U7TJz4PwNvXzlPfft9T2UC4bxWFl0jz3EmRsGslwkPHtJIuNOX9EP4BzcpUXPAdGyw%26fntick%3D0%26encryptVer%3D5%2E4%26flashver%3D26%2C0%2C0%2C151%26guid%3D3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B%26pla%3D0%26flvtype%3D1&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        kvCommon("cnlID=124208802&ftime=" + System.currentTimeMillis() + "&Pwd=779660211&platform=1&guid" +
                "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&vkey=C6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&BossId=3460");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;
        try {
        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("sid=124208802&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dwzry&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30201000&iTy=3007&p2pver=0&val=1306&ptag" +
                "=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=6&pid" +
                "=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vurl=http%3A%2F%2F117%2E169%2E85%2E25%3A8080" +
                "%2FC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C%2F124208802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        kvCommon("SuperNodePort=0&errorCode=10000&prdLength=4&PeerServerIP=0&downSpeed=262&PeerServerPort=0&app=live" +
                "&SuperNodeIP=0&maxSpeed=2613&CDNAbnormal=0&flashver=WIN%2026%2E0%2E0%2E151&cnnTime=855" +
                "&ReqSNBlockOutRange=0&fplayerver=30201000&cmd=205&HashNotFinished=0&blockHasData=0&returnBitmapErr=0" +
                "&reCnnCount=0&playerOnPlayTime=1963&cnnPS=0&transtype=0&adstat=4&lookback=0&HttpDownlandSpeed=0&dsip" +
                "=117%2E169%2E85%2E25&fullScreen=0&str%5Fparam1=zijian&seq=0&UDPDownlandSpeed=0&lookbackseq=0&durl" +
                "=http%3A%2F%2F117%2E169%2E85%2E25%3A8080" +
                "%2FC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C%2F124208802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&videopos=0&UDPDownSum=0&cdn=zijian&type=17&sIp=&switch=0&playtime=0&iQQ=0&UDPUpSum=0&ispay=0&sBiz=zhibo&RtmfpInfo=0&isuserpay=0&sOp=webflash&str%5Fparam2=117%2E169%2E85%2E25&PeerConnRate=0&live%5Ftype=8&iSta=0&clientip=&svrCount=0&playAd=0&xserverip=&p2pCount=0&UpdataSpeed=0&iFlow=0&viewid=&P2PReDelay=0&iTy=1991&sRef=&playNo=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&HttpDownSum=0&P2PVer=0&progid=124208802&averRemtime=0&SuNodDelay=0&livepid=23418&peerCount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&averPeerMeHealth=0&time=" + System.currentTimeMillis() + "&blockTime=0&StartP2P=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&pla=1&loadingTime=451&fullecode=10000");
        live_poll();
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&rnd=1120&str1=&ver=TencentPlayerLiveV3%2E2%2E1%2E00&int2=0&str3=&itype=52&iSta=7&iTy=2052&str2=1%2E4%2E6&val2=&bid=pcvideo&val=100&int1=0&str4=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=346&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=ECBE4FD5732305A4D4BC65DD3E343CAF90255BA8&pid=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124208802%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1571");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&rnd=4764&str1=&ver=TencentPlayerLiveV3%2E2%2E1%2E00&int2=1&str3=&itype=52&iSta=7&iTy=2052&str2=1%2E4%2E6&val2=&bid=pcvideo&val=100&int1=0&str4=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=60&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=ECBE4FD5732305A4D4BC65DD3E343CAF90255BA8&pid=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124208802%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1395");
       
            for (int i = 1; i < videoTime; i++) {
                forEachRequest(i);
            }
        } catch (Exception e) {

        }finally{
        	
            //关闭下载线程
            if (stream != null) {
            	stream.interrupt();
                stream.stop();
                
            }
        	
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
        headers1.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s7982752500; ts_last=tga.qq.com/match/2017/pc_game.html; pgv_pvid=461588912; ts_uid=5427588366");
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
            kvCommon("cnlID=124208802&ftime=" + System.currentTimeMillis() + "&Pwd=779660211&platform=1&guid" +
                    "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&vkey=C6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&BossId=3460");
            sleep();
            kvCommon("SuperNodePort=0&errorCode=10000&prdLength=60&PeerServerIP=0&downSpeed=222&PeerServerPort=0&app" +
                    "=live&SuperNodeIP=0&maxSpeed=0&CDNAbnormal=0&flashver=WIN%2026%2E0%2E0%2E151&cnnTime=0" +
                    "&ReqSNBlockOutRange=0&fplayerver=30201000&cmd=263&HashNotFinished=0&blockHasData=0" +
                    "&returnBitmapErr=0&reCnnCount=0&type=17&cnnPS=0&transtype=0&adstat=4&lookback=0" +
                    "&HttpDownlandSpeed=0&dsip=117%2E169%2E85%2E25&fullScreen=0&str%5Fparam1=zijian&seq=1" +
                    "&UDPDownlandSpeed=0&lookbackseq=0&durl=http%3A%2F%2F117%2E169%2E85%2E25%3A8080" +
                    "%2FC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C%2F124208802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DC6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&videopos=0&UDPDownSum=0&cdn=zijian&playerOnPlayTime=0&sIp=&switch=0&playtime=0&iQQ=0&UDPUpSum=0&ispay=0&sBiz=zhibo&RtmfpInfo=0&isuserpay=0&sOp=webflash&str%5Fparam2=117%2E169%2E85%2E25&PeerConnRate=0&live%5Ftype=8&iSta=0&clientip=&svrCount=0&playAd=0&xserverip=&p2pCount=0&UpdataSpeed=0&iFlow=0&viewid=&P2PReDelay=0&iTy=1991&sRef=&playNo=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&HttpDownSum=0&P2PVer=0&progid=124208802&averRemtime=0&SuNodDelay=0&livepid=23418&peerCount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwz");
            sleep();
            live_poll();
            sleep();
            kvCommon("cnlID=124208802&ftime=" + System.currentTimeMillis() + "&Pwd=779660211&platform=1&guid" +
                    "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&vkey=C6804DC439E2CCA4F43A29F317B11805F72B425E987F6583105D0F009B9A39F06D73AF0842D8B3369D343C7B6A4955CE2BC13BA8C5DE8E4260A9C2D20EB60C333D6999297AAD3569B36BC8650061E8D9A176976FC218933C&BossId=3460");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s7982752500; pgv_pvid=461588912");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s7982752500; pgv_pvid=461588912");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s7982752500; pgv_pvid=461588912");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&qqlog=&pollDataKey=pid%3D23418%26type%3D&needmark=1&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dwzry&apptype=live";
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



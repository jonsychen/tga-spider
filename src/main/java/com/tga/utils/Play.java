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
        kvGetCommon("http://trace.qq.com/collect?pj=1990&dm=tga.qq.com&url=/match/2017/pc_game.html&arg=game%3Ddn&rdm=&rurl=&rarg=&icache=&uv=&nu=&ol=&loc=http%3A//tga.qq.com/match/2017/pc_game.html%3Fgame%3Ddn&column=&subject=&nrnd=F672048110&rnd=50270");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&progid=124222002&P2PVer=&flashver=WIN&sRef=&BossId=2583&dc=1189&CheckSum=105821293&iQQ=0");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&iTy=3007&sref=http" +
                "%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&tpay=0&ptag=&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&P2PVer=0&val=0&p2pver=0&iQQ=0&BossId" +
                "=3007&adid=&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&Pwd=881273072&sid=124222002&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vurl=&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0" +
                "%2E170&sdtfrom=70202&val2=0&step=3&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&fplayerver=30202003");
        kvCommon("rnd=9598&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&bid=pcvideo&vid=124222002&itype=50&str2=1%2E4%2E6&int1=0&int2=0&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str4=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&val2=&iTy=2052&val=100&str3=&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddn&sRef=&sPageId=&sPos=&step=3&val=54&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=3F56F738ED5E8F045433FF225C828D2982231741&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&vid=124222002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0" +
                "%26vid%3D124222002%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03" +
                "%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D6F907AAAED5F2E8E9E5EE18A3B6047668188628C%26adaptor" +
                "%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1958");
        kvCommon("rnd=4000&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&bid=pcvideo&vid=124222002&itype=50&str2=1%2E4%2E6&int1=0&int2=1&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str4=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&val2=&iTy=2052&val=100&str3=&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddn&sRef=&sPageId=&sPos=&step=3&val=18&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=3F56F738ED5E8F045433FF225C828D2982231741&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&vid=124222002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0" +
                "%26vid%3D124222002%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03" +
                "%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D6F907AAAED5F2E8E9E5EE18A3B6047668188628C%26adaptor" +
                "%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=8854");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddn&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid" +
                "=3F56F738ED5E8F045433FF225C828D2982231741&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&vid=124222002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6047");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&iTy=3007&sref=http" +
                "%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&tpay=0&ptag=&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&P2PVer=0&val=0&p2pver=0&iQQ=0&BossId" +
                "=3007&adid=&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&Pwd=881273072&sid=124222002&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vurl=&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0" +
                "%2E170&sdtfrom=70202&val2=0&step=7&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&fplayerver=30202003");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2590&iFlow=0&sUrl=&sRef=&sPageId=&sPos=&step=0&val=blocked&val1=&val2=&val3=&val4=&val5=&apid=1.4.6&pid=1.4.6&vid=124222002&platform=6&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=&adtype=0&vurl=http://tga.qq.com/match/2017/pc_game.html?game=dn&reporttime=&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3405");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&iTy=3007&sref=http" +
                "%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&tpay=0&ptag=&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&P2PVer=0&val=393&p2pver=0&iQQ=0" +
                "&BossId=3007&adid=&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&Pwd=881273072&sid=124222002&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vurl=http%3A%2F%2Fqingcdn%2Evideo%2Eqq%2Ecom%3A80" +
                "%2F124222002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()
                /1000+"%26cdn%3Dbsycdn" +
                "%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey" +
                "%3DDBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E170&sdtfrom=70202&val2=0&step=4&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&fplayerver=30202003");
        kvCommon("cts="+System.currentTimeMillis()
                /1000+"&cip=&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&dip=bsycdn&cky" +
                "=XKfCQRsgbusGa1N9CMxu99mxavGxXdbY6K5jazeM0nH1BTCI30enGyjpSAsY1m2vl2NYa6tVJasXz8mjqE" +
                "%2DbhUx5saTuAygSkedvHnRB1sNsBTwCHS8mOBDGTOcWknspLY7AkN13fyS499O%2DipZrQJ3i" +
                "%2DbLLGFggWpys3Rvvbw4cxg0y4byjnHP7xncLBecSoQI4UzL0Wjas8lZfc1LTn0PTMfA" +
                "%2DgF8APLGJrI9hGv9oIUCp5uG10vcAEmCXGlmErmfKa37GWbM9iTqTCwnCDVtJYM6LecuQNvoSWnFQDlY01fofwv6k3gWH8ZmG3f7baMtAYQ&sdt=70202&cnl=124222002&ftime="+System.currentTimeMillis()+"&vky=DBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&evr=5%2E4&uin=0&iTy=2595&avr=TencentPlayerLiveV3%2E2%2E2%2E03&plt=1");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&iTy=3007&sref=http" +
                "%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&tpay=0&ptag=&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&P2PVer=0&val=253&p2pver=0&iQQ=0" +
                "&BossId=3007&adid=&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&Pwd=881273072&sid=124222002&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3FappVer" +
                "%3DTencentPlayerLiveV3%2E2%2E2%2E03%26rnd%3D889%26queueStatus%3D0%26pla%3D0%26cmd%3D2%26rid" +
                "%3D6F907AAAED5F2E8E9E5EE18A3B6047668188628C%26browser%3Dchrome%26system%3D3%26txvjsv%3D2%26livequeue" +
                "%3D1%26flvtype%3D1%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26flashver%3D27%2C0%2C0%2C170" +
                "%26sdtfrom%3D70202%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame" +
                "%2Ehtml%253Fgame%253Ddn%26cKey" +
                "%3DXKfCQRsgbusGa1N9CMxu99mxavGxXdbY6K5jazeM0nH1BTCI30enGyjpSAsY1m2vl2NYa6tVJasXz8mjqE" +
                "%2DbhUx5saTuAygSkedvHnRB1sNsBTwCHS8mOBDGTOcWknspLY7AkN13fyS499O%2DipZrQJ3i" +
                "%2DbLLGFggWpys3Rvvbw4cxg0y4byjnHP7xncLBecSoQI4UzL0Wjas8lZfc1LTn0PTMfA" +
                "%2DgF8APLGJrI9hGv9oIUCp5uG10vcAEmCXGlmErmfKa37GWbM9iTqTCwnCDVtJYM6LecuQNvoSWnFQDlY01fofwv6k3gWH8ZmG3f7baMtAYQ%26stream%3D2%26defauto%3D1%26vip%5Fstatus%3D0%26fntick%3D0%26encryptVer%3D5%2E4%26defn%3D%26cnlid%3D124222002&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E170&sdtfrom=70202&val2=0&step=1100&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&fplayerver=30202003");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("BossId=3460&cnlID=124222002&ftime="+ System.currentTimeMillis()+"&Pwd=779660211&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vkey=DBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&platform=1");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&iTy=3007&sref=http" +
                "%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&tpay=0&ptag=&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&P2PVer=0&val=868&p2pver=0&iQQ=0" +
                "&BossId=3007&adid=&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&Pwd=881273072&sid=124222002&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vurl=http%3A%2F%2Fqingcdn%2Evideo%2Eqq%2Ecom%3A80" +
                "%2F124222002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()
                /1000+"%26cdn%3Dbsycdn" +
                "%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey" +
                "%3DDBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E170&sdtfrom=70202&val2=0&step=6&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&fplayerver=30202003");
        kvCommon("cdn=bsycdn&cnnTime=470&cmd=205&HashNotFinished=0&reCnnCount=0&iTy=1991&playNo" +
                "=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&HttpDownlandSpeed=0&blockHasData=0&iFlow=0&progid" +
                "=124222002&P2PVer=0&playerOnPlayTime=1281&time="+System.currentTimeMillis()+"&cnnPS=0&loadingTime=398&fullScreen=0" +
                "&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&seq=0&HttpDownSum" +
                "=0&PeerServerIP=0&pla=1&playAd=0&downSpeed=810&videopos=0&playtime=0&adstat=0&UDPDownlandSpeed=0" +
                "&lookback=0&app=live&ispay=0&StartP2P=0&UDPDownSum=0&maxSpeed=3539&isuserpay=0&str%5Fparam1=bsycdn" +
                "&type=17&livepid=40573&PeerConnRate=0&UpdataSpeed=0&blockCount=0&errorCode=10000&svrCount=0" +
                "&SuperNodePort=0&durl=http%3A%2F%2Fqingcdn%2Evideo%2Eqq%2Ecom%3A80%2F124222002%2Eflv%3Fcdncode%3D" +
                "%252f18907E7BE0798990%252f%26time%3D"+System
                .currentTimeMillis()/1000+"%26cdn%3Dbsycdn%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                "%26scheduleflag%3D1%26buname" +
                "%3Dqqlive%26vkey%3DDBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&fullecode=10000&p2pCount=0&RtmfpInfo=0&str%5Fparam2=qingcdn%2Evideo%2Eqq%2Ecom&UDPUpSum=0&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ReqSNBlockOutRange=0&xserverip=&live%5Ftype=8&sIp=&sOp=webflash&transtype=0&blockTime=0&averRemtime=0&sBiz=zhibo&SuNodDelay=0&iQQ=0&SuperNodeIP=0&prdLength=2&iSta=0&switch=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E170&PeerServerPort=0&averPeerMeHealth=0&returnBitmapErr=0&dsip=qingcdn%2Evideo%2Eqq%2Ecom&viewid=&fplayerver=30202003");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddn&sRef=&sPageId=&sPos=&step=7&val=30000&val1=5&val2=&val3=&val4=&val5=&apid" +
                "=3F56F738ED5E8F045433FF225C828D2982231741&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&vid=124222002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=30000&bt=30000&idx=0&appid=0&ua" +
                "=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1607");
        live_poll();
        kvCommon("BossId=3460&cnlID=124222002&ftime="+System.currentTimeMillis()+"&Pwd=779660211&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vkey=DBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&platform=1");
        kvCommon("rnd=4565&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&bid=pcvideo&vid=124222002&itype=52&str2=1%2E4%2E6&int1=0&int2=0&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str4=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&val2=&iTy=2052&val=100&str3=&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddn&sRef=&sPageId=&sPos=&step=3&val=21&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=D578364B076EA22353FC3EBAF3CAC3288465DB47&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&vid=124222002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3D6F907AAAED5F2E8E9E5EE18A3B6047668188628C%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=8221");
        kvCommon("rnd=6873&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&bid=pcvideo&vid=124222002&itype=52&str2=1%2E4%2E6&int1=0&int2=1&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str4=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&val2=&iTy=2052&val=100&str3=&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddn&sRef=&sPageId=&sPos=&step=3&val=16&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=D578364B076EA22353FC3EBAF3CAC3288465DB47&pid=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&vid=124222002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3D6F907AAAED5F2E8E9E5EE18A3B6047668188628C%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=8963");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; pgv_info=ssid=s5215588912; ts_last=tga.qq.com/match/2017/pc_game.html; pgv_pvid=672048110; ts_uid=9440516329");
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
            kvCommon("cdn=bsycdn&time="+System.currentTimeMillis()+"&cmd=263&HashNotFinished=0&reCnnCount=0&iTy=1991&playNo" +
                    "=6F907AAAED5F2E8E9E5EE18A3B6047668188628C&HttpDownlandSpeed=0&blockHasData=0&iFlow=0&progid" +
                    "=124222002&P2PVer=0&playerOnPlayTime=0&cnnTime=0&cnnPS=0&loadingTime=0&fullScreen=0&progUrl=http" +
                    "%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddn&seq=1&HttpDownSum=0" +
                    "&PeerServerIP=0&pla=1&playAd=0&downSpeed=564&videopos=0&playtime=0&UpdataSpeed=0" +
                    "&UDPDownlandSpeed=0&lookback=0&app=live&ispay=0&StartP2P=0&UDPDownSum=0&adstat=4&isuserpay=0&str" +
                    "%5Fparam1=bsycdn&UDPUpSum=0&livepid=40573&PeerConnRate=0&maxSpeed=0&blockCount=0&errorCode=10000" +
                    "&svrCount=0&SuperNodePort=0&durl=http%3A%2F%2Fqingcdn%2Evideo%2Eqq%2Ecom%3A80%2F124222002%2Eflv" +
                    "%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System
                    .currentTimeMillis()/1000+"%26cdn%3Dbsycdn%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                    "%26scheduleflag%3D1" +
                    "%26buname%3Dqqlive%26vkey%3DDBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&fullecode=10000&p2pCount=0&RtmfpInfo=0&str%5Fparam2=qingcdn%2Evideo%2Eqq%2Ecom&type=17&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ReqSNBlockOutRange=0&xserverip=&live%5Ftype=8&sIp=&sOp=webflash&transtype=0&blockTime=0&averRemtime=0&sBiz=zhibo&SuNodDelay=0&iQQ=0&SuperNodeIP=0&prdLength=31&iSta=0&switch=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E170&PeerServerPort=0&averPeerMeHealth=0&returnBitmapErr=0&dsip=qingcdn%2Evideo%2Eqq%2Ecom&viewid=&fplayerver=30202003");
            sleep();
            kvCommon("BossId=3460&cnlID=124222002&ftime="+System.currentTimeMillis()+"&Pwd=779660211&guid" +
                    "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vkey=DBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&platform=1");
            sleep();
            live_poll();
            sleep();
            kvCommon("BossId=3460&cnlID=124222002&ftime="+System.currentTimeMillis()+"&Pwd=779660211&guid" +
                    "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vkey=DBFED734078A7F66D189381DCB69A108701E0E54EB3376FFCE41B60BEEAAABBE8DEFD26EAD7C7DCD8DE64BAB20078CE7EC68A093EC5509382C6D6100D031C99D002A558F2AA859F98961EDEECC6E3D48CA8A42E345481C5C&platform=1");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; pgv_info=ssid=s5215588912; pgv_pvid=672048110");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; pgv_info=ssid=s5215588912; pgv_pvid=672048110");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; pgv_info=ssid=s5215588912; pgv_pvid=672048110");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&needmark=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&qqlog=&pollDataKey=pid%3D40573%26type%3D&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            conn.addRequestProperty("Cookie","eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; pgv_info=ssid=s5215588912; pgv_pvid=672048110");
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



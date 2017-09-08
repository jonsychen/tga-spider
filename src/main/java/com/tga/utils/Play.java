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
        kvCommon("flashver=WIN&iQQ=0&dc=8447&P2PVer=&progid=124209001&sRef=&CheckSum=105821293&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&BossId=2583");
        kvCommon("sid=124209001&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dlol&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&fplayerver=30201000&iTy=3007&p2pver=0&val=0&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&step=3&pid=40A69A3E214B35258876B5DA01B5FADC3702ED76&vurl=&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&iSta=7&str3=&str1=&int2=0&ver=TencentPlayerLiveV3%2E2%2E1%2E00&rnd=7297&bid=pcvideo&itype=50&str4=40A69A3E214B35258876B5DA01B5FADC3702ED76&vid=124209001&iTy=2052&val2=&str2=1%2E4%2E6&val=100&int1=0");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dlol&sRef=&sPageId=&sPos=&step=3&val=515&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=6E39B1FDCF9B7E00A6941E1594A2B719D667C784&pid=40A69A3E214B35258876B5DA01B5FADC3702ED76&vid=124209001" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124209001%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D40A69A3E214B35258876B5DA01B5FADC3702ED76%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5923");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&iSta=7&str3=&str1=&int2=1&ver=TencentPlayerLiveV3%2E2%2E1%2E00&rnd=5829&bid=pcvideo&itype=50&str4=40A69A3E214B35258876B5DA01B5FADC3702ED76&vid=124209001&iTy=2052&val2=&str2=1%2E4%2E6&val=100&int1=0");
        kvCommon("sid=124209001&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dlol&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dlol&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" +
                "%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&fplayerver=30201000&iTy=3007&p2pver=0&val=1296&ptag=&tpay=0" +
                "&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&step=4&pid" +
                "=40A69A3E214B35258876B5DA01B5FADC3702ED76&vurl=http%3A%2F%2F163%2E177%2E76%2E106%3A8080" +
                "%2F617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE%2F124209001%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        kvCommon("sid=124217202&adid=&iQQ=0&val2=0&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame" +
                "%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame" +
                "%2Ehtml%3Fgame%3Dhyrz&p2pver=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Dhyrz&fplayerver=30201000&iTy=3007&flashver=WIN%2026%2E0%2E0%2E151&val=1083754&ptag=&tpay=0" +
                "&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=5&pid" +
                "=701A364B29C7878FED5532859A5639837D24C34B&vurl=http%3A%2F%2F117%2E169%2E85%2E19%3A8080" +
                "%2FB4417B1F73952BCC6165BF771BCB38C8E966EB7069726580E79F734B1041A7DC8E84C1D0029F53B182042BEC30295508A818CCCAEE85AE45FF0838820D91FD38AFA796895994DD96045B740C22704CC6BFA2B037A080FF1D%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB4417B1F73952BCC6165BF771BCB38C8E966EB7069726580E79F734B1041A7DC8E84C1D0029F53B182042BEC30295508A818CCCAEE85AE45FF0838820D91FD38AFA796895994DD96045B740C22704CC6BFA2B037A080FF1D&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&ctime=" + cTimeStr());
        kvCommon("sid=124217202&adid=&iQQ=0&val2=0&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame" +
                "%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame" +
                "%2Ehtml%3Fgame%3Dhyrz&p2pver=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Dhyrz&fplayerver=30201000&iTy=3007&flashver=WIN%2026%2E0%2E0%2E151&val=2397710&ptag=&tpay=0" +
                "&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=5&pid" +
                "=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&vurl=http%3A%2F%2F117%2E169%2E85%2E19%3A8080" +
                "%2F351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&ctime=" + cTimeStr());
        kvCommon
                ("vky=617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&cky=TCvnbQusS8cGa1N9CMxu99mxavGxXdbY6K5jazeM0nFv7F%5FZRmcwLdOfYhte%2DmsJXACH5w1AijuX0Tsn0R5sDxjVTlCSV%2DabIkepag0IsRXdPRGh4jdA8H6QOfMd70k1ONRdszlMdj5L73Ari79TFsEay8IZ9lI2bMY%5F36POohluRLzZDidQXT9%2D%5FBp%2DvmTnrKhVyeVvlSTUE3knpwmrAX744LYQ58xdQre3cD7p679pvW8RU2qkyTjWC29zzJhZcfEIR8F883uAP0VSvMDD%5FtPgRHXg33RM6xD4Dl0xdushdofqBl4IYYoHbMU%2DSW0UF%5FoYtQ&cnl=124209001&ftime=" + System.currentTimeMillis() + "&uin=0&evr=5%2E4&plt=1&cts=" + System.currentTimeMillis() / 1000 + "&cip=112%2E97%2E59%2E57&iTy=2595&avr=TencentPlayerLiveV3%2E2%2E1%2E00&gid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&dip=zijian&sdt=70202");
        kvCommon("sid=124209001&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dlol&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&fplayerver=30201000&iTy=3007&p2pver=0&val=353&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&step=1100&pid=40A69A3E214B35258876B5DA01B5FADC3702ED76&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Flivequeue%3D1%26rid%3D40A69A3E214B35258876B5DA01B5FADC3702ED76%26flvtype%3D1%26defn%3D%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Dlol%26cnlid%3D124209001%26system%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E1%2E00%26guid%3D3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B%26cKey%3DTCvnbQusS8cGa1N9CMxu99mxavGxXdbY6K5jazeM0nFv7F%5FZRmcwLdOfYhte%2DmsJXACH5w1AijuX0Tsn0R5sDxjVTlCSV%2DabIkepag0IsRXdPRGh4jdA8H6QOfMd70k1ONRdszlMdj5L73Ari79TFsEay8IZ9lI2bMY%5F36POohluRLzZDidQXT9%2D%5FBp%2DvmTnrKhVyeVvlSTUE3knpwmrAX744LYQ58xdQre3cD7p679pvW8RU2qkyTjWC29zzJhZcfEIR8F883uAP0VSvMDD%5FtPgRHXg33RM6xD4Dl0xdushdofqBl4IYYoHbMU%2DSW0UF%5FoYtQ%26browser%3Dchrome%26vip%5Fstatus%3D0%26cmd%3D2%26flashver%3D26%2C0%2C0%2C151%26queueStatus%3D0%26sdtfrom%3D70202%26defauto%3D1%26fntick%3D0%26encryptVer%3D5%2E4%26rnd%3D78%26pla%3D0%26txvjsv%3D2%26stream%3D2&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("cnlID=124209001&Pwd=779660211&platform=1&ftime=" + cTimeStr() + "&guid" +
                "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&vkey=617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&BossId=3460");
        kvCommon("sid=124209001&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dlol&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dlol&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" +
                "%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&fplayerver=30201000&iTy=3007&p2pver=0&val=1918&ptag=&tpay=0" +
                "&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&step=6&pid" +
                "=40A69A3E214B35258876B5DA01B5FADC3702ED76&vurl=http%3A%2F%2F163%2E177%2E76%2E106%3A8080" +
                "%2F617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE%2F124209001%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        kvCommon("SuperNodePort=0&errorCode=10000&prdLength=7&PeerServerIP=0&downSpeed=96&PeerServerPort=0&app=live" +
                "&SuperNodeIP=0&maxSpeed=794&CDNAbnormal=0&flashver=WIN%2026%2E0%2E0%2E151&cnnTime=1036&fullScreen=0" +
                "&fplayerver=30201000&cmd=205&HashNotFinished=0&ReqSNBlockOutRange=0&returnBitmapErr=0&reCnnCount=0" +
                "&playerOnPlayTime=3535&cnnPS=0&blockHasData=0&transtype=0&adstat=4&lookback=0&HttpDownlandSpeed=0" +
                "&dsip=163%2E177%2E76%2E106&switch=0&str%5Fparam1=zijian&seq=0&UDPDownlandSpeed=0&lookbackseq=0&durl" +
                "=http%3A%2F%2F163%2E177%2E76%2E106%3A8080" +
                "%2F617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE%2F124209001%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&videopos=0&UDPDownSum=0&cdn=zijian&type=17&sIp=&UpdataSpeed=0&playtime=0&iQQ=0&UDPUpSum=0&ispay=0&sBiz=zhibo&RtmfpInfo=0&isuserpay=0&sOp=webflash&str%5Fparam2=163%2E177%2E76%2E106&PeerConnRate=0&livepid=23419&iSta=0&clientip=&svrCount=0&playAd=0&xserverip=&p2pCount=0&iFlow=0&viewid=&P2PReDelay=0&iTy=1991&sRef=&playNo=40A69A3E214B35258876B5DA01B5FADC3702ED76&HttpDownSum=0&P2PVer=0&progid=124209001&averRemtime=0&SuNodDelay=0&live%5Ftype=8&peerCount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&averPeerMeHealth=0&time=" + System.currentTimeMillis() + "&blockTime=0&StartP2P=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&pla=1&loadingTime=882&fullecode=10000");
        live_poll();
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&iSta=7&str3=&str1=&int2=0&ver=TencentPlayerLiveV3%2E2%2E1%2E00&rnd=2510&bid=pcvideo&itype=52&str4=40A69A3E214B35258876B5DA01B5FADC3702ED76&vid=124209001&iTy=2052&val2=&str2=1%2E4%2E6&val=100&int1=0");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dlol&sRef=&sPageId=&sPos=&step=3&val=31&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=57AFBB8F8A328B9440B5306E7169315FEE952B17&pid=40A69A3E214B35258876B5DA01B5FADC3702ED76&vid=124209001" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124209001%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D40A69A3E214B35258876B5DA01B5FADC3702ED76%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3542");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&iSta=7&str3=&str1=&int2=1&ver=TencentPlayerLiveV3%2E2%2E1%2E00&rnd=6859&bid=pcvideo&itype=52&str4=40A69A3E214B35258876B5DA01B5FADC3702ED76&vid=124209001&iTy=2052&val2=&str2=1%2E4%2E6&val=100&int1=0");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dlol&sRef=&sPageId=&sPos=&step=3&val=33&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=57AFBB8F8A328B9440B5306E7169315FEE952B17&pid=40A69A3E214B35258876B5DA01B5FADC3702ED76&vid=124209001" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124209001%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D40A69A3E214B35258876B5DA01B5FADC3702ED76%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime=" + cTimeStr()
                + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3737");
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
        headers1.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s3883642302; ts_last=tga.qq.com/match/2017/pc_game.html; pgv_pvid=461588912; ts_uid=5427588366");
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
            kvCommon("cnlID=124209001&Pwd=779660211&platform=1&ftime=" + System.currentTimeMillis() + "&guid" +
                    "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&vkey=617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&BossId=3460");
            sleep();
            kvCommon("SuperNodePort=0&errorCode=10000&prdLength=60&PeerServerIP=0&downSpeed=118&PeerServerPort=0&app" +
                    "=live&SuperNodeIP=0&maxSpeed=0&CDNAbnormal=0&flashver=WIN%2026%2E0%2E0%2E151&cnnTime=0" +
                    "&fullScreen=0&fplayerver=30201000&cmd=263&HashNotFinished=0&ReqSNBlockOutRange=0&returnBitmapErr" +
                    "=0&reCnnCount=0&type=17&cnnPS=0&blockHasData=0&transtype=0&adstat=4&lookback=0&HttpDownlandSpeed" +
                    "=0&dsip=163%2E177%2E76%2E106&switch=0&str%5Fparam1=zijian&seq=1&UDPDownlandSpeed=0&lookbackseq=0" +
                    "&durl=http%3A%2F%2F163%2E177%2E76%2E106%3A8080" +
                    "%2F617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE%2F124209001%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&videopos=0&UDPDownSum=0&cdn=zijian&playerOnPlayTime=0&sIp=&UpdataSpeed=0&playtime=0&iQQ=0&UDPUpSum=0&ispay=0&sBiz=zhibo&RtmfpInfo=0&isuserpay=0&sOp=webflash&str%5Fparam2=163%2E177%2E76%2E106&PeerConnRate=0&livepid=23419&iSta=0&clientip=&svrCount=0&playAd=0&xserverip=&p2pCount=0&iFlow=0&viewid=&P2PReDelay=0&iTy=1991&sRef=&playNo=40A69A3E214B35258876B5DA01B5FADC3702ED76&HttpDownSum=0&P2PVer=0&progid=124209001&averRemtime=0&SuNodDelay=0&live%5Ftype=8&peerCount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&averPeerMeHealth=0&time=" + System.currentTimeMillis() + "&blockTime=0&StartP2P=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&pla=1&loadingTime=0&fullecode=10000");
            sleep();
            live_poll();
            sleep();
            kvCommon("cnlID=124209001&Pwd=779660211&platform=1&ftime=" + System.currentTimeMillis() + "&guid" +
                    "=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&vkey=617B3CD64D2FCDE7192B56FFED3202719E0A4D66BE39F01F7BF99050A627F4305C9EFFF5092B7E4AC4A2686971DA70584FF6EB638A776E44F28423C410514FC863953751E0C53DB6BD704E79DD33E540F7A65DDC659CE1EE&BossId=3460");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s3883642302; pgv_pvid=461588912");
        headers.put("Host", "btrace.video.qq.com");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s3883642302; pgv_pvid=461588912");
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
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s3883642302; pgv_pvid=461588912");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&qqlog=&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&pollDataKey=pid%3D23419%26type%3D&needmark=1&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dlol&apptype=live";
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



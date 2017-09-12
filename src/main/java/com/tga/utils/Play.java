//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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

    public Play(String uri, String videoUri, double videoTime, int videoDownSize, int timeout, boolean exceptionStatus, AtomicInteger autoIndex) {
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

    public void run() {
        this.autoIndex.incrementAndGet();
        System.out.println(this.autoIndex.get());
        this.indexPage();
        this.kvCommon("flashver=WIN&iQQ=0&dc=9673&P2PVer=&progid=124217202&sRef=&CheckSum=105821293&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&BossId=2583");
        this.kvCommon("sid=124217202&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=" + "http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=WIN%2026%2E0%2E0%2E" + "151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver=30201000" + "&iTy=3007&p2pver=0&val=0&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml" + "%3Fgame%3Dhyrz&step=3&pid=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&P2PVer=0&BossId=3007&vurl=&Pwd=" + "881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        this.kvCommon("bid=pcvideo&rnd=6870&str4=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&ver=TencentPlayerLiveV3%2E2%2E1%2E00&int2=0&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str1=&itype=50&str3=&int1=0&iTy=2052&str2=1%2E4%2E6&iSta=7&val=100&vid=124217202&val2=");
        this.kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=323&val1=2&val2=604&val3=&val4=&val5=&apid=D5807D2F8C2351F1F078B2A876659C3DF2837475&pid=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&vid=124217202&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124217202%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DC2FB4A0E3A257670BE7318DEB69A3A633A3C574F%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1926");
        this.kvCommon("sid=124217202&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" + "%5Fgame" + "%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame" + "%2Ehtml%3Fgame%3Dhyrz&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" + "%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver=30201000&iTy=3007&p2pver=0&val=1296&ptag=&tpay=0" + "&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=4&pid" + "=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&P2PVer=0&BossId=3007&vurl=http%3A%2F%2F117%2E169%2E85%2E19" + "%3A8080%2F351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000L + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        this.kvCommon("sid=124217202&adid=&iQQ=0&val2=0&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&p2pver=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver=30201000&iTy=3007&flashver=WIN%2026%2E0%2E0%2E151&val=120588&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=5&pid=26B2A370A57FBF0AB22E9C001E0F75DC48983E8E&P2PVer=0&BossId=3007&vurl=http%3A%2F%2Fqqlive%2Ehdl%2Elxdns%2Ecom%3A80%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000L + "%26cdn%3Dwangsu%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname" + "%3Dqqlive%26vkey%3D7DCA6DF4D34023486E2EE496E1560E40CC7C162E2D44B0A3E4840F7912879381570A09656EE0706EE92CBF4330A2A6D22F0905F914BB062A4886D15B54B6976F47DBF18D4F9AE55B7EC343E4B93F9ABC235D1410ECC6E845&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&ctime=" + cTimeStr());
        this.kvCommon("sid=124217202&adid=&iQQ=0&val2=0&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&p2pver=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver=30201000&iTy=3007&flashver=WIN%2026%2E0%2E0%2E151&val=2510789&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=5&pid=EA91E629498AA85711F990E1FA9281B34C6CDE31&P2PVer=0&BossId=3007&vurl=http%3A%2F%2Fdnion%2Evideo%2Eqq%2Ecom%3A80%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000L + "%26cdn" + "%3Ddilian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive" + "%26vkey%3DC52FD5EF87D0AC6CB71BB9E05F07D9EDE904F0A210B1D806D53456308CE28DA950DBBC5156AC6D396DE24B068DD7890A2761586F441EF5B53E094B62340CC3BD601E7529A5AA319FCC2D0A5117128BCF1DACC0D81E264509&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&ctime=" + cTimeStr());
        this.kvCommon("avr=TencentPlayerLiveV3%2E2%2E1%2E00&cky=vGhkyPvvyGIGa1N9CMxu99mxavGxXdbY6K5jazeM0nHGxIV3X1HQSamuYDPCTEtaOPEX6R%5FQwBeN7PBUB5pYpnS6%5F4yVZgbKvorv4m1qGVBlvsrsuWJNMHr4iKiKJnVFNcc0i1%5FdNdZJ7qIFu0obxoAhKof8BdEkwBgrqFFCKz7nyp%5FGEwICrzPdqRHexjq1VRaTcfz49S8rEimTa6Pr2C6md8KUpLGFnq5MN5D2uqAsGNGyGqFIAzilff2SlMQkXBNaiSrFBvard4pOpWdshIFLPHD4UoC4OhTVp3gk5p2ZbNLkwyEjjCRqWLpE%5FuJ7aQHD%2DA&sdt=70202&cnl=124217202&ftime=" + System.currentTimeMillis() + "&uin=0&evr=5%2E4&plt=1&cts=" + System.currentTimeMillis() / 1000L + "&cip=111%2E8%2E185%2E94&gid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&dip=zijian&vky=351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&iTy=2595");
        this.kvCommon("sid=124217202&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" + "%5Fgame%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver=30201000&iTy=3007&p2pver=0&val=361&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=1100&pid=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&P2PVer=0&BossId=3007&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Frnd%3D981%26rid%3DC2FB4A0E3A257670BE7318DEB69A3A633A3C574F%26defauto%3D1%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Dhyrz%26appVer%3DTencentPlayerLiveV3%2E2%2E1%2E00%26system%3D0%26livequeue%3D1%26stream%3D2%26cKey%3DvGhkyPvvyGIGa1N9CMxu99mxavGxXdbY6K5jazeM0nHGxIV3X1HQSamuYDPCTEtaOPEX6R%5FQwBeN7PBUB5pYpnS6%5F4yVZgbKvorv4m1qGVBlvsrsuWJNMHr4iKiKJnVFNcc0i1%5FdNdZJ7qIFu0obxoAhKof8BdEkwBgrqFFCKz7nyp%5FGEwICrzPdqRHexjq1VRaTcfz49S8rEimTa6Pr2C6md8KUpLGFnq5MN5D2uqAsGNGyGqFIAzilff2SlMQkXBNaiSrFBvard4pOpWdshIFLPHD4UoC4OhTVp3gk5p2ZbNLkwyEjjCRqWLpE%5FuJ7aQHD%2DA%26browser%3Dchrome%26txvjsv%3D2%26cmd%3D2%26flashver%3D26%2C0%2C0%2C151%26defn%3D%26queueStatus%3D0%26sdtfrom%3D70202%26cnlid%3D124217202%26vip%5Fstatus%3D0%26encryptVer%3D5%2E4%26guid%3D3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B%26pla%3D0%26flvtype%3D1%26fntick%3D0&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        Thread stream = null;
        if (this.videoTime > 0 && this.videoDownSize > 0) {
            stream = new Thread(() -> {
                this.httpDownload();
            });
            stream.start();
        }

        this.kvCommon("sid=124217202&adid=&iQQ=0&ctime=" + cTimeStr() + "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" + "%5Fgame%2Ehtml%3Fgame%3Dhyrz&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" + "%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom" + "%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver=30201000&iTy=3007&p2pver=0&val=4117&ptag" + "=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=6&pid" + "=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&P2PVer=0&BossId=3007&vurl=http%3A%2F%2F117%2E169%2E85%2E19" + "%3A8080%2F351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000L + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");
        this.kvCommon("SuperNodePort=0&errorCode=10000&prdLength=8&PeerServerIP=0&downSpeed=166&PeerServerPort=0&app=live&maxSpeed=442&CDNAbnormal=0&flashver=WIN%2026%2E0%2E0%2E151&cnnTime=1052&fullScreen=0&fplayerver=30201000&cmd=205&HashNotFinished=0&ReqSNBlockOutRange=0&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=5575&cnnPS=0&blockHasData=0&transtype=0&adstat=4&type=17&HttpDownlandSpeed=0&dsip=117%2E169%2E85%2E19&playAd=0&lookback=0&str%5Fparam1=zijian&seq=0&UDPDownlandSpeed=0&lookbackseq=0&durl=http%3A%2F%2F117%2E169%2E85%2E19%3A8080%2F351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000L + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&videopos=0&UDPDownSum=0&cdn=zijian&str%5Fparam2=117%2E169%2E85%2E19&sIp=&UpdataSpeed=0&playtime=0&iQQ=0&UDPUpSum=0&ispay=0&sBiz=zhibo&switch=0&isuserpay=0&sOp=webflash&PeerConnRate=0&livepid=35598&iSta=0&clientip=&svrCount=0&HttpDownSum=0&xserverip=&p2pCount=0&RtmfpInfo=0&iFlow=0&viewid=&P2PReDelay=0&iTy=1991&sRef=&playNo=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&SuNodDelay=0&P2PVer=0&progid=124217202&averRemtime=0&time=" + System.currentTimeMillis() + "&live%5Ftype=8&peerCount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&averPeerMeHealth=0&loadingTime=3065&blockTime=0&StartP2P=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&pla=1&SuperNodeIP=0&fullecode=10000");
        this.live_poll();
        this.kvCommon("bid=pcvideo&rnd=2085&str4=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&ver=TencentPlayerLiveV3%2E2%2E1%2E00&int2=0&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str1=&itype=52&str3=&int1=0&iTy=2052&str2=1%2E4%2E6&iSta=7&val=100&vid=124217202&val2=");
        this.kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=58&val1=2&val2=604&val3=&val4=&val5=&apid=058C569F9CD532B8189296789FD76770EA8BCCB0&pid=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&vid=124217202&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124217202%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DC2FB4A0E3A257670BE7318DEB69A3A633A3C574F%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6148");
        this.kvCommon("bid=pcvideo&rnd=3864&str4=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&ver=TencentPlayerLiveV3%2E2%2E1%2E00&int2=1&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str1=&itype=52&str3=&int1=0&iTy=2052&str2=1%2E4%2E6&iSta=7&val=100&vid=124217202&val2=");
        this.kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=81&val1=2&val2=604&val3=&val4=&val5=&apid=058C569F9CD532B8189296789FD76770EA8BCCB0&pid=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&vid=124217202&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124217202%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DC2FB4A0E3A257670BE7318DEB69A3A633A3C574F%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26retry%3D1&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random" + "=8426");

        try {
            for(int i = 1; i < this.videoTime; i++) {
                this.forEachRequest(i);
            }
        } catch (Exception var3) {
        }

        if (this.videoTime > 0 && this.videoDownSize > 0 && stream != null) {
            stream.stop();
        }

    }

    public void indexPage() {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers1.put("Accept-Encoding", "gzip, deflate");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers1.put("Cache-Control", "max-age=0");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s8687862400; ts_last=tga.qq.com/match/2017/pc_game.html; pgv_pvid=461588912; ts_uid=5427588366");
        headers1.put("Host", "tga.qq.com");
        headers1.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(this.uri_index, headers1, this.exceptionStatus, this.timeout);
    }

    public void forEachRequest(int seq) {
        try {
            this.live_poll();
            this.sleep();
            this.kvCommon("guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&Pwd=779660211&cnlID=124217202&ftime=" + System.currentTimeMillis() + "&vkey=351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&platform=1&BossId=3460");
            this.sleep();
            this.kvCommon("SuperNodePort=0&errorCode=10000&prdLength=60&PeerServerIP=0&downSpeed=231&PeerServerPort=0&app=live&maxSpeed=0&CDNAbnormal=0&flashver=WIN%2026%2E0%2E0%2E151&cnnTime=0&fullScreen=0&fplayerver=30201000&cmd=263&HashNotFinished=0&ReqSNBlockOutRange=0&returnBitmapErr=0&reCnnCount=0&type=17&cnnPS=0&blockHasData=0&transtype=0&adstat=4&lookback=0&HttpDownlandSpeed=0&dsip=117%2E169%2E85%2E19&playAd=0&str%5Fparam1=zijian&seq=" + seq + "&UDPDownlandSpeed=0&lookbackseq=0&durl=http%3A%2F" + "%2F117" + "%2E169%2E85%2E19%3A8080%2F351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7%2F124217202%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + cTimeStr() + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&videopos=0&UDPDownSum=0&cdn=zijian&playerOnPlayTime=0&sIp=&UpdataSpeed=0&playtime=0&iQQ=0&UDPUpSum=0&ispay=0&sBiz=zhibo&switch=0&isuserpay=0&sOp=webflash&str%5Fparam2=117%2E169%2E85%2E19&PeerConnRate=0&livepid=35598&iSta=0&clientip=&svrCount=0&HttpDownSum=0&xserverip=&p2pCount=0&RtmfpInfo=0&iFlow=0&viewid=&P2PReDelay=0&iTy=1991&sRef=&playNo=C2FB4A0E3A257670BE7318DEB69A3A633A3C574F&SuNodDelay=0&P2PVer=0&progid=124217202&averRemtime=0&time=" + System.currentTimeMillis() + "&live%5Ftype=8&peerCount=0&blockCount=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&averPeerMeHealth=0&loadingTime=0&blockTime=0&StartP2P=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&pla=1&SuperNodeIP=0&fullecode=10000");
            this.sleep();
            this.live_poll();
            this.sleep();
            this.kvCommon("guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&Pwd=779660211&cnlID=124217202&ftime=" + System.currentTimeMillis() + "&vkey=351AB0F5E279A6C05B4FBCBC0B2DB9786EB6F61D8DBF0F2E14C640FDFB440CE6681A6F6E89D61A7EDC5EEA4A60F532089477D8F7A6F86D649B24D53A515C31A478C24C97632312A8DF6557AEC9B9E1BD9869AFC60F542EE7&platform=1&BossId=3460");
            this.sleep();
        } catch (InterruptedException var3) {
        }

    }

    private static String cTimeStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss SSS"));
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(2000L);
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
        headers.put("Referer", this.uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://112.90.53.167:8080/FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9/124208501.flv?cdncode=%2f18907E7BE0798990%2f&time=" + System.currentTimeMillis() / 1000L + "&cdn=zijian&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey" + "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223" + "D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B47" + "9ABA9&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html&apptype=live", headers, this.exceptionStatus, this.timeout);
    }

    public void kvGetCommon(String uri) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Cache-Control", "max-age=0");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s8687862400; pgv_pvid=461588912");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri, headers, this.exceptionStatus, this.timeout);
    }

    public void kvCommon(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", String.valueOf(body.length()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s8687862400; pgv_pvid=461588912");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.post(KV_URL, body, headers, this.exceptionStatus, this.timeout);
    }

    public void live_poll() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "pgv_pvi=5648218112; eas_sid=010560Q4B3O5R947B3D5I2D9S6; pgv_info=ssid=s8687862400; pgv_pvid=461588912");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&pollDataKey=pid%3D35598%26type%3D&needmark=1&qqlog=&markContext=last%3D0", headers, this.exceptionStatus, this.timeout);
    }

    public void httpDownload() {
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = this.videoUri + "&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Dhyrz&apptype=live";
            String host = tmpUrl.substring(8);
            host2 = host.substring(0, host.indexOf('/'));
            url = new URL(tmpUrl);
        } catch (Exception var20) {
            if (this.exceptionStatus) {
                var20.printStackTrace();
            }
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
            conn.addRequestProperty("Referer", this.uri_index);
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            conn.addRequestProperty("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            inStream = conn.getInputStream();
            byte[] buffer = new byte[1204];
            int totalSize = this.videoDownSize;
            while((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                if (bytesum >= totalSize) {
                    System.out.println("视频大小上限..." + bytesum + "---" + totalSize);
                    break;
                }
            }
        } catch (Exception var18) {
            if (this.exceptionStatus) {
                var18.printStackTrace();
            }
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException var17) {
            }

        }

    }
}

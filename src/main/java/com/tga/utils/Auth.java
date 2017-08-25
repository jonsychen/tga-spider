package com.tga.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Auth {

    private static String VIDEO_URL = null;

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


    public synchronized static final String getVideoUrl() throws InterruptedException, ExecutionException, TimeoutException,
            IOException {
        if (VIDEO_URL == null) {
            String json = HttpUtil.getOrReturn("http://info.zb.video.qq.com/?txvjsv=2&vip_status=0&pla=0&encryptVer=5%2E4&cKey=0LThs5czTRkGa1N9CMxu99mxavGxXdbY6K5jazeM0nGCbWGiXfY8k6HbSdZTAaWCkNl6RhFEv-qp5Y_bsDQnr22LBXSeVGKTk-pYpoDCtBaJQBO8YMw4a2DFbQtynsOgvSp5MiSA0eyz61srLvLbhIxXhgP_-bFLs8EaQ8vrwfy05DvyELYEyO0hppwDOY3HiNU1zKRjj1k7w-vq3p3J37Ej_FZyJWlxPeB2iXLSEzgRXc6lUx-xZ8LGIzfbXlZuB3DH6s2kkNsHTHgl_X0IQ_4ksjfDYl1gHYHB6OrSCsj6As2BHbs_3YhueKXFeGe2N4MUmg&defn=shd&queueStatus=0&cnlid=124219102&livequeue=1&guid=B906B291C9FC0214455D1F82479E28708BFE6308&defauto=1&flvtype=1&host=http%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc_index%2Ehtml&cmd=2&sdtfrom=70202&appVer=TencentPlayerLiveV3%2E2%2E0%2E00&fntick=1462851618&rnd=8&flashver=26%2C0%2C0%2C151&system=0&browser=chrome&stream=2&rid=9FA56234E1A48D6A6A440473A8B34C606E82B0AA", new HashMap<>());
            String url = JsonUtil.filter(json, "playurl");
            VIDEO_URL = url.substring(1, url.length() - 2) +
                    "&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&refer=http%3A%2F%2Ftga.qq" +
                    ".com%2Fmatch%2F2017%2Fpc_index.html&apptype=live";
        }
        return VIDEO_URL;
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException, IOException {
        String url = "http://qqlive.hdl.lxdns.com:80/124219102.flv?cdncode=%2f18907E7BE0798990%2f&time=1503638985&cdn=wangsu&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey=25DD5AAB6E0B2DD12D815F1FCDDEB54395BABA0E6FEA235C37F87D65F1D880F7D10D32520B7D784C898AB0A76E0122F8580E63CEFD2FAF284CBAE7379C6597116E345220E24AA882D6D2EC66366EC49AB3A538C70ED14194";
//        url.substring()url.indexOf("time")
    }


}

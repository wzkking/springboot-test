package org.wt.book;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoTest {
    //设置APPID/AK/SK
    public static final String APP_ID = "14469439";
    public static final String API_KEY = "3v32IZ1YEFKlCPf0LFOKyahd";
    public static final String SECRET_KEY = "4K7K4xi1q5etxboBAeNHn543OpVGtNAD";

    public static void main(String[] args) throws  Exception {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
// 调用接口
        HashMap<String,Object> options = new HashMap<>();
        options.put("per","3");
        List<byte[]> bylist = new ArrayList<>();
        File file = new File("D:/dp.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(isr);
        String str=null;
        long bt = System.currentTimeMillis();
        while ((str=br.readLine())!=null){
            TtsResponse res = client.synthesis(str, "zh", 1, options);
            byte[] data = res.getData();
            if(data!=null) {
                bylist.add(data);
            }
        }
        br.close();
        isr.close();
        long et = System.currentTimeMillis();
        System.out.println("耗时:"+(et-bt));
        byte[] resultby = byteMergerAll(bylist);
        Util.writeBytesToFileSystem(resultby, "D:/output1111.mp3");

//        TtsResponse res = client.synthesis("“你这个死丫头，没听绑匪说了吗？报警的话就撕票！是不是蠢？”朱红气得面红耳赤，点着许娇娇的脑袋：“闭上你的嘴巴！尽出馊主意！”", "zh", 2, options);
//        byte[] data = res.getData();
//        JSONObject res1 = res.getResult();
//        if (data != null) {
//            try {
//                Util.writeBytesToFileSystem(data, "D:/output5.mp3");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
/*        if (res1 != null) {
            System.out.println(res1.toString(2));
        }*/

    }

    private static byte[] byteMergerAll(List<byte[]> values) {
        int length_byte = 0;
        for (int i = 0; i < values.size(); i++) {
            length_byte += values.get(i).length;
        }
        byte[] all_byte = new byte[length_byte];
        int countLength = 0;
        for (int i = 0; i < values.size(); i++) {
            byte[] b = values.get(i);
            System.arraycopy(b, 0, all_byte, countLength, b.length);
            countLength += b.length;
        }
        return all_byte;
    }


}

package com.sky.cloud.test;

import com.baidu.aip.http.AipRequest;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Base64Util;
import org.json.JSONException;
import org.json.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;

public class BaiDuOCR {

    //设置APPID/AK/SK
    public static final String APP_ID = "24231130";
    public static final String API_KEY = "G062UYGMR7O4tHlswcdAnAD9";
    public static final String SECRET_KEY = "1MGG0ZtqkU0S9FEmXeI8GfFGb4O8GCK8";


    public static void main(String[] args) throws JSONException, IOException {

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

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
//        String path = "C:\\Users\\dm\\Pictures\\测试OCR\\z1.jpg";
//        String path = "C:\\Users\\dm\\Pictures\\测试OCR\\sky-b.png";
        String path = "C:\\Users\\dm\\Pictures\\1cun.jpg";
        BASE64Encoder encoder = new BASE64Encoder();
        path = encoder.encode(readImageFile(path));
        System.out.println(path);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] fileBytes = decoder.decodeBuffer(path);
        getFileByBytes(fileBytes, "C:\\Users\\dm\\Pictures", "1cun2.jpg");


//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));

//        String path2 = "C:\\Users\\dm\\Pictures\\测试OCR\\f1.jpg";
//        String path2 = "C:\\Users\\dm\\Pictures\\测试OCR\\lsq-f.jpg";
//        JSONObject res2 = client.basicGeneral(path2, new HashMap<String, String>());
//        System.out.println(res2.toString(2));

    }




    public void sample(AipOcr client , String imagePath) throws JSONException {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");


        // 参数为本地图片路径
        String image = imagePath;
        JSONObject res = client.basicGeneral(image, options);
        System.out.println(res.toString(2));

/*        // 参数为本地图片二进制数组
        byte[] file = readImageFile(image);
        res = client.basicGeneral(file, options);
        System.out.println(res.toString(2));*/


        // 通用文字识别, 图片参数为远程url图片
//        JSONObject res = client.basicGeneralUrl(imagePath, options);
//        System.out.println(res.toString(2));


    }



    public static  byte[] readImageFile(String imagePath) {
        byte[] buffer = null;
        try
        {
            FileInputStream fis = new FileInputStream(imagePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }

    //将Byte数组转换成文件
    public static void getFileByBytes(byte[] bytes, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

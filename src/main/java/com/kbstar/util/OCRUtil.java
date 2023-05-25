package com.kbstar.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OCRUtil {
    public static Object getResult(String imgpath, String imgname){
        JSONObject obj = null;
        String apiURL = "https://uhucar79op.apigw.ntruss.com/custom/v1/22517/b3c60e46e2433217e892560674224f9a6d08faef0ac65b5d9f6572ff06630406/infer";
        String secretKey = "bENoaVFWTG9Gb1RlWXVLeklReGJxaXREemhlRXlYUVc=";
        String imageFile = imgpath+imgname;

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.add(image);
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = new File(imageFile);
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        return obj;
    }
    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }
    public static Map getData(JSONObject obj){
        Map<String,String> map = new HashMap<>();


        JSONArray images = (JSONArray) obj.get("images");
        JSONObject jo1 = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray) jo1.get("fields");

        JSONObject biznum = (JSONObject) fields.get(0);
        String biznum_value = (String) biznum.get("inferText");
        JSONObject bizname = (JSONObject) fields.get(1);
        String bizname_value = (String) bizname.get("inferText");
        JSONObject bizowner = (JSONObject) fields.get(2);
        String bizowner_value = (String) bizowner.get("inferText");
        JSONObject bizdate = (JSONObject) fields.get(3);
        String bizdate_value = (String) bizdate.get("inferText");
        JSONObject bizad = (JSONObject) fields.get(4);
        String bizad_value = (String) bizad.get("inferText");

        map.put("biznum",biznum_value);
        map.put("bizname",bizname_value);
        map.put("bizowner",bizowner_value);
        map.put("bizdate",bizdate_value);
        map.put("bizad",bizad_value);

        return map;
    }
    public static Map getbab(JSONObject obj){
        Map<String,String> map = new HashMap<>();

        JSONArray images = (JSONArray) obj.get("images");
        JSONObject jo1 = (JSONObject) images.get(0);
        JSONObject title = (JSONObject) jo1.get("title");
        String date = (String) title.get("inferText");

        JSONArray menu = (JSONArray) jo1.get("fields");
        JSONObject menu1 = (JSONObject) menu.get(0);
        String menu1_val = (String) menu1.get("inferText");
        JSONObject menu2 = (JSONObject) menu.get(1);
        String menu2_val = (String) menu2.get("inferText");
        JSONObject menu3 = (JSONObject) menu.get(2);
        String menu3_val = (String) menu3.get("inferText");
        JSONObject menu4 = (JSONObject) menu.get(3);
        String menu4_val = (String) menu4.get("inferText");
        JSONObject menu5 = (JSONObject) menu.get(4);
        String menu5_val = (String) menu5.get("inferText");


        map.put("date",date);
        map.put("menu1",menu1_val);
        map.put("menu2",menu2_val);
        map.put("menu3",menu3_val);
        map.put("menu4",menu4_val);
        map.put("menu5",menu5_val);
        return map;
    }
}

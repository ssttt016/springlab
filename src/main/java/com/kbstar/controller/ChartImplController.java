package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ChartImplController {
    @RequestMapping("/chart02")
    public Object chart02(){
        // {'category':[],'datas':[]}
        JSONObject jo = new JSONObject();

        JSONArray jaCnt = new JSONArray();
        for(int i =1;i<=12;i++){
            Random r = new Random();
            int cnt = r.nextInt(10000)+1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for(int i=2011;i<=2023;i++){
            jaYear.add(i);
        }
        jo.put("category",jaYear);
        jo.put("datas",jaCnt);
        return jo;
    }
    @RequestMapping("/chart0301")
    public Object chart0301(){
        JSONArray ja = new JSONArray();
        for(int i=1;i<=5;i++){
            Random r = new Random();
            int num = r.nextInt(20)+1;
            JSONArray jadata = new JSONArray();
            jadata.add("data:"+num);
            jadata.add(num);
            ja.add(jadata);
        }
        return ja;
    }
    @RequestMapping("/chart0302")
    public Object chart0302(){
        JSONObject jo = new JSONObject();
        JSONArray dot = new JSONArray();
        JSONArray ja1 = new JSONArray();
        JSONArray ja2 = new JSONArray();
        JSONArray line = new JSONArray();
        for(int i=1;i<=6;i++){
            Random r = new Random();
            int num = r.nextInt(10)+1;
            dot.add(num);
        }
        for(int i=1;i<=2;i++){
            Random r = new Random();
            int num = r.nextInt(6)+1;
            ja1.add(num);
        }
        for(int i=1;i<=2;i++){
            Random r = new Random();
            int num = r.nextInt(6)+1;
            ja2.add(num);
        }
        line.add(ja1);
        line.add(ja2);
        jo.put("line",line);
        jo.put("dot",dot);
        return jo;
    }
    @RequestMapping("/chart0303")
    public Object chart0303(){
        JSONObject jo = new JSONObject();
        JSONArray ja1 = new JSONArray();
        for(int i=1;i<=6;i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja1.add(num);
        }
        JSONArray ja2 = new JSONArray();
        for(int i=1;i<=6;i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja2.add(num);
        }
        JSONArray ja3 = new JSONArray();
        for(int i=1;i<=6;i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja3.add(num);
        }
        JSONArray ja4 = new JSONArray();
        for(int i=1;i<=6;i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja4.add(num);
        }
        JSONArray ja5 = new JSONArray();
        for(int i=1;i<=6;i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja5.add(num);
        }
        JSONArray ja6 = new JSONArray();
        for(int i=1;i<=6;i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja6.add(num);
        }
        jo.put("data1",ja1);
        jo.put("data2",ja2);
        jo.put("data3",ja3);
        jo.put("data4",ja4);
        jo.put("data5",ja5);
        jo.put("data6",ja6);

        return jo;
    }
    @RequestMapping("/chart05")
    public Object chart05(String year){
        JSONArray ja = new JSONArray();
        for(int i=1; i<=12; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja.add(num);
        }
        return ja;
    }
}

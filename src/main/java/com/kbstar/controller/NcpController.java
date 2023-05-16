package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class NcpController {

    @Value("${uploadimgdir}")
    String imgpath;
    @RequestMapping("/cfr1impl")
    public String cfr1impl(Model model, Ncp ncp) throws ParseException {
        // 이미지를 서버에 저장
        FileUploadUtil.saveFile(ncp.getImg(),imgpath);
        // 저장한 이미지를 ncp로 , 결과를 받는다
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRCelebrityUtil.getResult(imgpath,imgname);
        log.info(result.toJSONString());

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);
        JSONObject celebrity = (JSONObject) obj.get("celebrity");
        String value = (String) celebrity.get("value");


        model.addAttribute("result",value);
        model.addAttribute("center","cfr1");
        return "index";
    }
    @RequestMapping("/cfr2impl")
    public String cfr2impl(Model model, Ncp ncp) throws ParseException {
        FileUploadUtil.saveFile(ncp.getImg(),imgpath);

        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath,imgname);
        log.info(result.toJSONString());

        String gender_value = "";
        String emotion_value = "";
        String pose_value = "";
        String age_value = "";

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value");

        Map<String,String> map = new HashMap<>();
        map.put("emotion",emotion_value);
        map.put("gender",gender_value);
        map.put("pose",pose_value);
        map.put("age",age_value);
        model.addAttribute("result",map);
        model.addAttribute("center","cfr2");
        return "index";
    }
    @RequestMapping("/mycfr")
    public String mycfr(Model model, Ncp ncp,String imgname) throws ParseException {
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath,imgname);
        log.info(result.toJSONString());

        String gender_value = "";
        String emotion_value = "";
        String pose_value = "";
        String age_value = "";

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value");

        Map<String,String> map = new HashMap<>();
        map.put("emotion",emotion_value);
        map.put("gender",gender_value);
        map.put("pose",pose_value);
        map.put("age",age_value);
        model.addAttribute("result",map);
        model.addAttribute("center","pic");
        return "index";
    }
    @RequestMapping("/ocr1impl")
    public String ocrimpl1(Model model, Ncp ncp){
        FileUploadUtil.saveFile(ncp.getImg(),imgpath);
        String imgname = ncp.getImg().getOriginalFilename();

        JSONObject result = (JSONObject) OCRUtil.getResult(imgpath,imgname);
        Map map = OCRUtil.getData(result);

        model.addAttribute("result",map);
        model.addAttribute("center","ocr1");
        return "index";
    }
    @RequestMapping("/ocr2impl")
    public String ocrimpl2(Model model, Ncp ncp){
        FileUploadUtil.saveFile(ncp.getImg(),imgpath);
        String imgname = ncp.getImg().getOriginalFilename();

        JSONObject result = (JSONObject) OCRUtil.getResult(imgpath,imgname);
        Map map = OCRUtil.getbab(result);

        model.addAttribute("result",map);
        model.addAttribute("center","ocr2");
        return "index";
    }
}

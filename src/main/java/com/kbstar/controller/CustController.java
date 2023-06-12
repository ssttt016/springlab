package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Search;
import com.kbstar.dto.Search2;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/cust")
public class CustController {

    @Autowired
    CustService custService;

    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "cust/";
    // 127.0.0.1/cust
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        //logger.info("---------------------------------------------------");
        Random r = new Random();
        int inx = r.nextInt(10)+1;
        log.info(inx+"");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model, String id){
        Cust cust = new Cust(id,"xxx","james");
        model.addAttribute("gcust",cust);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }
    @RequestMapping("/find")
    public String find(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"find");
        return "index";
    }
    @RequestMapping("/findimpl")
    public String findimpl(Model model, Search search,@RequestParam(required = false, defaultValue = "1") int pageNo) throws Exception {
        PageInfo<Cust> p = new PageInfo<>(custService.getFindPage(pageNo, search), 3);
        // search 조건이 위에 getFindPage에 들어감 기존에는 pageNo만 있었음
        model.addAttribute("target","cust");
        model.addAttribute("cpage",p);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"find");
        model.addAttribute("search", search);
        return "index";
    }
    @RequestMapping("/find2")
    public String find2(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"find2");
        return "index";
    }

    @RequestMapping("/findimpl2")
    public String findimpl2(Model model, Search2 search2, @RequestParam(required = false, defaultValue = "1") int pageNo) throws Exception {
        log.info(search2.getSearch1());
        log.info(search2.getSearch2());
        PageInfo<Cust> p = new PageInfo<>(custService.getFindPage2(pageNo, search2), 3);
        model.addAttribute("value1",search2.getSearch1());
        model.addAttribute("value2",search2.getSearch2());
        model.addAttribute("target","cust");
        model.addAttribute("cpage",p);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"find2");
        model.addAttribute("search", search2);
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Cust> list= null;
        try {
            list = custService.get();
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
        }
        model.addAttribute("clist",list);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"all");
        return "index";
    }

    @RequestMapping("/allpage")
    public String allpage(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) throws Exception {
        PageInfo<Cust> p;
        try {
            p = new PageInfo<>(custService.getPage(pageNo), 3);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
        }
        model.addAttribute("target","cust");
        model.addAttribute("cpage",p);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"allpage");
        return "index";
    }
}

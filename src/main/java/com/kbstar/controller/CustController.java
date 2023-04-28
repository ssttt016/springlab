package com.kbstar.controller;

import com.kbstar.dto.Cust;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/cust")
public class CustController {
    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir= "cust/";
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("center",dir+"center");
        model.addAttribute("left",dir+"left");
        //logger.info("------------------------------");
        Random r = new Random();
        int inx = r.nextInt(1000)+1;
        log.info(inx+"");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir+"add");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model, String id) {
        Cust cust = new Cust(id,"xxx","james");
        model.addAttribute("gcust",cust);
        model.addAttribute("center",dir+"get");
        model.addAttribute("left",dir+"left");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model){
        List<Cust> clist = new ArrayList<>();
        clist.add(new Cust("id01","pwd01","james1"));
        clist.add(new Cust("id02","pwd02","james2"));
        clist.add(new Cust("id03","pwd03","james3"));
        clist.add(new Cust("id04","pwd04","james4"));
        clist.add(new Cust("id05","pwd05","james5"));
        model.addAttribute("clist",clist);

        model.addAttribute("center",dir+"all");
        model.addAttribute("left",dir+"left");
        return "index";
    }

}

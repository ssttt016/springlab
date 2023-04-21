package com.kbstar.controller;

import com.kbstar.dto.Cust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JSPController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir= "jsp/";
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("center",dir+"center");
        model.addAttribute("left",dir+"left");
        return "index";
    }

    @RequestMapping("/jsp01")
    public String jsp01(Model model){
        model.addAttribute("num",10000.234);
        Cust cust = new Cust("id01","pwd01","james");
        model.addAttribute("cust",cust);
        Date date = new Date();
        model.addAttribute("cdate",date);

        model.addAttribute("center",dir+"jsp01");
        model.addAttribute("left",dir+"left");
        return "index";
    }

    @RequestMapping("/jsp02")
    public String jsp02(Model model){
        Cust cust = new Cust("id01","pwd01","james");
        model.addAttribute("rcust",cust);
        model.addAttribute("num",3);
        model.addAttribute("center",dir+"jsp02");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/jsp03")
    public String jsp03(Model model){
        List<Cust> clist = new ArrayList<>();
        clist.add(new Cust("id01","pwd01","james1"));
        clist.add(new Cust("id02","pwd02","james2"));
        clist.add(new Cust("id03","pwd03","james3"));
        clist.add(new Cust("id04","pwd04","james4"));
        clist.add(new Cust("id05","pwd05","james5"));
        model.addAttribute("clist",clist);

        model.addAttribute("center",dir+"jsp03");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/jsp04")
    public String jsp04(Model model){
        model.addAttribute("center",dir+"jsp04");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/jsp05")
    public String jsp05(Model model){
        model.addAttribute("center",dir+"jsp05");
        model.addAttribute("left",dir+"left");
        return "index";
    }

}

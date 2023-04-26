package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir= "item/";

    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("center",dir+"center");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir+"add");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model){
        List<Item> list = new ArrayList<>();
        list.add(new Item(100,"Bear1",1000,"a.jpg",new Date()));
        list.add(new Item(101,"Bear2",2000,"b.jpg",new Date()));
        list.add(new Item(102,"Bear3",3000,"c.jpg",new Date()));
        list.add(new Item(103,"Bear4",4000,"d.jpg",new Date()));
        list.add(new Item(104,"Bear5",5000,"e.jpg",new Date()));
        model.addAttribute("allitem",list);

        model.addAttribute("center",dir+"all");
        model.addAttribute("left",dir+"left");
        return "index";
    }
}

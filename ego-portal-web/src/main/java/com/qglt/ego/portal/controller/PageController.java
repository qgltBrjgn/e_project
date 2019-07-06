package com.qglt.ego.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qingt on 2019/7/5.
 */
@Controller
public class PageController {



    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        System.out.println("转发页面"+page);
        return page;
    }
}

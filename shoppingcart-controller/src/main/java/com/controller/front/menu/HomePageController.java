package com.controller.front.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SherWin
 * @date 2019/12/20 11:31
 */
@Controller
public class HomePageController {

    @RequestMapping("/homepagejsp")
    public String homePageJsp(){

        return "fe/homepage";
    }
}

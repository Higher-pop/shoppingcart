package com.controller.behind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SherWin
 * @date 2019/12/5 10:34
 */
@Controller
@RequestMapping("/admin")
public class BeIndexController {


    @RequestMapping("/index")
    public String index(){
        return "be/index";
    }

}


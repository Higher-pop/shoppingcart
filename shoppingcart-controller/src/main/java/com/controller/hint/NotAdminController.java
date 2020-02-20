package com.controller.hint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SherWin
 * @date 2019/12/20 12:01
 */
@Controller
public class NotAdminController {

    @RequestMapping("/notadminjsp")
    public String notAdminJsp(){
        return "hint/not_admin";
    }
}

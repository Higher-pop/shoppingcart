package com.controller.front.login;

import com.entity.SUserEntity;
import com.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SherWin
 * @date 2019/12/20 10:44
 */
@Controller
public class SUserLoginController {

    @Autowired
    private SUserService sUserService;

    @RequestMapping("/loginjsp")
    public String loginJsp(){
        return "be/login";
    }

    @RequestMapping("/getlogin")
    public String getLogin(SUserEntity sUserEntity){
        sUserService.getByName(sUserEntity.getUsername());
        return null;
    }
}

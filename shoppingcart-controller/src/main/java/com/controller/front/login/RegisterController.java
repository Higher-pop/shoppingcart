package com.controller.front.login;

import com.entity.SUserEntity;
import com.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author SherWin
 * @date 2019/12/20 9:38
 */
@Controller
public class RegisterController {

    @Autowired
    private SUserService sUserService;

    @RequestMapping("/registerjsp")
    public String registerJsp(){
        return "be/register";
    }

    @RequestMapping("/getregister")
    public String getRegister(SUserEntity sUserEntity, HttpServletResponse resp, HttpServletRequest req){

        try{
            sUserService.insert(sUserEntity);
            resp.getWriter().print("<h2>注册成功</h2>");
            return "forward:homepage";
        } catch (IOException e) {
            try {
                resp.getWriter().print("<h2>注册失败,用户已存在或密码长度超出范围</h2>");
                req.setAttribute("users",sUserEntity);
                return "forward:register";
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }


        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

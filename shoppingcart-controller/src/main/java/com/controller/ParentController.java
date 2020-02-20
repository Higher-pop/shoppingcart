package com.controller;

import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author SherWin
 * @date 2019/12/12 10:00
 */
@Repository
public abstract class ParentController extends HttpServlet {


    public static final int  PAGE_SIZE = 2;
    protected Integer getParamInteger(HttpServletRequest req, String key, int defaultValue) {
        Integer returnValue = defaultValue;
        try {
            returnValue = Integer.valueOf(req.getParameter(key));
        } catch (NumberFormatException nfe) {
            //throw new RuntimeException("error");
        }

        return returnValue;
    }


}
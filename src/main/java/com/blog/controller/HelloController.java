package com.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GD on 2017/8/31.
 */
@Controller
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/hello.do")
    public String index(HttpServletRequest request, HttpServletResponse response,Model model){
        return "index";
    }

    @RequestMapping(path="api.do")
    @ResponseBody
    public void swaggerIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect( "swagger-ui.html");
    }

}

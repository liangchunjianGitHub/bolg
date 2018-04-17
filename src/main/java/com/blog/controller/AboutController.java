package com.blog.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by GD on 2017/8/31.
 */
@RequestMapping(path = "about")
@Api(tags = "关于我", description = "相关信息")
@Controller
public class AboutController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "home")
    @ApiIgnore
    public String home(HttpServletRequest request, HttpServletResponse response,Model model){
        return "pages/about/index";
    }
}

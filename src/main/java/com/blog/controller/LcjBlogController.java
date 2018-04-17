package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;
/**
 * Created by LCJ on 2018/4/9.
 */
@RequestMapping(path = "blog")
@Api(tags = "关于我", description = "相关信息")
@Controller
public class LcjBlogController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "home")
    @ApiIgnore
    public String home(HttpServletRequest request, HttpServletResponse response,Model model){
        return "pages/blog/home";
    }
}

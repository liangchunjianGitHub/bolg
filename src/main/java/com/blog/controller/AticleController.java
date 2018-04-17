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
@RequestMapping(path = "aticles")
@Api(tags = "文章管理", description = "文章信息的管理")
@Controller
public class AticleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "home")
    @ApiIgnore
    public String home(HttpServletRequest request, HttpServletResponse response,Model model){
        return "pages/aticles/index";
    }

    @RequestMapping(path = "detail")
    @ApiIgnore
    public String atileInfo(HttpServletRequest request, HttpServletResponse response,Model model){
        return "pages/aticles/aticle_detail";
    }
}

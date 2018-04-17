package com.blog.controller;

import com.blog.model.User;
import com.blog.service.interf.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by GD on 2017/8/31.
 */
@Controller
@RequestMapping("user")
@Api(value = "User" ,tags = "用戶")
public class UserController {

    @Autowired
    private UserService userService;

    private User user;
    @Value("${USER_SESSION}")
    private String userSession;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    @ResponseBody
    @ApiOperation("获取商品信息")
    public User login(HttpServletRequest request, HttpServletRequest response,
        @ApiParam(name="id" ,value = "user id" ,required = true) @RequestParam Integer id //apiParam 中的name 要与定义的name一样
        ){
        try {
            user = userService.loginUser(1);
            HttpSession session = request.getSession();
            session.setAttribute(userSession,user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

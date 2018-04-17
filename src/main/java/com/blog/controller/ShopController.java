package com.blog.controller;

import com.blog.baseModel.ResultBean;
import com.blog.model.Shop;
import com.blog.service.interf.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GD on 2018/3/8.
 */

@Controller
@RequestMapping("shop")
@Api(tags = "商品信息接口" ,description = "商品信息接口")
public class ShopController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ShopService shopService;

    @RequestMapping(value="list" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取商品信息")
    public ResultBean shopList(@RequestParam Integer id){
        Shop shop = shopService.getShopById(id);
        return new ResultBean<Shop>(shop);
    }
}

package com.xzh.shiro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author 向振华
 * @date 2020/09/27 16:11
 */
@Api(tags = "首页")
@RestController
@RequestMapping
public class HomeController {

    @ApiOperation(value = "首页")
    @GetMapping
    public String home() {
        return "success";
    }
}

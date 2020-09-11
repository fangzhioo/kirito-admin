package com.kirito.cloud.portal.controller;

import com.kirito.cloud.common.api.CommonResult;
import com.kirito.cloud.portal.domain.HomeContentResult;
import com.kirito.cloud.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 首页内容管理Controller
 * Created by macro on 2019/1/28.
 */
@Controller
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {

    private HomeService homeService;

    @Autowired
    public void setHomeService(HomeService homeService) {
        // 没有直接在变量上添加Autowired注解的原因参考 http://code.aone.alibaba-inc.com/dt/op-daas/codereview
        this.homeService = homeService;
    }


    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<HomeContentResult> content() {
        HomeContentResult contentResult = homeService.content();
        return CommonResult.success(contentResult);
    }
}

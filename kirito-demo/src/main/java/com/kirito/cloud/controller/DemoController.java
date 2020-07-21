package com.kirito.cloud.controller;

import com.kirito.cloud.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/app")
    public String getHello(){
        return "Hello Guy!";
    }

    @GetMapping("/json")
    public CommonResult<String> getJson(){
        return new CommonResult<>(200, "success", "hello from getJson");
    }

}

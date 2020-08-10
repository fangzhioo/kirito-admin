package com.kirito.cloud.controller;

import com.kirito.cloud.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alioss")
@Api
public class AliossController {


//    @GetMapping("/policy")
//    @ApiOperation("获取aliyun OSS上传签名")
//    public CommonResult policy(){
//        AliyunOSSPolicyBO policy = fileService.policy();
//        return BaseResult.success(policy);
//    }
//
//    @PostMapping("/upload")
//    @ApiOperation("upload")
//    public BaseResult uploadFile(@RequestParam(value = "file") MultipartFile multipartFile){
//        BlogFileBO fileBo = fileService.uploadOSSFile(multipartFile);
//        return BaseResult.success(fileBo);
//    }
//
//    @PostMapping("/async")
//    @ApiOperation("async")
//    public BaseResult asyncFile(@RequestBody BlogFileBO fileBo){
//        boolean b = fileService.asyncFile(fileBo);
//        return BaseResult.success(b);
//    }
//
//    @GetMapping("/list")
//    @ApiOperation("list")
//    public BaseResult list(BlogFileSearch search){
//        List<BlogFileBO> objects = fileService.listFile(search);
//        return BasePages.restPage(objects);
//    }
//
//    @GetMapping("/delete")
//    @ApiOperation("delete")
//    public BaseResult deleteFile(@RequestParam(value = "ossKey",required = true) String ossKey){
//        return BaseResult.success(fileService.deleteFile(ossKey));
//    }
}

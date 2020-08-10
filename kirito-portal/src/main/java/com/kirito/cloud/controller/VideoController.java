package com.kirito.cloud.controller;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.portal.pojo.query.VideoQuery;
import com.kirito.cloud.portal.pojo.vo.VideoVO;
import com.kirito.cloud.service.VideoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/video")
@Api
public class VideoController {
    @Resource
    private VideoService videoService;

    @GetMapping("/get/{id}")
    public CommonResult<VideoVO> getVideoById(@PathVariable("id") Integer id){
        VideoVO video = videoService.getVideo(id);
        return CommonResult.success(video);
    }

    @GetMapping("/list")
    public CommonResult<List<VideoVO>> getVideoList(VideoQuery videoQuery){
        List<VideoVO> list = videoService.getArticleList(videoQuery);
        return CommonResult.success(list);
    }

    @PostMapping("/publish")
    public CommonResult<Integer> publishVideo(@RequestBody VideoVO videoVO){
        Integer video = videoService.createVideo(videoVO);
        return CommonResult.success(video);
    }

    @GetMapping("/del/{id}")
    public CommonResult<Integer> deleteVideoById(@PathVariable("id")Integer id){
        Integer integer = videoService.removeVideo(id);
        return CommonResult.success(integer);
    }

    @PostMapping("/update")
    public CommonResult<Integer> updateVideo(@RequestBody VideoVO videoVO){
        Integer integer = videoService.updateVideo(videoVO);
        return CommonResult.success(integer);
    }
}

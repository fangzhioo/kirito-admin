package com.kirito.cloud.controller;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.portal.pojo.query.ArticleQuery;
import com.kirito.cloud.portal.pojo.vo.ArticleVO;
import com.kirito.cloud.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
@Api
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("/recommend")
    @ApiOperation("获取首页热门")
    public CommonResult<List<ArticleVO>> getRecommendArticles(ArticleQuery articleQuery) {
        List<ArticleVO> result = articleService.getRecommendArticles(articleQuery);
        return CommonResult.success(result);
    }

    @GetMapping("/get/{id}")
    @ApiOperation("获取文章详情")
    public CommonResult<ArticleVO> getArticleById(@PathVariable Integer id){
        ArticleVO article = articleService.getArticle(id);
        return CommonResult.success(article);
    }

    @GetMapping("/list")
    @ApiOperation("获取最新发布的文章列表")
    public CommonResult<List<ArticleVO>> getArticleList(ArticleQuery articleQuery){
        List<ArticleVO> articleList = articleService.getArticleList(articleQuery);
        return CommonResult.success(articleList);
    }

    @PostMapping("/publish")
    @ApiOperation("发表文章")
    public CommonResult<Integer> publishArticle(@RequestBody ArticleVO articleVO){
        Integer article = articleService.createArticle(articleVO);
        return CommonResult.success(article);
    }

    @GetMapping("/del/{id}")
    @ApiOperation("根据id删除文章")
    public CommonResult<Integer> deleteArticleById(@PathVariable Integer id){
        Integer integer = articleService.removeArticleById(id);
        return CommonResult.success(integer);
    }

    @PostMapping("/update")
    @ApiOperation("更新文章")
    public CommonResult<Integer> updateArticle(@RequestBody ArticleVO articleVO){
        Integer integer = articleService.updateArticle(articleVO);
        return CommonResult.success(integer);
    }
}

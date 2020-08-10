package com.kirito.cloud.service.impl;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.common.Preconditions;
import com.kirito.cloud.converter.POJOConverter;
import com.kirito.cloud.portal.mapper.BlogVideoMapper;
import com.kirito.cloud.portal.model.BlogVideo;
import com.kirito.cloud.portal.model.BlogVideoExample;
import com.kirito.cloud.portal.pojo.query.VideoQuery;
import com.kirito.cloud.portal.pojo.vo.VideoVO;
import com.kirito.cloud.service.UserService;
import com.kirito.cloud.service.VideoService;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;
import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    private BlogVideoMapper blogVideoMapper;
    @Resource
    private UserService userService;

    @Override
    public Integer createVideo(VideoVO videoVO) {
        CommonResult<SsoUserBO> current = userService.current();
        Preconditions.checkNotNull(current,"请先登陆");
        Preconditions.checkState(CommonResult.checkStatus(current.getCode()),current.getMsg());
        Preconditions.checkNotNull(videoVO.getTitle(),"标题不能为空");
        Preconditions.checkNotNull(videoVO.getContent(),"内容不能为空");
        BlogVideo video = POJOConverter.voToDO(videoVO);
        video.setAuthorId(current.getData().getUserId());
        video.setAuthorAvatar(current.getData().getAvatar());
        video.setAuthorNickname(current.getData().getNickName());
        return blogVideoMapper.insertSelective(video);
    }

    @Override
    public Integer removeVideo(Integer videoId) {
        CommonResult<SsoUserBO> current = userService.current();
        Preconditions.checkNotNull(current,"请先登陆");
        Preconditions.checkState(CommonResult.checkStatus(current.getCode()),current.getMsg());
        BlogVideo video = blogVideoMapper.selectByPrimaryKey(videoId);
        Preconditions.checkNotNull(video,"找不到指定的视频");
        Preconditions.checkState(video.getStatus()==1,"该视频已被删除或已取消发布");
        Preconditions.checkState(current.getData().getUserId().equals(video.getAuthorId()),"无权限删除");
        return blogVideoMapper.deleteByPrimaryKey(videoId);
    }

    @Override
    public Integer updateVideo(VideoVO videoVO) {
        Preconditions.checkNotNull(videoVO.getVideoId(),"缺少Id");
        CommonResult<SsoUserBO> current = userService.current();
        Preconditions.checkNotNull(current,"请先登陆");
        Preconditions.checkState(CommonResult.checkStatus(current.getCode()),current.getMsg());
        BlogVideo video = blogVideoMapper.selectByPrimaryKey(videoVO.getVideoId());
        Preconditions.checkNotNull(video,"找不到指定的视频");
        Preconditions.checkState(video.getStatus()==1,"该视频已被删除或已取消发布");
        Preconditions.checkState(current.getData().getUserId().equals(video.getAuthorId()),"无权限删除");
        BlogVideo blogVideo = POJOConverter.voToDO(videoVO);
        blogVideo.setId(videoVO.getVideoId());
        return blogVideoMapper.updateByPrimaryKeySelective(blogVideo);
    }

    @Override
    public VideoVO getVideo(Integer videoId) {
        BlogVideo video = blogVideoMapper.selectByPrimaryKey(videoId);
        Preconditions.checkNotNull(video,"找不到指定的文章");
        Preconditions.checkState(video.getStatus()==1,"该视频已被删除或已取消发布");
        try{
            BlogVideo blogVideo = new BlogVideo();
            blogVideo.setId(videoId);
            blogVideo.setViews(video.getViews() + 1);
            blogVideoMapper.updateByPrimaryKeySelective(blogVideo);
        }catch (Exception ignored){}
        return POJOConverter.doToVO(video);
    }

    @Override
    public List<VideoVO> getArticleList(VideoQuery videoQuery) {
        RowBounds bounds = new RowBounds(videoQuery.getOffset(),videoQuery.getLimit());
        BlogVideoExample example = new BlogVideoExample();
        BlogVideoExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        if(!StringUtils.isNullOrEmpty(videoQuery.getKeyword())){
            criteria.andTitleLike(videoQuery.getKeyword());
        };
        example.setOrderByClause("gmt_modified desc");
        List<BlogVideo> blogVideos = blogVideoMapper.selectByExampleWithBLOBsWithRowbounds(example, bounds);
        ArrayList<VideoVO> list = new ArrayList<>();
        for (BlogVideo vdo : blogVideos){
            list.add(POJOConverter.doToVO(vdo));
        }
        return list;
    }
}

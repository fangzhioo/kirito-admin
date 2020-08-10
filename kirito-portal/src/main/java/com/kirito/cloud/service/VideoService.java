package com.kirito.cloud.service;

import com.kirito.cloud.portal.pojo.query.VideoQuery;
import com.kirito.cloud.portal.pojo.vo.VideoVO;

import java.util.List;

public interface VideoService {

    Integer createVideo(VideoVO videoVO);

    Integer removeVideo(Integer videoId);

    Integer updateVideo(VideoVO videoVO);

    VideoVO getVideo(Integer videoId);

    List<VideoVO> getArticleList(VideoQuery videoQuery);
}

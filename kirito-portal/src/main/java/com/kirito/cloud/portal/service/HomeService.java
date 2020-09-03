package com.kirito.cloud.portal.service;

import com.kirito.cloud.portal.domain.HomeContentResult;

/**
 * 首页内容管理Service
 * Created by macro on 2019/1/28.
 */
public interface HomeService {

    /**
     * 获取首页内容
     */
    HomeContentResult content();
}

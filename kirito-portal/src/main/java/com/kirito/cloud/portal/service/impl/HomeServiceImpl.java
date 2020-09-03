package com.kirito.cloud.portal.service.impl;

import com.kirito.cloud.portal.dao.HomeDao;
import com.kirito.cloud.portal.domain.HomeContentResult;
import com.kirito.cloud.portal.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 首页内容管理Service实现类
 * Created by macro on 2019/1/28.
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        return result;
    }

}

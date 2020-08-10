package com.kirito.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.kirito.cloud.portal.mapper")
public class MybatisConf {
    /**
     * http://mybatis.org/generator/reference/plugins.html
     * org.mybatis.generator.plugins.MapperAnnotationPlugin
     * 也可以用上面的插件自动添加@Mapper注解
     */
}

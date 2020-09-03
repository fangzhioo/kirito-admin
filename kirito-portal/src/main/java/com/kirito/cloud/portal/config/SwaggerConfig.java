package com.kirito.cloud.portal.config;

import com.kirito.cloud.common.config.BaseSwaggerConfig;
import com.kirito.cloud.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.kirito.cloud.portal.controller")
                .title("kirito前台系统")
                .description("kirito前台相关接口文档")
                .contactName("kirito")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}

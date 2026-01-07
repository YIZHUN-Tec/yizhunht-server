package com.yizhun.health.tech.module.promotion.framework.web.config;

import com.yizhun.health.tech.framework.swagger.config.YizhunhtSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * promotion 模块的 web 组件的 Configuration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class PromotionWebConfiguration {

    /**
     * promotion 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi promotionGroupedOpenApi() {
        return YizhunhtSwaggerAutoConfiguration.buildGroupedOpenApi("promotion");
    }

}

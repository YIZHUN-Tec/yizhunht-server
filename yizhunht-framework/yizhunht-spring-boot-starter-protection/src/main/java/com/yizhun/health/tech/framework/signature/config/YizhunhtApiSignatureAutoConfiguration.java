package com.yizhun.health.tech.framework.signature.config;

import com.yizhun.health.tech.framework.redis.config.YizhunhtRedisAutoConfiguration;
import com.yizhun.health.tech.framework.signature.core.aop.ApiSignatureAspect;
import com.yizhun.health.tech.framework.signature.core.redis.ApiSignatureRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * HTTP API 签名的自动配置类
 *
 * @author Zhougang
 */
@AutoConfiguration(after = YizhunhtRedisAutoConfiguration.class)
public class YizhunhtApiSignatureAutoConfiguration {

    @Bean
    public ApiSignatureAspect signatureAspect(ApiSignatureRedisDAO signatureRedisDAO) {
        return new ApiSignatureAspect(signatureRedisDAO);
    }

    @Bean
    public ApiSignatureRedisDAO signatureRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new ApiSignatureRedisDAO(stringRedisTemplate);
    }

}

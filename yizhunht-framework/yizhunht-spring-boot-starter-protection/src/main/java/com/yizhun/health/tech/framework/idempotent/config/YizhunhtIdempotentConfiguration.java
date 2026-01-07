package com.yizhun.health.tech.framework.idempotent.config;

import com.yizhun.health.tech.framework.idempotent.core.aop.IdempotentAspect;
import com.yizhun.health.tech.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.yizhun.health.tech.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.yizhun.health.tech.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.yizhun.health.tech.framework.idempotent.core.keyresolver.impl.UserIdempotentKeyResolver;
import com.yizhun.health.tech.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import com.yizhun.health.tech.framework.redis.config.YizhunhtRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = YizhunhtRedisAutoConfiguration.class)
public class YizhunhtIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public UserIdempotentKeyResolver userIdempotentKeyResolver() {
        return new UserIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}

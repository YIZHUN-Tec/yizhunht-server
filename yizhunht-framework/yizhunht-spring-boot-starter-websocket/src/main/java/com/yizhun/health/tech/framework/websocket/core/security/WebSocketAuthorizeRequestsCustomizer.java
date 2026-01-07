package com.yizhun.health.tech.framework.websocket.core.security;

import com.yizhun.health.tech.framework.security.config.AuthorizeRequestsCustomizer;
import com.yizhun.health.tech.framework.websocket.config.WebSocketProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

/**
 * WebSocket 的权限自定义
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
public class WebSocketAuthorizeRequestsCustomizer extends AuthorizeRequestsCustomizer {

    private final WebSocketProperties webSocketProperties;

    @Override
    public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
        registry.requestMatchers(webSocketProperties.getPath()).permitAll();
    }

}

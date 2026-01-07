package com.yizhun.health.tech.framework.datapermission.config;

import com.yizhun.health.tech.framework.common.biz.system.permission.PermissionCommonApi;
import com.yizhun.health.tech.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
import com.yizhun.health.tech.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import com.yizhun.health.tech.framework.security.core.LoginUser;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 基于部门的数据权限 AutoConfiguration
 *
 * @author 芋道源码
 */
@AutoConfiguration
@ConditionalOnClass(LoginUser.class)
@ConditionalOnBean(value = {DeptDataPermissionRuleCustomizer.class})
public class YizhunhtDeptDataPermissionAutoConfiguration {

    @Bean
    public DeptDataPermissionRule deptDataPermissionRule(PermissionCommonApi permissionApi,
                                                         List<DeptDataPermissionRuleCustomizer> customizers) {
        // 创建 DeptDataPermissionRule 对象
        DeptDataPermissionRule rule = new DeptDataPermissionRule(permissionApi);
        // 补全表配置
        customizers.forEach(customizer -> customizer.customize(rule));
        return rule;
    }

}

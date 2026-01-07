package com.yizhun.health.tech.module.report.dal.mysql.goview;

import com.yizhun.health.tech.framework.common.pojo.PageParam;
import com.yizhun.health.tech.framework.common.pojo.PageResult;
import com.yizhun.health.tech.framework.mybatis.core.mapper.BaseMapperX;
import com.yizhun.health.tech.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.yizhun.health.tech.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoViewProjectMapper extends BaseMapperX<GoViewProjectDO> {

    default PageResult<GoViewProjectDO> selectPage(PageParam reqVO, Long userId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GoViewProjectDO>()
                .eq(GoViewProjectDO::getCreator, userId)
                .orderByDesc(GoViewProjectDO::getId));
    }

}

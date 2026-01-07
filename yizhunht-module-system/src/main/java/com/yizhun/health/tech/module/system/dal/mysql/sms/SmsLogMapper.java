package com.yizhun.health.tech.module.system.dal.mysql.sms;

import com.yizhun.health.tech.framework.common.pojo.PageResult;
import com.yizhun.health.tech.framework.mybatis.core.mapper.BaseMapperX;
import com.yizhun.health.tech.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.yizhun.health.tech.module.system.controller.admin.sms.vo.log.SmsLogPageReqVO;
import com.yizhun.health.tech.module.system.dal.dataobject.sms.SmsLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsLogMapper extends BaseMapperX<SmsLogDO> {

    default PageResult<SmsLogDO> selectPage(SmsLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SmsLogDO>()
                .eqIfPresent(SmsLogDO::getChannelId, reqVO.getChannelId())
                .eqIfPresent(SmsLogDO::getTemplateId, reqVO.getTemplateId())
                .likeIfPresent(SmsLogDO::getMobile, reqVO.getMobile())
                .eqIfPresent(SmsLogDO::getSendStatus, reqVO.getSendStatus())
                .betweenIfPresent(SmsLogDO::getSendTime, reqVO.getSendTime())
                .eqIfPresent(SmsLogDO::getReceiveStatus, reqVO.getReceiveStatus())
                .betweenIfPresent(SmsLogDO::getReceiveTime, reqVO.getReceiveTime())
                .orderByDesc(SmsLogDO::getId));
    }

    default SmsLogDO selectByApiSerialNo(String apiSerialNo) {
        return selectOne(SmsLogDO::getApiSerialNo, apiSerialNo);
    }

}

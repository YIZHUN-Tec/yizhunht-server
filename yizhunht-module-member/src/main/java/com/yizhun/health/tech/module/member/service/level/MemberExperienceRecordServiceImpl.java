package com.yizhun.health.tech.module.member.service.level;

import cn.hutool.core.util.StrUtil;
import com.yizhun.health.tech.framework.common.pojo.PageParam;
import com.yizhun.health.tech.framework.common.pojo.PageResult;
import com.yizhun.health.tech.module.member.controller.admin.level.vo.experience.MemberExperienceRecordPageReqVO;
import com.yizhun.health.tech.module.member.convert.level.MemberExperienceRecordConvert;
import com.yizhun.health.tech.module.member.dal.dataobject.level.MemberExperienceRecordDO;
import com.yizhun.health.tech.module.member.dal.mysql.level.MemberExperienceRecordMapper;
import com.yizhun.health.tech.module.member.enums.MemberExperienceBizTypeEnum;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 会员经验记录 Service 实现类
 *
 * @author owen
 */
@Service
@Validated
public class MemberExperienceRecordServiceImpl implements MemberExperienceRecordService {

    @Resource
    private MemberExperienceRecordMapper experienceLogMapper;

    @Override
    public MemberExperienceRecordDO getExperienceRecord(Long id) {
        return experienceLogMapper.selectById(id);
    }

    @Override
    public PageResult<MemberExperienceRecordDO> getExperienceRecordPage(MemberExperienceRecordPageReqVO pageReqVO) {
        return experienceLogMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<MemberExperienceRecordDO> getExperienceRecordPage(Long userId, PageParam pageParam) {
         return experienceLogMapper.selectPage(userId, pageParam);
    }

    @Override
    public void createExperienceRecord(Long userId, Integer experience, Integer totalExperience,
                                       MemberExperienceBizTypeEnum bizType, String bizId) {
        String description = StrUtil.format(bizType.getDescription(), experience);
        MemberExperienceRecordDO record = MemberExperienceRecordConvert.INSTANCE.convert(
                userId, experience, totalExperience,
                bizId, bizType.getType(), bizType.getTitle(), description);
        experienceLogMapper.insert(record);
    }

}

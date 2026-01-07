package com.yizhun.health.tech.module.statistics.dal.mysql.trade;

import com.yizhun.health.tech.framework.mybatis.core.mapper.BaseMapperX;
import com.yizhun.health.tech.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.yizhun.health.tech.module.statistics.controller.admin.trade.vo.TradeTrendSummaryRespVO;
import com.yizhun.health.tech.module.statistics.dal.dataobject.trade.TradeStatisticsDO;
import com.yizhun.health.tech.module.statistics.service.trade.bo.TradeSummaryRespBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 交易统计 Mapper
 *
 * @author owen
 */
@Mapper
public interface TradeStatisticsMapper extends BaseMapperX<TradeStatisticsDO> {

    TradeSummaryRespBO selectOrderCreateCountSumAndOrderPayPriceSumByTimeBetween(@Param("beginTime") LocalDateTime beginTime,
                                                                                 @Param("endTime") LocalDateTime endTime);

    TradeTrendSummaryRespVO selectVoByTimeBetween(@Param("beginTime") LocalDateTime beginTime,
                                                  @Param("endTime") LocalDateTime endTime);

    default List<TradeStatisticsDO> selectListByTimeBetween(LocalDateTime beginTime, LocalDateTime endTime) {
        return selectList(new LambdaQueryWrapperX<TradeStatisticsDO>()
                .between(TradeStatisticsDO::getTime, beginTime, endTime));
    }

    Integer selectExpensePriceByTimeBetween(@Param("beginTime") LocalDateTime beginTime,
                                            @Param("endTime") LocalDateTime endTime);

    default TradeStatisticsDO selectByTimeBetween(LocalDateTime beginTime, LocalDateTime endTime) {
        return selectOne(new LambdaQueryWrapperX<TradeStatisticsDO>()
                .between(TradeStatisticsDO::getTime, beginTime, endTime));
    }

}

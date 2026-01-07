package com.yizhun.health.tech.module.pay.convert.wallet;

import com.yizhun.health.tech.framework.common.pojo.PageResult;
import com.yizhun.health.tech.module.pay.controller.admin.wallet.vo.transaction.PayWalletTransactionRespVO;
import com.yizhun.health.tech.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import com.yizhun.health.tech.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import com.yizhun.health.tech.module.pay.service.wallet.bo.WalletTransactionCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<PayWalletTransactionRespVO> convertPage2(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(WalletTransactionCreateReqBO bean);

}

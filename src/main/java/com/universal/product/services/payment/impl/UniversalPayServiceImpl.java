package com.universal.product.services.payment.impl;

import com.universal.product.config.payment.SignType;
import com.universal.product.config.payment.WxPayH5Config;
import com.universal.product.enums.payment.UniversalPayTypeEnum;
import com.universal.product.enums.payment.UniversalPayResultEnum;
import com.universal.product.exception.payment.UniversalPayException;
import com.universal.product.models.payment.PayRequest;
import com.universal.product.models.payment.PayResponse;
import com.universal.product.models.payment.RefundRequest;
import com.universal.product.models.payment.RefundResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UniversalPayServiceImpl extends AbstractComponent implements
    com.universal.product.services.payment.UniversalPayService {

    private WxPayH5Config wxPayH5Config;

    public void setWxPayH5Config(WxPayH5Config wxPayH5Config) {
        this.wxPayH5Config = wxPayH5Config;
    }

    @Override
    public PayResponse pay(PayRequest request) {
        //微信h5支付
        WxPayServiceImpl wxPayService = new WxPayServiceImpl();
        wxPayService.setWxPayH5Config(this.wxPayH5Config);

        return wxPayService.pay(request);
    }

    /**
     * 同步返回
     *
     * @param request
     * @return
     */
    public PayResponse syncNotify(HttpServletRequest request) {
        return null;
    }

    @Override
    public boolean verify(Map<String, String> toBeVerifiedParamMap, SignType signType, String sign) {
        return false;
    }

    /**
     * 异步回调
     *
     * @return
     */
    public PayResponse asyncNotify(String notifyData) {

        //微信h5支付
        WxPayServiceImpl wxPayService = new WxPayServiceImpl();
        wxPayService.setWxPayH5Config(this.wxPayH5Config);

        return wxPayService.asyncNotify(notifyData);
    }

    /**
     * 判断是什么支付类型(从同步回调中获取参数)
     *
     * @param request
     * @return
     */
    private UniversalPayTypeEnum payType(HttpServletRequest request) {
        //先判断是微信还是支付宝 是否是xml
        //支付宝同步还是异步
        if (request.getParameter("notify_type") == null) {
            //支付宝同步
            if (request.getParameter("exterface") != null && request.getParameter("exterface").equals("create_direct_pay_by_user")) {
                return UniversalPayTypeEnum.ALIPAY_PC;
            }
            if (request.getParameter("method") != null && request.getParameter("method").equals("alipay.trade.wap.pay.return")) {
                return UniversalPayTypeEnum.ALIPAY_WAP;
            }
        } else {
            //支付宝异步(发起支付时使用这个参数标识支付方式)
            String payType = request.getParameter("passback_params");
            return UniversalPayTypeEnum.getByCode(payType);
        }

        throw new UniversalPayException(UniversalPayResultEnum.PAY_TYPE_ERROR);
    }

    @Override
    public RefundResponse refund(RefundRequest request) {
        //微信h5支付
        WxPayServiceImpl wxPayService = new WxPayServiceImpl();
        wxPayService.setWxPayH5Config(this.wxPayH5Config);
        return wxPayService.refund(request);
    }
}

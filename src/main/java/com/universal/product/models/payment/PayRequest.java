package com.universal.product.models.payment;

import com.universal.product.enums.payment.UniversalPayTypeEnum;
import lombok.Data;
import org.simpleframework.xml.Default;

/**
 * 支付时请求参数
 */
@Data
public class PayRequest {

    /**
     * 支付方式.
     */
    private UniversalPayTypeEnum payTypeEnum;

    /**
     * 订单号.
     */
    private String orderId;

    /**
     * 订单金额.
     */
    private Double orderAmount;

    /**
     * 订单名字.
     */
    private String orderName;

    /**
     * 微信openid, 仅微信支付时需要
     */
    private String openid;

    /**
     * 客户端访问Ip  外部H5支付时必传，需要真实Ip
     */
    private String spbillCreateIp;

    public UniversalPayTypeEnum getPayTypeEnum() {
        return payTypeEnum;
    }

    public void setPayTypeEnum(UniversalPayTypeEnum payTypeEnum) {
        this.payTypeEnum = payTypeEnum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }
}

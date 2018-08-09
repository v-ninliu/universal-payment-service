package com.universal.product.models.payment;

import com.universal.product.enums.payment.UniversalPayTypeEnum;
import lombok.Data;

/**
 * 支付时请求参数
 */
@Data
public class RefundRequest {

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
}

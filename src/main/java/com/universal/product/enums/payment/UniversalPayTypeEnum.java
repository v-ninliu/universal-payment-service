package com.universal.product.enums.payment;

import com.universal.product.exception.payment.UniversalPayException;

/**
 * 支付方式
 * Created by null on 2017/2/14.
 */
public enum UniversalPayTypeEnum {

  ALIPAY_APP("alipay_app", "支付宝app"),

  ALIPAY_PC("alipay_pc", "支付宝pc"),

  ALIPAY_WAP("alipay_wap", "支付宝wap"),

  WXPAY_H5("wxpay_h5", "微信公众账号支付"),

  WXPAY_MWEB("MWEB", "微信公众账号支付"),
  ;

  private String code;

  private String name;

  UniversalPayTypeEnum(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public static UniversalPayTypeEnum getByCode(String code) {
    for (UniversalPayTypeEnum bestPayTypeEnum : UniversalPayTypeEnum
        .values()) {
      if (bestPayTypeEnum.getCode().equals(code)) {
        return bestPayTypeEnum;
      }
    }
    throw new UniversalPayException(UniversalPayResultEnum.PAY_TYPE_ERROR);
  }
}

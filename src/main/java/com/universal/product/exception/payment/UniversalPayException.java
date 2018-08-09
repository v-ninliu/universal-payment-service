package com.universal.product.exception.payment;

import com.universal.product.enums.payment.UniversalPayResultEnum;


public class UniversalPayException extends RuntimeException {

  private Integer code;

  public UniversalPayException(UniversalPayResultEnum resultEnum) {
    super(resultEnum.getMsg());
    code = resultEnum.getCode();
  }

  public Integer getCode() {
    return code;
  }
}

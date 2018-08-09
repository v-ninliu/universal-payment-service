package com.universal.product.services.payment;

import com.universal.product.config.payment.SignType;
import com.universal.product.models.payment.PayRequest;
import com.universal.product.models.payment.PayResponse;
import com.universal.product.models.payment.RefundRequest;
import com.universal.product.models.payment.RefundResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public interface IUniversalPayService {

  /**
   * pay
   */
  PayResponse pay(PayRequest request);

  /**
   * verify pay result.
   *
   * @param toBeVerifiedParamMap to be verified parameters.
   * @param signType sign type.
   * @param sign sign.
   * @return result.
   */
  boolean verify(Map<String, String> toBeVerifiedParamMap, SignType signType, String sign);

  /**
   * syncNotify
   */
  PayResponse syncNotify(HttpServletRequest request);

  /**
   * asyncNotify
   */
  PayResponse asyncNotify(String notifyData);

  /**
   * refund
   */
  RefundResponse refund(RefundRequest request);

}

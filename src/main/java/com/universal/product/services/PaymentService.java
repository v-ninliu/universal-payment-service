package com.universal.product.services;

import com.universal.product.enums.payment.UniversalPayTypeEnum;
import com.universal.product.models.payment.PayRequest;
import com.universal.product.models.payment.PayResponse;
import com.universal.product.services.payment.impl.UniversalPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import static java.lang.Double.parseDouble;

@Service public class PaymentService {

  @Autowired
  private UniversalPayService universalPayService;

  public String wechatPay(HttpServletRequest request, HttpServletResponse response) {
    try {
      String openid = request.getParameter("openid");
      String orderid = request.getParameter("orderid");
      String ordername = request.getParameter("ordername");
      String orderamount = request.getParameter("orderamount");

      PayRequest paymentRequest = new PayRequest();
      Random random = new Random();

      //set payment parameters
      paymentRequest.setPayTypeEnum(UniversalPayTypeEnum.WXPAY_H5);
      paymentRequest.setOrderId(orderid);
      paymentRequest.setOrderAmount(parseDouble(orderamount));
      paymentRequest.setOrderName(ordername);
      paymentRequest.setOpenid(openid);

      PayResponse payResponse = universalPayService.pay(paymentRequest);
      String res = payResponse.toString();
      return res;
    } catch (Exception e) {
      return e.getMessage();
    }
  }

}

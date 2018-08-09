package com.universal.product.controllers;

import com.universal.product.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired private PaymentService weChatPaymentService;


  /***
   * wechatPay - wechat pay
   * Request parameter:
   *
   *
   * Example: ....
   *
   * Note: .....
   *
   * @return
   */
  @RequestMapping(value = "/wechat/pay", method = RequestMethod.GET)
  public String wechatPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return weChatPaymentService.wechatPay(request, response);
  }

}

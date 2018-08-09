package com.universal.product.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.universal.product.config.payment.WxPayH5Config;
import com.universal.product.services.payment.impl.UniversalPayService;


@EnableAutoConfiguration
@Component
@EnableScheduling
@EnableAsync
public class AppConfiguration {

  // payment values
  @Value("${wechat.payment.mpappid}")
  private String mpappid;
  @Value("${wechat.payment.mchId}")
  private String mchId;
  @Value("${wechat.payment.mchKey}")
  private String mchKey;
  @Value("${wechat.payment.keyPath}")
  private String keyPath;
  @Value("${wechat.payment.notifyUrl}")
  private String notifyUrl;

  @Bean
  public WxPayH5Config wxPayH5Config() {
    WxPayH5Config wxPayH5Config = new WxPayH5Config();
    wxPayH5Config.setAppId(mpappid);
    wxPayH5Config.setMchId(mchId);
    wxPayH5Config.setMchKey(mchKey);
    wxPayH5Config.setKeyPath(keyPath);
    wxPayH5Config.setNotifyUrl(notifyUrl);
    return wxPayH5Config;
  }

  @Bean
  public UniversalPayService universalPayService(WxPayH5Config wxPayH5Config) {
    UniversalPayService universalPayService = new UniversalPayService();
    universalPayService.setWxPayH5Config(wxPayH5Config);
    return universalPayService;
  }

}


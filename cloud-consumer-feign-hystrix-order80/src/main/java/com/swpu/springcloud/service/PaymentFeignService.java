package com.swpu.springcloud.service;

import com.swpu.springcloud.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {
    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) ;

    @GetMapping("/payment/hystrix/get/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) ;

}

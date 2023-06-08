package com.swpu.springcloud.service.impl;

import com.swpu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        String msg="------PaymentFeignServiceImpl  paymentInfo_TimeOut ";
        return msg;
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        String msg="------PaymentFeignServiceImpl  paymentInfo_OK ";
        return msg;
    }

}

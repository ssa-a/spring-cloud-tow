package com.swpu.springcloud.controller;

import com.swpu.springcloud.entities.CommonResult;
import com.swpu.springcloud.entities.Payment;
import com.swpu.springcloud.service.PaymentOpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {
    @Autowired
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentOpenFeignService.getPaymentById(id);
    }

}

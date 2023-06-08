package com.swpu.springcloud.controller;

import com.swpu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OderController {
    public static final String PAYMENT_URL="http://nacos-payment-provider";

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        //return paymentService.getPayment(id);
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/nacos/"+id,String.class);
    }

}

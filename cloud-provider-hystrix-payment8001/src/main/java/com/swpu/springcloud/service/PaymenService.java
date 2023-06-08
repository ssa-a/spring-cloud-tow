package com.swpu.springcloud.service;


import org.springframework.web.bind.annotation.PathVariable;

public interface PaymenService {
    public String paymentInfo_OK(Integer id);
    public String paymentInfo_TimeOut(Integer id);
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}

package com.swpu.springcloud.service.impl;

import com.swpu.springcloud.entities.Payment;
import com.swpu.springcloud.mapper.PaymentMapper;
import com.swpu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    public int create(Payment payment){
        return  paymentMapper.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id){
        return paymentMapper.getPaymentById(id);
    }
}

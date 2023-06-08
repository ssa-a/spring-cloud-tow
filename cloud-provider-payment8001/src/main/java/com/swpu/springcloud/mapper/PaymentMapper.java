package com.swpu.springcloud.mapper;

import com.swpu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaymentMapper {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}

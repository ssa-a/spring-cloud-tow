package com.swpu.springcloud.controller;

import com.swpu.springcloud.entities.CommonResult;
import com.swpu.springcloud.entities.Payment;
import com.swpu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discovery")
    public DiscoveryClient discovery(){
        List<String> services = discoveryClient.getServices();  //获取eureka注册清单上所有的服务信息
        for (String service:services) {
            log.info("****element:"+service);   //这里返回的都是服务名称
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");//根据某个具体的服务名称获取实例
        for (ServiceInstance instance:instances) {
            //instance.getServiceId()：获取服务名id  instance.getHost()获取主机地址  instance.getPort()获取端口  instance.getUri()获取访问地址
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("插入成功"+result);
        if(result>0){
            return new CommonResult(200,"插入成功,serverPort="+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }



}

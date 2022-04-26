package com.njupt.controller;


import com.njupt.entity.CommentResult;
import com.njupt.entity.Payment;
import com.njupt.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/02/10:37
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/creat")
    public CommentResult creat(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("出入的结果为{}",result);
        if(result>0){
            return new CommentResult(200,"插入成功+端口号为："+serverPort,result);
        }else {
            return new CommentResult(444,"插入失败",result);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("出入的结果为{}",payment.toString());
        if(payment!=null){
            return new CommentResult(200,"查询成功成功端口号为"+serverPort,payment);
        }else {
            return new CommentResult(444,"没有对应的id",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for(String service:services ){
            log.info("查看所提供的服务{}",service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}

package com.njupt.controller;

import com.njupt.entity.CommentResult;
import com.njupt.entity.Payment;

import lombok.extern.slf4j.Slf4j;
import com.njupt.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/creat")
    public CommentResult creat(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("出入的结果为{}",result);
        if(result>0){
            return new CommentResult(200,"插入成功端口号为："+serverPort,result);
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
}

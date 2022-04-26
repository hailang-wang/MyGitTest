package com.njupt.controller;

import com.njupt.entity.CommentResult;
import com.njupt.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/02/11:41
 * @Description:
 */
@Slf4j
@RestController
public class OrderController {

    //单机版public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    /*为什么是get请求呢？因为客户端都是从浏览器发起请求，但是你调用时，可以采用post请求*/
    @GetMapping("/consumer/payment/create")
    public CommentResult<Payment> creat(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/creat",payment,CommentResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
    }
}

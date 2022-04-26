package com.njupt.service;

import com.njupt.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/02/10:33
 * @Description:
 */

public interface PaymentService {

    int creat(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}

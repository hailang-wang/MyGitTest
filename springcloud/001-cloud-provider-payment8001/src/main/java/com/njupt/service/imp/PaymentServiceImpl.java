package com.njupt.service.imp;

import com.njupt.dao.PaymentDao;
import com.njupt.entity.Payment;
import com.njupt.service.PaymentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/02/10:35
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    public int creat(Payment payment){
        return paymentDao.creat(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}

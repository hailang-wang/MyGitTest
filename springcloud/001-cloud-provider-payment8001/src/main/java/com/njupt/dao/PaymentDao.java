package com.njupt.dao;

import com.njupt.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/02/10:14
 * @Description:
 */
@Mapper
public interface PaymentDao {
    int creat(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}

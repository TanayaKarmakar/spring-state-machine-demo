package com.app.ssm.repository;

import com.app.ssm.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author t0k02w6 on 31/05/21
 * @project spring-state-machine-demo
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

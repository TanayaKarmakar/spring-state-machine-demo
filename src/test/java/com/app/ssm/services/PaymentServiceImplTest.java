package com.app.ssm.services;

import com.app.ssm.domain.Payment;
import com.app.ssm.domain.PaymentEvent;
import com.app.ssm.domain.PaymentState;
import com.app.ssm.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author t0k02w6 on 01/06/21
 * @project spring-state-machine-demo
 */
@SpringBootTest
class PaymentServiceImplTest {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);
        System.out.println("Should be NEW");
        System.out.println(savedPayment.getState());

        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.getById(savedPayment.getId());

        System.out.println("Should be PRE_AUTH or PRE_AUTH_ERROR");
        System.out.println(preAuthedPayment.getState());

        System.out.println(sm.getState().getId());
        System.out.println(preAuthedPayment);
    }

    @Test
    @Transactional
    void authorizePayment() {
        Payment savedPayment = paymentService.newPayment(payment);
        System.out.println("Should be NEW");
        System.out.println(savedPayment.getState());

        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.getById(savedPayment.getId());

        StateMachine<PaymentState, PaymentEvent> authSm = paymentService.authorizePayment(preAuthedPayment.getId());

        Payment authPayment = paymentRepository.getById(preAuthedPayment.getId());

        System.out.println("Should be AUTH or AUTH_ERROR");
        System.out.println(authPayment.getState());

        System.out.println(authSm.getState().getId());
        System.out.println(authPayment);
    }
}
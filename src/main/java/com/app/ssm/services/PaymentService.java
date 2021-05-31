package com.app.ssm.services;

import com.app.ssm.domain.Payment;
import com.app.ssm.domain.PaymentEvent;
import com.app.ssm.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

/**
 * @author t0k02w6 on 31/05/21
 * @project spring-state-machine-demo
 */
public interface PaymentService {
    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}

package com.app.ssm.config;

import com.app.ssm.domain.PaymentEvent;
import com.app.ssm.domain.PaymentState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.UUID;

/**
 * @author t0k02w6 on 31/05/21
 * @project spring-state-machine-demo
 */
@SpringBootTest
public class StateMachineConfigTest {
    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> factory;

    @Test
    void testNewStateMachine() {
        StateMachine<PaymentState, PaymentEvent> sm = factory.getStateMachine(UUID.randomUUID());

        sm.start();
        System.out.println(sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE);
        System.out.println(sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTH_APPROVED);
        System.out.println(sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTH_DECLINED);
        System.out.println(sm.getState().toString());
    }

}

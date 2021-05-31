package com.app.ssm.domain;

/**
 * @author t0k02w6 on 31/05/21
 * @project spring-state-machine-demo
 */
public enum PaymentEvent {
    PRE_AUTHORIZE, PRE_AUTH_APPROVED, PRE_AUTH_DECLINED, AUTHORIZE, AUTH_APPROVED, AUTH_DECLINED;
}

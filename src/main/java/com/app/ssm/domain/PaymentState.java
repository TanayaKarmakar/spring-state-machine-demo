package com.app.ssm.domain;

/**
 * @author t0k02w6 on 31/05/21
 * @project spring-state-machine-demo
 */
public enum PaymentState {
    NEW, PRE_AUTH, PRE_AUTH_ERROR, AUTH, AUTH_ERROR;
}

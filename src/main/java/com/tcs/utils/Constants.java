package com.tcs.utils;

import org.springframework.beans.factory.annotation.Value;

public class Constants {
    @Value("${login-service}")
    public static final String LOGIN_SERVICE = "LOGIN-SERVICE";
    @Value("${ui-service}")
    public static final String UI_SERVICE = "UI-SERVICE";
    @Value("${passbook-service}")
    public static final String PASSBOOK_SERVICE = "PASSBOOK-SERVICE";
    @Value("${transaction-service}")
    public static final String TRANSACTION_SERVICE = "TRANSACTION-SERVICE";
}

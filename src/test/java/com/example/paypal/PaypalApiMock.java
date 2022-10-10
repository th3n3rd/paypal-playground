package com.example.paypal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;

@AutoConfigureWireMock(port = 0)
@TestPropertySource(
    properties = {
        "paypal.auth.client-id=test@example.com",
        "paypal.auth.secret=test",
        "paypal.client.url=http://localhost:${wiremock.server.port}",
    }
)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface PaypalApiMock {}

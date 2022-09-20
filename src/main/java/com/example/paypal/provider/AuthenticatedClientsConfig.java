package com.example.paypal.provider;

import okhttp3.Interceptor;
import org.springframework.context.annotation.Bean;

class AuthenticatedClientsConfig {
    @Bean
    Interceptor authentication(AuthClient authClient, PaypalProperties properties) {
        return new Authentication(authClient, properties.getAuth().getClientId(), properties.getAuth().getSecret());
    }
}

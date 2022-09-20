package com.example.paypal.provider;

import okhttp3.OkHttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PaypalProperties.class)
class ClientsConfig {

    @Bean
    @LoadBalanced
    OkHttpClient.Builder httpClientBuilder() {
        return new OkHttpClient.Builder();
    }
}

package com.example.paypal.provider;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "paypal")
public class PaypalProperties {

    private Auth auth = new Auth();

    @Data
    public class Auth {
        private String clientId;
        private String secret;
    }

}

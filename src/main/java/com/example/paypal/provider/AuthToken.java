package com.example.paypal.provider;

import lombok.Data;

@Data
public class AuthToken {
    private String accessToken;
    private int expiresIn;
}

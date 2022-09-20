package com.example.paypal;

import java.math.BigDecimal;
import java.util.Currency;
import lombok.Value;

@Value
class Amount {
    Currency currency;
    BigDecimal value;

    public static Amount of(String currencyCode, String value) {
        return new Amount(
            Currency.getInstance(currencyCode),
            new BigDecimal(value)
        );
    }
}

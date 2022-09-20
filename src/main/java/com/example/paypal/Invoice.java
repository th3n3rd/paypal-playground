package com.example.paypal;

import java.time.LocalDate;
import lombok.Value;

@Value
class Invoice {
    String status;
    String number;
    LocalDate date;
}

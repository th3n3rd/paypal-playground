package com.example.paypal;

import java.util.UUID;
import lombok.Value;

@Value
class Transaction {
    final UUID transactionId = UUID.randomUUID();
    String providerTransactionId;
    Amount amount;
}

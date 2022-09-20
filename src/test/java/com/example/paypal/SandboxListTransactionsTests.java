package com.example.paypal;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SandboxListTransactionsTests {

    @Autowired
    private ListTransactions listTransactions;

    @Test
    @SneakyThrows
    void listTransactions() {
        var transactions = listTransactions.apply("2022-09-01T00:00:00-0700", "2022-09-20T00:00:00-0700");
        assertThat(transactions).isNotEmpty();
        assertThat(transactions).hasSize(1);

        var amount = transactions.get(0).getAmount();
        assertThat(amount.getCurrency().getCurrencyCode()).isEqualTo("GBP");
        assertThat(amount.getValue()).isEqualByComparingTo("5000.0");
    }

}

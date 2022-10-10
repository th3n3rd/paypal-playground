package com.example.paypal;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@PaypalApiMock
@SpringBootTest
class ListTransactionsTests {

    @Autowired
    private ListTransactions listTransactions;

    @Test
    @SneakyThrows
    void listTransactions() {
        var transactions = listTransactions.apply("2014-07-01T00:00:00-0700", "2014-07-30T23:59:59-0700");
        assertThat(transactions).isNotEmpty();
        assertThat(transactions).hasSize(1);

        var firstTransaction = transactions.get(0);
        assertThat(firstTransaction.getProviderTransactionId()).isEqualTo("5TY05013RG002845M");

        var amount = firstTransaction.getAmount();
        assertThat(amount.getCurrency().getCurrencyCode()).isEqualTo("USD");
        assertThat(amount.getValue()).isEqualByComparingTo("465.00");
    }

}

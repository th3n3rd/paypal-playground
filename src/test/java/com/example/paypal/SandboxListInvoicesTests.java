package com.example.paypal;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SandboxListInvoicesTests {

    @Autowired
    private ListInvoices listInvoices;

    @Test
    @SneakyThrows
    void listTransactions() {
        var invoices = listInvoices.apply();
        assertThat(invoices).isNotEmpty();
        assertThat(invoices).hasSize(1);

        var invoice = invoices.get(0);
        assertThat(invoice.getStatus()).isEqualTo("SENT");
        assertThat(invoice.getNumber()).isEqualTo("0001");
        assertThat(invoice.getDate()).isEqualTo(LocalDate.parse("2022-09-20"));
    }

}

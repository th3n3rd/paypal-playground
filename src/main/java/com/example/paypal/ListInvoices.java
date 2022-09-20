package com.example.paypal;

import com.example.paypal.provider.InvoicingClient;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ListInvoices {

    private final InvoicingClient invoicingClient;

    @SneakyThrows
    List<Invoice> apply() {
        var invoices = invoicingClient.listInvoices().execute().body();

        return invoices.items
            .stream()
            .map(it -> new Invoice(
                it.status,
                it.detail.invoiceNumber,
                LocalDate.parse(it.detail.invoiceDate)
            ))
            .collect(Collectors.toList());
    }

}

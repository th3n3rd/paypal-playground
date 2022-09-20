package com.example.paypal;

import com.example.paypal.provider.TransactionSearchClient;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ListTransactions {

    private final TransactionSearchClient transactionSearchClient;

    @SneakyThrows
    List<Transaction> apply(String startDate, String endDate) {
        var transactions = transactionSearchClient.listTransactions(
            startDate,
            endDate
        ).execute().body();

        return transactions.transactionDetails
            .stream()
            .map(it -> new Transaction(
                it.transactionInfo.transactionId,
                Amount.of(
                    it.transactionInfo.transactionAmount.currencyCode,
                    it.transactionInfo.transactionAmount.value
                )
            ))
            .collect(Collectors.toList());
    }

}

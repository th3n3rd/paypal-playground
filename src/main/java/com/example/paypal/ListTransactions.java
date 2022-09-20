package com.example.paypal;

import com.example.paypal.provider.AuthClient;
import com.example.paypal.provider.PaypalProperties;
import com.example.paypal.provider.TransactionSearchClient;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Credentials;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ListTransactions {

    private final PaypalProperties paypalProperties;
    private final AuthClient authClient;
    private final TransactionSearchClient transactionSearchClient;

    @SneakyThrows
    List<Transaction> apply(String startDate, String endDate) {
        String authorisation = requestAuthorisation();

        var transactions = transactionSearchClient.listTransactions(
            authorisation,
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

    private String requestAuthorisation() throws IOException {
        var credentials = Credentials.basic(
            paypalProperties.getAuth().getClientId(),
            paypalProperties.getAuth().getSecret()
        );
        var accessToken = this.authClient.authenticate(credentials, "client_credentials").execute().body().getAccessToken();

        return "Bearer %s".formatted(accessToken);
    }
}

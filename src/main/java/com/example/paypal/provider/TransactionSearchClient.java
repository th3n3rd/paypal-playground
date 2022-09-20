package com.example.paypal.provider;

import org.springframework.cloud.square.retrofit.core.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@RetrofitClient(
    name = "paypal-transaction-search",
    url = "https://api-m.sandbox.paypal.com",
    configuration = AuthenticatedClientsConfig.class
)
public interface TransactionSearchClient {
    @GET("/v1/reporting/transactions")
    Call<Transactions> listTransactions(
        @Query("start_date") String startDate,
        @Query("end_date") String endDate
    );
}

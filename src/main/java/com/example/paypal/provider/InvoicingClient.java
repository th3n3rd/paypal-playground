package com.example.paypal.provider;

import org.springframework.cloud.square.retrofit.core.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;

@RetrofitClient(
    name = "paypal-invoicing",
    url = "${paypal.client.url}",
    configuration = AuthenticatedClientsConfig.class
)
public interface InvoicingClient {

    @GET("/v2/invoicing/invoices")
    Call<Invoices> listInvoices();
}


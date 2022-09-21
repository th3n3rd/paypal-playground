package com.example.paypal.provider;

import org.springframework.cloud.square.retrofit.core.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

@RetrofitClient(name = "paypal-auth", url = "https://api-m.sandbox.paypal.com")
interface AuthClient {

    @POST("v1/oauth2/token")
    @FormUrlEncoded
    Call<AuthToken> authenticate(@Header("Authorization") String authorisation, @Field("grant_type") String grantType);
}

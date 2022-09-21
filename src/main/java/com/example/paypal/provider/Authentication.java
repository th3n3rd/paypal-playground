package com.example.paypal.provider;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
class Authentication implements Interceptor {

    private final AuthClient authClient;
    private final String clientId;
    private final String secret;

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        var original = chain.request();
        if (containsAccessToken(original)) {
            return chain.proceed(original);
        }
        return chain.proceed(withAccessToken(original));
    }

    private static boolean containsAccessToken(Request original) {
        return original.header("Authorization") != null;
    }

    private Request withAccessToken(Request original) {
        return original
            .newBuilder()
            .addHeader("Authorization", accessTokenBearer())
            .build();
    }

    @SneakyThrows
    private String accessTokenBearer() {
        var accessToken = authClient
            .authenticate(Credentials.basic(clientId, secret), "client_credentials")
            .execute()
            .body()
            .accessToken;

        return "Bearer %s".formatted(accessToken);
    }
}

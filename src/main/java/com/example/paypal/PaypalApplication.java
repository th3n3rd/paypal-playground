package com.example.paypal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.square.retrofit.EnableRetrofitClients;

@EnableRetrofitClients
@SpringBootApplication
public class PaypalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaypalApplication.class, args);
	}

}

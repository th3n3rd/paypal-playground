package com.example.paypal.provider;

import java.util.List;

public class Transactions {
    public List<Detail> transactionDetails;

    public static class Detail {
        public Info transactionInfo;
    }

    public static class Info {
        public String transactionId;
        public Amount transactionAmount;
    }

    public static class Amount {
        public String currencyCode;
        public String value;
    }
}

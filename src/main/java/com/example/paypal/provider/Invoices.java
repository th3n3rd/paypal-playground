package com.example.paypal.provider;

import java.util.List;

public class Invoices {
    public List<Item> items;

    public static class Item {
        public String status;
        public Detail detail;
    }

    public static class Detail {
        public String invoiceNumber;
        public String invoiceDate;
    }
}

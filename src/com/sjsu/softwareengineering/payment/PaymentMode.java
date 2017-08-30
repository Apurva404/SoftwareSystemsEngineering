package com.sjsu.softwareengineering.payment;

/**
 * Created by Apurva on 8/4/2017.
 */
public enum PaymentMode {
    Cash("Cash"),
    CreditCard("Credit Card"),
    DebitCard("Debit Card");

    private String name;

    private PaymentMode(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}


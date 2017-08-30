package com.sjsu.softwareengineering.payment;

import com.sjsu.softwareengineering.order.Bill;

/**
 * Created by Apurva on 8/4/2017.
 */
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void payBill(Bill bill) {
        System.out.println("Bill of amount $" + bill.computeTotalBill() + " paid using credit card");
    }
}

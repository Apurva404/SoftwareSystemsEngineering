package com.sjsu.softwareengineering.payment;


import com.sjsu.softwareengineering.order.Bill;
import com.sjsu.softwareengineering.people.Customer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Apurva on 8/4/2017.
 */
public class PaymentProcessor {
    private PaymentStrategy strategy;
    private static Map<PaymentMode, PaymentStrategy> mPaymentStrategyMap;

    static {
        mPaymentStrategyMap = new HashMap<>();
        mPaymentStrategyMap.put(PaymentMode.Cash, new CashPaymentStrategy());
        mPaymentStrategyMap.put(PaymentMode.CreditCard, new CreditCardPaymentStrategy());
        mPaymentStrategyMap.put(PaymentMode.DebitCard, new DebitCardPaymentStrategy());
    }

    public PaymentProcessor(){}

    public void processPayment(Bill bill, PaymentMode paymentMode){
        PaymentStrategy strategy = mPaymentStrategyMap.get(paymentMode);
        strategy.payBill(bill);
    }
}

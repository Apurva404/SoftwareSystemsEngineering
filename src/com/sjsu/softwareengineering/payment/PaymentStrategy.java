package com.sjsu.softwareengineering.payment;

import com.sjsu.softwareengineering.order.Bill;

/**
 * Created by Apurva on 8/4/2017.
 */
public interface PaymentStrategy {
    public void payBill(Bill bill);
}

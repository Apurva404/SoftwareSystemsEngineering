package com.sjsu.softwareengineering.people;

import com.sjsu.softwareengineering.order.Order;
import com.sjsu.softwareengineering.payment.PaymentMode;

public class Customer extends Person {
    protected Order mAssociatedOrder;
    protected int mPartySize;
    protected PaymentMode mPaymentMode;

    public Customer(String name) {
        super(name);
        mAssociatedOrder = null;
        mPartySize = 0;
        mPaymentMode = null;
    }

    public Order getAssociatedOrders() {return mAssociatedOrder;}

    public void setAssociatedOrders(Order order) {
        mAssociatedOrder = order;
    }

    public PaymentMode getPaymentMode() {
        return mPaymentMode;
    }

    public void setPaymentMode(PaymentMode modeOfPayment) {
        mPaymentMode = modeOfPayment;
    }

    public int getPartySize() {
        return mPartySize;
    }

    public void setPartySize(int size) {
        mPartySize = size;
    }
}

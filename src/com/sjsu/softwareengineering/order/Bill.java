package com.sjsu.softwareengineering.order;

public interface Bill {
    public double computeTotalBill();
    public String listBilledItems();
    public String listItemizedBill();
}

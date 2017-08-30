package com.sjsu.softwareengineering.order;

public class EmptyBill implements Bill
{
    public EmptyBill() {}

    @Override
    public double computeTotalBill() {
        return 0.0;
    }

    @Override
    public String listBilledItems() {
        return "";
    }

	@Override
	public String listItemizedBill() {
		return "";
	}
}

package com.sjsu.softwareengineering.order;

import com.sjsu.softwareengineering.menu.food.FoodItem;

/**
 * Created by Apurva on 8/3/2017.
 */
public class EmptyBillDecorator implements Bill  {
    protected FoodItem mItem;
    protected int mQuantity;
    protected Bill mCurrentBill;

    public EmptyBillDecorator(Bill currentBill, FoodItem newItem, int orderedQuantityOfItem) {
        mCurrentBill = currentBill;
        mItem = newItem;
        mQuantity = orderedQuantityOfItem;
    }

    @Override
    public double computeTotalBill() {
        return (mQuantity * mItem.getPrice()) + mCurrentBill.computeTotalBill();
    }

    @Override
    public String listBilledItems() {
        return mItem.getDescription() + "\t Quantity : " + mQuantity + "\n" + mCurrentBill.listBilledItems();
    }

	@Override
	public String listItemizedBill() {
		return ( "Item : " + mItem.getDescription() + 
				"\t Quantity : " + mQuantity +
				"\t Cost = $" + (mQuantity * mItem.getPrice()) +
				"\n" + mCurrentBill.listItemizedBill());
	}
}

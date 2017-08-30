package com.sjsu.softwareengineering.order;

import com.sjsu.softwareengineering.menu.food.FoodItem;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private String mOrderId;
    private Map<FoodItem, Integer> mFoodItems;
    private Map<FoodItem, Integer> mFoodItemsNotServed;

    public Order(String orderId){
        mOrderId = orderId;
        mFoodItems = new HashMap<>();
        mFoodItemsNotServed = new HashMap<>();
    }

    public void addItemsToOrder(Collection<FoodItem> items) {
        for(FoodItem item : items) {
            addItemToOrder(item);
        }
    }

    public void addItemToOrder(FoodItem item) {
        if (mFoodItems.containsKey(item)) {
            Integer quantity = mFoodItems.get(item);
            mFoodItems.put(item, quantity + 1);
        } else {
            mFoodItems.put(item, 1);
        }

        if (mFoodItemsNotServed.containsKey(item)) {
            Integer quantity = mFoodItemsNotServed.get(item);
            mFoodItemsNotServed.put(item, quantity + 1);
        } else {
            mFoodItemsNotServed.put(item, 1);
        }
    }

    public void removeItemFromOrder(FoodItem item) {
        if (mFoodItems.containsKey(item)) {
            Integer quantity = mFoodItems.get(item);
            if(quantity > 1)
                mFoodItems.put(item, quantity - 1);
            else
                mFoodItems.remove(item);
        }

        if (mFoodItemsNotServed.containsKey(item)) {
            Integer quantity = mFoodItemsNotServed.get(item);
            if(quantity > 1)
                mFoodItemsNotServed.put(item, quantity - 1);
            else
                mFoodItemsNotServed.remove(item);
        }
    }

    public void markItemServed(FoodItem item) {
        if (mFoodItemsNotServed.containsKey(item)) {
            Integer quantity = mFoodItemsNotServed.get(item);
            if(quantity > 1)
                mFoodItemsNotServed.put(item, quantity - 1);
            else
                mFoodItemsNotServed.remove(item);
        } else {
            System.out.println("All items of type " + item.getName() + " has been served.");
        }
    }

    public String getOrderId() {
        return mOrderId;
    }

    public Map<FoodItem, Integer> getOrderDetails() {
        return Collections.unmodifiableMap(mFoodItems);
    }

    public boolean isOrderComplete() {
        return mFoodItemsNotServed.isEmpty();
    }

    public Bill generateBill() {
        if(isOrderComplete()) {
            Bill bill = new EmptyBill();
            for (Map.Entry<FoodItem, Integer> entry : mFoodItems.entrySet()) {
                bill = new EmptyBillDecorator(bill, entry.getKey(), entry.getValue());
            }
            return bill;
        } else {
            System.out.println("All items have not been served yet. EmptyBillDecorator can't be generated.");
            return null;
        }
    }
}


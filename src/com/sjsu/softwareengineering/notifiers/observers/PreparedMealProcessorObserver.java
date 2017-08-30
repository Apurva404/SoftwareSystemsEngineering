package com.sjsu.softwareengineering.notifiers.observers;

import com.sjsu.softwareengineering.menu.food.FoodItem;

/**
 * Created by Apurva on 8/2/2017.
 */
public interface PreparedMealProcessorObserver {
    public void notifyMealIsPrepared(String orderId, FoodItem preparedItem);
}

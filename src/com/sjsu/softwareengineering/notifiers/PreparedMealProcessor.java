package com.sjsu.softwareengineering.notifiers;

import com.sjsu.softwareengineering.notifiers.observers.PreparedMealProcessorObserver;
import com.sjsu.softwareengineering.menu.food.FoodItem;

import java.util.HashSet;
import java.util.Set;

public class PreparedMealProcessor {
    private static PreparedMealProcessor sInstance;
    private Set<PreparedMealProcessorObserver> observers;

    private PreparedMealProcessor() {
        observers = new HashSet<>();
    }

    public static PreparedMealProcessor getInstance(){
        if(sInstance == null){
            sInstance = new PreparedMealProcessor();
        }
        return sInstance;
    }

    public void addObserver(PreparedMealProcessorObserver observer) {
        observers.add(observer);
    }

    public void markMealPrepared(String orderId, FoodItem preparedItem) {
        System.out.println("Preparation complete for Order Id : " + orderId + ", item : " + preparedItem.getName());
        for(PreparedMealProcessorObserver observer : observers) {
           observer.notifyMealIsPrepared(orderId, preparedItem);
        }
    }
}

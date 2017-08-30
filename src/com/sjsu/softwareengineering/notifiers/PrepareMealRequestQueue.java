package com.sjsu.softwareengineering.notifiers;

import com.sjsu.softwareengineering.notifiers.observers.PrepareMealRequestQueueObserver;
import com.sjsu.softwareengineering.menu.food.FoodItem;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PrepareMealRequestQueue {
    private static PrepareMealRequestQueue sInstance;

    private Queue<Pair<String, FoodItem>> mPendingMealQueue;
    private Set<PrepareMealRequestQueueObserver> observers;

    private PrepareMealRequestQueue() {
        mPendingMealQueue = new LinkedList<>();
        observers = new HashSet<>();
    }

    public static PrepareMealRequestQueue getInstance(){
        if(sInstance == null){
            sInstance = new PrepareMealRequestQueue();
        }
        return sInstance;
    }

    //method to placeRequest a new observer or subscriber
    public void addObserver(PrepareMealRequestQueueObserver observer) {
        observers.add(observer);
    }

    // method which notifies all observers(chef) that a new meal has been added to kitchen cooking queue
    public void placeRequest(String orderId, FoodItem itemToPrepare) {
        System.out.println("Order placed to kitchen for Order Id : " + orderId + ", item : " + itemToPrepare.getName());
        mPendingMealQueue.add(new Pair<>(orderId, itemToPrepare));
        for(PrepareMealRequestQueueObserver observer : observers) {
            observer.notifyRequestToCookItemAdded(orderId, itemToPrepare.getName());
        }
    }

    //Retrieves, but does not remove, the head (first element) of this list.
    public Pair<String, FoodItem> peek() {
        return mPendingMealQueue.peek();
    }

    //Retrieves and removes the head (first element) of this list.
    public Pair<String, FoodItem> poll() {
        return mPendingMealQueue.poll();
    }
}

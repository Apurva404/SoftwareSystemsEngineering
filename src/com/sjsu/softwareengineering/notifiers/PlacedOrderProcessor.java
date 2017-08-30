package com.sjsu.softwareengineering.notifiers;

import com.sjsu.softwareengineering.notifiers.observers.PlacedOrderProcessorObserver;
import com.sjsu.softwareengineering.order.Order;

import java.util.HashSet;
import java.util.Set;

public class PlacedOrderProcessor {
    private static PlacedOrderProcessor sInstance;
    private Set<PlacedOrderProcessorObserver> observers;

    private PlacedOrderProcessor() {
        observers = new HashSet<>();
    }

    public static PlacedOrderProcessor getInstance(){
        if(sInstance == null){
            sInstance = new PlacedOrderProcessor();
        }
        return sInstance;
    }

    public void addObserver(PlacedOrderProcessorObserver observer) {
        observers.add(observer);
    }

    public void placeOrder(String tableId, Order orderToPlace) {
        System.out.println("New Order placed, Order Id : " + orderToPlace.getOrderId() + " from table " + tableId);
        System.out.println("PlacedOrderProcessor : Notifying all observers");
        for(PlacedOrderProcessorObserver observer : observers) {
            observer.notifyOrderIsPlaced(tableId, orderToPlace);
        }
    }
}

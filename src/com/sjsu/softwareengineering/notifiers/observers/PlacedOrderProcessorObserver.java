package com.sjsu.softwareengineering.notifiers.observers;

import com.sjsu.softwareengineering.order.Order;

/**
 * Created by Apurva on 8/2/2017.
 */
public interface PlacedOrderProcessorObserver {
    void notifyOrderIsPlaced(String tableId, Order order);
}

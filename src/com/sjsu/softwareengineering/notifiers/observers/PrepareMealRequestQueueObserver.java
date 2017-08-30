package com.sjsu.softwareengineering.notifiers.observers;

/**
 * Created by Apurva on 8/2/2017.
 */
public interface PrepareMealRequestQueueObserver {
    public void notifyRequestToCookItemAdded(String orderId, String itemName);
}

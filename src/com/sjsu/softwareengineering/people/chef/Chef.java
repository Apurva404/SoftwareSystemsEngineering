package com.sjsu.softwareengineering.people.chef;
import com.sjsu.softwareengineering.menu.food.*;
import com.sjsu.softwareengineering.notifiers.PrepareMealRequestQueue;
import com.sjsu.softwareengineering.notifiers.PreparedMealProcessor;
import com.sjsu.softwareengineering.notifiers.observers.PrepareMealRequestQueueObserver;
import com.sjsu.softwareengineering.people.RestaurantEmployee;
import javafx.util.Pair;

public abstract class Chef extends RestaurantEmployee implements PrepareMealRequestQueueObserver {
    protected Class<? extends FoodItem> mSpeciality;

    public Chef(String name, String id) {
        super(name, id);
        mSpeciality = null;

        PrepareMealRequestQueue.getInstance().addObserver(this);
    }

    public Class<? extends FoodItem>  getSpeciality() { return mSpeciality; }

    protected abstract void prepareMeal(FoodItem itemToPrepare);

    @Override
    public void notifyRequestToCookItemAdded(String orderId, String itemName) {
        String orderIdFromQueue;
        FoodItem itemToPrepare;
        Pair<String, FoodItem> request = PrepareMealRequestQueue.getInstance().peek();
        if(request == null) {
            System.out.println("Chef " + mName + " can't prepare " + orderId + " item : " + itemName + ", someone else has already prepared it.");
            return;
        } else {
            orderIdFromQueue = request.getKey();
            itemToPrepare = request.getValue();
        }

        if(!orderId.equals(orderIdFromQueue)) {
            System.out.println("Chef " + mName + " can't prepare " + orderId + " item : " + itemName + ", someone else has already prepared it.");
            return;
        }

        if(mSpeciality.equals(request.getValue().getClass())) {
            // we need to make sure this chef doesn't poll the wrong item
            // possible problem with multiple chef with same specialty
            request = PrepareMealRequestQueue.getInstance().poll();

            prepareMeal(itemToPrepare);

            PreparedMealProcessor.getInstance().markMealPrepared(orderId, itemToPrepare);
        } else {
            System.out.println("Chef " + mName + " can't prepare " + itemToPrepare.getName());
        }
    }
}

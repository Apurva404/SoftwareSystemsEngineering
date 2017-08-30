package com.sjsu.softwareengineering.people;

import com.sjsu.softwareengineering.menu.food.FoodItem;
import com.sjsu.softwareengineering.notifiers.PrepareMealRequestQueue;
import com.sjsu.softwareengineering.notifiers.PreparedMealProcessor;
import com.sjsu.softwareengineering.notifiers.observers.PreparedMealProcessorObserver;
import com.sjsu.softwareengineering.order.Bill;
import com.sjsu.softwareengineering.order.Order;
import com.sjsu.softwareengineering.notifiers.PlacedOrderProcessor;
import com.sjsu.softwareengineering.notifiers.observers.PlacedOrderProcessorObserver;
import com.sjsu.softwareengineering.restaurant.Restaurant;
import com.sjsu.softwareengineering.restaurant.Table;
import com.sjsu.softwareengineering.restaurant.TableStatus;

import java.util.*;

public class Waiter extends RestaurantEmployee implements PlacedOrderProcessorObserver, PreparedMealProcessorObserver {
    private Map<String, Table> mAssociatedTables;
    private Map<String, Order> mOrderIdOrderAssociationMap;
    private Map<String, String> mTableIdOrderIdAssociationMap;
    private Map<String, String> mOrderIdTableIdAssociationMap;

    public Waiter(String name, String id) {
        super(name, id);
        mAssociatedTables = new HashMap<>();
        mOrderIdOrderAssociationMap = new HashMap<>();
        mTableIdOrderIdAssociationMap = new HashMap<>();
        mOrderIdTableIdAssociationMap = new HashMap<>();

        PlacedOrderProcessor.getInstance().addObserver(this);
        PreparedMealProcessor.getInstance().addObserver(this);
    }

    public Collection<Table> getAssociatedTables () { return mAssociatedTables.values(); }

    public void disassociateTable(Table table) {
        mAssociatedTables.remove(table.getTableId());
    }

    public Table seatCustomer(Customer customer) { // algorithm to assign best sized table to customer
        Collection<Table> tables = Restaurant.getInstance().getAllTables();
        Table candidateTable = null;
        int minExtraSeatingCapacityOTable = Integer.MAX_VALUE;
        for(Table table : tables) {
            if (table.getStatus().equals(TableStatus.VACANT)) {
                int extraSeatingCapacityOTable = table.getCapacity() - customer.getPartySize();
                if ((extraSeatingCapacityOTable >= 0) && (extraSeatingCapacityOTable < minExtraSeatingCapacityOTable)) {
                    minExtraSeatingCapacityOTable = extraSeatingCapacityOTable;
                    candidateTable = table;
                }
            }
        }

        if(candidateTable != null) {
            candidateTable.seatCustomer();
            mAssociatedTables.put(candidateTable.getTableId(), candidateTable);
        }

        return candidateTable;
    }
    

    public Bill generateBillForOrderId(String orderId) {
        Order order = mOrderIdOrderAssociationMap.get(orderId);
        if(order != null)
            return order.generateBill();
        else
            throw new IllegalArgumentException();
    }

    public Bill generateBillForTableId(String tableId) {
        String orderId = mTableIdOrderIdAssociationMap.get(tableId);
        return generateBillForOrderId(orderId);
    }

    @Override
    public void notifyOrderIsPlaced(String tableId, Order order) {
        if (mAssociatedTables.containsKey(tableId)) {
            System.out.println("Waiter " + mName + " is serving table " + tableId + ". Pushing items in order " + order.getOrderId() + " to kitchen");
            mOrderIdOrderAssociationMap.put(order.getOrderId(), order);
            mTableIdOrderIdAssociationMap.put(tableId, order.getOrderId());
            mOrderIdTableIdAssociationMap.put(order.getOrderId(), tableId);
            for(Map.Entry<FoodItem, Integer> entry : order.getOrderDetails().entrySet()) {
                for(int i=0; i<entry.getValue(); i++)
                    PrepareMealRequestQueue.getInstance().placeRequest(order.getOrderId(), entry.getKey());
            }
        } else {
            // print that this waiter is not serving the table
            System.out.println("Waiter " + mName + " is not serving table " + tableId);
        }
    }

    @Override
    public void notifyMealIsPrepared(String orderId, FoodItem preparedItem) {
        if(mOrderIdTableIdAssociationMap.containsKey(orderId)) {
            System.out.println("Waiter " + mName + " served " + preparedItem.getName() + " to table " + mOrderIdTableIdAssociationMap.get(orderId));
            Order order = mOrderIdOrderAssociationMap.get(orderId);
            order.markItemServed(preparedItem);
            if(order.isOrderComplete())
                System.out.println("Order " + orderId + " is now complete.");
        } else {
            // print that this server is not associated with this order
            System.out.println("Waiter " + mName + " is not serving order " + orderId);
        }
    }
}

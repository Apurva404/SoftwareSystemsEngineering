package com.sjsu.softwareengineering.restaurant;

public class Table {
    private String mTableId;
    private int mCapacity;
    private TableStatus mStatus;

    public Table(String tableId, int capacity) {
        mTableId = tableId;
        mCapacity = capacity;
        mStatus = TableStatus.VACANT;
    }

    public String getTableId() { return mTableId;}
    public int getCapacity() { return mCapacity;}
    public TableStatus getStatus() { return mStatus;}

    public void seatCustomer() {
        mStatus = TableStatus.OCCUPIED;
        System.out.println("Table : " + mTableId + " got Occupied");
    }

    public void emptyTable() {
        mStatus = TableStatus.NEED_CLEANING;
        System.out.println("Table : " + mTableId + " got empty and needs cleaning");
    }

    public void cleanTable() {
        mStatus = TableStatus.VACANT;
        System.out.println("Table : " + mTableId + " has been cleaned and is empty");
    }
}

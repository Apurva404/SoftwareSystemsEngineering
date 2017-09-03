package com.SJSU.SoftwareEngineering.enums;

/**
 * Created by Apurva on 7/24/2017.
 */
public enum PattyWeight {

    ONE_THIRD_POUND("1/3rd lb", 9.50),
    TWO_THIRD_POUND("2/3rd lb", 11.50),
    ONE_POUND("1 lb", 15.50);

    private double mCost;
private String mName;

    PattyWeight(String name, double cost)
    {
        mName = name;
        mCost = cost;
    }

    public double getCost()
    {
        return mCost;
    }

    @Override
    public String toString()
    {
        return mName;
    }
}

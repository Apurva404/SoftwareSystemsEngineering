package com.sjsu.softwareengineering.menu.food;

public abstract class FoodItem {
    protected String mName;
    protected double mPrice;

    public FoodItem() {
        mName = "";
        mPrice = 0.0;
    }

    public String getName() {
        return mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public String getDescription() {
        return mName + "($" + mPrice + ")";
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof FoodItem) {
            FoodItem other = (FoodItem) o;
            if(mName.equals(other.getName()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return mName.hashCode();
    }
}

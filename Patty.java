package com.SJSU.SoftwareEngineering.enums;

public enum Patty
{
    Beef("Beef"),
    Chicken("Chicken"),
    Turkey("Turkey"),
    Veggie("Veggie");

    private String mName;

    Patty(String name)
    {
        mName = name;
    }

    @Override
    public String toString()
    {
        return mName;
    }
}

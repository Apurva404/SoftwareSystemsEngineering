package com.SJSU.SoftwareEngineering.enums;

/**
 * Created by divyankithaRaghavaUrs on 7/24/17.
 */
public enum Container
{
    OnABun(0.00),
    InBowlWithLettuceBlend(1.00),
    InBowlWithOrganicMixedBeans(1.00);

    private double mCost;

    Container(double cost)
    {
        mCost = cost;
    }

    public double getCost()
    {
        return mCost;
    }
}

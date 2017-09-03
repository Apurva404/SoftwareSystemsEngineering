package com.SJSU.SoftwareEngineering.classes;

import com.SJSU.SoftwareEngineering.enums.Container;
import com.SJSU.SoftwareEngineering.enums.Patty;
import com.SJSU.SoftwareEngineering.enums.PattyWeight;
import com.SJSU.SoftwareEngineering.interfaces.Burger;

public class BasicBurger implements Burger
{
    Patty mPattyType;
    PattyWeight mPattyWeight;
    Container mContainerType;

    public BasicBurger(Patty pattyType, PattyWeight pattyWeight, Container container)
    {
        mPattyType = pattyType;
        mPattyWeight = pattyWeight;
        mContainerType = container;
    }

    @Override
    public String getDescription() {
        return (mPattyType + ", " + mPattyWeight + ", " + mContainerType);
    }

    @Override
    public double computeCost()
    {
      return (mPattyWeight.getCost() + mContainerType.getCost());
    }
}

package com.SJSU.SoftwareEngineering.classes;

import com.SJSU.SoftwareEngineering.enums.Cheese;
import com.SJSU.SoftwareEngineering.interfaces.Burger;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CheeseAddOn extends AddOnDecorator
{
    Set<Cheese> mCheeses;

    public CheeseAddOn(Burger burger, Collection<Cheese> cheeses)
    {
        super(burger);
        mCheeses = new HashSet<>();
        mCheeses.addAll(cheeses);
    }

    @Override
    public String getDescription() {
        return (mBurger.getDescription() + ", cheese(s) : " + mCheeses);
    }

    @Override
    public double computeCost()
    {
        double price = mBurger.computeCost();
        if(mCheeses.size() > 1)
        {
            price += ((mCheeses.size() - 1) * Cheese.COST_OF_ONE_CHEESE);
        }
        return price;
    }
}

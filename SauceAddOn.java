package com.SJSU.SoftwareEngineering.classes;

import com.SJSU.SoftwareEngineering.enums.Sauce;
import com.SJSU.SoftwareEngineering.interfaces.Burger;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by divyankithaRaghavaUrs on 7/24/17.
 */
public class SauceAddOn extends AddOnDecorator
{
    Set<Sauce> mSauces;

    public SauceAddOn(Burger burger, Collection<Sauce> sauces)
    {
        super(burger);
        mSauces= new HashSet<>();
        mSauces.addAll(sauces);
     }

    public String getDescription()
    {
        return (mBurger.getDescription() + " , sauces : " + mSauces);
    }

    @Override
    public double computeCost()
    {
        double price = mBurger.computeCost();
        if(mSauces.size() > 1)
            price += ((mSauces.size() - 1) * Sauce.COST_OF_ONE_SAUCE);

        return price;
    }
}

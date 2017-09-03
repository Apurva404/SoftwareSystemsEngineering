package com.SJSU.SoftwareEngineering.classes;

import com.SJSU.SoftwareEngineering.enums.GeneralTopping;
import com.SJSU.SoftwareEngineering.enums.PremiumTopping;
import com.SJSU.SoftwareEngineering.interfaces.Burger;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ToppingAddOn extends AddOnDecorator
{

    Set<GeneralTopping> mGeneralToppings;
    Set<PremiumTopping> mPremiumToppings;

    public ToppingAddOn(Burger burger, Collection<GeneralTopping> gToppings, Collection<PremiumTopping> pToppings)
    {
        super(burger);
        mGeneralToppings = new HashSet<>();
        mPremiumToppings = new HashSet<>();
        if(gToppings != null)
            mGeneralToppings.addAll(gToppings);
        if(pToppings != null)
            mPremiumToppings.addAll(pToppings);
    }
    public String getDescription() {
        return (mBurger.getDescription() + ", general toppings : " + mGeneralToppings + ", premium toppings : " + mPremiumToppings);
    }

    @Override
    public double computeCost()
    {
        double price = mBurger.computeCost();
        if(mGeneralToppings.size() > 4) {
            price += ((mGeneralToppings.size() - 4) * GeneralTopping.CODE_OF_ONE_GENERAL_TOPPING);
        }
        price += (mPremiumToppings.size() * PremiumTopping.COST_OF_ONE_PREMIUM_TOPPING);

        return price;
    }
}

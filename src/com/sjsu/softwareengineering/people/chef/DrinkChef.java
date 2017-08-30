package com.sjsu.softwareengineering.people.chef;

import com.sjsu.softwareengineering.menu.food.Drink;
import com.sjsu.softwareengineering.menu.food.FoodItem;

/**
 * Created by Apurva on 8/4/2017.
 */
public class DrinkChef extends Chef {
    public DrinkChef(String name, String id) {
        super(name, id);
        mSpeciality = Drink.class;
    }

    @Override
    protected void prepareMeal(FoodItem itemToPrepare) {
        // print that you have prepared the drink
        System.out.println("Chef " + mName + " prepared " + itemToPrepare.getName());
    }
}

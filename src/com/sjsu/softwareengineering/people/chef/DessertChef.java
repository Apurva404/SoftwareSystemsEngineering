package com.sjsu.softwareengineering.people.chef;

import com.sjsu.softwareengineering.menu.food.Dessert;
import com.sjsu.softwareengineering.menu.food.FoodItem;

/**
 * Created by Apurva on 8/4/2017.
 */
public class DessertChef extends Chef {
    public DessertChef(String name, String id) {
        super(name, id);
        mSpeciality = Dessert.class;
    }

    @Override
    protected void prepareMeal(FoodItem itemToPrepare) {
        // print that you have prepared the dessert
        System.out.println("Chef " + mName + " prepared " + itemToPrepare.getName());
    }
}

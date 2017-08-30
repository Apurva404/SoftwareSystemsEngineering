package com.sjsu.softwareengineering.people.chef;

import com.sjsu.softwareengineering.menu.food.Appetizer;
import com.sjsu.softwareengineering.menu.food.FoodItem;

/**
 * Created by Apurva on 8/4/2017.
 */
public class AppetizerChef extends Chef {

    public AppetizerChef(String name, String id) {
        super(name, id);
        mSpeciality = Appetizer.class;
    }

    @Override
    protected void prepareMeal(FoodItem itemToPrepare) {
        // print that you have prepared the appetizer
        System.out.println("Chef " + mName + " prepared " + itemToPrepare.getName());
    }
}

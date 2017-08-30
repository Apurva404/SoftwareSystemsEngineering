package com.sjsu.softwareengineering.people.chef;

import com.sjsu.softwareengineering.menu.food.Entree;
import com.sjsu.softwareengineering.menu.food.FoodItem;

/**
 * Created by Apurva on 8/4/2017.
 */
public class EntreeChef extends Chef {
    public EntreeChef(String name, String id) {
        super(name, id);
        mSpeciality = Entree.class;
    }

    @Override
    protected void prepareMeal(FoodItem itemToPrepare) {
        // print that you have prepared the entree
        System.out.println("Chef " + mName + " prepared " + itemToPrepare.getName());
    }
}

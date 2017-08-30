package com.sjsu.softwareengineering.menu.food;

import com.sjsu.softwareengineering.menu.catalog.AppetizerCatalog;

public class Appetizer extends FoodItem {
    public Appetizer(String name) {
        super();
        mName = name;
        mPrice = AppetizerCatalog.findByName(name).getCost();;
    }
}



package com.sjsu.softwareengineering.menu.food;

import com.sjsu.softwareengineering.menu.catalog.DessertCatalog;

public class Dessert extends FoodItem {
    public Dessert(String name) {
        super();
        mName = name;
        mPrice = DessertCatalog.findByName(name).getCost();
    }
}

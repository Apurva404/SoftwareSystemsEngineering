package com.sjsu.softwareengineering.menu.food;


import com.sjsu.softwareengineering.menu.catalog.DrinkCatalog;

public class Drink extends FoodItem {
    public Drink(String name) {
        super();
        mName = name;
        mPrice = DrinkCatalog.findByName(name).getCost();
    }
}


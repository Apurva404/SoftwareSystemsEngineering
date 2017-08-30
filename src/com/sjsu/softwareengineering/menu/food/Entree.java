package com.sjsu.softwareengineering.menu.food;

import com.sjsu.softwareengineering.menu.catalog.EntreeCatalog;

public class Entree extends FoodItem {
    public Entree(String name) {
       super();
       mName = name;
       mPrice = EntreeCatalog.findByName(name).getCost();
    }
}

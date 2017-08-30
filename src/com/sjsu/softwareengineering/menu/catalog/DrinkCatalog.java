package com.sjsu.softwareengineering.menu.catalog;


public enum DrinkCatalog
{
    Mojito("Mojito", 11.00),
    Martini("Martini", 12.00),
    PinaColada("Pina Colada", 10.00),
    Margarita("Margarita", 11.00),
    Coke("Coke", 3.00),
    DietCoke("Diet Coke", 3.00),
    Pepsi("Pepsi", 3.00),
    DietPepsi("Diet Pespi", 3.00),
    SevenUp("Seven Up", 3.00),
    Lemonade("Lemonade", 2.00);

    private double mCost;
    private String mName;

    DrinkCatalog(String name, double cost) {
        mName = name;
        mCost = cost;
    }

    public double getCost() {
        return mCost;
    }

    public String getName() {
        return mName;
    }

    public static DrinkCatalog findByName(String name) {
        for(DrinkCatalog drink : DrinkCatalog.values()) {
            if(drink.getName().equals(name))
                return drink;
        }
        throw new IllegalArgumentException();
    }
}

package com.sjsu.softwareengineering.menu.catalog;

public enum AppetizerCatalog
{
    FrenchFries("French Fries",5),
    StuffedMushroom("Stuffed Mushroom" ,8),
    MozzarellaSticks("Mozzarella Sticks",8),
    GarlicTwisters("Garlic Twisters", 10),
    CrabCake("Crab Cake",15),
    ChickenNuggets("Chicken Nuggets",9);

    private double cost;
    private String name;

    private AppetizerCatalog(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost()
    {
        return this.cost;
    }
    public String getName()
    {
        return this.name;
    }

    public static AppetizerCatalog findByName(String name) {
        for(AppetizerCatalog appetizer : AppetizerCatalog.values()) {
            if(appetizer.getName().equals(name))
                return appetizer;
        }
        throw new IllegalArgumentException();
    }
}
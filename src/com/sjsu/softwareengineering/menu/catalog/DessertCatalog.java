package com.sjsu.softwareengineering.menu.catalog;

public enum DessertCatalog
{
    ChocolateBrownie("Chocolate Brownie",10),
    WalnutBrownie("Walnut Brownie",12),
    Tiramisu("Tiramisu",15),
    NewYorkCheeseCake("NewYork Cheese Cake",15),
    BrownieSundae("Brownie Sundae",20);

    private double cost;
    private String name;

    private DessertCatalog(String name, double cost)
    {
        this.cost = cost;
        this.name = name;
    }

    public double getCost()
    {
        return this.cost;
    }

    public String getName()
    {
        return this.name;
    }

    public static DessertCatalog findByName(String name) {
        for(DessertCatalog dessert : DessertCatalog.values()) {
            if(dessert.getName().equals(name))
                return dessert;
        }
        throw new IllegalArgumentException();
    }
}
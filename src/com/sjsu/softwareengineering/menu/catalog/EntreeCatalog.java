package com.sjsu.softwareengineering.menu.catalog;

public enum EntreeCatalog {
    ChickenAlfredo("Chicken Alfredo",16),
    LobsterRavioli("Lobster Ravioli",20),
    MushroomRavioli("Mushroom Ravioli",10),
    EggplantParmesan("EggplantParmesan",12),
    Lasagna("Lasagna",16);

    private double cost;
    private String name;

    private EntreeCatalog(String name, double cost)
    {
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

    public static EntreeCatalog findByName(String name) {
        for(EntreeCatalog entree : EntreeCatalog.values()) {
            if(entree.getName().equals(name))
                return entree;
        }
        throw new IllegalArgumentException();
    }
}

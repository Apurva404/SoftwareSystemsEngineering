package com.sjsu.softwareengineering.menu.catalog;

public enum FoodItemCatalog {
    Mojito("Mojito",11),
    Martini("Martini",12),
    PinaColada("Pina Colada",10),
    Margarita("Margarita",11),
    Coke("Coke",3),
    DietCoke("Diet Coke",3),
    Pepsi("Pepsi",3),
    DietPepsi("Diet Pespi",3),
    SevenUp("Seven Up",3),
    Lemonade("Lemonade",2),
    FrenchFries("French Fries",5),
    StuffedMushroom("Stuffed Mushroom" ,8),
    MozzarellaSticks("Mozzarella Sticks",8),
    GarlicTwisters("Garlic Twisters", 10),
    CrabCake("Crab Cake",15),
    ChickenAlfredo("Chicken Alfredo",16),
    LobsterRavioli("Lobster Ravioli",20),
    MushroomRavioli("Mushroom Ravioli",10),
    EggplantParmesan("EggplantParmesan",12),
    Lasagna("Lasagna",16),
    ChickenNuggets("Chicken Nuggets",9),
    ChocolateBrownie("Chocolate Brownie",10),
    WalnutBrownie("Walnut Brownie",12),
    Tiramisu("Tiramisu",15),
    NewYorkCheeseCake("NewYork Cheese Cake",15),
    BrownieSundae("Brownie Sundae",20);

    private double cost;
    private String name;

    private FoodItemCatalog(String name, double cost)
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
}

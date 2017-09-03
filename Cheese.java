package com.SJSU.SoftwareEngineering.enums;

public enum Cheese
{
    DanishBlueCheese("Danish Blue Cheese"),
    HorseradishCheddar("Horse Radish Cheddar"),
    SoftRipenedBrie("Soft Ripened Brie"),
    GreekFeta("Greek Feta"),
    ImportedSwiss("Imported Swiss"),
    TillmookCheddar("Tillmook Cheddar"),
    Gruyere("Gruyere"),
    GeneralToppingsJalapenoJack("General Toppings Jalepeo Jack"),
    YellowAmerican("Yellow American"),
    HerbGoatCheeseSpread("Herb Goat Cheese Spread"),
    SharpProvolone("Sharp Provolone");

    public static double COST_OF_ONE_CHEESE = 1.00;
    private String mName;

    Cheese(String name)
    {
        mName = name;
    }

    @Override
    public String toString()
    {
        return mName;
    }
}

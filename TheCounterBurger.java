package com.SJSU.SoftwareEngineering.test;

import com.SJSU.SoftwareEngineering.classes.BasicBurger;
import com.SJSU.SoftwareEngineering.classes.CheeseAddOn;
import com.SJSU.SoftwareEngineering.classes.SauceAddOn;
import com.SJSU.SoftwareEngineering.classes.ToppingAddOn;
import com.SJSU.SoftwareEngineering.enums.*;
import com.SJSU.SoftwareEngineering.interfaces.Burger;

import java.util.HashSet;
import java.util.Set;


public class TheCounterBurger
{

    public static void main(String args[])
    {
        //creating the step 1 of burger
        System.out.println("THE COUNTER BURGER \n----------------------------------- ");
        System.out.println( "Step #1:Choose a patty, patty weight and conatiner");
        Burger burger = new BasicBurger(Patty.Beef, PattyWeight.ONE_THIRD_POUND, Container.OnABun);
        System.out.println("Burger details after completing step 1:");
        System.out.println(burger.getDescription() + " = " + burger.computeCost() + "$");

        // creating the step 2 of burger
        System.out.println( "Step #2:Choose a Cheese(Extra cheese + $1.00)");
        Set<Cheese> cheeses = new HashSet<>();
        cheeses.add(Cheese.DanishBlueCheese);
        cheeses.add(Cheese.HorseradishCheddar);
        burger = new CheeseAddOn(burger,cheeses);
        System.out.println("Burger details after completing step 2:");
        System.out.println(burger.getDescription() + " = " + burger.computeCost()+ "$");

        // creating the step 2 of burger
        System.out.println( "Step #3:Choose upto 4 topping(Extra general topping + $.75,Premium topping per selection+ $1.50)");
        Set<GeneralTopping> generalToppings = new HashSet<>();
        generalToppings.add(GeneralTopping.BermudaRedOnion);
        generalToppings.add(GeneralTopping.BlackOlives);
        generalToppings.add(GeneralTopping.CarrotStrings);
        generalToppings.add(GeneralTopping.Coleslaw);


        Set<PremiumTopping> premiumToppings = new HashSet<>();
        premiumToppings.add(PremiumTopping.ApplewoodSmokedBacon);
        burger = new ToppingAddOn(burger, generalToppings, premiumToppings);
        System.out.println("Burger details after completing step 3:");
        System.out.println(burger.getDescription() + " = " + burger.computeCost() + "$");

        // creating the step 4 of burger
        System.out.println( "Step #4:Choose a Sauce(Extra sauce + $0.75)");
        Set<Sauce> sauces = new HashSet<>();
        sauces.add(Sauce.ApricotSauce);
        burger = new SauceAddOn(burger, sauces);
        System.out.println("Burger details after completing step 4:");
        System.out.println(burger.getDescription() + " = " + burger.computeCost()+ "$");
    }
}

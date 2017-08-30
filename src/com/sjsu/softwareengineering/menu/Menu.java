package com.sjsu.softwareengineering.menu;

import com.sjsu.softwareengineering.menu.catalog.AppetizerCatalog;
import com.sjsu.softwareengineering.menu.catalog.DessertCatalog;
import com.sjsu.softwareengineering.menu.catalog.DrinkCatalog;
import com.sjsu.softwareengineering.menu.catalog.EntreeCatalog;
import com.sjsu.softwareengineering.menu.food.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static Menu sInstance;

    private List<Drink> mDrinkMenu;
    private List<Appetizer> mAppetizerMenu;
    private List<Entree> mEntreeMenu;
    private List<Dessert> mDessertMenu;

    private Menu(){
        mDrinkMenu = new ArrayList<>();
        mAppetizerMenu = new ArrayList<>();
        mEntreeMenu = new ArrayList<>();
        mDessertMenu = new ArrayList<>();
    }

    public static Menu getInstance(){
        if(sInstance == null){
            sInstance = new Menu();
            sInstance.createMenu();
        }
        return sInstance;
    }

    private void createMenu(){
        for(DrinkCatalog catalogedDrink : DrinkCatalog.values()) {
            Drink drink = new Drink(catalogedDrink.getName());
            mDrinkMenu.add(drink);
        }

        for(AppetizerCatalog catalogedAppetizer : AppetizerCatalog.values()) {
            Appetizer appetizer = new Appetizer(catalogedAppetizer.getName());
            mAppetizerMenu.add(appetizer);
        }

        for(EntreeCatalog catalogedEntree : EntreeCatalog.values()) {
            Entree entree = new Entree(catalogedEntree.getName());
            mEntreeMenu.add(entree);
        }

        for(DessertCatalog catalogedDessert : DessertCatalog.values()) {
            Dessert dessert = new Dessert(catalogedDessert.getName());
            mDessertMenu.add(dessert);
        }
    }

    public void addFoodItemToMenu() {
    	//TODO: owner can add new item
    }

    public void removeFoodItemToMenu(){
    	// TODO: owner can remove item from menu
    }

    public void updateFoodItemInMenu(FoodItem item, String Name, Double Cost){
    	//TODO: Owner can update a current menu item
    }

    public static Drink getDrinkByName(String drinkName) {
        for(Drink drink : sInstance.mDrinkMenu) {
            if(drink.getName().equals(drinkName))
                return drink;
        }
        throw new IllegalArgumentException();
    }

    public static Appetizer getAppetizerByName(String appetizerName) {
        for(Appetizer appetizer : sInstance.mAppetizerMenu) {
            if(appetizer.getName().equals(appetizerName))
                return appetizer;
        }
        throw new IllegalArgumentException();
    }

    public static Entree getEntreeByName(String entreeName) {
        for(Entree entree : sInstance.mEntreeMenu) {
            if(entree.getName().equals(entreeName))
                return entree;
        }
        throw new IllegalArgumentException();
    }

    public static Dessert getDessertByName(String dessertName) {
        for(Dessert dessert : sInstance.mDessertMenu) {
            if(dessert.getName().equals(dessertName))
                return dessert;
        }
        throw new IllegalArgumentException();
    }

    public void showMenu(){
        System.out.println("============Welcome to TestBench=============");
        System.out.println("============MENU=============");
        System.out.println("***DRINKS***");
        for(Drink drink : mDrinkMenu) {
            System.out.println(drink.getDescription());
        }
        System.out.println("=========================");
        System.out.println("***APPETIZERS***");
        for(Appetizer appetizer : mAppetizerMenu) {
            System.out.println(appetizer.getDescription());
        }
        System.out.println("=========================");
        System.out.println("***ENTREES***");
        for(Entree entree : mEntreeMenu) {
            System.out.println(entree.getDescription());
        }
        System.out.println("=========================");
        System.out.println("***DESSERT***");
        for(Dessert dessert : mDessertMenu) {
            System.out.println(dessert.getDescription());
        }
    }
}

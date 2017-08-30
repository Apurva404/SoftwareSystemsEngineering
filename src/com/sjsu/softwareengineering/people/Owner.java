package com.sjsu.softwareengineering.people;

public class Owner extends RestaurantEmployee {
    private static Owner sInstance;

    private Owner(String nameIn){
        super(nameIn, null);
    }

    public static Owner getInstance() throws InstantiationException {
        if(sInstance == null)
            throw new InstantiationException();
        else
            return sInstance;
    }

    public static Owner getInstance(String name){
        if(sInstance == null){
            sInstance = new Owner(name);
        }
        return sInstance;
    }

    public static Owner replaceOwner(String name) {
        if(sInstance == null)
            getInstance(name);
        else {
            sInstance = new Owner(name);
        }
        return sInstance;
    }
}

package com.SJSU.SoftwareEngineering.classes;

import com.SJSU.SoftwareEngineering.interfaces.Burger;

public abstract class AddOnDecorator implements Burger {
    protected Burger mBurger;

    public AddOnDecorator(Burger burger)
    {
        mBurger = burger;
    }
}

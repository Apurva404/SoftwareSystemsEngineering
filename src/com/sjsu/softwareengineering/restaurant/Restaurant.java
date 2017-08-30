package com.sjsu.softwareengineering.restaurant;

import com.sjsu.softwareengineering.menu.Menu;
import com.sjsu.softwareengineering.people.chef.Chef;
import com.sjsu.softwareengineering.people.Customer;
import com.sjsu.softwareengineering.people.Owner;
import com.sjsu.softwareengineering.people.Waiter;

import java.util.*;

/**
 * Created by Apurva on 8/3/2017.
 */
public class Restaurant {
    private Owner mOwner;
    private Set<Chef> mChefs;
    private Set<Waiter> mWaiters;
    private Set<Table> mTables;
    private Set<Customer> mCustomers;
    private Menu mMenu;
    
    private Restaurant() {
        mOwner = null;
        mChefs = new HashSet<>();
        mWaiters = new HashSet<>();
        mTables = new HashSet<>();
        mCustomers = new HashSet<>();
        mMenu = Menu.getInstance();
    }

    private static Restaurant sInstance;

    public static Restaurant getInstance() {
        if(sInstance == null) {
            sInstance = new Restaurant();
        }
        return sInstance;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public void assignOwner(Owner owner) {
        mOwner = owner;
    }

    public void addWaiter(Waiter waiter) {
        mWaiters.add(waiter);
    }

    public void addChef(Chef chef) {
        mChefs.add(chef);
    }

    public void addTable(Table table) {
        mTables.add(table);
    }

    public void addCustomer(Customer customer) {
        mCustomers.add(customer);
    }
    
    public Collection<Table> getAllTables() {
        return Collections.unmodifiableSet(mTables);
    }
    
    public void showMenu() {
    	mMenu.showMenu();
    }
    
    
}

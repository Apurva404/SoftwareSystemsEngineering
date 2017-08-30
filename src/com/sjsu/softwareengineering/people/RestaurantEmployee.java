package com.sjsu.softwareengineering.people;

/**
 * Created by Apurva on 8/3/2017.
 */
public class RestaurantEmployee extends Person {
    protected String mId;
    protected String mUsername;
    protected String mPassword;

    public RestaurantEmployee(String name, String id) {
        super(name);
        mId = id;
        mUsername = null;
        mPassword = null;
    }

    public String getId() { return mId; }
    public String getUsername() { return mUsername; }
    public String getPassword() { return mPassword;}

    public void setUsername(String username) {
        mUsername = username;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}

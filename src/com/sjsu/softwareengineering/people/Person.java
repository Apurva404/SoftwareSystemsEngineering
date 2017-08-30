package com.sjsu.softwareengineering.people;

public abstract class Person {
    protected String mName;
    protected String mEmailId;
    protected String mContactNo;

    public Person(String nameIn) {
        mName = nameIn;
        mEmailId = null;
        mContactNo = null;
    }

    public String getName() { return mName;}
    public String getEmailId() { return mEmailId;}
    public String getContactNo() { return mContactNo;}

    public void setEmailId(String emailId){
        this.mEmailId = emailId;
    }

    public void setContactNo(String contactNo) {
        this.mContactNo = contactNo;
    }
}

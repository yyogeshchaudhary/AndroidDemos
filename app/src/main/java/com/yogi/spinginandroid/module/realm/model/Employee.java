package com.yogi.spinginandroid.module.realm.model;

import io.realm.RealmObject;

/**
 * Created by ril on 5/6/16.
 */
public class Employee extends RealmObject{

    private int emloyeeID;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmloyeeID() {
        return emloyeeID;
    }

    public void setEmloyeeID(int emloyeeID) {
        this.emloyeeID = emloyeeID;
    }

}

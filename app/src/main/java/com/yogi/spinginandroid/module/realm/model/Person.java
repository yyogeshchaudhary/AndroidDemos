package com.yogi.spinginandroid.module.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by ril on 5/6/16.
 */
public class Person extends RealmObject {
    private String name;
    private String address;
    private String phoneNumber;
    private RealmList<Child> childs;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RealmList<Child> getChilds() {
        return childs;
    }

    public void setChilds(RealmList<Child> childs) {
        this.childs = childs;
    }
}

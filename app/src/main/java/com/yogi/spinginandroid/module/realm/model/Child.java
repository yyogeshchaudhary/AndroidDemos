package com.yogi.spinginandroid.module.realm.model;

import io.realm.RealmObject;

/**
 * Created by ril on 5/6/16.
 */
public class Child extends RealmObject {
    private int age;
    private String school;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}

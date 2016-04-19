package com.yogi.spinginandroid.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ril on 4/19/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    @JsonProperty
    private double speed;
    @JsonProperty
    private double deg;
}

package com.yogi.spinginandroid.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ril on 4/19/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {
    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }

    @JsonProperty
    private double all;
}

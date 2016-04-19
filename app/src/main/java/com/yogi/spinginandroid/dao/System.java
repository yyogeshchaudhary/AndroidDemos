package com.yogi.spinginandroid.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ril on 4/19/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class System {
    @JsonProperty
    private int type;
    @JsonProperty
    private int id;
    @JsonProperty
    private double message;
    @JsonProperty
    private String country;
    @JsonProperty
    private long sunrise;
    @JsonProperty
    private long sunset;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

}

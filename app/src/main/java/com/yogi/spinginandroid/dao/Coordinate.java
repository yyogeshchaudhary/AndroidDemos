package com.yogi.spinginandroid.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ril on 4/19/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinate {
    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @JsonProperty
    private double lon;
    @JsonProperty
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat(){
        return lat;
    }
}

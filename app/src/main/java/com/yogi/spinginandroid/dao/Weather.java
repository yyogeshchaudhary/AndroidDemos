package com.yogi.spinginandroid.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ril on 4/19/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @JsonProperty
    private int id;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty
    private String main;
    @JsonProperty
    private String description;
    @JsonProperty
    private String icon;

}

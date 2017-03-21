package com.example.edwardfouxvictorious.espressotest.model;

import android.support.annotation.VisibleForTesting;

import java.io.Serializable;

public class Earthquake implements Serializable {

    private String datetime;
    private double depth;
    private double lng;
    private String src;
    private String eqid;
    private double magnitude;
    private double lat;

    @VisibleForTesting
    public Earthquake(String datetime, double depth, double magnitude) {
        this.datetime = datetime;
        this.depth = depth;
        this.magnitude = magnitude;
    }

    public String getDatetime() {
        return datetime;
    }

    public double getDepth() {
        return depth;
    }

    public double getLng() {
        return lng;
    }

    public String getSrc() {
        return src;
    }

    public String getEqid() {
        return eqid;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "datetime='" + datetime + '\'' +
                ", depth=" + depth +
                ", lng=" + lng +
                ", src='" + src + '\'' +
                ", eqid='" + eqid + '\'' +
                ", magnitude=" + magnitude +
                ", lat=" + lat +
                '}';
    }
}

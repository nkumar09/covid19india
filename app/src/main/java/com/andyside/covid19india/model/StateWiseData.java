package com.andyside.covid19india.model;

import com.google.gson.annotations.SerializedName;

public class StateWiseData {

    @SerializedName("active")
    private String active;

    @SerializedName("confirmed")
	private String confirmed;

    @SerializedName("deaths")
    private String deaths;

    @SerializedName("deltaconfirmed")
    private String deltaConfirmed;

    @SerializedName("deltadeaths")
    private String deltaDeaths;

    @SerializedName("deltarecovered")
    private String deltaRecovered;

    @SerializedName("lastupdatedtime")
    private String lastUpdatedTime;

    @SerializedName("recovered")
    private String recovered;

    @SerializedName("state")
    private String state;

    @SerializedName("statecode")
    private String stateCode;

    public StateWiseData(String active, String confirmed, String deaths, String deltaConfirmed,
                         String deltaDeaths, String deltaRecovered, String lastUpdatedTime,
                         String recovered, String state, String stateCode) {
        this.active = active;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.deltaConfirmed = deltaConfirmed;
        this.deltaDeaths = deltaDeaths;
        this.deltaRecovered = deltaRecovered;
        this.lastUpdatedTime = lastUpdatedTime;
        this.recovered = recovered;
        this.state = state;
        this.stateCode = stateCode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(String deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public String getDeltaDeaths() {
        return deltaDeaths;
    }

    public void setDeltaDeaths(String deltaDeaths) {
        this.deltaDeaths = deltaDeaths;
    }

    public String getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(String deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}

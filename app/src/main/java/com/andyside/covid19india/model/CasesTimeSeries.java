package com.andyside.covid19india.model;

import com.google.gson.annotations.SerializedName;

public class CasesTimeSeries {

    @SerializedName("dailyconfirmed")
    private String dailyConfirmed;

    @SerializedName("dailydeceased")
    private String dailyDeceased;

    @SerializedName("dailyrecovered")
    private String dailyRecovered;

    @SerializedName("date")
    private String date;

    @SerializedName("totalconfirmed")
    private String totalConfirmed;

    @SerializedName("totaldeceased")
    private String totalDeceased;

    @SerializedName("totalrecovered")
    private String totalRecovered;

    public CasesTimeSeries(String dailyConfirmed, String dailyDeceased, String dailyRecovered,
                           String date, String totalConfirmed, String totalDeceased, String totalRecovered) {
        this.dailyConfirmed = dailyConfirmed;
        this.dailyDeceased = dailyDeceased;
        this.dailyRecovered = dailyRecovered;
        this.date = date;
        this.totalConfirmed = totalConfirmed;
        this.totalDeceased = totalDeceased;
        this.totalRecovered = totalRecovered;
    }

    public String getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(String dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public String getDailyDeceased() {
        return dailyDeceased;
    }

    public void setDailyDeceased(String dailyDeceased) {
        this.dailyDeceased = dailyDeceased;
    }

    public String getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(String dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getTotalDeceased() {
        return totalDeceased;
    }

    public void setTotalDeceased(String totalDeceased) {
        this.totalDeceased = totalDeceased;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }
}

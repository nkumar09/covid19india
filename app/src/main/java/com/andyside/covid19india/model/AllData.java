package com.andyside.covid19india.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class AllData {

    @SerializedName("cases_time_series")
    private CasesTimeSeries casesTimeSeries;

    @SerializedName("statewise")
    private StateWiseData stateWiseData;

    @SerializedName("tested")
    private TestedData testedData;

    public AllData(CasesTimeSeries casesTimeSeries, StateWiseData stateWiseData, TestedData testedData) {
        this.casesTimeSeries = casesTimeSeries;
        this.stateWiseData = stateWiseData;
        this.testedData = testedData;
    }

    public AllData() {

    }

    public static AllData fromJson(JSONObject jsonObject) {
        AllData allData = new AllData();
        try {
            allData.casesTimeSeries = (CasesTimeSeries) jsonObject.get("cases_time_series");
            allData.stateWiseData = (StateWiseData) jsonObject.get("statewise");
            allData.testedData = (TestedData) jsonObject.get("tested");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allData;
    }

    public CasesTimeSeries getCasesTimeSeries() {
        return casesTimeSeries;
    }

    public void setCasesTimeSeries(CasesTimeSeries casesTimeSeries) {
        this.casesTimeSeries = casesTimeSeries;
    }

    public StateWiseData getStateWiseData() {
        return stateWiseData;
    }

    public void setStateWiseData(StateWiseData stateWiseData) {
        this.stateWiseData = stateWiseData;
    }

    public TestedData getTestedData() {
        return testedData;
    }

    public void setTestedData(TestedData testedData) {
        this.testedData = testedData;
    }
}



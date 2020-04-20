package com.andyside.covid19india.model;

import org.json.JSONException;
import org.json.JSONObject;

public class AllDataList {

    private JSONObject allData;

    public AllDataList(String allData) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(allData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.allData = jsonObject;
    }

    public JSONObject getAllData() {

        return allData;
    }

    public void setAllData(String allData) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(allData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.allData = jsonObject;
    }
}

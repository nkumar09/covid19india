package com.andyside.covid19india.retrofit;

import com.andyside.covid19india.model.AllData;
import com.andyside.covid19india.model.AllDataList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkAPIService {

    @GET("data.json")
    Call<List<AllData>> getAllData();
}

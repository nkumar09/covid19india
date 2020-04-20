package com.andyside.covid19india.retrofit;

import com.andyside.covid19india.model.AllData;
import com.andyside.covid19india.model.AllDataList;

import java.util.List;

import retrofit2.Call;

public class NetworkAdapter {

    private static final String TAG = "NetworkAdapter";

    private static NetworkAdapter networkAdapter = null;

    private NetworkClient networkClient;

    public NetworkAdapter() {
        networkClient = new NetworkClient();
    }

    public static NetworkAdapter getInstance() {
        if (networkAdapter == null) {
            networkAdapter = new NetworkAdapter();
        }
        return networkAdapter;
    }

    public Call<List<AllData>> getAllData() {
        return networkClient.getApiService().getAllData();
    }
}

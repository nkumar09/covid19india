package com.andyside.covid19india;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andyside.covid19india.adapter.DistrictListAdapter;

import org.json.JSONException;
import org.json.JSONObject;

public class DistrictActivity extends AppCompatActivity {

    private static final String TAG = "DistrictActivity";

    RecyclerView recyclerView;
    DistrictListAdapter adapter;

    JSONObject mDistrictList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        Intent intent = getIntent();
        try {
            JSONObject dist_data = new JSONObject(intent.getStringExtra("district_details"));
            mDistrictList = dist_data.getJSONObject("districtData");
            Log.d(TAG, "onCreate: districts: " + mDistrictList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        initUI();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recycler_view);

        adapter = new DistrictListAdapter(this, mDistrictList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

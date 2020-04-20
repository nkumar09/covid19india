package com.andyside.covid19india;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andyside.covid19india.adapter.StateListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView mTotalConfirmed, mConfirmedAdded, mTotalActive, mTotalRecovered, mRecoveredAdded,
            mTotalDeceased, mDeceasedAdded, mOpenSource, mDate;

    ImageView mRefresh;

    JSONArray mStateList;

    RecyclerView mStateListRecycler;
    StateListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        mTotalConfirmed = findViewById(R.id.total_confirmed);
        mConfirmedAdded = findViewById(R.id.confirmed_added);
        mTotalActive = findViewById(R.id.total_active);
        mTotalRecovered = findViewById(R.id.total_recovered);
        mRecoveredAdded = findViewById(R.id.recovered_added);
        mTotalDeceased = findViewById(R.id.total_deceased);
        mDeceasedAdded = findViewById(R.id.deceased_added);
        mDate = findViewById(R.id.date);
        mOpenSource = findViewById(R.id.open_source);
        mRefresh = findViewById(R.id.refresh);
        mStateListRecycler = findViewById(R.id.recycler_statelist);

        mRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllData();
            }
        });

        mOpenSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.covid19india.org/"));
                startActivity(browserIntent);
            }
        });

        getAllData();

        adapter = new StateListAdapter(this, mStateList);
        mStateListRecycler.setLayoutManager(new LinearLayoutManager(this));
        mStateListRecycler.setAdapter(adapter);
    }

    private void getAllData() {
        try {
            Response response = new GetAllData().execute("https://api.covid19india.org/data.json").get();

            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(response.body().string());
                JSONArray jsonArray = jsonObject.getJSONArray("cases_time_series");
                mStateList = jsonObject.getJSONArray("statewise");
                Log.d(TAG, "getAllData: array: " + jsonArray);
                JSONObject last = mStateList.getJSONObject(0);

                int totalConfirmed = Integer.parseInt(last.getString("confirmed"));
                int dailyConfirmed = Integer.parseInt(last.getString("deltaconfirmed"));
                int dailyDeceased = Integer.parseInt(last.getString("deltadeaths"));
                int dailyRecovered = Integer.parseInt(last.getString("deltarecovered"));
                int totalDeceased = Integer.parseInt(last.getString("deaths"));
                int active = Integer.parseInt(last.getString("active"));
                int totalRecovered = totalConfirmed - (totalDeceased + active);
                String date = last.getString("lastupdatedtime");

                mTotalConfirmed.setText(String.valueOf(totalConfirmed));
                mConfirmedAdded.setText("[+" + dailyConfirmed + "]");
                mTotalActive.setText(String.valueOf(active));
                mTotalRecovered.setText(String.valueOf(totalRecovered));
                mRecoveredAdded.setText("[+" + dailyRecovered + "]");
                mTotalDeceased.setText(String.valueOf(totalDeceased));
                mDeceasedAdded.setText("[+" + dailyDeceased + "]");
                mDate.setText(date);
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            AllDataList dataList = new AllDataList(response.body().string());
//            AllData.fromJson(dataList.getAllData());

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class GetAllData extends AsyncTask<String, Void, Response> {

        @Override
        protected Response doInBackground(String... strings) {
            Response response = null;
            try {
                OkHttpClient client = new OkHttpClient().newBuilder().build();
                Request request = new Request.Builder()
                        .url(strings[0])
                        .method("GET", null)
                        .build();

                response = client.newCall(request).execute();

//                Log.d(TAG, "doInBackground: " + response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }
    }
}

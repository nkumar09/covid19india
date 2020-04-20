package com.andyside.covid19india.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andyside.covid19india.DistrictActivity;
import com.andyside.covid19india.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StateListAdapter extends RecyclerView.Adapter<StateListAdapter.StateListViewHolder> {

    private static final String TAG = "StateListAdapter";

    Context mContext;
    JSONArray mStatelist;

    DistrictListAdapter adapter;
    RecyclerView districtRecyclerView;

    public StateListAdapter(Context context, JSONArray statelist) {
        this.mContext = context;
        this.mStatelist = statelist;
    }

    @NonNull
    @Override
    public StateListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_state_list, parent, false);
        StateListViewHolder viewHolder = new StateListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StateListViewHolder holder, int position) {
        TextView mStateName = holder.mStateName;
        LinearLayout mStateLay = holder.mStateLay;
        TextView mStateConfirmed = holder.mStateConfirmed;
        TextView mStateActive = holder.mStateActive;
        TextView mStateRecovered = holder.mStateRecovered;
        TextView mStateDeceased = holder.mStateDeceased;
        final ImageView btn_toggle = holder.btn_toggle;

        try {
            JSONObject last = mStatelist.getJSONObject(position + 1);

            final String stateName = last.getString("state");
            String stateConfirmed = last.getString("confirmed");
            String stateActive = last.getString("active");
            String stateRecovered = last.getString("recovered");
            String stateDeceased = last.getString("deaths");

            mStateName.setText(stateName);
            mStateConfirmed.setText(stateConfirmed);
            mStateActive.setText(stateActive);
            mStateRecovered.setText(stateRecovered);
            mStateDeceased.setText(stateDeceased);

            Log.d(TAG, "onBindViewHolder: stateConfirmed: " + stateConfirmed);

            if (stateConfirmed.equals("0")) {
                btn_toggle.setVisibility(View.GONE);
            } else {
                btn_toggle.setVisibility(View.VISIBLE);
            }

            btn_toggle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: btn_toggle");
                    JSONObject district = getAllData(stateName);
                    Intent intent = new Intent(mContext, DistrictActivity.class);
                    intent.putExtra("district_details", district.toString());
                    mContext.startActivity(intent);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (mStatelist.length() > 0) {
            return mStatelist.length() - 1;
        } else {
            return 0;
        }
    }

    private JSONObject getAllData(String state) {
        Log.d(TAG, "getAllData: enter");
        JSONObject district = null;
        try {
            Response response = new GetAllData().execute("https://api.covid19india.org/state_district_wise.json").get();
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(response.body().string());
                district = jsonObject.getJSONObject(state);
                Log.d(TAG, "getAllData: district: " + district);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return district;
    }

    public class StateListViewHolder extends RecyclerView.ViewHolder {

        TextView mStateName, mStateConfirmed, mStateActive, mStateRecovered, mStateDeceased;
        LinearLayout mStateLay;

        ImageView btn_toggle;

        public StateListViewHolder(@NonNull View itemView) {
            super(itemView);

            this.mStateName = itemView.findViewById(R.id.state_name);
            this.mStateLay = itemView.findViewById(R.id.state_layout);
            this.mStateConfirmed = itemView.findViewById(R.id.state_confirmed);
            this.mStateActive = itemView.findViewById(R.id.state_active);
            this.mStateRecovered = itemView.findViewById(R.id.state_recovered);
            this.mStateDeceased = itemView.findViewById(R.id.state_deceased);
            this.btn_toggle = itemView.findViewById(R.id.bt_toggle);
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

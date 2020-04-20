package com.andyside.covid19india.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andyside.covid19india.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DistrictListAdapter extends RecyclerView.Adapter<DistrictListAdapter.DistrictListViewHolder> {

    private static final String TAG = "DistrictListAdapter";

    Context mContext;
    JSONObject mDistrictList;

    public DistrictListAdapter(Context mContext, JSONObject mDistrictList) {
        this.mContext = mContext;
        this.mDistrictList = mDistrictList;
    }

    @NonNull
    @Override
    public DistrictListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_district_list, parent, false);
        return new DistrictListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DistrictListViewHolder holder, int position) {
        TextView districtName = holder.districtName;
        TextView districtConfirmed = holder.districtConfirmed;
        TextView deltaConfirmed = holder.deltaConfirmed;

        JSONArray names = mDistrictList.names();
        try {
            String name = (String) names.get(position);
            String confirmed = mDistrictList.getJSONObject(name).getString("confirmed");
            String deltaConfirm = "[+" + mDistrictList.getJSONObject(name).getJSONObject("delta").getString("confirmed") + "]";

            Log.d(TAG, "onBindViewHolder: " + name);
            Log.d(TAG, "onBindViewHolder: " + confirmed);
            districtName.setText(name);
            districtConfirmed.setText(confirmed);
            deltaConfirmed.setText(deltaConfirm);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (mDistrictList.length() > 0) {
            return mDistrictList.length();
        } else {
            return 0;
        }
    }

    public class DistrictListViewHolder extends RecyclerView.ViewHolder {
        TextView districtName;
        TextView districtConfirmed;
        TextView deltaConfirmed;

        public DistrictListViewHolder(@NonNull View itemView) {
            super(itemView);

            districtName = itemView.findViewById(R.id.district_name);
            districtConfirmed = itemView.findViewById(R.id.district_confirmed);
            deltaConfirmed = itemView.findViewById(R.id.delta_confirmed);
        }
    }
}

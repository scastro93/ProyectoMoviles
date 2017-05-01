package com.example.scastro81.teamstec.Main.subFragmentTeam;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.scastro81.teamstec.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by scastro81 on 19/04/17.
 */

public class JSONAdapter extends BaseAdapter{

    private JSONArray data;
    private Activity activity;

    public JSONAdapter(JSONArray data, Activity activity){
        this.data = data;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.length();
    }

    @Override
    public Object getItem(int position) {
        try{
            return data.getJSONObject(position);
        }catch(JSONException j){
            j.printStackTrace();
        }

        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.row, null);
        }

        TextView name = (TextView)convertView.findViewById(R.id.textView);
        TextView desc = <TextView
        android:text="Name"
        android:layout_width="match_parent"
        android:layo<TextView
        android:text="Name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textView"
        android:textAppearance="@style/TextAppearance.AppCompat.Body2"
        android:textAlignment="center"
        android:textSize="24sp" />

        <TextView
        android:text="Description"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textView2"
        android:textAlignment="center" />ut_height="wrap_content"
        android:id="@+id/textView"
        android:textAppearance="@style/TextAppearance.AppCompat.Body2"
        android:textAlignment="center"
        android:textSize="24sp" />

        <TextView
        android:text="Description"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textView2"
        android:textAlignment="center" />(TextView)convertView.findViewById(R.id.textView2);

        try{
            JSONObject curr = data.getJSONObject(position);
            name.setText(curr.getString("name"));
            desc.setText("Description: "+curr.getString("desc"));
        }catch(JSONException j){
            j.printStackTrace();
        }

        return convertView;
    }
}

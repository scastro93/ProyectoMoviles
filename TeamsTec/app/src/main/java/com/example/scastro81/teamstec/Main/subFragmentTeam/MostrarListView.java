package com.example.scastro81.teamstec.Main.subFragmentTeam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.scastro81.teamstec.R;

import org.json.JSONArray;
import org.json.JSONException;

public class MostrarListView extends AppCompatActivity implements JSONRequest.JSONRequestCallback,
        AdapterView.OnItemClickListener{

    private JSONRequest j;
    private JSONArray jarray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_listview);
        j = new JSONRequest(this);
    }

    public void load(View v){
        j.execute("https://api.myjson.com/bins/1c8b1n");
    }

    @Override
    public void done(JSONArray jsonArray) {
        jarray = jsonArray;
        JSONAdapter jadapter = new JSONAdapter(jarray, this);
        ListView lv = (ListView)findViewById(R.id.friends);
        lv.setAdapter(jadapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, MomentView.class);
        try{
            i.putExtra("name", jarray.getJSONObject(position).getString("name"));
            i.putExtra("desc", jarray.getJSONObject(position).getString("desc"));
            i.putExtra("time", jarray.getJSONObject(position).getString("time"));
            startActivity(i);
        }catch(JSONException j){
            j.printStackTrace();
        }
    }
}

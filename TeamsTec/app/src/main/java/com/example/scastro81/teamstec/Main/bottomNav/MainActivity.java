package com.example.scastro81.teamstec.Main.bottomNav;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.scastro81.teamstec.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener{

    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;

    //JSON
    //private JSONRequest j;
    private JSONArray jarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }
        selectFragment(selectedItem);

        //JSON
        //j = new JSONRequest(this);
    }

    /*
    public void load(View v){
        j.execute("https://api.myjson.com/bins/1c8b1n");
    }

    */

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else {
            super.onBackPressed();
        }
    }

    private void selectFragment(MenuItem item) {

        if(item.getItemId() == R.id.menu_add){

            Fragment_Add fragmentAdd = new Fragment_Add();
            //fragmentAdd.setArguments(b);

            FragmentManager manager = getFragmentManager();
            android.app.FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container, fragmentAdd, "fragmentAdd")
                    .setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();

        } else if(item.getItemId() == R.id.menu_dashboard) {

            Bundle b = new Bundle();
            b.putSerializable("jsonarray", (Serializable) this.jarray);

            Fragment_Dashboard fragmentDash = new Fragment_Dashboard();
            fragmentDash.setArguments(b);

            FragmentManager manager = getFragmentManager();
            android.app.FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container, fragmentDash, "fragmentAdd")
                    .setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();

        } else if(item.getItemId() == R.id.menu_team) {

            Fragment_Team fragment_team = new Fragment_Team();
            //fragmentAdd.setArguments(b);

            FragmentManager manager = getFragmentManager();
            android.app.FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container, fragment_team, "fragmentAdd")
                    .setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        }


        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i< mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

        updateToolbarText(item.getTitle());

    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
        }
    }

    private int getColorFromRes(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }

    @Override
    public void onClick(View v) {

    }

    /*

    @Override
    public void done(JSONArray jsonArray) {
        System.out.println("DONE");
        jarray = jsonArray;
        JSONAdapter jadapter = new JSONAdapter(jarray, this);
        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(jadapter);
        lv.setOnItemClickListener(this);
    }
    */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        /*
        Intent i = new Intent(this, MomentView.class);
        try{
            i.putExtra("name", jarray.getJSONObject(position).getString("name"));
            i.putExtra("address", jarray.getJSONObject(position).getString("address"));
        }catch(JSONException j){
            j.printStackTrace();
        }
        */
    }



    public void onClickCrear(View view) {
        System.out.println("HOls si jalo");
        //Intent intent = new Intent(this, CrearMomento.class);
        //startActivity(intent);
    }
}
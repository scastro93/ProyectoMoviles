package com.example.scastro81.teamstec.Main.subFragmentTeam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.scastro81.teamstec.R;

public class MomentView extends AppCompatActivity {

    TextView name, desc, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment_view);

        name = (TextView)findViewById(R.id.nametxt);
        desc = (TextView)findViewById(R.id.desctxt);
        time = (TextView)findViewById(R.id.timetxt);

        Intent i = getIntent();

        name.setText("Name: "+i.getStringExtra("name"));
        desc.setText("Description: "+i.getStringExtra("desc"));
        time.setText("Time: "+i.getStringExtra("time"));
    }
}

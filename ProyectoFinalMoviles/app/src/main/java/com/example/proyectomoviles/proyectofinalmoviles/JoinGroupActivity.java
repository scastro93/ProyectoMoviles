package com.example.proyectomoviles.proyectofinalmoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoinGroupActivity extends AppCompatActivity {

    Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);

        btnJoin = (Button)findViewById(R.id.button);

        btnJoin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinGroupActivity.this, PerfilGroupActivity.class));
            }
        });
    }
}


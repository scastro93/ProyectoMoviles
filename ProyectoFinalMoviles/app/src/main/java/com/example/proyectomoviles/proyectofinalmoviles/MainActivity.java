package com.example.proyectomoviles.proyectofinalmoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCrearGrupo;
    Button btnUnirseGrupo;
    Button btnGotoWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrearGrupo = (Button)findViewById(R.id.button2);
        btnUnirseGrupo = (Button)findViewById(R.id.button5);
        btnGotoWork = (Button)findViewById(R.id.bGoToWork);

        btnCrearGrupo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateGroupActivity.class));
            }
        });

        btnUnirseGrupo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JoinGroupActivity.class));
            }
        });

        btnGotoWork.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MomentActivity.class));
            }
        });


    }
}

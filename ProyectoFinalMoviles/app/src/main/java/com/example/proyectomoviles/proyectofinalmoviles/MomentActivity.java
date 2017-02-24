package com.example.proyectomoviles.proyectofinalmoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Timer;

public class MomentActivity extends AppCompatActivity {


    Button bStartWorking, bStopWorking;
    private TextView tvCommitTitle, tvCommitMessage;
    EditText etCommitTitle, etCommitMessage;
    Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment);

        bStartWorking = (Button)findViewById(R.id.bStartWorking);
        bStopWorking = (Button)findViewById(R.id.bStopWorking);
        etCommitMessage = (EditText)findViewById(R.id.etCommitMessage);
        etCommitTitle = (EditText)findViewById(R.id.etCommitTitle);

        //Enable buttons and Edit Text
        etCommitMessage.setEnabled(false);
        etCommitTitle.setEnabled(false);
        bStopWorking.setEnabled(false);

        bStartWorking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MomentActivity.this, "Timer is running. Work and Fun", Toast.LENGTH_SHORT).show();

                bStopWorking.setEnabled(true);
                bStartWorking.setEnabled(false);
                etCommitMessage.setEnabled(true);
                etCommitTitle.setEnabled(true);

                //timer.schedule();

            }
        });

        bStopWorking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MomentActivity.this, "Your work was published. Nice Work :)", Toast.LENGTH_SHORT).show();

                bStopWorking.setEnabled(false);
                bStartWorking.setEnabled(true);
                etCommitMessage.setEnabled(false);
                etCommitTitle.setEnabled(false);
            }
        });
    }
}

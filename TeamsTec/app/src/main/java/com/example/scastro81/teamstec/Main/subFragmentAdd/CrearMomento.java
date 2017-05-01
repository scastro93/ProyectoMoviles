package com.example.scastro81.teamstec.Main.subFragmentAdd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scastro81.teamstec.Main.bottomNav.MainActivity;
import com.example.scastro81.teamstec.Main.login.Config;
import com.example.scastro81.teamstec.R;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrearMomento extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextTitulo;
    private EditText editTextDesc;

    private Button btnAceptar;
    private Button btnCancelar;


    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_momento);

        editTextTitulo = (EditText) findViewById(R.id.editTextTitulo);
        editTextDesc = (EditText) findViewById(R.id.editTextDesc);

        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        Firebase.setAndroidContext(this);
    }

    @Override
    public void onClick(View v) {

        if (v == btnAceptar){
            create();
            finish();
            startActivity(new Intent(this, MainActivity.class));

        }

        if (v == btnCancelar){
            finish();
            startActivity(new Intent(this, MainActivity.class));

        }

    }

    public void create(){

        Firebase ref = new Firebase(Config.FIREBASE_URL);

        String titulo = editTextTitulo.getText().toString().intern();
        String desc = editTextDesc.getText().toString().intern();

        String uid = firebaseAuth.getCurrentUser().getUid();

        Moment moment = new Moment();

        moment.setTitulo(titulo);
        moment.setDescripcion(desc);

        ref.child("Moments").child(uid).setValue(moment);
        Toast.makeText(this, "Updating data...",Toast.LENGTH_LONG).show();


    }
}

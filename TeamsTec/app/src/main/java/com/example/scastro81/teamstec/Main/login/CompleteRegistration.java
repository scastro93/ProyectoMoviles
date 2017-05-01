package com.example.scastro81.teamstec.Main.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scastro81.teamstec.Main.bottomNav.MainActivity;
import com.example.scastro81.teamstec.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompleteRegistration extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    private EditText editTextNombre;
    private EditText editTextMatricula;
    private Button btnAceptar;
    private Button btnCancelar;

    private Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_registration);

        Firebase.setAndroidContext(this);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        check();


        databaseReference = FirebaseDatabase.getInstance().getReference();

        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextMatricula = (EditText) findViewById(R.id.editTextMatricula);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        btnCancelar.setOnClickListener(this);
        btnAceptar.setOnClickListener(this);


    }

    public void check(){

        this.ref = new Firebase(Config.FIREBASE_URL);
        ref.child("User").addValueEventListener(new ValueEventListener() {

            String uid = firebaseAuth.getCurrentUser().getUid();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }



    public void complete(){

        this.ref = new Firebase(Config.FIREBASE_URL);

        String nombre = editTextNombre.getText().toString().trim();
        String matricula = editTextMatricula.getText().toString().trim();

        String uid = firebaseAuth.getCurrentUser().getUid();

        User user = new User();

        user.setNombre(nombre);
        user.setMatricula(matricula);

        ref.child("Users").child(uid).setValue(user);
        Toast.makeText(this, "Updating data...",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        if(view == btnCancelar){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        if(view == btnAceptar){
            complete();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}

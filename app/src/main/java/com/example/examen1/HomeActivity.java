package com.example.examen1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    boolean receptor;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        receptor = getIntent().getBooleanExtra("acape", false);



    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Deseas cerrar sesión?")
                .setPositiveButton("Si", (dialog, i) -> {
                    firebaseAuth.getInstance().signOut();
                    finish();
                    startActivity(new Intent(this, AuthActivity.class));
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss() );
        builder.show();
    }

}
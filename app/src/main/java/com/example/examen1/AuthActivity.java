package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {

    Button login;
    EditText correo, password;
    Switch switch1;

    FirebaseAuth firebaseAuth;
    boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        login = findViewById(R.id.btn_login);
        correo = findViewById(R.id.txt_email);
        password = findViewById(R.id.txt_contrasena);
        switch1 = findViewById(R.id.switch1);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();


        /*if(user != null){
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }*/


        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
               b = true;
            }else{
                b = false;
            }
        });

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        login.setOnClickListener(view->{

            String mail = correo.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if(mail == null || mail.equals("")){
                correo.setError("Campo Requerido");
            }else if(pass == null || pass.equals("")){
                password.setError("Campo Requerido");
            }else {
                if(mail.matches(emailPattern) || mail.matches(emailPattern2)){
                    firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(
                                    this,
                                    "Bienvenido!",
                                    Toast.LENGTH_SHORT
                            ).show();
                            finish();
                            Intent intent = new Intent(this, HomeActivity.class);
                            intent.putExtra("acape", b);
                            startActivity(intent);
                        }else{
                            Toast.makeText(
                                    this,
                                    "Credenciales incorrectas",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    });
                }else{
                    correo.setError("Correo inválido");
                }
            }



        });

    }

}
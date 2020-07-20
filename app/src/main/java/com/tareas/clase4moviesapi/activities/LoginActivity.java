package com.tareas.clase4moviesapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.tareas.clase4moviesapi.R;
import com.tareas.clase4moviesapi.util.SharedPref;

public class LoginActivity extends AppCompatActivity {


    final static String PARAMETRO_1 ="MAIL";
    ConstraintLayout LayoutLogin;
    EditText editCorreoLogin;
    EditText editPWLogin;
    TextView txtOlvidoLogin;
    TextView txtRegistrarLogin;
    TextView txtRegistrar2Login;
    Button btnIngresarLogin;
    CheckBox checkRecordarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        LayoutLogin = findViewById(R.id.LayoutLogin);
        editCorreoLogin = findViewById(R.id.editCorreoLogin);
        editPWLogin= findViewById(R.id.editPWLogin);
        txtOlvidoLogin= findViewById(R.id.txtOlvidoLogin);
        txtRegistrarLogin= findViewById(R.id.txtRegistrarLogin);
        txtRegistrar2Login= findViewById(R.id.txtRegistrar2Login);
        btnIngresarLogin= findViewById(R.id.btnIngresarLogin);
        checkRecordarLogin= findViewById(R.id.checkRecordarLogin);




        if(
                !SharedPref.getKey(getApplicationContext(),getResources().getString(R.string.login_shared_preference_key_email)).isEmpty() &&
                SharedPref.getKeyInteger(getApplicationContext(),getResources().getString(R.string.login_shared_preference_key_recordar))==1
        ){
            editCorreoLogin.setText(SharedPref.getKey(getApplicationContext(),getResources().getString(R.string.login_shared_preference_key_email)));
            checkRecordarLogin.setChecked((SharedPref.getKeyInteger(getApplicationContext(),getResources().getString(R.string.login_shared_preference_key_recordar))==1?true:false));
        }

        btnIngresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editCorreoLogin.getText().toString().isEmpty()){
                Snackbar.make(LayoutLogin, getResources().getString(R.string.login_error_email), Snackbar.LENGTH_SHORT).show();
                }
                else if(editPWLogin.getText().toString().isEmpty()){
                    Snackbar.make(LayoutLogin, getResources().getString(R.string.login_error_email), Snackbar.LENGTH_SHORT).show();
                }
                else{
                    if(checkRecordarLogin.isChecked()) {
                        SharedPref.setKey(getApplicationContext(), getResources().getString(R.string.login_shared_preference_key_email), editCorreoLogin.getText().toString());
                        SharedPref.setKeyInt(getApplicationContext(),getResources().getString(R.string.login_shared_preference_key_recordar), (checkRecordarLogin.isChecked()?1:0)  );
                    }

                    Intent i =  new Intent(getApplicationContext(),HomeActivity.class);
                    i.putExtra(PARAMETRO_1,editCorreoLogin.getText().toString());
                    startActivity(i);
                    finish();
                }
            }
        });

        txtOlvidoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,OlvidasteContrasenaActivity.class));
                finish();
            }
        });

        txtRegistrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,CrearCuentaActivity.class));
                finish();
            }
        });
        txtRegistrar2Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,CrearCuentaActivity.class));
                finish();
            }
        });

        checkRecordarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.setKeyInt(getApplicationContext(),getResources().getString(R.string.login_shared_preference_key_recordar), (checkRecordarLogin.isChecked()?1:0)  );
            }
        });
    }
}
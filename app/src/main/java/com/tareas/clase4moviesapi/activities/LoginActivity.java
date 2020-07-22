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

import com.google.android.material.snackbar.Snackbar;
import com.tareas.clase4moviesapi.R;
import com.tareas.clase4moviesapi.util.SharedPref;

public class LoginActivity extends AppCompatActivity {


    final static String PARAMETRO_1 ="MAIL";
    ConstraintLayout layoutLogin;
    EditText editCorreoLogin;
    EditText editPwLogin;
    TextView txtOlvidoLogin;
    TextView txtRegistrarLogin;
    TextView txtRegistrarLoginLinkLogin;
    Button btnIngresarLogin;
    CheckBox checkRecordarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        layoutLogin = findViewById(R.id.layoutLogin);
        editCorreoLogin = findViewById(R.id.editCorreoLogin);
        editPwLogin= findViewById(R.id.editPwLogin);
        txtOlvidoLogin= findViewById(R.id.txtOlvidoLogin);
        txtRegistrarLogin= findViewById(R.id.txtRegistrarLogin);
        txtRegistrarLoginLinkLogin= findViewById(R.id.txtRegistrarLoginLinkLogin);
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
                Snackbar.make(layoutLogin, getResources().getString(R.string.login_error_email), Snackbar.LENGTH_SHORT).show();
                }
                else if(editPwLogin.getText().toString().isEmpty()){
                    Snackbar.make(layoutLogin, getResources().getString(R.string.login_error_email), Snackbar.LENGTH_SHORT).show();
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
                startActivity(new Intent(getApplicationContext(),OlvidasteContrasenaActivity.class));
                finish();
            }
        });

        txtRegistrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CrearCuentaActivity.class));
                finish();
            }
        });
        txtRegistrarLoginLinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CrearCuentaActivity.class));
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
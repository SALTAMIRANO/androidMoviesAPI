package com.tareas.clase4moviesapi.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.tareas.clase4moviesapi.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onBackPressed() {
        confirmCerrarSesion();
    }
    public void confirmCerrarSesion() {

        new AlertDialog.Builder(this)
                .setMessage(R.string.home_cerrar_sesion_text)
                .setCancelable(false)
                .setPositiveButton(R.string.dialogs_btn_positive , new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();
                    }
                })
                .setNegativeButton(R.string.dialogs_btn_negative, null)
                .show();
    }
}
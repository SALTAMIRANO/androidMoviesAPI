package com.tareas.clase4moviesapi.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.tareas.clase4moviesapi.R;
import com.tareas.clase4moviesapi.data.MoviesData;
import com.tareas.clase4moviesapi.models.MovieModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
List<MovieModel> data  = new ArrayList<>();

        try {
            InputStream is = getApplicationContext().getAssets().open( getResources().getString( R.string.json_name_movies));
            data =  MoviesData.getMovies(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
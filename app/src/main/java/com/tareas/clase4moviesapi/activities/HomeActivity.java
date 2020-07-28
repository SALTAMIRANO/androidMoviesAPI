package com.tareas.clase4moviesapi.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.tareas.clase4moviesapi.R;
import com.tareas.clase4moviesapi.adapters.MovieAdapter;
import com.tareas.clase4moviesapi.data.MoviesData;
import com.tareas.clase4moviesapi.interfaces.InterfaceMoviesClick;
import com.tareas.clase4moviesapi.models.MovieModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements InterfaceMoviesClick {

    private static final String PARAMETRO_1 ="MOVIE_SELECTED";
    private InterfaceMoviesClick onclickInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(R.string.home_title);


        List<MovieModel> data  = new ArrayList<>();
        try {
            InputStream is = getApplicationContext().getAssets().open( getResources().getString( R.string.json_name_movies));
            data =  MoviesData.getMovies(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RecyclerView myRecycler = findViewById(R.id.reciclerViewHome);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            myRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        } else {
            myRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        }
        MovieAdapter myAdapter = new MovieAdapter(getApplicationContext(), data,this);
        myRecycler.setAdapter(myAdapter);
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

    @Override
    public void setClick(MovieModel item) {
        Intent i =  new Intent(getApplicationContext(), HomeDetActivity.class);
        i.putExtra(PARAMETRO_1,item);
        startActivity(i);
    }
}
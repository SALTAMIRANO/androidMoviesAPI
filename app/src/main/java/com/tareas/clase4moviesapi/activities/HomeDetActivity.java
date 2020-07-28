package com.tareas.clase4moviesapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tareas.clase4moviesapi.R;
import com.tareas.clase4moviesapi.adapters.ActorsAdapter;
import com.tareas.clase4moviesapi.data.ActorsData;
import com.tareas.clase4moviesapi.data.MoviesData;
import com.tareas.clase4moviesapi.models.ActorsModel;
import com.tareas.clase4moviesapi.models.MovieModel;
import com.tareas.clase4moviesapi.util.Paths;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


///https://developers.themoviedb.org/3/configuration/get-api-configuration
public class HomeDetActivity extends AppCompatActivity {

    private static final String PARAMETRO_1  ="MOVIE_SELECTED";
    ImageView imgBack;
    ImageView imgPoster;
    TextView txtTitle;
    TextView txtVotes;
    TextView txtInfo;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_det);
        MovieModel myMovieModel =  (MovieModel)getIntent().getSerializableExtra(PARAMETRO_1);
        setTitle(myMovieModel.title);

        imgBack = findViewById(R.id.imgBack);
        imgPoster = findViewById(R.id.imgPoster);
        txtTitle = findViewById(R.id.txtTitle);
        txtVotes = findViewById(R.id.txtVotes);
        txtInfo = findViewById(R.id.txtInfo);
        recyclerView = findViewById(R.id.reciclerViewHomeDet);

        txtTitle.setText(myMovieModel.original_title);
        txtVotes.setText( String.format("%.0f", (myMovieModel.vote_average * 10)));
        txtInfo.setText(myMovieModel.overview);

        Picasso.get()
        .load(Paths.PATH_IMGS+"/original/" + myMovieModel.backdrop_path)
        .into(imgBack);
        imgBack.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Picasso.get()
        .load( Paths.PATH_IMGS+"/w300/" + myMovieModel.poster_path)
        .into(imgPoster);
        imgPoster.setScaleType(ImageView.ScaleType.CENTER_CROP);


        //region RECICLER VIEW

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<ActorsModel> data  = new ArrayList<>();
        try {
            InputStream is = getApplicationContext().getAssets().open( getResources().getString( R.string.json_name_actors));
            data =  ActorsData.getActors(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ActorsAdapter myAdapter = new ActorsAdapter(getApplicationContext(),  data);
        recyclerView.setAdapter(myAdapter);
        //endregion


    }
}
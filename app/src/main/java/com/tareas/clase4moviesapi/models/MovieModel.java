package com.tareas.clase4moviesapi.models;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieModel implements Serializable {

        private float popularity;
        private float vote_count;
        private boolean video;
        private String poster_path;
        private float id;
        private boolean adult;
        private String backdrop_path;
        private String original_language;
        private String original_title;
        ArrayList< Object > genre_ids = new ArrayList < Object > ();
        private String title;
        private float vote_average;
        private String overview;
        private String release_date;
}

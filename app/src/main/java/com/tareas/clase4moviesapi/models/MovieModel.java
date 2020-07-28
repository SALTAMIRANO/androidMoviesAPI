package com.tareas.clase4moviesapi.models;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieModel implements Serializable {

        public float popularity;
        public float vote_count;
        public boolean video;
        public String poster_path;
        public float id;
        public boolean adult;
        public String backdrop_path;
        public String original_language;
        public String original_title;
        ArrayList< Object > genre_ids = new ArrayList < Object > ();
        public String title;
        public float vote_average;
        public String overview;
        public String release_date;

        public float getVote_average() {
                return vote_average;
        }
}


package com.tareas.clase4moviesapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tareas.clase4moviesapi.interfaces.InterfaceMoviesClick;
import com.tareas.clase4moviesapi.models.MovieModel;
import com.tareas.clase4moviesapi.R;
import com.tareas.clase4moviesapi.util.Paths;

import java.text.DecimalFormat;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.myViewHolder> {
    private List<MovieModel> myListMovies;
    private InterfaceMoviesClick onClickInterface;
    private Context context;

    public MovieAdapter() {
    }

    public MovieAdapter(Context context, List<MovieModel> myMovies, InterfaceMoviesClick onClickInterface) {
        this.myListMovies = myMovies;
        this.onClickInterface = onClickInterface;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return myListMovies.size();
    }

    @NonNull
    @Override
    public MovieAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_home, parent, false);
        MovieAdapter.myViewHolder vh = new MovieAdapter.myViewHolder(myView);
        return vh;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtItem);
            imageView = (ImageView) itemView.findViewById(R.id.imgItem);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.myViewHolder holder, final int position) {
        holder.textView.setText( String.format("%.0f", (myListMovies.get(position).vote_average * 10)));

        Picasso.get()
        //   .load(context.getResources().getString(R.string.json_url_base_images) + myListMovies.get(position).poster_path)
        .load( Paths.PATH_IMGS+"/w300/" + myListMovies.get(position).poster_path)
        .into(holder.imageView);
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        /*
        Glide.with(holder.itemView.getContext())
        //.asBitmap()
        // .load("https://image.tmdb.org/t/p/w300/" + myListMovies.get(position).poster_path)
        .load("https://image.tmdb.org/t/p/w300/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg")
        .into(holder.imageView);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickInterface.setClick(myListMovies.get(position));
            }
        });

        setAnimation(holder.itemView, position);
    }

    private int lastPosition = -1;

    private void setAnimation(View viewToAnimate, int position) {

        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            animation.setDuration(200);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        } else if (position < lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


}
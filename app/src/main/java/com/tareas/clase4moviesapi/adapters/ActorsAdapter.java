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
import com.squareup.picasso.Transformation;
import com.tareas.clase4moviesapi.R;
import com.tareas.clase4moviesapi.interfaces.InterfaceMoviesClick;
import com.tareas.clase4moviesapi.models.ActorsModel;
import com.tareas.clase4moviesapi.models.MovieModel;
import com.tareas.clase4moviesapi.util.Paths;

import java.util.List;


public class ActorsAdapter extends RecyclerView.Adapter<MovieAdapter.myViewHolder> {
    private List<ActorsModel> myList;
    private Context context;

    public ActorsAdapter() {
    }

    public ActorsAdapter(Context context, List<ActorsModel> myList) {
        this.myList = myList;
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    @NonNull
    @Override
    public MovieAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_actors_home, parent, false);
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
        holder.textView.setText(myList.get(position).name);
        Picasso.get()
        .load(Paths.PATH_IMGS +"/w300/" + myList.get(position).profile_path)
        .into(holder.imageView);
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

    }





}
package com.example.moviesapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyHolder> {

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movies_raw, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Movies movies = moviesList.get(position);
        holder.name.setText(movies.getName());
        holder.image.setImageResource(movies.getImage());
    }

    @Override
    public int getItemCount() {
        return moviesList!=null?moviesList.size():0;
    }
    Context context;
    List<Movies> moviesList;
    public void setData(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.movie_raw_image);
            name = itemView.findViewById(R.id.movie_raw_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movies movies = moviesList.get(getAdapterPosition());
                    Intent intent = new Intent(context,DetailsActivity.class);
                    intent.putExtra("movies",movies);
                    context.startActivity(intent);
                }
            });
        }
    }
}

package com.example.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView moveImage,movieCover;
    TextView movieName,movieDesc,movieRating;
    Movies movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        moveImage = findViewById(R.id.details_movie_image);
        movieCover = findViewById(R.id.details_move_cover);
        movieName = findViewById(R.id.details_movie_name);
        movieDesc = findViewById(R.id.details_movie_desc);
        movieRating = findViewById(R.id.details_movie_rating);

        movies = getIntent().getExtras().getParcelable("movies");
        movieRating.setText("rating: "+movies.getRating());
        movieName.setText("name: "+movies.getName());
        movieDesc.setText(movies.getDesc());
        moveImage.setImageResource(movies.getImage());
    }
}
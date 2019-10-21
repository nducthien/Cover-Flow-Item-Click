package com.example.coverflow_itemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.coverflow_itemclick.Common.Common;
import com.example.coverflow_itemclick.Model.Movie;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    KenBurnsView movie_image;
    TextView movie_title;
    TextView movie_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movie_image = findViewById(R.id.movie_image);
        movie_title = findViewById(R.id.movie_title);
        movie_summary = findViewById(R.id.movie_summary);

        if (getIntent() != null) {
            int movie_index = getIntent().getIntExtra("movie_index", -1);
            if (movie_index != -1) {
                loadMovieDetail(movie_index);
            }
        }

    }

    private void loadMovieDetail(int index) {
        Movie movie = Common.movieList.get(index);

        //Load img
        Picasso.with(getBaseContext()).load(movie.getUrl()).into(movie_image);
        movie_title.setText(movie.getTitle());
        movie_summary.setText(movie.getSummary());
    }
}

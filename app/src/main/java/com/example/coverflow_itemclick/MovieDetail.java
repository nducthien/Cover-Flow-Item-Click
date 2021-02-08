package com.example.coverflow_itemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.coverflow_itemclick.common.Common;
import com.example.coverflow_itemclick.db.Db;
import com.example.coverflow_itemclick.entity.Product;
import com.example.coverflow_itemclick.model.Movie;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity implements View.OnClickListener {

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
        findViewById(R.id.btnInsert).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btnUpdate).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btnDelete).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btnSelect).setOnClickListener((View.OnClickListener) this);

        if (getIntent() != null) {
            int movie_index = getIntent().getIntExtra(Common.MOVIE_INDEX, -1);
            if (movie_index != -1) {
                loadMovieDetail(movie_index);
            }
        }

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInsert:
                Product product = new Product("Sting", 15);
                Db.getDb().productDao().insert(product);
                break;
            case R.id.btnUpdate:
                Product productUpdate = new Product("Coca news", 150);
                productUpdate.id = 3;

                Db.getDb().productDao().update(productUpdate);

                break;
            case R.id.btnDelete:
                Product productDelete = new Product();
                productDelete.id = 5;
                Db.getDb().productDao().delete(productDelete);
                break;
            case R.id.btnSelect:
                break;
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

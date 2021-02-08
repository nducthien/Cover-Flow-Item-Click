package com.example.coverflow_itemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.coverflow_itemclick.adapter.MovieAdapter;
import com.example.coverflow_itemclick.common.Common;
import com.example.coverflow_itemclick.db.Db;
import com.example.coverflow_itemclick.entity.Product;
import com.example.coverflow_itemclick.model.Movie;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    MovieAdapter movieAdapter;
    TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        movieAdapter = new MovieAdapter(Common.movieList, this);
        coverFlow = findViewById(R.id.coverFlow);
        mTitle = findViewById(R.id.mTitle);
        /**
         * show Title below img
         * ViewSwitcher.ViewFactory: the view factory used to generate the switcher's content
         */
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.layout_title, null);
                return textView;
            }
        });
        coverFlow.setAdapter(movieAdapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.movieList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetail.class);
                intent.putExtra(Common.MOVIE_INDEX, position);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        Common.movieList.add(new Movie("Iron Man",
                "https://images.hdqwalls.com/wallpapers/iron-man-2020-5k-2t.jpg",
                "My whole world changed from the moment I met you"));

        Common.movieList.add(new Movie("Civir war",
                "https://hdqwalls.com/download/firewatch-game-graphics-2880x1800.jpg",
                "Everything was perfect, I knew this love is worth it\n" +
                        "Our own miracle in the makin"));
        Common.movieList.add(new Movie("Mountain",
                "https://www.pixelstalk.net/wp-content/uploads/2016/07/Art-Images-HD-2880x1800-Download.jpg",
                "Smiles by the thousands, ya tears have all dried out\n"));
        Common.movieList.add(new Movie("Neon City",
                "https://external-preview.redd.it/XCTVIhr4EElXe3kgRt3cKiNlfHpS5xEUqEChHRoSjTI.jpg?auto=webp&s=fef5917af72b33d71eab15521dec8b6a89f53f07",
                "Everything was perfect, I knew this love is worth it\n" +
                        "Our own miracle in the makin'\n"));
    }
}

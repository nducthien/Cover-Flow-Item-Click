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

import com.example.coverflow_itemclick.Adapter.MovieAdapter;
import com.example.coverflow_itemclick.Common.Common;
import com.example.coverflow_itemclick.Model.Movie;

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
                intent.putExtra("movie_index", position);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        Common.movieList.add(new Movie("Songoku",
                "http://shoppopgallery.com/wp-content/uploads/2019/06/nature-at-night-2880x1800-wallpaper-staggering-2880-x-1800-complex-11.jpg",
                "My whole world changed from the moment I met you\n" +
                        "And it would never be the same\n" +
                        "Felt like I knew that I'd always love you\n" +
                        "From the moment I heard your name"));

        Common.movieList.add(new Movie("Civir war",
                "https://hdqwalls.com/download/firewatch-game-graphics-2880x1800.jpg",
                "Everything was perfect, I knew this love is worth it\n" +
                        "Our own miracle in the makin'\n" +
                        "'Til this world stops turning\n" +
                        "I'll still be here waiting and waiting to make that vow that I'll...\n" +
                        "I'll be by your side, 'til the day I die\n" +
                        "I'll be waiting 'til I hear you say I Do\n" +
                        "Something old, something new\n" +
                        "Something borrowed, something blue\n" +
                        "I'll be waiting 'til I hear you say I Do"));
        Common.movieList.add(new Movie("Mountain",
                "https://www.pixelstalk.net/wp-content/uploads/2016/07/Art-Images-HD-2880x1800-Download.jpg",
                "Smiles by the thousands, ya tears have all dried out\n" +
                        "'Cos I won't see you cry again\n" +
                        "Throw pennies in the fountain, and look at what comes out\n" +
                        "Sometimes wishes do come true"));
        Common.movieList.add(new Movie("Neon City",
                "https://external-preview.redd.it/XCTVIhr4EElXe3kgRt3cKiNlfHpS5xEUqEChHRoSjTI.jpg?auto=webp&s=fef5917af72b33d71eab15521dec8b6a89f53f07",
                "Everything was perfect, I knew this love is worth it\n" +
                        "Our own miracle in the makin'\n" +
                        "'Til this world stops turning\n" +
                        "I'll still be here waiting and waiting to make that vow that I'll...\n" +
                        "I'll be by your side, 'til the day I die\n" +
                        "I'll be waiting 'til I hear you say I Do\n" +
                        "Something old, something new\n" +
                        "Something borrowed, something blue\n" +
                        "I'll be waiting 'til I hear you say I Do"));
    }
}

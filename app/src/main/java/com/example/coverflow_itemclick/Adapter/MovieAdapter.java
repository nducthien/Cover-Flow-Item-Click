package com.example.coverflow_itemclick.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coverflow_itemclick.MainActivity;
import com.example.coverflow_itemclick.Model.Movie;
import com.example.coverflow_itemclick.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends BaseAdapter {

    List<Movie> movieList = new ArrayList<>();
    Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        if (rootView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.layout_item, null);
            TextView name = view.findViewById(R.id.tv_label);
            ImageView imageView = view.findViewById(R.id.image);

            Picasso.with(context).load(movieList.get(position).getUrl()).into(imageView);
            name.setText(movieList.get(position).getTitle());

            return view;
        }

        return rootView;
    }
}

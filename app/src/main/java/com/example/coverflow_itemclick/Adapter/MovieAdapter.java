package com.example.coverflow_itemclick.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.coverflow_itemclick.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends BaseAdapter {

    List<Movie> movieList = new ArrayList<>();
    Context context;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        movieList.get(position);
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return null;
    }
}

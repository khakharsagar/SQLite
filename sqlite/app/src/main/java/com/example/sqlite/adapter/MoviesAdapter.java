package com.example.sqlite.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sqlite.R;


import com.example.sqlite.database.Contact;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Contact> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            genre = view.findViewById(R.id.genre);
            year = view.findViewById(R.id.year);
        }
    }


    public MoviesAdapter(List<Contact> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact movie = moviesList.get(position);
        holder.title.setText(movie.getID());
        holder.genre.setText(movie.getName());
        holder.year.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

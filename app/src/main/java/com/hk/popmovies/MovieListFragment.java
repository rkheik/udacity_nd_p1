package com.hk.popmovies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hk.popmovies.adapters.ImageAdapter;
import com.hk.popmovies.models.Movie;
import com.hk.popmovies.models.MovieList;

public class MovieListFragment extends Fragment {

    private MovieList movies = new MovieList();

    public MovieListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie_list, container, false);
        ImageAdapter adapter = new ImageAdapter(getContext(), movies);
        GridView grid = (GridView)root.findViewById(R.id.movie_list_gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gotoMovieDetail(position);
            }
        });
        return root;
    }

    private void gotoMovieDetail(int position) {
        Movie movie = movies.getMovie(position);
        Intent intent = MovieDetailActivity.getStartIntent(getContext(), movie);
        startActivity(intent);
    }
}

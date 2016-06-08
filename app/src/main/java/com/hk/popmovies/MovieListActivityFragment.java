package com.hk.popmovies;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.hk.popmovies.adapters.ImageAdapter;
import com.hk.popmovies.models.MovieList;

public class MovieListActivityFragment extends Fragment {

    private MovieList mMovies = new MovieList();

    public MovieListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie_list, container, false);
        ImageAdapter adapter = new ImageAdapter(getContext(), mMovies);
        GridView grid = (GridView)root.findViewById(R.id.movie_list_gridview);
        grid.setAdapter(adapter);

        return root;
    }
}

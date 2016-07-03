package com.hk.popmovies;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hk.popmovies.adapters.ImageAdapter;
import com.hk.popmovies.models.Movie;
import com.hk.popmovies.models.MovieList;

public class MovieListFragment extends Fragment implements MovieListActivity.OnOptionSelected {

    private MovieList movies;
    private ImageAdapter adapter;

    public MovieListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie_list, container, false);
        //init model
        movies = new MovieList(getContext());
        //init grid
        adapter = new ImageAdapter(getContext(), movies);
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


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadMovies(MovieList.POPULAR);
    }

    private void loadMovies(final int movieType) {
        movies.getMovies(getContext(), movieType, new MovieList.SuccessListener() {
            @Override
            public void onSuccess() {
                //Refresh grid
                adapter.notifyDataSetChanged();
                setTitle(movieType);
            }
        });
    }

    private void setTitle(int type) {
        String title = getString(R.string.action_popular);
        if(type == MovieList.TOP_RATED) {
            title = getString(R.string.action_rating);
        }
        ActionBar bar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if(bar != null) {
            bar.setTitle(title);
        }
    }

    private void gotoMovieDetail(int position) {
        Movie movie = movies.getMovie(position);
        Intent intent = MovieDetailActivity.getStartIntent(getContext(), movie);
        startActivity(intent);
    }

    //Menu change from activity
    @Override
    public boolean menuSelected(int id) {
        if(id == R.id.menu_item_popular) {
            loadMovies(MovieList.POPULAR);
            return true;
        } else if(id == R.id.menu_item_rating) {
            loadMovies(MovieList.TOP_RATED);
            return true;
        }
        return false;
    }
}

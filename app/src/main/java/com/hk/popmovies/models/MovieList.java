package com.hk.popmovies.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by humbo on 7/6/16.
 */
public class MovieList {
    private List<Movie> mItems;

    public MovieList() {
        mItems = new ArrayList<>();
        for(int i=0; i<20; i++) {
            Movie m = new Movie();
            m.setTitle("ESOTSM");
            m.setImageUrl("http://image.tmdb.org/t/p/w185/7y3eYvTsGjxPYDtSnumCLIMDkrV.jpg");
            m.setReleaseDate("2004");
            m.setVoteAverage("5/5");
            m.setSynopsis("When their relationship turns sour, a couple undergoes a procedure to have each other erased from their memories. But it is only through the process of loss that they discover what they had to begin with.");

            mItems.add(m);
        }
    }

    public int getCount() {
        return mItems.size();
    }

    public Movie getItem(int position) {
        return mItems.get(position);
    }
}

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
            m.setmTitle("Avengers");
            m.setImageUrl("http://example.com");
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

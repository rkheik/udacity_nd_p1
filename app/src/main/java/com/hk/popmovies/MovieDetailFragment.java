package com.hk.popmovies;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hk.popmovies.models.Movie;
import com.hk.popmovies.ui.CustomRatioImageView;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailFragment extends Fragment {

    private static final String ARG_EXTRA = "movie";

    public MovieDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        Bundle args = getArguments();
        if(args != null) {
            Movie movie = (Movie)args.getSerializable(ARG_EXTRA);
            configureView(root, movie);
        }
        return root;
    }

    private void configureView(View root, Movie movie) {
        TextView title = (TextView) root.findViewById(R.id.movie_detail_title);
        TextView synopsis = (TextView) root.findViewById(R.id.movie_detail_synopsis);
        TextView date = (TextView) root.findViewById(R.id.movie_detail_date);
        TextView voteAverage = (TextView) root.findViewById(R.id.movie_detail_average);
        CustomRatioImageView poster = (CustomRatioImageView) root.findViewById(R.id.movie_detail_poster);

        title.setText(movie.getTitle());
        synopsis.setText(movie.getSynopsis());
        date.setText(movie.getReleaseDate());
        voteAverage.setText(movie.getVoteAverage());
        Picasso.with(getContext()).load(movie.getImageUrl()).into(poster);
    }

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_EXTRA, movie);
        fragment.setArguments(args);
        return fragment;
    }
}

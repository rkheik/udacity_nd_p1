package com.hk.popmovies.models;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by humbo on 7/6/16.
 */
public class MovieList {
    public List<Movie> items;

    public static final int POPULAR = 0;
    public static final int TOP_RATED = 1;

    public interface SuccessListener {
        public void onSuccess();

    }

    public MovieList(Context context) {
        items = new ArrayList<>();
        //initialize volley
        VolleySingleton.getInstance(context);
    }

    //Request methods
    public void getMovies(Context context, int type, final SuccessListener successListener) {

        String url = Router.MOVIES_POPULAR;
        switch (type) {
            case POPULAR:
                url = Router.MOVIES_POPULAR;
                break;
            case TOP_RATED:
                url = Router.MOVIES_TOP_RATED;
                break;
        }

        items.clear();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
           new Response.Listener<JSONObject>() {
               @Override
               public void onResponse(JSONObject response) {
                   try {
                       loadMovies(response);
                       successListener.onSuccess();
                   } catch (JSONException e) {
                       //TODO error
                   }
               }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance(context).addToRequestQueue(request);
    }

    private void loadMovies(JSONObject response) throws JSONException {
        JSONArray mi = response.getJSONArray("results");
        for (int i = 0; i < mi.length() ; i++) {
            JSONObject o = mi.getJSONObject(i);
            Movie movie = new Movie();
            movie.setTitle(o.getString("original_title"));
            movie.setImageUrl(o.getString("poster_path"));
            movie.setSynopsis(o.getString("overview"));
            movie.setVoteAverage(o.getDouble("vote_average"));
            movie.setReleaseDate(o.getString("release_date"));
            items.add(movie);
        }

    }

    //Other
    public int getCount() {
        return items.size();
    }

    public Movie getMovie(int position) {
        return items.get(position);
    }
}

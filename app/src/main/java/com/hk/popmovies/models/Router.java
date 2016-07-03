package com.hk.popmovies.models;

import com.hk.popmovies.BuildConfig;

/**
 * Created by humbo on 26/6/16.
 */
public class Router {

    private static final String IMG_BASE_URL     = "https://image.tmdb.org/t/p/";
    private static final String IMG_SIZE_DEFAULT = "w185";
    private static final String API_BASE_URL = "http://api.themoviedb.org/3/movie/";
    //resources
    private static final String API_RES_POP = "popular";
    private static final String API_RES_TOP_RATED = "top_rated";
    //public urls
    public static final String MOVIES_POPULAR = apify(API_RES_POP);
    public static final String MOVIES_TOP_RATED = apify(API_RES_TOP_RATED);

    private static String apify(String resource) {
        // {url}{resource}?api_key=something
        return String.format("%s%s?api_key=%s",
                API_BASE_URL,
                resource,
                BuildConfig.API_KEY_TMDB
        );
    }

    //public tools

    public static String absoluteImageUrl(String shortName) {
        return fullImageUrl(shortName, IMG_SIZE_DEFAULT);
    }

    public static String fullImageUrl(String shortName, String size) {
        return IMG_BASE_URL + size + shortName;
    }

}

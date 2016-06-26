package com.hk.popmovies.models;

import java.io.Serializable;

/**
 * Created by humbo on 7/6/16.
 */
public class Movie implements Serializable {
    private String title;
    private String synopsis;
    private String imageUrl;
    private String releaseDate;
    private String voteAverage;

    public String getTitle() {
        return title;
    }
    public void setTitle(String mTitle) {
        this.title = mTitle;
    }

    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String mImageUrl) {
        this.imageUrl = mImageUrl;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }
}

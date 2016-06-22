package com.hk.popmovies.models;

import java.io.Serializable;

/**
 * Created by humbo on 7/6/16.
 */
public class Movie implements Serializable {
    private String mTitle;
    private String mSynopsis;
    private String mImageUrl;
    private String mReleaseDate;
    private String mVoteAverage;

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getSynopsis() {
        return mSynopsis;
    }
    public void setSynopsis(String synopsis) {
        this.mSynopsis = synopsis;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.mReleaseDate = releaseDate;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }
    public void setVoteAverage(String voteAverage) {
        this.mVoteAverage = voteAverage;
    }
}

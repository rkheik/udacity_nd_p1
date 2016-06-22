package com.hk.popmovies.models;

import java.io.Serializable;

/**
 * Created by humbo on 7/6/16.
 */
public class Movie implements Serializable {
    private String mTitle;
    private String mImageUrl;

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}

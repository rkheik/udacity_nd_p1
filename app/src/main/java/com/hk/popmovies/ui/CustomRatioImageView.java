package com.hk.popmovies.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by humbo on 8/6/16.
 */

public class CustomRatioImageView extends ImageView {

    public CustomRatioImageView(Context context) {
        super(context);
    }

    public CustomRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRatioImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        //poster images ratio is approximately 1.5
        int height = Math.round(width*1.5f);
        setMeasuredDimension(width, height);
    }

}
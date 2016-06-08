package com.hk.popmovies.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.hk.popmovies.R;
import com.hk.popmovies.models.Movie;
import com.hk.popmovies.models.MovieList;

/**
 * Created by humbo on 7/6/16.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private MovieList mModel;
    private LayoutInflater mInflater;

    public ImageAdapter(Context context, MovieList model) {
        this.mContext = context;
        this.mModel = model;
        this.mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mModel.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mModel.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_movie, null);
            holder = new Holder();
            holder.image = (ImageView) convertView.findViewById(R.id.cell_movie_image);
            convertView.setTag(holder);
        }
        holder = (Holder) convertView.getTag();
        Movie movie = mModel.getItem(position);
        holder.image.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }

    /* View Holder */
    class Holder {
        ImageView image;
    }
}

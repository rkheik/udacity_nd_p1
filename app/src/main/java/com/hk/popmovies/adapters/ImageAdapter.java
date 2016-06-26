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
import com.squareup.picasso.Picasso;

/**
 * Created by humbo on 7/6/16.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private MovieList model;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, MovieList model) {
        this.context = context;
        this.model = model;
        this.inflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return model.getCount();
    }

    @Override
    public Object getItem(int position) {
        return model.getMovie(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.cell_movie, null);
            holder = new Holder();
            holder.image = (ImageView) convertView.findViewById(R.id.cell_movie_image);
            convertView.setTag(holder);
        }
        holder = (Holder) convertView.getTag();
        Movie movie = model.getMovie(position);
        Picasso.with(context).load(movie.getImageUrl()).into(holder.image);
        //holder.image.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }

    /* View Holder */
    class Holder {
        ImageView image;
    }
}

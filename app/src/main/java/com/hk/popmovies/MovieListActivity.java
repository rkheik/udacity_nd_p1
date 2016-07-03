package com.hk.popmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MovieListActivity extends AppCompatActivity {

    private OnOptionSelected menuListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState == null) {
            MovieListFragment fragment = new MovieListFragment();
            menuListener = fragment;
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.movie_list_fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( menuListener != null && menuListener.menuSelected(item.getItemId()) ) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Utils
    public interface OnOptionSelected {
        boolean menuSelected(int id);
    }
}

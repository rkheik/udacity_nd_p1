package com.hk.popmovies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState == null) {
            Fragment fragment = new MovieListFragment();
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
        switch (item.getItemId()) {
            case R.id.menu_item_popular:
                Log.d("something", "pop selected");
                return true;
            case R.id.menu_item_rating:
                Log.d("something", "rating selected");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

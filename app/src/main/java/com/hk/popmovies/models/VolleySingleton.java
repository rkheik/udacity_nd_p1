package com.hk.popmovies.models;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by humbo on 26/6/16.
 */
public class VolleySingleton {

    private static VolleySingleton instance;
    private static Context context;
    private RequestQueue queue;

    private VolleySingleton(Context context) {
        this.context = context.getApplicationContext();
        queue = Volley.newRequestQueue(this.context);
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if(instance == null) {
            instance = new VolleySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return queue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        queue.add(request);
    }

}

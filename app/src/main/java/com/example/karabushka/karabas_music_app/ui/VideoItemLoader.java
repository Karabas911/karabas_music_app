package com.example.karabushka.karabas_music_app.ui;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;


import com.example.karabushka.karabas_music_app.MovieProvider;
import com.example.karabushka.karabas_music_app.model.Movie;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Karabushka on 26.06.2017.
 */

public class VideoItemLoader extends AsyncTaskLoader<LinkedHashMap<Integer,List<Movie>>> {

    private static final String TAG = VideoItemLoader.class.getSimpleName();

    public VideoItemLoader(Context context) {
        super(context);
    }

    @Override
    public LinkedHashMap<Integer, List<Movie>> loadInBackground() {
        Log.d(TAG, "loadInBackground");
        LinkedHashMap<Integer, List<Movie>> videoLists = prepareData();
        return videoLists;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    private LinkedHashMap<Integer, List<Movie>> prepareData() {
        LinkedHashMap<Integer, List<Movie>> videoLists = new LinkedHashMap<>();
        for(int channel: MovieProvider.ALL_CHANNELS) {
            videoLists.put(channel, MovieProvider.getMovieItems(channel));
        }
        return videoLists;
    }
}

package com.example.karabushka.karabas_music_app.ui;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.example.karabushka.karabas_music_app.model.Movie;



/**
 * Created by Karabushka on 25.06.2017.
 */
public class DetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        Movie movie = (Movie) item;

        if (movie != null) {
            viewHolder.getTitle().setText(movie.getTitle());
            viewHolder.getSubtitle().setText(movie.getStudio());
            viewHolder.getBody().setText(movie.getDescription());
        }

    }
}

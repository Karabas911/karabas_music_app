package com.example.karabushka.karabas_music_app.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.support.v17.leanback.widget.SparseArrayObjectAdapter;
import android.util.Log;

import com.example.karabushka.karabas_music_app.MovieProvider;
import com.example.karabushka.karabas_music_app.Utils;
import com.example.karabushka.karabas_music_app.model.Movie;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Karabushka on 25.06.2017.
 */

public class VideoDetailsFragment extends DetailsFragment {
    private static final String TAG = VideoDetailsFragment.class.getSimpleName();

    private static final int DETAIL_THUMB_WIDTH = 274;
    private static final int DETAIL_THUMB_HEIGHT = 274;
    private static final int ACTION_PLAY_VIDEO = 1;


    private static final String MOVIE = "Movie";

    private CustomFullWidthDetailsOverviewRowPresenter mFwdorPresenter;
    private PicassoBackgroundManager mPicassoBackgroundManager;

    private Movie mSelectedMovie;
    private DetailsRowBuilderTask mDetailsRowBuilderTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        mFwdorPresenter = new CustomFullWidthDetailsOverviewRowPresenter(new DetailsDescriptionPresenter());

        mPicassoBackgroundManager = new PicassoBackgroundManager(getActivity());
        mSelectedMovie = (Movie)getActivity().getIntent().getSerializableExtra(MOVIE);

        mDetailsRowBuilderTask = (DetailsRowBuilderTask) new DetailsRowBuilderTask().execute(mSelectedMovie);
        mPicassoBackgroundManager.updateBackgroundWithDelay(mSelectedMovie.getCardImageUrl());;
    }

    @Override
    public void onStop() {
        mDetailsRowBuilderTask.cancel(true);
        super.onStop();
    }

    private class DetailsRowBuilderTask extends AsyncTask<Movie, Integer, DetailsOverviewRow> {
        @Override
        protected DetailsOverviewRow doInBackground(Movie... params) {
            DetailsOverviewRow row = new DetailsOverviewRow(mSelectedMovie);
            try {
                Bitmap poster = Picasso.with(getActivity())
                        .load(mSelectedMovie.getCardImageUrl())
                        .resize(Utils.convertDpToPixel(getActivity().getApplicationContext(), DETAIL_THUMB_WIDTH),
                                Utils.convertDpToPixel(getActivity().getApplicationContext(), DETAIL_THUMB_HEIGHT))
                        .centerCrop()
                        .get();
                row.setImageBitmap(getActivity(), poster);
            } catch (IOException e) {
                Log.w(TAG, e.toString());
            }


            return row;
        }

        @Override
        protected void onPostExecute(DetailsOverviewRow row) {
                    /* 1st row: DetailsOverviewRow */
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter();

            sparseArrayObjectAdapter.set(0, new Action(ACTION_PLAY_VIDEO, "Play"));
            mFwdorPresenter.setOnActionClickedListener(new OnActionClickedListener() {
                @Override
                public void onActionClicked(Action action) {
                    if (action.getId() == ACTION_PLAY_VIDEO) {
                        Intent intent = new Intent(getActivity(), PlaybackActivity.class);
                        intent.putExtra("Movie", mSelectedMovie);
                        intent.putExtra("shouldStart", true);
                        startActivity(intent);
                    }
                }
            });
            row.setActionsAdapter(sparseArrayObjectAdapter);

        /* 2nd row: ListRow */
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
            ArrayList<Movie> relatedVideos = new ArrayList<Movie>(MovieProvider.getMovieItems(mSelectedMovie.getVideoGenreId()));
            for(Movie movie: relatedVideos){
                listRowAdapter.add(movie);
            }

            HeaderItem headerItem = new HeaderItem(0, "Related Videos");

            ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
            mFwdorPresenter.setInitialState(FullWidthDetailsOverviewRowPresenter.STATE_SMALL);
            Log.e(TAG, "mFwdorPresenter.getInitialState: " +mFwdorPresenter.getInitialState());

            classPresenterSelector.addClassPresenter(DetailsOverviewRow.class, mFwdorPresenter);
            classPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());

            ArrayObjectAdapter adapter = new ArrayObjectAdapter(classPresenterSelector);
            /* 1st row */
            adapter.add(row);
            /* 2nd row */
            adapter.add(new ListRow(headerItem, listRowAdapter));
            /* 3rd row */
            //adapter.add(new ListRow(headerItem, listRowAdapter));
            setAdapter(adapter);

        }
    }
}

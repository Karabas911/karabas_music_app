/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.karabushka.karabas_music_app.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;
import android.view.View;


import com.example.karabushka.karabas_music_app.R;
import com.example.karabushka.karabas_music_app.model.Movie;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Karabushka on 25.06.2017.
 */
public class MainFragment extends BrowseFragment {
    private static final String TAG = MainFragment.class.getSimpleName();

    private ArrayObjectAdapter mRowsAdapter;
    private static final int VIDEO_ITEM_LOADER_ID = 1;
    private static PicassoBackgroundManager picassoBackgroundManager = null;
    private static final String[] CHANNEL_NAMES = {"Chill out","Synthwave","Hip-Hop","Rock"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        picassoBackgroundManager = new PicassoBackgroundManager(getActivity());
        picassoBackgroundManager.updateBackgroundWithDelay("http://i1.ytimg.com/vi/gwDoRPcPxtc/maxresdefault.jpg");

        setupUIElements();

//        loadRows();

        getLoaderManager().initLoader(VIDEO_ITEM_LOADER_ID, null, new MainFragmentLoaderCallbacks());
        setupEventListeners();

    }
    private class MainFragmentLoaderCallbacks implements LoaderManager.LoaderCallbacks<LinkedHashMap<Integer, List<Movie>>> {


        @Override
        public Loader<LinkedHashMap<Integer, List<Movie>>> onCreateLoader(int id, Bundle args) {
            if(id == VIDEO_ITEM_LOADER_ID) {
                Log.d(TAG, "create VideoItemLoader");
                return new VideoItemLoader(getActivity());
            }
            return null;
        }

        @Override
        public void onLoadFinished(Loader<LinkedHashMap<Integer, List<Movie>>> loader, LinkedHashMap<Integer, List<Movie>> data) {
            Log.d(TAG, "onLoadFinished");
            /* Loader data has prepared. Start updating UI here */
            switch (loader.getId()) {
                case VIDEO_ITEM_LOADER_ID:
                    Log.d(TAG, "VideoLists UI update");
                    mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
                    CardPresenter cardPresenter = new CardPresenter();
                    if (null != data) {
                        for (Map.Entry<Integer, List<Movie>> entry : data.entrySet()) {
                            ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);
                            HeaderItem cardPresenterHeader = new HeaderItem(entry.getKey(), CHANNEL_NAMES[entry.getKey()]);
                            List<Movie> list = entry.getValue();
                            for (Movie movie : list) {
                                cardRowAdapter.add(movie);
                            }
                            mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
                        }
                    } else {
                        Log.e(TAG, "An error occurred fetching videos");
                    }
                    /* Set */
                    setAdapter(mRowsAdapter);
            }
        }

        @Override
        public void onLoaderReset(Loader<LinkedHashMap<Integer, List<Movie>>> loader) {
            Log.d(TAG, "VideoItemLoader: onLoadReset");
        }
    }

//    private void loadRows() {
//        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
//        CardPresenter cardPresenter = new CardPresenter();
//
//        HeaderItem cardPresenterHeader = new HeaderItem(0, "Chill out");
//        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);
//        ArrayList<Movie> mItems = MovieProvider.getMovieItems(MovieProvider.CHILL_OUT_NUMBER);
//        for (Movie movie : mItems) {
//            cardRowAdapter.add(movie);
//        }
//        mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
//
//        HeaderItem cardPresenterHeader1 = new HeaderItem(1, "Synthwave");
//        ArrayObjectAdapter cardRowAdapter1 = new ArrayObjectAdapter(cardPresenter);
//        ArrayList<Movie> mItems1 = MovieProvider.getMovieItems(MovieProvider.SYNTHWAVE_NUMBER);
//        for (Movie movie : mItems1) {
//            cardRowAdapter1.add(movie);
//        }
//        mRowsAdapter.add(new ListRow(cardPresenterHeader1, cardRowAdapter1));
//
//        HeaderItem cardPresenterHeader2 = new HeaderItem(2, "Hip-Hop");
//        ArrayObjectAdapter cardRowAdapter2 = new ArrayObjectAdapter(cardPresenter);
//        ArrayList<Movie> mItems2 = MovieProvider.getMovieItems(MovieProvider.HIP_HOP_NUMBER);
//        for (Movie movie : mItems2) {
//            cardRowAdapter2.add(movie);
//        }
//        mRowsAdapter.add(new ListRow(cardPresenterHeader2, cardRowAdapter2));
//
//        HeaderItem cardPresenterHeader3 = new HeaderItem(3, "Rock");
//        ArrayObjectAdapter cardRowAdapter3 = new ArrayObjectAdapter(cardPresenter);
//        ArrayList<Movie> mItems3 = MovieProvider.getMovieItems(MovieProvider.ROCK_NUMBER);
//        for (Movie movie : mItems3) {
//            cardRowAdapter3.add(movie);
//        }
//        mRowsAdapter.add(new ListRow(cardPresenterHeader3, cardRowAdapter3));
//
//        setAdapter(mRowsAdapter);
//    }

    private void setupUIElements() {

        setTitle("Music App");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.default_background));
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnSearchClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
            // each time the item is selected, code inside here will be executed.
            if (item instanceof String) {
                picassoBackgroundManager.updateBackgroundWithDelay("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/10/RIMG0656.jpg");
            } else if (item instanceof Movie) {              // CardPresenter
                picassoBackgroundManager.updateBackgroundWithDelay(((Movie) item).getCardImageUrl());
            }
        }
    }
    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                                  RowPresenter.ViewHolder rowViewHolder, Row row) {
            Movie movie = (Movie) item;
            Log.d(TAG, "Item: " + item.toString());
            Intent intent = new Intent(getActivity(), VideoDetailsActivity.class);
            intent.putExtra(VideoDetailsActivity.MOVIE, movie);

            getActivity().startActivity(intent);

        }
    }


}


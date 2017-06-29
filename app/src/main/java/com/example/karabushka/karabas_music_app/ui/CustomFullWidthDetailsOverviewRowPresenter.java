package com.example.karabushka.karabas_music_app.ui;

import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.RowPresenter;

/**
 * Created by Karabushka on 25.06.2017.
 */

public class CustomFullWidthDetailsOverviewRowPresenter extends FullWidthDetailsOverviewRowPresenter {

    private static final String TAG = CustomFullWidthDetailsOverviewRowPresenter.class.getSimpleName();

    CustomFullWidthDetailsOverviewRowPresenter(Presenter presenter) {
        super(presenter);
    }
    @Override
    protected void onBindRowViewHolder(RowPresenter.ViewHolder holder, Object item) {
        super.onBindRowViewHolder(holder, item);
        this.setState((ViewHolder) holder, FullWidthDetailsOverviewRowPresenter.STATE_SMALL);
    }
}

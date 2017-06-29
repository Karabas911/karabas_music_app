package com.example.karabushka.karabas_music_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.karabushka.karabas_music_app.R;

/**
 * Created by Karabushka on 25.06.2017.
 */
public class SearchActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    @Override
    public boolean onSearchRequested() {
        //if (mSearchFragment.hasResults()) {
        startActivity(new Intent(this, SearchActivity.class));
        //} else {
        //mSearchFragment.startRecognition();
        //}
        return true;
    }

}

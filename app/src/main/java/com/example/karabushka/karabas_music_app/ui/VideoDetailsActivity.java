package com.example.karabushka.karabas_music_app.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.karabushka.karabas_music_app.R;

/**
 * Created by Karabushka on 25.06.2017.
 */
public class VideoDetailsActivity extends FragmentActivity {
    public static final String MOVIE = "Movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
    }
}

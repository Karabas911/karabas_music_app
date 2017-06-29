/*
 * Copyright 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.karabushka.karabas_music_app;

import android.media.tv.TvContract;
import android.net.Uri;

import com.google.android.exoplayer.util.Util;
import com.google.android.media.tv.companionlibrary.EpgSyncJobService;
import com.google.android.media.tv.companionlibrary.model.Channel;
import com.google.android.media.tv.companionlibrary.model.InternalProviderData;
import com.google.android.media.tv.companionlibrary.model.Program;

import java.util.ArrayList;
import java.util.List;

/**
 * EpgSyncJobService that periodically runs to update channels and programs.
 */
public class SampleJobService extends EpgSyncJobService {
    private static final long PROGRAM_START_TIME_MS = 0;
    private static final long CO_PROGRAM_DURATION_MS = (3*60+43) * 1000;
    private static final long SW_PROGRAM_DURATION_MS = (3*60+3) * 1000;
    private static final long HH_PROGRAM_DURATION_MS = (3*60+33) * 1000;
    private static final long RK_PROGRAM_DURATION_MS = (3*60+48) * 1000;

    @Override
    public List<Channel> getChannels() {
        List<Channel> channelList = new ArrayList<>();
        // Add a channel programmatically
        InternalProviderData internalProviderData = new InternalProviderData();
        internalProviderData.setRepeatable(true);
        Channel channelChill = new Channel.Builder()
                .setDisplayName(getString(R.string.CHILL_OUT_CHANNEL_NAME))
                .setDisplayNumber(getString(R.string.CHILL_OUT_CHANNEL_NUMBER))
                .setChannelLogo(getString(R.string.CHILL_OUT_CHANNEL_LOGO))
                .setOriginalNetworkId(R.integer.CHILL_OUT_ORIGINAL_NETWORK_ID)
                .setInternalProviderData(internalProviderData)
                .build();
        channelList.add(channelChill);
        Channel channelSynthwave = new Channel.Builder()
                .setDisplayName(getString(R.string.SYNTHWAVE_CHANNEL_NAME))
                .setDisplayNumber(getString(R.string.SYNTHWAVE_CHANNEL_NUMBER))
                .setChannelLogo(getString(R.string.SYNTHWAVE_CHANNEL_LOGO))
                .setOriginalNetworkId(R.integer.SYNTHWAVE_ORIGINAL_NETWORK_ID)
                .setInternalProviderData(internalProviderData)
                .build();
        channelList.add(channelSynthwave);
        Channel channelHipHop = new Channel.Builder()
                .setDisplayName(getString(R.string.HIP_HOP_CHANNEL_NAME))
                .setDisplayNumber(getString(R.string.HIP_HOP_CHANNEL_NUMBER))
                .setChannelLogo(getString(R.string.HIP_HOP_CHANNEL_LOGO))
                .setOriginalNetworkId(R.integer.HIP_HOP_ORIGINAL_NETWORK_ID)
                .setInternalProviderData(internalProviderData)
                .build();
        channelList.add(channelHipHop);
        Channel channelRock = new Channel.Builder()
                .setDisplayName(getString(R.string.ROCK_CHANNEL_NAME))
                .setDisplayNumber(getString(R.string.ROCK_CHANNEL_NUMBER))
                .setChannelLogo(getString(R.string.ROCK_CHANNEL_LOGO))
                .setOriginalNetworkId(R.integer.ROCK_ORIGINAL_NETWORK_ID)
                .setInternalProviderData(internalProviderData)
                .build();
        channelList.add(channelRock);
        return channelList;
    }

    @Override
    public List<Program> getProgramsForChannel(Uri channelUri, Channel channel, long startMs,
                                               long endMs) {
        List<Program> programs = null;
        if(channel.getDisplayName().equals(getString(R.string.CHILL_OUT_CHANNEL_NAME))){
            programs = new ArrayList<>();
            InternalProviderData internalProviderData = new InternalProviderData();
            internalProviderData.setVideoType(Util.TYPE_OTHER);
            internalProviderData.setVideoUrl(getString(R.string.CO_PROGRAM_SOURCE));
            internalProviderData.setRepeatable(true);
            programs.add(new Program.Builder()
                    .setTitle(getString(R.string.CO_PROGRAM_TITLE))
                    .setStartTimeUtcMillis(PROGRAM_START_TIME_MS)
                    .setEndTimeUtcMillis(PROGRAM_START_TIME_MS + CO_PROGRAM_DURATION_MS)
                    .setDescription(getString(R.string.CO_PROGRAM_DESCRIPTION))
                    .setCanonicalGenres(new String[]{TvContract.Programs.Genres.MUSIC,
                            TvContract.Programs.Genres.MUSIC})
                    .setPosterArtUri(getString(R.string.CO_PROGRAM_ART))
                    .setThumbnailUri(getString(R.string.CO_PROGRAM_ART))
                    .setInternalProviderData(internalProviderData)
                    .build());
            }
        else if(channel.getDisplayName().equals(getString(R.string.SYNTHWAVE_CHANNEL_NAME))){
            programs = new ArrayList<>();
            InternalProviderData internalProviderData2 = new InternalProviderData();
            internalProviderData2.setVideoType(Util.TYPE_OTHER);
            internalProviderData2.setVideoUrl(getString(R.string.SW_PROGRAM_SOURCE));
            internalProviderData2.setRepeatable(true);
            programs.add(new Program.Builder()
                    .setTitle(getString(R.string.SW_PROGRAM_TITLE))
                    .setStartTimeUtcMillis(PROGRAM_START_TIME_MS)
                    .setEndTimeUtcMillis(PROGRAM_START_TIME_MS + SW_PROGRAM_DURATION_MS)
                    .setDescription(getString(R.string.SW_PROGRAM_DESCRIPTION))
                    .setCanonicalGenres(new String[]{TvContract.Programs.Genres.MUSIC,
                            TvContract.Programs.Genres.MUSIC})
                    .setPosterArtUri(getString(R.string.SW_PROGRAM_ART))
                    .setThumbnailUri(getString(R.string.SW_PROGRAM_ART))
                    .setInternalProviderData(internalProviderData2)
                    .build());
            }

        else if(channel.getDisplayName().equals(getString(R.string.HIP_HOP_CHANNEL_NAME))) {
            programs = new ArrayList<>();
            InternalProviderData internalProviderData3 = new InternalProviderData();
            internalProviderData3.setVideoType(Util.TYPE_OTHER);
            internalProviderData3.setVideoUrl(getString(R.string.HH_PROGRAM_SOURCE));
            internalProviderData3.setRepeatable(true);
            programs.add(new Program.Builder()
                    .setTitle(getString(R.string.HH_PROGRAM_TITLE))
                    .setStartTimeUtcMillis(PROGRAM_START_TIME_MS)
                    .setEndTimeUtcMillis(PROGRAM_START_TIME_MS + HH_PROGRAM_DURATION_MS)
                    .setDescription(getString(R.string.HH_PROGRAM_DESCRIPTION))
                    .setCanonicalGenres(new String[]{TvContract.Programs.Genres.MUSIC,
                            TvContract.Programs.Genres.MUSIC})
                    .setPosterArtUri(getString(R.string.HH_PROGRAM_ART))
                    .setThumbnailUri(getString(R.string.HH_PROGRAM_ART))
                    .setInternalProviderData(internalProviderData3)
                    .build());
            }
        else if (channel.getDisplayName().equals(getString(R.string.ROCK_CHANNEL_NAME))) {
            programs = new ArrayList<>();
            InternalProviderData internalProviderData4 = new InternalProviderData();
            internalProviderData4.setVideoType(Util.TYPE_OTHER);
            internalProviderData4.setVideoUrl(getString(R.string.RK_PROGRAM_SOURCE));
            internalProviderData4.setRepeatable(true);
            programs.add(new Program.Builder()
                    .setTitle(getString(R.string.RK_PROGRAM_TITLE))
                    .setStartTimeUtcMillis(PROGRAM_START_TIME_MS)
                    .setEndTimeUtcMillis(PROGRAM_START_TIME_MS + RK_PROGRAM_DURATION_MS)
                    .setDescription(getString(R.string.RK_PROGRAM_DESCRIPTION))
                    .setCanonicalGenres(new String[]{TvContract.Programs.Genres.MUSIC,
                            TvContract.Programs.Genres.MUSIC})
                    .setPosterArtUri(getString(R.string.RK_PROGRAM_ART))
                    .setThumbnailUri(getString(R.string.RK_PROGRAM_ART))
                    .setInternalProviderData(internalProviderData4)
                    .build());
        }
        return programs;
    }
}
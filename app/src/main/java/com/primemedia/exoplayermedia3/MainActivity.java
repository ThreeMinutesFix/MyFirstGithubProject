package com.primemedia.exoplayermedia3;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

public class MainActivity extends AppCompatActivity {
    PlayerView MediaPlayerView;
    ExoPlayer exoPlayer;
    Context context = this;
    String Url = "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4";
    public static long timeSaver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayerView = findViewById(R.id.MediaPlayerView);
        exoPlayer = new ExoPlayer.Builder(context).build();
        MediaItem mediaItem = MediaItem.fromUri(Url);
        exoPlayer.setMediaItem(mediaItem);
        MediaPlayerView.setPlayer(exoPlayer);
        exoPlayer.prepare();
        exoPlayer.play();
    }

    @Override
    protected void onStart() {
        super.onStart();
        exoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.setPlayWhenReady(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        exoPlayer.setPlayWhenReady(true);
    }
}
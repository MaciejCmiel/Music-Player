package com.example.macx.music_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by MacX on 2018-04-04.
 */

public class PlayerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ImageView playPause;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.play_screen);

        Log.i(PlayerActivity.class.getName(), "RUN TEST");

        String title = getIntent().getStringExtra("TITLE");
        String author = getIntent().getStringExtra("AUTHOR");
        int rawId = getIntent().getIntExtra("RAWID", 0);
        int imgId = getIntent().getIntExtra("IMGID", 0);

        Log.i(PlayerActivity.class.getName(), "TEST:" + title);
        TextView titleTextView = findViewById(R.id.title_text);
        titleTextView.setText(title);

        TextView authorTextView = findViewById(R.id.author_text);
        authorTextView.setText(author);

        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageResource(imgId);

        mediaPlayer = MediaPlayer.create(PlayerActivity.this, rawId);


        ImageView rewindBack = findViewById(R.id.rewind_backward);
        ImageView rewindForward = findViewById(R.id.rewind_forward);
        playPause = findViewById(R.id.play_pause);

        rewindBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                playPause.setImageResource(R.drawable.play);

            }
        });

        rewindForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                Intent backToPlaylist = new Intent(PlayerActivity.this, ListActivity.class);
                startActivity(backToPlaylist);
            }
        });

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playPause.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    playPause.setImageResource(R.drawable.pause);
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
                Intent backToPlaylist = new Intent(PlayerActivity.this, ListActivity.class);
                startActivity(backToPlaylist);
            }
        });

    }
}

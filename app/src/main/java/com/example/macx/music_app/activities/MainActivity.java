package com.example.macx.music_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.macx.music_app.R;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_SONGS = "songs";
    public static final String INTENT_ALBUMS = "albums";
    public static final String INTENT_AUTHORS = "authors";
    public static final String INTENT_DOWNLOADS = "downloads";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView songsList = findViewById(R.id.songs);
        TextView albumsList = findViewById(R.id.albums);
        TextView authorsList = findViewById(R.id.authors);
        TextView downloads = findViewById(R.id.downloaded);

        songsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", INTENT_SONGS);
                startActivity(typeOfList);
            }
        });

        albumsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", INTENT_ALBUMS);
                startActivity(typeOfList);
            }
        });

        authorsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", INTENT_AUTHORS);
                startActivity(typeOfList);
            }
        });

        downloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", INTENT_DOWNLOADS);
                startActivity(typeOfList);
            }
        });
    }
}

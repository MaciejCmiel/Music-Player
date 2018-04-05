package com.example.macx.music_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView songsList = findViewById(R.id.songs);
        TextView albumsList = findViewById(R.id.albums);
        TextView authorsList = findViewById(R.id.authors);
        TextView downloaded = findViewById(R.id.downloaded);

        songsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", "songs");
                startActivity(typeOfList);
            }
        });

        albumsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", "albums");
                startActivity(typeOfList);
            }
        });

        authorsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", "authors");
                startActivity(typeOfList);
            }
        });

        downloaded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent typeOfList = new Intent(MainActivity.this, ListActivity.class);
                typeOfList.putExtra("TYPE", "downloaded");
                startActivity(typeOfList);
            }
        });
    }
}

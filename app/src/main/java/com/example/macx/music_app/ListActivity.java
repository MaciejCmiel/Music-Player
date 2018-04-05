package com.example.macx.music_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by MacX on 2018-04-04.
 */

public class ListActivity extends AppCompatActivity {

    private SongAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.list);

        //Now it is useless but for future features this activity will have information
        //what type of list should be displayed depending on which TextView was clicked
        //now all four TextViews are displaying the same list of songs
        //String groupType = getIntent().getStringExtra("TYPE");

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Sail", "Avolnation", R.raw.sail_avolnation, R.drawable.sail_image));
        songs.add(new Song("Somewhere over the rainbow", "IZ", R.raw.somewhere, R.drawable.somewhere_over));
        songs.add(new Song("Mad World", "Gary Jules", R.raw.mad_world, R.drawable.mad_world));

        itemsAdapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Song currentSong = itemsAdapter.getItem(position);
                Intent songIntent = new Intent(ListActivity.this, PlayerActivity.class);
                songIntent.putExtra("TITLE", currentSong.getName()).putExtra("AUTHOR", currentSong.getAuthor()).putExtra("RAWID", currentSong.getRawId()).putExtra("IMGID", currentSong.getImageId());
                startActivity(songIntent);
            }
        });

    }


}

package com.example.macx.music_app;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by MacX on 2018-04-04.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Song currentSong = getItem(position);

        Log.i(SongAdapter.class.getName(), "TEST name: " + currentSong.getName());

        //find each TextView and set proper text for them
        TextView title = listItemView.findViewById(R.id.title_text);
        title.setText(currentSong.getName());

        TextView author = listItemView.findViewById(R.id.author_text);
        author.setText(currentSong.getAuthor());

        ImageView imageView = listItemView.findViewById(R.id.list_item_image);
        imageView.setImageResource(currentSong.getImageId());

        return listItemView;
    }
}

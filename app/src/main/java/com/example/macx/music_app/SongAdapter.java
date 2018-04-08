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

        ViewHolder holder;
        
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.title_text);
            holder.author = convertView.findViewById(R.id.author_text);
            holder.imageView = convertView.findViewById(R.id.list_item_image);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song currentSong = getItem(position);
        Log.i(SongAdapter.class.getName(), "TEST name: " + currentSong.getName());

        holder.title.setText(currentSong.getName());
        holder.author.setText(currentSong.getAuthor());
        holder.imageView.setImageResource(currentSong.getImageId());

        return convertView;
    }

    static class ViewHolder {
        private TextView title;
        private TextView author;
        private ImageView imageView;
    }
}

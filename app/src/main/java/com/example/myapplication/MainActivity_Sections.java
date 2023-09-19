package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity_Sections extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sections);
        ViewPager view = findViewById(R.id.view_pager);
        TabLayout layout = findViewById(R.id.tab_layout);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addfragment(new Fragment_songs(), "Music");
        adapter.addfragment(new Fragment_Playlists(), "Playlists");
        view.setAdapter(adapter);
        layout.setupWithViewPager(view);


    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;
        static ArrayList<Songs> songlist;

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            titles = new ArrayList<>();
        }

        //this is the main method that adds a fragment to the viewPager with the specified name
        void addfragment(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

    }
    public static ArrayList<Songs> getMusic(Context context) {
        ArrayList<Songs> temp_list = new ArrayList<>();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.TITLE
        };

    Cursor cursor = context.getContentResolver().query(uri,projection,null,null,null);
    if (cursor!=null){
        while(cursor.moveToNext()){
            String album = cursor.getString(0);
            String duration = cursor.getString(0);
            String artist = cursor.getString(0);
            String file = cursor.getString(0);
            String title = cursor.getString(0);
            Songs song = new Songs(file,title,duration,artist,album);
            temp_list.add(song);
        }
        cursor.close();

    }
    return temp_list;
    }

}

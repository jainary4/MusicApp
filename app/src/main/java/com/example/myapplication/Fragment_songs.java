package com.example.myapplication;

import static com.example.myapplication.MainActivity_Sections.MyPagerAdapter.songlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_songs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_songs extends Fragment {
    private RecyclerView recycler_view;
    private Music_panel_Adapter music_adapter;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_songs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_songs.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_songs newInstance(String param1, String param2) {
        Fragment_songs fragment = new Fragment_songs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_songs, container, false);
        recycler_view= view.findViewById(R.id.recycler_view_songs);
        recycler_view.hasFixedSize();
        if(!(songlist.size()<1)){
            music_adapter= new Music_panel_Adapter(getContext(),songlist);
            recycler_view.setAdapter(music_adapter);
            recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        }


        return view;
    }
}
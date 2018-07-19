package com.example.hasnainali.fragmentapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BestSongs  extends Fragment {
   // private static final String TAG = "Best Songs";
    ListView LV;
    List<String> list;
    ListAdapter adapter;
    MediaPlayer MP;
    Button play;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bestsongs, container, false);

        play = (Button) view.findViewById(R.id.btnPlay);
        LV = (ListView) view.findViewById(R.id.ListMusic);
        list = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for(int i=0 ; i<fields.length ; i++)
        {
            list.add(fields[i].getName());
        }

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,list);
        LV.setAdapter(adapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(MP != null)
                {
                    MP.release();
                }
                int resID = getResources().getIdentifier(list.get(i),"raw",getActivity().getPackageName());
                MP = MediaPlayer.create(getActivity(),resID);
                MP.start();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MP.isPlaying())
                {
                    MP.pause();
                    play.setText("Play");
                }
                else
                {
                    MP.start();
                    play.setText("Pause");

                }
            }
        });
        return view;
    }
    @Override
    public void onStop()
    {
        super.onStop();
        MP.stop();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        MP.stop();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
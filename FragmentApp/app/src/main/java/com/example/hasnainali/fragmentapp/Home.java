package com.example.hasnainali.fragmentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home extends Fragment {
   // private static final String TAG = "MainActivity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mviewpager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        //Log.d(TAG,"onCreate: Starting");
        mSectionsPageAdapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        mviewpager = (ViewPager)view.findViewById(R.id.container);
        setupViewPager(mviewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mviewpager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");
    }

    private void setupViewPager(ViewPager viewpager)
    {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new Utilities(),"Utilities");
        adapter.addFragment(new RateUs(),"Rate Us");
        adapter.addFragment(new BestSongs(),"Best Songs");
        viewpager.setAdapter(adapter);
    }
}

package com.example.hasnainali.fragmentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateUs extends Fragment {
    //private static final String TAG = "Rate Us";
    Button btRating;
    RatingBar ratebar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rateus, container, false);
        ratebar=(RatingBar)view.findViewById(R.id.ratingBar);
        btRating=(Button)view.findViewById(R.id.btRating);
        btRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Rating = String.valueOf(ratebar.getRating());
                Toast.makeText(getActivity(), Rating +"\nThanks For YourRating", Toast.LENGTH_LONG).show();
                //getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

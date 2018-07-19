package com.example.hasnainali.fragmentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Utilities extends Fragment {
   // private static final String TAG = "Utilities";
    Button btTakePic,btECall,btMaps,btFB;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.utilities, container, false);
        btTakePic = (Button) view.findViewById(R.id.btnTakePic);
        btECall = (Button) view.findViewById(R.id.btnECall);
        btMaps = (Button) view.findViewById(R.id.btnMaps);
        btFB = (Button) view.findViewById(R.id.btnFB);
        btTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Camera",Toast.LENGTH_SHORT).show();
                Intent CameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(CameraIntent);
            }
        });

        btMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Google Map",Toast.LENGTH_SHORT).show();
                Intent MapIntent = new Intent(Intent.ACTION_VIEW);
                MapIntent.setData(Uri.parse("geo:24.8799064,67.05886950000001"));
                //Intent Chooser = Intent.createChooser(MapIntent,"Launch Map");
                startActivity(MapIntent);
            }
        });

        btECall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity() ,"Call",Toast.LENGTH_SHORT).show();
                Intent CallIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1020"));
                startActivity(CallIntent);
            }
        });

        btFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity() ,"Facebook",Toast.LENGTH_SHORT).show();
                Intent FacebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(FacebookIntent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
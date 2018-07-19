package com.example.hasnainali.fragmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Fragment {
    Button btLog;
    EditText EUN,EP;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);
        btLog = (Button) view.findViewById(R.id.btnLog);
        EUN = (EditText) view.findViewById(R.id.ETUN);
        EP = (EditText) view.findViewById(R.id.ETP);

        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UN = ("BeginerDeveloper@gmail.com");
                String Pass = ("1234");
                StringBuilder Check=new StringBuilder();

                if(EUN.getText().toString().equals(UN) && EP.getText().toString().equals(Pass))
                {
                    Check.append("Login Granted");
                    Toast.makeText(getActivity(), Check.toString(), Toast.LENGTH_LONG).show();
                }
                else
                {
                    Check.append("Invalid UserName Or Password!");
                    Toast.makeText(getActivity(), Check.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Login");
    }
}


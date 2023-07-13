package com.example.agro.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.agro.Activities.GetDataActivity;
import com.example.agro.Login.LoginActivity;
import com.example.agro.R;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding profileXml;
    SessionManagement sessionManagement;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        profileXml=FragmentProfileBinding.inflate(inflater,container,false);
        View rootView=profileXml.getRoot();
        sessionManagement=new SessionManagement(getContext());
        String Email=sessionManagement.GetEmail();

        profileXml.tvProEmailId.setText(Email);


        profileXml.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GetDataActivity.class);
                startActivity(intent);
            }
        });

        profileXml.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement=new SessionManagement(getContext());
                    sessionManagement.RemoveEmail();
                    sessionManagement.clear();
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        profileXml.tvProFirstName.setText(sessionManagement.GetFirstName());
        profileXml.tvProLastName.setText(sessionManagement.GetLastName());
        profileXml.tvProMobile.setText(sessionManagement.GetMobileNo());


        // Inflate the layout for this fragment
        return rootView;
    }
}
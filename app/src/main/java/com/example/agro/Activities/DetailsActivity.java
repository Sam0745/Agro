package com.example.agro.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.agro.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding detailsXml;
    String text ;
    Integer img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsXml=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(detailsXml.getRoot());

        text=getIntent().getStringExtra("text");
        detailsXml.detailsName.setText(text);

        img=getIntent().getIntExtra("image",1);
        detailsXml.detailImg.setImageResource(img);


    }
}
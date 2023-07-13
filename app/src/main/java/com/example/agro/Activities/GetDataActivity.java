package com.example.agro.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.agro.Fragments.ProfileFragment;
import com.example.agro.R;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.ActivityGetDataBinding;

public class GetDataActivity extends AppCompatActivity {

    ActivityGetDataBinding getDataXml;
    SessionManagement sessionManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDataXml=ActivityGetDataBinding.inflate(getLayoutInflater());
        setContentView(getDataXml.getRoot());

        getDataXml.saveDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckValidation();

            }
        });

        getDataXml.dataBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(GetDataActivity.this,MainActivity.class);
               startActivity(intent);
            }
        });

    }
    public void CheckValidation(){
        if (getDataXml.etFirstName.getText().toString().isEmpty()){
            Toast.makeText(this, "--Please enter your Firstname--", Toast.LENGTH_SHORT).show();
        }
        else if (getDataXml.etLastName.getText().toString().isEmpty()){
            Toast.makeText(this, "--Please enter your Lastname", Toast.LENGTH_SHORT).show();
        }
        else if(getDataXml.etMobileNo.getText().toString().isEmpty()){
            Toast.makeText(this, "--Please enter your Mobile number--", Toast.LENGTH_SHORT).show();
        }
        else{
            sessionManagement=new SessionManagement(this);
            sessionManagement.SaveData(getDataXml.etFirstName.getText().toString(),getDataXml.etLastName.getText().toString(),getDataXml.etMobileNo.getText().toString());
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
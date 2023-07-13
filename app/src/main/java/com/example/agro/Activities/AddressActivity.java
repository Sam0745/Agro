package com.example.agro.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.agro.R;
import com.example.agro.databinding.ActivityAddressBinding;


public class AddressActivity extends AppCompatActivity {
    ActivityAddressBinding addressXml;
    String name, flat, area, landmark, city, state;

    String totalRate,totalItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addressXml = ActivityAddressBinding.inflate(getLayoutInflater());
        setContentView(addressXml.getRoot());

        totalItems= getIntent().getStringExtra("totalItems");
        totalRate=getIntent().getStringExtra("totalRate");

        addressXml.addressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = addressXml.etName.getText().toString();
                flat = addressXml.etFlat.getText().toString();
                area = addressXml.etArea.getText().toString();
                landmark = addressXml.etLandmark.getText().toString();
                city = addressXml.etTown.getText().toString();
                state = addressXml.etState.getText().toString();



                    if (name.isEmpty()){
                        Toast.makeText(AddressActivity.this, "Enter your name", Toast.LENGTH_SHORT).show();
                    }
                    else if (addressXml.etMobile.getText().length() != 10 ) {
                        Toast.makeText(AddressActivity.this, "Enter valid mobile number", Toast.LENGTH_SHORT).show();

                    }
                    else if (flat.isEmpty()){
                        Toast.makeText(AddressActivity.this, "Enter your Flat, house no.", Toast.LENGTH_SHORT).show();
                    }
                    else if (area.isEmpty()){
                        Toast.makeText(AddressActivity.this, "Enter your Area,Street", Toast.LENGTH_SHORT).show();
                    }
                    else if (landmark.isEmpty()){
                        Toast.makeText(AddressActivity.this, "Enter your landmark", Toast.LENGTH_SHORT).show();
                    }
                    else if (city.isEmpty()){
                        Toast.makeText(AddressActivity.this, "Enter your City/town", Toast.LENGTH_SHORT).show();
                    }
                    else if (state.isEmpty()){
                        Toast.makeText(AddressActivity.this, "Enter your State", Toast.LENGTH_SHORT).show();
                    }
                    else if (addressXml.etPincode.getText().toString().isEmpty()){
                        Toast.makeText(AddressActivity.this, "Enter PinCode", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AddressActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(AddressActivity.this,BillActivity.class);
                        intent.putExtra("name",addressXml.etName.getText().toString());
                        intent.putExtra("flat",addressXml.etFlat.getText().toString());
                        intent.putExtra("town",addressXml.etTown.getText().toString());
                        intent.putExtra("landMark",addressXml.etLandmark.getText().toString());
                        intent.putExtra("pinCode",addressXml.etPincode.getText().toString());
                        intent.putExtra("state",addressXml.etState.getText().toString());
                        intent.putExtra("mobile",addressXml.etMobile.getText().toString());
                        intent.putExtra("totalRate",totalRate);
                        intent.putExtra("totalItems",totalItems);
                        startActivity(intent);
                    }

            }
        });

    }
}
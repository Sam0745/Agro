package com.example.agro.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.agro.R;
import com.example.agro.databinding.ActivityBillBinding;

public class BillActivity extends AppCompatActivity {

    ActivityBillBinding billXml;
    String name,mobile,flat,area,landmark,pinCode,city,state,totalItem,totalRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        billXml=ActivityBillBinding.inflate(getLayoutInflater());
        setContentView(billXml.getRoot());
        name=getIntent().getStringExtra("name");
        mobile=getIntent().getStringExtra("mobile");
        flat=getIntent().getStringExtra("flat");
        area=getIntent().getStringExtra("name");
        landmark=getIntent().getStringExtra("landMark");
        pinCode=getIntent().getStringExtra("pinCode");
        city=getIntent().getStringExtra("town");
        state=getIntent().getStringExtra("state");
        totalItem=getIntent().getStringExtra("totalItems");
        totalRate=getIntent().getStringExtra("totalRate");

        billXml.tvCustomerName.setText(name);
        billXml.tvCustomerAddress.setText(flat+" "+area+" "+landmark+" "+pinCode+" "+city+" "+state);
        billXml.tvCustomerMobile.setText(mobile);

        billXml.tvTotalPrice.setText(totalRate);
        billXml.ivPriceWithItems.setText("Price ("+totalItem+" items"+") ");
        billXml.etTotalAmt.setText("₹ "+totalRate);






    }
}
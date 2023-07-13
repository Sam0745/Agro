package com.example.agro.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.example.agro.RecyclerView.PlaceOrderRecycler.PlaceOrderRvAdaptor;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.ActivityPlaceOrderBinding;

import java.util.ArrayList;

public class PlaceOrderActivity extends AppCompatActivity {

    ActivityPlaceOrderBinding placeOrderXml;
    ArrayList<CartRecyclerModel> orderList;
    PlaceOrderRvAdaptor orderRvAdaptor;
    LinearLayoutManager layoutManager;
    SessionManagement sessionManagement;
    int order=0;
    int sum=0;
    int listLength;
    int totalRate;
    int totalItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        placeOrderXml=ActivityPlaceOrderBinding.inflate(getLayoutInflater());
        setContentView(placeOrderXml.getRoot());

        sessionManagement=new SessionManagement(this);
        orderList=new ArrayList<>();
        orderList=sessionManagement.getCartDetails();
        orderRvAdaptor=new PlaceOrderRvAdaptor(orderList,this);
        layoutManager=new LinearLayoutManager(this);
        placeOrderXml.rvPlaceOrder.setLayoutManager(layoutManager);
        placeOrderXml.rvPlaceOrder.setAdapter(orderRvAdaptor);
        placeOrderXml.placeOrderBtn.setText("Proceed to Buy ("+orderList.size()+" items)");


        listLength=orderList.size();

            for(int i=0;i<listLength;i++){

                order= Integer.parseInt(orderList.get(i).getRate());
                sum=order+sum;
            }

            totalRate=sum;
            totalItems=orderList.size();




           /* placeOrderXml.placeOrderBtn.setText(String.valueOf(totalRate));*/

            placeOrderXml.placeOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(PlaceOrderActivity.this, AddressActivity.class);
                    intent.putExtra("totalRate",String.valueOf(totalRate));
                    intent.putExtra("totalItems",String.valueOf(totalItems));
                    startActivity(intent);
                }
            });
    }
}
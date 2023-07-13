package com.example.agro.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.agro.Activities.PlaceOrderActivity;
import com.example.agro.R;
import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;
import com.example.agro.RecyclerView.PlaceOrderRecycler.PlaceOrderRvAdaptor;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.FragmentDetailsBinding;
import com.example.agro.databinding.FragmentHomeBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class DetailsFragment extends Fragment {

        FragmentDetailsBinding detailsXml;
        int img1;
        Toolbar toolBar;
        SessionManagement sessionManagement;
        BottomNavigationView bottomNavigationView;
        /*List<CartRecyclerModel>orderList;
        PlaceOrderRvAdaptor orderRvAdaptor;
        LinearLayoutManager layoutManager;*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bottomNavigationView=getActivity().findViewById(R.id.myBottomNavi);
        detailsXml = FragmentDetailsBinding.inflate(inflater,container,false);
        View rootView=detailsXml.getRoot();
        toolBar = getActivity().findViewById(R.id.toolBar);

        detailsXml.detailsName.setText(this.getArguments().getString("text"));
        detailsXml.detailImg.setImageResource(this.getArguments().getInt("image"));

        img1=this.getArguments().getInt("image");


        detailsXml.addCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* AddToCartFragment cartFragment=new AddToCartFragment();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();

                Bundle bundle=new Bundle();
                bundle.putInt("image",img1);
                bundle.putString("name",detailsXml.detailsName.getText().toString());
                bundle.putString("rate",detailsXml.etRupee.getText().toString());
                cartFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.container,cartFragment).commit();*/

                toolBar.setTitle("Add to Cart");

                Toast.makeText(getContext(), "Added Successfully", Toast.LENGTH_SHORT).show();

                sessionManagement=new SessionManagement(getActivity());
                CartRecyclerModel model = new CartRecyclerModel();
                model.setCartImage(img1);
                model.setName(detailsXml.detailsName.getText().toString());
                model.setRate(Integer.parseInt(String.valueOf(detailsXml.etRupee.getText())));

                sessionManagement.addCartDetails(model);


                BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cartTab);
                badgeDrawable.setVisible(true);
                sessionManagement=new SessionManagement(getContext());
                badgeDrawable.setNumber(sessionManagement.getCartDetails().size());
                Toast.makeText(getActivity(), "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        detailsXml.placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                detailsXml.addCartBtn.callOnClick();
                Intent intent=new Intent(getActivity(), PlaceOrderActivity.class);
                startActivity(intent);
                /*sessionManagement=new SessionManagement(getContext());
                orderList=new ArrayList<>();
                orderList=sessionManagement.getCartDetails();
                orderRvAdaptor=new PlaceOrderRvAdaptor(orderList,getContext());
                orderList=sessionManagement.getCartDetails();*/


            }
        });
        return rootView;

    }
}
package com.example.agro.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.agro.Activities.PlaceOrderActivity;
import com.example.agro.Interface.RvInterface;
import com.example.agro.R;
import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerViewAdaptor;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.FragmentAddToCartBinding;
import com.example.agro.databinding.FragmentDetailsBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class AddToCartFragment extends Fragment implements RvInterface {

    FragmentAddToCartBinding addCartXml;
    List<CartRecyclerModel> cartList1;
    LinearLayoutManager layoutManager;
    CartRecyclerViewAdaptor cartAdaptor;
    SessionManagement sessionManagement;
    BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addCartXml = FragmentAddToCartBinding.inflate(inflater, container, false);
        View rootView = addCartXml.getRoot();
        bottomNavigationView=getActivity().findViewById(R.id.myBottomNavi);

        cartList1 = new ArrayList<>();


        setUpAdapter();

        addCartXml.placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PlaceOrderActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    public void setUpAdapter() {
        cartAdaptor = new CartRecyclerViewAdaptor(getContext(), this);
        sessionManagement = new SessionManagement(getActivity());
        cartList1 = sessionManagement.getCartDetails();
        cartAdaptor.cartList(cartList1);
        layoutManager = new LinearLayoutManager(getActivity());
        addCartXml.cartRecyclerView.setLayoutManager(layoutManager);
        addCartXml.cartRecyclerView.setAdapter(cartAdaptor);
        cartAdaptor.notifyDataSetChanged();


    }


    @Override
    public void ItemClick(int position, CartRecyclerModel cartRecyclerModel) {
        cartList1.remove(position);
        sessionManagement.clearSingleItem(position);
        cartAdaptor.notifyItemRemoved(cartList1.size()+1);
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cartTab);

        badgeDrawable.setVisible(true);

        sessionManagement=new SessionManagement(getActivity());
        badgeDrawable.setNumber(sessionManagement.getCartDetails().size());

    }
}
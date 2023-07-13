package com.example.agro.RecyclerView.PlaceOrderRecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agro.R;
import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderRvAdaptor extends RecyclerView.Adapter<PlaceOrderRvAdaptor.ViewHolder> {

    List<CartRecyclerModel> orderList;
    Context context;

    public PlaceOrderRvAdaptor(List<CartRecyclerModel> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceOrderRvAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.placeorder_rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceOrderRvAdaptor.ViewHolder holder, int position) {

        holder.img.setImageResource(orderList.get(position).getCartImage());
        holder.name.setText(orderList.get(position).getName());
        holder.rate.setText(orderList.get(position).getRate());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name,rate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.ivPlaceOrder);
            name=itemView.findViewById(R.id.tvPlaceOrderName);
            rate=itemView.findViewById(R.id.etPlaceOrderRupee);
        }
    }
}

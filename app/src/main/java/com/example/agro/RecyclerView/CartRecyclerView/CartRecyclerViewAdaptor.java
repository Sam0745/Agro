package com.example.agro.RecyclerView.CartRecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agro.Fragments.AddToCartFragment;
import com.example.agro.Interface.RvInterface;
import com.example.agro.R;
import com.example.agro.Session.SessionManagement;

import java.util.ArrayList;
import java.util.List;

public class CartRecyclerViewAdaptor extends RecyclerView.Adapter<CartRecyclerViewAdaptor.ViewHolder> {

    List<CartRecyclerModel> cartList;
    Context context;
    RvInterface rvInterface;
    CartRecyclerViewAdaptor adaptor;
    SessionManagement sessionManagement;


    public CartRecyclerViewAdaptor(Context context, RvInterface rvInterface) {
        this.context = context;
        this.rvInterface = rvInterface;
    }

    @NonNull
    @Override
    public CartRecyclerViewAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_rv_layout, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull CartRecyclerViewAdaptor.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(cartList.get(position).getCartImage());
        holder.name.setText(cartList.get(position).getName());
        holder.rate.setText(cartList.get(position).getRate());


        holder.deleteCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rvInterface.ItemClick(position, cartList.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, deleteCart;
        TextView name, rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cartRvImg);
            name = itemView.findViewById(R.id.tvCartName);
            rate = itemView.findViewById(R.id.etCartRupee);
            deleteCart = itemView.findViewById(R.id.ivDelete);


        }
    }

    public void cartList(List<CartRecyclerModel> list) {
        this.cartList = list;
        notifyDataSetChanged();
    }

}

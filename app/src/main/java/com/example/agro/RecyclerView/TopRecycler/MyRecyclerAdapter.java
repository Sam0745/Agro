package com.example.agro.RecyclerView.TopRecycler;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agro.Fragments.DetailsFragment;
import com.example.agro.Fragments.TopRecyclerDetailsFragment;
import com.example.agro.R;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
        Context context;
        ArrayList<MyModel> list;

    public MyRecyclerAdapter(Context context, ArrayList<MyModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
            holder.text.setText(list.get(position).getText());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity= (AppCompatActivity) v.getContext();
                    TopRecyclerDetailsFragment topRecyclerDetailsFragment =new TopRecyclerDetailsFragment();
                    Bundle bundle=new Bundle();
                    topRecyclerDetailsFragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,topRecyclerDetailsFragment).addToBackStack(null).commit();
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.myText);
            cardView=itemView.findViewById(R.id.topRvCard);
        }
    }
}

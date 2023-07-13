package com.example.agro.RecyclerView.ChildRecycler;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agro.Fragments.DetailsFragment;
import com.example.agro.R;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {

    ArrayList<ChildRvModel> childList;
    Context context;



    public ChildAdapter(ArrayList<ChildRvModel> childList, Context context) {
        this.childList = childList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_child_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ViewHolder holder, int position) {

        holder.img.setImageResource(childList.get(position).getImg());
        holder.txt.setText(childList.get(position).getText());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent=new Intent(context, DetailsActivity.class);
                intent.putExtra("image",childList.get(position).getImg());
                intent.putExtra("text",childList.get(position).getText());
                context.startActivity(intent);*/

                AppCompatActivity activity= (AppCompatActivity) v.getContext();
                DetailsFragment detailsFragment=new DetailsFragment();

                Bundle bundle=new Bundle();
                bundle.putInt("image",childList.get(position).getImg());
                bundle.putString("text",childList.get(position).getText());
                detailsFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,detailsFragment).addToBackStack(null).commit();


            }
        });

    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt,addBtn;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.myChildCardView);
            img=itemView.findViewById(R.id.childImg);
            txt=itemView.findViewById(R.id.childTxt);
            addBtn=itemView.findViewById(R.id.childAddBtn);
        }
    }
}

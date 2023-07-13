package com.example.agro.RecyclerView.TopRvDetails;

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
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;

import java.util.ArrayList;
import java.util.List;

public class TopRvDetailsAdapter extends RecyclerView.Adapter<TopRvDetailsAdapter.ViewHolder> {
    List<ChildRvModel> topDetailsList;
    Context context;

    public TopRvDetailsAdapter(List<ChildRvModel> topDetailsList, Context context) {
        this.topDetailsList = topDetailsList;
        this.context = context;
    }



    public void setFilteredList(List<ChildRvModel>filteredList){
        this.topDetailsList=filteredList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public TopRvDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_top_rv_details_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRvDetailsAdapter.ViewHolder holder, int position) {

        holder.img.setImageResource(topDetailsList.get(position).getImg());
        holder.txt.setText(topDetailsList.get(position).getText());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity= (AppCompatActivity) v.getContext();
                DetailsFragment detailsFragment=new DetailsFragment();

                Bundle bundle=new Bundle();
                bundle.putInt("image",topDetailsList.get(position).getImg());
                bundle.putString("text",topDetailsList.get(position).getText());
                detailsFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,detailsFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return topDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.myTopRvDetailsImg);
            txt=itemView.findViewById(R.id.myTopRvDetailsTxt);
            cardView=itemView.findViewById(R.id.myTopRvDetailsCardView);

        }
    }
}

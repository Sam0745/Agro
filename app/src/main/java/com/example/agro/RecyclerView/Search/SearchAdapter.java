package com.example.agro.RecyclerView.Search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agro.Activities.MainActivity;
import com.example.agro.Fragments.DetailsFragment;
import com.example.agro.Interface.RvInterface;
import com.example.agro.Interface.RvInterfscesecond;
import com.example.agro.R;
import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;
import com.example.agro.Session.SessionManagement;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    List<ChildRvModel> topDetailsList;
    Context context;
    SessionManagement sessionManagement;
    BadgeDrawable badgeDrawable;
    RvInterfscesecond rvInterface;


    public SearchAdapter(List<ChildRvModel> topDetailsList, Context context, RvInterfscesecond rvInterface) {
        this.topDetailsList = topDetailsList;
        this.context = context;
        this.rvInterface=rvInterface;
    }



    public void setFilteredList(List<ChildRvModel>filteredList){
        this.topDetailsList=filteredList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_top_rv_details_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {

        holder.img.setImageResource(topDetailsList.get(position).getImg());
        holder.txt.setText(topDetailsList.get(position).getText());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rvInterface.ItemClick(position);

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
        BottomNavigationView bottomNavigationView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bottomNavigationView=itemView.findViewById(R.id.myBottomNavi);
            img=itemView.findViewById(R.id.myTopRvDetailsImg);
            txt=itemView.findViewById(R.id.myTopRvDetailsTxt);
            cardView=itemView.findViewById(R.id.myTopRvDetailsCardView);

        }
    }
}

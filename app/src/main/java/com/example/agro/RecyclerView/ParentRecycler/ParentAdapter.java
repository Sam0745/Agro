package com.example.agro.RecyclerView.ParentRecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agro.R;
import com.example.agro.RecyclerView.ChildRecycler.ChildAdapter;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {

    List<ParentRvModel>parentList;

    public ParentAdapter(List<ParentRvModel> parentList, Context context) {
        this.parentList = parentList;
        this.context = context;
    }

    Context context;
    @NonNull
    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_parent_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.ViewHolder holder, int position) {

        holder.title.setText(parentList.get(position).getHeading());
        ChildAdapter childAdapter=new ChildAdapter(parentList.get(position).childRvModelList,context);
        holder.rvChild.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.rvChild.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvChild;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tvParentHeading);
            rvChild=itemView.findViewById(R.id.childRv);

        }
    }
}

package com.example.agro.RecyclerView.ParentRecycler;

import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;

import java.util.ArrayList;
import java.util.List;

public class ParentRvModel {
    String heading;
    ArrayList<ChildRvModel>childRvModelList;
    public ParentRvModel(String heading, ArrayList<ChildRvModel> childRvModelList) {
        this.heading = heading;
        this.childRvModelList = childRvModelList;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public ArrayList<ChildRvModel> getChildRvModelList() {
        return childRvModelList;
    }

    public void setChildRvModelList(ArrayList<ChildRvModel> childRvModelList) {
        this.childRvModelList = childRvModelList;
    }


}

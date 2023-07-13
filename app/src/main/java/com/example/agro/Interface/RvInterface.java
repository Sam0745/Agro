package com.example.agro.Interface;

import android.icu.text.Transliterator;

import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;

public interface RvInterface {

    void ItemClick(int position, CartRecyclerModel cartRecyclerModel);

}

package com.example.agro.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agro.R;
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;
import com.example.agro.RecyclerView.TopRvDetails.TopRvDetailsAdapter;
import com.example.agro.databinding.FragmentTopRecyclerDetailsBinding;

import java.util.ArrayList;

public class TopRecyclerDetailsFragment extends Fragment {

    FragmentTopRecyclerDetailsBinding topDetailsXml;
    TopRvDetailsAdapter topDetailsAdapter;
    LinearLayoutManager layoutManager;
    ArrayList<ChildRvModel> topDetailsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        topDetailsXml=FragmentTopRecyclerDetailsBinding.inflate(inflater,container,false);
        View rootView=topDetailsXml.getRoot();

        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        topDetailsXml.topRvDetails.setLayoutManager(layoutManager);

        topDetailsList=new ArrayList<>();
        topDetailsList.add(new ChildRvModel("Maize",R.drawable.corn1));
        topDetailsList.add(new ChildRvModel("Bajra",R.drawable.bajra));
        topDetailsList.add(new ChildRvModel("Jowar",R.drawable.jowar));
        topDetailsList.add(new ChildRvModel("Wheat",R.drawable.wheat));
        topDetailsList.add(new ChildRvModel("Barley",R.drawable.barley));
        topDetailsList.add(new ChildRvModel("Peas",R.drawable.peas));
        topDetailsList.add(new ChildRvModel("Gram",R.drawable.gram));
        topDetailsList.add(new ChildRvModel("Ammonia",R.drawable.ammonia));
        topDetailsList.add(new ChildRvModel("Calcium Nitrate",R.drawable.calcium_nitrate));
        topDetailsList.add(new ChildRvModel("Cotton seed",R.drawable.cotton_seed_meal));
        topDetailsList.add(new ChildRvModel("Monoammonium",R.drawable.mono));
        topDetailsList.add(new ChildRvModel("Potash",R.drawable.potash));
        topDetailsList.add(new ChildRvModel("P Chloride",R.drawable.pta_chioride));
        topDetailsList.add(new ChildRvModel("Sodium Nitrate",R.drawable.sodium_nitrate));
        topDetailsList.add(new ChildRvModel("Manure",R.drawable.manure));

        topDetailsAdapter=new TopRvDetailsAdapter(topDetailsList,getContext());
        topDetailsXml.topRvDetails.setAdapter(topDetailsAdapter);
        topDetailsAdapter.notifyDataSetChanged();


        return rootView;

    }
}
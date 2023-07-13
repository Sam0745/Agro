package com.example.agro.Fragments;

import android.content.ClipData;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.agro.Interface.RvInterfscesecond;
import com.example.agro.R;
import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;
import com.example.agro.RecyclerView.Search.SearchAdapter;
import com.example.agro.RecyclerView.TopRvDetails.TopRvDetailsAdapter;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.FragmentSearchBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements RvInterfscesecond {

    FragmentSearchBinding searchXml;
    List<ChildRvModel> itemList;
    SearchAdapter adapter;
    LinearLayoutManager layoutManager;
    BadgeDrawable badgeDrawable;
    BottomNavigationView bottomNavigationView;
    SessionManagement sessionManagement;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        searchXml=FragmentSearchBinding.inflate(inflater,container,false);
        View rootView=searchXml.getRoot();

        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        searchXml.mySearchViewRv.setLayoutManager(layoutManager);

        itemList=new ArrayList<>();
        itemList.add(new ChildRvModel("Maize",R.drawable.corn1));
        itemList.add(new ChildRvModel("Bajra",R.drawable.bajra));
        itemList.add(new ChildRvModel("Jowar",R.drawable.jowar));
        itemList.add(new ChildRvModel("Wheat",R.drawable.wheat));
        itemList.add(new ChildRvModel("Barley",R.drawable.barley));
        itemList.add(new ChildRvModel("Peas",R.drawable.peas));
        itemList.add(new ChildRvModel("Gram",R.drawable.gram));
        itemList.add(new ChildRvModel("Ammonia",R.drawable.ammonia));
        itemList.add(new ChildRvModel("Calcium Nitrate",R.drawable.calcium_nitrate));
        itemList.add(new ChildRvModel("Cotton seed",R.drawable.cotton_seed_meal));
        itemList.add(new ChildRvModel("Monoammonium",R.drawable.mono));
        itemList.add(new ChildRvModel("Potash",R.drawable.potash));
        itemList.add(new ChildRvModel("P Chloride",R.drawable.pta_chioride));
        itemList.add(new ChildRvModel("Sodium Nitrate",R.drawable.sodium_nitrate));
        itemList.add(new ChildRvModel("Manure",R.drawable.manure));

        adapter=new SearchAdapter(itemList,getContext(),this);
        searchXml.mySearchViewRv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        searchXml.mySearchView.clearFocus();
        searchXml.mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        return rootView;
    }

    private void filterList(String text) {
        List<ChildRvModel> filteredList=new ArrayList<>();
        for (ChildRvModel item:itemList){

            if (item.getText().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
        }else
            adapter.setFilteredList(filteredList);


    }

    @Override
    public void ItemClick(int position) {
        bottomNavigationView=getActivity().findViewById(R.id.myBottomNavi);
        badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cartTab);
        sessionManagement=new SessionManagement(getContext());
        CartRecyclerModel model = new CartRecyclerModel();
        model.setCartImage(itemList.get(position).getImg());
        model.setName(itemList.get(position).getText());
        model.setRate(500);

        sessionManagement.addCartDetails(model);



        badgeDrawable.setVisible(true);
        sessionManagement=new SessionManagement(getContext());
        badgeDrawable.setNumber(sessionManagement.getCartDetails().size());
        Toast.makeText(getContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
    }
}
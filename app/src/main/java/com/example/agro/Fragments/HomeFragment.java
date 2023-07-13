package com.example.agro.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agro.Activities.MainActivity;
import com.example.agro.R;
import com.example.agro.RecyclerView.ChildRecycler.ChildRvModel;
import com.example.agro.RecyclerView.ParentRecycler.ParentAdapter;
import com.example.agro.RecyclerView.ParentRecycler.ParentRvModel;
import com.example.agro.RecyclerView.TopRecycler.MyModel;
import com.example.agro.RecyclerView.TopRecycler.MyRecyclerAdapter;
import com.example.agro.ViewPager.MyViewPageAdaptor;
import com.example.agro.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    FragmentHomeBinding homeXml;
    ArrayList<Integer> imgList=new ArrayList<>();
    ArrayList<MyModel>textList;
    ArrayList<ParentRvModel>parentArrayList;
    ArrayList<ChildRvModel>cropList;
    ArrayList<ChildRvModel>fertilizerList;

    Timer timer;
    Handler handler;
    LinearLayoutManager layoutManager;
    MyRecyclerAdapter myRecyclerAdapter;
    ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgList.add(R.drawable.img1);
        imgList.add(R.drawable.img2);
        imgList.add(R.drawable.img3);
        imgList.add(R.drawable.img4);
        imgList.add(R.drawable.img5);
        imgList.add(R.drawable.img6);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeXml =FragmentHomeBinding.inflate(inflater,container,false);
        View rootView=homeXml.getRoot();



        layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        homeXml.myRv.setLayoutManager(layoutManager);
        textList=new ArrayList<>();
        textList.add(new MyModel("Farming"));
        textList.add(new MyModel("Cultivation"));
        textList.add(new MyModel("Gardening"));
        textList.add(new MyModel("Culture"));
        textList.add(new MyModel("Animal Husbandry"));
        textList.add(new MyModel("Crop"));
        textList.add(new MyModel("Fertile"));

        myRecyclerAdapter=new MyRecyclerAdapter(getActivity(),textList);
        homeXml.myRv.setAdapter(myRecyclerAdapter);

        ParentAdapter parentAdapter;
        parentArrayList=new ArrayList<>();
        cropList=new ArrayList<>();
        fertilizerList=new ArrayList<>();


        cropList.add(new ChildRvModel("Maize",R.drawable.corn1));
        cropList.add(new ChildRvModel("Bajra",R.drawable.bajra));
        cropList.add(new ChildRvModel("Jowar",R.drawable.jowar));
        cropList.add(new ChildRvModel("Wheat",R.drawable.wheat));
        cropList.add(new ChildRvModel("Barley",R.drawable.barley));
        cropList.add(new ChildRvModel("Peas",R.drawable.peas));
        cropList.add(new ChildRvModel("Gram",R.drawable.gram));

        parentArrayList.add(new ParentRvModel("Crops",cropList));

        fertilizerList.add(new ChildRvModel("Ammonia",R.drawable.ammonia));
        fertilizerList.add(new ChildRvModel("Calcium Nitrate",R.drawable.calcium_nitrate));
        fertilizerList.add(new ChildRvModel("Cotton seed",R.drawable.cotton_seed_meal));
        fertilizerList.add(new ChildRvModel("Monoammonium",R.drawable.mono));
        fertilizerList.add(new ChildRvModel("Potash",R.drawable.potash));
        fertilizerList.add(new ChildRvModel("P Chloride",R.drawable.pta_chioride));
        fertilizerList.add(new ChildRvModel("Sodium Nitrate",R.drawable.sodium_nitrate));
        fertilizerList.add(new ChildRvModel("Manure",R.drawable.manure));

        parentArrayList.add(new ParentRvModel("Fertilizers",fertilizerList));





        parentAdapter=new ParentAdapter(parentArrayList,getActivity());
        homeXml.parentRv.setLayoutManager(new LinearLayoutManager(getContext()));
        homeXml.parentRv.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();


    /*    imgList.add(R.drawable.img1);
        imgList.add(R.drawable.img2);
        imgList.add(R.drawable.img3);
        imgList.add(R.drawable.img4);
        imgList.add(R.drawable.img5);
        imgList.add(R.drawable.img6);*/


        MyViewPageAdaptor myViewPageAdaptor=new MyViewPageAdaptor(getContext(),imgList,homeXml.flipper,homeXml.dotIndicator);
        homeXml.flipper.setAdapter(myViewPageAdaptor);
        homeXml.dotIndicator.attachTo(homeXml.flipper);


        handler=new Handler();
        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int i=homeXml.flipper.getCurrentItem();

                        if (i==imgList.size()-1){
                            i=0;
                            homeXml.flipper.setCurrentItem(i,true);


                        }else {
                            i++;
                            homeXml.flipper.setCurrentItem(i,true);
                            homeXml.dotIndicator.attachTo(homeXml.flipper);

                        }

                    }
                });

            }
        },1000,3000);

        return rootView;
    }
}
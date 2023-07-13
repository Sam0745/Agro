package com.example.agro.ViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.agro.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class MyViewPageAdaptor extends PagerAdapter {

    Context context;
    ArrayList<Integer> arrayList;
    LayoutInflater layoutInflater;
    ViewPager viewPager;
    DotsIndicator dotsIndicator;


    public MyViewPageAdaptor(Context context, ArrayList<Integer> arrayList,ViewPager viewPager,DotsIndicator dotsIndicator) {
        this.context = context;
        this.arrayList = arrayList;
        this.viewPager=viewPager;
        this.dotsIndicator=dotsIndicator;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        View v=layoutInflater.inflate(R.layout.my_viewpager_view,container,false);
        ImageView imageView=v.findViewById(R.id.myViewImage);
        imageView.setImageResource(arrayList.get(position));

        if (position==arrayList.size()-2 && dotsIndicator.getScrollBarSize()==arrayList.size()){


            viewPager.post(runnable);
            dotsIndicator=new DotsIndicator(context);
            dotsIndicator.setScrollBarSize(0);
            dotsIndicator.attachTo(viewPager);

        }
        else if (position==arrayList.size()){
            viewPager.post(runnable);
        }

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            arrayList.addAll(arrayList);
            dotsIndicator.setScrollBarSize(0);
            notifyDataSetChanged();



        }
    };
}

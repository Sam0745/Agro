package com.example.agro.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.agro.Fragments.AddToCartFragment;
import com.example.agro.RecyclerView.CartRecyclerView.CartRecyclerModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SessionManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String shared_preference_Name = "session";
    String session_key = "session_key";
    String Email = "email",firstName="sam",lastName="last",mobile="00000000";


    public SessionManagement(Context context) {

        sharedPreferences = context.getSharedPreferences(shared_preference_Name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void SaveEmail(String email) {

        editor.putString(Email, email).commit();

    }
    public void SaveData(String firstName1,String lastName1,String mobile1){
        editor.putString(firstName,firstName1).commit();
        editor.putString(lastName,lastName1).commit();
        editor.putString(mobile,mobile1).commit();
    }


    public String GetFirstName(){
        return sharedPreferences.getString(firstName,"");
    }
    public String GetLastName(){
        return sharedPreferences.getString(lastName,"");
    }
    public String GetMobileNo(){
        return sharedPreferences.getString(mobile,"");
    }


    public String GetEmail() {

        return sharedPreferences.getString(Email, "");
    }

    public void RemoveEmail() {

        editor.putString(Email, "").commit();
    }


    public void addCartDetails(CartRecyclerModel model) {
        List<CartRecyclerModel> list = getCartDetails();
        list.add(model);
        editor.putString("arrayKey", new Gson().toJson(list));
        editor.apply();

    }

    public ArrayList<CartRecyclerModel> getCartDetails() {

        String d = sharedPreferences.getString("arrayKey", null);

        if (d != null) {
            return new Gson().fromJson(d, new TypeToken<List<CartRecyclerModel>>() {
            }.getType());
        }
        return new ArrayList<>();
    }
    public void Refresh(){


    }

    public void clear(){
        editor.remove("arrayKey").apply();
    }
    public void clearSingleItem(int model){

        List<CartRecyclerModel>list=getCartDetails();
        for (int i =0;i<list.size();i++){
            if (i==model){
                list.remove(i);

                editor.putString("arrayKey",new Gson().toJson(list));
                editor.apply();


            }


        }
    }
}


package com.example.agro.RecyclerView.PlaceOrderRecycler;

public class PlaceOrderRvModel {

    int image;
    String name,rupee;

    public PlaceOrderRvModel(int image, String name, String rupee) {
        this.image = image;
        this.name = name;
        this.rupee = rupee;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRupee() {
        return rupee;
    }

    public void setRupee(String rupee) {
        this.rupee = rupee;
    }
}

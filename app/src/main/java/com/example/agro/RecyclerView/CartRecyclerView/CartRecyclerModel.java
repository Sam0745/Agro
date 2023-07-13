package com.example.agro.RecyclerView.CartRecyclerView;

public class CartRecyclerModel {

    Integer cartImage,rate;
    String name;

    public CartRecyclerModel() {

    }

    public Integer getCartImage() {
        return cartImage;
    }

    public void setCartImage(Integer cartImage) {
        this.cartImage = cartImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate.toString();
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}

package com.example.shoppingcart;
import java.io.Serializable;

/**
 * Java bean class for each item object of the cart
 */
public class ItemBean implements Serializable {
    private int quantity;
    private int price;
    private String name;

    public  String getName(){ return  name;}

    public void setName(String name) {
        this.name= name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity= quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

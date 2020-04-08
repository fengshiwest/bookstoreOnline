package com.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wan Yu on 2020/4/6
 * 购物车
 */
public class Cart {
    private Map<Long, CartItem> map = new HashMap<Long, CartItem>();
    private double totalPrice;

    //添加到购物车
    public void addToCart(Book book) {
        CartItem cartItem = map.get(book.getId());
        if(cartItem == null) {
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setNum(1);
            map.put(book.getId(), cartItem);

        } else {
            cartItem.setNum(cartItem.getNum() + 1);
        }
    }

    //移出购物车
    public void deleteFromCart(Book book) {
        CartItem cartItem = map.get(book.getId());
        if(cartItem.getNum() == 1) {
            map.remove(book.getId());
        } else {
            cartItem.setNum(cartItem.getNum() - 1);
        }
    }

    public Map<Long, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Long, CartItem> map) {
        this.map = map;
    }


    public double getTotalPrice() {
        double price = 0;
        for(Map.Entry<Long, CartItem> map : map.entrySet()){
            CartItem cartItem = map.getValue();
            price = price + cartItem.getPrice();
        }
        this.totalPrice = price;
        return  totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

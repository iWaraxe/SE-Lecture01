package com.coherentsolution.section04;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();
    private double totalPrice = 0.0;

    public void addItem(Item item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Item class for simplicity
    public static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}


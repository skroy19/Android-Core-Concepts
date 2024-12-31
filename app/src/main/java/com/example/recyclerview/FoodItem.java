package com.example.recyclerview;


// this is a dataclass
//How It Works in the RecyclerView Flow
//Step 1: Create a list of FoodItem objects. Each object represents one row in the RecyclerView.
//Step 2: Pass this list to the RecyclerView Adapter.
//Step 3: The Adapter uses this data to bind it to the views (image, name, and price) in the RecyclerView.


public class FoodItem {
    private int imageResId; // Resource ID for the food image
    private String name;    // Name of the food
    private String price;   // Price of the food

    public FoodItem(int imageResId, String name, String price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    // Getter for Image Resource ID
    public int getImageResId() {
        return imageResId;
    }

    // Getter for Food Name
    public String getName() {
        return name;
    }

    // Getter for Price
    public String getPrice() {
        return price;
    }
}

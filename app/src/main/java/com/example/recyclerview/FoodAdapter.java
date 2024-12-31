package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//The RecyclerView.Adapter is generic and expects a ViewHolder class as a type parameter
//Here, FoodAdapter.FoodViewHolder explicitly tells RecyclerView.Adapter to use the nested FoodViewHolder class as its ViewHolder.
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    private List<FoodItem> foodList;

    // Constructor for the Adapter
    public FoodAdapter(List<FoodItem> foodList) {
        this.foodList = foodList;
    }


    @NonNull
    @Override
    //Purpose: Creates a new FoodViewHolder for an item when the RecyclerView needs it.

    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate item layout
        //LayoutInflater.from(parent.getContext()): Gets the context to inflate the layout.
        //inflate(R.layout.food_item, parent, false): Inflates the food_item.xml layout for a single item.
        //Using parent.getContext() ensures the LayoutInflater uses the same context that the parent ViewGroup (RecyclerView) is using

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        // Purpose: Binds data from the foodList to the views in the ViewHolder

        FoodItem foodItem = foodList.get(position);
        holder.foodImage.setImageResource(foodItem.getImageResId());
        holder.foodName.setText(foodItem.getName());
        holder.foodPrice.setText(foodItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return foodList.size(); // Total number of items in the list
    }

    // Inner class for ViewHolder
    //Purpose: Holds references to the views in the item layout (food_item.xml).

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName, foodPrice;

        //constructor
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views
            foodImage = itemView.findViewById(R.id.foodImage);
            foodName = itemView.findViewById(R.id.foodName);
            foodPrice = itemView.findViewById(R.id.foodPrice);
        }
    }
}
